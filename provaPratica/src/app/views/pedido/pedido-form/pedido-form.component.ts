import { Router } from '@angular/router';
import { PedidoService } from './../../../components/pedido/pedido.service';
import { Pedido } from './../../../components/pedido/pedido.model';
import { FormControl } from '@angular/forms';
import { ProdutoService } from './../../../components/prodruto/produto.service';
import { Produto } from './../../../components/prodruto/produto.model';
import { ItensPedido } from './../../../components/pedido/itensPedido.model';
import { ClienteService } from './../../../components/cliente/cliente.service';
import { Cliente } from 'src/app/components/cliente/cliente.model';
import { Component, OnInit, NgModule } from '@angular/core';

@Component({
  selector: 'app-pedido-form',
  templateUrl: './pedido-forma.component.html',
  styleUrls: ['./pedido-forma.component.css']
})
export class PedidoFormComponent implements OnInit {

  constructor(private route: Router ,private pedidoService: PedidoService,private clienteService: ClienteService , private produtoService: ProdutoService) { }

  clientes: Cliente[];
  itensPedido: ItensPedido[];
  produtoTemporario: any = {};
  itemProduto: ItensPedido;
  objTemporarrio: any = {}; 
  produtos: Produto[];
  carrinhoVazio: Boolean;
  pedido: Pedido;

  ngOnInit() {
    this.clienteService.listaCliente().subscribe(cliente => {
      this.clientes = cliente
    });
    this.produtoService.listaProduto().subscribe(produto => {
      this.produtos = produto
    });
    this.itensPedido = []
    this.carrinhoVazio = true
    this.iniciarPedido()
  }

  teste(obj:Produto):void{   
    
     if(obj.imagemUrl == null || obj.imagemUrl == ''){
        obj.imagemUrl = 'assets/img/produtoSemImagem.jpg';
     }     
    this.produtoTemporario = obj;   
    var itemPedidoTemporario = {      
      codigo_ItemPedido: 0,	
      pedido: 0,
      produto: obj,	
      quantidadeProduto: 1,	
      valorTotalItem: obj.precoUnitario,
 
    }
    this.objTemporarrio = itemPedidoTemporario;
    this.itemProduto = this.objTemporarrio;
    this.carrinhoVazio = false
    this.itensPedido.unshift(this.itemProduto);  
    this.calcularValorTotal();  
    
  }

  retirarItemCarrinho(obj:ItensPedido):void{
    this.itensPedido.splice(this.itensPedido.indexOf(obj), 1);
    if(this.itensPedido.length == 0){
      this.carrinhoVazio = true;
    }    
    this.calcularValorTotal();
  }

  calcularValorTotalItem(obj:ItensPedido):void{    
    
    this.itensPedido.filter(
      a=> this.itensPedido.indexOf(a) == this.itensPedido.indexOf(obj)
    ).forEach(
      b=> b.valorTotalItem = (b.produto.precoUnitario * obj.quantidadeProduto)
    );
    this.calcularValorTotal();
    
  }

  calcularValorTotal():void{    
    this.pedido.valorTotalPedido = 0;
    this.itensPedido.map(a=> this.pedido.valorTotalPedido = (a.valorTotalItem + this.pedido.valorTotalPedido))
  }

  iniciarPedido():void{
    var pedido = {      
      codigoPedido: null,
      cliente: null,
      frete: 0,
      valorTotalPedido: 0, 
      quantidadeProdutos: 0,
      valorFreteUnitario: 0,
      itensPedidos: null 
    }
    this.pedido = pedido;
  }  

  finalizarPedido():void{
    if(this.pedido.cliente != null){  
      this.pedido.itensPedidos = []   
      this.itensPedido.map(a=> this.pedido.itensPedidos.unshift(a))
      this.pedidoService.salvarPedido(this.pedido).subscribe(() => {
        this.pedidoService.showMessage("Pedido Criado")
        this.route.navigate(['./pedido'])
      })
    }else{
      this.pedidoService.showMessage("Cliente Não Informado")
    }

  }

  adicionarClientePedido(obj:Cliente):void{
      this.pedido.cliente = obj;
  }

}
