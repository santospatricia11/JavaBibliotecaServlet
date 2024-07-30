package javaweb.javaweb.controllers;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import javaweb.javaweb.dao.LivroDao;
import javaweb.javaweb.model.Livro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@WebServlet("/editLivro")
@MultipartConfig
public class EditLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivroDao livroDao;

    @Override
    public void init() {
        this.livroDao = new LivroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String isbn = request.getParameter("isbn");
        Livro livro = livroDao.buscarLivroPorIsbn(isbn);
        request.setAttribute("livro", livro);
        request.getRequestDispatcher("editLivro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        Livro livro = livroDao.buscarLivroPorIsbn(isbn);

        if (livro != null) {
            updateBookDetails(request, livro);
            livroDao.atualizar(livro);
            response.sendRedirect("home");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Livro não encontrado");
        }
    }

    private void updateBookDetails(HttpServletRequest request, Livro livro) throws ServletException, IOException {
        String nome_livro = request.getParameter("nome_livro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String capa = request.getParameter("capa");



        }
    }

