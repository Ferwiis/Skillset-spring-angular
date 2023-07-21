import { Empleado } from "./empleado";
import { TipoIdentificacion } from "./tipo-identificacion";
import { Usuario } from "./usuario";

export class Empresa {
    id: number = 0;
    usuario: Usuario = new Usuario();
    empleados: Array<Empleado> = new Array();
    nit: string = '';
    razon_social: string = '';
    // fecha_fund: Date = new Date();
    tel_fijo: number = 0;
    //matricula_merc
    nom_duenio: string = '';
    ape_duenio: string = '';
    tipo_id_duenio: TipoIdentificacion = new TipoIdentificacion();
    num_id_duenio: number = 0;
    // fecha_nac_duenio: Date = new Date();
    tel_duenio: number = 0;
    nom_rep: string = '';
    ape_rep: string = '';
    tipo_id_rep: TipoIdentificacion = new TipoIdentificacion();
    num_id_rep: number = 0;
    // fecha_nac_rep: Date = new Date();
    tel_rep: number = 0;

}
