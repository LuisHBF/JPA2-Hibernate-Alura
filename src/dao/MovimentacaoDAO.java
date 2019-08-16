package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Conta;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class MovimentacaoDAO {

	private EntityManager manager;
	
	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipo, Conta conta) {

		String jpql = "SELECT DISTINCT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo GROUP BY m.data";
		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		query.setParameter("pConta", conta);

		return query.getResultList();
	}

}
