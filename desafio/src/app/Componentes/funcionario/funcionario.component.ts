import { EmpresaService } from './../../Servicos/empresa.service';
import { FuncionarioService } from './../../Servicos/funcionario.service';
import { Empresa } from './../../Modelos/Empresa';

import { Funcionario } from './../../Modelos/Funcionario';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {
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
      console.log(this.funcionarios);
    });
  }
  add(){
    this.router.navigate(['funcionario/novo']);
  }

  deletar(func:Funcionario){
    console.log(func); 
    this.funcionarioService.deleteFuncionario(func).subscribe();
    window.location.reload();
  }

  editar(func:any){
    console.log(func);
    localStorage.setItem("cod", func.cod);
    this.router.navigate(['funcionario/editar']);
  }
  carregaEmp(){
    this.service.getEmpresas().subscribe( valor => {
        this.empresas = valor;
      }
    )
  }

  

  

}
