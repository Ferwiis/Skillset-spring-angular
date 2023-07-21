import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Curso } from 'src/app/models/curso';
import { CursoService } from 'src/app/services/curso.service';

@Component({
  selector: 'app-detalle-curso',
  templateUrl: './detalle-curso.component.html',
  styleUrls: ['./detalle-curso.component.css']
})
export class DetalleCursoComponent implements OnInit {
  titulo:string='Detalles Curso';
  curso: Curso = new Curso();
  constructor(private service: CursoService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    console.log("/ * / * / WARNING / * / * /")
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((curso)=> this.curso=curso);
        }
      }
    );
  }

}
