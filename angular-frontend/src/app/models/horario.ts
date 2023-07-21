import { Dia } from "./dia";

export class Horario {
    id: number = 0;
    dia: Dia = new Dia();
    hora_inicio: Date = new Date();
    hora_fin: Date = new Date();
}
