package bank;

import utilitarios.Utils;

public class Account {

	private static int accountCounter = 1;
	
	private int numeroConta;
	private Client client;
	private Double saldo = 0.0;
	
	public Account(Client client) {
		this.numeroConta = accountCounter;
		this.client = client;
		accountCounter += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() +
			   "\nCPF: " + this.client.getCpf() +
			   "\nEmail: " + this.client.getEmail() +
			   "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
			   "\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu deposito foi realizado com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar o depósito.");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque foi realizado com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar o saque.");
		}
	}
	
	public void transferir(Account contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso");
		} else {
			System.out.println("Não foi possivel realizar a transferencia");
		}
	}
	
}
