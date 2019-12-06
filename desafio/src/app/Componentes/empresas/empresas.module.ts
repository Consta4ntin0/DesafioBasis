import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { EmpresaService } from './../../Servicos/empresa.service';
import { EmpresaRoutingModule } from './empresas.routing.module';
import { EmpresaFormComponent } from './empresa-form/empresa-form.component';
import { EmpresasComponent } from './empresas.component';


@NgModule({
  declarations: [
    EmpresaFormComponent,
    EmpresasComponent
  ],
  imports: [
    CommonModule,  
    EmpresaRoutingModule,
    FormsModule
  ],
  providers:[EmpresaService, ]  
})
export class EmpresaModule { }
