import { Rol } from "./rol";

export class Usuario {
    id:number=0;
    correo:string='';
    nickname:string='';
    contrasena:string = '';
    esta_activo: boolean = false;
    cuenta_activada: boolean = false;
    roles: Rol[] = new Array<Rol>();
}
