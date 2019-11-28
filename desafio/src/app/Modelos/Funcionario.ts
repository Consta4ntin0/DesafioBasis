export class Funcionario {
    cod:number;
    nome:String;
    dataNascimento: Date;
    cpf: String;
    codEmpresa:number;
   
    constructor(cod?:number, nome?:String,dataNascimento?: Date, cpf?: String,codEmpresa?:number){
        this.cod = cod,
        this.nome = nome,
        this.dataNascimento = dataNascimento,
        this.cpf = cpf,
        this.codEmpresa = codEmpresa;
    };
    
}