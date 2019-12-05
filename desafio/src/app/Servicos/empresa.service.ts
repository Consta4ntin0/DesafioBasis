import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empresa } from '../Modelos/Empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {
  constructor(private http: HttpClient) { }
  
  Url="http://localhost:8080/empresa"

  getEmpresas(){  
    return this.http.get<Empresa[]>(this.Url+"s");
  }

  createEmpresa(empresa: Empresa){
    return this.http.post<Empresa>(this.Url,empresa);
  }

  getEmpresaId(cod: number){
    return this.http.get<Empresa>(this.Url+"/"+cod);
  }

  updateEmpresa(empresa: Empresa){
    return this.http.put<Empresa>(this.Url+"/"+empresa.cod, empresa);
  }

  deleteEmpresa(empresa: Empresa){
    return this.http.delete<Empresa>(this.Url+"/"+empresa.cod);
  }
}
