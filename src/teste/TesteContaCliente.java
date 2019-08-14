package teste;

import javax.persistence.EntityManager;

import modelo.Cliente;
import modelo.Conta;
import util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Luis");
		cliente.setEndereco("Rua lala, 321");
		cliente.setProfissao("Professor");
		
		Conta conta = manager.find(Conta.class, 2);
		cliente.setConta(conta);
		
		manager.persist(cliente);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
