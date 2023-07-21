import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Oferta } from '../models/oferta';

@Injectable({
  providedIn: 'root'
})
export class OfertaService {
  urlEndPoint:string='http://localhost:9191/oferta';
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  listar():Observable<Oferta[]>{
    return this.http.get<Oferta[]>(this.urlEndPoint);
  }

  crear(oferta:Oferta): Observable<Oferta>{
    return this.http.post<Oferta>(this.urlEndPoint, oferta, 
      {headers:this.httpHeaders});
  }

  ver(id:number):Observable<Oferta>{
    return this.http.get<Oferta>(`${this.urlEndPoint}/${id}`);
  }

  modificar(oferta:Oferta):Observable<Oferta>{
    return this.http.put<Oferta>(`${this.urlEndPoint}/${oferta.id}`, oferta, 
      {headers:this.httpHeaders});
  }

  eliminar(id:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size', size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }

}
