-- DDL ---

DROP DATABASE IF EXISTS bd111mil;
CREATE DATABASE bd111mil;
USE bd111mil;

-- Habilita las modificaciones, Opc.Menu: Edit, Preference , SQLEditor, destildar ultima opc.
SET SQL_SAFE_UPDATES = 0;


-- Permite la conexion a la BD desde java. La version del driver exije que la pwd sea creada de este modo
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';



CREATE TABLE E01_CLIENTE (
    nro_cliente INTEGER NOT NULL,
    nombre 		VARCHAR(45) NOT NULL,
    apellido 	VARCHAR(45) NOT NULL,
    direccion 	VARCHAR(45) NOT NULL,
    activo 		tinyint NOT NULL,
    CONSTRAINT PK_E01_CLIENTE PRIMARY KEY (nro_cliente)
)
ENGINE = InnoDB
;



CREATE TABLE E01_DETALLE_FACTURA (
    nro_factura 	INTEGER NOT NULL,
    codigo_producto INTEGER NOT NULL,
    nro_item 		INTEGER NOT NULL,
    cantidad 		FLOAT NOT NULL,
    CONSTRAINT PK_E01_DETALLE_FACTURA PRIMARY KEY (nro_factura , codigo_producto)
)
ENGINE = InnoDB
;


CREATE TABLE E01_FACTURA (
    nro_factura 	INTEGER NOT NULL,
    fecha 			DATETIME  NOT NULL,
    total_sin_iva 	DOUBLE NOT NULL,
    iva 			DOUBLE NOT NULL,
    total_con_iva 	DOUBLE,
    nro_cliente 	INTEGER NOT NULL,
    CONSTRAINT PK_E01_FACTURA PRIMARY KEY (nro_factura)
)
ENGINE = InnoDB
;


CREATE TABLE E01_PRODUCTO (
    codigo_producto INTEGER NOT NULL,
    marca 			VARCHAR(45) NOT NULL,
    nombre 			VARCHAR(45) NOT NULL,
    descripcion 	VARCHAR(45) NOT NULL,
    precio 			FLOAT NOT NULL,
    stock 			INTEGER NOT NULL,
    CONSTRAINT PK_E01_PRODUCTO PRIMARY KEY (codigo_producto)
)
ENGINE = InnoDB
;

CREATE TABLE E01_TELEFONO (
    codigo_area 	INTEGER NOT NULL,
    nro_telefono 	INTEGER NOT NULL,
    tipo CHAR(1) 	NOT NULL,
    nro_cliente 	INTEGER NOT NULL,
    CONSTRAINT PK_E01_TELEFONO PRIMARY KEY (codigo_area , nro_telefono)
)
ENGINE = InnoDB
;


ALTER TABLE E01_DETALLE_FACTURA ADD CONSTRAINT FK_E01_DETALLE_FACTURA_PRODUCTO
    FOREIGN KEY (codigo_producto)
    REFERENCES E01_PRODUCTO(codigo_producto)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;


ALTER TABLE E01_DETALLE_FACTURA ADD CONSTRAINT FK_E01_DETALLE_FACTURA_FACTURA 
    FOREIGN KEY (nro_factura)
    REFERENCES E01_FACTURA(nro_factura)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;


ALTER TABLE E01_FACTURA ADD CONSTRAINT FK_E01_FACTURA_CLIENTE 
    FOREIGN KEY (nro_cliente)
    REFERENCES E01_CLIENTE(nro_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;


ALTER TABLE E01_TELEFONO ADD CONSTRAINT FK_E01_TELEFONO_CLIENTE 
    FOREIGN KEY (nro_cliente)
    REFERENCES E01_CLIENTE(nro_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;

