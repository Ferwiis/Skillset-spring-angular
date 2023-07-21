import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {
  lista: Empleado[] = new Array<Empleado>();
  titulo: string = 'Listado de empleados';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5,10,25,100];
  constructor(private service:EmpleadoService) { }

  ngOnInit(): void {
    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      p => {
        this.lista = p.content as Empleado[];
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
