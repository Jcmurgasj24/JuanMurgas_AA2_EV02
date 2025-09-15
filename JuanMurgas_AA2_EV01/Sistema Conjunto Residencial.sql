create database sistema_conjunto_residencial;
use sistema_conjunto_residencial;
	CREATE TABLE Residente (
		id_residente INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(50) NOT NULL,
		apellido VARCHAR(50) NOT NULL,
		tipo_documento VARCHAR(20) NOT NULL,
		numero_documento VARCHAR(20) NOT NULL UNIQUE,
		telefono VARCHAR(15),
		email VARCHAR(100),
		numero_apartamento VARCHAR(10) NOT NULL
	);
    
CREATE TABLE Vehiculo (
    id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL UNIQUE,
    marca VARCHAR(30),
    modelo VARCHAR(20),
    color VARCHAR(20),
    id_residente INT,
    FOREIGN KEY (id_residente) REFERENCES Residente(id_residente)
        ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Visitante (
    id_visitante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    tipo_documento VARCHAR(20),
    numero_documento VARCHAR(20),
    motivo_visita VARCHAR(100)
);

CREATE TABLE Usuario_Seguridad (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(100) NOT NULL,
    rol ENUM('vigilante', 'administrador') NOT NULL
);

CREATE TABLE Registro_Entrada_Salida (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    tipo_registro ENUM('entrada', 'salida') NOT NULL,
    fecha_hora DATETIME NOT NULL,
    id_vehiculo INT,
    id_visitante INT,
    autorizado_por INT NOT NULL,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculo(id_vehiculo)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_visitante) REFERENCES Visitante(id_visitante)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (autorizado_por) REFERENCES Usuario_Seguridad(id_usuario)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

