package util;

import javax.persistence.EntityManager;

import modelo.Conta;

public class PopulaConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();

		conta1.setBanco("001 - BANCO DO BRASIL");
		conta1.setNumero("23982-X");
		conta1.setAgencia("6543");
		conta1.setTitular("Maria");

		conta2.setBanco("237 - BANCO BRADESCO");
		conta2.setNumero("86519-3");
		conta2.setAgencia("17454");
		conta2.setTitular("Paulo");

		conta3.setBanco("341 - BANCO ITAU UNIBANCO");
		conta3.setNumero("77772-3");
		conta3.setAgencia("7467");
		conta3.setTitular("Antonio");

		conta4.setBanco("033 - BANCO SANTANDER");
		conta4.setNumero("12345-6");
		conta4.setAgencia("9876");
		conta4.setTitular("Leandra");

		conta5.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta5.setNumero("96454-3");
		conta5.setAgencia("1234");
		conta5.setTitular("Alexandre");

		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		manager.persist(conta5);

		manager.getTransaction().commit();

		manager.close();

	}

}

