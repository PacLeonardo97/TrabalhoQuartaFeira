package views;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import br.com.parg.politicaDeFoco.PoliticaFocoGenerica; //Política de foco
import br.com.parg.viacep.ViaCEP; //ViaCep
import br.com.parg.viacep.ViaCEPException; //Exception do ViaCep
import dao.FornecedorDAO;
import model.Endereco;
import model.Fornecedor;

public class TelaCadastroFornecedor extends JFrame  implements ActionListener {
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
    
    private JTextField  txtNome, txtTelefone, 
    txtCep, txtCidade, txtRua, 
    txtNumero, txtBairro, txtEstado , txtCnpj;
    private JLabel  lblNome, lblTelefone, 
    lblCep, lblCidade, lblRua, 
    lblNumero, lblBairro, lblEstado, lblCnpj;
    private JButton btnCadastrar, btnLimpar;    

    public TelaCadastroFornecedor(){
        super("Cadastro de Fornecedor");
        
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(26, 25, 40, 20);
		getContentPane().add(lblNome);
		
        txtNome = new JTextField(20);
        txtNome.setBounds(92, 25, 153, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
        
        lblTelefone= new JLabel("Telefone:");
        lblTelefone.setBounds(26, 75, 57, 20);
		getContentPane().add(lblTelefone);
		
        txtTelefone = new JTextField(20);
        txtTelefone.setBounds(92, 75, 153, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(26, 125, 45, 20);
		getContentPane().add(lblCnpj);
		
        txtCnpj = new JTextField(20);
        txtCnpj.setBounds(92, 125, 153, 20);
		getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
        
        lblCep = new JLabel("Cep:");
        lblCep.setBounds(26, 175, 40, 20);
		getContentPane().add(lblCep);
        
        txtCep = new JTextField(20);
        txtCep.setBounds(92, 175, 153, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
        
        lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(297, 25, 45, 20);
		getContentPane().add(lblEstado);
		
        txtEstado = new JTextField(20);
        txtEstado.setBounds(352, 25, 153, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
        
        lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(297, 75, 57, 20);
		getContentPane().add(lblCidade);
		
        txtCidade = new JTextField(20);
        txtCidade.setBounds(352, 75, 153, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
        
        lblRua = new JLabel("Rua:");
        lblRua.setBounds(297, 175, 40, 20);
		getContentPane().add(lblRua);
        
        txtRua = new JTextField(20);
        txtRua.setBounds(352, 175, 153, 20);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);
        
        lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(297, 125, 40, 20);
		getContentPane().add(lblBairro);
		
        txtBairro = new JTextField(20);
        txtBairro.setBounds(352, 125, 153, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
        
        lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(142, 225, 56, 20);
		getContentPane().add(lblNumero);
		
        txtNumero = new JTextField(20);
        txtNumero.setBounds(208, 225, 153, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
        

        btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
	
		txtCep.addFocusListener(new FocusAdapter() {			
			public void focusLost(FocusEvent e) {
				ViaCEP viacep = new ViaCEP();	
				
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
					JOptionPane.showMessageDialog(null, "Não foi possível encontrar o seu endereço");
					e1.printStackTrace();
				}
			}						
		});
		
        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        this.setSize(600, 450);
        this.setResizable(false); //Não tem mais o botão para maximizar e o tamanho é sempre padrão
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnCadastrar.setBounds(156, 268, 89, 34);
		getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(297, 268, 89, 34);
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
}