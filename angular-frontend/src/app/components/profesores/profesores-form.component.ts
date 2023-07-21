import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profesor } from 'src/app/models/profesor';
import { TipoIdentificacion } from 'src/app/models/tipo-identificacion';
import { ProfesorService } from 'src/app/services/profesor.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-profesor-form',
  templateUrl: './profesores-form.component.html',
  styleUrls: ['./profesores-form.component.css'],
})
export class ProfesoresFormComponent implements OnInit {
  titulo: string = 'Formulario Profesor';
  profesor: Profesor = new Profesor();
  tiposID: TipoIdentificacion[] = [];
  error: any;
  conf_contrasena: string = '';
  constructor(
    private service: ProfesorService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listar_tipos_id();
    this.editar();
  }

  listar_tipos_id(): void {
    this.service
      .listar_tipos_id()
      .subscribe((tipos) => (this.tiposID = tipos as TipoIdentificacion[]));
  }

  crear() {
    this.service.crear(this.profesor).subscribe(
      (profesor) => {
        Swal.fire(
          'Crear Profesor',
          `El profesor ${profesor.nombre} ${profesor.apellido} se ha creado exitosamente`,
          'success'
        );
        this.router.navigate(['/profesores']);
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
          .subscribe((profesor) => (this.profesor = profesor));
      }
    });
  }

  modificar() {
    this.service.modificar(this.profesor).subscribe(
      (profesor) => {
        Swal.fire(
          'Adicionar Profesor',
          `El profesor ${profesor.nombre} ${profesor.apellido} se ha modificado exitosamente`,
          'success'
        );
        this.router.navigate(['/profesors']);
      },
      (err) => {
        if (err.status === 400) {
          this.error = err.error;
        }
      }
    );
  }
}
