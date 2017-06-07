import java.io.Serializable;
import java.util.*;

public class Produto implements Serializable {
	
	
	public String codProduto;
	public String descProduto;
	public float valorVenda;
	public float valorCusto;
	public Boolean promocao;
	

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		if(this.valorVenda<0){
			throw new PersonalExcept("O valor nao pode ser menor que zero!");
		}
		this.valorVenda = valorVenda;
	}

	public float getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(float valorCusto) {
		if(this.valorCusto<0){
			throw new PersonalExcept("O valor nao pode ser menor que zero!");
		}
		this.valorCusto = valorCusto;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}
	
	public Produto criarProduto(Produto novoProduto){ //Registrando um produto novo
		
		Scanner leitor = new Scanner(System.in);
		int promoOpt = 0;
		
		System.out.println("-------------------Cadastro de Produto-------------------\n");
		System.out.println("Codigo: ");
		novoProduto.setCodProduto(leitor.nextLine());
		System.out.println("\nDescricao: ");
		novoProduto.setDescProduto(leitor.nextLine());
		try{
			System.out.println("\nValor de venda: ");
			novoProduto.setValorVenda(leitor.nextFloat());
			System.out.println("\nValor de compra (custo): ");
			novoProduto.setValorCusto(leitor.nextFloat());
		} catch (InputMismatchException e) {
			System.out.println("Valor invalido!!");
			novoProduto.setValorVenda(0);
		}
		
		System.out.println("\n1 - Produto com desconto \n2 - Produto sem desconto");
		System.out.println("\n>>");
		
		promoOpt = leitor.nextInt();
		if(promoOpt == 1){
			novoProduto.setPromocao(true);
		} else if(promoOpt == 2){
			novoProduto.setPromocao(false);
		} else {
			System.out.println("Valor invalido!!");
		}
		
			
		return novoProduto;
	}
	
	public void mostraProduto(Produto produto){ //Exibindo os dados do produto
		
		System.out.println("\n------------Informacoes------------\n");
		System.out.println("- Codigo:" + produto.getCodProduto());
		System.out.println("\n- Descricao do Produto:" + produto.getDescProduto());
		System.out.println("\n- Valor de venda: " + produto.getValorVenda());
		System.out.println("\n- Valor de compra (custo): " + produto.getValorCusto());
		System.out.println("\n- Status: ");
		if(produto.getPromocao() == true){
			System.out.println("promocao!!");
		} else {
			System.out.println("normal!!");
		}	
		
		try { Thread.sleep (3000); } catch (InterruptedException ex) {}
	}

	
	
}
