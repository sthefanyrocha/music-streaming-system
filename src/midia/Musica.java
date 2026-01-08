package midia;

public class Musica extends Midia {

    public Musica(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    @Override
    public String getDescricao() {
        return "\nMúsica: " + titulo + "\n Artista: " + artista + "\n Duração: " + duracao + "\n Gênero: " + genero;
    }


}
