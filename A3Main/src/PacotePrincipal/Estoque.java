package PacotePrincipal;

public class Estoque {
    private Produto[] listaDeprodutos;

    private int tamanho;
    //quantos elementos tem 

    private int capacidade;
    //quantos elementos pode ter
    Produto a = new Produto(1, "AirForce", "Nike", 20, 300,799);
    Produto b = new Produto(2, "Air Max Plus Terrascape", "Nike", 20, 150, 499);
    Produto c = new Produto(3, "New Balance 327", "New Balance", 20, 250, 749);
    Produto d = new Produto(4, "Yeezy 500", "Adidas", 10, 700, 1299);
    Produto e = new Produto(5, "Air Jordan 4 Retro", "Jordan", 12, 900, 1699);
    Produto f = new Produto(6, "Sacai X VaporWaffle", "Nike", 3, 2000, 5200);
    Produto g = new Produto(7, "Mizuno Sky Medal", "Mizuno", 15, 425, 899);
    Produto h = new Produto(8, "NMD", "Adidas", 30, 235, 499);
    Produto i = new Produto(9, "New Balance 550", "New Balance", 20, 485, 999);
    Produto j = new Produto(10, "Adidas Forum Low", "Adidas", 15, 200, 449);
    
    public Estoque(int capacidadeInicial) {
        listaDeprodutos = new Produto[capacidadeInicial];
        tamanho = 0;
        capacidade = capacidadeInicial;
        inserirProduto(a);
        inserirProduto(b);
        inserirProduto(c);
        inserirProduto(d);
        inserirProduto(e);
        inserirProduto(f);
        inserirProduto(g);
        inserirProduto(h);
        inserirProduto(i);
        inserirProduto(j);
    }

    public void inserirProduto(Produto produto) {

        //se a quantidade de itens chegar ao limite a função novaArr é chamada sem parametros
        if (tamanho == capacidade) {
            novaArr();
        }

        produto.setId(tamanho + 1);
        listaDeprodutos[tamanho] = produto;
        tamanho++;
        
        
    }

    public void novaArr() {
        int novaCapacidade = capacidade * 2;
        Produto[] novaArr = new Produto[novaCapacidade];

        for (int c = 0; c < tamanho; c++) {
            novaArr[c] = listaDeprodutos[c];
        }

        listaDeprodutos = novaArr;
        capacidade = novaCapacidade;
    }

    public boolean removerProduto(int id) {
        int indice = buscarIndicePorId(id);

        if (indice != -1) {
            // Desloca os elementos à esquerda para preencher a lacuna deixada pelo produto removido
            for (int i = indice; i < tamanho - 1; i++) {
                listaDeprodutos[i] = listaDeprodutos[i + 1];
            }
            
            // Define o último elemento como null e atualiza o tamanho
            listaDeprodutos[tamanho - 1] = null;
            tamanho--;
            return true; // Remoção bem-sucedida
        }

        return false; // Produto não encontrado
    }

    
     public void atualizarProduto(int id, String novoModelo, String novaMarca, int novaQuantidade, double novoPrecoDeCompra, double novoPrecoDeVenda) {
        int indice = buscarIndicePorId(id);

        if (indice != -1) {
            Produto produto = listaDeprodutos[indice];
            produto.setModelo(novoModelo);
            produto.setMarca(novaMarca);
            produto.setQuantidade(novaQuantidade);
            produto.setPrecoDeCompra(novoPrecoDeCompra);
            produto.setPrecoDeVenda(novoPrecoDeVenda);
        }
    }

    public Produto buscarProdutoPorId(int id) {
        int indice = buscarIndicePorId(id);

        if (indice != -1) {
            return listaDeprodutos[indice];
        }

        return null;
    }

    private int buscarIndicePorId(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (listaDeprodutos[i].getId() == id) {
                return i;
            }
        }

        return -1;
    }
    
    public Produto[] listarProdutos() {
        // Cria um novo array de produtos com o tamanho igual ao número de elementos no estoque
        Produto[] produtos = new Produto[tamanho];
        
        // Percorre o estoque e copia cada produto para o novo array
        for (int i = 0; i < tamanho; i++) {
            produtos[i] = listaDeprodutos[i];
        }
        // Retorna o array de produtos
        return produtos;
}

}