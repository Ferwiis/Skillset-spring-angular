import { Curso } from "./curso";
import { Horario } from "./horario";
import { Profesor } from "./profesor";

export class Oferta {
    id: number = 0;
    curso: Curso = new Curso();
    profesor: Profesor = new Profesor();
    fecha_inicio: Date = new Date();
    fecha_fin: Date = new Date();
    cupos: number = 0;
    horarios: Array<Horario> = new Array();
}
