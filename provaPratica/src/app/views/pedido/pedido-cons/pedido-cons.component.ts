import { Pedido } from './../../../components/pedido/pedido.model';
import { Router } from '@angular/router';
import { PedidoService } from './../../../components/pedido/pedido.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pedido-cons',
  templateUrl: './pedido-cons.component.html',
  styleUrls: ['./pedido-cons.component.css']
})
export class PedidoConsComponent implements OnInit {

  
  pedidos: Pedido[]
  displayedColumns = ['codigoPedido','valorTotalPedido' , 'quantidadeProdutos','valorFreteUnitario']

  constructor(private pedidoService: PedidoService , private route: Router) { }

  ngOnInit(): void {
    this.pedidoService.listaPedido().subscribe(pedido => {
      this.pedidos = pedido
    }) 
  }

}
