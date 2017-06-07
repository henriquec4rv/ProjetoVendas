import java.io.FileNotFoundException;

public class VendaMain {
	
	public static void main(String[] args) {

		MenuVendas menu = new MenuVendas();
		Vendedor vendedor = new Vendedor();
		Produto produto = new Produto();
		Venda venda = new Venda();
		ArqMan arq = new ArqMan();


		while (menu.getOpt() != 4) {

			menu.setOpt2(2);
			menu.vassourinha();
			menu.menu1();
			switch (menu.getOpt()) {

			case 1: // Registrando uma Venda

				while (menu.getOpt2() == 2) {

					venda.registrarVenda(venda);
					venda.mostrarVenda(venda);
					try {
						arq.salvar(venda, "vendas/" + venda.getVendedor().getNome());
					} catch (FileNotFoundException e) {
						
					}
					menu.menu2();
					
					

				}
				break;

			case 2: // Registrando um novo Vendedor

				while (menu.getOpt2() == 2) {

					menu.vassourinha();
					vendedor.cadastroVendedor(vendedor);
					try {
						arq.salvar(vendedor, "vendedores/" + vendedor.getCodigo());
					} catch (FileNotFoundException e) {
						System.out.println("Nao foi possivel ler os dados.");
					}
					vendedor.exibeVendedor(vendedor);
					menu.menu2();
				}
				break;

			case 3: // Registrando um novo Produto

				while (menu.getOpt2() == 2) {
					produto.criarProduto(produto);
					try {
						arq.salvar(produto, "produtos/" + produto.getCodProduto());
					} catch (FileNotFoundException e) {
						System.out.println("Nao foi possivel ler os dados.");
					}
					
					produto.mostraProduto(produto);
					menu.menu2();

				}
				break;

			case 4: // Saindo do sistema
				System.exit(0);

			default:
				System.out.println("Informe um valor dentre as opcoes: ");
				break;
			}
		}
	}

}