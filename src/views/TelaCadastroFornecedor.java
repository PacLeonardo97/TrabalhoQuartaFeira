package views;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import br.com.parg.politicaDeFoco.PoliticaFocoGenerica; //Pol�tica de foco
import br.com.parg.viacep.ViaCEP; //ViaCep
import br.com.parg.viacep.ViaCEPException; //Exception do ViaCep
import dao.FornecedorDAO;

import model.Endereco;
import model.Fornecedor;

public class TelaCadastroFornecedor extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private FornecedorDAO funcDao;
    	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JFormattedTextField txtCep, txtCnpj;
	
    private JTextField  txtNome, txtTelefone, txtCidade, 
    txtRua, txtNumero, txtBairro, 
    txtEstado;
    private JLabel  lblNome, lblTelefone, 
    lblCep, lblCidade, lblRua, 
    lblNumero, lblBairro, lblEstado, lblCnpj;
    private JButton btnCadastrar, btnLimpar;    

    public TelaCadastroFornecedor(){
        super("Cadastro de Fornecedor");
        setIconifiable(true);
        setClosable(true);
        
        try {
        	txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
        	
        	txtCnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
                	
         } catch (ParseException e) {
            e.printStackTrace();
         }
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(26, 25, 40, 20);
		getContentPane().add(lblNome);
		
        txtNome = new JTextField(20);
        txtNome.setBounds(92, 25, 153, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
        
        lblTelefone= new JLabel("Telefone:");
        lblTelefone.setBounds(26, 75, 57, 20);
		getContentPane().add(lblTelefone);
		
        txtTelefone = new JTextField(20);
        txtTelefone.setBounds(92, 75, 153, 28);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(26, 125, 45, 20);
		getContentPane().add(lblCnpj);
		
        txtCnpj.setBounds(92, 125, 153, 28);
		getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
        
        lblCep = new JLabel("Cep:");
        lblCep.setBounds(26, 175, 40, 20);
		getContentPane().add(lblCep);
        
//        txtCep = new JTextField(20);
        txtCep.setBounds(92, 175, 153, 28);
        
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
        
        lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(297, 25, 45, 20);
		getContentPane().add(lblEstado);
		
        txtEstado = new JTextField(20);
        txtEstado.setBounds(352, 25, 153, 28);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
        
        lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(297, 75, 57, 20);
		getContentPane().add(lblCidade);
		
        txtCidade = new JTextField(20);
        txtCidade.setBounds(352, 75, 153, 28);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
        
        lblRua = new JLabel("Rua:");
        lblRua.setBounds(297, 175, 40, 20);
		getContentPane().add(lblRua);
        
        txtRua = new JTextField(20);
        txtRua.setBounds(352, 175, 153, 28);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);
        
        lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(297, 125, 40, 20);
		getContentPane().add(lblBairro);
		
        txtBairro = new JTextField(20);
        txtBairro.setBounds(352, 125, 153, 28);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
        
        lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(142, 225, 56, 20);
		getContentPane().add(lblNumero);
		
        txtNumero = new JTextField(20);
        txtNumero.setBounds(208, 225, 153, 28);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
        

        btnCadastrar = new JButton("Cadastrar");
        
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                 btnCadastrar.doClick();
                }
             }
        });
        
		btnLimpar = new JButton("Limpar");
	
		txtCep.addFocusListener(new FocusAdapter() {			
			public void focusLost(FocusEvent e) {
				ViaCEP viacep = new ViaCEP();	
				new Thread( ()-> {
				try {
					 
					viacep.buscar(txtCep.getText());
					txtBairro.setText(viacep.getBairro());
					txtRua.setText(viacep.getLogradouro());
					txtEstado.setText(viacep.getUf());
					txtCidade.setText(viacep.getLocalidade());
					txtBairro.setEditable(false);
					txtRua.setEditable(false);
					txtEstado.setEditable(false);
					txtCidade.setEditable(false);
					txtBairro.setEditable(false);
					
				} catch (ViaCEPException e1) {
					JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar o seu endereco");
					e1.printStackTrace();
				}
				}).start();
			}						
		});
		
        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        this.setSize(583, 402);
        this.setResizable(false); //N�o tem mais o bot�o para maximizar e o tamanho � sempre padr�o

		getContentPane().setLayout(null);
				
		
		btnCadastrar.setBounds(156, 268, 89, 48);
		getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(297, 268, 89, 48);
		getContentPane().add(btnLimpar);
		
		setFocusTraversalPolicy(new PoliticaFoco());
    }

    public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource() == btnCadastrar){	  

			String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String dTelefone = txtTelefone.getText();
		    txtTelefone.setText(dTelefone);
		    
		    String eEstado = txtEstado.getText();
		    txtEstado.setText(eEstado);
		    
		    String cCidade = txtCidade.getText();
		    txtCidade.setText(cCidade);
		    
		    String cCep = txtCep.getText();
		    txtCep.setText(cCep);
		    
		    String rRua = txtRua.getText();
		    txtRua.setText(rRua);
		    
		    String bBairro = txtBairro.getText();
		    txtBairro.setText(bBairro);
		    
		    String nNumero = txtNumero.getText();
		    int number = Integer.parseInt(nNumero);
		    txtNumero.setText(""+number);

            String pCnpj = txtCnpj.getText();
            txtCnpj.setText(pCnpj);
            	         
            Fornecedor fornecedor = new Fornecedor(nNome, dTelefone, pCnpj);
            Endereco endereco = new Endereco(eEstado, cCidade, rRua, bBairro, number, cCep, fornecedor);
    
            try {

				this.funcDao = new FornecedorDAO();
				this.funcDao.incluir(fornecedor, endereco);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
			    		 
		} else if (cadastrar.getSource() == btnLimpar){

	    	  txtNome.setText("");
	    	  txtTelefone.setText("");
	    	  txtCnpj.setText("");
		}
    }
    
    class PoliticaFoco extends PoliticaFocoGenerica {
    	  private PoliticaFoco() {
    	    this.componentes.add(txtNome);
    	    this.componentes.add(txtTelefone);
    	    this.componentes.add(txtCnpj);
    	    this.componentes.add(txtCep);
    	    this.componentes.add(txtEstado);
    	    this.componentes.add(txtCidade);
    	    this.componentes.add(txtBairro);
    	    this.componentes.add(txtRua);
    	    this.componentes.add(txtNumero);
    	  }
    }  
    
    public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}