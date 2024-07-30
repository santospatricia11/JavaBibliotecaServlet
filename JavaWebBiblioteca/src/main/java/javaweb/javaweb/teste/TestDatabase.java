package javaweb.javaweb.teste;

import javaweb.javaweb.model.Livro;
import javaweb.javaweb.model.Usuario;
import javaweb.javaweb.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestDatabase {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Usuario logger = new Usuario("pppppp","patricia@gmail.com","8383838383s");
        em.persist(logger);


        Livro livro = new Livro("1234","serd" ,"sxec","dfv",3,"wsed");
        em.persist(livro);

        em.getTransaction().commit();
        em.close();

    }
}

