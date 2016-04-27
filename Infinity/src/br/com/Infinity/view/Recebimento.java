package br.com.Infinity.view;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.Infinity.controller.ClienteUser;
import br.com.Infinity.controller.VendaUser;
import br.com.Infinity.model.Cliente;
import br.com.Infinity.model.Mercadoria;

public class Recebimento {

	private JFrame frame;
	private JTextField txtBuscaCod;
	private JTextField txtCliente;
	private JScrollPane scrollPane;
	private JTable table;
	private Button btnCancelar;
	Cliente cliente;
	Mercadoria mercadoria;
	VendaUser vendaUser;
	int idMercadoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recebimento window = new Recebimento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Recebimento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 394);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblConsultaDeCliente = new JLabel("Recebimento de Notas");
		lblConsultaDeCliente.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblConsultaDeCliente.setBounds(10, 11, 213, 26);
		frame.getContentPane().add(lblConsultaDeCliente);

		txtBuscaCod = new JTextField();
		txtBuscaCod.setBounds(40, 53, 62, 20);
		frame.getContentPane().add(txtBuscaCod);
		txtBuscaCod.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblId);

		txtCliente = new JTextField();
		txtCliente.setBounds(232, 53, 341, 20);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);

		final Button btnBuscarCliente = new Button("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cliente = new Cliente();
				ClienteUser clienteUser = new ClienteUser();
				int id = Integer.parseInt(txtBuscaCod.getText());
				cliente = clienteUser.buscarCliente(id);
				txtCliente.setText(cliente.getNome());

				btnBuscarCliente.setEnabled(false);

				txtBuscaCod.setEnabled(false);
				txtCliente.setEnabled(false);

			}
		});
		btnBuscarCliente.setBounds(126, 52, 84, 23);
		frame.getContentPane().add(btnBuscarCliente);
		
		
		
//		private final String colunas[]={"Nome:","Idade:","Sexo:"};
//	    private final String dados[][]={
//	            {"Jack","19","Masculino"},
//	            {"Eddie","56","Masculino"},
//	            {"Gina","34","Feminino"},
//	            {"Klaus","18","Masculino"},
//	            {"Erika","20","Feminino"},
//	            {"Roberto","29","Masculino"},
//	            {"Maria","30","Feminino"}};
		
		//String[][] dados = new String[10][4];
		

		// Criando Tabela de consulta Manual
	    //

		String [] colunas = {"Cod Produto", "Produto", "Quantidade", "Valor Total"}; 
		Object [][] dados = { {"1", "Tennis Nike", "1", "280,00"}, {"2", "Meia", "3", "60,00"}, {"3", "Boné", "1", "Ellus"} };



		
		
		
		
		table = new JTable(dados, colunas);
		table.setBounds(10, 171, 360, 139);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 108, 563, 184);

		frame.getContentPane().add(scrollPane);

		Button btnDadosCliente = new Button("Pagar Itens");
		btnDadosCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDadosCliente.setBounds(10, 320, 109, 23);
		frame.getContentPane().add(btnDadosCliente);

		btnCancelar = new Button("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(126, 320, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
