import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cliente josildus = new Cliente("Josiiulgsudus", "4S2.89E.585-SI", "Rua Estratuvarius, 687 - Sum Paulo - SP");

        Conta cc = new ContaCorrente(josildus);
        Conta cp = new ContaPoupanca(josildus);

        cc.depositar(100);
        cc.imprimirExtrato();
        cc.sacar(101);
        cc.sacar(-1);
        cc.depositar(-1);
        cc.transferir(-1, cp);
        cc.transferir(53, cp);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cp.dadosCliente();

        List<Conta> contas = new ArrayList<>();
        contas.add(cc);
        contas.add(cp);
        Banco banco = new Banco();
        for(int i = 0; i < 10; i++){
            contas.add(new ContaPoupanca(new Cliente(String.format("Cliente %s", i))));
        }
        banco.setContas(contas);
        banco.listarClientes();
    }
}
