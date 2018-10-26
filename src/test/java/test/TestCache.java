package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TestCache {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);

        EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean(EntityManagerFactory.class);        
        EntityManager em = emf.createEntityManager();

        Produto produto = em.find(Produto.class, 1);
        System.out.println("Nome: " + produto.getNome());
        
        //Produto outroProduto = em.find(Produto.class, 1);
        EntityManager em2 = emf.createEntityManager(); // criando o segundo EntityManager
        Produto outroProduto = em2.find(Produto.class, 1); // buscando a mesma entidade com o segundo EntityManager
        System.out.println("Nome: " + outroProduto.getNome());
    }
}
