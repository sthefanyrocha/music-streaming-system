package midia;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Midia> midias;

    public Catalogo() {
        this.midias = new ArrayList<Midia>();
    }

    public void adicionarMidia(Midia m) {
        midias.add(m);
    }

    public void removerMidia(Midia m) throws Exception {
        if (!midias.remove(m)) {
            throw new Exception("Mídia não encontrada no catálogo.");
        }
    }

    public ArrayList<Midia> buscarPorTitulo(String titulo) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) resultado.add(m);
        }
        return resultado;
    }

    public ArrayList<Midia> buscarPorArtista(String artista) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getArtista().equalsIgnoreCase(artista)) resultado.add(m);
        }
        return resultado;
    }

    public ArrayList<Midia> buscarPorGenero(Genero genero) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getGenero() == genero) resultado.add(m);
        }
        return resultado;
    }

    public ArrayList<Midia> buscarPorArtistaEGenero(String artista, Genero genero) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getArtista().equalsIgnoreCase(artista) && m.getGenero() == genero) resultado.add(m);
        }
        return resultado;
    }

    public void listarTodos() {
        if (midias.isEmpty()) {
            System.out.println("Catálogo vazio.");
            return;
        }
        for (Midia m : midias) System.out.println(m.getDescricao());
    }
}
