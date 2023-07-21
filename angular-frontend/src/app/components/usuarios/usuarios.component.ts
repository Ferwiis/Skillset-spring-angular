import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  lista: Usuario[] = new Array<Usuario>();
  titulo: string = 'Listado de usuarios';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5,10,25,100];
  constructor(private service:UsuarioService) { }

  ngOnInit(): void {
    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(
      p => {
        this.lista = p.content as Usuario[];
        this.totalRegistros = p.totalElements as number;
      }
    );
  }

  paginar(event:PageEvent):void {
    this.paginaActual = event.pageIndex;
    this.totalPorPagina = event.pageSize;
    this.calcularRangos();
  }

  activar(usuario:Usuario): void {
    Swal.fire({
      title: 'Activar cuenta de usuario',
      text: `¿Está seguro de activar la cuenta del usuario ${usuario.nickname}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.activar(usuario).subscribe(() => {
          //this.lista = this.lista?.filter(c => c!==usuario);
          this.calcularRangos();
          Swal.fire('Activar cuenta de usuario', `Se activó la cuenta del usuario ${usuario.nickname} correctamente`,'success');
        });
      }
    })
  }

  desactivar(usuario: Usuario): void {
    Swal.fire({
      title: 'Desactivar cuenta de usuario',
      text: `¿Está seguro de desactivar la cuenta del usuario ${usuario.nickname}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.desactivar(usuario).subscribe(() => {
          //this.lista = this.lista?.filter(c => c!==usuario);
          this.calcularRangos();
          Swal.fire('Desactivar cuenta de usuario', `Se desactivó la cuenta del usuario ${usuario.nickname} correctamente`,'success');
        });
      }
    })
  }

  eliminar(usuario:Usuario):void{ 
    Swal.fire({
      title: 'Eliminar Usuario',
      text: `¿Está seguro de eliminar al usuario ${usuario.nickname}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(usuario.id).subscribe(() => {
          //this.lista = this.lista?.filter(c => c!==usuario);
          this.calcularRangos();
          Swal.fire('Eliminar Usuario', `Se eliminó el usuario ${usuario.nickname}`,'success');
        });
      }
    })
  }
}
