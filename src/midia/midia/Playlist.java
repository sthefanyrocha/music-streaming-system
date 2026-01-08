package midia;

import java.util.ArrayList;

import exceptions.MidiaNaoEncontradaException;
import usuario.*;

public class Playlist {
    private String nome;
    private ArrayList<Midia> midias;
    private Usuario donoUsuario;

    public Playlist(String nome, Usuario donoUsuario) {
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Usuario getDonoUsuario() {
        return donoUsuario;
    }

    public ArrayList<Midia> getMidias() {
        return midias;
    }

    public void adicionarMidia(Midia m) {
        midias.add(m);
    }

    public void removerMidia(Midia m) throws MidiaNaoEncontradaException {
        if (!midias.remove(m)) {
            throw new MidiaNaoEncontradaException("Mídia não encontrada na playlist.");
        }
    }

    public double duracaoTotal() {
        double total = 0;
        for (Midia m : midias) {
            total += m.getDuracao();
        }
        return total;
    }

    public void listarTitulos() {
        for (Midia m : midias) {
            System.out.println(m.getTitulo());
        }
    }

    public Midia buscarMidia(String titulo) throws Exception {
        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        throw new Exception("Mídia não encontrada na playlist.");
    }

    public int contarMidiasPorGenero(Genero g) {
        int count = 0;
        for (Midia m : midias) {
            if (m.getGenero() == g) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Playlist: " + nome + "\n");
        for (Midia m : midias) {
            sb.append(" - ").append(m.getDescricao()).append("\n"); // Altere aqui
        }
        sb.append(String.format("Duração total: %.2f min", duracaoTotal()));
        return sb.toString();
    }
}
