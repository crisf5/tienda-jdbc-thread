﻿-- PRODUCTO / CATEGORIA / PROVEEDOR

DROP SCHEMA PUBLIC CASCADE;

CREATE TABLE categoria (
    id_categoria INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,descripcion VARCHAR(255));
INSERT INTO categoria VALUES (1,'Computación');   
INSERT INTO categoria VALUES (2,'Telefonía');   
INSERT INTO categoria VALUES (3,'Videouegos');   
   
CREATE TABLE proveedor (
    id_proveedor INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,empresa VARCHAR(255)
   ,contacto VARCHAR(255)
   ,direccion VARCHAR(255));
INSERT INTO proveedor VALUES (1,'Sony','Juan Gonz�lez','Pje. Della Paolera 22 Piso 15');
INSERT INTO proveedor VALUES (2,'Dell','Carlos Graggero','Ing. Butty 214 Piso 3');
INSERT INTO proveedor VALUES (3,'Samsung','Francisco Heredia','Av. Ej�rcito de Salvaci�n 311');
INSERT INTO proveedor VALUES (4,'Microsoft','Gerardo Garc�a','Bulnes 518 Piso 7');

CREATE TABLE proveedor_categoria (
    id_proveedor_categoria INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,id_proveedor INTEGER
   ,id_categoria INTEGER);
ALTER TABLE proveedor_categoria ADD FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor);
ALTER TABLE proveedor_categoria ADD FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria);

INSERT INTO proveedor_categoria VALUES(1,1,1); -- Sony/Computacion
INSERT INTO proveedor_categoria VALUES(2,1,2); -- Sony/Telefonia
INSERT INTO proveedor_categoria VALUES(3,1,3); -- Sony/Videojuegos
INSERT INTO proveedor_categoria VALUES(4,2,1); -- Dell/Computacion
INSERT INTO proveedor_categoria VALUES(5,3,1); -- Samsung/Computacion
INSERT INTO proveedor_categoria VALUES(6,3,2); -- Samgung/Telefonia
INSERT INTO proveedor_categoria VALUES(7,4,3); -- Microsoft/Videojuegos

CREATE TABLE producto (
    id_producto INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,descripcion VARCHAR(255)
   ,id_proveedor INTEGER
   ,id_categoria INTEGER
   ,precio_unitario DOUBLE
   ,unidades_stock INTEGER
   ,unidades_stock_minimo INTEGER
   ,unidades_stock_maximo INTEGER
   ,flg_discontinuo INTEGER);
ALTER TABLE producto ADD FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor);
ALTER TABLE producto ADD FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria);

INSERT INTO producto VALUES (1,'Notebook Vaio SVN1445210',1,1,1300,5,2,10,0); -- notebook/sony
INSERT INTO producto VALUES (2,'Notebook Vaio SVN1562883',1,1,980,2,3,10,0); -- notebook/sony
INSERT INTO producto VALUES (3,'Ultrabook Slim Vaio SVUB15551',1,1,1800,1,10,1,0); -- notebook/sony
INSERT INTO producto VALUES (4,'Inspiron 14-55312',2,1,540,6,0,10,0); -- notebook/dell
INSERT INTO producto VALUES (5,'Latitude 12-24411',2,1,1100,3,0,10,0); -- notebook/dell
INSERT INTO producto VALUES (6,'Chromebook 13KBE04',3,1,880,1,3,10,0); -- notebook/samsung
INSERT INTO producto VALUES (7,'Xperia V6'         ,1,2,660,3,2,10,0); -- cel/sony
INSERT INTO producto VALUES (8,'Xperia V9',1,2,1200,1,0,10,0); -- cel/sony
INSERT INTO producto VALUES (9,'S8',3,2,990,4,3,10,0); -- cel/samsung
INSERT INTO producto VALUES (10,'S8',3,2,990,4,3,10,0); -- cel/samsung
INSERT INTO producto VALUES (11,'S8 mini',3,2,550,8,2,10,0); -- cel/samsung
INSERT INTO producto VALUES (12,'S9',3,2,1300,3,0,10,0); -- cel/samsung
INSERT INTO producto VALUES (13,'S9 mini',3,2,670,5,2,10,0); -- cel/samsung
INSERT INTO producto VALUES (14,'Playstation 4 500 MB',4,3,700,5,3,10,0); -- vj/ms
INSERT INTO producto VALUES (15,'Playstation 4 1000 MG',4,3,1100,3,1,10,0); -- vj/ms
INSERT INTO producto VALUES (16,'Mando Playstation XV3432',4,3,150,3,0,10,0); -- vj/ms
INSERT INTO producto VALUES (17,'Xbox One',1,3,1100,4,0,10,0); -- vj/Sony
INSERT INTO producto VALUES (18,'Mando Xbox Bateria VBB133123',1,3,170,3,0,10,0); -- vj/Sony

