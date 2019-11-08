package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.ProdutoDAO;
import model.Produto;

public class TelaConsultaProduto extends JInternalFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTable tabelaProduto;
	private JScrollPane scrollPane;
	private JButton btnAtualizar = new JButton("Atualizar"), btnDeletar = new JButton("Deletar");
	private JTextField txtNome = new JTextField(), txtDescricao = new JTextField(), txtPeso = new JTextField();
	private JLabel lblNome = new JLabel("Nome"), lblQuantidade = new JLabel("Quantidade"), lblPeso = new JLabel("Peso");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaProduto frame = new TelaConsultaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ViewJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProduto.getModel();
        tabelaProduto.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
        readJTable();
	}
	
	public void readJTable() {
        try {
        	 DefaultTableModel modelo = (DefaultTableModel) tabelaProduto.getModel();
             modelo.setNumRows(0);
             ProdutoDAO dao = new ProdutoDAO();
             
             for (Produto p : dao.buscar()) {
                 modelo.addRow(new Object[]{
                    p.getIdProduto(),
                    p.getNomeProduto(),
                    p.getDescricaoProduto(),
                    p.getPesoProduto(),
                    convertStringToDate(p.getDataCriacao())
                 });
             }
		} catch (Exception e) {
			System.out.println(e);
		}
    }
	
	public String convertStringToDate(Date indate){
		   String dateString = null;
		   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
		   try{
			   dateString = sdfr.format( indate );
			   return dateString;
		   }catch (Exception ex ){
			   return "";
		   }
	}


	public TelaConsultaProduto() {
		super("Tela de Consulta de Produto");
		setClosable(true);
		setIconifiable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 749, 484);
		
		tabelaProduto= new JTable();
		scrollPane = new JScrollPane(tabelaProduto);
		scrollPane.setViewportView(tabelaProduto);
		scrollPane.setBounds(30, 113, 635, 295);
		getContentPane().add(scrollPane);
		
		lblNome.setBounds(99, 23, 48, 14);
        getContentPane().add(lblNome);
        
        lblQuantidade.setBounds(272, 23, 89, 14);
        getContentPane().add(lblQuantidade);
        
        lblPeso.setBounds(501, 23, 48, 14);
        getContentPane().add(lblPeso);
		
        txtNome = new JTextField();
        txtNome.setBounds(52, 48, 136, 20);
        getContentPane().add(txtNome);
        txtNome.setColumns(10);
        
        txtDescricao = new JTextField();
        txtDescricao.setBounds(248, 48, 136, 20);
        getContentPane().add(txtDescricao);
        txtDescricao.setColumns(10);
        
        txtPeso = new JTextField();
        txtPeso.setBounds(457, 48, 136, 20);
        getContentPane().add(txtPeso);
        txtPeso.setColumns(10);
		
		btnDeletar.setBounds(340, 79, 89, 23);
        getContentPane().add(btnDeletar);
        
        btnAtualizar.setBounds(174, 79, 89, 23);
	    getContentPane().add(btnAtualizar);
		
		tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {},
	            	new String [] {
	                    "ID", "Nome do produto", "Quantidade", "Peso", "Criado em"
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
		
		tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	jTFuncionarioMouseClicked(evt);
            }});
	
		tabelaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
        	jFuncionarioKeyReleased(evt);
        	}});
		
		readJTable();
		btnDeletar.addActionListener(this);
        btnAtualizar.addActionListener(this);	
		
	}
	
	private void jTFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaProduto.getSelectedRow() != -1) {
    		txtNome.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
    		txtDescricao.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
            txtPeso.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
        }
    }
    
    private void jFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaProduto.getSelectedRow() != -1) {
        	txtNome.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
        	txtDescricao.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
            txtPeso.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
        }
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnDeletar) {
    		if (tabelaProduto.getSelectedRow() != -1) {
				try {
					Produto p = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					dao = new ProdutoDAO();
					
					p.setIdProduto((int) tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0));
					
					dao.excluir(p);
					
					txtNome.setText("");
					txtDescricao.setText("");
		            txtPeso.setText("");
		            readJTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecione um Funcionario para excluir.");
	        }
    	}
    	else if(e.getSource() == btnAtualizar) {
    		if (tabelaProduto.getSelectedRow() != -1) {
				try {
					Produto p = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					p.setNomeProduto(txtNome.getText());
					p.setDescricaoProduto(txtDescricao.getText());
					p.setPesoProduto(Integer.parseInt(txtPeso.getText()));
					
					p.setIdProduto((int) tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0));
					
					dao.update(p);
					
					txtNome.setText("");
					txtDescricao.setText("");
					txtPeso.setText("");
					
		            readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    	}
    }

}
