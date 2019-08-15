package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Categoria;
import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = manager.find(Categoria.class, 1);
		
		String jpql = "SELECT m from Movimentacao m join m.categorias c where c = :pCategoria";
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();
		
		resultados.forEach(movimentacao -> {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id" + movimentacao.getConta().getId());
		});
	}
}
