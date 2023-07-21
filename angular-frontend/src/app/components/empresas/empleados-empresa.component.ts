import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute } from '@angular/router';
import { Empleado } from 'src/app/models/empleado';
import { EmpresaService } from 'src/app/services/empresa.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados-empresa.component.html',
  styleUrls: ['./empleados-empresa.component.css']
})
export class EmpleadosEmpresaComponent implements OnInit {
  lista: Empleado[] = new Array<Empleado>();
  titulo: string = 'Listado de empleados de la empresa';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  id_empresa: number = 0;
  constructor(private service:EmpresaService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
    this.calcularRangos();
  }

  consultar() {
    this.route.params.subscribe(
      params => {
        let id = params['id'];
        if (id) {
          this.id_empresa = id;
        }
      }
    );
  }

  private calcularRangos() {
    this.service.listarEmpleadosPagina(this.paginaActual.toString(), this.totalPorPagina.toString(),this.id_empresa ).subscribe(
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
