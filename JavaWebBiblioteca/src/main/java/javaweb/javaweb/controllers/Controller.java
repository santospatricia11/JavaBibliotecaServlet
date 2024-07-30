package javaweb.javaweb.controllers;

import jakarta.servlet.annotation.MultipartConfig;
import javaweb.javaweb.dao.*;
import javaweb.javaweb.model.*;
import javaweb.javaweb.service.AuthenticationService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/newuser", "/home", "/cadastrar", "/atualizar", "/logout", "/termos"})
@MultipartConfig
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    private LivroDao livroDao;

    @Inject
    private UsuarioDao usuarioDao;

    private AuthenticationService authService;

    @Override
    public void init() {
        this.livroDao = new LivroDao();
        this.usuarioDao = new UsuarioDao();
        this.authService = new AuthenticationService(usuarioDao);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        switch (method) {
            case "GET":
                doGet(request, response);
                break;
            case "POST":
                doPost(request, response);
                break;
            case "PUT":
                doPut(request, response);
                break;
            case "DELETE":
                doDelete(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/home":
                List<Livro> livros = livroDao.listarLivros();
                request.setAttribute("listaLivros", livros);
                forwardToPage(request, response, "home.jsp");
                break;
            case "/cadastrar":
                forwardToPage(request, response, "novoLivro.jsp");
                break;
            case "/login":
                forwardToPage(request, response, "index.jsp");
                break;
            case "/logout":
                handleLogout(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/newuser":
                handleNewUser(request, response);
                break;
            case "/login":
                handleLogin(request, response);
                break;
            case "/cadastrar":
                handleAddBook(request, response);
                break;
            case "/logout":
                handleLogout(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }


    }

    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    private void handleNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario newUsuario = new Usuario(nome, email, password);
        Usuario registerUser = authService.registerUser(newUsuario);
        if (registerUser != null) {
            request.getSession().setAttribute("existingUser", registerUser);
            response.sendRedirect("login.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Esse usuário já existe.");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario authenticatedUser = authService.authenticate(email, password);

        if (authenticatedUser != null) {
            request.getSession().setAttribute("user", authenticatedUser);
            response.sendRedirect("home");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não encontrado.");
        }
    }
    private void handleAddBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String isbn = request.getParameter("isbn");
        String nome_livro = request.getParameter("nome_livro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String capa = request.getParameter("capa");

        Livro livro = new Livro(isbn, nome_livro, categoria, descricao, quantidade, capa);
        livroDao.cadastrar(livro);
        response.sendRedirect("home");
    }

    /*private void handleAddBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String isbn = request.getParameter("isbn");
        String nome_livro = request.getParameter("nome_livro ");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");

        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String capa = request.getParameter("capa");


        Livro livro = new Livro(isbn,nome_livro ,categoria,descricao,quantidade,capa);
        livro.setIsbn(isbn);
        livro.setNome_livro(nome_livro);
        livro.setCategoria(categoria);
        livro.setDescricao(descricao);
        livro.setQuantidade(quantidade);
        livro.setCapa(capa);
        LivroDao livroDao = new LivroDao();
        livroDao.cadastrar(livro);
        response.sendRedirect("home");
    }
*/

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        response.sendRedirect("login.jsp");
    }
}