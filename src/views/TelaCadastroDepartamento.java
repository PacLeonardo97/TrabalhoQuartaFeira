package views;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.DepartamentoDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroDepartamento extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroDepartamento();
	}

	private static final long serialVersionUID = 1L;
	private DepartamentoDAO dao;
	private JTextField txtNome, txtLocal, txtFuncionario;
	private JLabel lblNome, lblLocal, lblFuncionario;
	private JButton btnCadastrar, btnLimpar;
	   
	public TelaCadastroDepartamento(){
		super("Cadastro de Departamento");

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblLocal = new JLabel("Local:");
		txtLocal = new JTextField(20);
        
        lblFuncionario= new JLabel("Funcionario:");
        txtFuncionario = new JTextField(12);

		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");

		Container tela = getContentPane();
		tela.setLayout(new GridLayout(6,2));
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
		JPanel painel6 = new JPanel(new FlowLayout());
		JPanel painel9 = new JPanel(new FlowLayout());
		JPanel painel10 = new JPanel(new FlowLayout());
		JPanel painel11 = new JPanel(new FlowLayout());
		JPanel painel12 = new JPanel(new FlowLayout());
		      
		//adicionar aos paineis
		painel3.add(lblNome);
		painel4.add(txtNome);
		
		painel5.add(lblLocal);
		painel6.add(txtLocal);
		
		painel9.add(lblFuncionario);
		painel10.add(txtFuncionario);
		
		painel11.add(btnCadastrar);
		painel12.add(btnLimpar);
		
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
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
		if(cadastrar.getSource()==btnCadastrar){	  
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String lLocal = txtLocal.getText();
		    txtLocal.setText(lLocal);
		         
//			Departamento departamento = new Departamento(nNome, lLocal, Fornecedor);
			try {
				this.dao = new DepartamentoDAO();
//				this.dao.incluir(departamento);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} else if (cadastrar.getSource()==btnLimpar){
	    	  txtNome.setText("");
	    	  txtLocal.setText("");
		}
	}
}