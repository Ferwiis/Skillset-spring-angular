import { Empleado } from "./empleado";
import { Oferta } from "./oferta";

export class OfertaEmpleado {
    id: number = 0;
    oferta: Oferta = new Oferta();
    empleado: Empleado = new Empleado();
    asistencias: number = 0;
    nota_definitiva: number = 0.0;
    es_modificable: boolean = false;
    es_meritorio_de_certificado_de_asistencias: boolean = false;
    es_meritorio_de_certificado_de_aprobacion: boolean = false;
}
