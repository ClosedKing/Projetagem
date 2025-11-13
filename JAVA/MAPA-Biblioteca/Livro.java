public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;

    //Construtor com parâmetros, define os itens iniciais do objeto.
    public Livro(long id, String titulo, String autor, int ano, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.categoria = categoria;
    };

    public String getTitulo() {
        return titulo;
    };
    public String getAutor() {
        return autor;
    };
    public int getAno() {
        return ano;
    };
    public String getCategoria() {
        return categoria;
    };

    // Todos devem ser não nulo, verificar outras regrasd e negócio...
    public void setId(long id) {// Isso é o isbn???
        // não pode ter outro igual, gerado automaticamente
        this.id = id;
    };
    public void setTitulo(String titulo) {
        // Não repete
        this.titulo = titulo;
    };
    public void setAutor(String autor) {
        this.autor = autor;
    };
    public void setAno(int ano) {
        // Valor positivo e não pode ser ano futuro
        this.ano = ano;
    };
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    };

    public String toString() {
        return "Livro cadastrado é: "+ titulo;
    }

}