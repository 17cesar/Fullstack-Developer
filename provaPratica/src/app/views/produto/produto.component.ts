import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produto',
  template: `  `,
  styles: [
  ]
})
export class ProdutoComponent implements OnInit {

  constructor(private router: Router ) { }

  ngOnInit(): void {
  }

  novoProduto(): void {
    console.log('opa')
    this.router.navigate(['/produto'])
}

}
