package views;

import javax.swing.JTextField;

import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.EntradaProdutoDAO;
import dao.ProdutoDAO;
import model.Produto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaCadastroEntradaProduto extends JFrame implements ActionListener {
	
	public static void main(String[] args){
		new TelaCadastroEntradaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField txtQuantidade;
	private UtilDateModel model = new UtilDateModel();
	
    private JLabel lblData = new JLabel("Data:"), lblQuantidade= new JLabel("Quantidade:"), lblIdProduto= new JLabel("Id do Produto:");
    private JButton btnCadastrar , btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox<Object>();
    private EntradaProdutoDAO dao;
    
	public TelaCadastroEntradaProduto(){
        super("Cadastro de Entrada de Produto");
//        setClosable(true);
//		setIconifiable(true);
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
	        
	        for(Produto p: dao.buscar()){
	        	cbProdutos.addItem(p);
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		cbProdutos.setBounds(168, 293, 153, 28);
		getContentPane().add(cbProdutos);
		
		lblData.setBounds(131, 37, 85, 20);
		getContentPane().add(lblData);
		
		lblQuantidade.setBounds(48, 248, 97, 20);
		getContentPane().add(lblQuantidade);
		
		lblIdProduto.setBounds(48, 297, 97, 20);
		getContentPane().add(lblIdProduto);

//		Properties p = new Properties();
//
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//		
//		getContentPane().add(datePanel);
//		datePanel.setBounds(28, 68, 326, 150);
		
	
		
		txtQuantidade = new JTextField(20);
		txtQuantidade.setBounds(168, 244, 153, 28);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		this.setSize(393, 534);
        this.setResizable(false);
        getContentPane().setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(56, 344, 89, 48);
		getContentPane().add(btnCadastrar);	
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(218, 344, 89, 48);
		getContentPane().add(btnLimpar);
		
		
        btnCadastrar.addActionListener(this);
        
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                 btnCadastrar.doClick();
                }
             }
         });
        btnLimpar.addActionListener(this);
        
		setVisible(true);
		getContentPane().setLayout(null);	
    }
    
    public void actionPerformed(ActionEvent cadastrar){
    	if(Pattern.matches("[a-zA-Z]+", txtQuantidade.getText()) == false) {
    		if(cadastrar.getSource() == btnCadastrar){	  	
//				try {
					String pData;
				    Date nData = model.getValue();
//				    model.getValue().toString();
				    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//					pData = formato.parse(model.getValue());
//					txtData.setText(nData); 
					System.out.println( model.getValue().toString());
					String dQuantidade = txtQuantidade.getText();
				    int sQuantidade = Integer.parseInt(dQuantidade);
				    txtQuantidade.setText(""+sQuantidade);
		            
		            Produto ProdutoSelecionado = (Produto) this.cbProdutos.getSelectedItem();
//		            System.out.println(ProdutoSelecionado);
//		            EntradaProduto entradaProduto = new EntradaProduto(pData, sQuantidade, ProdutoSelecionado);
//		            
//		            this.dao = new EntradaProdutoDAO();
//		            dao.incluir(entradaProduto);
//		            JOptionPane.showMessageDialog(this, "entrada produto criado");
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			} else if (cadastrar.getSource() == btnLimpar){
				
			}
    	}else {
    		JOptionPane.showMessageDialog(this, "O campo Quantidade deve conter somente numeros");
    	}
    	
    }
    
//    public void setPosicao() {
//	    Dimension d = this.getDesktopPane().getSize();
//	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
//	}
    
}