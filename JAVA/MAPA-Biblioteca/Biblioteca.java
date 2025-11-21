
//Acho que falta só ver a questão de calculo da multa, fazer opção de excluir e revisar itens e menus...


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.nio.charset.StandardCharsets;

public class Biblioteca {
    private static List<Livro> livros = new ArrayList<>();
    private static final AtomicLong nextId = new AtomicLong(1);

    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    public static void main(String[] args) {

        int escolha = 0;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        do {
            System.out.println("\n\n\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"); 
            System.out.println("-=-=-BEM-VINDO A BIBLIOTECA 'LIVROTECA'=-=-=");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("\n\nFavor escolher uma das opções abaixo:");
            System.out.println(
                    "\n1- Cadastrar livro \n2- Alterar livro (por ID ou ISBN) \n3- Pesquisar livro (por título/autor/ISBN) \n4- Excluir \n5- Listar Livros \n6- Pegar Emprestado \n7- Devolver Livro \n8- Sair");
            System.out.println("============================================");

            escolha = Integer.parseInt(scanner.nextLine().trim());
            
            switch (escolha) {
                case 1:
                    CadastrarLivro();
                    break;
                case 2:
                    AlterarLivro();
                    break;
                case 3:
                    int op = 0;
                    while (true) {
                        System.out.println("\n\n\n=-=-=-=-=-=-=-=-=-=\n");
                        System.out.println("Deseja buscar livros por:\n");
                        System.out.println("1 - TÍTULO.\n");
                        System.out.println("2 - AUTOR.\n");
                        System.out.println("3 - ISBN.\n");
                        System.out.println("=-=-=-=-=-=-=-=-=-=\n");
                        try {
                            op = Integer.parseInt(scanner.nextLine().trim());
                            // Verifica se a opção é 1, 2 ou 3
                            if (op >= 1 && op <= 3) {
                                break; // Sai do loop se a opção for válida
                            } else {
                                System.out.println("\n======================================================");
                                System.out.println("Opção inválida. Deve ser 1, 2 ou 3. Escolha novamente... ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n======================================================");
                            System.out.println("Entrada inválida. Digite apenas 1, 2 ou 3. Escolha novamente... ");
                        }
                    }
                    PesquisarLivro(op);
                    break;
                case 4:
                    ExcluirLivro();
                    break;
                case 5:
                    int x = 0;
                    while (true) {
                        System.out.println("\n\n\n=-=-=-=-=-=-=-=-=-=\n");
                        System.out.println("1 - Livros DISPONÍVEIS.\n");
                        System.out.println("2 - Livros EMPRESTADOS.\n");
                        System.out.println("=-=-=-=-=-=-=-=-=-=\n");
                        try {
                            x = Integer.parseInt(scanner.nextLine().trim());
                            // Verifica se a opção é 0 ou 1
                            if (x == 1 || x == 2) {
                                break; // Sai do loop se a opção for válida
                            } else {
                                System.out.println("\n======================================================");
                                System.out.println("Opção inválida. Deve ser 1 ou 2. Escolha novamente... ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n======================================================");
                            System.out.println("Entrada inválida. Digite apenas 1 ou 2. Escolha novamente... ");
                        }
                    }
                    ListarLivro(x);
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
                    System.out.println("Obrigado por utilizar a LIVROTECA, até a próxima!\n");
                    break;
                default:
                    System.out.println("Opção inválida, favor digite apenas o número dentre os fornecidos");
                    break;
            }

        } while (escolha != 8);
        scanner.close();// Fechamento do scanner.
    } // Encerramento classe principal.1

    private static void CadastrarLivro() { // 1
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }

        // gerar ID:
        long id = nextId.getAndIncrement();

        System.out.println("============================================");
        System.out.println("Vamos prosseguir para o cadastro, favor insira abaixo o ISBN do livro:");
        String isbn = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("ótimo, e qual o título do livro?");
        String titulo = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("Perfeito, e qual é o autor?");
        String autor = scanner.nextLine();

        // Validar ano
        int ano;
        while (true) {
            System.out.println("\n========================================");
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

        System.out.println("\n========================================");
        System.out.println("Por último, informe a categoria do livro:");
        String categoria = scanner.nextLine();
        boolean emprestado = false; // Sempre cadastra como disponível.
        double multa = 0.0; //Inicia sem multa.

        Livro novoLivro = new Livro(id, isbn, titulo, autor, ano, categoria, emprestado, multa);
        livros.add(novoLivro);

        System.out.println(" Livro: " + novoLivro.getTitulo() + " inserido com sucesso!");
    }

    private static void AlterarLivro() { // 2 ID ou ISBN

        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
        System.out.println("============================================");
    }

    private static void PesquisarLivro(int op) { // 3 por título/autor/ISBN
for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
        
        System.out.println("============================================");
        System.out.println("PESQUISAR LIVRO");
        System.out.println("============================================");
        
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados no momento...");
            return;
        }
        
        String termoBusca;
        boolean encontrado = false;
        
        switch (op) {
            case 1: // Pesquisar por TÍTULO
                System.out.println("Informe o TÍTULO do livro que deseja buscar:");
                termoBusca = scanner.nextLine().trim();
                System.out.println("======================================================\n");
                
                for (Livro l : livros) {
                    if (l.getTitulo().equalsIgnoreCase(termoBusca)) {
                        System.out.println("Livro encontrado com sucesso:");
                        System.out.println(l);
                        System.out.println("======================================================");
                        encontrado = true;
                    }
                }
                break;
                
            case 2: // Pesquisar por AUTOR
                System.out.println("Informe o AUTOR do livro que deseja buscar:");
                termoBusca = scanner.nextLine().trim();
                System.out.println("======================================================\n");
                
                for (Livro l : livros) {
                    if (l.getAutor().equalsIgnoreCase(termoBusca)) {
                        System.out.println("Livro encontrado com sucesso:");
                        System.out.println(l);
                        System.out.println("======================================================");
                        encontrado = true;
                    }
                }
                break;
                
            case 3: // Pesquisar por ISBN
                System.out.println("Informe o ISBN do livro que deseja buscar:");
                termoBusca = scanner.nextLine().trim();
                System.out.println("======================================================\n");
                
                for (Livro l : livros) {
                    if (l.getIsbn().equalsIgnoreCase(termoBusca)) {
                        System.out.println("Livro encontrado com sucesso:");
                        System.out.println(l);
                        System.out.println("======================================================");
                        encontrado = true;
                        break;
                    }
                }
                break;
        }
        
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o critério informado!");
            System.out.println("======================================================");
        }
    }

