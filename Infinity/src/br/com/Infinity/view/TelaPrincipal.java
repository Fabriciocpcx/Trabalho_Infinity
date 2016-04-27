package br.com.Infinity.view;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.com.Infinity.controller.CaixaUser;
import br.com.Infinity.model.Caixa;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Caixa caixa = new Caixa();
		CaixaUser caixaUser = new CaixaUser();

		caixa.setEntradas(0);
		caixa.setSaidas(0);
		caixa.setaPrazo(0);
		caixa.setSaldoCaixa(0);

		caixaUser.iniciarCaixa(caixa);
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		// frame.setBounds(100, 100, 475, 305);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1362, 37);
		frame.getContentPane().add(menuBar);

		JMenu mnAtendimento = new JMenu("Atendimento");
		menuBar.add(mnAtendimento);

		JMenuItem mntmNovaCompra = new JMenuItem("Nova Venda");
		mntmNovaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NovaVenda novaVenda = new NovaVenda();
				novaVenda.open();

			}
		});
		mnAtendimento.add(mntmNovaCompra);

		JMenu mnFinanceiro = new JMenu("Caixa");
		menuBar.add(mnFinanceiro);

		JMenuItem mntmFluxoDeCaixa = new JMenuItem("Fluxo de caixa");
		mntmFluxoDeCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FluxoDeCaixa fluxoDeCaixa = new FluxoDeCaixa();
				fluxoDeCaixa.open();

			}
		});

		JMenuItem mntmConsultarCliente = new JMenuItem("Recebimento");
		mnFinanceiro.add(mntmConsultarCliente);
		mntmConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Recebimento();

			}
		});
		mnFinanceiro.add(mntmFluxoDeCaixa);

		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);

		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarCliente();
				CadastrarCliente cadastrarCliente = new CadastrarCliente();
				cadastrarCliente.open();
			}
		});
		mntmCadastrarCliente.addMouseListener(new MouseAdapter() {

		});
		mnNewMenu.add(mntmCadastrarCliente);

		JMenuItem mntmCadastrarFuncionario = new JMenuItem(
				"Cadastrar Funcionario");
		mntmCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastrarFuncionario cadastrarFuncionario = new CadastrarFuncionario();
				cadastrarFuncionario.open();

			}
		});
		mnNewMenu.add(mntmCadastrarFuncionario);

		JMenu mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);

		JMenuItem mntmCadastrarNovoProduto = new JMenuItem(
				"Cadastrar Mercadoria");
		mntmCadastrarNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMercadoria cadMercadoria = new CadastrarMercadoria();
				cadMercadoria.open();

			}
		});
		mnEstoque.add(mntmCadastrarNovoProduto);

		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int botaoConfirmacao = JOptionPane.YES_NO_OPTION;
				botaoConfirmacao = JOptionPane.showConfirmDialog(null,
						"Deseja Sair?");
				if (botaoConfirmacao == JOptionPane.YES_OPTION) {

					frame.dispose();

				}

			}
		});
		menuBar.add(mnSair);

		JLabel img1 = new JLabel();
		img1.setBounds(1042, 558, 278, 98);
		ImageIcon imagem = new ImageIcon(
				TelaPrincipal.class.getResource("/img/logp infinity.png"));
		Image imag = imagem.getImage().getScaledInstance(img1.getWidth(),
				img1.getHeight(), Image.SCALE_DEFAULT);

		img1.setIcon(new ImageIcon(imag));

		frame.getContentPane().add(img1);
	}
}
