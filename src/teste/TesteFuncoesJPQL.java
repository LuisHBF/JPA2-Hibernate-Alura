package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.print.attribute.standard.Media;

import dao.MovimentacaoDAO;
import modelo.Categoria;
import modelo.Conta;
import modelo.TipoMovimentacao;
import util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();		
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);
		
		Conta conta = manager.find(Conta.class, 1);
		List<Double> medias = movimentacaoDAO.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		medias .forEach(media -> {
			System.out.println("media: " + media);
		});
		
		TypedQuery<Double> typedQuery = manager.createNamedQuery("MediasPorDiaETipo",Double.class);			
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		manager.getTransaction().commit();
		manager.close();
	}
}
