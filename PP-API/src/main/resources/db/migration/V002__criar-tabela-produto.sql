create table produto( 
 codigo_produto serial not null,
 codigo varchar(220) not null,
 id varchar(220) not null, 
 nome varchar(200) not null,
 preco_unitario real,
 imagem_url varchar(200),
 primary key (codigo_produto)
);