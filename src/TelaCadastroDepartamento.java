import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.parg.viacep.ViaCEP;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroDepartamento extends JFrame implements ActionListener {
	
	public static void main(String[] args){
		new TelaCadastroDepartamento();
	}

	private JTextField txtID;
	private JLabel lblID;

	private JTextField txtNome;
	private JLabel lblNome;

	private JTextField txtLocal;
	private JLabel lblLocal;

	private JTextField txtTelefone;
	private JLabel lblTelefone;
	
	private JTextField txtFuncionario;
	private JLabel lblFuncionario;
	
	private JButton btnCadastrar, btnLimpar;
	   
	public TelaCadastroDepartamento(){
		//configura o titulo
		super("Cadastro de Departamento");
		//instanciar elementos de interface
		lblID = new JLabel("ID:");
		txtID = new JTextField(10);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblLocal = new JLabel("Local:");
		txtLocal = new JTextField(20);

		lblTelefone= new JLabel("telefone:");
        txtTelefone = new JTextField(20);
        
        lblFuncionario= new JLabel("Nome Funcionario:");
        txtFuncionario = new JTextField(12);

		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");

		//configura o gerenciador de layout
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(5,2));
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
		      
		//adicionar aos paineis
		painel1.add(lblID);
		painel2.add(txtID);
		painel3.add(lblNome);
		painel4.add(txtNome);
		painel5.add(lblLocal);
		painel6.add(txtLocal);
		painel7.add(lblTelefone);
		painel8.add(txtTelefone);
		painel9.add(lblFuncionario);
		painel10.add(txtFuncionario);
		painel11.add(btnCadastrar);
		painel12.add(btnLimpar);
		//adicionar a tela
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
		    String iId  = txtNome.getText();
		    int id = Integer.parseInt(iId);
			txtID.setText(""+id);
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String lLocal = txtLocal.getText();
		    txtLocal.setText(lLocal);
		         
		    String tTelefone = txtTelefone.getText();
		    txtTelefone.setText(tTelefone);
		    
		    String fFuncionario = txtFuncionario.getText();
		    txtFuncionario.setText(fFuncionario);
		    
		    
		    
		    Departamento departamento = new Departamento(id, nNome, lLocal, tTelefone, fFuncionario);
		         
		    
		    
		} else if (cadastrar.getSource()==btnLimpar){
			txtID.setText("");
	    	  txtNome.setText("");
	    	  txtLocal.setText("");
	    	  txtTelefone.setText("");
		}
	}
}