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

-- USUARIOS
CREATE TABLE MASCOTAS.TUSUARIO 
    (CUSUARIO NUMBER(4,0),
    IDENTIFICACION VARCHAR2(16) NOT NULL,
    NOMBRES VARCHAR2(120) NOT NULL,
    APELLIDOS VARCHAR2(120) NOT NULL,
    USUARIO VARCHAR2(30) NOT NULL,
    PASSWORD VARCHAR2(120),
    ESTADO VARCHAR2(3),
    CORREO VARCHAR2(120),
    GENERO VARCHAR2(1),
    ACTIVO NUMBER(1,0));

ALTER TABLE MASCOTAS.TUSUARIO ADD CONSTRAINT PK_CUSUARIO PRIMARY KEY (CUSUARIO);    

COMMENT ON TABLE MASCOTAS.TUSUARIO IS 'Tabla de Usuarios';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.CUSUARIO IS 'Codigo de usuario';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.IDENTIFICACION IS 'Identificacion del usuario';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.NOMBRES IS 'Nombres del usuario';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.APELLIDOS IS 'Apellidos del usuario';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.USUARIO IS 'Usuario de cuenta del sistema';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.PASSWORD IS 'Password de cuenta del sistema';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.ESTADO IS 'Estado del usuario ACT:ACTIVO BLQ:BLOQUEADO CER;CARRADO';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.CORREO IS 'Correo institucional del usuario';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.GENERO IS 'Genero del usuario - H:HOMBRE  M:MUJER';
COMMENT ON COLUMN MASCOTAS.TUSUARIO.ACTIVO IS 'Estado del usuario - 1:ACTIVO  0:INACTIVO';
 
 
-- PREGUNTAS
CREATE TABLE MASCOTAS.TPREGUNTA 
    (CPREGUNTA NUMBER(4,0),
    PREGUNTA VARCHAR2(100) NOT NULL,
    ACTIVO NUMBER(1,0));
    
ALTER TABLE MASCOTAS.TPREGUNTA ADD CONSTRAINT PK_CPREGUNTA PRIMARY KEY (CPREGUNTA);    

COMMENT ON TABLE MASCOTAS.TPREGUNTA IS 'Tabla de Preguntas de Seguridad';
COMMENT ON COLUMN MASCOTAS.TPREGUNTA.CPREGUNTA IS 'Codigo de pregunta';
COMMENT ON COLUMN MASCOTAS.TPREGUNTA.PREGUNTA IS 'Descripcion de la pregunta';
COMMENT ON COLUMN MASCOTAS.TPREGUNTA.ACTIVO IS 'Estado del usuario - 1:ACTIVO  0:INACTIVO';


-- ROLES
CREATE TABLE MASCOTAS.TROL 
    (CROL NUMBER(4,0),
     NOMBRE VARCHAR2(40) NOT NULL,
     DESCRIPCION  VARCHAR2(100) NOT NULL,
     ACTIVO NUMBER(1,0));

ALTER TABLE MASCOTAS.TROL ADD CONSTRAINT PK_CROL PRIMARY KEY (CROL); 

COMMENT ON TABLE MASCOTAS.TROL IS 'Tabla de Roles del sistema';
COMMENT ON COLUMN MASCOTAS.TROL.CROL IS 'Codigo de rol';
COMMENT ON COLUMN MASCOTAS.TROL.NOMBRE IS 'Nombre del rol';
COMMENT ON COLUMN MASCOTAS.TROL.DESCRIPCION IS 'Descripcion del rol';
COMMENT ON COLUMN MASCOTAS.TROL.ACTIVO IS 'Estado del rol - 1:ACTIVO  0:INACTIVO';


-- ROLES USUARIO
CREATE TABLE MASCOTAS.TROLUSUARIO 
    (CROL NUMBER(4,0),
    CUSUARIO NUMBER(4,0),
    ACTIVO NUMBER(1,0));

ALTER TABLE MASCOTAS.TROLUSUARIO ADD CONSTRAINT FK_TRUCROL FOREIGN KEY (CROL) REFERENCES MASCOTAS.TROL(CROL); 
ALTER TABLE MASCOTAS.TROLUSUARIO ADD CONSTRAINT FK_TRUCUSUARIO FOREIGN KEY (CUSUARIO) REFERENCES MASCOTAS.TUSUARIO(CUSUARIO); 


COMMENT ON TABLE MASCOTAS.TROLUSUARIO IS 'Tabla de usuarios asignados a un rol';
COMMENT ON COLUMN MASCOTAS.TROLUSUARIO.CROL IS 'Codigo del rol';
COMMENT ON COLUMN MASCOTAS.TROLUSUARIO.CUSUARIO IS 'Codigo de usuario';
COMMENT ON COLUMN MASCOTAS.TROLUSUARIO.ACTIVO IS 'Estado de la relacion rol-usuario - 1:ACTIVO  0:INACTIVO';

-- PREGUNTAS USUARIO
CREATE TABLE MASCOTAS.TPREGUNTASUSUARIO 
    (CPREGUNTA NUMBER(4,0),
    CUSUARIO NUMBER(4,0),
    RESPUESTA VARCHAR2(100),
    FMODIFICACION TIMESTAMP(6),
    CUSUARIO_MODIFICACION NUMBER(4,0),
    ACTIVO NUMBER(1,0));

