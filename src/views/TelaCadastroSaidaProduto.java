package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import dao.ProdutoDAO;
import dao.SaidaProdutoDAO;
import model.EntradaProduto;
import model.Produto;
import model.SaidaProduto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;


public class TelaCadastroSaidaProduto extends JInternalFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroSaidaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField txtData, txtQuantidade;
	private JLabel lblData = new JLabel("Data:"), lblQuantidade= new JLabel("Quantidade:"), lblIdProduto= new JLabel("Id do Produto:");
    private JButton btnCadastrar, btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox<Object>();
    private SaidaProdutoDAO dao;
    
    public TelaCadastroSaidaProduto(){
        super("Cadastro de Saída de Produto");
        setClosable(true);
		setIconifiable(true);
		
        try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));	
         } catch (ParseException e) {
            e.printStackTrace();
         }
        
		try {
			ProdutoDAO dao = new ProdutoDAO();
	        
	        for(Produto p: dao.buscar()){
	        	cbProdutos.addItem(p);
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cbProdutos.setBounds(143, 121, 153, 28);
		getContentPane().add(cbProdutos);
		
		lblData.setBounds(48, 25, 85, 20);
		getContentPane().add(lblData);
		
		lblQuantidade.setBounds(48, 73, 97, 20);
		getContentPane().add(lblQuantidade);
		
		lblIdProduto.setBounds(48, 125, 97, 20);
		getContentPane().add(lblIdProduto);
	
		txtData.setBounds(143, 21, 148, 28);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		txtQuantidade = new JTextField(20);
		txtQuantidade.setBounds(143, 65, 153, 28);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		this.setSize(340, 320);
        this.setResizable(false);
        getContentPane().setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(44, 184, 89, 48);
		getContentPane().add(btnCadastrar);	
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(207, 184, 89, 48);
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
		setBounds(100, 100, 345, 315);
		getContentPane().setLayout(null);	
    }  
    
    public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource() == btnCadastrar){	  
			if (!txtData.getText().equals("") && !txtQuantidade.getText().equals("")) {
				try {	  			
					//come�o data
					Date pData;
				    String nData = txtData.getText();
				    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					pData = formato.parse(nData);
					txtData.setText(nData); 
				    //fim data 
				         
				    String dQuantidade = txtQuantidade.getText();
				    int sQuantidade = Integer.parseInt(dQuantidade);
				    txtQuantidade.setText(""+sQuantidade);

				    EntradaProduto ProdutoSelecionado = (EntradaProduto) this.cbProdutos.getSelectedItem();

		            SaidaProduto saidaProduto = new SaidaProduto(pData, sQuantidade, ProdutoSelecionado);
		            this.dao = new SaidaProdutoDAO();
		            this.dao.incluir(saidaProduto);
		            
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Algum Campo está faltando!!!");
			}
		} else if (cadastrar.getSource() == btnLimpar){
			txtData.setText("");
			txtQuantidade.setText("");
		
		  }
		
		else {
		JOptionPane.showMessageDialog(this, "O campo Quantidade deve conter somente numeros");
	}
	
}
    
    public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}