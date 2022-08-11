package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Account>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindo(a) ao Digital-bank---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
        
        int operacao = input.nextInt();
        
        switch(operacao) {
        case 1:
        	criarConta();
        	break;
        case 2:
        	depositar();
        	break;
        case 3:
        	sacar();
        	break;
        case 4:
        	transferir();
        	break;
        case 5:
        	listar();
        	break;
        case 6:
        	System.out.println("Obrigado por usar nosso banco!");
        	System.exit(0);
        	break;
        default:
        	System.out.println("Opção inválida");
        	operacoes();
        	break;
        }
        
	}
	
	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String nome =  input.next();
		
		System.out.println("\nCPF: ");
		String cpf =  input.next();
		
		System.out.println("\nEmail: ");
		String email =  input.next();
		
		Client client = new Client(nome, cpf, email);
		
		Account account = new Account(client);
		
		contasBancarias.add(account);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
	}
	
	private static Account encontrarAccount(int numeroConta) {
		Account account = null;
		if(contasBancarias.size() > 0) {
			for(Account c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					account = c;
				}
			}
		}
		return account;
	}
	
	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Account account = encontrarAccount(numeroConta);
		
		if(account != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			account.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
		} else {
			System.out.println("Conta não encontrada.");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Account account = encontrarAccount(numeroConta);
		
		if(account != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			account.sacar(valorSaque);
		} else {
			System.out.println("Conta não encontrada."); 
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número da conta do remetende: ");
		int numeroContaRemetente = input.nextInt();
		
		Account contaRemetente = encontrarAccount(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número da conta do destinatário");
			int numeroContaDestinatario = input.nextInt();
			
			Account contaDestinatario = encontrarAccount(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferencia: ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor); 
			} else {
				System.out.println("Conta para depósito não foi encontrada");
			}
		} else {
			System.out.println("Conta para transferencia não encontrada");
		}
		
		operacoes();
	}
	
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for(Account account: contasBancarias) {
				System.out.println(account);
			}
		} else {
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	}
	
}
