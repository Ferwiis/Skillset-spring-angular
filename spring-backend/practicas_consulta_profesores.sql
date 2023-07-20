USE skillsetdb;

INSERT INTO roles (rol, nombre) VALUES (1, 'administrador');
INSERT INTO roles (rol, nombre) VALUES (2, 'empresa');
INSERT INTO roles (rol, nombre) VALUES (3, 'empleado');
INSERT INTO roles (rol, nombre) VALUES (4, 'profesor');

INSERT INTO tipos_identificacion (id, nom_tipo) VALUES (1, 'CC');
INSERT INTO tipos_identificacion (id, nom_tipo) VALUES (2, 'CE');
INSERT INTO tipos_identificacion (id, nom_tipo) VALUES (3, 'TI');
INSERT INTO tipos_identificacion (id, nom_tipo) VALUES (4, 'PAP');

INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (1, 'admin1@gmail.com', 'admin1', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (2, 'admin2@gmail.com', 'admin2', '12345', 1, 1);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (3, 'admin3@gmail.com', 'admin3', '12345', 0, 0);

INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (4, 'empresa1@gmail.com', 'empresa1', '12345', 1, 1);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (5, 'empresa2@gmail.com', 'empresa2', '12345', 1, 1);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (6, 'empresa3@gmail.com', 'empresa3', '12345', 1, 0);

INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (7, 'profesor1@gmail.com', 'profesor1', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (8, 'profesor2@gmail.com', 'profesor2', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (9, 'profesor3@gmail.com', 'profesor3', '12345', 1, 0);

INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (10, 'empleado1@gmail.com', 'empleado1', '12345', 1, 1);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (11, 'empleado2@gmail.com', 'empleado2', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (12, 'empleado3@gmail.com', 'empleado3', '12345', 1, 1);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (13, 'empleado4@gmail.com', 'empleado4', '12345', 1, 0);

INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (14, 'empresa4@gmail.com', 'empresa4', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (15, 'profesor4@gmail.com', 'profesor4', '12345', 1, 0);
INSERT INTO usuarios (id, correo, nickname, contrasena, cuenta_activada, esta_activo) VALUES (16, 'empleado5@gmail.com', 'empleado5', '12345', 1, 0);

INSERT INTO usuario_roles (usuario, rol) VALUES (1, 1);
INSERT INTO usuario_roles (usuario, rol) VALUES (2, 1);
INSERT INTO usuario_roles (usuario, rol) VALUES (3, 1);

INSERT INTO usuario_roles (usuario, rol) VALUES (4, 2);
INSERT INTO usuario_roles (usuario, rol) VALUES (5, 2);
INSERT INTO usuario_roles (usuario, rol) VALUES (6, 2);

INSERT INTO usuario_roles (usuario, rol) VALUES (7, 4);
INSERT INTO usuario_roles (usuario, rol) VALUES (8, 4);
INSERT INTO usuario_roles (usuario, rol) VALUES (9, 4);

INSERT INTO usuario_roles (usuario, rol) VALUES (10, 3);
INSERT INTO usuario_roles (usuario, rol) VALUES (11, 3);
INSERT INTO usuario_roles (usuario, rol) VALUES (12, 3);
INSERT INTO usuario_roles (usuario, rol) VALUES (13, 3);

INSERT INTO usuario_roles (usuario, rol) VALUES (14, 2);
INSERT INTO usuario_roles (usuario, rol) VALUES (15, 4);

INSERT INTO profesores(id, usuario, nombre, apellido, tipo_id, 
			  num_id, fecha_nac, ciudad, localidad, direccion, telefono, tarj_pro)
		      VALUES(1, 7, 'Misael', 'Pastrana', 1, 1004642536, 
              '2004-03-22', 'Medellin', 'Comuna 13', 'Avenida Risol', 349754120, null);

INSERT INTO profesores(id, usuario, nombre, apellido, tipo_id, 
			  num_id, fecha_nac, ciudad, localidad, direccion, telefono, tarj_pro)
		      VALUES(2, 8, 'Robinson Ballesteros', 'Leal', 1, 1004642537, 
              '2000-07-10', 'Tibú', 'Solana', 'Cll 10 #3-20', 300288201, null);
              
INSERT INTO profesores(id, usuario, nombre, apellido, tipo_id, 
			  num_id, fecha_nac, ciudad, localidad, direccion, telefono, tarj_pro)
		      VALUES(3, 9, 'Camilo Hernan', 'Molina Salamanca', 1, 1008642538, 
              '1984-04-30', 'Barranquilla', 'Bello', 'Cll 45 #28-14', 300288202, null);