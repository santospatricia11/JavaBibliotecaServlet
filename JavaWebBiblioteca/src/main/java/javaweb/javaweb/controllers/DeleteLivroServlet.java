package javaweb.javaweb.controllers;

import javaweb.javaweb.dao.LivroDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteBookAction")
public class DeleteLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivroDao livroDao;

    @Override
    public void init() {
        this.livroDao = new LivroDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        if (isbn != null) {
            livroDao.remover(isbn);
            response.sendRedirect("home");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ISBN não fornecido");
        }
    }
}
