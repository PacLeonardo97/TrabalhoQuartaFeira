import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroFornecedor extends JFrame implements ActionListener {
    public static void main(String[] args){
		new TelaCadastroFornecedor();
    }
    private JTextField txtID;
    private JLabel lblID;

    private JTextField txtNome;
    private JLabel lblNome;
    
    private JTextField txtTelefone;
    private JLabel lblTelefone;

    private JTextField txtEndereco;
    private JLabel lblEndereco;
    
    private JTextField txtCnpj;
    private JLabel lblCnpj;

    private JButton btnCadastrar, btnLimpar;

    public TelaCadastroFornecedor(){
        super("Cadastro de Fornecedor");

        lblID = new JLabel("ID:");
        txtID = new JTextField(10);
        
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);
        
        lblTelefone= new JLabel("telefone:");
        txtTelefone = new JTextField(20);
        
        lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField(20);
        
        lblCnpj = new JLabel("CNPJ:");
        txtCnpj = new JTextField(20);

        btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
        
        Container tela = getContentPane();

        tela.setLayout(new GridLayout(8,2));
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
        
        painel1.add(lblID);
        painel2.add(txtID);
        
		painel3.add(lblNome);
        painel4.add(txtNome);

        painel5.add(lblTelefone);
        painel6.add(txtTelefone);

        painel7.add(lblEndereco);
        painel8.add(txtEndereco);

        painel9.add(lblCnpj);
        painel10.add(txtCnpj);

        painel11.add(btnCadastrar);
        painel12.add(btnLimpar);

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
			System.exit(0);
		}
    }
}