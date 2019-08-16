package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Categoria;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria categoria = manager.find(Categoria.class, 1);
		
		String jpql = "SELECT sum(m.valor) from Movimentacao m join m.categorias c where c = :pCategoria AND m.tipo = :pTipo";
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		System.out.println("A soma é: " + soma.intValue());
		
		manager.getTransaction().commit();
		manager.close();
	}
}
