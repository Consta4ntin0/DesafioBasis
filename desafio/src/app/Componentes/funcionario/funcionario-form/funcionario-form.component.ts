import { Component, OnInit, ViewChild, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { FuncionarioService } from 'src/app/Servicos/funcionario.service';
import { Funcionario } from 'src/app/Modelos/Funcionario';
import { Empresa } from 'src/app/Modelos/Empresa';
import { EmpresaService } from 'src/app/Servicos/empresa.service';
import { Validators } from '@angular/forms';
import { HttpRequest, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'funcionarioForm',
  templateUrl: './funcionario-form.component.html',
  styleUrls: ['./funcionario-form.component.css']
})
export class FuncionarioFormComponent implements OnInit {
  funcionario: any = {};
  empresas: Empresa[] = [];
  oculto = false;
  id: number;
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
    this.service.getEmpresas().subscribe(valor => {
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

  enviar(funcionario: any) {
    if (!funcionario.nomeFunc && !funcionario.cpfFunc && !funcionario.dataNascimentoFunc) {
      alert("preencha os campos")
    } else {
      if (!funcionario.codFunc) {
        this.funcionarioService.createFuncionario(funcionario).subscribe(value => {
          alert("Funcionario adicionado com sucesso!")
          this.router.navigate(["funcionarios"]);
        });
      } else {
        this.funcionarioService.updateFuncionario(funcionario).subscribe(value => {
          alert("Funcionario editado com sucesso!")
          this.router.navigate(["funcionarios"])
        });
      }
    }
  }

}


