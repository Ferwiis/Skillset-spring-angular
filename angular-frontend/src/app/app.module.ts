import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientesComponent } from './components/externo/clientes/clientes.component';
import { ClienteFormComponent } from './components/externo/clientes/cliente-form.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { EmpresasComponent } from './components/empresas/empresas.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { OfertasComponent } from './components/ofertas/ofertas.component';
import { OfertasEmpleadoComponent } from './components/ofertas-empleado/ofertas-empleado.component';
import { CertificadosComponent } from './components/certificados/certificados.component';
import { ProfesoresComponent } from './components/profesores/profesores.component';
import { EmpleadoFormComponent } from './components/empleados/empleado-form.component';
import { ProfesoresFormComponent } from './components/profesores/profesores-form.component';
import { CursosFormComponent } from './components/cursos/cursos-form.component';
import { OfertasFormComponent } from './components/ofertas/ofertas-form.component';
import { OfertasEmpleadoFormComponent } from './components/ofertas-empleado/ofertas-empleado-form.component';
import { DetalleUsuarioComponent } from './components/usuarios/detalle-usuario.component';
import { EmpresaFormComponent } from './components/empresas/empresa-form.component';
import { DetalleEmpresaComponent } from './components/empresas/detalle-empresa.component';
import { DetalleEmpleadoComponent } from './components/empleados/detalle-empleado.component';
import { DetalleProfesorComponent } from './components/profesores/detalle-profesor.component';
import { DetalleOfertaComponent } from './components/ofertas/detalle-oferta.component';
import { DetalleCursoComponent } from './components/cursos/detalle-curso.component';
import { CursosEmpresaComponent } from './components/empresas/cursos-empresa.component';
import { DetalleCursoEmpresaComponent } from './components/empresas/detalle-curso-empresa.component';
import { CursosEmpleadoComponent } from './components/empleados/cursos-empleado.component';
import { DetalleCursoEmpleadoComponent } from './components/empleados/detalle-curso-empleado.component';
import { CursosProfesorComponent } from './components/profesores/cursos-profesor.component';
import { DetalleCursoProfesorComponent } from './components/profesores/detalle-curso-profesor.component';
import { EmpleadosEmpresaComponent } from './components/empresas/empleados-empresa.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    ClienteFormComponent,
    HomeComponent,
    UsuariosComponent,
    EmpresasComponent,
    EmpleadosComponent,
    CursosComponent,
    OfertasComponent,
    OfertasEmpleadoComponent,
    CertificadosComponent,
    ProfesoresComponent,
    EmpleadoFormComponent,
    ProfesoresFormComponent,
    CursosFormComponent,
    OfertasFormComponent,
    OfertasEmpleadoFormComponent,
    DetalleUsuarioComponent,
    EmpresaFormComponent,
    DetalleEmpresaComponent,
    DetalleEmpleadoComponent,
    DetalleProfesorComponent,
    DetalleOfertaComponent,
    DetalleCursoComponent,
    CursosEmpresaComponent,
    DetalleCursoEmpresaComponent,
    CursosEmpleadoComponent,
    DetalleCursoEmpleadoComponent,
    CursosProfesorComponent,
    DetalleCursoProfesorComponent,
    EmpleadosEmpresaComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatPaginatorModule,
    FlexLayoutModule,
    MatCardModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
