package menus;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.MidiaNaoEncontradaException;
import midia.*;
import usuario.*;

public class MenuStreaming {
    public static void exibirMenuStreaming(Sistema sistema, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        Catalogo catalogo = sistema.getCatalogo();

        int opcao = -1;

        while (opcao != 8) {

            System.out.println("1 - Criar playlist");
            System.out.println("2 - Adicionar mídia à playlist");
            System.out.println("3 - Remover mídia da playlist");
            System.out.println("4 - Listar playlists do usuário");
            System.out.println("5 - Buscar playlist");
            System.out.println("6 - Buscar mídia no catálogo");
            System.out.println("7 - Listar catálogo completo");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome da playlist: ");
                        String nomeP = sc.nextLine();
                        usuario.criarPlaylist(nomeP);
                        System.out.println("Playlist criada!");
                        break;

                    case 2:
                        System.out.print("Nome da playlist: ");
                        String plAdd = sc.nextLine();
                        System.out.print("Título da mídia: ");
                        String titAdd = sc.nextLine();
                        ArrayList<Midia> mediasAdd = catalogo.buscarPorTitulo(titAdd);
                        if (mediasAdd.isEmpty()) {
                            System.out.println("Mídia não encontrada no catálogo.");
                        } else {
                            usuario.adicionarMidiaEmPlaylist(plAdd, mediasAdd.get(0));
                            System.out.println("Mídia adicionada à playlist!");
                        }
                        break;

                    case 3:
                        System.out.print("Nome da playlist: ");
                        String plRem = sc.nextLine();
                        System.out.print("Título da mídia: ");
                        String titRem = sc.nextLine();
                        ArrayList<Midia> mediasRem = catalogo.buscarPorTitulo(titRem);
                        if (mediasRem.isEmpty()) {
                            System.out.println("Mídia não encontrada no catálogo.");
                        } else {
                            usuario.removerMidiaDePlaylist(plRem, mediasRem.get(0));
                            System.out.println("Mídia removida da playlist!");
                        }
                        break;

                    case 4:
                        usuario.listarPlaylists();
                        break;
                    case 5:
                        System.out.print("Nome da playlist: ");
                        String plView = sc.nextLine();
                        Playlist p = usuario.buscarPlaylist(plView);
                        System.out.println(p);
                        break;
                    case 6:
                        System.out.print("Digite o título da mídia: ");
                        String titSearch = sc.nextLine();
                        ArrayList<Midia> resultado = catalogo.buscarPorTitulo(titSearch);
                        if (resultado.isEmpty()) {
                            System.out.println("Nenhuma mídia encontrada.");
                        } else {
                            System.out.println("Mídias encontradas:");
                            for (Midia m : resultado) System.out.println(m);
                        }
                        break;
                    case 7:
                        catalogo.listarTodos();
                        break;
                    case 8:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (MidiaNaoEncontradaException e) {
                System.out.println("Erro ao remover: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        }

        sc.close();
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

    }
}
