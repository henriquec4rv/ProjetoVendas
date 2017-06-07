# Projeto - Sistema de Vendas (Luís Felipe Oliveira de Araújo e Henrique Luís de Carvalho Santos)

Repositório destinado ao Projeto do 3º estágio da disciplina Metodologia e Linguagem de Programação, ministrada por Rodrigo Fujioka.

# Classes

.Vendedor

  Classe que contém os seguintes dados dos vendedores:
      Nome;
      Código;
      Comissão;
      Endereço.
  
  Métodos:
      cadastroVendedor -> efetua o cadastro de um novo vendedor no sistema;
      exibeVendedor -> exibe os dados do vendedor cadastrado;
  
.Produto

  Classe que contém os seguintes dados dos produtos:
      Código do Produto;
      Descrição do Produto;
      Valor de venda do Produto;
      Valor de aquisição do Produto;
      Status: true or false para promoção.
  
  Métodos:
      criarProduto -> efetua o cadastro de um novo produto no sistema;
      mostraProduto -> exibe os dados do produto cadastrado;
      
      
 .Venda

  Classe que contém os seguintes dados das vendas:
      Qtd de itens;
      Qtd final dos itens (após finalizar o laço);
      Desconto;
      Comissao (calculada);
      Valor total da venda;
  
  Métodos:
      registrarVenda -> efetua o cadastro de uma venda no sistema;
      mostraVenda -> exibe os dados da venda;
      efetuarDesconto -> calcula e aplica o desconto no valor da compra;
      calcularValor -> calcula o valor da compra;
      calcularComissao -> calcula a comissao do vendedor com base no valor da compra;
 
 .ArqMan
 
  Classe com finalidade apenas de ler/criar arquivos;
  
.PersonalExcept

 Classe contendo um tratamento de exceção feito pela dupla (obrigatório);
 
.MenuVendas

 Classe que contém as funcionalidades de Menu e limpeza (vassourinha = clear || cls);
 
.VendaMain

 Classe que faz as operações da venda: exibição de menus, cadastro de vendedores, produtos e vendas.
