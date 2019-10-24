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

public class TelaCadastroFuncionario extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroFuncionario();
	}

	private JTextField txtCPF;
	private JLabel lblCPF;

	private JTextField txtNome;
	private JLabel lblNome;

	private JTextField txtSenha;
	private JLabel lblSenha;

	private JButton btnCadastrar, btnLimpar;
	   
	public TelaCadastroFuncionario(){
		//configura o titulo
		super("Cadastro de Funcionario");
		//instanciar elementos de interface
		lblCPF = new JLabel("CPF:");
		txtCPF = new JTextField(11);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(15);

		lblSenha = new JLabel("Senha:");
		txtSenha = new JTextField(10);

		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");

		//configura o gerenciador de layout
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(4,2));
		JPanel painel1 = new JPanel(new FlowLayout());
		JPanel painel2 = new JPanel(new FlowLayout());
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
		JPanel painel6 = new JPanel(new FlowLayout());
		JPanel painel7 = new JPanel(new FlowLayout());
		JPanel painel8 = new JPanel(new FlowLayout());
		      
		//adicionar aos paineis
		painel1.add(lblCPF);
		painel2.add(txtCPF);
		painel3.add(lblNome);
		painel4.add(txtNome);
		painel5.add(lblSenha);
		painel6.add(txtSenha);
		painel7.add(btnCadastrar);
		painel8.add(btnLimpar);
		//adicionar a tela
		tela.add(painel1);
		tela.add(painel2);
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
		tela.add(painel7);
		tela.add(painel8);
		//configurar eventos
		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);
		//retoques finais
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	   
	public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource()==btnCadastrar){	  
		   
			String cCPF = txtCPF.getText();
		    txtCPF.setText(cCPF); 
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String sSenha  = txtSenha.getText();
		    int ssenha = Integer.parseInt(sSenha);
			txtSenha.setText("" + ssenha);
		         
			Funcionario funcionario = new Funcionario(cCPF, nNome, ssenha);

		} else if (cadastrar.getSource()==btnLimpar){
			  txtCPF.setText("");
	    	  txtNome.setText("");
	    	  txtSenha.setText("");
	    	}
	}
}