    private static void ExcluirLivro() { // 4

    }

    private static void ListarLivro(int x) { // 5 
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados no momento...");
        } else {
            int c = 1;
            if (x == 1) {
                for (Livro l : livros) {
                    if (l.getEmprestado() == false) {
                        System.out.println("================++=================");
                        System.out.println("Livro Nro: " + c);
                        System.out.println(l);
                        c++;
                    }
                }
                System.out.println("+++++++++++++++++++++++++++++++++++");
            } else {
                for (Livro l : livros) {
                    if (l.getEmprestado() == true) {
                        System.out.println("================++=================");
                        System.out.println("Livro Nro: " + c);
                        System.out.println(l);
                        c++;
                    }
                }
                System.out.println("+++++++++++++++++++++++++++++++++++");
            }

        }
    }

    private static void EmprestarLivro() {// 6
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
        
        System.out.println("============================================");
        System.out.println("EMPRESTAR LIVRO");
        System.out.println("============================================");
        
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados no momento...");
            return;
        }
        
        System.out.println("Informe o ISBN do livro que deseja emprestar:");
        String isbnBusca = scanner.nextLine().trim();
        
        boolean encontrado = false;
        for (Livro l : livros) {
            if (l.getIsbn().equalsIgnoreCase(isbnBusca)) {
                encontrado = true;
                
                if (l.getEmprestado()) {
                    System.out.println("\n======================================================");
                    System.out.println("Este livro já foi emprestado e ainda não foi devolvido!");
                    System.out.println("Título: " + l.getTitulo());
                    System.out.println("======================================================");
                } else {
                    l.setEmprestado(true);
                    System.out.println("\n======================================================");
                    System.out.println("Livro emprestado com sucesso!");
                    System.out.println("Título: " + l.getTitulo());
                    System.out.println("Autor: " + l.getAutor());
                    System.out.println("======================================================");
                }
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("\n======================================================");
            System.out.println("Livro não encontrado com o ISBN informado!");
            System.out.println("======================================================");
        }
    }

        private static void DevolverLivro() {// 7
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
        
        System.out.println("============================================");
        System.out.println("DEVOLVER LIVRO");
        System.out.println("============================================");
        
        if (livros.isEmpty()) {
            System.out.println("Não existem livros cadastrados no momento...");
            return;
        }
        
        System.out.println("Informe o ISBN do livro que deseja devolver:");
        String isbnBusca = scanner.nextLine().trim();
        
        boolean encontrado = false;
        for (Livro l : livros) {
            if (l.getIsbn().equalsIgnoreCase(isbnBusca)) {
                encontrado = true;
                
                if (!l.getEmprestado()) {
                    System.out.println("\n======================================================");
                    System.out.println("Este livro não estava emprestado!");
                    System.out.println("Título: " + l.getTitulo());
                    System.out.println("======================================================");
                } else {
                    l.setEmprestado(false);
                    System.out.println("\n======================================================");
                    System.out.println("Livro devolvido com sucesso!");
                    System.out.println("Título: " + l.getTitulo());
                    System.out.println("Autor: " + l.getAutor());
                    System.out.println("======================================================");
                }
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("\n======================================================");
            System.out.println("Livro não encontrado com o ISBN informado!");
            System.out.println("======================================================");
        }
    }
}