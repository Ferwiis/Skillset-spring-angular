import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CertificadosComponent } from './components/certificados/certificados.component';
import { CursosFormComponent } from './components/cursos/cursos-form.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { DetalleCursoComponent } from './components/cursos/detalle-curso.component';
import { CursosEmpleadoComponent } from './components/empleados/cursos-empleado.component';
import { DetalleCursoEmpleadoComponent } from './components/empleados/detalle-curso-empleado.component';
import { DetalleEmpleadoComponent } from './components/empleados/detalle-empleado.component';
import { EmpleadoFormComponent } from './components/empleados/empleado-form.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { CursosEmpresaComponent } from './components/empresas/cursos-empresa.component';
import { DetalleCursoEmpresaComponent } from './components/empresas/detalle-curso-empresa.component';
import { DetalleEmpresaComponent } from './components/empresas/detalle-empresa.component';
import { EmpleadosEmpresaComponent } from './components/empresas/empleados-empresa.component';
import { EmpresaFormComponent } from './components/empresas/empresa-form.component';
import { EmpresasComponent } from './components/empresas/empresas.component';
import { ClienteFormComponent } from './components/externo/clientes/cliente-form.component';
import { ClientesComponent } from './components/externo/clientes/clientes.component';
import { HomeComponent } from './components/home/home.component';
import { OfertasEmpleadoFormComponent } from './components/ofertas-empleado/ofertas-empleado-form.component';
import { OfertasEmpleadoComponent } from './components/ofertas-empleado/ofertas-empleado.component';
import { DetalleOfertaComponent } from './components/ofertas/detalle-oferta.component';
import { OfertasFormComponent } from './components/ofertas/ofertas-form.component';
import { OfertasComponent } from './components/ofertas/ofertas.component';
import { CursosProfesorComponent } from './components/profesores/cursos-profesor.component';
import { DetalleCursoProfesorComponent } from './components/profesores/detalle-curso-profesor.component';
import { DetalleProfesorComponent } from './components/profesores/detalle-profesor.component';
import { ProfesoresFormComponent } from './components/profesores/profesores-form.component';
import { ProfesoresComponent } from './components/profesores/profesores.component';
import { DetalleUsuarioComponent } from './components/usuarios/detalle-usuario.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'usuarios/detalle/:id', component: DetalleUsuarioComponent },
  { path: 'empresas', component: EmpresasComponent },
  { path: 'empresas/:id/empleados', component: EmpleadosEmpresaComponent },
  { path: 'empresas/detalle/:id', component: DetalleEmpresaComponent },
  { path: 'empresas/:id/mis_cursos', component: CursosEmpresaComponent },
  { path: 'empresas/:id/mis_cursos/curso/:id_curso', component: DetalleCursoEmpresaComponent },
  { path: 'empresas/form', component: EmpresaFormComponent },
  { path: 'empresas/form/:id', component: EmpresaFormComponent },
  { path: 'empleados', component: EmpleadosComponent },
  { path: 'empleados/detalle/:id', component: DetalleEmpleadoComponent },
  { path: 'empleados/:id/mis_cursos', component: CursosEmpleadoComponent },
  { path: 'empleados/:id/mis_cursos/curso/:id_curso', component: DetalleCursoEmpleadoComponent },
  { path: 'empleados/form', component: EmpleadoFormComponent },
  { path: 'empleados/form/:id', component: EmpleadoFormComponent },
  { path: 'profesores', component: ProfesoresComponent },
  { path: 'profesores/detalle/:id', component: DetalleProfesorComponent },
  { path: 'profesores/:id/mis_cursos', component: CursosProfesorComponent },
  { path: 'profesores/:id/mis_cursos/curso/:id_curso', component: DetalleCursoProfesorComponent },
  { path: 'profesores/form', component: ProfesoresFormComponent },
  { path: 'profesores/form/:id', component: ProfesoresFormComponent },
  { path: 'cursos', component: CursosComponent },
  { path: 'cursos/detalle/:id', component: DetalleCursoComponent },
  { path: 'cursos/form', component: CursosFormComponent },
  { path: 'cursos/form/:id', component: CursosFormComponent },
  { path: 'ofertas', component: OfertasComponent },
  { path: 'ofertas/detalle/:id', component: DetalleOfertaComponent },
  { path: 'ofertas/form', component: OfertasFormComponent },
  { path: 'ofertas/form/:id', component: OfertasFormComponent },
  { path: 'ofertasempleado', component: OfertasEmpleadoComponent },
  { path: 'ofertasempleado/form', component: OfertasEmpleadoFormComponent },
  { path: 'ofertasempleado/form/:id', component: OfertasEmpleadoFormComponent },
  { path: 'certificados', component: CertificadosComponent },
  { path: 'clientes', component: ClientesComponent },
  { path: 'clientes/form', component: ClienteFormComponent },
  { path: 'clientes/form/:id', component: ClienteFormComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
