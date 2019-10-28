package views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.FornecedorDAO;
import model.Fornecedor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaConsultaFornecedor extends JFrame implements ActionListener{
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
	
	private static final long serialVersionUID = 1L;
	private FornecedorDAO DAO;

	private JPanel contentPane;
	private JTable tabelaFuncionario;
	private JScrollPane scrollPane;
	private String[] colunasTabela = {"Id", "Nome", "Fone", "CNPJ"};
	private JButton btnDeletar = new JButton("Deletar");
	private JTextField txtNome, txtTelefone,  txtcnpj;
	private FornecedorDAO dao;
	
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
		scrollPane.setBounds(30, 113, 498, 295);
		getContentPane().add(scrollPane);
        this.setResizable(false);
        getContentPane().setLayout(null);
        
     
        btnDeletar.setBounds(64, 79, 89, 23);
        getContentPane().add(btnDeletar);
        
        txtNome = new JTextField();
        txtNome.setBounds(41, 48, 136, 20);
        getContentPane().add(txtNome);
        txtNome.setColumns(10);
        
        txtTelefone = new JTextField();
        txtTelefone.setBounds(223, 48, 136, 20);
        getContentPane().add(txtTelefone);
        txtTelefone.setColumns(10);
        
        txtcnpj = new JTextField();
        txtcnpj.setBounds(393, 48, 136, 20);
        getContentPane().add(txtcnpj);
        txtcnpj.setColumns(10);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(78, 24, 48, 14);
        getContentPane().add(lblNome);
        
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(263, 23, 48, 14);
        getContentPane().add(lblTelefone);
        
        JLabel lblCnpj = new JLabel("CNPJ");
        lblCnpj.setBounds(449, 23, 48, 14);
        getContentPane().add(lblCnpj);
        
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        
        tabelaFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        
        btnDeletar.addActionListener(this);
	}
	
	private String[][] carregarDadosCliente() {
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

	
	
    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionario.getModel();
        modelo.setNumRows(0);
        FornecedorDAO dao = null;

        try {
			dao = new FornecedorDAO(); 
			for (Fornecedor p : dao.buscar()) {
	            modelo.addRow(new Object[]{
	                p.getIdFornecedor(),
	                p.getNome(),
	                p.getTelefone(),
	                p.getCNPJ()
	            });
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaFuncionario.getSelectedRow() != -1) {
    		System.out.println(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0).toString());
            txtNome.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 1).toString());
            txtTelefone.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 2).toString());
            txtcnpj.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 3).toString());
        }
    }
    
    
    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaFuncionario.getSelectedRow() != -1) {
            txtNome.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 1).toString());
            txtTelefone.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 2).toString());
            txtcnpj.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 3).toString());

        }
    }
    
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDeletar) {
			if (tabelaFuncionario.getSelectedRow() != -1) {
				try {
					Fornecedor p = new Fornecedor();
			        
					dao = new FornecedorDAO();
					
					p.setIdFornecedor(Integer.parseInt((String) tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0)) );
					
					dao.excluir(p);
					
					txtNome.setText("");
		            txtTelefone.setText("");
		            txtcnpj.setText("");
		            carregarDadosCliente();
		            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecione um Fornecedor para excluir.");
	        }
		}
	}
}
