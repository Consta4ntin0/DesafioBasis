import { EmpresaService } from './../../Servicos/empresa.service';
import { FuncionarioService } from './../../Servicos/funcionario.service';
import { Empresa } from './../../Modelos/Empresa';

import { Funcionario } from './../../Modelos/Funcionario';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { FuncionarioFormComponent } from './funcionario-form/funcionario-form.component';


@Component({
  selector: 'funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {
  @ViewChild('funcionarioForm',null) funcionarioForm:FuncionarioFormComponent;
  funcionarios: Funcionario[];
  funcionario: Funcionario;
  empresas:Empresa[];
  func:{
    nome:String
    dataN:Date;
    cpf:String;
    empresa:String;
  };
  

  constructor(private funcionarioService:FuncionarioService, private router: Router,private service:EmpresaService) { }

  ngOnInit() {
    this.carregaDados();
  }

  carregaDados(){
    this.funcionarioService.getFuncionarios().subscribe(valor => {
      this.funcionarios = valor;
    });
  }
  add(){
    this.router.navigate(['funcionario/novo']);
  }

  deletar(func:any){
    this.funcionarioService.deleteFuncionario(func).subscribe( () => {
      this.funcionarios = this.funcionarios.filter(funcionario => {
        return funcionario.codFunc !== func.codFunc;
      });
    });
  }

  editar(func:any){
    this.router.navigate(['funcionario/editar/',func.codFunc],);
  }
  
  carregaEmp(){
    this.service.getEmpresas().subscribe( valor => {
        this.empresas = valor;
      }
    )


  }

}
