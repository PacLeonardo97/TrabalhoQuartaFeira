package views;


import java.awt.Dimension;
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


import dao.LoginDAO;
import model.Funcionario;

public class TelaConsultaFuncionario2 extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtCPF = new JTextField(), txtNome = new JTextField();
	private JTable tabelaFuncionario;
	private JScrollPane scrollPane;
	private JLabel lblCpf = new JLabel("CPF"), lblNome = new JLabel("Nome");
	
	private JButton btnAtualizar = new JButton("Atualizar"), btnDeletar = new JButton("Deletar");
	private LoginDAO dao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaFuncionario2 frame = new TelaConsultaFuncionario2();
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
             LoginDAO dao = new LoginDAO();
             
             for (Funcionario f : dao.buscar()) {
            	 
            	 
                 modelo.addRow(new Object[]{
                		 
                     f.getidFunc(),
                     f.getCPFFuncionario(),
                     f.getNomeFuncionario(),
                     convertStringToDate(f.getData())
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


	public TelaConsultaFuncionario2() {
		super("Tela de Consulta de Funcionário");
		setClosable(true);
		setIconifiable(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 597, 490);
		
		tabelaFuncionario= new JTable();
		
		scrollPane = new JScrollPane(tabelaFuncionario);
		scrollPane.setViewportView(tabelaFuncionario);
		scrollPane.setBounds(30, 113, 498, 295);
		
		getContentPane().add(scrollPane);
        this.setResizable(false);
		
        btnDeletar.setBounds(324, 79, 89, 23);
        getContentPane().add(btnDeletar);
        
        txtNome = new JTextField();
        txtNome.setBounds(301, 48, 136, 20);
        getContentPane().add(txtNome);
        txtNome.setColumns(10);
		
        txtCPF = new JTextField();
        txtCPF.setBounds(93, 48, 136, 20);
        getContentPane().add(txtCPF);
        txtCPF.setColumns(10);
        
        lblNome.setBounds(342, 23, 48, 14);
        getContentPane().add(lblNome);
        
        lblCpf.setBounds(153, 23, 48, 14);
        getContentPane().add(lblCpf);
        
		btnAtualizar.setBounds(125, 79, 89, 23);
	    getContentPane().add(btnAtualizar);
		
		tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {},
	            	new String [] {
	                    "ID", "Cpf", "nome", "Criado em"
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
            	jTFuncionarioMouseClicked(evt);
            }});
	
		tabelaFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
        	jFuncionarioKeyReleased(evt);
        	}});
	        
		readJTable();
		btnDeletar.addActionListener(this);
        btnAtualizar.addActionListener(this);	
	}
	
	private void jTFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaFuncionario.getSelectedRow() != -1) {
            txtCPF.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 1).toString());
            txtNome.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 2).toString());
            
        }
    }
    
    private void jFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaFuncionario.getSelectedRow() != -1) {
        	txtCPF.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 1).toString());
            txtNome.setText(tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 2).toString());
           
        }
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnDeletar) {
    		if (tabelaFuncionario.getSelectedRow() != -1) {
				try {
					Funcionario f = new Funcionario();
					dao = new LoginDAO();
					
					f.setIduncionario((int) tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0));
					
					dao.excluir(f);
					
					txtCPF.setText("");
					txtNome.setText("");
		            
		            readJTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecione um Funcionario para excluir.");
	        }
    	} else if(e.getSource() == btnAtualizar) {
    		if (tabelaFuncionario.getSelectedRow() != -1) {
				try {
					Funcionario f = new Funcionario();
					dao = new LoginDAO();
					f.setCPFFuncionario(txtCPF.getText());
					f.setNomeFuncionario(txtNome.getText());
					f.setIduncionario((int) tabelaFuncionario.getValueAt(tabelaFuncionario.getSelectedRow(), 0));
					
					dao.update(f);
					
					txtCPF.setText("");
		            txtNome.setText("");
		            
		            readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
    	}
    }
    
    public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
