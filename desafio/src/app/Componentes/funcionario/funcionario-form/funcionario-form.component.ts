import { FuncionarioEndereco } from '../../../Modelos/FuncionarioEndereco';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { FuncionarioService } from 'src/app/Servicos/funcionario.service';
import { Funcionario } from 'src/app/Modelos/Funcionario';
import { Empresa } from 'src/app/Modelos/Empresa';
import { EmpresaService } from 'src/app/Servicos/empresa.service';

@Component({
  selector: 'funcionarioForm',
  templateUrl: './funcionario-form.component.html',
  styleUrls: ['./funcionario-form.component.css']
})
export class FuncionarioFormComponent implements OnInit {
  funcionario: any = {};
  funcionarioEnd: FuncionarioEndereco = new FuncionarioEndereco;
  empresas: Empresa[] = [];
  oculto = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private funcionarioService: FuncionarioService,
    private service: EmpresaService) { }

  ngOnInit() {
    this.route.params.subscribe(valor => {
      console.log("asdasdasd"+valor['cod']);
      
      if (valor['cod']) {
        this.carregaDadosFunc(Number(valor['cod']));
      }
    })
    this.carregaDados();
  }

  carregaDados() {
    this.service.getEmpresasDto().subscribe(valor => {
      this.empresas = valor;
     // console.log(valor);
    }
    )
  }

  carregaDadosFunc(id: number) {
    this.funcionarioService.getFuncionarioId(id).subscribe(valor => {
      this.funcionario = valor;
      console.log(valor);
      
    }
    )
  }

  enviar(funcionario: FuncionarioEndereco) {
    if (!funcionario.nome && !funcionario.cpf && !funcionario.dataNascimento
      && !funcionario.cidade && !funcionario.bairro && !funcionario.numero && !funcionario.pais
      && !funcionario.rua && !funcionario.uf) {
      alert("preencha os campos")
    } else {
      if (!funcionario.cod) {
        console.log(funcionario);
        //
        this.funcionarioService.createFuncionario(funcionario)
        .subscribe(() => {
          console.log("log subscribe");
          
          alert("Funcionario adicionado com sucesso!")
          this.router.navigate(["funcionarios"]);
        });
        console.log("ultimo log");
        
      } else {
        this.funcionarioService.updateFuncionario(funcionario).subscribe(
          () => {
          alert("Funcionario editado com sucesso!")
          this.router.navigate(["funcionarios"]) 
        });
      }
    }
  }
}


