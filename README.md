
<h1>Projeto - Documentação</h1>
Este documento apresenta o sistema desenvolvido pelo nosso grupo durante o período letivo da disciplina "Programação de Soluções Computacionais" ministrada pelos professores Leandro Procópio Alves e João Felipe Fernandes Coghi. Além de descrever as classes e métodos, este artigo detalha o processo de desenvolvimento.

<h2>Classe Produto</h2>
A classe Produto é a primeira implementada no sistema. Ela possui seis atributos privados:

id: identificador único do produto.
modelo: modelo do produto.
marca: marca do produto.
quantidade: quantidade disponível do produto.
precoDeCompra: preço de compra do produto.
precoDeVenda: preço de venda do produto.
Existem três construtores na classe Produto:

O primeiro construtor recebe como parâmetros o modelo, a marca, a quantidade, o preço de compra e o preço de venda do produto, atribuindo esses valores aos atributos correspondentes da classe.

O segundo construtor recebe um parâmetro adicional, o ID, além dos parâmetros do primeiro construtor. Ele também atribui os valores recebidos aos atributos correspondentes, incluindo o ID.

O terceiro construtor é vazio, não recebendo parâmetros nem realizando nenhuma ação.

A classe Produto também possui métodos de acesso (getters) e modificação (setters) para cada um dos atributos. Esses métodos permitem obter o valor atual de um atributo ou alterar o seu valor.

Resumidamente, a classe Produto é usada para representar um produto com suas informações básicas, como modelo, marca, quantidade, preço de compra e preço de venda. Ela fornece métodos para acessar e modificar essas informações, permitindo que outras partes do programa interajam com os objetos Produto de forma controlada.

<h2>Classe Estoque</h2>
A classe Estoque representa o estoque do sistema e possui os seguintes atributos privados:

listaDeProdutos: um array de objetos do tipo Produto, que armazena os produtos presentes no estoque.
tamanho: indica quantos elementos (produtos) existem atualmente no estoque.
capacidade: indica a capacidade máxima do estoque, ou seja, quantos produtos ele pode armazenar.
A classe Estoque também declara e inicializa dez objetos do tipo Produto (a, b, c, d, e, f, g, h, i, j) com informações pré-definidas.

O construtor da classe Estoque recebe um parâmetro capacidadeInicial, que define a capacidade inicial do estoque. Ele inicializa o atributo listaDeProdutos como um novo array de produtos com a capacidade inicial especificada. Em seguida, define o tamanho como zero e a capacidade como o valor passado no parâmetro.

O método inserirProduto permite adicionar um produto ao estoque. Se o tamanho do estoque atingir a capacidade máxima, o método novaArr é chamado para aumentar a capacidade do estoque, duplicando o seu tamanho. O método atribui um ID ao produto com base no tamanho atual do estoque mais um, adiciona o produto à lista de produtos e incrementa o tamanho.

O método novaArr cria um novo array de produtos com o dobro da capacidade atual e copia os produtos existentes para o novo array.

O método removerProduto recebe um ID como parâmetro e tenta encontrar o produto correspondente no estoque. Se o produto for encontrado, ele desloca os elementos à esquerda para preencher a lacuna deixada pelo produto removido e define o último elemento como null. O tamanho é decrementado e o método retorna verdadeiro, indicando que a remoção foi bem-sucedida. Caso contrário, retorna falso.

O método atualizarProduto recebe um ID e os novos valores para modelo, marca, quantidade, preço de compra e preço de venda. Ele busca o produto correspondente pelo ID e, se encontrado, atualiza as informações do produto com os novos valores.

O método buscarProdutoPorId busca o produto correspondente no estoque após receber o ID. Se o produto for encontrado, é retornado o objeto Produto correspondente. Caso contrário, retorna null.

O método privado buscarIndicePorId busca o índice do produto correspondente no array de produtos do estoque após receber o ID. Se o produto for encontrado, retorna o índice. Caso contrário, retorna -1.

O método listarProdutos retorna um array de produtos contendo todos os produtos atualmente presentes no estoque. Ele cria um novo array de produtos com o tamanho igual ao número de elementos no estoque, percorre o estoque e copia cada produto para o novo array, e, por fim, retorna o array de produtos.

