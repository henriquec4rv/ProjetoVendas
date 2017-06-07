import java.io.*;
import java.util.*;

public class Venda implements Serializable{

	
	public Produto produto = new Produto();
	public ArrayList<Produto> produtos = new ArrayList<>();
	public Vendedor vendedor;
	int aux = 0, i = 0, quantidadeItens, quantidadeItensFinal;
	float desconto, valorComissaoFinal, valorFinal, valor, valorComissao;
	
	ArqMan arq = new ArqMan();
	MenuVendas menuFuncs = new MenuVendas();
	
	Scanner leitor = new Scanner(System.in);
	Scanner leitor2 = new Scanner(System.in);
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	public void setQuantidadeItens(int quantidadeItens) {
		if(this.quantidadeItens<0){
			throw new PersonalExcept("A quantidade de itens precisa ser maior que zero!");
		}
		this.quantidadeItens = quantidadeItens;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		if(this.valor<0){
			throw new PersonalExcept("Erro, o valor da venda esta incorreto");
		}
		this.valor = valor;
	}
	
	public float getValorComissaoFinal() {
		return valorComissaoFinal;
	}
	public void setValorComissaoFinal(float valorComissaoFinal) {
		this.valorComissaoFinal = valorComissaoFinal;
	}
	public float getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	public int getQuantidadeItensFinal() {
		return quantidadeItensFinal;
	}
	public void setQuantidadeItensFinal(int quantidadeItensFinal) {
		this.quantidadeItensFinal = quantidadeItensFinal;
	}
	
	
	
	public Venda registrarVenda(Venda venda) {
		
		System.out.println("\n- Codigo do vendedor: ");
		venda.setVendedor((Vendedor) arq.lerObjeto("vendedores/" + leitor.nextLine()));
		
		while(aux==0){
		//valor final a se pagar
			System.out.println("\n- Codigo do Produto: ");
			//ADICIONAR NOT FOUND EXCEPTION
			venda.produto = ((Produto) arq.lerObjeto("produtos/" + leitor.nextLine()));
		
			System.out.println("\n- Qtd:");
			venda.quantidadeItens = leitor2.nextInt();
			venda.produtos.add(venda.getProduto());
			venda.calcularValor();
			venda.calcularComissao();
			
			venda.valorComissaoFinal += venda.valorComissao;
			venda.valorFinal += venda.valor;
			venda.quantidadeItensFinal += venda.quantidadeItens;
			
			menuFuncs.vassourinha();
			System.out.println("Digite 0 para adicionar mais produtos ou qualquer outro valor para sair!!");
			aux = leitor2.nextInt();
			
		}

		return venda;
	}

	public void efetuarDesconto(float porcentagem){
		
		try{
			desconto = (porcentagem / 100) * this.produto.getValorVenda();
			
			if(desconto<0){
				throw new PersonalExcept("Valor invalido!!");
			}
			
			if((produto.getValorVenda() - desconto) < produto.getValorCusto()){
				desconto = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao efetuar desconto!!");
		} finally {
			System.out.println("");
		}
	}
	

	public float calcularValor(){
		
		this.valor = (this.produtos.get(i).getValorCusto() - this.desconto) * this.quantidadeItens;
		if (produto.getValorVenda()<0){
			throw new PersonalExcept("Valor invalido!!");
		}
		return valor;
	}
	
	
	public float calcularComissao(){
		
		if(this.produto.promocao == true){
			valorComissao = ((this.vendedor.getComissao() / 100) * getValor() / 2);
		} else {
			valorComissao = ((this.vendedor.getComissao() / 100) * getValor());
		}
		if(valorComissao < 0) {
			throw new PersonalExcept("Valor invalido para a comissao!!");
		}
		
		return valorComissao;
		
	}
	
	
	public void mostrarVenda(Venda venda){
		System.out.println("---------------------------Dados da Venda---------------------------");
		try{
			do{
				System.out.println("\n- Cod. Produto:" + produtos.get(i).getCodProduto() + "\n- Desc. Produto:" + produtos.get(i).getDescProduto() + "\n- Valor/unidade: R$" + produtos.get(i).getValorCusto());
				i++;
			} while(venda.getProdutos().get(i) != null);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("");
		} finally {
			
		}
		System.out.println("- Qtd de itens: " + venda.quantidadeItensFinal + "\t-> Total: R$" + venda.valorFinal);
		System.out.println("\n- Vendedor:"+ venda.vendedor.getNome() + "\t\tComissao pela venda: R$" + venda.valorComissaoFinal);
		
		try { Thread.sleep (3000); } catch (InterruptedException ex) {}
		
	}
	
}	
	