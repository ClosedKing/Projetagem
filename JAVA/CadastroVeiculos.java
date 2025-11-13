import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    static class Veiculo {
        private String tipo;
        private String marca;
        private String modelo;
        private int ano;
        private double preco;
        private int portas;
        private int cc;

        Veiculo(String tipo, String marca, String modelo, int ano, double preco, int portas, int cc) {
            this.tipo = tipo;
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.preco = preco;
            this.portas = portas;
            this.cc = cc;
        }

        @Override
        public String toString() {
            return String.format("Tipo: %s | Marca: %s | Modelo: %s | Ano: %d | Preço: R$ %.2f | Portas: %d | cc: %d",
                    tipo, marca, modelo, ano, preco, portas, cc);
        }
    }

    public static void main(String[] args) {
        //Já aceitar acentuação e caracteres especiais...
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> lista = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("Quantos veículos deseja cadastrar?");
        System.out.println("(Apenas de 1 até 10)");
        int quant = 0;
        while (true) {
            String q = scanner.nextLine().trim();
            try {
                quant = Integer.parseInt(q);
                if (quant <= 0 || quant > 10) {
                    System.out.println("\n=======================================");
                    System.out.println("Valor inválido. Deve ser entre 1 e 10:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\n===========================================");
                System.out.println("Entrada inválida. Digite um número inteiro:");
            }
        }

        for (int i = 0; i < quant; i++) {
            System.out.println("\n++++++++++++++++++++++++");
            System.out.println("Cadastro do " + (i + 1) + "º veículo:");
            System.out.println("++++++++++++++++++++++++");

            // Valida tipo (M ou C)
            String tipoLeitura;
            while (true) {
                System.out.println("\n=============");
                System.out.println("insira o tipo: \n M = Moto\n C = Carro");
                System.out.println("=============");
                tipoLeitura = scanner.nextLine().trim().toUpperCase();
                if (tipoLeitura.equals("M") || tipoLeitura.equals("C")) {
                    break;
                }
                System.out.println("\nEntrada inválida! Use APENAS 'M' para Moto ou 'C' para Carro.");
            }
            String tipo = tipoLeitura.equals("M") ? "Moto" : "Carro";

            System.out.println("\n================");
            System.out.println("Digite a marca: ");
            String marca = scanner.nextLine().trim();

            System.out.println("\n===============");
            System.out.println("Digite o modelo: ");
            String modelo = scanner.nextLine().trim();

            // Validar ano
            int ano;
            while (true) {
                System.out.println("\n========================");
                System.out.println("Digite o ano do veículo: ");
                String entradaAno = scanner.nextLine().trim();
                try {
                    ano = Integer.parseInt(entradaAno);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\n==============================================================");
                    System.out.println("Entrada inválida. Digite apenas números (ex.: 1966).");
                }
            }

            // Coletar preço do veículo
            double preco;
            while (true) {
                System.out.println("\n=====================================");
                System.out.println("Digite o preço (use ponto para os centavos): ");
                String entradaPreco = scanner.nextLine().trim();
                try {
                    preco = Double.parseDouble(entradaPreco);
                    //Não pode ser menor que zero
                    if (preco < 0) {
                        System.out.println("\n=============================================");
                        System.out.println("Preço inválido. Informe um valor positivo.");
                        continue;
                    }
                    break;
                    //Separado apenas por ponto.
                } catch (NumberFormatException e) {
                    System.out.println("=========================================================");
                    System.out.println("Digite um valor válido (ex.: 49998.52).");
                }
            }

            //Diferenciação se é moto ou carro:
            int portas = 0;
            int cc = 0;
            
            if (tipo.equals("Carro")) {
                while (true) {
                    System.out.println("\n=====================================");
                    System.out.println("Digite o número de portas:");
                    try {
                        String entradaPortas = scanner.nextLine().trim();
                        portas = Integer.parseInt(entradaPortas);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\n============================================");
                        System.out.println("Inválido, digite apenas números.");
                    }
                }
            } else {
                while (true) {
                    System.out.println("\n=====================================");
                    System.out.println("Digite as cilindradas (CC): ");
                    try {
                        String entradaCC = scanner.nextLine().trim();
                        cc = Integer.parseInt(entradaCC);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\n============================================");
                        System.out.println("Inválido, digite apenas números.");
                    }
                }
            }
            lista.add(new Veiculo(tipo, marca, modelo, ano, preco, portas, cc));
            
            System.out.println("\n\n\n----------------------------------");
            System.out.println("Veículo cadastrado com sucesso!!!");
            System.out.println("----------------------------------");
        }
        
        //Perguntar preço para filtro:
        double precoFiltro;
            while (true) {
                System.out.println("\n=====================================");
                System.out.println("Deseja exibir veículos acima de qual valor? \n(use ponto para os centavos): ");
                String filtro = scanner.nextLine().trim();
                try {
                    precoFiltro = Double.parseDouble(filtro);
                    //Não pode ser menor que zero
                    if (precoFiltro < 0) {
                        System.out.println("\n=============================================");
                        System.out.println("Preço inválido. Informe um valor positivo.");
                        continue;
                    }
                    break;
                    //Separado apenas por ponto.
                } catch (NumberFormatException e) {
                    System.out.println("=========================================================");
                    System.out.println("Entrada inválida. Digite um número válido (ex.: 45000.50).");
                }
            }

        // Exibe todos os veículos cadastrados
        System.out.println("\n\n\n<><><><><><><><><><><> VEÍCULOS CADASTRADOS E FILTRADOS <><><><><><><><><><><><><>");
        System.out.printf("%-5s ||%-5s  ||%-10s  ||%-15s  ||%-4s  ||%-13s  ||%-4s\n", "ÍNDICE", "TIPO", "MARCA", "MODELO", "ANO", "PREÇO", "PORTAS/CC");
        int n = 1;
        int esp = 0;
        for (Veiculo v : lista) {
            if (v.preco > precoFiltro){
                System.out.printf("%-5d  ||%-5s  ||%-10s  ||%-15s  ||%-4d  ||R$ %-10.2f  ||%-4d\n",
                    n++,
                    v.tipo,
                    v.marca,
                    v.modelo,
                    v.ano,
                    v.preco,
                    esp = v.tipo.equals("Moto") ? v.cc : v.portas
                    );
            }
        }
        scanner.close();
    }
}