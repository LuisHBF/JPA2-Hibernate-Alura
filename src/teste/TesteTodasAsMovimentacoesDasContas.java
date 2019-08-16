package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Conta;
import util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		String jpql = "SELECT DISTINCT c from Conta c LEFT JOIN fetch c.movimentacoes";
		Query query = manager.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		todasAsContas.forEach(conta -> {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes:");
			System.out.println(conta.getMovimentacoes());
		});
	}
}
