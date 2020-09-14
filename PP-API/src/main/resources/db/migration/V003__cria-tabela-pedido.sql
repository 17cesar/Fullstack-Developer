create table pedido( 
 codigo_pedido serial not null,
 cliente_codigo_cliente int not null,
 frete real not null, 
 quantidade_Produtos int,
 valor_total_pedido real,
 valor_frete_unitario real,
 CONSTRAINT fk_pedido FOREIGN KEY (cliente_codigo_cliente) REFERENCES cliente(codigo_cliente),
 primary key (codigo_pedido)
);

