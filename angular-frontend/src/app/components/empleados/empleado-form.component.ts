import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from 'src/app/models/empleado';
import { Empresa } from 'src/app/models/empresa';
import { TipoIdentificacion } from 'src/app/models/tipo-identificacion';
import { EmpleadoService } from 'src/app/services/empleado.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-form',
  templateUrl: './empleado-form.component.html',
  styleUrls: ['./empleado-form.component.css'],
})
export class EmpleadoFormComponent implements OnInit {
  titulo: string = 'Formulario Empleado';
  empleado: Empleado = new Empleado();
  tiposID: TipoIdentificacion[] = [];
  listaEmpresas: Empresa[] = [];
  error: any;
  conf_contrasena: string = '';
  constructor(
    private service: EmpleadoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listar_empresas();
    this.listar_tipos_id();
    this.editar();
  }

  listar_tipos_id(): void {
    this.service
      .listar_tipos_id()
      .subscribe((tipos) => (this.tiposID = tipos as TipoIdentificacion[]));
  }

  listar_empresas(): void {
    this.service
      .listar_empresas()
      .subscribe((empresas) => this.listaEmpresas = empresas as Empresa[]);
  }

  crear() {
    this.service.crear(this.empleado).subscribe(
      (empleado) => {
        Swal.fire(
          'Crear Empleado',
          `El empleado ${empleado.nombre} ${empleado.apellido} se ha creado exitosamente`,
          'success'
        );
        this.router.navigate(['/empleados']);
      },
      (err) => {
        if (err.status === 400) {
          this.error = err.error;
        }
      }
    );
  }

  editar(): void {
    this.route.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        this.service
          .ver(id)
          .subscribe((empleado) => (this.empleado = empleado));
      }
    });
  }

  modificar() {
    this.service.modificar(this.empleado).subscribe(
      (empleado) => {
        Swal.fire(
          'Adicionar Empleado',
          `El empleado ${empleado.nombre} ${empleado.apellido} se ha modificado exitosamente`,
          'success'
        );
        this.router.navigate(['/empleados']);
      },
      (err) => {
        if (err.status === 400) {
          this.error = err.error;
        }
      }
    );
  }
}
