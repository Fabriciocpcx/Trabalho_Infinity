package br.com.Infinity.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.Infinity.controller.CaixaUser;
import br.com.Infinity.controller.ClienteUser;
import br.com.Infinity.controller.MercadoriaUser;
import br.com.Infinity.controller.VendaUser;
import br.com.Infinity.model.Caixa;
import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Mercadoria;
import br.com.Infinity.model.Venda;

public class NovaVenda {

	JFrame frame;
	protected Shell shlNovaVenda;
	private Text txtBuscaCod;
	public Button btnBuscarCliente;
	public Button btnConcluir;
	public Button btnCancelar;
	private FormData fd_txtBuscaCod;
	private Label lbCodigo;
	private Label lbTCliente;
	private FormData fd_btnCancelar;
	private Label lblCodigo;
	private Text txtCodigo;
	private Text txtPreco;
	private Text txtQuantidade;
	private Text txtMercadoria;
	private Text txtCliente;
	private Text txtResultado;
	private Label lbData;

	Cliente cliente;
	Mercadoria mercadoria;
	VendaUser vendaUser;
	int preco;
	int quantidade;
	private Text txtData;
	private Button btnBuscarMercadoria;
	private Button btnNovaVenda;
	Button btnPrazo;
	boolean opcao = false;
	private Label lblEstoque;
	private Text txtEstoque;
	int idMercadoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NovaVenda window = new NovaVenda();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlNovaVenda.open();
		shlNovaVenda.layout();
		btnConcluir.setEnabled(false);
		btnCancelar.setEnabled(false);
		while (!shlNovaVenda.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlNovaVenda = new Shell();
		shlNovaVenda.setSize(499, 354);
		shlNovaVenda.setText("Nova Venda");
		shlNovaVenda.setLayout(new FormLayout());

		btnCancelar = new Button(shlNovaVenda, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				txtResultado.setEnabled(true);
				txtBuscaCod.setEnabled(true);
				txtCliente.setEnabled(true);
				txtCodigo.setEnabled(true);
				txtMercadoria.setEnabled(true);
				txtPreco.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtData.setEnabled(true);
				txtEstoque.setEnabled(true);

				txtResultado.setText("");
				txtBuscaCod.setText("");
				txtCliente.setText("");
				txtCodigo.setText("");
				txtMercadoria.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				txtData.setText("");
				txtEstoque.setText("");

				btnBuscarMercadoria.setEnabled(true);
				btnBuscarCliente.setEnabled(true);
				btnConcluir.setEnabled(true);
				btnNovaVenda.setEnabled(false);
				btnCancelar.setEnabled(false);

			}
		});
		fd_btnCancelar = new FormData();
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		lbCodigo = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_lbCodigo = new FormData();
		lbCodigo.setLayoutData(fd_lbCodigo);
		lbCodigo.setText("ID Cliente");

		lbTCliente = new Label(shlNovaVenda, SWT.NONE);
		fd_lbCodigo.top = new FormAttachment(lbTCliente, 14);
		lbTCliente.setText("Cliente");
		lbTCliente.setFont(SWTResourceManager.getFont("Tw Cen MT", 12,
				SWT.NORMAL));
		FormData fd_lbTCliente = new FormData();
		fd_lbTCliente.right = new FormAttachment(100, -324);
		fd_lbTCliente.left = new FormAttachment(0, 10);
		fd_lbTCliente.top = new FormAttachment(0, 10);
		lbTCliente.setLayoutData(fd_lbTCliente);

		txtBuscaCod = new Text(shlNovaVenda, SWT.BORDER);
		fd_lbCodigo.right = new FormAttachment(100, -422);
		fd_txtBuscaCod = new FormData();
		fd_txtBuscaCod.left = new FormAttachment(lbCodigo, 10);
		fd_txtBuscaCod.top = new FormAttachment(lbCodigo, -3, SWT.TOP);
		txtBuscaCod.setLayoutData(fd_txtBuscaCod);

		btnBuscarCliente = new Button(shlNovaVenda, SWT.NONE);
		fd_txtBuscaCod.right = new FormAttachment(100, -361);
		btnBuscarCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				cliente = new Cliente();
				ClienteUser clienteUser = new ClienteUser();
				int id = Integer.parseInt(txtBuscaCod.getText());
				cliente = clienteUser.buscarCliente(id);
				txtCliente.setText(cliente.getNome());

				btnBuscarCliente.setEnabled(false);
				btnConcluir.setEnabled(true);
				btnCancelar.setEnabled(true);
				txtCliente.setEnabled(false);

			}
		});
		FormData fd_btnBuscarCliente = new FormData();
		fd_btnBuscarCliente.top = new FormAttachment(lbCodigo, -5, SWT.TOP);
		fd_btnBuscarCliente.left = new FormAttachment(txtBuscaCod, 20);
		fd_btnBuscarCliente.right = new FormAttachment(btnCancelar, 0,
				SWT.RIGHT);
		btnBuscarCliente.setLayoutData(fd_btnBuscarCliente);
		btnBuscarCliente.setText("Buscar");

		btnConcluir = new Button(shlNovaVenda, SWT.NONE);
		fd_btnCancelar.top = new FormAttachment(btnConcluir, 0, SWT.TOP);
		fd_btnCancelar.left = new FormAttachment(btnConcluir, 6);
		btnConcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Venda venda = new Venda();
				vendaUser = new VendaUser();

				venda.setCliente(cliente);
				venda.setMercadoria(mercadoria);
				int quant = Integer.parseInt(txtQuantidade.getText());
				venda.setQuantidade(quant);

				int valor = quant * preco;
				venda.setValor(valor);
				venda.setData(txtData.getText());
				venda.setPrazo(opcao);

				// Recupero o caixa para atualizar
				CaixaUser caixaUser = new CaixaUser();
				Caixa temp = new Caixa();
				temp = caixaUser.buscarCaixa(1);

				// inclui no banco
				vendaUser.CadastrarVenda(venda);

				// Se for a prazo,
				if (opcao == true) {

					double aux = temp.getaPrazo();
					aux = aux + valor;

					temp.setaPrazo(aux);

					caixaUser.alterarCaixa(temp);

				} else {// se nao, apenas inclui valor no caixa (à Vista)

					double aux = temp.getEntradas();
					aux = aux + valor;

					double saldo = temp.getSaldoCaixa();
					saldo = saldo + valor;

					temp.setEntradas(aux);
					temp.setSaldoCaixa(saldo);

					caixaUser.alterarCaixa(temp);

				}

				// Atualizar Estoque
				MercadoriaUser mercadoriaUser = new MercadoriaUser();
				idMercadoria = Integer.parseInt(txtCodigo.getText());

				mercadoria = mercadoriaUser.buscarMercadoria(idMercadoria);

				int estoque = quantidade - quant;

				mercadoria.setEstoque(estoque);

				mercadoriaUser.alterarMercadoria(mercadoria, idMercadoria);

				txtResultado.setText(valor + "");

				txtResultado.setEnabled(false);
				txtBuscaCod.setEnabled(false);
				txtCliente.setEnabled(false);
				txtCodigo.setEnabled(false);
				txtMercadoria.setEnabled(false);
				txtPreco.setEnabled(false);
				txtQuantidade.setEnabled(false);
				txtData.setEnabled(false);
				txtMercadoria.setEnabled(false);
				txtEstoque.setEnabled(false);

				btnBuscarMercadoria.setEnabled(false);
				btnBuscarCliente.setEnabled(false);
				btnConcluir.setEnabled(false);
				btnNovaVenda.setEnabled(true);
				btnCancelar.setEnabled(false);

				JOptionPane.showMessageDialog(null,
						"Venda cadastrada com sucesso!");

			}
		});
		FormData fd_btnConcluir = new FormData();
		fd_btnConcluir.right = new FormAttachment(100, -381);
		fd_btnConcluir.bottom = new FormAttachment(100, -10);
		fd_btnConcluir.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		btnConcluir.setLayoutData(fd_btnConcluir);
		btnConcluir.setText("Concluir");

		lblCodigo = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_lblCodigo = new FormData();
		fd_lblCodigo.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		lblCodigo.setLayoutData(fd_lblCodigo);
		lblCodigo.setText("Codigo");

		txtCodigo = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtCodigo = new FormData();
		fd_txtCodigo.right = new FormAttachment(txtBuscaCod, 0, SWT.RIGHT);
		fd_txtCodigo.left = new FormAttachment(lblCodigo, 22);
		txtCodigo.setLayoutData(fd_txtCodigo);

		Label label = new Label(shlNovaVenda, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(btnBuscarCliente, 16);
		fd_label.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		fd_label.right = new FormAttachment(0, 458);
		label.setLayoutData(fd_label);

		Label label_1 = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.top = new FormAttachment(0, 111);
		fd_label_1.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		label_1.setLayoutData(fd_label_1);

		Label lbTMercadoria = new Label(shlNovaVenda, SWT.NONE);
		fd_lblCodigo.top = new FormAttachment(lbTMercadoria, 20);
		fd_txtCodigo.top = new FormAttachment(lbTMercadoria, 17);
		lbTMercadoria.setText("Mercadoria");
		lbTMercadoria.setFont(SWTResourceManager.getFont("Tw Cen MT", 12,
				SWT.NORMAL));
		FormData fd_lbTMercadoria = new FormData();
		fd_lbTMercadoria.top = new FormAttachment(label, 16);
		fd_lbTMercadoria.left = new FormAttachment(0, 10);
		lbTMercadoria.setLayoutData(fd_lbTMercadoria);

		Label lblPreo = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_lblPreo = new FormData();
		fd_lblPreo.top = new FormAttachment(lblCodigo, 34);
		fd_lblPreo.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		lblPreo.setLayoutData(fd_lblPreo);
		lblPreo.setText("Pre\u00E7o");

		txtPreco = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtPreco = new FormData();
		fd_txtPreco.top = new FormAttachment(lblPreo, -3, SWT.TOP);
		txtPreco.setLayoutData(fd_txtPreco);

		Label lbQuantidade = new Label(shlNovaVenda, SWT.NONE);
		fd_btnCancelar.right = new FormAttachment(lbQuantidade, -10, SWT.RIGHT);
		fd_txtPreco.right = new FormAttachment(lbQuantidade, -14);
		FormData fd_lbQuantidade = new FormData();
		fd_lbQuantidade.top = new FormAttachment(lblPreo, 0, SWT.TOP);
		fd_lbQuantidade.right = new FormAttachment(100, -275);
		lbQuantidade.setLayoutData(fd_lbQuantidade);
		lbQuantidade.setText("Quantidade");

		txtQuantidade = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtQuantidade = new FormData();
		fd_txtQuantidade.left = new FormAttachment(0, 225);
		fd_txtQuantidade.top = new FormAttachment(lblPreo, -3, SWT.TOP);
		txtQuantidade.setLayoutData(fd_txtQuantidade);

		Label lbPagamento = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_lbPagamento = new FormData();
		fd_lbPagamento.top = new FormAttachment(txtPreco, 24);
		fd_lbPagamento.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		lbPagamento.setLayoutData(fd_lbPagamento);
		lbPagamento.setText("Pagamento");

		Button btnPrazo = new Button(shlNovaVenda, SWT.CHECK);
		btnPrazo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				opcao = true;

			}
		});
		FormData fd_btnPrazo = new FormData();
		btnPrazo.setLayoutData(fd_btnPrazo);
		btnPrazo.setText("\u00E0 Prazo");

		Label lbTotal = new Label(shlNovaVenda, SWT.NONE);
		FormData fd_lbTotal = new FormData();
		fd_lbTotal.top = new FormAttachment(btnCancelar, 5, SWT.TOP);
		lbTotal.setLayoutData(fd_lbTotal);
		lbTotal.setText("Total :  R$");

		txtMercadoria = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtMercadoria = new FormData();
		fd_txtMercadoria.right = new FormAttachment(label, -112, SWT.RIGHT);
		fd_txtMercadoria.top = new FormAttachment(lblCodigo, -3, SWT.TOP);
		fd_txtMercadoria.left = new FormAttachment(txtQuantidade, 0, SWT.LEFT);
		txtMercadoria.setLayoutData(fd_txtMercadoria);

		txtCliente = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtCliente = new FormData();
		fd_txtCliente.left = new FormAttachment(txtQuantidade, 0, SWT.LEFT);
		fd_txtCliente.right = new FormAttachment(label, 0, SWT.RIGHT);
		fd_txtCliente.bottom = new FormAttachment(label, -18);
		txtCliente.setLayoutData(fd_txtCliente);

		txtResultado = new Text(shlNovaVenda, SWT.BORDER);
		fd_lbTotal.right = new FormAttachment(txtResultado, -6);
		FormData fd_txtResultado = new FormData();
		fd_txtResultado.right = new FormAttachment(100, -25);
		fd_txtResultado.left = new FormAttachment(0, 382);
		fd_txtResultado.top = new FormAttachment(btnCancelar, 2, SWT.TOP);
		txtResultado.setLayoutData(fd_txtResultado);

		lbData = new Label(shlNovaVenda, SWT.NONE);
		fd_txtQuantidade.right = new FormAttachment(lbData, -20);
		FormData fd_lbData = new FormData();
		fd_lbData.top = new FormAttachment(lblPreo, 0, SWT.TOP);
		lbData.setLayoutData(fd_lbData);
		lbData.setText("Data");
		fd_lbData.right = new FormAttachment(100, -111);

		txtData = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtData = new FormData();
		fd_txtData.bottom = new FormAttachment(lblPreo, 0, SWT.BOTTOM);
		fd_txtData.right = new FormAttachment(label, 0, SWT.RIGHT);
		txtData.setLayoutData(fd_txtData);

		btnBuscarMercadoria = new Button(shlNovaVenda, SWT.NONE);
		btnBuscarMercadoria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				mercadoria = new Mercadoria();
				MercadoriaUser mercadoriaUser = new MercadoriaUser();
				idMercadoria = Integer.parseInt(txtCodigo.getText());
				mercadoria = mercadoriaUser.buscarMercadoria(idMercadoria);

				txtMercadoria.setText(mercadoria.getMercadoria());
				txtEstoque.setText(mercadoria.getEstoque() + "");

				preco = Integer.parseInt(mercadoria.getPreco());
				quantidade = mercadoria.getEstoque();

				txtPreco.setText(mercadoria.getPreco());

				btnBuscarMercadoria.setEnabled(false);
				btnConcluir.setEnabled(true);
				btnCancelar.setEnabled(true);
				txtMercadoria.setEnabled(false);
				txtEstoque.setEnabled(false);

			}
		});
		btnBuscarMercadoria.setText("Buscar");
		FormData fd_btnBuscarMercadoria = new FormData();
		fd_btnBuscarMercadoria.left = new FormAttachment(txtCodigo, 20);
		fd_btnBuscarMercadoria.right = new FormAttachment(txtMercadoria, -27);
		fd_btnBuscarMercadoria.top = new FormAttachment(lblCodigo, -5, SWT.TOP);
		btnBuscarMercadoria.setLayoutData(fd_btnBuscarMercadoria);

		btnNovaVenda = new Button(shlNovaVenda, SWT.NONE);
		btnNovaVenda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				txtResultado.setEnabled(false);
				txtBuscaCod.setEnabled(true);
				txtCliente.setEnabled(true);
				txtCodigo.setEnabled(true);
				txtMercadoria.setEnabled(true);
				txtPreco.setEnabled(true);
				txtQuantidade.setEnabled(true);
				txtData.setEnabled(true);

				txtResultado.setText("");
				txtBuscaCod.setText("");
				txtCliente.setText("");
				txtCodigo.setText("");
				txtMercadoria.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				txtData.setText("");
				txtEstoque.setText("");

				btnBuscarMercadoria.setEnabled(true);
				btnBuscarCliente.setEnabled(true);
				btnConcluir.setEnabled(true);
				btnNovaVenda.setEnabled(false);
				btnCancelar.setEnabled(true);

			}
		});
		btnNovaVenda.setText("Nova Venda");
		FormData fd_btnNovaVenda = new FormData();
		fd_btnNovaVenda.top = new FormAttachment(btnCancelar, 0, SWT.TOP);
		fd_btnNovaVenda.left = new FormAttachment(btnCancelar, 6);
		fd_btnNovaVenda.right = new FormAttachment(100, -189);
		btnNovaVenda.setLayoutData(fd_btnNovaVenda);

		Button btnVista = new Button(shlNovaVenda, SWT.CHECK);
		btnVista.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				opcao = false;
				// btnVista.setSize(false);

			}
		});
		fd_btnPrazo.top = new FormAttachment(btnVista, 6);
		fd_btnPrazo.left = new FormAttachment(btnVista, 0, SWT.LEFT);
		FormData fd_btnVista = new FormData();
		fd_btnVista.left = new FormAttachment(lbPagamento, 17);
		fd_btnVista.top = new FormAttachment(lbPagamento, -1, SWT.TOP);
		btnVista.setLayoutData(fd_btnVista);
		btnVista.setText("\u00E0 Vista");

		lblEstoque = new Label(shlNovaVenda, SWT.NONE);
		lblEstoque.setText("Estoque");
		FormData fd_lblEstoque = new FormData();
		fd_lblEstoque.left = new FormAttachment(txtMercadoria, 15);
		fd_lblEstoque.bottom = new FormAttachment(lblCodigo, 0, SWT.BOTTOM);
		lblEstoque.setLayoutData(fd_lblEstoque);

		txtEstoque = new Text(shlNovaVenda, SWT.BORDER);
		FormData fd_txtEstoque = new FormData();
		fd_txtEstoque.right = new FormAttachment(label, 0, SWT.RIGHT);
		fd_txtEstoque.top = new FormAttachment(txtCodigo, 0, SWT.TOP);
		fd_txtEstoque.left = new FormAttachment(lblEstoque, 6);
		txtEstoque.setLayoutData(fd_txtEstoque);

	}
}
