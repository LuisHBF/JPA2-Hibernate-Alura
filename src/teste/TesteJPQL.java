package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 2);
		
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo "
				+ "ORDER BY m.valor DESC";
		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		resultados.forEach(movimentacao -> {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id" + movimentacao.getConta().getId());
		});
	}
}
