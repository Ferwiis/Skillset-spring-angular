import { Empresa } from "./empresa";
import { TipoIdentificacion } from "./tipo-identificacion";
import { Usuario } from "./usuario";

export class Empleado {
    id: number = 0;
    usuario: Usuario = new Usuario();
    empresa: Empresa = new Empresa();
    tipo_id: TipoIdentificacion = new TipoIdentificacion();
    num_id: number = 0;
    nombre: string = '';
    apellido: string = '';
    // fecha_nac: Date = new Date();
    ciudad: string = '';
    localidad: string = '';
    direccion: string = '';
    telefono: number = 0;
    //tarj_pro
}
