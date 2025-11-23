import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livro extends itemBiblioteca {
    private double multa;
    private LocalDate dataEmprestimo;

    public Livro(long id, String isbn, String titulo, String autor, int ano, String categoria, LocalDate dataEmprestimo,
            double multa) {
        super(id, isbn, titulo, autor, ano, categoria, false);
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public double calcularMulta() {
        if (dataEmprestimo == null) {
            return 0.0;
        }

        long diasEmprestado = ChronoUnit.DAYS.between(dataEmprestimo, LocalDate.now());

        // Se passou mais de 10 dias, cobra R$ 5 por dia de atraso
        if (diasEmprestado > 10) {
            return (diasEmprestado - 10) * 5.0;
        }

        return 0.0;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}