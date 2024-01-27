package testando;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("-------------");
		System.out.println("Deseja abrir uma conta ?");
		System.out.println("Sim ou não ?");
		String isSignUp = scan.nextLine();

		if (isSignUp.equalsIgnoreCase("sim")) {
			Cliente cliente = new Cliente();
			System.out.println("Iniciando abertura de conta...");
			System.out.println("-------------");

			System.out.println("Digite seu nome: ");
			String nomeCliente = scan.nextLine();
			cliente.setNome(nomeCliente);

			System.out.println("Digite o tipo de conta deseja: ");
			System.out.println("| Corrente | Poupança |");
			String tipoDeConta = scan.nextLine();
			Conta conta = null;

			if (tipoDeConta.equalsIgnoreCase("corrente")) {
				conta = new ContaCorrente(cliente);
			} else if (tipoDeConta.equalsIgnoreCase("poupanca" )
					|| tipoDeConta.equalsIgnoreCase("poupança" )) {
				conta = new ContaPoupanca(cliente);
			} else {
				System.out.println("<=-------------=>");
				System.err.println("Opção invalida !");
				System.out.println("Obrigado !");
				System.out.println("Encerrando...");
				System.exit(0);
			}

			// Saldo inicial para testar funcionalidades
			conta.depositar(100);

			System.out.println("\n-----------------------");
			System.out.println("Deseja realizar alguma operação ?");
			System.out.println("1 -> Deposito");
			System.out.println("2 -> Saque");
			System.out.println("3 -> Transferência");
			System.out.println("Para sair digite qualquer outro numero !");
			int opcao = scan.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o valor do deposito:");
				double valor = scan.nextDouble();
				conta.depositar(valor);

				conta.imprimirExtrato();
			} else if (opcao == 2) {
				System.out.println("Digite o valor do saque:");
				double valor = scan.nextDouble();
				conta.sacar(valor);

				conta.imprimirExtrato();
			} else if (opcao == 3) {
				System.out.println("Nome do destinatario:");
				String nomeDestinatario = scan.next();

				Cliente clienteFicticio = new Cliente();
				clienteFicticio.setNome(nomeDestinatario);
				Conta contaDestinataria = new ContaCorrente(clienteFicticio);

				System.out.println("Digite o valor da transferencia:");
				double valor = scan.nextDouble();

				conta.transferir(valor, contaDestinataria);

				System.out.println("Transferencia concluida !");
				conta.imprimirExtrato();
			}
			System.out.println("Obrigado pela preferência !");
		} else {
			System.out.println("-------------");
			System.out.println("Obrigado !");
			System.out.println("Encerrando...");
		}

	}
}
