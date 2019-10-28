package views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.FornecedorDAO;
import model.Fornecedor;

public class TelaConsultaFornecedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaFornecedor frame = new TelaConsultaFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane;
	private JTable tabelaFuncionario;
	private JScrollPane scrollPane;
	private String[] colunasTabela = {"Id", "Nome", "Fone", "CNPJ"};
	
	public TelaConsultaFornecedor() {
		super("Consulta de Fornecedor");
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		String[][] dadosClientes = carregarDadosCliente();
		contentPane.setLayout(null);
		
		tabelaFuncionario = new JTable(dadosClientes, this.colunasTabela);
		scrollPane = new JScrollPane(tabelaFuncionario);
		scrollPane.setBounds(28, 78, 498, 295);
//		contentPane.add(scrollPane);
		getContentPane().add(scrollPane);
//		this.setSize(450, 700);
        this.setResizable(false);
        getContentPane().setLayout(null);
		
	}
	

	private String[][] carregarDadosCliente() {

		FornecedorDAO DAO;
		
		String[][] dadosFuncionario = null;
		try {
			DAO = new FornecedorDAO();
			ArrayList<Fornecedor> forn = DAO.buscar();
			dadosFuncionario = new String[forn.size()][4];	
			for(int i = 0; i < forn.size(); i++) {
				dadosFuncionario[i][0] = Integer.toString(forn.get(i).getIdFornecedor());
				dadosFuncionario[i][1] = forn.get(i).getNome();
				dadosFuncionario[i][2] = forn.get(i).getTelefone();
				dadosFuncionario[i][3] = forn.get(i).getCNPJ();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar lista de Fornecedor!");
			e.printStackTrace();
		}
		
		return dadosFuncionario;
	}

}
