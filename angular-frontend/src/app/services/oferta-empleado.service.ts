import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OfertaEmpleadoService {
  private urlEndPoint:string='http://localhost:9191/oferta-empleado';
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor() { }
}
