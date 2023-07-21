import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Curso } from 'src/app/models/curso';
import { EmpresaService } from 'src/app/services/empresa.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-detalle-curso-empresa',
  templateUrl: './detalle-curso-empresa.component.html',
  styleUrls: ['./detalle-curso-empresa.component.css'],
})
export class DetalleCursoEmpresaComponent implements OnInit {
  titulo: string = 'Detalles Curso';
  curso: Curso = new Curso();
  constructor(
    private service: EmpresaService,
    private router: Router,
    private route: ActivatedRoute,
    private _location: Location
  ) {}

  ngOnInit(): void {
    this.consultar();
  }

  volver_pagina_anterior(): void {
    this._location.back();
  }

  consultar() {
    this.route.params.subscribe((params) => {
      let id = params['id_curso'];
      if (id) {
        this.service.ver_curso(id).subscribe((curso) => (this.curso = curso));
      }
    });
  }
}
