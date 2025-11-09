import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Biblioteca {
    public static void main(String[] args) {
        int escolha = 0;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("-=-=-BEM-VINDO A BIBLIOTECA 'LIVROTECA'=-=-=");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("\n\nFavor escolher uma das opções abaixo:");
            System.out.println(
                    "\n1- Cadastrar livro \n2- Alterar livro (por ID ou ISBN) \n3- Pesquisar livro (por título/autor/ISBN) \n4- Excluir \n5- livroListar \n6- acervoEmprestar \n7- livroDevolver livro \n8- Sair");
            System.out.println("============================================");

            escolha = Integer.parseInt(scanner.nextLine().trim());
            // String nome = scanner.nextLine(); // Lê a linha inteira digitada pelo usuário

            switch (escolha) {
                case 1:
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
                        break;
                    }

                    System.out.println("ótimo, e qual o título do livro?");
                    String titulo = scanner.nextLine();

                    System.out.println("Perfeito, e qual é o autor?");
                    String autor = scanner.nextLine();

                    System.out.println("Favor informe o ano, apenas os números:");
                    int ano;
                    try {
                        ano = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido. Cadastro abortado.");
                        break;
                    }

                    System.out.println("Por último, informe a categoria do livro:");
                    String categoria = scanner.nextLine();

                    Livro livro1 = new Livro(id, titulo, autor, ano, categoria);

                    System.out.println(" Livro inserido com sucesso: " + livro1.getTitulo());

                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 4:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 5:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 6:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 7:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;
                case 8:
                    for (int i = 0; i < 30; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("============================================");
                    break;

                default:
                    System.out.println("Opção inválida, favor digite apenas o número dentre os fornecidos");
                    break;
            }

        } while (escolha != 8);
        // Gambiarra para limpar o console
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
        scanner.close(); // Fecha o scanner para evitar vazamento de recursos
        System.out.println("Obrigado por utilizar a LIVROTECA, até a próxima!");
    }

}