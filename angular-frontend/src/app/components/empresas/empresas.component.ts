import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Empresa } from 'src/app/models/empresa';
import { EmpresaService } from 'src/app/services/empresa.service';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {
  lista: Empresa[] = new Array<Empresa>();
  titulo: string = 'Listado de empresas';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5,10,25,100];
  constructor(private service: EmpresaService) { }

  ngOnInit(): void {
    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      p => {
        this.lista = p.content as Empresa[];
        this.totalRegistros = p.totalElements as number;
      }
    );
  }

  paginar(event:PageEvent):void {
    this.paginaActual = event.pageIndex;
    this.totalPorPagina = event.pageSize;
    this.calcularRangos();
  }

}
