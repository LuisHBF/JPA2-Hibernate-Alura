package teste;

import javax.persistence.EntityManager;

import modelo.Conta;
import util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		conta.setTitular("Luizão");
		conta.setAgencia("51023");
		
		System.out.println(conta.getTitular());
		
		manager.getTransaction().commit();
		
	}
	
}
