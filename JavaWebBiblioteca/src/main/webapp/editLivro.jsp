<%@ page import="javaweb.javaweb.model.Livro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Edição de Livro</title>
</head>
<%
    Object user = session.getAttribute("user");
    boolean isLoggedIn = (user != null);
%>
<body>
<header id="header">
    <jsp:include page="components/navBar.jsp" />
</header>

<c:choose>
    <c:when test="<%= isLoggedIn %>">
        <section>
            <a href="./home.jsp" title="Home"><button>Home</button></a>
            <div>
                <div>
                    <h1>Editar Livro</h1>
                </div>
                <%
                    Livro livro = (Livro) request.getAttribute("livro");
                    if (livro != null) {
                %>
                <form action="editBook" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="isbn" value="<%= livro.getIsbn() %>"/>
                    <div>
                        <label for="titulo">Título:</label>
                        <input type="text" id="titulo" name="titulo" value="<%= livro.getNome_livro() %>" required/>
                    </div>
                    <div>
                        <label for="categoria">Categoria:</label>
                        <input type="text" id="categoria" name="categoria" value="<%= livro.getCategoria() %>" required/>

                    </div>
                    <div>
                        <label for="descricao">Descrição:</label>
                        <input type="text" id="descricao" name="descricao" value="<%= livro.getCategoria() %>" required/>

                    </div>
                    <div>
                        <label for="quantidade">Quantidade:</label>
                        <input type="number" id="quantidade" name="quantidade" value="<%= livro.getQuantidade() %>" required/>
                    </div>
                    <div>
                        <label for="capa">Capa:</label>
                        <input type="text" id="capa" name="capa"/>
                    </div>
                    <div>
                        <button type="submit">Salvar</button>
                    </div>
                </form>
                <%
                } else {
                %>
                <p>Livro não encontrado.</p>
                <%
                    }
                %>
            </div>
        </section>
    </c:when>
    <c:otherwise>
        <section>
            <div>
                <h1>Acesso Negado</h1>
                <p>Você não tem permissão para acessar esta página.</p>
                <a href="login.jsp"><button>Voltar para o Login</button></a>
            </div>
        </section>
    </c:otherwise>
</c:choose>
<jsp:include page="footer.jsp" />
</body>
</html>
