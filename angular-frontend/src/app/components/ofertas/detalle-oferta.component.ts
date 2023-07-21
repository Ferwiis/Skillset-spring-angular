import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Oferta } from 'src/app/models/oferta';
import { OfertaService } from 'src/app/services/oferta.service';

@Component({
  selector: 'app-detalle-oferta',
  templateUrl: './detalle-oferta.component.html',
  styleUrls: ['./detalle-oferta.component.css']
})
export class DetalleOfertaComponent implements OnInit {
  titulo:string='Detalles Oferta';
  oferta: Oferta = new Oferta();
  constructor(private service: OfertaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((oferta)=> this.oferta=oferta);
        }
      }
    );
  }
}
