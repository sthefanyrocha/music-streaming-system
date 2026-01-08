package midia;

import java.util.Scanner;

import usuario.Usuario;

import java.util.HashMap;

public class Sistema {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Catalogo catalogo = new Catalogo();
  
    {
        catalogo.adicionarMidia(new Musica("505", "Arctic Monkeys", 3.1, Genero.ROCK));
        catalogo.adicionarMidia(new Musica("Die For You", "The Weeknd", 5.5, Genero.POP));
        catalogo.adicionarMidia(new Podcast("Pod Delas", "Tata Cocielo", 40.0));
        catalogo.adicionarMidia(new Audiobook("Harry Potter", "J.K. Rowling", 600.0, 16));
    }

    public Usuario cadastrarUsuario(String nome, String email) {
        if (!usuarios.containsKey(email)) {
            Usuario novo = new Usuario(nome, email);
            usuarios.put(email, novo);
            System.out.println("Usuário cadastrado com sucesso!");
            return novo;
        } else {
            System.out.println("Email já cadastrado. Use outro email.");
            return null;
        }
    }

    public Usuario acessarUsuario(String nome, String email) {
        Usuario u = usuarios.get(email);
        if (u != null && u.verificar(nome, email)) {
            System.out.println("Bem-vindo, " + nome);
            return u;
        }
        System.out.println("Email não encontrado ou nome incorreto.");
        return null;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}
