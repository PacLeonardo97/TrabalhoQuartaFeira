package views;
import javax.swing.JFrame;
import javax.swing.JTextField;
import dao.ProdutoDAO;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroEntradaProduto extends JFrame implements ActionListener, ItemListener {
	public static void main(String[] args){
		new TelaCadastroEntradaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField  txtData, txtQuantidade;
    private JLabel lblData= new JLabel("Data:"), lblQuantidade= new JLabel("Quantidade:"), lblIdProduto= new JLabel("Id do Produto:");
    private JButton btnCadastrar , btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox();
    
	public TelaCadastroEntradaProduto(){
        super("Cadastro de Entrada de Produto");

		try {
			ProdutoDAO dao = new ProdutoDAO();
	        
	        for(Produto p: dao.buscar()){
	        	cbProdutos.addItem(p.getNomeProduto());
	        	
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cbProdutos.addItemListener(this);
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
        this.setResizable(false); //Não tem mais o botão para maximizar e o tamanho é sempre padrão
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
    }
    
    public void actionPerformed(ActionEvent cadastrar){
    	
//    	if(cadastrar.getSource() == btnCadastrar){	  
//
//			try {	  			
//				//começo data
//				Date pData;
//			    String nData = txtData.getText();
//			    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//				pData = formato.parse(nData);
//				txtData.setText(nData); 
//			    //fim data 
//			         
//			    String dQuantidade = txtQuantidade.getText();
//			    int sQuantidade = Integer.parseInt(dQuantidade);
//			    txtQuantidade.setText(""+sQuantidade);
//	            
//	           
//	            Produto produto = new Produto(prodId, nNomeProduto, nDescProduto, Prod);
//
//	            EntradaProduto entradaProduto = new EntradaProduto(pData, sQuantidade, produto);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    
//		} else if (cadastrar.getSource() == btnLimpar){
//			
//		}
    }
    
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String itemCombo = cbProdutos.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, itemCombo);
		}
	}
}