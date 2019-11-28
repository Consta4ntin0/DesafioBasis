import { EmpresaFormComponent } from './empresa-form/empresa-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const empresaRoutes: Routes = [
    {path:'empresa', children:[
        { path:"novo", component: EmpresaFormComponent },
        {path:'editar', component: EmpresaFormComponent},
        
    ]},
    
];


@NgModule({
    imports:[RouterModule.forChild(empresaRoutes)],
    exports: [RouterModule]
})
export class EmpresaRoutingModule { }