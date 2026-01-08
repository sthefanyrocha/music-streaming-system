package midia;

public class Podcast extends Midia {
    private int episodio;

    public Podcast(String titulo, String artista, double duracao) {
        super(titulo, artista, duracao, null);
    }

    @Override
    public String getDescricao() {
        return "\nTítulo: " + titulo + "\n Ep: " + episodio + "\n Artista: " + artista + "\n Duração: " + duracao;

    }

    public int getEpisodio() {
        return episodio;
    }


}
