import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Profesor } from 'src/app/models/profesor';
import { ProfesorService } from 'src/app/services/profesor.service';

@Component({
  selector: 'app-detalle-profesor',
  templateUrl: './detalle-profesor.component.html',
  styleUrls: ['./detalle-profesor.component.css']
})
export class DetalleProfesorComponent implements OnInit {
  titulo:string='Detalles Profesor';
  profesor: Profesor = new Profesor();
  constructor(private service: ProfesorService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((profesor)=> this.profesor=profesor);
        }
      }
    );
  }

}
