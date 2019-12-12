import { FuncionarioEndereco } from '../Modelos/FuncionarioEndereco';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Funcionario } from '../Modelos/Funcionario';
import { throwError } from 'rxjs';


@Injectable()
export class FuncionarioService {

  constructor(private http: HttpClient) { }

  Url = "http://localhost:8080/funcionario"

  getFuncionarios() {
    return this.http.get<Funcionario[]>(this.Url + "s");
  }

  createFuncionario(funcionario: FuncionarioEndereco){
    return this.http
      .post(this.Url,funcionario)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  getFuncionarioId(cod: number) {
    return this.http.get<Funcionario>(this.Url + "/" + cod);
  }

  updateFuncionario(funcionario: FuncionarioEndereco) {
    return this.http.put<Funcionario>(this.Url + "/" + funcionario.cod, funcionario);
  }

  deleteFuncionario(funcionario: Funcionario) {
    return this.http.delete<Funcionario>(this.Url + "/" + funcionario.cod);
  }

  handleError(error) {

    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
  
}