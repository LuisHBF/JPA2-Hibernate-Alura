package teste;

import java.util.List;

import javax.persistence.EntityManager;
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
		
		List<Double> medias = movimentacaoDAO.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, manager.find(Conta.class, 1));
		medias .forEach(media -> {
			System.out.println("media: " + media);
		});
		
		manager.getTransaction().commit();
		manager.close();
	}
}
