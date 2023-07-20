INSERT INTO tipos_curso (id, nom_tipo) VALUES (1, 'CURSO');
INSERT INTO tipos_curso (id, nom_tipo) VALUES (2, 'SEMINARIO');

INSERT INTO cursos (id, nombre, objetivo, sesiones_semanales, horas_sesion,
		    contenidos, precio, tipo_curso)
	     VALUES(1, 'POO', 'Programación orientada a objetos', 2, 6,
		    'Todo sobre los objetos Java y más', 30000, 1);

INSERT INTO cursos (id, nombre, objetivo, sesiones_semanales, horas_sesion,
		    contenidos, precio, tipo_curso)
	     VALUES(2, 'Matematicas básicas', 'fundamentos de matemáticas', 3, 6,
		    'Todo sobre los números reales', 30000, 1);

INSERT INTO cursos (id, nombre, objetivo, sesiones_semanales, horas_sesion,
		    contenidos, precio, tipo_curso)
	     VALUES(3, 'UML', 'Lenguaje unificado de modelado', 2, 6,
		    'Todo sobre modelado y diseño', 30000, 2);