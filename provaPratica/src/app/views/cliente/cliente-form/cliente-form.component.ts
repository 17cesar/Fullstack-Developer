import { Cliente } from 'src/app/components/cliente/cliente.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from './../../../components/cliente/cliente.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cliente-form',
  templateUrl:  './clienteForm.component.html',
  styleUrls: ['./clienteForm.component.css']
  
})
export class ClienteFormComponent implements OnInit {

  cliente: Cliente

  constructor(private clienteService: ClienteService , private route: Router , private routerAction: ActivatedRoute) { }

  ngOnInit(): void {
    const codigo = this.routerAction.snapshot.paramMap.get('codigoCliente');    
    this.clienteService.consultarPorCodigo(codigo).subscribe(clienteAltear => {
      this.cliente = clienteAltear
    })    
  }

  alterar(){

  }

  cancelar(): void{
     this.route.navigate(['/cliente'])
  }

  novo():void{
    this.route.navigate(['/clienteForm'])
  }

  teste(): void{
     if(this.cliente.codigo == null){
        alert('Novo Doido')
     }else{
      alert('Editando')
     }
  }
}
