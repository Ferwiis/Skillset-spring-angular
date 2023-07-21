import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { Oferta } from 'src/app/models/oferta';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-cursos-empleado',
  templateUrl: './cursos-empleado.component.html',
  styleUrls: ['./cursos-empleado.component.css']
})
export class CursosEmpleadoComponent implements OnInit {
  id_empresa: number = 0;
  lista: Oferta[] = new Array<Oferta>();
  titulo: string = 'Cursos del empleado';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  ruta_actual: string = '';
  constructor(private service: EmpleadoService, private router: Router, private route: ActivatedRoute) {
    this.ruta_actual = router.url;
  }

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
    this.service.listarCursosPagina(this.paginaActual.toString(), this.totalPorPagina.toString(), this.id_empresa).subscribe(
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