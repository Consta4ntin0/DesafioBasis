
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FuncionarioService } from 'src/app/Servicos/funcionario.service';
import { FuncionarioRoutingModule } from './funcionario.routing.module';
import { FuncionarioComponent } from './funcionario.component';
import { FuncionarioFormComponent } from './funcionario-form/funcionario-form.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    FuncionarioComponent,
    FuncionarioFormComponent
  ],
  imports: [
    CommonModule,  
    FuncionarioRoutingModule,
    FormsModule
  ],
  providers:[FuncionarioService, ]  
})
export class FuncionarioModule { }
