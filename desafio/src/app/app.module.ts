import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { EmpresaModule } from './Componentes/empresas/empresas.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Componentes/navbar/navbar.component';
import { HomeComponent } from './Componentes/home/home.component';
import { FuncionarioModule } from './Componentes/funcionario/funcionario.module';

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
