import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../models/curso';
import { Empleado } from '../models/empleado';
import { Empresa } from '../models/empresa';
import { TipoIdentificacion } from '../models/tipo-identificacion';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  urlEndPoint:string='http://localhost:9191/empleado';
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  listar():Observable<Empleado[]>{
    return this.http.get<Empleado[]>(this.urlEndPoint);
  }

  listar_tipos_id(): Observable<TipoIdentificacion[]>{
    return this.http.get<TipoIdentificacion[]>(`${this.urlEndPoint}/tipos_id`);
  }

  listar_empresas(): Observable<Empresa[]>{
    return this.http.get<Empresa[]>(`${this.urlEndPoint}/empresas`);
  }

  crear(empleado:Empleado): Observable<Empleado>{
    return this.http.post<Empleado>(this.urlEndPoint, empleado, 
      {headers:this.httpHeaders});
  }

  ver(id:number):Observable<Empleado>{
    return this.http.get<Empleado>(`${this.urlEndPoint}/${id}`);
  }

  ver_curso(id:number):Observable<Curso>{
    return this.http.get<Curso>(`${this.urlEndPoint}/curso/${id}`);
  }

  modificar(empleado:Empleado):Observable<Empleado>{
    return this.http.put<Empleado>(`${this.urlEndPoint}/${empleado.id}`, empleado, 
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

  listarCursosPagina(page:string, size:string, id: number):Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/${id}/mis_cursos`,{params:params});
  }
  
}

