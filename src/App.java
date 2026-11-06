import java.util.Scanner;

public class App {
    private static ContaBancaria conta = new ContaBancaria();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        if (iniciarAplicacao(scanner)) {

            criarContaBancaria(scanner);

            while (sair == false) {
                exibirMenu();

                int opcao = scanner.nextInt();
                menuSelecionado(opcao, scanner);

                if(opcao > 0) {
                    System.out.println("\nDigite \"1\" para voltar ao menu principal ou \"0\" para sair.");
                }
                
                if (opcao == 0 || scanner.nextInt() == 0) {
                    sair = true;
                    break;
                }
            }            
            scanner.close();
        }

    }

    public static void menuSelecionado(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                conta.consultarSaldo();
                break;
            case 2:
                conta.consultarChequeEspecial();
                break;
            case 3:
                depositarDinheiro(scanner);
                break;
            case 4:
                sacarDinheiro(scanner);
                break;
            case 5:
                pagarBoleto(scanner);
                break;
            case 6:
                estaUsandoChequeEspecial();
                break;
            case 0:
                System.out.println("Saindo da aplicação...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }

    public static void depositarDinheiro(Scanner scanner) {
        System.out.println("=> Digite o valor a ser depositado:");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
    }

    public static void sacarDinheiro(Scanner scanner) {
        System.out.println("=> Digite o valor a ser sacado:");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
    }

    public static void pagarBoleto(Scanner scanner) {
        System.out.println("=> Digite o valor do boleto a ser pago:");
        double valor = scanner.nextDouble();
        conta.pagarBoleto(valor);
    }

    public static void estaUsandoChequeEspecial() {
        if (conta.estaUsandoChequeEspecial()) {
            System.out.println("* Você está usando o cheque especial.");
            conta.consultarChequeEspecial();

            conta.consultarSaldo();
        } else {
            System.out.println("* Você não está usando o cheque especial.");
        }
    }

    public static void criarContaBancaria(Scanner scanner) {
        double limiteChequeEspecial = 0.0;
        double saldoInicial = 0.0;

        System.out.println("[ Bem-vindo! Vamos criar sua conta bancária ]");

        System.out.println("=> Digite o saldo inicial da conta:");

        saldoInicial = scanner.nextDouble();

        if (saldoInicial <= 0) {
            System.out.println("Saldo inicial não pode ser igual ou menor que 0. Por favor, digite um valor válido.");
            criarContaBancaria(scanner);
        }

        conta.criarContaBancaria(saldoInicial);

        System.out.println("Conta criada com sucesso! ");
        System.out.printf("Conta criada com sucesso! \nSaldo inicial: R$ %.2f, Limite do cheque especial: R$ %.2f%n",
                saldoInicial, limiteChequeEspecial);
    }

    public static void exibirMenu() {
        System.out.println("\nDigite o número para o menu desejado:");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Consultar Cheque Especial");
        System.out.println("3 - Depositar Dinheiro");
        System.out.println("4 - Sacar Dinheiro");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Verificar se Estou Usando Cheque Especial");
        System.out.println("0 - Sair");
    }

    public static boolean iniciarAplicacao(Scanner scanner) {
        System.out.println("=============================================================================");
        System.out.println("== Olá! Bem-vindo à conta bancária do teste do Bootcamp Itaú - Java com IA ==");
        System.out.println("=============================================================================");

        System.out.println("=> Digite \"I\" para iniciar a aplicação ou \"S\" para sair.");

        String opcao = scanner.nextLine().toUpperCase();

        if (opcao.equals("I")) {
            System.out.println("=> Aplicação iniciada!\n");
        } else if (opcao.equals("S")) {
            System.out.println("=> Saindo da aplicação...\n");
            return false;
        } else {
            System.out.println("=> Opção inválida. Por favor, digite \"I\" para iniciar ou \"S\" para sair.");
            iniciarAplicacao(scanner);
        }

        return true;
    }
}
