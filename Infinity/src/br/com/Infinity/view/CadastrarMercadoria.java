package br.com.Infinity.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.Infinity.controller.MercadoriaUser;
import br.com.Infinity.model.Mercadoria;

public class CadastrarMercadoria {

	JFrame frame;
	protected Shell shlCadastroDeProduto;
	private Text textBuscaCod;
	private Text txtMercadoria;
	private Text txtFornecedor;
	private Text txtTelefone;
	private Text txtPreco;
	private Text txtEstoque;
	public Button btnNovaMercadoria;
	public Button btnAlterar;
	public Button btnDeletar;
	public Button btnBuscar;
	public Button btnInserir;
	public Button btnCancelar;
	private Text txtCnpf;
	private FormData fd_textBuscaCod;
	private Label lbCodigo;
	private Label lbBuscarMercadoria;
	private Composite composite;
	private FormData fd_btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastrarMercadoria window = new CadastrarMercadoria();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCadastroDeProduto.open();
		shlCadastroDeProduto.layout();
		btnInserir.setEnabled(false);
		btnCancelar.setEnabled(false);
		while (!shlCadastroDeProduto.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlCadastroDeProduto = new Shell();
		shlCadastroDeProduto.setSize(481, 334);
		shlCadastroDeProduto.setText("Cadastro de Mercadoria");
		shlCadastroDeProduto.setLayout(new FormLayout());

		btnCancelar = new Button(shlCadastroDeProduto, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaCod.setText("");
				txtFornecedor.setText("");
				txtEstoque.setText("");
				txtMercadoria.setText("");
				txtCnpf.setText("");
				txtTelefone.setText("");
				txtPreco.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovaMercadoria.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaCod.setEditable(true);

			}
		});
		fd_btnCancelar = new FormData();
		fd_btnCancelar.right = new FormAttachment(100, -102);
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		btnNovaMercadoria = new Button(shlCadastroDeProduto, SWT.NONE);

		btnNovaMercadoria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaCod.setText("");
				txtFornecedor.setText("");
				txtEstoque.setText("");
				txtMercadoria.setText("");
				txtCnpf.setText("");
				txtTelefone.setText("");
				txtPreco.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(false);

				btnDeletar.setEnabled(false);
				btnNovaMercadoria.setEnabled(false);

				btnInserir.setEnabled(true);
				btnCancelar.setEnabled(true);
				textBuscaCod.setEditable(false);
			}
		});

		FormData fd_btnNovaMercadoria = new FormData();
		btnNovaMercadoria.setLayoutData(fd_btnNovaMercadoria);
		btnNovaMercadoria.setText("Nova Mercadoria");

		btnAlterar = new Button(shlCadastroDeProduto, SWT.NONE);
		fd_btnCancelar.top = new FormAttachment(btnAlterar, 0, SWT.TOP);
		fd_btnNovaMercadoria.right = new FormAttachment(100, -354);
		btnAlterar.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				btnAlterar.setEnabled(true);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(true);
				btnNovaMercadoria.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(true);
				textBuscaCod.setEditable(true);

				int id = Integer.parseInt(textBuscaCod.getText());

				Mercadoria mercadoria = new Mercadoria();			
				
				mercadoria.setFornecedor(txtFornecedor.getText());
				mercadoria.setEstoque(Integer.parseInt(txtEstoque.getText()));
				mercadoria.setMercadoria(txtMercadoria.getText());
				mercadoria.setCnpj(txtCnpf.getText());
				mercadoria.setPreco(txtPreco.getText());
				mercadoria.setTelefone(txtTelefone.getText());

				MercadoriaUser mercadoriaUser = new MercadoriaUser();
				mercadoriaUser.alterarMercadoria(mercadoria, id);

				JOptionPane.showMessageDialog(null,
						"Mercadoria " + txtMercadoria.getText()
								+ " alterado com sucesso!");

			}
		});

		FormData fd_btnAlterar = new FormData();
		btnAlterar.setLayoutData(fd_btnAlterar);
		btnAlterar.setText("Alterar");

		btnDeletar = new Button(shlCadastroDeProduto, SWT.NONE);
		fd_btnCancelar.left = new FormAttachment(btnDeletar, 6);
		fd_btnAlterar.right = new FormAttachment(100, -285);
		btnDeletar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				boolean resultado;
				MercadoriaUser mercadoriaUser = new MercadoriaUser();

				int id = Integer.parseInt(textBuscaCod.getText());
				resultado = mercadoriaUser.excluirMercadoria(id);

				if (resultado == true) {

					JOptionPane.showMessageDialog(null,
							"Mercadoria " + txtMercadoria.getText()
									+ " excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao excluir mercadoria!");
				}

				textBuscaCod.setText("");
				txtFornecedor.setText("");
				txtEstoque.setText("");
				txtMercadoria.setText("");
				txtCnpf.setText("");
				txtTelefone.setText("");
				txtPreco.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovaMercadoria.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaCod.setEditable(true);

			}
		});
		FormData fd_btnDeletar = new FormData();
		fd_btnDeletar.top = new FormAttachment(btnAlterar, 0, SWT.TOP);
		fd_btnDeletar.left = new FormAttachment(btnAlterar, 6);
		fd_btnDeletar.right = new FormAttachment(100, -187);
		btnDeletar.setLayoutData(fd_btnDeletar);
		btnDeletar.setText("Deletar");

		lbCodigo = new Label(shlCadastroDeProduto, SWT.NONE);
		fd_btnNovaMercadoria.left = new FormAttachment(lbCodigo, 0, SWT.LEFT);
		FormData fd_lbCodigo = new FormData();
		fd_lbCodigo.left = new FormAttachment(0, 10);
		lbCodigo.setLayoutData(fd_lbCodigo);
		lbCodigo.setText("C\u00F3digo");

		lbBuscarMercadoria = new Label(shlCadastroDeProduto, SWT.NONE);
		lbBuscarMercadoria.setText("Buscar Mercadoria");
		lbBuscarMercadoria.setFont(SWTResourceManager.getFont("Tw Cen MT", 12,
				SWT.NORMAL));
		FormData fd_lbBuscarMercadoria = new FormData();
		fd_lbBuscarMercadoria.right = new FormAttachment(0, 159);
		fd_lbBuscarMercadoria.left = new FormAttachment(0, 10);
		fd_lbBuscarMercadoria.top = new FormAttachment(0, 10);
		lbBuscarMercadoria.setLayoutData(fd_lbBuscarMercadoria);

		textBuscaCod = new Text(shlCadastroDeProduto, SWT.BORDER);
		fd_lbCodigo.top = new FormAttachment(0, 57);
		fd_textBuscaCod = new FormData();
		fd_textBuscaCod.top = new FormAttachment(lbCodigo, -3, SWT.TOP);
		fd_textBuscaCod.left = new FormAttachment(lbCodigo, 6);
		textBuscaCod.setLayoutData(fd_textBuscaCod);

		btnBuscar = new Button(shlCadastroDeProduto, SWT.NONE);
		fd_textBuscaCod.right = new FormAttachment(btnBuscar, -6);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Mercadoria mercadoria = new Mercadoria();
				MercadoriaUser mercadoriaUser = new MercadoriaUser();

				int id = Integer.parseInt(textBuscaCod.getText());
				mercadoria = mercadoriaUser.buscarMercadoria(id);

				txtFornecedor.setText(mercadoria.getFornecedor());
				txtEstoque.setText(mercadoria.getEstoque()+"");
				txtMercadoria.setText(mercadoria.getMercadoria());
				txtCnpf.setText(mercadoria.getCnpj());
				txtTelefone.setText(mercadoria.getTelefone());
				txtPreco.setText(mercadoria.getPreco());

				btnCancelar.setEnabled(false);
				btnInserir.setEnabled(false);
				btnNovaMercadoria.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnBuscar.setEnabled(false);
				textBuscaCod.setEditable(false);
				btnInserir.setEnabled(false);

			}
		});
		FormData fd_btnBuscar = new FormData();
		fd_btnBuscar.right = new FormAttachment(100, -171);
		fd_btnBuscar.left = new FormAttachment(0, 210);
		fd_btnBuscar.top = new FormAttachment(lbCodigo, -5, SWT.TOP);
		btnBuscar.setLayoutData(fd_btnBuscar);
		btnBuscar.setText("Buscar");

		composite = new Composite(shlCadastroDeProduto, SWT.NONE);
		fd_btnNovaMercadoria.bottom = new FormAttachment(100, -176);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(btnCancelar, -23);
		fd_composite.top = new FormAttachment(btnNovaMercadoria, 6);
		fd_composite.left = new FormAttachment(btnNovaMercadoria, 0, SWT.LEFT);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new RowData(439, SWT.DEFAULT));
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));

		Label lbMercadoria = new Label(composite_1, SWT.NONE);
		lbMercadoria.setText("Mercadoria");

		txtMercadoria = new Text(composite_1, SWT.BORDER);
		txtMercadoria.setLayoutData(new RowData(156, SWT.DEFAULT));

		Label lbPreco = new Label(composite_1, SWT.NONE);
		lbPreco.setText("Pre\u00E7o");

		txtPreco = new Text(composite_1, SWT.BORDER);
		txtPreco.setLayoutData(new RowData(150, SWT.DEFAULT));

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayoutData(new RowData(440, SWT.DEFAULT));
		composite_2.setLayout(new RowLayout(SWT.HORIZONTAL));

		Label lbFornecedor = new Label(composite_2, SWT.NONE);
		lbFornecedor.setText("Fornecedor");

		txtFornecedor = new Text(composite_2, SWT.BORDER);
		txtFornecedor.setLayoutData(new RowData(159, SWT.DEFAULT));

		Label lbCnpj = new Label(composite_2, SWT.NONE);
		lbCnpj.setText("CNPJ");

		txtCnpf = new Text(composite_2, SWT.BORDER);
		txtCnpf.setLayoutData(new RowData(151, SWT.DEFAULT));

		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_3.setLayoutData(new RowData(439, 26));

		Label lbTelefone = new Label(composite_3, SWT.NONE);
		lbTelefone.setText("Telefone");

		txtTelefone = new Text(composite_3, SWT.BORDER);
		txtTelefone.setLayoutData(new RowData(169, SWT.DEFAULT));

		Label lbEstoque = new Label(composite_3, SWT.NONE);
		lbEstoque.setText("Estoque");

		txtEstoque = new Text(composite_3, SWT.BORDER);
		txtEstoque.setLayoutData(new RowData(141, SWT.DEFAULT));

		btnInserir = new Button(shlCadastroDeProduto, SWT.NONE);
		fd_btnAlterar.left = new FormAttachment(btnInserir, 7);
		fd_btnAlterar.top = new FormAttachment(btnInserir, 0, SWT.TOP);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setFornecedor(txtFornecedor.getText());
				mercadoria.setEstoque(Integer.parseInt(txtEstoque.getText()));
				mercadoria.setMercadoria(txtMercadoria.getText());
				mercadoria.setCnpj(txtCnpf.getText());
				mercadoria.setPreco(txtPreco.getText());
				mercadoria.setTelefone(txtTelefone.getText());
				
				
				
				

				MercadoriaUser mercadoriaUser = new MercadoriaUser();
				mercadoriaUser.cadastrarMercadoria(mercadoria);

				txtFornecedor.setText("");
				txtEstoque.setText("");
				txtMercadoria.setText("");
				txtCnpf.setText("");
				txtTelefone.setText("");
				txtPreco.setText("");

				JOptionPane.showMessageDialog(null, "Mercadoria Inserida com sucesso!");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovaMercadoria.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaCod.setEditable(true);
				

			}
		});
		FormData fd_btnInserir = new FormData();
		fd_btnInserir.left = new FormAttachment(0, 10);
		fd_btnInserir.right = new FormAttachment(100, -371);
		fd_btnInserir.bottom = new FormAttachment(100, -27);
		btnInserir.setLayoutData(fd_btnInserir);
		btnInserir.setText("Inserir");

	}

}
