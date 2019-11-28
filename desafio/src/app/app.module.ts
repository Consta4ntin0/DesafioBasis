import { EmpresaModule } from './Componentes/empresas/empresas.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Componentes/navbar/navbar.component';
import { EmpresasComponent } from './Componentes/empresas/empresas.component';
import { HomeComponent } from './Componentes/home/home.component';
import { FuncionarioModule } from './Componentes/funcionario/funcionario.module';
import { EmpresaFormComponent } from './Componentes/empresas/empresa-form/empresa-form.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FuncionarioModule,
    FormsModule,
    EmpresaModule

  ],
  providers: [],
  bootstrap: [AppComponent],
})

export class AppModule { 
  
}
