Linkedin da galera:

<https://www.linkedin.com/in/rodrigovp>\
<https://www.linkedin.com/in/arthurfnsc/>\
<https://www.linkedin.com/in/isaacnp/>\
<https://www.linkedin.com/in/josecarlosoliveirajr/>\
<https://www.linkedin.com/in/thiago-bomfim-37b198a1/>\
<https://www.linkedin.com/in/leo-falcao-javasr>\
<https://www.linkedin.com/in/raimundo-norberto-jr/>\
<https://www.linkedin.com/in/rafael-soares-matos-854576120/>\
<https://www.linkedin.com/in/pablocdemoura/>

Discord: <https://discord.gg/Ew2T8W>\
<http://maratona.dev>

27/7
FJ-38 - Práticas de Design e Arquitetura para Aplicações Java

Instrutor: Rodrigo Vieira Pinto\
rodrigo.vieira@caelum.com.br\
Elo7 - www.elo7.com.br

Endereço deste Dontpad -> <http://dontpad.com/caelum/fj-38>

"Qualquer programador consegue escrever um código que um computador entenda. Bons programadores escrevem códigos para outros programadores entenderem"
 <i>Martin Fowler</i>

#### Uncle Bob 
	Clean Coder (O Codificador Limpo)
	Clean Code (O Código Limpo)
	Clean Architecture (Arquitetura Limpa)
	The Software Craftsman
#### Dave Thomas
	O Programador Pragmático
#### Martin Fowler
	Refatoração - Aperfeiçoando o Projeto de Código Existente
	Patterns of Enterprise Application Architecture (Padrões de Arquitetura de Aplicações Corporativas)
#### Fred Brooks
	O Mítico Homem Mês
#### Gang of Four
	Design Patterns - Favoreça composição à herança
#### Michael Feathers
	Working Effectively With Legacy Code
#### Kent Beck
	Desenvolvimento Guiado a Testes

####  Grady Booch

--------------------------------------

O que são classes?
- representações de objetos
- abstração do nosso mundo real
- modelo do objeto
- como um átomo, é uma representação mais simples de um todo
- Uncle Bob - é um agrupamento acoplado de funções e dados
-->> Regra do Escoteiro: sempre deixe melhor o lugar por onde você passou

Donald Knuth - The Art of Computer Programming

Análise de Mutantes -> <https://pitest.org>
<https://blog.caelum.com.br/testes-de-mutantes/amp/>


Classes se relacionam
(via construtor, métodos, ...)

Algumas formas de relacionamento -> Padrões 

---<<< Singleton <<<---

--->>> Injeção de Dependência >>>---

* Adapter
* Command
* Factory Method
* DTO/VO (Data Transfer Object)
* DAO (Data Access Object)
* Entity
* DDD (Domain Driven Design)


* Single Responsibility Principle
* Open Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

----------------------------------------------------------------------
28/7
Active Record - Ruby on Rails

Sistema de E-Commerce

Usuario

<https://blog.caelum.com.br/nao-aprender-oo-getters-e-setters/amp/>

Refatoração - alteração de código sem alterar funcionalidades
DDD - classes de domínio
 - atributos
 - comportamento

----------------------------------------------------------------------
29/7

<https://philcalcado.com/2010/03/22/nevermind_domain_driven_design.html>

ArchUnit <https://www.archunit.org/>\
Exemplos: <https://github.com/TNG/ArchUnit-Examples>

<https://desciclopedia.org/wiki/Gambi_Design_Patterns#Mega_Zord>
<https://francescocirillo.com/pages/anti-if-campaign>

----------------------------------------------------------------------
30/7

<https://blog.caelum.com.br/como-nao-aprender-orientacao-a-objetos-heranca/amp/>

----------------------------------------------------------------------
3/8
<https://deviniciative.wordpress.com/2020/06/22/voce-deveria-abandonar-o-lombok/>

----------------------------------------------------------------------
4/8

Command Pattern
Composite Pattern

----------------------------------
Princípios de Coesão de Módulos
- Princípio da Equivalência Entre Entrega e Reuso (REP)
- Princípio do Agrupamento Comum (CCP)
- Princípio do Reuso Comum (CRP)

Java com 4MB?? --> <https://www.youtube.com/watch?v=Uq9Qi5i4NNU>

----------------------------------------------------------------------
5/8

<https://www.youtube.com/user/AkitaOnRails>

Princípios de Acoplamento de Módulos
 - Princípio das Dependências Acíclicas
 - Princípio das Dependências Estáveis
 - Princípio das Abstrações Estáveis

select 1

<https://github.com/caelum/apostila-microservices-com-spring-cloud>

An object-oriented, multi-threaded <http server framework written in Dart.
<https://aqueduct.io/>

----------------------------------------------------------------------
6/8

Módulos
javabean
binding

module modulo {
	exports br.com.caelum.UmaClasse;
	requires outro.modulo;
}

<https://blog.caelum.com.br/erros-com-jaxb-no-java-9/>

Cap. 12
H2 - Parâmetros no application.properties (pom):

<pre>spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:file:~/h2file;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect 
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
</pre>



(DDD)
<https://kalele.io/>

<https://www.youtube.com/channel/UC3PGn-hQdbtRiqxZK9XBGqQ>

Implementando DDD (VERNON)
<https://www.amazon.com.br/Implementando-Domain-Driven-design-Vernon/dp/8576089521/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2RN7EFW9DIJ7Y&dchild=1&keywords=implementing+domain-driven+design&qid=1596755356&sprefix=Imple%2Caps%2C272&sr=8-1>

<https://github.com/kamranahmedse/developer-roadmap>

<https://www.infoq.com/articles/architecture-trends-2020/>

<https://github.com/thombergs/buckpal>

<https://github.com/mattia-battiston/clean-architecture-example>

<https://martinfowler.com/microservices/>

<https://blog.bradfieldcs.com/you-are-not-google-84912cf44afb>

<https://www.infoq.com/br/interviews/os-desafios-da-escalabilidade-desconstruindo-padroes/>

hipsters.tech - Roberta Arcoverde/Stack Overflow


<https://www.ebay.com/sch/i.html?_from=R40&_nkw=patterns+of+enterprise+application+architecture&_sacat=171243&_sop=15>

 Obrigado por participarem!
