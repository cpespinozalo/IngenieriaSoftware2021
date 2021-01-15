/*==================================================================
Database name:  Database
DBMS name:      ORACLE Version 12c Express Edition
Created on:     12/01/2021
Created by:     Grupo 3 - Ingenieria de Software
/*==================================================================*/

spool DDL_PARAMETRIZACION_INICIAL.log

-- ====================================================
-- CREACION DEL USUARIO MASCOTAS
-- ====================================================
CREATE USER mascotas IDENTIFIED BY COREinsidei7;

GRANT CONNECT, RESOURCE TO mascotas;
GRANT CREATE ANY TABLE, RESOURCE TO mascotas;
GRANT SELECT ANY TABLE, RESOURCE TO mascotas;
GRANT INSERT ANY TABLE, RESOURCE TO mascotas;
GRANT ALTER ANY TABLE, RESOURCE TO mascotas;
GRANT ALTER ANY INDEX, RESOURCE TO mascotas;
GRANT CREATE VIEW TO mascotas;

ALTER USER mascotas IDENTIFIED BY COREinsidei7 ACCOUNT UNLOCK;
CONNECT mascotas/COREinsidei7;


prompt Done.
spool
