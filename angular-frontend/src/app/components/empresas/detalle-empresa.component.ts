import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Empresa } from 'src/app/models/empresa';
import { EmpresaService } from 'src/app/services/empresa.service';

@Component({
  selector: 'app-detalle-empresa',
  templateUrl: './detalle-empresa.component.html',
  styleUrls: ['./detalle-empresa.component.css']
})
export class DetalleEmpresaComponent implements OnInit {
  titulo:string='Detalles Empresa';
  empresa: Empresa = new Empresa();
  constructor(private service: EmpresaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar(){
    this.route.params.subscribe(
      params=>{
        let id = params['id'];
        if(id){
          this.service.ver(id).subscribe((empresa)=> this.empresa=empresa);
        }
      }
    );
  }

}
