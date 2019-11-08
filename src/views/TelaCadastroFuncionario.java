package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.LoginDAO;
import model.Funcionario;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class TelaCadastroFuncionario extends JInternalFrame implements ActionListener {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static final long serialVersionUID = 1L;
	private LoginDAO dao;
	private JTextField txtCPF, txtNome, txtSenha;
	
	private JButton btnLimpar = new JButton("Limpar"), btnCadastrar = new JButton("Cadastrar");
	
	public TelaCadastroFuncionario(){
		
		super("Cadastro de Funcionario");
		setClosable(true);
		setIconifiable(true);
		
		


		
		      
		
		setSize(324,302);
		getContentPane().setLayout(null);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(131, 21, 148, 28);
		getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(131, 75, 148, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(131, 135, 148, 28);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		
		btnCadastrar.setBounds(23, 190, 89, 48);
		getContentPane().add(btnCadastrar);
		
		
		btnLimpar.setBounds(179, 190, 89, 48);
		getContentPane().add(btnLimpar);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(41, 28, 48, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(41, 82, 48, 14);
		getContentPane().add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(41, 142, 48, 14);
		getContentPane().add(lblSenha);

		
		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);
		setVisible(true);

	}
	   
	public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource()==btnCadastrar){	  
		   
			String cCPF = txtCPF.getText();
		    txtCPF.setText(cCPF); 
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String sSenha  = txtSenha.getText();
		   
			txtSenha.setText("" + sSenha);
		         
			Funcionario funcionario = new Funcionario(cCPF, nNome, sSenha);
			try {
				this.dao = new LoginDAO();
				this.dao.incluir(funcionario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (cadastrar.getSource()==btnLimpar){
			  txtCPF.setText("");
	    	  txtNome.setText("");
	    	  txtSenha.setText("");
	    	}
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}
