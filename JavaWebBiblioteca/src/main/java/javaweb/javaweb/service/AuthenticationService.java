package javaweb.javaweb.service;

import javaweb.javaweb.dao.UsuarioDao;
import javaweb.javaweb.model.Usuario;

import java.util.Optional;

public class AuthenticationService {
    private UsuarioDao usuarioDao;

    public AuthenticationService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario authenticate(String email, String password) {
        Optional<Usuario> optionalLogger = Optional.ofNullable(usuarioDao.findByEmail(email));
        return optionalLogger.filter(logger -> logger.getPassword().equals(password)).orElse(null);
    }

    public Usuario registerUser(Usuario newUsuario) {
        Optional<Usuario> optionalLogger = Optional.ofNullable(usuarioDao.findByEmail(newUsuario.getEmail()));
        if (optionalLogger.isPresent()) {
            return null;
        } else {
            usuarioDao.cadastrar(newUsuario);
            return newUsuario;
        }
    }
}