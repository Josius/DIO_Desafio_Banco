public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public void sacar(double valor) {
        //valor>0 para evitar aumentar o valor da conta com vlrs negativos
        //saldo-vlr<0 para não sacar vlrs negativos
        if(valor>0){
            if((saldo-valor) < 0){
                System.out.println("Saldo insuficiente");
            }else saldo -= valor;
        }else System.out.println("Valor para saque incorreto");
    }

    @Override
    public void depositar(double valor) {
        //valor>0 para evitar aumentar o valor da conta com vlrs negativos
        if(valor>0){
            saldo += valor;
        }else System.out.println("Valor para deposito incorreto");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        //valor>0 para evitar aumentar o valor da conta com vlrs negativos
        //saldo-vlr<0 para não sacar vlrs negativos
        if(valor>0){
            if((saldo-valor) < 0){
                System.out.println("Saldo insuficiente para transferencia");
            }else {
                this.sacar(valor);
                contaDestino.depositar(valor);
            }
        }else System.out.println("Valor para transferencia incorreto");
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void dadosCliente() {
        System.out.println(cliente.toString());
    }

    public Cliente getCliente() {
        return cliente;
    }
}
