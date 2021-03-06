import { PaginaInexistenteComponent } from './../../componentes/pagina-inexistente/pagina-inexistente.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FuncionarioFormComponent } from './funcionario-form/funcionario-form.component';

const funcionarioRoutes: Routes = [
    {path:'funcionario', children:[
        { path:":novo", component: FuncionarioFormComponent }  ,
        {path:':editar/:cod', component: FuncionarioFormComponent}, 
    ]},
];

@NgModule({
    imports:[RouterModule.forChild(funcionarioRoutes)],
    exports: [RouterModule]
})
export class FuncionarioRoutingModule { }