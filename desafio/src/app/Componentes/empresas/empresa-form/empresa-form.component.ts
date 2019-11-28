import { EmpresaService } from './../../../Servicos/empresa.service';
import { Empresa } from './../../../Modelos/Empresa';
import { Subscription } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empresa-form',
  templateUrl: './empresa-form.component.html',
  styleUrls: ['./empresa-form.component.css']
})
export class EmpresaFormComponent implements OnInit {
  empresa:Empresa = new Empresa();
  oculto = false;
  inscricao: Subscription;
  constructor(private empresaService:EmpresaService, private router:Router) { }

  ngOnInit() {
    var cod = parseInt(localStorage.getItem('cod'));
    localStorage.clear();
    if (!isNaN(cod)) {
      this.empresaService.getEmpresaId(cod).subscribe(valor => {
        this.empresa = valor;
      });
    }
  }

  guardar(empresa: Empresa) {
    if (empresa.cod == undefined) {
      this.empresaService.createEmpresa(empresa).subscribe(value => {
        alert("Empresa adicionada com sucesso!")
        this.router.navigate(["empresas"]);
      });
    } else {
      this.empresaService.updateEmpresa(empresa).subscribe(value => {
        alert("Empresa editada com sucesso!")
        this.router.navigate(["empresas"])
      });
      }
  }

    enviar(id: number, nome: String, cnpj:string, endereco:String) {
      if (nome == undefined && cnpj == undefined && endereco == undefined) {
        alert("preencha os campos corretamente")
      } else if (cnpj.length < 4) {
        alert("cnpj deve ter 4 digitos")
      } else {
        if (id != 0) {
          this.empresa = new Empresa(id, nome, cnpj, endereco);
          this.guardar(this.empresa)
        } else {
          this.empresa = new Empresa(null, nome, cnpj, endereco);
          this.guardar(this.empresa)
        }
      }
    }

}
