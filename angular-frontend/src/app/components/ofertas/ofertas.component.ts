import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Oferta } from 'src/app/models/oferta';
import { OfertaService } from 'src/app/services/oferta.service';

@Component({
  selector: 'app-ofertas',
  templateUrl: './ofertas.component.html',
  styleUrls: ['./ofertas.component.css']
})
export class OfertasComponent implements OnInit {
  lista: Oferta[] = new Array<Oferta>();
  titulo: string = 'Listado de ofertas';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5,10,25,100];
  constructor(private service:OfertaService) { }

  ngOnInit(): void {
    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      p => {
        this.lista = p.content as Oferta[];
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