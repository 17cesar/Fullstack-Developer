import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Pedido } from './pedido.model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient , private snackBar: MatSnackBar) { }

  urlApi =  "/api/pedido"

  salvarPedido(pedido:Pedido): Observable<Pedido> { 
    return this.http.post<Pedido>(this.urlApi , pedido)
  }

  listaPedido(): Observable<Pedido[]>{    
    return this.http.get<Pedido[]>(this.urlApi)
  }

  consultarPorCodigo(codigo: string): Observable<Pedido>{
    const url = `${this.urlApi}/${codigo}`    
    return this.http.get<Pedido>(url)
  }

  showMessage(mensagem: string): void {
     this.snackBar.open(mensagem , 'X' , {
       duration: 3000,
       horizontalPosition: "right",
       verticalPosition: "top"
     })
  }
}
