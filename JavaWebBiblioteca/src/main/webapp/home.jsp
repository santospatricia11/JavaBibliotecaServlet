<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javaweb.javaweb.model.Livro"%>
<%@ page import="javaweb.javaweb.dao.LivroDao"%>
<%@ page import="java.util.List" %>
<%@ page import="javaweb.javaweb.dao.LivroDao" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Lista de Livros</title>

</head>
<%
    LivroDao livroDao = new LivroDao();
    List<Livro> livros = livroDao.listarLivros();
    Object user = session.getAttribute("user");
    boolean isLoggedIn = (user != null);
%>
<body >


<header >
    <jsp:include page="components/navBar.jsp" />
</header >
<section>
    <c:choose>
        <c:when test="<%= isLoggedIn %>">
            <a href="./home.jsp" title="Home">

            </a>
        </c:when>
        <c:otherwise>
            <a href="./index.jsp" title="Home">

            </a>
        </c:otherwise>
    </c:choose>

        <div >
            <h1 >
                Lista de <span>Livros</span>
            </h1>
        </div>
                    <div >
                        <table>
                            <thead>
                            <form>
                                <th> ISBN </th>
                                <th> Nome Livro </th>
                                <th> Categoria </th>
                                <th> Quantidade </th>
                                <th>Descrição</th>
                                <th> Capa do Livro </th>
                            </form>
                            <tbody>
                            <c:forEach var="livro" items="<%=livros%>">
                            <form>
                                <td >${livro.isbn}</td>
                                <td>${livro.nome_livro}</td>
                                <td>${livro.descricao}</td>
                                <td>${livro.categoria}</td>
                                <td>${livro.quantidade}</td>
                                <td>${livro.capa}</td>

                            </form>
                            </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                    </div>
    <div>
    </div>

</section>
<jsp:include page="footer.jsp" />

</script>
</body>
</html>