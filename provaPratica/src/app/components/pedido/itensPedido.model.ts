import { TestabilityRegistry } from '@angular/core';
import { Produto } from '../prodruto/produto.model';
import { Pedido } from './pedido.model';

export interface ItensPedido {
    codigo_ItemPedido: number;	
    pedido: Pedido;
    produto: Produto;	
	quantidadeProduto: number;	
    valorTotalItem: number;
  
}