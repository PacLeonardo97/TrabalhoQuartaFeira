package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.EntradaProdutoDAO;
import dao.SaidaProdutoDAO;
//import dao.SaidaProdutoDAO;
import model.Produto;
import model.SaidaProduto;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaConsultaSaidaProduto extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtData, txtQuantidade;
	private JTable tabelaSaidaProduto;
	private JScrollPane scrollPane;
	private JButton btnDeletar = new JButton("Deletar"), btnAtualizar = new JButton("Atualizar");;
//	private SaidaProdutoDAO dao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaSaidaProduto frame = new TelaConsultaSaidaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ViewJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaSaidaProduto.getModel();
        tabelaSaidaProduto.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
        readJTable();
	}
	
	public void readJTable() {
        try {
        	 DefaultTableModel modelo = (DefaultTableModel) tabelaSaidaProduto.getModel();
             modelo.setNumRows(0);
             
             SaidaProdutoDAO dao = new SaidaProdutoDAO();
             ArrayList<Object> f = dao.buscar();
             Iterator<Object> iter = f.iterator(); 
             
             while(iter.hasNext()) {
            	 SaidaProduto sp = (SaidaProduto) iter.next();
            	 Produto p = (Produto) iter.next();
                 modelo.addRow(new Object[]{	
                	 sp.getIdSaidaProduto(),
                     convertStringToDate(sp.getDataSaida()),
                     sp.getQuantidade(),
                     
                     p.getNomeProduto(),
                     p.getDescricaoProduto(),
                     p.getPesoProduto(),
//                     convertStringToDate(ep.getDataCriada())
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

	public TelaConsultaSaidaProduto() {
		setBounds(100, 100, 660, 496);
		getContentPane().setLayout(null);
		
		
		txtData = new JTextField();
		txtData.setBounds(99, 55, 141, 28);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		tabelaSaidaProduto = new JTable();
		scrollPane = new JScrollPane(tabelaSaidaProduto);
		scrollPane.setViewportView(tabelaSaidaProduto);
		scrollPane.setBounds(31, 151, 574, 295);
		getContentPane().add(scrollPane);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(305, 55, 141, 28);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(138, 30, 48, 14);
		getContentPane().add(lblData);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(317, 30, 69, 14);
		getContentPane().add(lblQuantidade);
		
		btnDeletar.setBounds(287, 97, 89, 48);
	    getContentPane().add(btnDeletar);
	        
	    btnAtualizar.setBounds(119, 97, 89, 48);
	    getContentPane().add(btnAtualizar);
		
	    
	    tabelaSaidaProduto.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "id", "Data de Saida", "Quantidade", "Nome do Produto", "Descrição do produto","Peso do Produto", "Criado em"
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
		
		tabelaSaidaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        
		tabelaSaidaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
		
		btnAtualizar.addActionListener(this);
        btnDeletar.addActionListener(this);
        
        this.setResizable(false);
        readJTable();
	}
	
	private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {
    	if (tabelaSaidaProduto.getSelectedRow() != -1) {
            txtData.setText(tabelaSaidaProduto.getValueAt(tabelaSaidaProduto.getSelectedRow(), 1).toString());
            txtQuantidade.setText(tabelaSaidaProduto.getValueAt(tabelaSaidaProduto.getSelectedRow(), 2).toString());
        }
    }
    
    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {
        if (tabelaSaidaProduto.getSelectedRow() != -1) {
        	txtData.setText(tabelaSaidaProduto.getValueAt(tabelaSaidaProduto.getSelectedRow(), 1).toString());
        	txtQuantidade.setText(tabelaSaidaProduto.getValueAt(tabelaSaidaProduto.getSelectedRow(), 2).toString());
        }
    }
    
//	public void setPosicao() {
//		Dimension d = this.getDesktopPane().getSize();
//		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
//	}

	public void actionPerformed(ActionEvent e) {		
		
	}
}
