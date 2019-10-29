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
import javax.swing.table.TableRowSorter;

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
	

	public void ViewJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionario.getModel();
        tabelaFuncionario.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
        readJTable();
	}

	public void readJTable() {
        try {
        	 DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionario.getModel();
             modelo.setNumRows(0);
             FornecedorDAO dao = new FornecedorDAO();
             for (Fornecedor f : dao.buscar()) {
                 modelo.addRow(new Object[]{
                     f.getIdFornecedor(),
                     f.getNome(),
                     f.getTelefone(),
                     f.getCNPJ()
                 });
             }
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnDeletar = new JButton("Deletar"), btnAtualizar = new JButton("Atualizar");;
	private JTextField txtNome, txtTelefone,  txtcnpj;
	private FornecedorDAO dao;
	
	private JTable tabelaFuncionario;
	

	private TelaConsultaFornecedor() {
		super("Consulta de Fornecedor");
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		tabelaFuncionario = new JTable();
		
		scrollPane = new JScrollPane(tabelaFuncionario);
		scrollPane.setViewportView(tabelaFuncionario);
		scrollPane.setBounds(30, 113, 498, 295);
		getContentPane().add(scrollPane);
        this.setResizable(false);
        getContentPane().setLayout(null);
     
        btnDeletar.setBounds(246, 79, 89, 23);
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
        
        btnAtualizar.setBounds(51, 79, 89, 23);
        getContentPane().add(btnAtualizar);
        
        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID", "Nome", "Telefone", "CNPJ"
                }
            ) {

                private static final long serialVersionUID = 1L;

                boolean[] canEdit = new boolean[] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
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
        readJTable();
        btnDeletar.addActionListener(this);
        btnAtualizar.addActionListener(this);
	}
	
    
    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaFuncionario.getSelectedRow() != -1) {
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
					Fornecedor f = new Fornecedor();
					dao = new FornecedorDAO();
					
					f.setIdFornecedor((int) tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0));
					
					dao.excluir(f);
					
					txtNome.setText("");
		            txtTelefone.setText("");
		            txtcnpj.setText("");
		            readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecione um Fornecedor para excluir.");
	        }
			
		} else if(e.getSource() == btnAtualizar) {
			if (tabelaFuncionario.getSelectedRow() != -1) {
				try {
					Fornecedor f = new Fornecedor();
					dao = new FornecedorDAO();
					f.setNome(txtNome.getText());
					f.setTelefone(txtTelefone.getText());
					f.setCNPJ(txtcnpj.getText());
					f.setIdFornecedor((int) tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0));
					
					dao.update(f);
					
					txtNome.setText("");
		            txtTelefone.setText("");
		            txtcnpj.setText("");
		            readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		}
	}
}
