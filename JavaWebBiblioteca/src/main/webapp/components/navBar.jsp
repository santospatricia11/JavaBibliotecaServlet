
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>navBar</title>

    <%
        Object user = session.getAttribute("user");
        boolean isLoggedIn = (user != null);
    %>
</head>
<body>
<nav
        class="">

    <a href="./index.jsp" class="">
    </a>

    <div>


        <a href="./home.jsp" >
            <button class="">
                Coleção de Livros
            </button>
        </a>

        <c:choose>
            <c:when test="<%= isLoggedIn %>">
                <div>

                    <a
                            href="./novoLivro.jsp" >
                        <button >
                            Cadastro de Livros
                        </button> </a>
                </div>
            </c:when>
            <c:otherwise>
                <div>

                    <a
                            href="./novoUsuario.jsp"> <button >
                        Cadastre-se
                    </button> </a>
                </div>
            </c:otherwise>
        </c:choose>
        <div>
            <c:choose>
            <c:when test="<%= isLoggedIn %>">
        </div>
        <p  class=" ">Bem-vindo(a) ${user.nome} </p>
        <div>
            </c:when>
            <c:otherwise>
                <a class=""
                   href="./login.jsp">
                    Login
                </a>

            </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${not empty sessionScope.user}">
            <div>
                <a href="logout" title="Logout" ><button  class=" ">

                </button> </a>
            </div>
        </c:if>

    </div>

</nav>

</body>
</html>
