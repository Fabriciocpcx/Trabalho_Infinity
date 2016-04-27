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
import br.com.Infinity.controller.FuncionarioUser;
import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Funcionario;

public class CadastrarFuncionario {

	JFrame frame;
	protected Shell shlCadastroDeFuncionario;
	private Text textBuscaId;
	private Text txtnome;
	private Text txtcpf;
	private Text txttelefone;
	private Text txtSalario;
	private Text txtendereco;
	public Button btnNovoFuncionario;
	public Button btnAlterar;
	public Button btnDeletar;
	public Button btnBuscar;
	public Button btnInserir;
	public Button btnCancelar;
	private Text txtrg;
	private FormData fd_textBuscaId;
	private Label lblIdFuncionario;
	private Label label;
	private Label lblBuscarFuncionario;
	private Composite composite;
	private FormData fd_btnCancelar;
	CadastrarCliente window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastrarFuncionario window = new CadastrarFuncionario();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCadastroDeFuncionario.open();
		shlCadastroDeFuncionario.layout();
		btnInserir.setEnabled(false);
		btnCancelar.setEnabled(false);
		while (!shlCadastroDeFuncionario.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlCadastroDeFuncionario = new Shell();
		shlCadastroDeFuncionario.setSize(481, 367);
		shlCadastroDeFuncionario.setText("Cadastro de Funcionario");
		shlCadastroDeFuncionario.setLayout(new FormLayout());

		btnCancelar = new Button(shlCadastroDeFuncionario, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtSalario.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoFuncionario.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaId.setEditable(true);

			}
		});
		fd_btnCancelar = new FormData();
		btnCancelar.setLayoutData(fd_btnCancelar);
		btnCancelar.setText("Cancelar");

		btnNovoFuncionario = new Button(shlCadastroDeFuncionario, SWT.NONE);

		btnNovoFuncionario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtSalario.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(false);

				btnDeletar.setEnabled(false);
				btnNovoFuncionario.setEnabled(false);

				btnInserir.setEnabled(true);
				btnCancelar.setEnabled(true);
				textBuscaId.setEditable(false);
			}
		});

		FormData fd_btnNovoFuncionario = new FormData();
		btnNovoFuncionario.setLayoutData(fd_btnNovoFuncionario);
		btnNovoFuncionario.setText("Novo Funcionario");

		btnAlterar = new Button(shlCadastroDeFuncionario, SWT.NONE);
		fd_btnCancelar.top = new FormAttachment(btnAlterar, 0, SWT.TOP);
		fd_btnNovoFuncionario.right = new FormAttachment(100, -354);
		btnAlterar.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				btnAlterar.setEnabled(true);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(true);
				btnNovoFuncionario.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(true);
				textBuscaId.setEditable(true);

				int id = Integer.parseInt(textBuscaId.getText());

				Funcionario funcionario = new Funcionario();

				funcionario.setCpf(txtcpf.getText());
				funcionario.setEndereco(txtendereco.getText());
				funcionario.setNome(txtnome.getText());
				funcionario.setRg(txtrg.getText());
				funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
				funcionario.setTelefone(txttelefone.getText());

				FuncionarioUser funcionarioUser = new FuncionarioUser();
				funcionarioUser.alterarFuncionario(funcionario, id);

				JOptionPane.showMessageDialog(null,
						"Funcionario " + txtnome.getText()
								+ " alterado com sucesso!");

			}
		});

		FormData fd_btnAlterar = new FormData();
		btnAlterar.setLayoutData(fd_btnAlterar);
		btnAlterar.setText("Alterar");

		btnDeletar = new Button(shlCadastroDeFuncionario, SWT.NONE);
		fd_btnCancelar.right = new FormAttachment(btnDeletar, 85, SWT.RIGHT);
		fd_btnCancelar.left = new FormAttachment(btnDeletar, 6);
		fd_btnAlterar.right = new FormAttachment(100, -286);
		btnDeletar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				boolean resultado;
				FuncionarioUser funcionarioUser = new FuncionarioUser();

				int id = Integer.parseInt(textBuscaId.getText());
				resultado = funcionarioUser.excluirFuncionario(id);

				if (resultado == true) {

					JOptionPane.showMessageDialog(null,
							"Funcionario " + txtnome.getText()
									+ " excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao excluir Funcionario!");
				}

				textBuscaId.setText("");
				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtSalario.setText("");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoFuncionario.setEnabled(true);

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

		lblIdFuncionario = new Label(shlCadastroDeFuncionario, SWT.NONE);
		fd_btnNovoFuncionario.left = new FormAttachment(lblIdFuncionario, 0, SWT.LEFT);
		FormData fd_lblIdFuncionario = new FormData();
		fd_lblIdFuncionario.left = new FormAttachment(0, 10);
		lblIdFuncionario.setLayoutData(fd_lblIdFuncionario);
		lblIdFuncionario.setText("ID Funcionario");

		lblBuscarFuncionario = new Label(shlCadastroDeFuncionario, SWT.NONE);
		lblBuscarFuncionario.setText("Buscar Funcionario");
		lblBuscarFuncionario.setFont(SWTResourceManager.getFont("Tw Cen MT", 12, SWT.NORMAL));
		FormData fd_lblBuscarFuncionario = new FormData();
		fd_lblBuscarFuncionario.right = new FormAttachment(0, 139);
		fd_lblBuscarFuncionario.left = new FormAttachment(0, 10);
		fd_lblBuscarFuncionario.top = new FormAttachment(0, 10);
		lblBuscarFuncionario.setLayoutData(fd_lblBuscarFuncionario);

		label = new Label(shlCadastroDeFuncionario, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_btnNovoFuncionario.top = new FormAttachment(label, 6);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, -230);
		fd_label.right = new FormAttachment(100, -21);
		fd_label.left = new FormAttachment(0, 10);
		label.setLayoutData(fd_label);

		textBuscaId = new Text(shlCadastroDeFuncionario, SWT.BORDER);
		fd_lblIdFuncionario.top = new FormAttachment(0, 57);
		fd_textBuscaId = new FormData();
		fd_textBuscaId.left = new FormAttachment(lblIdFuncionario, 6);
		fd_textBuscaId.bottom = new FormAttachment(100, -253);
		textBuscaId.setLayoutData(fd_textBuscaId);

		btnBuscar = new Button(shlCadastroDeFuncionario, SWT.NONE);
		fd_label.top = new FormAttachment(btnBuscar, 6);
		fd_textBuscaId.right = new FormAttachment(100, -297);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Funcionario funcionario = new Funcionario();
				FuncionarioUser funcionarioUser = new FuncionarioUser();

				int id = Integer.parseInt(textBuscaId.getText());
				funcionario = funcionarioUser.buscarFuncionario(id);

				txtcpf.setText(funcionario.getCpf());
				txtendereco.setText(funcionario.getEndereco());
				txtnome.setText(funcionario.getNome());
				txtrg.setText(funcionario.getRg());
				txttelefone.setText(funcionario.getTelefone());
				txtSalario.setText(funcionario.getSalario()+"");

				btnCancelar.setEnabled(false);
				btnInserir.setEnabled(false);
				btnNovoFuncionario.setEnabled(false);
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
		fd_btnBuscar.top = new FormAttachment(lblIdFuncionario, -5, SWT.TOP);
		btnBuscar.setLayoutData(fd_btnBuscar);
		btnBuscar.setText("Buscar");

		composite = new Composite(shlCadastroDeFuncionario, SWT.NONE);
		fd_btnAlterar.top = new FormAttachment(composite, 6);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100, -41);
		fd_composite.top = new FormAttachment(btnNovoFuncionario, 15);
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

		Label lblSalario = new Label(composite_3, SWT.NONE);
		lblSalario.setText("Sal\u00E1rio");

		txtSalario = new Text(composite_3, SWT.BORDER);
		txtSalario.setLayoutData(new RowData(146, SWT.DEFAULT));

		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_4.setLayoutData(new RowData(432, 32));

		Label lblEndereo = new Label(composite_4, SWT.NONE);
		lblEndereo.setText("Endere\u00E7o");

		txtendereco = new Text(composite_4, SWT.BORDER);
		txtendereco.setLayoutData(new RowData(362, SWT.DEFAULT));

		btnInserir = new Button(shlCadastroDeFuncionario, SWT.NONE);
		fd_btnAlterar.left = new FormAttachment(btnInserir, 6);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(txtcpf.getText());
				funcionario.setEndereco(txtendereco.getText());
				funcionario.setNome(txtnome.getText());
				funcionario.setRg(txtrg.getText());
				funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
				funcionario.setTelefone(txttelefone.getText());

				FuncionarioUser funcionarioUser = new FuncionarioUser();
				funcionarioUser.cadastrarFuncionario(funcionario);

				txtcpf.setText("");
				txtendereco.setText("");
				txtnome.setText("");
				txtrg.setText("");
				txttelefone.setText("");
				txtSalario.setText("");

				JOptionPane.showMessageDialog(null, "Funcionario Salvo!");

				btnAlterar.setEnabled(false);
				btnBuscar.setEnabled(true);

				btnDeletar.setEnabled(false);
				btnNovoFuncionario.setEnabled(true);

				btnInserir.setEnabled(false);
				btnCancelar.setEnabled(false);
				textBuscaId.setEditable(true);

			}
		});
		FormData fd_btnInserir = new FormData();
		fd_btnInserir.top = new FormAttachment(composite, 6);
		fd_btnInserir.left = new FormAttachment(btnNovoFuncionario, 0, SWT.LEFT);
		fd_btnInserir.right = new FormAttachment(100, -371);
		btnInserir.setLayoutData(fd_btnInserir);
		btnInserir.setText("Inserir");

	}
}
