import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { FuncionarioService } from 'src/app/Servicos/funcionario.service';
import { Funcionario } from 'src/app/Modelos/Funcionario';
import { Empresa } from 'src/app/Modelos/Empresa';
import { EmpresaService } from 'src/app/Servicos/empresa.service';

@Component({
  selector: 'app-funcionario-form',
  templateUrl: './funcionario-form.component.html',
  styleUrls: ['./funcionario-form.component.css']
})
export class FuncionarioFormComponent implements OnInit {
  funcionario: Funcionario = new Funcionario();
  inscricao: Subscription;
  empresas: Empresa[] = [];
  oculto = false;
  constructor(private router: Router,
    private funcionarioService: FuncionarioService,
    private service: EmpresaService) { }

  ngOnInit() {
    var cod = parseInt(localStorage.getItem('cod'));
    localStorage.clear();
    if (!isNaN(cod)) {
      this.funcionarioService.getFuncionarioId(cod).subscribe(valor => {
        this.funcionario = valor;
      });
    }
    this.carregaDados();

  }

  carregaDados() {
    this.service.getEmpresas().subscribe(valor => {
      this.empresas = valor;
    }
    )
  }


  guardar(funcionario: Funcionario) {
    if (funcionario.cod == undefined) {
      this.funcionarioService.createFuncionario(funcionario).subscribe(value => {
        alert("Funcionario adicionado com sucesso!")
        this.router.navigate(["funcionarios"]);
      })
    } else {
      this.funcionarioService.updateFuncionario(funcionario).subscribe(value => {
        alert("Funcionario editado com sucesso!")
        this.router.navigate(["funcionarios"])
      })
    }
  }

  parseEmpresaId(nome: String) {
    let i = 0;
    while (i < this.empresas.length) {
      if (nome === this.empresas[i].nome) {
        return this.empresas[i].cod;
      }
      i++;
    }
    alert("selecione uma empresa")
  }

  enviar(id: number, nome: String, data: Date, cpf: string, empresa: string) {
    if ( nome == "" || data == undefined|| cpf == "" || empresa == "") {
      alert("preencha os campos corretamente")
    } else if (cpf.length < 11) {
      alert("cpf deve ter 11 digitos")
    } else {
      if (id != 0) {
        let i = this.parseEmpresaId(empresa);
        //console.log(i)
        this.funcionario = new Funcionario(id, nome, data, cpf, i);
        this.guardar(this.funcionario)
      } else {
        let i = this.parseEmpresaId(empresa);
        this.funcionario = new Funcionario(null, nome, data, cpf, i);
        this.guardar(this.funcionario)
      }
    }
  }
}


