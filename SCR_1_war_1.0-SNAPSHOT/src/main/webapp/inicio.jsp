<%-- 
    Document   : inicio
    Created on : Sep 14, 2025, 9:45:36 PM
    Author     : Juanc
--%>

<%-- 
    Document   : inicio
    Created on : 18/07/2024, 2:08:42 p. m.
    Author     : Wbeimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio - Sistema Conjunto Residencial</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1a2a6c, #b21f1f, #fdbb2d);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
            color: #fff;
            text-align: center;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        #container1 {
            width: 100%;
            height: 120px;
            background: rgba(0, 0, 0, 0.6);
            display: flex;
            justify-content: center;
            align-items: center;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.6);
        }

        #container1 i {
            font-size: 70px;
            color: #ffce00;
            margin-right: 20px;
        }

        #container1 h1 {
            font-size: 28px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 2px;
            background: linear-gradient(90deg, #ffce00, #ff8c00);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .spacer {
            height: 25px;
        }

        .container {
            width: 60%;
            height: 75px;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(8px);
            border-radius: 15px;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            margin: 0 auto;
            padding: 0 15px;
            transition: transform 0.3s ease;
        }

        .container:hover {
            transform: translateY(-5px);
            box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.4);
        }

        .container .icon {
            font-size: 40px;
            margin-right: 20px;
            color: #ffce00;
            transition: transform 0.3s ease;
        }

        .container:hover .icon {
            transform: scale(1.2) rotate(8deg);
        }

        .container button {
            flex: 1;
            background: linear-gradient(90deg, #ff512f, #dd2476);
            color: #fff;
            font-weight: bold;
            border: none;
            height: 50px;
            border-radius: 10px;
            font-size: 18px;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .container button:hover {
            background: linear-gradient(90deg, #dd2476, #ff512f);
            transform: scale(1.05);
        }
    </style>

    <script>
        function redirectToInicioSesion() {
            window.location.href = "inicio_sesion.jsp";
        }
    </script>
</head>

<body>

    <!-- ENCABEZADO -->
    <div id="container1">
        <i class="fa fa-car"></i>
        <h1>Sistema Conjunto Residencial</h1>
    </div>

    <!-- MENÚ PRINCIPAL -->
    <div class="spacer"></div>
    <div class="container">
        <i class="fa fa-sign-in-alt icon"></i>
        <button type="button" onclick="redirectToInicioSesion()">Iniciar Sesión</button>
    </div>

    <div class="spacer"></div>
    <div class="container">
        <i class="fa fa-users icon"></i>
        <button type="button" onclick="window.location.href = 'residentes.jsp'">Residentes</button>
    </div>

    <div class="spacer"></div>
    <div class="container">
        <i class="fa fa-id-card icon"></i>
        <button type="button" onclick="window.location.href = 'visitantes.jsp'">Visitantes</button>
    </div>

    <div class="spacer"></div>
    <div class="container">
        <i class="fa fa-car icon"></i>
        <button type="button" onclick="window.location.href = 'vehiculos.jsp'">Vehículos</button>
    </div>

    <div class="spacer"></div>
    <div class="container">
        <i class="fa fa-phone icon"></i>
        <button type="button" onclick="window.location.href = 'contacto.jsp'">Contacto / Soporte</button>
    </div>

</body>
</html>
