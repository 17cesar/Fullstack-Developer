import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';
import { HttpClientModule } from  '@angular/common/http'
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatSidenavModule } from '@angular/material/sidenav'
import { MatListModule } from '@angular/material/list'
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon'
import { MatInputModule } from '@angular/material/input'
import { MatMenuModule}  from '@angular/material/menu'
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { ClienteComponent } from './views/cliente/cliente.component';
import { ProdutoComponent } from './views/produto/produto.component';
import { PedidoComponent } from './views/pedido/pedido.component';
import { HomeComponent } from './views/home/home.component';
import { RouterModule } from '@angular/router';
import { ClienteConsComponent } from './views/cliente/cliente-cons/cliente-cons.component';
import { ClienteFormComponent } from './views/cliente/cliente-form/cliente-form.component';
import { MatDividerModule } from '@angular/material/divider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatGridListModule } from '@angular/material/grid-list';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { PedidoConsComponent } from './views/pedido/pedido-cons/pedido-cons.component';
import { PedidoFormComponent } from './views/pedido/pedido-form/pedido-form.component';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatSelectModule } from '@angular/material/select';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ClienteComponent,
    ProdutoComponent,
    PedidoComponent,
    HomeComponent,
    ClienteConsComponent,
    ClienteFormComponent,
    PedidoConsComponent,
    PedidoFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatNativeDateModule,
    RouterModule,
    MatCardModule,
    MatDividerModule,
    HttpClientModule,
    MatSnackBarModule,
    MatTableModule,
    MatRippleModule,
    MatGridListModule,
    FormsModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
