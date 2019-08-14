package teste;

import javax.persistence.EntityManager;

import modelo.Conta;
import util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Otavio");
		conta.setAgencia("123");
		conta.setBanco("BB");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		
		conta.setTitular("Felipe");
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Clau");
		em2.merge(conta);
		
		conta = em2.find(Conta.class, 1);
		em2.remove(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
		
		
		
	}
}
