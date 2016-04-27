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
import br.com.Infinity.controller.ClienteUser;
import br.com.Infinity.model.Cliente;

public class CadastrarCliente {

	JFrame frame;
	protected Shell shlCadastroDeCliente;
	private Text textBuscaId;
	private Text txtnome;
	private Text txtcpf;
	private Text txttelefone;
	private Text txtLimite;
	private Text txtendereco;
	public Button btnNovoCliente;
	public Button btnAlterar;
	public Button btnDeletar;
	public Button btnBuscar;
	public Button btnInserir;
	public Button btnCancelar;
	private Text txtrg;
	private FormData fd_textBuscaId;
	private Label lblIdCliente;
	private Label label;
	private Label label_1;
	private Composite composite;
	private FormData fd_btnCancelar;
	CadastrarCliente window;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastrarCliente window = new CadastrarCliente();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCadastroDeCliente.open();
		shlCadastroDeCliente.layout();
		btnInserir.setEnabled(false);
		btnCancelar.setEnabled(false);
		while (!shlCadastroDeCliente.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlCadastroDeCliente = new Shell();
		shlCadastroDeCliente.setSize(481, 367);
		shlCadastroDeCliente.setText("Cadastro de Cliente");
		shlCadastroDeCliente.setLayout(new FormLayout());

		btnCancelar = new Button(shlCadastroDeCliente, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtLimite.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoCliente.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaId.setEditable(true);

			}
		});
		fd_btnCancelar = new FormData();
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		btnNovoCliente = new Button(shlCadastroDeCliente, SWT.NONE);

		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtLimite.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(false);

				btnDeletar.setEnabled(false);
				btnNovoCliente.setEnabled(false);

				btnInserir.setEnabled(true);
				btnCancelar.setEnabled(true);
				textBuscaId.setEditable(false);
			}
		});

		FormData fd_btnNovoCliente = new FormData();
		btnNovoCliente.setLayoutData(fd_btnNovoCliente);
		btnNovoCliente.setText("Novo Cliente");

		btnAlterar = new Button(shlCadastroDeCliente, SWT.NONE);
		fd_btnCancelar.top = new FormAttachment(btnAlterar, 0, SWT.TOP);
		fd_btnNovoCliente.right = new FormAttachment(100, -354);
		btnAlterar.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				btnAlterar.setEnabled(true);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(true);
				btnNovoCliente.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(true);
				textBuscaId.setEditable(true);

				int id = Integer.parseInt(textBuscaId.getText());

				Cliente cliente = new Cliente();
				// cliente.setVendas(null);
				cliente.setCpf(txtcpf.getText());
				cliente.setEndereco(txtendereco.getText());
				cliente.setNome(txtnome.getText());
				cliente.setRg(txtrg.getText());
				cliente.setLimite(txtLimite.getText());
				cliente.setTelefone(txttelefone.getText());

				ClienteUser clienteUser = new ClienteUser();
				clienteUser.alterarCliente(cliente, id);

				JOptionPane.showMessageDialog(null,
						"Cliente " + txtnome.getText()
								+ " alterado com sucesso!");

			}
		});

		FormData fd_btnAlterar = new FormData();
		btnAlterar.setLayoutData(fd_btnAlterar);
		btnAlterar.setText("Alterar");

		btnDeletar = new Button(shlCadastroDeCliente, SWT.NONE);
		fd_btnCancelar.right = new FormAttachment(btnDeletar, 85, SWT.RIGHT);
		fd_btnCancelar.left = new FormAttachment(btnDeletar, 6);
		fd_btnAlterar.right = new FormAttachment(100, -286);
		btnDeletar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				boolean resultado;
				ClienteUser clienteUser = new ClienteUser();

				int id = Integer.parseInt(textBuscaId.getText());
				resultado = clienteUser.excluirCliente(id);

				if (resultado == true) {

					JOptionPane.showMessageDialog(null,
							"Cliente " + txtnome.getText()
									+ " excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao excluir cliente!");
				}

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtLimite.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoCliente.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaId.setEditable(true);

			}
		});
		FormData fd_btnDeletar = new FormData();
		fd_btnDeletar.top = new FormAttachment(btnAlterar, 0, SWT.TOP);
		fd_btnDeletar.left = new FormAttachment(btnAlterar, 6);
		fd_btnDeletar.right = new FormAttachment(100, -188);
		btnDeletar.setLayoutData(fd_btnDeletar);
		btnDeletar.setText("Deletar");

		lblIdCliente = new Label(shlCadastroDeCliente, SWT.NONE);
		fd_btnNovoCliente.left = new FormAttachment(lblIdCliente, 0, SWT.LEFT);
		FormData fd_lblIdCliente = new FormData();
		fd_lblIdCliente.left = new FormAttachment(0, 10);
		lblIdCliente.setLayoutData(fd_lblIdCliente);
		lblIdCliente.setText("ID Cliente");

		label_1 = new Label(shlCadastroDeCliente, SWT.NONE);
		label_1.setText("Buscar Cliente");
		label_1.setFont(SWTResourceManager.getFont("Tw Cen MT", 12, SWT.NORMAL));
		FormData fd_label_1 = new FormData();
		fd_label_1.left = new FormAttachment(0, 10);
		fd_label_1.top = new FormAttachment(0, 10);
		label_1.setLayoutData(fd_label_1);

		label = new Label(shlCadastroDeCliente, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_btnNovoCliente.top = new FormAttachment(label, 6);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, -230);
		fd_label.right = new FormAttachment(100, -21);
		fd_label.left = new FormAttachment(0, 10);
		label.setLayoutData(fd_label);

		textBuscaId = new Text(shlCadastroDeCliente, SWT.BORDER);
		fd_lblIdCliente.top = new FormAttachment(0, 57);
		fd_textBuscaId = new FormData();
		fd_textBuscaId.left = new FormAttachment(lblIdCliente, 6);
		fd_textBuscaId.bottom = new FormAttachment(100, -253);
		textBuscaId.setLayoutData(fd_textBuscaId);

		btnBuscar = new Button(shlCadastroDeCliente, SWT.NONE);
		fd_label.top = new FormAttachment(btnBuscar, 6);
		fd_textBuscaId.right = new FormAttachment(100, -297);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Cliente cliente = new Cliente();
				ClienteUser clienteUser = new ClienteUser();

				int id = Integer.parseInt(textBuscaId.getText());
				cliente = clienteUser.buscarCliente(id);

				txtcpf.setText(cliente.getCpf());
				txtendereco.setText(cliente.getEndereco());
				txtnome.setText(cliente.getNome());
				txtrg.setText(cliente.getRg());
				txttelefone.setText(cliente.getTelefone());
				txtLimite.setText(cliente.getLimite());

				btnCancelar.setEnabled(false);
				btnInserir.setEnabled(false);
				btnNovoCliente.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnBuscar.setEnabled(false);
				textBuscaId.setEditable(false);
				btnInserir.setEnabled(false);

			}
		});
		FormData fd_btnBuscar = new FormData();
		fd_btnBuscar.right = new FormAttachment(100, -188);
		fd_btnBuscar.left = new FormAttachment(textBuscaId, 25);
		fd_btnBuscar.top = new FormAttachment(lblIdCliente, -5, SWT.TOP);
		btnBuscar.setLayoutData(fd_btnBuscar);
		btnBuscar.setText("Buscar");

		composite = new Composite(shlCadastroDeCliente, SWT.NONE);
		fd_btnAlterar.top = new FormAttachment(composite, 6);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100, -41);
		fd_composite.top = new FormAttachment(btnNovoCliente, 15);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new RowData(434, SWT.DEFAULT));
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));

		Label lblNome = new Label(composite_1, SWT.NONE);
		lblNome.setText("Nome");

		txtnome = new Text(composite_1, SWT.BORDER);
		txtnome.setLayoutData(new RowData(379, SWT.DEFAULT));

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayoutData(new RowData(431, SWT.DEFAULT));
		composite_2.setLayout(new RowLayout(SWT.HORIZONTAL));

		Label lblCPF = new Label(composite_2, SWT.NONE);
		lblCPF.setText("CPF");

		txtcpf = new Text(composite_2, SWT.BORDER);
		txtcpf.setLayoutData(new RowData(190, SWT.DEFAULT));

		Label lblRg = new Label(composite_2, SWT.NONE);
		lblRg.setText("RG");

		txtrg = new Text(composite_2, SWT.BORDER);
		txtrg.setLayoutData(new RowData(167, SWT.DEFAULT));

		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_3.setLayoutData(new RowData(432, 26));

		Label lblTelefone = new Label(composite_3, SWT.NONE);
		lblTelefone.setText("Telefone");

		txttelefone = new Text(composite_3, SWT.BORDER);
		txttelefone.setLayoutData(new RowData(169, SWT.DEFAULT));

		Label lblLimite = new Label(composite_3, SWT.NONE);
		lblLimite.setText("Limite");

		txtLimite = new Text(composite_3, SWT.BORDER);
		txtLimite.setLayoutData(new RowData(146, SWT.DEFAULT));

		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_4.setLayoutData(new RowData(432, 32));

		Label lblEndereo = new Label(composite_4, SWT.NONE);
		lblEndereo.setText("Endere\u00E7o");

		txtendereco = new Text(composite_4, SWT.BORDER);
		txtendereco.setLayoutData(new RowData(362, SWT.DEFAULT));

		btnInserir = new Button(shlCadastroDeCliente, SWT.NONE);
		fd_btnAlterar.left = new FormAttachment(btnInserir, 6);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setVendas(null);
				cliente.setCpf(txtcpf.getText());
				cliente.setEndereco(txtendereco.getText());
				cliente.setNome(txtnome.getText());
				cliente.setRg(txtrg.getText());
				cliente.setLimite(txtLimite.getText());
				cliente.setTelefone(txttelefone.getText());

				ClienteUser clienteUser = new ClienteUser();
				clienteUser.cadastrarCliente(cliente);

				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtLimite.setText("");

				JOptionPane.showMessageDialog(null, "Cliente Salvo!");
				
				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoCliente.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaId.setEditable(true);
				

			}
		});
		FormData fd_btnInserir = new FormData();
		fd_btnInserir.top = new FormAttachment(composite, 6);
		fd_btnInserir.left = new FormAttachment(btnNovoCliente, 0, SWT.LEFT);
		fd_btnInserir.right = new FormAttachment(100, -371);
		btnInserir.setLayoutData(fd_btnInserir);
		btnInserir.setText("Inserir");

	}
}
