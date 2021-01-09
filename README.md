# DsDelivery

[![NPM](https://img.shields.io/npm/1/react)](https://github.com/Renanvt/dsdeliver-sds2/blob/main/LICENSE)


# Sobre o projeto

DSDelivery é uma aplicação full stack web construída durante a 2ª edição da Semana DevSuperior (#sds2), evento organizado pela DevSuperior.

A aplicação consiste em um sistema de registro e entrega de pedidos, onde os pedidos são coletados no front end, e depois são armazenados no back end, que também apresenta uma categorização dos pedidos baseados nos dados requisitados.


Você pode:
  - Pedir vários produtos;
  - Usar o mapa para a entrega do(s) produto(s);
  - Ver informações do produto como nome, descrição, imagem e preço.

# Layout web

![index](https://github.com/Renanvt/dsdeliver-sds2/blob/main/front-web/img/layout-web.PNG
)

![index/orders](https://github.com/Renanvt/dsdeliver-sds2/blob/main/front-web/img/layout-web_2.PNG
)

### Padrão camadas adotado
![camada](https://github.com/Renanvt/dsdeliver-sds2/blob/main/backend/img/camadas.png)
# Modelo de domínio

### Nível Conceitual
![modelo_conceitual](https://github.com/Renanvt/dsdeliver-sds2/blob/main/backend/img/modelo-conceitual.png)
![modelo_conceitual2](https://github.com/Renanvt/dsdeliver-sds2/blob/main/backend/img/N%C3%ADvelConceitual_2.jpg)
### Nível Lógico
![modelo_lógico](https://github.com/Renanvt/dsdeliver-sds2/blob/main/backend/img/N%C3%ADvelL%C3%B3gico.jpg)
### Nível Físico
```sql
create table tb_order (id int8 generated by default as identity, address varchar(255), latitude float8, longitude float8, moment timestamp, status int4, primary key (id));
create table tb_order_product (order_id int8 not null, product_id int8 not null, primary key (order_id, product_id));
create table tb_product (id int8 generated by default as identity, description varchar(255), image_uri varchar(255), name varchar(255), price float8, primary key (id));
alter table if exists tb_order_product add constraint FKsu03ywlcvyqg5y78qey2q25lc foreign key (product_id) references tb_product;
alter table if exists tb_order_product add constraint FK40anaevs16kmc2tbh7wc511fq foreign key (order_id) references tb_order;

INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Pizza Bacon', 49.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Pizza Moda da Casa', 59.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg', 'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Pizza Portuguesa', 45.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg', 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Risoto de Carne', 52.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg', 'Risoto de carne com especiarias e um delicioso molho de acompanhamento.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Risoto Funghi', 59.95, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg', 'Risoto Funghi feito com ingredientes finos e o toque especial do chef.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Macarrão Espaguete', 35.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg', 'Macarrão fresco espaguete com molho especial e tempero da casa.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Macarrão Fusili', 38.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg', 'Macarrão fusili com toque do chef e especiarias.');
INSERT INTO tb_product (name, price, image_Uri, description) VALUES ('Macarrão Penne', 37.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg', 'Macarrão penne fresco ao dente com tempero especial.');

INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (1, -22.946779, -43.217753, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -25.439787, -49.237759, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T12:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (1, -23.561680, -46.656139, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T08:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T14:00:00Z');
INSERT INTO tb_order (status, latitude, longitude, address, moment) VALUES (0, -23.561680, -46.656139, 'Avenida Paulista, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T09:00:00Z');

INSERT INTO tb_order_product (order_id, product_id) VALUES (1 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (1 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 5);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 8);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3 , 3);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 6);
INSERT INTO tb_order_product (order_id, product_id) VALUES (5 , 4);
INSERT INTO tb_order_product (order_id, product_id) VALUES (5 , 6);
INSERT INTO tb_order_product (order_id, product_id) VALUES (6 , 5);
INSERT INTO tb_order_product (order_id, product_id) VALUES (6 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (7 , 7);
INSERT INTO tb_order_product (order_id, product_id) VALUES (7 , 5);

```

# Modelo de objetos
![modelo_de_objeto](https://github.com/Renanvt/dsdeliver-sds2/blob/main/backend/img/modelo-de-objetos.PNG)
# Checklist

* Setup inicial do projeto
- [x] Dependências
- [x] Arquivos .properties
- [x] Configuração de segurança
* Modelo de domínio
- [x] Entidades e relacionamentos
- [x] Mapeamento objeto-relacional
- [x] Seed
* Criar endpoints
- [x] [GET] /products
- [x] [GET] /orders
- [x] [POST] /orders
- [x] [PUT] /orders/{id}/delivered
* Validar perfil dev
- [x] Base de dados Postgres local
- [x] Testar todos endpoints
* Preparar projeto para implantação
- [x] Arquivo system.properties
- [x] Profile prod -> commit
* Implantar projeto no Heroku
- [x] Criar app e provisionar Postgres
- [x] Criar base de dados remota
- [x] Executar comandos no Heroku CLI

# Tecnologias utilizadas

### Back end
* Java
* Spring Boot
* JPA /Hibernate
* Maven

### Front end
* HTLM/ CSS / JS / TypeScript
* ReactJS

### Implantação em produção
* Back end: Heroku
* Front end: Netlify
* Banco de dados: Postgresql

Além disso o DsDeliver usa uma série de projetos de código aberto para funcionar corretamente:

### Como executar o projeto

Pré-requisitos: Java 11

Install the dependencies and devDependencies and start the server.

```sh
# clonar repositório
$ git clone https://github.com/Renanvs/dsdeliver-sds2
# entrar na posta do projeto back end
$ cd backend
# executar o projeto
$ ./mvnw spring-boot:run
```

### Front end web

```sh
# clonar repositório
$ git clone https://github.com/Renanvs/dsdeliver-sds2
# entrar na posta do projeto front end web
$ cd front-web
# instalar dependências
$ yarn install
# executar o projeto
$ yarn start
```

### Plugins

DsDeliver está atualmente estendido com os seguintes plugins. As instruções sobre como usá-los em seu próprio aplicativo estão no link abaixo.

| Plugin | README |
| ------ | ------ |
| ReactRouter | [https://reactrouter.com/][PlDb] |
| ReactLeaflet | [https://react-leaflet.js.org/][PlGh] |
| ReactSelect | [https://react-select.com/home][PlGd] |
| MapBox | [https://www.mapbox.com/][PlOd] |
| ReactToastify | [https://fkhadra.github.io/react-toastify/installation/][PlMe] |

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
