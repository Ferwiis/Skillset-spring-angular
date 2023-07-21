import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Profesor } from 'src/app/models/profesor';
import { ProfesorService } from 'src/app/services/profesor.service';

@Component({
  selector: 'app-profesors',
  templateUrl: './profesores.component.html',
  styleUrls: ['./profesores.component.css']
})
export class ProfesoresComponent implements OnInit {
  lista: Profesor[] = new Array<Profesor>();
  titulo: string = 'Listado de profesores';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5,10,25,100];
  constructor(private service:ProfesorService) { }

  ngOnInit(): void {
    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      p => {
        this.lista = p.content as Profesor[];
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
