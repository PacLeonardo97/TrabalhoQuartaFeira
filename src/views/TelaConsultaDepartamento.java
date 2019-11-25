package views;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.DepartamentoDAO;
import model.Departamento;
import model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaConsultaDepartamento extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNome, txtLocal;
	private JScrollPane scrollPane;
	private JTable tabelaDepartamento;
	private JButton btnAtualizar = new JButton("Atualizar"), btnDeletar = new JButton("Deletar");
	private JLabel lblLocalDoDepartamento = new JLabel("Local"), lblNomeDoDepartamento = new JLabel("Nome");
	private DepartamentoDAO dao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaDepartamento frame = new TelaConsultaDepartamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ViewJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaDepartamento.getModel();
        tabelaDepartamento.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
        readJTable();
	}
	
	public void readJTable() {
        try {
       	 DefaultTableModel modelo = (DefaultTableModel) tabelaDepartamento.getModel();
            modelo.setNumRows(0);
            
            DepartamentoDAO dao = new DepartamentoDAO();
            ArrayList<Object> f = dao.buscar();
            Iterator<Object> iter = f.iterator(); 
            while(iter.hasNext()) {
            	Departamento dpto = (Departamento) iter.next();
            	Funcionario func = (Funcionario) iter.next();
            	
            	modelo.addRow(new Object[]{		
            			dpto.getIdDepartamento(),
                        dpto.getNomeDepartamento(),
                        dpto.getLocalDepartamento(),
                        
                        func.getCPFFuncionario(),
                        func.getNomeFuncionario(),
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
	
	public TelaConsultaDepartamento() {
		setBounds(100, 100, 726, 504);
		getContentPane().setLayout(null);
		setClosable(true);
		setIconifiable(true);
		
		tabelaDepartamento = new JTable();
		
		scrollPane = new JScrollPane(tabelaDepartamento);
		scrollPane.setViewportView(tabelaDepartamento);
		scrollPane.setBounds(34, 148, 635, 295);
		getContentPane().add(scrollPane);

		lblNomeDoDepartamento.setBounds(231, 23, 48, 14);
		getContentPane().add(lblNomeDoDepartamento);
		
		lblLocalDoDepartamento.setBounds(431, 23, 48, 14);
		getContentPane().add(lblLocalDoDepartamento);
				
		txtNome = new JTextField();
		txtNome.setBounds(184, 48, 136, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(377, 48, 136, 28);
		getContentPane().add(txtLocal);
		txtLocal.setColumns(10);
		
		
		tabelaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID", "Nome do departamento", "Local do Produto", "CPF do responsável", "Nome do Responsável"
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
		
		
		btnAtualizar.setBounds(211, 89, 89, 48);
        getContentPane().add(btnAtualizar);
        
        btnDeletar.setBounds(401, 87, 89, 48);
        getContentPane().add(btnDeletar);
        
		tabelaDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        
		tabelaDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
		
		readJTable();
		btnDeletar.addActionListener(this);
		btnAtualizar.addActionListener(this);

	}
	
	private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaDepartamento.getSelectedRow() != -1) {
            txtNome.setText(tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 1).toString());
            txtLocal.setText(tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 2).toString());
        }
    }
    
    
    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaDepartamento.getSelectedRow() != -1) {
        	txtNome.setText(tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 1).toString());
        	txtLocal.setText(tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 2).toString());
        }
    }
    
   
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDeletar) {
			if (tabelaDepartamento.getSelectedRow() != -1) {
				try {
					Departamento dpto = new Departamento();
					dao = new DepartamentoDAO();
					dpto.setIdDepartamento((int) tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 0));
					dao.excluir(dpto);
					
					txtNome.setText("");
					txtLocal.setText("");
					readJTable();
				} catch (SQLException e2) {
					System.out.println("Não foi possível deletar" + e2);
				}
			}
		} else if(e.getSource() == btnAtualizar) {
			if (tabelaDepartamento.getSelectedRow() != -1) {
				try {
					Departamento dpto = new Departamento();
					dao = new DepartamentoDAO();
					
					dpto.setNomeDepartamento(txtNome.getText());
					dpto.setLocaDepartamento(txtLocal.getText());
					dpto.setIdDepartamento((int) tabelaDepartamento.getValueAt(tabelaDepartamento.getSelectedRow(), 0));
					
					dao.update(dpto);
					
					txtNome.setText("");
					txtLocal.setText("");
					readJTable();
				} catch(SQLException e1){
					System.out.println("Não FOi possível atualizar" + e1);
				}
				
			}
		}
	} 
	
	public void setPosicao() {
		    Dimension d = this.getDesktopPane().getSize();
		    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}

}
