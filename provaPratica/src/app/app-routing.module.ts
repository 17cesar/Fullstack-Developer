import { PedidoFormComponent } from './views/pedido/pedido-form/pedido-form.component';
import { PedidoConsComponent } from './views/pedido/pedido-cons/pedido-cons.component';
import { ClienteFormComponent } from './views/cliente/cliente-form/cliente-form.component';
import { ClienteConsComponent } from './views/cliente/cliente-cons/cliente-cons.component';
import { HomeComponent } from './views/home/home.component';
import { PedidoComponent } from './views/pedido/pedido.component';
import { ProdutoComponent } from './views/produto/produto.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "cliente",
    component: ClienteConsComponent
  },
  {
    path: "clienteForm",
    component: ClienteFormComponent
  },

  {
    path: "clienteForm/:codigoCliente",
    component: ClienteFormComponent
  },
  
  {
    path: "produto",
    component: ProdutoComponent
  },
  {
    path: "pedido",
    component: PedidoConsComponent
  },
  {
    path: "pedidoForm",
    component: PedidoFormComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
