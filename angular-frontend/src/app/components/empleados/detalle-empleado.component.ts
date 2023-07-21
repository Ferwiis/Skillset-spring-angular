import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-detalle-empleado',
  templateUrl: './detalle-empleado.component.html',
  styleUrls: ['./detalle-empleado.component.css']
})
export class DetalleEmpleadoComponent implements OnInit {
  titulo:string='Detalles Empleado';
  empleado: Empleado = new Empleado();
  constructor(private service: EmpleadoService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((empleado)=> this.empleado=empleado);
        }
      }
    );
  }

}
