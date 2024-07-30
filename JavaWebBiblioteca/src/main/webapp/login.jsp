<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
</head>
<body>
<header >
    <jsp:include page="/components/navBar.jsp" />
</header>
<section>
    <a href="./index.jsp" title="Home"><button>Home</button></a>
    <div>

                    <h1>Login</h1>
                    <form id="form" action="login" method="post">
                        <div>
                            <label for="email">E-mail</label>
                            <input id="email" type="email" name="email" required />
                        </div>
                        <div>
                            <label for="password">Senha</label>
                            <input id="password" type="password" name="password" required />
                        </div>
                        <div>
                            <button type="submit">LOGIN</button>
                        </div>
                    </form>
                    <div>
                        <h3>Não possui uma conta?
                            <a href="novoUsuario.jsp">Cadastre-se</a>
                        </h3>
                    </div>
                </div>
</section>
<jsp:include page="footer.jsp" />
</body>
</html>
