<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro de usuário</title>
</head>
<body>
<header>
    <jsp:include page="components/navBar.jsp" />
</header>
<section id="section">
    <a href="./home.jsp" title="Home">
        <button>
            Home
        </button>
    </a>
    <div>
        <div>
            <h1>Cadastre-se</h1>
            <form id="form" action="newuser" method="post" onsubmit="return checkPasswords()">
                <div>
                    <label for="name">Nome</label>
                    <input id="name" type="text" name="nome" required />
                </div>
                <div>
                    <label for="email">E-mail</label>
                    <input id="email" type="email" name="email" required />
                </div>
                <div>
                    <label for="password">Crie sua Senha</label>
                    <input id="password" type="password" name="password" required />
                </div>
                <div>
                    <label for="confirm-password">Confirme sua Senha</label>
                    <input id="confirm-password" type="password" name="confirm-password" required />
                </div>
                <div>
                    <button type="submit">Cadastrar</button>
                </div>
            </form>
            <div>
                <h3>Já possui cadastro?
                    <a href="novoUsuario.jsp">Login</a>
                </h3>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp" />

<script src="js/checkPasswords.js"></script>
</body>
</html>
