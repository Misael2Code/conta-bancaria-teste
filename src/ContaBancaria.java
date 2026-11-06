public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double limiteAutorizadoChequeEspecial;
    private double taxaJurosChequeEspecial = 0.2;

    public double consultarSaldo() {
        System.out.println("------------------------------------------");
        System.out.printf("(=) Saldo atual: R$ %.2f%n", this.saldo);
        System.out.println("------------------------------------------");
        return this.saldo;
    }

    public double consultarChequeEspecial() {
        System.out.println("------------------------------------------");
        System.out.printf("(=) Limite do cheque especial: R$ %.2f%n", this.limiteChequeEspecial);
        System.out.println("------------------------------------------");
        return this.limiteChequeEspecial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            double juros = calcularJurosChequeEspecial();

            if(this.saldo < 0 && valor > (juros + Math.abs(this.saldo))) {
                this.limiteChequeEspecial = this.limiteAutorizadoChequeEspecial;
            }

            this.saldo += valor - juros;

            System.out.printf("\n(+) Depósito de R$ %.2f realizado com sucesso.", valor);
            if(juros > 0.0) {
                System.out.printf("\n(-) Juros do cheque especial: R$ %.2f.", juros);
            }
            System.out.println("\n------------------------------------------");
            System.out.printf("(=) Saldo atual: R$ %.2f.\n", this.saldo);
            System.out.println("------------------------------------------");
        }
    }

    public void criarContaBancaria(double saldoInicial) {
        double chequeEspecial = 0.0;

        if (saldoInicial <= 500) {
            chequeEspecial = 150;
        } else {
            chequeEspecial = saldoInicial * 0.5;
        }

        this.saldo = saldoInicial;
        this.limiteChequeEspecial = chequeEspecial;
        this.limiteAutorizadoChequeEspecial = chequeEspecial;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo + this.limiteChequeEspecial) {
            this.limiteChequeEspecial = valor > this.saldo ? this.limiteChequeEspecial - (valor - this.saldo)
                    : this.limiteChequeEspecial;
            this.saldo -= valor;            
            System.out.printf("\n(-) Saque de R$ %.2f realizado com sucesso.", valor);
            if(this.saldo < 0) {
                System.out.printf("\n* Você está usando o cheque especial. Limite restante: R$ %.2f.", this.limiteChequeEspecial);
            }
            System.out.println("\n------------------------------------------");
            System.out.printf("(=) Saldo atual: R$ %.2f.\n", this.saldo);
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void pagarBoleto(double valor) {
        if (valor > 0 && valor <= this.saldo + this.limiteChequeEspecial) {
            this.limiteChequeEspecial = valor > this.saldo ? this.limiteChequeEspecial - (valor - this.saldo)
                    : this.limiteChequeEspecial;
            this.saldo -= valor;

            System.out.printf("\n(-) Pagamento de boleto de R$ %.2f realizado com sucesso.", valor);
            
            if(this.saldo < 0) {
                System.out.printf("\n* Você está usando o cheque especial. Limite restante: R$ %.2f.", this.limiteChequeEspecial);
            }
            System.out.println("\n------------------------------------------");
            System.out.printf("(=) Saldo atual: R$ %.2f.\n", this.saldo);
            System.out.println("------------------------------------------");
        } else {
            System.out.println("* Saldo insuficiente para pagamento de boleto.");
        }
    }

    public boolean estaUsandoChequeEspecial() {
        return this.saldo < 0;
    }

    public double calcularJurosChequeEspecial() {
        if (estaUsandoChequeEspecial()) {
            return -this.saldo * this.taxaJurosChequeEspecial;
        }
        return 0;
    }
}
