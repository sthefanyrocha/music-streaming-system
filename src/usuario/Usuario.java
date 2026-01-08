package usuario;

import java.util.ArrayList;

import midia.*;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Playlist> playlists;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean verificar(String nome, String email) {
        return this.nome.equals(nome) && this.email.equals(email);

    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome, this));
    }

    public Playlist buscarPlaylist(String nome) throws Exception {
        for (Playlist p : playlists) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        throw new Exception("Playlist não encontrada.");
    }

    public void removerPlaylist(String nome) throws Exception {
        Playlist p = buscarPlaylist(nome);
        playlists.remove(p);
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
            return;
        }
        for (Playlist p : playlists) {
            System.out.println(p.getNome() + " (" + p.duracaoTotal() + " min)");
        }
    }

    public Playlist playlistMaisLonga() {
        Playlist maisLonga = null;
        double maiorDuracao = 0;
        for (Playlist p : playlists) {
            if (p.duracaoTotal() > maiorDuracao) {
                maiorDuracao = p.duracaoTotal();
                maisLonga = p;
            }
        }
        return maisLonga;
    }

    public void adicionarMidiaEmPlaylist(String nomePlaylist, Midia m) throws Exception {
        Playlist p = buscarPlaylist(nomePlaylist);
        p.adicionarMidia(m);
    }

    public void removerMidiaDePlaylist(String nomePlaylist, Midia m) throws Exception {
        Playlist p = buscarPlaylist(nomePlaylist);
        p.removerMidia(m);
    }
}
