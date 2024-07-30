package javaweb.javaweb.dao;

import javaweb.javaweb.model.Livro;
import javaweb.javaweb.util.JPAUtil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import static javaweb.javaweb.util.InSessionUtil.inSession;

@RequestScoped
public class LivroDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");


    public void cadastrar(Livro livro) {


        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
    public void atualizar(Livro livro) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(livro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void remover(String isbn) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Livro livro = entityManager.find(Livro.class, isbn);
            if (livro != null) {
                entityManager.remove(livro);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        return inSession(entityManagerFactory , entityManager -> {
            return entityManager.find(Livro.class, isbn);
        });
    }

    public List<Livro> listarLivros() {
        return inSession(entityManagerFactory , entityManager -> {
            return entityManager.createQuery("select b from Livro b", Livro.class).getResultList();
        });
    }


}