import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../models/curso';
import { Profesor } from '../models/profesor';
import { TipoIdentificacion } from '../models/tipo-identificacion';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {
  urlEndPoint:string='http://localhost:9191/profesor';
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  listar():Observable<Profesor[]>{
    return this.http.get<Profesor[]>(this.urlEndPoint);
  }

  listar_tipos_id(): Observable<TipoIdentificacion[]>{
    return this.http.get<TipoIdentificacion[]>(`${this.urlEndPoint}/tipos_id`);
  }

  crear(profesor:Profesor): Observable<Profesor>{
    return this.http.post<Profesor>(this.urlEndPoint, profesor, 
      {headers:this.httpHeaders});
  }

  ver(id:number):Observable<Profesor>{
    return this.http.get<Profesor>(`${this.urlEndPoint}/${id}`);
  }

  ver_curso(id:number):Observable<Curso>{
    return this.http.get<Curso>(`${this.urlEndPoint}/curso/${id}`);
  }

  modificar(profesor:Profesor):Observable<Profesor>{
    return this.http.put<Profesor>(`${this.urlEndPoint}/${profesor.id}`, profesor, 
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
