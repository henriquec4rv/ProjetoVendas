import java.util.*;

public class MenuVendas {
	
	public int opt;
	public int opt2 = 2;
	Scanner leitor = new Scanner(System.in);
	
	public int getOpt() {
		return opt;
	}
	

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int getOpt2() {
		return opt2;
	}

	public void setOpt2(int opt2) {
		this.opt2 = opt2;
	}

	public int menu1(){
		System.out.println("--------------------Menu Principal--------------------");
		System.out.println("\n1 - Cadastrar Venda");
		System.out.println("\n2 - Cadastrar novo Vendedor");
		System.out.println("\n3 - Cadastrar novo Produto");
		System.out.println("\n4 - Sair");
		System.out.println("\n>>");
		
		try{
		setOpt(leitor.nextInt());
		}catch (InputMismatchException e) {
			System.out.println("Opcao invalida!!");
		}
		return opt;
	}
	
	public int menu2(){
		System.out.println("------------------------------------------\n");
		System.out.println("1 - Menu Principal");
		System.out.println("\n2 - Novo registro");
		System.out.println("\n>>");
		
		setOpt2(leitor.nextInt());
		
		return opt2;
	}
	
	public void menu3(){
		System.out.println("-----------------------Venda de Produtos-----------------------");
	}
	
	public void vassourinha(){
		int i = 0;
		while(i<10){
			System.out.println("\n");
			i++;
		}
	}
}
