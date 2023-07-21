import { OfertaEmpleado } from "./oferta-empleado";
import { TipoCertificado } from "./tipo-certificado";

export class Certificado {
    id: number = 0;
    tipo_cert: TipoCertificado = new TipoCertificado();
    oferta_empleado: OfertaEmpleado = new OfertaEmpleado();
    //imagen_cert
}
