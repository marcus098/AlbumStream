public class Author {
    private String nome;

    public Author(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
