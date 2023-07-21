import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';
import { EmpleadoService } from './empleado.service';
import { EmpresaService } from './empresa.service';
import { ProfesorService } from './profesor.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  urlEndPoint:string='http://localhost:9191/usuario';
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient, private empre_serv: EmpresaService, private emple_serv: EmpleadoService, private prof_serv: ProfesorService) { }

  activar(usuario: Usuario):Observable<Usuario> {
    return this.http.put<Usuario>(`${this.urlEndPoint}/activar/${usuario.id}`, usuario, 
    {headers:this.httpHeaders});
  }

  desactivar(usuario: Usuario):Observable<Usuario> {
    return this.http.put<Usuario>(`${this.urlEndPoint}/desactivar/${usuario.id}`, usuario);
  }

  listar():Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.urlEndPoint);
  }

  crear(usuario:Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.urlEndPoint, usuario, 
      {headers:this.httpHeaders});
  }

  ver(id:number):Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`);
  }
  modificar(usuario:Usuario):Observable<Usuario>{
    return this.http.put<Usuario>(`${this.urlEndPoint}/${usuario.id}`, usuario, 
      {headers:this.httpHeaders});
  }

  eliminar(id:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