CREATE TABLE reposicion(
            id_reposicion INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,id_producto INTEGER
           ,cantidad INTEGER
           ,fecha DATE);
ALTER TABLE reposicion ADD FOREIGN KEY (id_producto) REFERENCES producto (id_producto);

CREATE TABLE promocion (
            id_promocion INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,descripcion VARCHAR(255));
INSERT INTO promocion VALUES (1,'Promo Tarjeta Naranja');
INSERT INTO promocion VALUES (2,'Promo Banco Galicia');
INSERT INTO promocion VALUES (3,'Promo Clarin 365');

CREATE TABLE promocion_vigencia (
            id_promocion_vigencia INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,id_promocion INTEGER
           ,fecha_inicio DATE
           ,fecha_fin DATE);
ALTER TABLE promocion_vigencia ADD FOREIGN KEY (id_promocion) REFERENCES promocion (id_promocion);
INSERT INTO promocion_vigencia VALUES (10 ,1,now, date_add(now,7 day));
INSERT INTO promocion_vigencia VALUES (11,1,date_sub(now,15 day), date_sub(now,10 day));
INSERT INTO promocion_vigencia VALUES (12,1,date_sub(now,25 day), date_sub(now,30 day));
INSERT INTO promocion_vigencia VALUES (20,2,date_sub(now,2 day), date_add(now,5 day));
INSERT INTO promocion_vigencia VALUES (21,2,date_sub(now,18 day), date_sub(now,13 day));
INSERT INTO promocion_vigencia VALUES (30,3,date_sub(now,26 day), date_sub(now,8 day));
INSERT INTO promocion_vigencia VALUES (31,3,date_sub(now,4 day), date_add(now,1 day));
INSERT INTO promocion_vigencia VALUES (32,3,date_add(now,4 day), date_add(now,10 day));

CREATE TABLE promocion_producto (
            id_promocion_producto INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,id_producto INTEGER
           ,id_promocion_vigencia INTEGER 
           ,descuento DOUBLE);
ALTER TABLE promocion_producto ADD FOREIGN KEY (id_producto) REFERENCES producto (id_producto);
ALTER TABLE promocion_producto ADD FOREIGN KEY (id_promocion_vigencia) REFERENCES promocion_vigencia (id_promocion_vigencia);

INSERT INTO promocion_producto VALUES (1 ,2 , 10,0.2);
INSERT INTO promocion_producto VALUES (2 ,5 , 10,0.3);
INSERT INTO promocion_producto VALUES (3 ,8 , 10,0.1);
INSERT INTO promocion_producto VALUES (4 ,5 , 11,0.1);
INSERT INTO promocion_producto VALUES (5 ,8 , 11,0.2);
INSERT INTO promocion_producto VALUES (6 ,5 , 12,0.2);
INSERT INTO promocion_producto VALUES (7 ,9 , 12,0.4);
INSERT INTO promocion_producto VALUES (8 ,14, 12,0.3);
INSERT INTO promocion_producto VALUES (9 ,10, 20,0.2);
INSERT INTO promocion_producto VALUES (10,9 ,20,0.6);
INSERT INTO promocion_producto VALUES (11,17,20,0.2);
INSERT INTO promocion_producto VALUES (12,5 ,21,0.3);
INSERT INTO promocion_producto VALUES (13,9 ,21,0.6);
INSERT INTO promocion_producto VALUES (14,10,21,0.4);
INSERT INTO promocion_producto VALUES (15,4 ,30,0.3);
INSERT INTO promocion_producto VALUES (16,9 ,30,0.3);
INSERT INTO promocion_producto VALUES (17,15,30,0.3);
INSERT INTO promocion_producto VALUES (18,4 ,31,0.3);
INSERT INTO promocion_producto VALUES (19,9 ,31,0.5);
INSERT INTO promocion_producto VALUES (20,15,31,0.1);
INSERT INTO promocion_producto VALUES (21,18,31,0.2);
INSERT INTO promocion_producto VALUES (22,9 ,32,0.5);
INSERT INTO promocion_producto VALUES (23,15,32,0.35);
INSERT INTO promocion_producto VALUES (24,18,32,0.25);


-- USUARIO
CREATE TABLE usuario (
            id_usuario INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,username VARCHAR(255)
           ,password VARCHAR(255));
