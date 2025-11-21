public abstract class itemBiblioteca {
    private long id;
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;
    private boolean emprestado;

    //Construtor com parâmetros, define os itens iniciais do objeto.
    public itemBiblioteca(long id, String isbn, String titulo, String autor, int ano, String categoria, boolean emprestado) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.categoria = categoria;
        this.emprestado = emprestado;
    };

    public Long getId() {
        return id;
    };
    public String getIsbn() {
        return isbn;
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
    public boolean getEmprestado() {
        return emprestado;
    }

    // Todos devem ser não nulo, verificar outras regras e negócio...
    public void setId(long id) {
        // não pode ter outro igual, gerado automaticamente
        this.id = id;
    };
    public void setIsbn(String isbn) {
        //Não pode ter igual
        this.isbn = isbn;
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
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    };

    public String toString() {
        return "\n ISBN: " + isbn + "\nTÍTULO: "+ titulo +"\nAUTOR: " + autor + "\nANO: " + ano +"\nCATEGORIA: " + categoria + "\nEMPRESTADO: " + (emprestado ? "Sim" : "Não");
    }

}