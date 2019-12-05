import { Injectable } from '@angular/core';
import { Funcionario } from '../Modelos/Funcionario';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class FuncionarioService {

  constructor(private http: HttpClient) { }

  Url="http://localhost:8080/funcionario"

  getFuncionarios(){
    return this.http.get<Funcionario[]>(this.Url+"s");
  }

  createFuncionario(funcionario: Funcionario){
    return this.http.post<Funcionario>(this.Url,funcionario);
  }

  getFuncionarioId(cod: number){
    return this.http.get<Funcionario>(this.Url+"/"+cod);
  }

  updateFuncionario(funcionario: Funcionario){
    return this.http.put<Funcionario>(this.Url+"/"+funcionario.codFunc, funcionario);
  }

  deleteFuncionario(funcionario: Funcionario){
    console.log(funcionario.codFunc);
    return this.http.delete<Funcionario>(this.Url+"/"+funcionario.codFunc);
  }
}
