import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router ) { }

  ngOnInit(): void {
  }

  produto(): void {
    this.router.navigate(['/produto'])
  }

  cliente(): void {
    this.router.navigate(['/cliente'])
  }

  consultaPedido(): void {
    this.router.navigate(['/pedido'])
  }

  novoPedido(): void {
    this.router.navigate(['/pedidoForm'])
  }
}
