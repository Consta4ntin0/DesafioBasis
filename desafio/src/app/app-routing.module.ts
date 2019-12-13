import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FuncionarioComponent } from './Componentes/funcionario/funcionario.component';
import { EmpresasComponent } from './Componentes/empresas/empresas.component';
import { HomeComponent } from './Componentes/home/home.component';

const routes: Routes = [
  { path: "", component: HomeComponent,pathMatch:"full" }, 
  { path: "funcionarios", component: FuncionarioComponent},
  { path: "empresas", component: EmpresasComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
