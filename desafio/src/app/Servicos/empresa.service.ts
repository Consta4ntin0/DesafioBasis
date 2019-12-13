import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
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
  getEmpresasDto(){  
    return this.http.get<Empresa[]>(this.Url+"sDto");
  }
  createEmpresa(empresa: Empresa){
    return this.http.post<Empresa>(this.Url,empresa)
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  getEmpresaId(cod: number){
    return this.http.get<Empresa>(this.Url+"/"+cod);
  }

  updateEmpresa(empresa: Empresa){
    return this.http.put<Empresa>(this.Url+"/"+empresa.cod, empresa)
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  deleteEmpresa(empresa: Empresa){
    return this.http.delete<Empresa>(this.Url+"/"+empresa.cod);
  }
  handleError(error) {
    console.log(error);
    
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error: ${error.status}\nMessage: ${error.error.errorMessage}`;

    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
