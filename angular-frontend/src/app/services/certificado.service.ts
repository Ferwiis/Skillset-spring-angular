import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CertificadoService {
  private urlEndPoint:string='http://localhost:9191/certificado';
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor() { }
}
