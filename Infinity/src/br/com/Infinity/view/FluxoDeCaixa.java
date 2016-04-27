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

import br.com.Infinity.controller.CaixaUser;
import br.com.Infinity.model.Caixa;

public class FluxoDeCaixa {

	JFrame frame;
	protected Shell shlFluxoDeCaixa;
	private Text textBuscaCod;
	public Button btnAlterar;
	public Button btnInserir;
	public Button btnVoltar;
	public FormData fd_textBuscaCod;
	private FormData fd_btnVoltar;
	private Label lbEntrada;
	private Text txtEntradas;
	private Label lblSaidas;
	private Text txtSaidas;
	private Label lblPrazo;
	private Text txtaPrazo;
	private Text txtSaldoTotal;
	private Label lbSaldoTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FluxoDeCaixa window = new FluxoDeCaixa();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFluxoDeCaixa.open();
		shlFluxoDeCaixa.layout();
		btnAlterar.setEnabled(true);
		btnVoltar.setEnabled(true);

		while (!shlFluxoDeCaixa.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlFluxoDeCaixa = new Shell();
		shlFluxoDeCaixa.setSize(346, 334);
		shlFluxoDeCaixa.setText("Fluxo de Caixa");
		shlFluxoDeCaixa.setLayout(new FormLayout());

		btnVoltar = new Button(shlFluxoDeCaixa, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlFluxoDeCaixa.close();

			}
		});

		fd_btnVoltar = new FormData();
		fd_btnVoltar.right = new FormAttachment(100, -51);
		fd_btnVoltar.bottom = new FormAttachment(100, -27);
		btnVoltar.setLayoutData(fd_btnVoltar);
		btnVoltar.setText("Voltar");

		btnAlterar = new Button(shlFluxoDeCaixa, SWT.NONE);
		fd_btnVoltar.left = new FormAttachment(0, 167);
		btnAlterar.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Caixa caixa = new Caixa();			
				caixa.setEntradas(Double.parseDouble(txtEntradas.getText()));
				caixa.setSaidas(Double.parseDouble(txtSaidas.getText()));
				caixa.setaPrazo(Double.parseDouble(txtaPrazo.getText()));
				caixa.setSaldoCaixa(Double.parseDouble(txtSaldoTotal.getText()));

				CaixaUser caixaUser = new CaixaUser();
				caixaUser.alterarCaixa(caixa);

				JOptionPane.showMessageDialog(null,
						"Caixa atualizado!");

			}
		});

		FormData fd_btnAlterar = new FormData();
		fd_btnAlterar.bottom = new FormAttachment(100, -27);
		fd_btnAlterar.right = new FormAttachment(btnVoltar, -6);
		btnAlterar.setLayoutData(fd_btnAlterar);
		btnAlterar.setText("Alterar");

		textBuscaCod = new Text(shlFluxoDeCaixa, SWT.BORDER);
		fd_textBuscaCod = new FormData();
		fd_textBuscaCod.right = new FormAttachment(100, -261);
		fd_textBuscaCod.left = new FormAttachment(0, 68);
		fd_textBuscaCod.bottom = new FormAttachment(100, -100);
		textBuscaCod.setLayoutData(fd_textBuscaCod);

		btnInserir = new Button(shlFluxoDeCaixa, SWT.NONE);
		fd_btnAlterar.left = new FormAttachment(btnInserir, 92);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		FormData fd_btnInserir = new FormData();
		fd_btnInserir.left = new FormAttachment(0, 10);
		fd_btnInserir.right = new FormAttachment(100, -371);
		fd_btnInserir.bottom = new FormAttachment(100, -27);
		btnInserir.setLayoutData(fd_btnInserir);
		btnInserir.setText("Inserir");

		lbEntrada = new Label(shlFluxoDeCaixa, SWT.NONE);
		FormData fd_lbEntrada = new FormData();
		fd_lbEntrada.top = new FormAttachment(0, 38);
		fd_lbEntrada.left = new FormAttachment(0, 10);
		lbEntrada.setLayoutData(fd_lbEntrada);
		lbEntrada.setText("(+) ENTRADAS");

		txtEntradas = new Text(shlFluxoDeCaixa, SWT.BORDER);
		FormData fd_txtEntradas = new FormData();
		fd_txtEntradas.right = new FormAttachment(lbEntrada, 102, SWT.RIGHT);
		fd_txtEntradas.top = new FormAttachment(0, 35);
		fd_txtEntradas.left = new FormAttachment(lbEntrada, 40);
		txtEntradas.setLayoutData(fd_txtEntradas);

		lblSaidas = new Label(shlFluxoDeCaixa, SWT.NONE);
		FormData fd_lblSaidas = new FormData();
		fd_lblSaidas.top = new FormAttachment(lbEntrada, 27);
		fd_lblSaidas.left = new FormAttachment(0, 10);
		lblSaidas.setLayoutData(fd_lblSaidas);
		lblSaidas.setText("(-) SA\u00CDDAS");

		txtSaidas = new Text(shlFluxoDeCaixa, SWT.BORDER);
		FormData fd_txtSaidas = new FormData();
		fd_txtSaidas.right = new FormAttachment(txtEntradas, 0, SWT.RIGHT);
		fd_txtSaidas.left = new FormAttachment(lblSaidas, 63);
		fd_txtSaidas.top = new FormAttachment(lblSaidas, -3, SWT.TOP);
		txtSaidas.setLayoutData(fd_txtSaidas);

		lblPrazo = new Label(shlFluxoDeCaixa, SWT.NONE);
		FormData fd_lblPrazo = new FormData();
		fd_lblPrazo.top = new FormAttachment(lblSaidas, 29);
		fd_lblPrazo.left = new FormAttachment(btnInserir, 0, SWT.LEFT);
		lblPrazo.setLayoutData(fd_lblPrazo);
		lblPrazo.setText("(*)\u00C0 PRAZO");

		txtaPrazo = new Text(shlFluxoDeCaixa, SWT.BORDER);
		FormData fd_txtaPrazo = new FormData();
		fd_txtaPrazo.right = new FormAttachment(txtEntradas, 0, SWT.RIGHT);
		fd_txtaPrazo.top = new FormAttachment(txtSaidas, 23);
		fd_txtaPrazo.left = new FormAttachment(lblPrazo, 56);
		txtaPrazo.setLayoutData(fd_txtaPrazo);

		txtSaldoTotal = new Text(shlFluxoDeCaixa, SWT.BORDER);
		FormData fd_txtSaldoTotal = new FormData();
		fd_txtSaldoTotal.right = new FormAttachment(txtEntradas, 0, SWT.RIGHT);
		fd_txtSaldoTotal.top = new FormAttachment(txtaPrazo, 21);
		txtSaldoTotal.setLayoutData(fd_txtSaldoTotal);

		lbSaldoTotal = new Label(shlFluxoDeCaixa, SWT.NONE);
		fd_txtSaldoTotal.left = new FormAttachment(lbSaldoTotal, 44);
		FormData fd_lbSaldoTotal = new FormData();
		fd_lbSaldoTotal.top = new FormAttachment(lblPrazo, 30);
		fd_lbSaldoTotal.left = new FormAttachment(0, 9);
		lbSaldoTotal.setLayoutData(fd_lbSaldoTotal);
		lbSaldoTotal.setText("(=)Saldo Total");

		// Setando os valores iniciais

		CaixaUser caixaUser = new CaixaUser();
		Caixa caixa = new Caixa();
		caixa = caixaUser.buscarCaixa(1);

		txtEntradas.setText(caixa.getEntradas() + "");
		txtSaidas.setText(caixa.getSaidas() + "");
		txtaPrazo.setText(caixa.getaPrazo() + "");
		txtSaldoTotal.setText(caixa.getSaldoCaixa() + "");

	}

}
