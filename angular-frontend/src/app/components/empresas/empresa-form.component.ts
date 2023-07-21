import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empresa } from 'src/app/models/empresa';
import { TipoIdentificacion } from 'src/app/models/tipo-identificacion';
import { EmpresaService } from 'src/app/services/empresa.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empresa-form',
  templateUrl: './empresa-form.component.html',
  styleUrls: ['./empresa-form.component.css']
})
export class EmpresaFormComponent implements OnInit {
  titulo:string='Formulario Empresa';
  empresa: Empresa = new Empresa();
  tiposID: TipoIdentificacion[] = [];
  error: any;
  conf_contrasena: string = '';
  constructor(private service: EmpresaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.listar_tipos_id();
    this.editar();
  }

  listar_tipos_id(): void {
    this.service.listar_tipos_id().subscribe((tipos)=>this.tiposID = tipos as TipoIdentificacion[]);
  }

  crear(){
    this.service.crear(this.empresa).subscribe(
      empresa => {
        Swal.fire('Crear Empresa', `La empresa ${empresa.razon_social} se ha creado exitosamente`, 'success');
        this.router.navigate(['/empresas']);
      }, err => {
        if (err.status === 400) {
          this.error = err.error;
        }
      }
    );
  }

  editar():void{
    this.route.params.subscribe(params =>{
      let id = params['id'];
      if(id){
        this.service.ver(id).subscribe((empresa)=> this.empresa=empresa);
      }
    });
  }

  modificar(){
    this.service.modificar(this.empresa).subscribe(
      empresa => {
        Swal.fire('Adicionar Empresa', `La empresa ${empresa.razon_social} se ha modificado exitosamente`, 'success');
        this.router.navigate(['/empresas']);
      }, err => {
        if (err.status === 400) {
          this.error = err.error;
        }
      }
    );
  }
}
