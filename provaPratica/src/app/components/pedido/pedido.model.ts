import { ItensPedido } from './itensPedido.model';
import { Cliente } from 'src/app/components/cliente/cliente.model';

export interface Pedido {
    codigoPedido: number
    cliente: Cliente
    frete: number
    valorTotalPedido: number 
    quantidadeProdutos: number
    valorFreteUnitario: number
    itensPedidos: ItensPedido[]
}