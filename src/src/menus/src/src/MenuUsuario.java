package menus;

import java.util.Scanner;

import midia.*;
import usuario.*;

public class MenuUsuario {
    public static void exibirMenuUsuario() {

        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Usuario usuario = null;

        do {
            System.out.println("1 - Cadastrar usuário.");
            System.out.println("2 - Entrar em conta ja existente.");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome de usuario: ");
                    String nomeCadastro = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String emailCadastro = scanner.nextLine().trim();
                    usuario = sistema.cadastrarUsuario(nomeCadastro, emailCadastro);
                    if (usuario != null) {
                        MenuStreaming.exibirMenuStreaming(sistema, usuario);
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeLogin = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String emailLogin = scanner.nextLine().trim();
                    usuario = sistema.acessarUsuario(nomeLogin, emailLogin);
                    if (usuario != null) {
                        MenuStreaming.exibirMenuStreaming(sistema, usuario);
                    }
                    break;
                case 3:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3 && usuario == null);

        scanner.close();
    }

    public static void main(String[] args) {
        MenuUsuario.exibirMenuUsuario();
    }
}
