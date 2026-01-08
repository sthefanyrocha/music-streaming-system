package midia;

public class Audiobook extends Midia {
    private int capitulos;

    public Audiobook(String titulo, String artista, double duracao, int capitulos) {
        super(titulo, artista, duracao, null);
        this.capitulos = capitulos;
    }

    @Override
    public String getDescricao() {
        return "\nTítulo: " + titulo + "\n Capítulos: " + capitulos + "\n Artista: " + artista + "\n Duração: " + duracao;

    }

}
