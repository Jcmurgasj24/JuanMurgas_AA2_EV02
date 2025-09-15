<%-- 
    Document   : inicio_sesion
    Created on : Sep 14, 2025, 9:58:07 PM
    Author     : Juanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión - Sistema Conjunto Residencial</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1a2a6c, #b21f1f, #fdbb2d);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .login-container {
            width: 400px;
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.5);
            text-align: center;
            backdrop-filter: blur(6px);
        }

        .login-header {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 25px;
        }

        .login-header i {
            font-size: 60px;
            color: #ffce00;
            margin-right: 15px;
        }

        .login-header h2 {
            font-size: 24px;
            text-transform: uppercase;
            background: linear-gradient(90deg, #ffce00, #ff8c00);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin: 0;
        }

        .input-container {
            display: flex;
            align-items: center;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 10px;
            margin-bottom: 20px;
            padding: 10px;
        }

        .input-container i {
            margin-right: 10px;
            font-size: 20px;
            color: #ffce00;
        }

        .input-container input {
            flex: 1;
            border: none;
            outline: none;
            background: transparent;
            color: #fff;
            font-size: 16px;
        }

        .login-btn {
            width: 100%;
            background: linear-gradient(90deg, #ff512f, #dd2476);
            border: none;
            color: #fff;
            padding: 12px;
            font-size: 18px;
            border-radius: 10px;
            cursor: pointer;
            transition: transform 0.3s ease, background 0.3s ease;
            font-weight: bold;
        }

        .login-btn:hover {
            background: linear-gradient(90deg, #dd2476, #ff512f);
            transform: scale(1.05);
        }

        .extra-links {
            margin-top: 15px;
            font-size: 14px;
        }

        .extra-links a {
            color: #ffce00;
            text-decoration: none;
            margin: 0 5px;
        }

        .extra-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <div class="login-container">
        <!-- Encabezado -->
        <div class="login-header">
            <i class="fa fa-car"></i>
            <h2>Iniciar Sesión</h2>
        </div>

        <!-- Formulario con método POST -->
        <form action="validar_login.jsp" method="post">
            <div class="input-container">
                <i class="fa fa-user"></i>
                <input type="text" name="usuario" placeholder="Usuario" required>
            </div>
            <div class="input-container">
                <i class="fa fa-lock"></i>
                <input type="password" name="clave" placeholder="Contraseña" required>
            </div>
            <button type="submit" class="login-btn">Ingresar</button>
        </form>

        <!-- Enlaces adicionales -->
        <div class="extra-links">
            <a href="registro.jsp">Registrarse</a> | 
            <a href="recuperar_clave.jsp">¿Olvidó su contraseña?</a>
        </div>
    </div>

</body>
</html>

