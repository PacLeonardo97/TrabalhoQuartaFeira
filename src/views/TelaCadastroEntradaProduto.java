package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import dao.EntradaProdutoDAO;
import dao.ProdutoDAO;

import model.EntradaProduto;
import model.Produto;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.SQLException;
import java.text.ParseException;

public class TelaCadastroEntradaProduto extends JInternalFrame implements ActionListener {
	
	public static void main(String[] args){
		new TelaCadastroEntradaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField  txtData, txtQuantidade;
    private JLabel lblData = new JLabel("Data:"), lblQuantidade= new JLabel("Quantidade:"), lblIdProduto= new JLabel("Id do Produto:");
    private JButton btnCadastrar , btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox<Object>();
    private EntradaProdutoDAO dao;
    
	public TelaCadastroEntradaProduto(){
        super("Cadastro de Entrada de Produto");
        setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
	        
	        for(Produto p: dao.buscar()){
	        	cbProdutos.addItem(p);
	        	
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cbProdutos.setBounds(139, 123, 153, 22);
		getContentPane().add(cbProdutos);
		
		lblData.setBounds(55, 36, 40, 20);
		getContentPane().add(lblData);
		
		lblQuantidade.setBounds(33, 82, 74, 20);
		getContentPane().add(lblQuantidade);
		
		lblIdProduto.setBounds(33, 124, 74, 20);
		getContentPane().add(lblIdProduto);
			
		txtData = new JTextField(20);
		txtData.setBounds(139, 36, 153, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		txtQuantidade = new JTextField(20);
		txtQuantidade.setBounds(139, 82, 153, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		this.setSize(332, 286);
        this.setResizable(false);
        getContentPane().setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(55, 188, 89, 34);
		getContentPane().add(btnCadastrar);	
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(184, 188, 89, 34);
		getContentPane().add(btnLimpar);
		
		
        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        
		setVisible(true);
		getContentPane().setLayout(null);	
    }
    
    public void actionPerformed(ActionEvent cadastrar){
    	
    	if(cadastrar.getSource() == btnCadastrar){	  	
				try {
					
					Date pData;
				    String nData = txtData.getText();
				    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					pData = formato.parse(nData);
					txtData.setText(nData); 
					
					String dQuantidade = txtQuantidade.getText();
				    int sQuantidade = Integer.parseInt(dQuantidade);
				    txtQuantidade.setText(""+sQuantidade);
		            
		            Produto ProdutoSelecionado = (Produto) this.cbProdutos.getSelectedItem();
		            System.out.println(ProdutoSelecionado);
		            EntradaProduto entradaProduto = new EntradaProduto(pData, sQuantidade, ProdutoSelecionado);
		            
		            this.dao = new EntradaProdutoDAO();
		            dao.incluir(entradaProduto);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			   
		} else if (cadastrar.getSource() == btnLimpar){
			
		}
    }	
}