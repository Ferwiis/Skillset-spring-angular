import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-detalle-usuario',
  templateUrl: './detalle-usuario.component.html',
  styleUrls: ['./detalle-usuario.component.css']
})
export class DetalleUsuarioComponent implements OnInit {
  titulo:string='Detalles Usuario';
  usuario: Usuario = new Usuario();
  constructor(private service: UsuarioService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((usuario)=> this.usuario=usuario);
        }
      }
    );
  }

}

