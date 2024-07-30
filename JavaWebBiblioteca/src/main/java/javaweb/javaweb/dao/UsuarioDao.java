package javaweb.javaweb.dao;

import javaweb.javaweb.model.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import java.util.List;
import static javaweb.javaweb.util.InSessionUtil.inSession;

@RequestScoped
public class UsuarioDao {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");

    public UsuarioDao() {}

    public void cadastrar(Usuario logger) {
        inSession(factory, entityManager -> {
            entityManager.persist(logger);
        });
    }

    public void atualizar(String email) {
        inSession(factory, entityManager -> {
            Usuario logger = entityManager.find(Usuario.class, email);
            if (logger != null) {
                entityManager.merge(logger);
            }
        });
    }

    public void remover(String email) {
        inSession(factory, entityManager -> {
            Usuario logger = entityManager.find(Usuario.class, email);
            if (logger != null) {
                entityManager.remove(logger);
            }
        });
    }

    public List<Usuario> listarUsers() {
        return inSession(factory, entityManager -> {
            return entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();
        });
    }

    public Usuario findByEmail(String email) {
        return inSession(factory, entityManager -> {
            try {
                return entityManager.createQuery("SELECT l FROM Usuario l WHERE l.email = :email", Usuario.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException e) {
                return null; // Nenhum resultado encontrado, usuário não existe
            }
        });
    }
}
