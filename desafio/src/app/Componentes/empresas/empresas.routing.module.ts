import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EmpresaFormComponent } from './empresa-form/empresa-form.component';

const empresaRoutes: Routes = [
    {path:'empresa', children:[
        { path:"novo", component: EmpresaFormComponent },
        {path:'editar/:cod', component: EmpresaFormComponent},
    ]},
];


@NgModule({
    imports:[RouterModule.forChild(empresaRoutes)],
    exports: [RouterModule]
})
export class EmpresaRoutingModule { }