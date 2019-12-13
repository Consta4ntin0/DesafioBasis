import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { EmpresaService } from './../../../Servicos/empresa.service';
import { Empresa } from './../../../Modelos/Empresa';

@Component({
  selector: 'app-empresa-form',
  templateUrl: './empresa-form.component.html',
  styleUrls: ['./empresa-form.component.css']
})

export class EmpresaFormComponent implements OnInit {
  empresa: Empresa = new Empresa;
  oculto = false;
  constructor(private empresaService: EmpresaService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(valor => {
      if (valor['cod']) {
        this.carregaDados(Number(valor['cod']));
      }
    });
  }

  carregaDados(cod: number) {
    this.empresaService.getEmpresaId(cod).subscribe(valor => {
      this.empresa = valor;
    }
    )
  }

  guardar(empresa: Empresa) {
    if (!empresa.cod) {
      this.empresaService.createEmpresa(empresa).subscribe(() => {
        alert("Empresa adicionada com sucesso!")

        this.router.navigate(["empresas"]);
      });
    } else {
      this.empresaService.updateEmpresa(empresa).subscribe(() => {
        alert("Empresa editada com sucesso!")
        this.router.navigate(["empresas"])
      });
    }
  }

  enviar(empresa: Empresa) {
    if (!empresa.nome || !empresa.cnpj || !empresa.endereco) {
      alert("preencha os campos corretamente");
    } else if (empresa.cnpj.length < 14) {
      alert("cnpj deve conter 14 digitos");
    } else {
      this.guardar(empresa);
    }
  }


}
