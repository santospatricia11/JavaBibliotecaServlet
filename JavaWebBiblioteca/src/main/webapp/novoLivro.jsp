<%@ page import="javaweb.javaweb.model.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Cadastro de Livro</title>
</head>
<%
    Object user = session.getAttribute("user");
    boolean isLoggedIn = (user != null);
%>
<body>
<header>
    <jsp:include page="components/navBar.jsp" />

</header>

<c:choose>
    <c:when test="<%= isLoggedIn %>">
        <section>
            <a href="./home.jsp" title="Home">Home</a>
            <div>
                <h1>Cadastre seu Livro</h1>
            </div>
            <form action="cadastrar" method="post" enctype="multipart/form-data">
                <div>
                    <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" required/>
                </div>
                <div>
                    <label for="nome_livro">Nome do Livro:</label>
                    <input type="text" id="nome_livro" name="nome_livro" required/>
                </div>
                <div>
                    <label for="categoria">Categoria:</label>
                    <input type="text" id="categoria" name="categoria" required/>

                </div>
                <div>
                    <label for="descricao">Descrição:</label>
                    <input type="text" id="descricao" name="descricao" required/>
                </div>
                <div>
                    <label for="quantidade">Quantidade:</label>
                    <input type="number" id="quantidade" name="quantidade" value="1" min="1" required/>
                </div>
                <div>
                    <label for="imagem">Capa:</label>
                    <input type="text" id="imagem" name="imagem"/>
                </div>
                <div>
                    <button type="submit">Adicionar</button>
                </div>
            </form>
        </section>
    </c:when>
    <c:otherwise>
        <section>
            <div>
                <h1>Acesso Negado</h1>
                <p>Você não tem permissão para acessar esta página.</p>
                <a href="login.jsp">Voltar para o Login</a>
            </div>
        </section>
    </c:otherwise>
</c:choose>

<footer>
    <jsp:include page="footer.jsp" />
</footer>
</body>
</html>
