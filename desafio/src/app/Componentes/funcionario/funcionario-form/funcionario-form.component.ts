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
  empresas: Empresa[] = [];
  oculto = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private funcionarioService: FuncionarioService,
    private service: EmpresaService) { }

  ngOnInit() {
    this.route.params.subscribe(valor => {
      if (valor['codFunc']) {
        this.carregaDadosFunc(Number(valor['codFunc']));
      }
    })
    this.carregaDados();
  }

  carregaDados() {
    this.service.getEmpresasDto().subscribe(valor => {
      this.empresas = valor;
    }
    )
  }

  carregaDadosFunc(id: number) {
    this.funcionarioService.getFuncionarioId(id).subscribe(valor => {
      this.funcionario = valor;
    }
    )
  }

  enviar(funcionario: Funcionario) {
    if (!funcionario.nomeFunc && !funcionario.cpfFunc && !funcionario.dataNascimentoFunc) {
      alert("preencha os campos")
    } else {
      if (!funcionario.codFunc) {
        this.funcionarioService.createFuncionario(funcionario).subscribe(() => {
          alert("Funcionario adicionado com sucesso!")
          this.router.navigate(["funcionarios"]);
        });
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


