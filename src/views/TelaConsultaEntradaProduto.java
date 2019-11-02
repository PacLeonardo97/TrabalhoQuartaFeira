package views;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.EntradaProdutoDAO;
import model.EntradaProduto;
import model.Produto;

public class TelaConsultaEntradaProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabelaEntradaProduto;
	private JButton btnDeletar = new JButton("Deletar"), btnAtualizar = new JButton("Atualizar");;
	private JTextField txtData, txtQuantidade;
	
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
                     convertStringToDate(ep.getDataEntrada()),
                     ep.getQuantidade(),
                     p.getNomeProduto(),
                     p.getDescricaoProduto(),
                     p.getPesoProduto(),
                     convertStringToDate(ep.getDataCriada())
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
	public TelaConsultaEntradaProduto() {
		super("Sde entrada produto");
		
		setBounds(100, 100, 768, 500);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		tabelaEntradaProduto = new JTable();
		
		scrollPane = new JScrollPane(tabelaEntradaProduto);
		scrollPane.setViewportView(tabelaEntradaProduto);
		scrollPane.setBounds(30, 113, 685, 295);
		getContentPane().add(scrollPane);
        this.setResizable(false);
        
        btnDeletar.setBounds(348, 79, 89, 23);
        getContentPane().add(btnDeletar);
        
        txtData = new JTextField();
        txtData.setBounds(172, 48, 136, 20);
        getContentPane().add(txtData);
        txtData.setColumns(10);
        
        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(351, 48, 136, 20);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setColumns(10);
        
        JLabel lblData = new JLabel("Nome");
        lblData.setBounds(208, 23, 48, 14);
        getContentPane().add(lblData);
        
        JLabel lblQuantidade = new JLabel("Telefone");
        lblQuantidade.setBounds(389, 24, 48, 14);
        getContentPane().add(lblQuantidade);
        
        btnAtualizar.setBounds(208, 79, 89, 23);
        getContentPane().add(btnAtualizar);
        
        tabelaEntradaProduto.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "Data de entrada", "Quantidade", "Nome do Produto", "Descri��o do produto","Peso do Produto", "Criado em"
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
        
        readJTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
}
