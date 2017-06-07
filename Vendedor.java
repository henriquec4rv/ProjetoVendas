import java.io.Serializable;
import java.util.Scanner;

public class Vendedor implements Serializable{

	
	public String nome;
	public String codigo;
	public static float comissao = 5;
	public String endereco;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		Vendedor.comissao = comissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Vendedor cadastroVendedor(Vendedor vendedor){
		Scanner leitor = new Scanner(System.in);
		System.out.println("-----------------------Cadastro de Vendedor-----------------------\n");
		System.out.println("- Nome: ");
		vendedor.setNome(leitor.nextLine());
		System.out.println("\n- Codigo: ");
		vendedor.setCodigo(leitor.nextLine());
		System.out.println("\n- Endereco: ");
		vendedor.setEndereco(leitor.nextLine());
		
		leitor.close();
		
		return vendedor;
	}
	
	public void exibeVendedor(Vendedor vendedor){
		System.out.println("-----------------------Dados do Vendedor-----------------------\n");
		System.out.println("\n- Nome: "+ vendedor.getNome());
		System.out.println("\n- Codigo: " + vendedor.getCodigo());
		System.out.println("\n- Endereco: " + vendedor.getEndereco());
		try { Thread.sleep (3000); } catch (InterruptedException ex) {}
	}

}
