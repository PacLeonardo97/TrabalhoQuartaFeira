
package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.EntradaProdutoDAO;
import model.EntradaProduto;
import model.Produto;

public class TelaConsultaEntradaProduto extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTable tabelaEntradaProduto;
	private JButton btnDeletar = new JButton("Deletar"), btnAtualizar = new JButton("Atualizar");;
	private JTextField txtData, txtQuantidade;
	private EntradaProdutoDAO dao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					TelaConsultaEntradaProduto frame = new TelaConsultaEntradaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ViewJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEntradaProduto.getModel();
        tabelaEntradaProduto.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
        readJTable();
	}
	
	public void readJTable() {
        try {
        	 DefaultTableModel modelo = (DefaultTableModel) tabelaEntradaProduto.getModel();
             modelo.setNumRows(0);
             
             EntradaProdutoDAO dao = new EntradaProdutoDAO();
             ArrayList<Object> f = dao.buscar();
             Iterator<Object> iter = f.iterator(); 
             
             while(iter.hasNext()) {
            	 EntradaProduto ep = (EntradaProduto) iter.next();
            	 Produto p = (Produto) iter.next();
                 modelo.addRow(new Object[]{	
                	 ep.getIdEntradaProduto(),
                     convertStringToDate(ep.getDataEntrada()),
                     ep.getQuantidade(),
                     p.getNomeProduto(),
                     p.getDescricaoProduto(),
                     p.getPesoProduto(),
                     convertStringToDate(ep.getDataCriada())
                 }
                 );
                 
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
	
	public TelaConsultaEntradaProduto() {
		super("Consulta de entrada produto");
		setClosable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 768, 500);
		getContentPane().setLayout(null);
		
		tabelaEntradaProduto = new JTable();
		
		scrollPane = new JScrollPane(tabelaEntradaProduto);
		scrollPane.setViewportView(tabelaEntradaProduto);
		scrollPane.setBounds(31, 151, 685, 295);
		getContentPane().add(scrollPane);
       
        
        btnDeletar.setBounds(287, 97, 89, 48);
        getContentPane().add(btnDeletar);
        
        btnAtualizar.setBounds(119, 97, 89, 48);
        getContentPane().add(btnAtualizar);
        
        txtData = new JTextField();
        txtData.setBounds(90, 48, 136, 28);
        getContentPane().add(txtData);
        txtData.setColumns(10);
        
        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(288, 48, 136, 28);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setColumns(10);
        
        JLabel lblData = new JLabel("Data");
        lblData.setBounds(134, 23, 48, 14);
        getContentPane().add(lblData);
        
        JLabel lblQuantidade = new JLabel("Quantidade");
        lblQuantidade.setBounds(309, 23, 98, 14);
        getContentPane().add(lblQuantidade);
        
        
        tabelaEntradaProduto.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "id", "Data de entrada", "Quantidade", "Nome do Produto", "Descrição do produto","Peso do Produto", "Criado em"
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
        
        tabelaEntradaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });        
        
        tabelaEntradaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        
        btnDeletar.addActionListener( (e) -> {
           
        });
        
        
        
        btnAtualizar.addActionListener(this);
        btnDeletar.addActionListener(this);
        
        this.setResizable(false);
        readJTable();
	}
	
	private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaEntradaProduto.getSelectedRow() != -1) {
            txtData.setText(tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 1).toString());
            txtQuantidade.setText(tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 2).toString());
        }
    }
	
	
    
    
    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaEntradaProduto.getSelectedRow() != -1) {
        	txtData.setText(tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 1).toString());
        	txtQuantidade.setText(tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 2).toString());
        }
    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDeletar) {
			if (tabelaEntradaProduto.getSelectedRow() != -1) {
				try {
					EntradaProduto ep = new EntradaProduto();
					dao = new EntradaProdutoDAO();
					ep.setIdEntradaProduto((int) tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 0));
					dao.excluir(ep);
					
					txtQuantidade.setText("");
					txtData.setText("");
					
					readJTable();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if(e.getSource() == btnAtualizar) {
			if (tabelaEntradaProduto.getSelectedRow() != -1) {
				try {
					EntradaProduto ep = new EntradaProduto();
					dao = new EntradaProdutoDAO();
					
					ep.getDataEntrada();
					
					Date pData;
					String nData = txtData.getText();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					pData = formato.parse(nData);
					txtData.setText(nData); 
					ep.setDataEntrada(pData);
					
					ep.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
					ep.setIdEntradaProduto((int) tabelaEntradaProduto.getValueAt(tabelaEntradaProduto.getSelectedRow(), 0));
					dao.update(ep);
					
					txtData.setText("");
					txtQuantidade.setText("");
					
					readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
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
