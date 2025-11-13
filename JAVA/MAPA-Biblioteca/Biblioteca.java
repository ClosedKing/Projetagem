import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Biblioteca {
    private static List<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {

        int escolha = 0;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("-=-=-BEM-VINDO A BIBLIOTECA 'LIVROTECA'=-=-=");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("\n\nFavor escolher uma das opções abaixo:");
            System.out.println(
                    "\n1- Cadastrar livro \n2- Alterar livro (por ID ou ISBN) \n3- Pesquisar livro (por título/autor/ISBN) \n4- Excluir \n5- Listar Livros \n6- Pegar Emprestado \n7- Devolver Livro \n8- Sair");
            System.out.println("============================================");

            escolha = Integer.parseInt(scanner.nextLine().trim());
            // String nome = scanner.nextLine(); // Lê a linha inteira digitada pelo usuário

            switch (escolha) {
                case 1:
                    CadastrarLivro();
                    break;
                case 2:
                    AlterarLivro();
                    break;
                case 3:
                    PesquisarLivro();
                    break;
                case 4:
                    ExcluirLivro();
                    break;
                case 5:
                    ListarLivro();
                    break;
                case 6:
                    EmprestarLivro();
                    break;
                case 7:
                    DevolverLivro();
                    break;
                case 8:
                    // Gambiarra para limpar o console
                    for (int i = 0; i < 50; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("Obrigado por utilizar a LIVROTECA, até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida, favor digite apenas o número dentre os fornecidos");
                    break;
            }

        } while (escolha != 8);
        scanner.close();// Fechamento do scanner para evitar vazamentos.
    } // Encerramento classe principal.

    private static void CadastrarLivro() { // 1
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }

        System.out.println("============================================");
        System.out.println("Vamos prosseguir para o cadastro, favor insira abaixo o ISBN do livro:");
        long id;
        try {
            id = Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ISBN inválido. Cadastro abortado.");
            scanner.close();
            return;
        }

        System.out.println("ótimo, e qual o título do livro?");
        String titulo = scanner.nextLine();

        System.out.println("Perfeito, e qual é o autor?");
        String autor = scanner.nextLine();

        // Validar ano
        int ano;
        while (true) {
            System.out.println("\n========================");
            System.out.println("Favor informe o ano, apenas os números:");
            String entradaAno = scanner.nextLine().trim();
            try {
                ano = Integer.parseInt(entradaAno);
                break;
            } catch (NumberFormatException e) {
                System.out.println("\n======================================================");
                System.out.println("Entrada inválida. Digite apenas números (ex.: 1966).");
            }
        }

        System.out.println("Por último, informe a categoria do livro:");
        String categoria = scanner.nextLine();

        Livro novoLivro = new Livro(id, titulo, autor, ano, categoria);
        livros.add(novoLivro);

        System.out.println(" Livro: " + novoLivro.getTitulo() +" inserido com sucesso!");

        scanner.close();
    }

    private static void AlterarLivro() { // 2

        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
        System.out.println("============================================");
    }

    private static void PesquisarLivro() { // 3
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Insira o título do lvro que deseja bsucar: ");
        String tituloBusca = scanner.nextLine();
        for (Livro l : livros){
            if (l.getTitulo().equalsIgnoreCase(tituloBusca)){
                System.out.println("Livro pesqusiado é o: " + l);
            }
        }
        scanner.close();
    }

    private static void ExcluirLivro() { // 4
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        scanner.close();
    }

    private static void ListarLivro() { // 5
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados no momento...");
        } else {
            System.out.println("================++=================");
            for (Livro l : livros) {
                System.out.println(l);
            }
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }
    }

    private static void EmprestarLivro() {// 6
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        scanner.close();
    }

    private static void DevolverLivro() {// 7
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        scanner.close();
    }
}