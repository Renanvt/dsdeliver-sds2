# DsDelivery

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)


# Sobre o projeto

DSDelivery é uma aplicação full stack web construída durante a 2ª edição da Semana DevSuperior (#sds2), evento organizado pela DevSuperior.

A aplicação consiste em um sistema de registro e entrega de pedidos, onde os pedidos são coletados no front end, e depois são armazenados no back end, que também apresenta uma categorização dos pedidos baseados nos dados requisitados.


Você também pode:
  - Pedir vários produtos
  - Usar o mapa para a entrega do(s) produto(s)
  - Ver informações do produto como nome, descrição, imagem e preço antes de fazer um pedido

### Layout web

# Modelo de domínio

### Nível Conceitual

### Nível Lógico

### Nível Físico

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
