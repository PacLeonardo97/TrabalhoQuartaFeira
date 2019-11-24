package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.LoginDAO;
import model.Funcionario;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
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
	private JFormattedTextField txtCPF;
	private LoginDAO dao;
	private JTextField  txtNome, txtSenha;
	
	private JButton btnLimpar = new JButton("Limpar"), btnCadastrar = new JButton("Cadastrar");
	
	public TelaCadastroFuncionario(){
		
		super("Cadastro de Funcionario");
		
		setClosable(true);
		setIconifiable(true);
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));	
         } catch (ParseException e) {
            e.printStackTrace();
         }
		setSize(324,302);
		getContentPane().setLayout(null);
		
		
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
		
		txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                 btnCadastrar.doClick();
                }
             }
        });
		
		btnLimpar.addActionListener(this);
		setVisible(true);

	}
	   
	public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource()==btnCadastrar){	  
		   if (!txtCPF.getText().equals("") && !txtNome.getText().equals("") && !txtSenha.getText().equals("")) {
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
		} else {
			JOptionPane.showMessageDialog(null, "Algum Campo está faltando!!!");
		} } else if (cadastrar.getSource() == btnLimpar){
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
