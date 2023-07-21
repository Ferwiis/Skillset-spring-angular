import { TipoCurso } from "./tipo-curso";

export class Curso {
    id: number = 0;
    nombre: string = '';
    objetivo: string = '';
    sesiones_semanales: number = 0;
    sesiones_curso: number = 0;
    horas_sesion: number = 0;
    contenidos: string = '';
    precio: number = 0.0;
    tipo_curso: TipoCurso = new TipoCurso();
}
