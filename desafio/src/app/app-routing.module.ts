import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FuncionarioComponent } from './Componentes/funcionario/funcionario.component';
import { EmpresasComponent } from './Componentes/empresas/empresas.component';
import { HomeComponent } from './Componentes/home/home.component';

const routes: Routes = [
  { path: "funcionarios", component: FuncionarioComponent},
  { path: "empresas", component: EmpresasComponent },
  { path: "", component: HomeComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
