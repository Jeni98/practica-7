DROP TABLE IF EXISTS PRODUCTOS;

CREATE TABLE  "PRODUCTOS" (
    "COD_PROD" VARCHAR2(4) NOT NULL PRIMARY KEY,
    "MARCAS" VARCHAR2(40) NOT NULL,
	"PRODUCTO" VARCHAR2(40) NOT NULL,
	"PRECIO" NUMBER(12,2) NOT NULL
);