Em resumo, a classe Estoque gerencia um estoque de produtos, permitindo a inserção, remoção, atualização e busca de produtos, além de listar todos os produtos presentes no estoque. Ela também possui a capacidade de aumentar dinamicamente a capacidade do estoque quando necessário.

<h2>Classe Interface</h2>
A classe Interface é responsável pela interface gráfica do sistema. Ela utiliza a biblioteca Swing do Java para criar janelas, botões, rótulos e listas.

No método btn_addItemActionPerformed, acionado quando o botão "Adicionar Item" é clicado, é exibida uma caixa de diálogo para o usuário inserir os valores do novo produto, como nome, categoria, quantidade, preço de compra e preço de venda. Se algum valor for nulo (cancelado) ou se o botão "Cancelar" for pressionado, a operação é cancelada. Caso contrário, os valores são convertidos para os tipos apropriados (int e double) e um novo objeto Produto é criado com os valores informados. O método inserirProduto() do objeto Estoque é chamado para adicionar o novo produto ao estoque. Em seguida, é exibida uma mensagem informando que o produto foi adicionado e o método atualizarTabela() é chamado para atualizar a exibição dos produtos na tabela. Em caso de erro de conversão de tipo, uma mensagem de erro é exibida.

No método btn_remItemActionPerformed, acionado quando o botão "Remover Item" é clicado, é aberta uma caixa de diálogo solicitando ao usuário que insira o ID do produto a ser removido. Em seguida, verifica-se se o valor inserido não é nulo e o converte em um número inteiro. Em caso de sucesso, o método removerProduto() do objeto Estoque é chamado passando o ID como argumento. Se o produto for removido com sucesso, é exibida uma mensagem informando que o produto foi removido e o método atualizarTabela() é chamado para atualizar a exibição dos produtos na tabela. Caso contrário, é exibida uma mensagem de erro informando que o produto não foi encontrado. Em caso de não inserir um valor ID válido, por exemplo, usando uma String, também é exibida uma mensagem de erro.

No método btn_atuItemActionPerformed, acionado quando o botão "Atualizar Item" é clicado, é exibida uma caixa de diálogo solicitando ao usuário que insira o ID do produto a ser atualizado. Em seguida, verifica-se se o valor inserido não é nulo e o converte em um número inteiro. Em caso de sucesso, o método buscarProdutoPorId() do objeto Estoque é chamado passando o ID como argumento para obter o produto correspondente. Se o produto for encontrado, são exibidas caixas de diálogo para o usuário inserir os novos valores para nome, categoria, quantidade, preço de compra e preço de venda do produto. Caso algum valor seja nulo (cancelado), a operação é cancelada. Caso contrário, os novos valores são convertidos para os tipos apropriados (int e double) e o método atualizarProduto() do objeto Estoque é chamado para atualizar o produto com os novos valores. Em seguida, é exibida uma mensagem informando que o produto foi atualizado e o método atualizarTabela() é chamado para atualizar a exibição dos produtos na tabela. Em caso de erro de conversão de tipo, uma mensagem de erro é exibida.

No método btn_BuscItemActionPerformed, acionado quando o botão "Buscar Item" é clicado, é aberta uma caixa de diálogo solicitando ao usuário que insira o ID do produto a ser buscado. Em seguida, verifica-se se o valor inserido não é nulo e o converte em um número inteiro. Em caso de sucesso, o método buscarProdutoPorId() do objeto Estoque é chamado passando o ID como argumento para obter o produto correspondente. Se o produto for encontrado, é exibida uma caixa de diálogo com as informações do produto (ID, nome, categoria, quantidade, preço de compra e preço de venda). Caso contrário, é exibida uma mensagem informando que o produto não foi encontrado. Em caso de erro de conversão de tipo, uma mensagem de erro é exibida.

Por fim, no método atualizarTabela, criado para atualizar a exibição dos produtos na tabela da interface, obtém-se a referência ao modelo da tabela e redefine o número de linhas para zero, removendo todos os produtos previamente exibidos. Em seguida, obtém-se a lista de produtos do objeto Estoque e adiciona cada produto na tabela, preenchendo as colunas com o ID, nome, categoria, quantidade, preço de compra e preço de venda do produto.

Referências:
[1] Vídeo aula sobre montagem de interfaces: link
[2] Artigo sobre a biblioteca JOptionPane: link
