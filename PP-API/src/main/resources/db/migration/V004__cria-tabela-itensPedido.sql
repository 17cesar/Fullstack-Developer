create table itens_pedido( 
 codigo_item_pedido serial not null,
 produto_codigo_produto int not null,
 pedido_codigo_pedido int not null,
 valor_total_item real not null, 
 quantidade_Produto int,
 CONSTRAINT fk_item_pedido_produto FOREIGN KEY (produto_codigo_produto) REFERENCES produto(codigo_produto),
 CONSTRAINT fk_item_pedido_pedido FOREIGN KEY (pedido_codigo_pedido) REFERENCES pedido(codigo_pedido),
 primary key (codigo_item_pedido)
);
