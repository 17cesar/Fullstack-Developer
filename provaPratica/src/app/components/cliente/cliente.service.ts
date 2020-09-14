import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Cliente } from './cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient , private snackBar: MatSnackBar) { }

  urlApi =  "/api/cliente"

  salvarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.urlApi , cliente)
  }

  listaCliente(): Observable<Cliente[]>{    
    return this.http.get<Cliente[]>(this.urlApi)
  }

  consultarPorCodigo(codigo: string): Observable<Cliente>{
    const url = `${this.urlApi}/${codigo}`    
    return this.http.get<Cliente>(url)
  }

  showMessage(mensagem: string): void {
     this.snackBar.open(mensagem , 'X' , {
       duration: 3000,
       horizontalPosition: "right",
       verticalPosition: "top"
     })
  }
}
