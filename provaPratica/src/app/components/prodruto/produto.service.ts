import { Produto } from './produto.model';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  urlApi =  "/api/produto"


  constructor(private http: HttpClient , private snackBar: MatSnackBar) { }

  listaProduto(): Observable<Produto[]>{    
    return this.http.get<Produto[]>(this.urlApi)
  }

  
  consultarPorCodigo(codigo: string): Observable<Produto>{
    const url = `${this.urlApi}/${codigo}`    
    return this.http.get<Produto>(url)
  }

}
