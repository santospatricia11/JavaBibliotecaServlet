package javaweb.javaweb.teste;

import javaweb.javaweb.dao.UsuarioDao;
import javaweb.javaweb.model.Usuario;
import javaweb.javaweb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioDaoTest {

    private static EntityManager em;
    private UsuarioDao usuarioDao;

    @BeforeAll
    public static void setUpClass() {
        em = JPAUtil.getEntityManager();
    }

    @BeforeEach
    public void setUp() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        usuarioDao = new UsuarioDao(); // Sem argumentos
    }

    @AfterEach
    public void tearDown() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @AfterAll
    public static void tearDownClass() {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void testFindByEmail() {
        Usuario usuario = new Usuario("Test User", "test@example.com", "password");
        usuarioDao.cadastrar(usuario);

        Usuario foundUsuario = usuarioDao.findByEmail("test@example.com");
        assertNotNull(foundUsuario);
        assertEquals("Test User", foundUsuario.getNome());
    }
}