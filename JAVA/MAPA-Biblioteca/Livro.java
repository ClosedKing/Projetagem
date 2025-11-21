
//Extender essa classe, chamar de item biblioteca.
//Fazer abtract 
public class Livro extends itemBiblioteca {
    private double multa;

    public Livro(long id, String isbn, String titulo, String autor, int ano, String categoria, boolean emprestado, double multa) {
        super(id, isbn, titulo, autor, ano, categoria, emprestado);
        this.multa = multa;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

}