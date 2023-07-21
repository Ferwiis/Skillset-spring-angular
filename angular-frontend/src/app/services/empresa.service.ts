import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../models/curso';
import { Empresa } from '../models/empresa';
import { TipoIdentificacion } from '../models/tipo-identificacion';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {
  urlEndPoint:string='http://localhost:9191/empresa';
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  listar():Observable<Empresa[]>{
    return this.http.get<Empresa[]>(this.urlEndPoint);
  }

  listar_tipos_id(): Observable<TipoIdentificacion[]>{
    return this.http.get<TipoIdentificacion[]>(`${this.urlEndPoint}/tipos_id`);
  }

  crear(empresa:Empresa): Observable<Empresa>{
    return this.http.post<Empresa>(this.urlEndPoint, empresa, 
      {headers:this.httpHeaders});
  }

  ver(id:number):Observable<Empresa>{
    return this.http.get<Empresa>(`${this.urlEndPoint}/${id}`);
  }

  ver_curso(id:number):Observable<Curso>{
    return this.http.get<Curso>(`${this.urlEndPoint}/curso/${id}`);
  }

  modificar(empresa:Empresa):Observable<Empresa>{
    return this.http.put<Empresa>(`${this.urlEndPoint}/${empresa.id}`, empresa, 
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

  listarEmpleadosPagina(page:string, size:string, id: number):Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/${id}/empleados`,{params:params});
  }
}
