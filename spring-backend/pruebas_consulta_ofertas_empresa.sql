USE skillsetdb;
/*SELECT oe.id, oe.oferta, oe.empleado, oe.asistencias, oe.nota_definitiva, oe.es_modificable FROM oferta_empleado AS oe
			 JOIN empleados AS e
			 JOIN empresas AS emp
			 WHERE e.id = oe.empleado AND emp.id = e.empresa;*/

/*SELECT c.id, c.nombre, c.objetivo, c.horas_sesion, c.sesiones_curso, c.sesiones_semanales, c.tipo_curso, c.precio FROM cursos AS c 
WHERE c.id IN (SELECT MIN(o.curso) FROM ofertas AS o JOIN empleados AS emple JOIN empresas AS emp JOIN oferta_empleado AS oe WHERE oe.empleado = emple.id AND emple.empresa = 1
AND oe.oferta = o.id GROUP BY curso);*/

/*SELECT o.id, o.curso, o.profesor, o.cupos, o.fecha_inicio, o.fecha_fin FROM ofertas AS o JOIN oferta_empleado AS oe JOIN empresas as emp JOIN empleados as e WHERE oe.oferta = o.id AND oe.empleado = e.id AND e.empresa = emp.id;*/