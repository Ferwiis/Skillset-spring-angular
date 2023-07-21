import { TipoIdentificacion } from './tipo-identificacion';
import { Usuario } from './usuario';

export class Profesor {
  id: number = 0;
  usuario: Usuario = new Usuario();
  tipo_id: TipoIdentificacion = new TipoIdentificacion();
  num_id: number = 0;
  nombre: string = '';
  apellido: string = '';
  ciudad: string = '';
  localidad: string = '';
  direccion: string = '';
  telefono: number = 0;
  //tarj_pro
}