INSERT INTO usuario VALUES (1,'mgallardo','123');
INSERT INTO usuario VALUES (2,'rvillar'  ,'123');
INSERT INTO usuario VALUES (3,'mmontana' ,'123');
INSERT INTO usuario VALUES (4,'mroldan'  ,'123');
INSERT INTO usuario VALUES (5,'pperez'   ,'123');
INSERT INTO usuario VALUES (6,'ematsu'   ,'123');
INSERT INTO usuario VALUES (7,'aconfort' ,'123');

-- ORDEN / DETALLE / CLIENTE / EMPLEADO
CREATE TABLE tipo_cliente (
            id_tipo_cliente INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,descripcion VARCHAR(255));
INSERT INTO tipo_cliente VALUES (1,'Consumidor Final');
INSERT INTO tipo_cliente VALUES (2,'Revendedor');

CREATE TABLE cliente (    
            id_cliente INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,id_usuario INTEGER
           ,nombre VARCHAR(255)
           ,direccion VARCHAR(255)
           ,id_tipo_cliente INTEGER);
ALTER TABLE cliente ADD FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE cliente ADD FOREIGN KEY (id_tipo_cliente) REFERENCES tipo_cliente (id_tipo_cliente);
           
INSERT INTO cliente VALUES (1,1,'Marcelo Gallardo','Pje. Los Robles 351',1);
INSERT INTO cliente VALUES (2,2,'Ricardo Villar','Av. Jos� Mar�a Moreno 667',1);
INSERT INTO cliente VALUES (3,3,'Mar�a Montana','Ram�n Falc�n 5123',1);
INSERT INTO cliente VALUES (4,4,'Marcelo Rold�n','Donato �lvarez 145',1);
INSERT INTO cliente VALUES (5,5,'Paula P�rez','Av. Del Libertador 7734',1);
INSERT INTO cliente VALUES (6,6,'Electr�nica Matsushita','Av. Rivadavia 1241',2);
INSERT INTO cliente VALUES (7,7,'Audio Confort','Av. Santa Fe 3411',2);
           
CREATE TABLE empleado (    
            id_empleado INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
           ,nombre VARCHAR(255)
           ,id_jefe INTEGER);
ALTER TABLE empleado ADD FOREIGN KEY (id_jefe) REFERENCES empleado (id_empleado);

INSERT INTO empleado VALUES (1,'Jos� Vel�zquez',NULL);
INSERT INTO empleado VALUES (2,'Pedro Galimberti',1);
INSERT INTO empleado VALUES (3,'Carlos Mart�nez',1);
INSERT INTO empleado VALUES (4,'Reynaldo Jauregui',1);
INSERT INTO empleado VALUES (5,'Ram�n Sinay',4);
INSERT INTO empleado VALUES (6,'Pedro Alfonso',4);
INSERT INTO empleado VALUES (7,'Ricardo Garc�a',3);
INSERT INTO empleado VALUES (8,'Maribel Flores',3);

CREATE TABLE orden (
    id_orden INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,id_cliente INTEGER
   ,id_empleado INTEGER
   ,fecha_generada DATE
   ,fecha_entregada DATE);
ALTER TABLE orden ADD FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);
ALTER TABLE orden ADD FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado);

INSERT INTO orden VALUES (1,1,1,NOW,NULL);
INSERT INTO orden VALUES (2,1,2,NOW,NULL);
INSERT INTO orden VALUES (3,2,3,NOW,NULL);
INSERT INTO orden VALUES (4,2,4,NOW,NULL);

CREATE TABLE detalle_orden (
    id_detalle_orden INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY
   ,id_orden INTEGER
   ,id_producto INTEGER
   ,cantidad INTEGER);
ALTER TABLE detalle_orden ADD FOREIGN KEY (id_orden) REFERENCES orden (id_orden);
ALTER TABLE detalle_orden ADD FOREIGN KEY (id_producto) REFERENCES producto (id_producto);
INSERT INTO detalle_orden VALUES (1,1,1,2);
INSERT INTO detalle_orden VALUES (2,1,2,1);
INSERT INTO detalle_orden VALUES (3,1,3,3);
INSERT INTO detalle_orden VALUES (4,2,5,1);
INSERT INTO detalle_orden VALUES (5,3,4,1);
INSERT INTO detalle_orden VALUES (6,3,1,2);
INSERT INTO detalle_orden VALUES (7,4,2,3);
INSERT INTO detalle_orden VALUES (8,4,3,1);


