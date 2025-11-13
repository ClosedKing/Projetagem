Implemente, em Java, um Sistema de Biblioteca executado em console que permita cadastrar, alterar, pesquisar e excluir livros, além de registrar empréstimos e devoluções. A aplicação deve empregar Orientação a Objetos (atributos, visibilidade, métodos, classes/objetos, herança, encapsulamento, métodos estáticos, polimorfismo, classes/métodos abstratos) e estruturas de controle (menu, fluxo condicional, laços contados e variações).

1) Requisitos Funcionais (menu e operações)
Implemente um menu em loop até que o usuário escolha “Sair” ou alguma opção semelhante, com as opções:
Cadastrar livro
Alterar livro (por ID ou ISBN)
Pesquisar livro (por título/autor/ISBN)
Excluir livro
Listar acervo
Emprestar livro
Devolver livro
Sair

O cadastro deve ser armazenado em List<Livro> em memória.
Para realizar o empréstimo não há uma forma definida a ser seguida, o desenvolvedor pode criar um List de Empréstimos ou outra forma que desejar, mas deve registrar a situação do livro e não permitir um novo empréstimo sem que a devolução seja realizada.
Em Relatórios, ofereça:
“Livros disponíveis”
“Livros emprestados”

2) Modelo de Domínio (OO – Parte I e II)
2.1 Classe básicas
Livro (classe)
Atributos (privados): id (Long), isbn (String), titulo (String), auto (String), ano (int), categoria (String) Visibilidade/métodos: getters/setters; toString(); validações no setter (ex.: ano positivo; isbn não vazio).

2.2 Herança, classes/métodos abstratos 
ItemBiblioteca (classe abstrata)
Atributos comuns (ex.: id, título);
Livro estende ItemBiblioteca e implementa calcularMulta (ex.: R$ 1,50 por dia).