import { Empresa } from './../../Modelos/Empresa';
import { Component, OnInit } from '@angular/core';
import { EmpresaService } from 'src/app/Servicos/empresa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {
  empresas:Empresa[] = [];

  constructor(private service:EmpresaService, private router:Router) { }

  ngOnInit() {
    this.carregaDados();
  }

  carregaDados(){
    this.service.getEmpresas().subscribe( valor => {
        this.empresas = valor;
      }
    )
  }

  editar(emp:any){
    localStorage.setItem("cod", emp.cod);
    this.router.navigate(['empresa/editar']);
  }

  add(){
    this.router.navigate(['empresa/novo']);
  }

  deletar(emp:Empresa){
    this.service.deleteEmpresa(emp).subscribe();
    window.location.reload();
  }

}
