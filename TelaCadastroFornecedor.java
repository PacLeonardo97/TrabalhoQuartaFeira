import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ViaCep.CEP;
import ViaCep.ViaCEP;
import ViaCep.ViaCEPEvents;
import ViaCep.ViaCEPException;


public class TelaCadastroFornecedor extends JFrame implements ActionListener {
   
	public static void main(String[] args){
		new TelaCadastroFornecedor();
    }
    
    private JTextField txtID, txtNome, txtTelefone, 
    txtCep, txtCidade, txtRua, 
    txtNumero, txtBairro, txtEstado , txtCnpj;
    
    private JLabel lblID, lblNome, lblTelefone, 
    lblCep, lblCidade, lblRua, 
    lblNumero, lblBairro, lblEstado, lblCnpj;
    
    
    private JButton btnCadastrar, btnLimpar;

    public TelaCadastroFornecedor(){
        super("Cadastro de Fornecedor");

        lblID = new JLabel("ID:");
        txtID = new JTextField(10);
        
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);
        
        lblTelefone= new JLabel("telefone:");
        txtTelefone = new JTextField(20);
        
        lblCep = new JLabel("Cep:");
        txtCep = new JTextField(20);
        
        lblEstado = new JLabel("Estado:");
        txtEstado = new JTextField(20);
        
        lblCidade = new JLabel("Cidade:");
        txtCidade = new JTextField(20);
        
        lblRua = new JLabel("Rua:");
        txtRua = new JTextField(20);
        
        lblBairro = new JLabel("Bairro:");
        txtBairro = new JTextField(20);
        
        lblNumero = new JLabel("Numero:");
        txtNumero = new JTextField(20);
        
        
        lblCnpj = new JLabel("CNPJ:");
        txtCnpj = new JTextField(20);

        btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
        
        Container tela = getContentPane();

        tela.setLayout(new GridLayout(11,2));
		JPanel painel1 = new JPanel(new FlowLayout());
		JPanel painel2 = new JPanel(new FlowLayout());
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
		JPanel painel6 = new JPanel(new FlowLayout());
		JPanel painel7 = new JPanel(new FlowLayout());
		JPanel painel8 = new JPanel(new FlowLayout());
		JPanel painel9 = new JPanel(new FlowLayout());
		JPanel painel10 = new JPanel(new FlowLayout());
		JPanel painel11 = new JPanel(new FlowLayout());
		JPanel painel12 = new JPanel(new FlowLayout());
		JPanel painel13 = new JPanel(new FlowLayout());
		JPanel painel14 = new JPanel(new FlowLayout());
		JPanel painel15 = new JPanel(new FlowLayout());
		JPanel painel16 = new JPanel(new FlowLayout());
		JPanel painel17 = new JPanel(new FlowLayout());
		JPanel painel18 = new JPanel(new FlowLayout());
		JPanel painel19 = new JPanel(new FlowLayout());
		JPanel painel20 = new JPanel(new FlowLayout());
		JPanel painel21 = new JPanel(new FlowLayout());
		JPanel painel22 = new JPanel(new FlowLayout());
        
        painel1.add(lblID);
        painel2.add(txtID);
        
		painel3.add(lblNome);
        painel4.add(txtNome);

        painel5.add(lblTelefone);
        painel6.add(txtTelefone);

        painel7.add(lblCep);
        painel8.add(txtCep);
        
        painel9.add(lblEstado);
        painel10.add(txtEstado);
        
        painel11.add(lblCidade);
        painel12.add(txtCidade);
        
        painel13.add(lblRua);
        painel14.add(txtRua);
        
        painel15.add(lblBairro);
        painel16.add(txtBairro);
        
        painel17.add(lblNumero);
        painel18.add(txtNumero);

        painel19.add(lblCnpj);
        painel20.add(txtCnpj);

        painel21.add(btnCadastrar);
        painel22.add(btnLimpar);

        tela.add(painel1);
		tela.add(painel2);
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
		tela.add(painel7);
		tela.add(painel8);
		tela.add(painel9);
		tela.add(painel10);
		tela.add(painel11);
        tela.add(painel12);
        tela.add(painel13);
		tela.add(painel14);
		tela.add(painel15);
		tela.add(painel16);
		tela.add(painel17);
		tela.add(painel18);
		tela.add(painel19);
		tela.add(painel20);
		tela.add(painel21);
		tela.add(painel22);
        
        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);

        setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource() == btnCadastrar){	  
		    String iId  = txtID.getText();
		    int id = Integer.parseInt(iId);
			txtID.setText(""+id);
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String dTelefone = txtTelefone.getText();
		    txtTelefone.setText(dTelefone);
		         
		    String pEndereco  = txtEndereco.getText();
            txtEndereco.setText(pEndereco);

            String pCnpj = txtCnpj.getText();
            txtCnpj.setText(pCnpj);
		         
			Fornecedor fornecedor = new Fornecedor(id, nNome, dTelefone, pEndereco, pCnpj);
			    		 
		} else if (cadastrar.getSource() == btnLimpar){
			  txtID.setText("");
	    	  txtNome.setText("");
	    	  txtTelefone.setText("");
	    	  txtEndereco.setText("");
	    	  txtCnpj.setText("");
		}
    }
}