ALTER TABLE MASCOTAS.TPREGUNTASUSUARIO ADD CONSTRAINT FK_TPUCPREGUNTA FOREIGN KEY (CPREGUNTA) REFERENCES MASCOTAS.TPREGUNTA(CPREGUNTA); 
ALTER TABLE MASCOTAS.TPREGUNTASUSUARIO ADD CONSTRAINT FK_TPUCUSUARIO FOREIGN KEY (CUSUARIO) REFERENCES MASCOTAS.TUSUARIO(CUSUARIO); 


COMMENT ON TABLE MASCOTAS.TPREGUNTASUSUARIO IS 'Tabla de preguntas respondidas por un usuario';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.CPREGUNTA IS 'Codigo de Pregunta';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.CUSUARIO IS 'Codigo de usuario';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.RESPUESTA IS 'Respuesta a la pregunta de seguridad';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.FMODIFICACION IS 'Fecha de modificacion del registro';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.CUSUARIO_MODIFICACION IS 'Codigo de usuario de modificacion del registro';
COMMENT ON COLUMN MASCOTAS.TPREGUNTASUSUARIO.ACTIVO IS 'Estado de la relacion rol-usuario - 1:ACTIVO  0:INACTIVO';

-- SESIONES
CREATE TABLE MASCOTAS.TSESION 
    (IDSESION NUMBER(8,0),
     USUARIO VARCHAR2(30),
     FINICIOSESION TIMESTAMP,
     FFINSESION TIMESTAMP,
     RESULTADO VARCHAR2(100),
     SISTEMA VARCHAR2(100),
     CUSUARIO NUMBER(4,0),
     CROL NUMBER(4,0));

ALTER TABLE MASCOTAS.TSESION ADD CONSTRAINT PK_IDSESION PRIMARY KEY (IDSESION); 

COMMENT ON TABLE MASCOTAS.TSESION IS 'Tabla de Sesiones del sistema';
COMMENT ON COLUMN MASCOTAS.TSESION.IDSESION IS 'Identificador de la sesion';
COMMENT ON COLUMN MASCOTAS.TSESION.USUARIO IS 'Usuario de cuenta del sistema';
COMMENT ON COLUMN MASCOTAS.TSESION.FINICIOSESION IS 'Fecha y hora de inicion de Sesion del usuario';
COMMENT ON COLUMN MASCOTAS.TSESION.FFINSESION IS 'Fecha y hora de fin de Sesion del usuario';
COMMENT ON COLUMN MASCOTAS.TSESION.RESULTADO IS 'Resultado del login del usuario';
COMMENT ON COLUMN MASCOTAS.TSESION.SISTEMA IS 'Informacion del sistema';
COMMENT ON COLUMN MASCOTAS.TSESION.CUSUARIO IS 'Codigo de usuario';
COMMENT ON COLUMN MASCOTAS.TSESION.CROL IS 'Codigo de rol';


-- AUDITORIA
CREATE TABLE MASCOTAS.TAUDITORIA 
    (CAUDITORIA NUMBER(8,0),
     FREAL TIMESTAMP NOT NULL,
     TIPO VARCHAR2(50),
     ACCIONUSUARIO VARCHAR2(200),
     DETALLEACCION VARCHAR2(500),
     RESULTADO VARCHAR2(100),
     IDSESION NUMBER(8,0));

ALTER TABLE MASCOTAS.TAUDITORIA ADD CONSTRAINT PK_CAUDITORIA PRIMARY KEY (CAUDITORIA); 
ALTER TABLE MASCOTAS.TAUDITORIA ADD CONSTRAINT FK_TAUIDSESION FOREIGN KEY (IDSESION) REFERENCES MASCOTAS.TSESION(IDSESION); 

COMMENT ON TABLE MASCOTAS.TAUDITORIA IS 'Tabla de Auditoria del sistema';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.CAUDITORIA IS 'Codigo de auditoria';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.FREAL IS 'Fecha y hora de la accion del usuario';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.TIPO IS 'Tpo de accion realizada por el usuario';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.ACCIONUSUARIO IS 'Accion realizada por el usuario';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.DETALLEACCION IS 'Detalle de la accion realizada en la Base de Datos';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.RESULTADO IS 'Resultado de la accion del usuario';
COMMENT ON COLUMN MASCOTAS.TAUDITORIA.IDSESION IS 'Identificador de la sesion';

CREATE TABLE MASCOTAS.TMASCOTA 
    (CMASCOTA NUMBER(4,0),
    NOMBRE VARCHAR2(120) NOT NULL,
    EDAD NUMBER(2,0) NOT NULL,
    CIUDAD VARCHAR2(30) NOT NULL,
    TIPO VARCHAR2(120),
    DESCRIPCION VARCHAR2(500),
    ESTADO VARCHAR2(1),
    FECHA TIMESTAMP );
	
    
ALTER TABLE MASCOTAS.TMASCOTA ADD CONSTRAINT PK_CMASCOTA PRIMARY KEY (CMASCOTA);    

COMMENT ON TABLE MASCOTAS.TMASCOTA IS 'Tabla de Mascotas';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.CMASCOTA IS 'Codigo de mascota';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.NOMBRE IS 'Nombre de la mascota';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.EDAD IS 'Edad de la mascota';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.CIUDAD IS 'Ciudad en la vive la mascota';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.TIPO IS 'Tipo de mascota ejemplo perro gato';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.DESCRIPCION IS 'Descripcion de la mascota';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.ESTADO IS 'Estado de la mascota D:DISPONIBLE A:ADOPTADO';
COMMENT ON COLUMN MASCOTAS.TMASCOTA.FECHA IS 'Fecha que se crea el registro';

prompt Done.
spool
