package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Categoria;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = manager.find(Categoria.class, 1);
		
		String jpql = "SELECT avg(m.valor) from Movimentacao m join m.categorias c where c = :pCategoria AND m.tipo = :pTipo"
				+ " group by day(m.data), month(m.data), year(m.data)";
		TypedQuery<Double> query = manager.createQuery(jpql,Double.class);
		query.setParameter("pCategoria", categoria);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List<Double> medias = (List<Double>) query.getResultList();
			
		medias.forEach(media -> {
			System.out.println("media: " + media);
		});
		
		manager.getTransaction().commit();
		manager.close();
	}
}
