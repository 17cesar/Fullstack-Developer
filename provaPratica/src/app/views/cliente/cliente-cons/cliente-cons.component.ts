import { ClienteService } from './../../../components/cliente/cliente.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/components/cliente/cliente.model';


@Component({
  selector: 'app-cliente-cons',
  templateUrl: './clienteCons.component.html',
  styleUrls: ['./clienteCons.component.css']
})
export class ClienteConsComponent implements OnInit {


  clientes: Cliente[]

  teste: Cliente

  displayedColumns = ['codigoCliente','nome' , 'id']

  constructor(private clienteService: ClienteService , private route: Router) { }

  ngOnInit(): void {
    this.clienteService.listaCliente().subscribe(cliente => {
      this.clientes = cliente
    }) 
  }
  
}
