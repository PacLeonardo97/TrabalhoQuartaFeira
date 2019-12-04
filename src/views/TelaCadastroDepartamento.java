package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.DepartamentoDAO;
import dao.LoginDAO;
import model.Departamento;

import model.Funcionario;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class TelaCadastroDepartamento extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private DepartamentoDAO dao;
	private JTextField txtNome, txtLocal;
	private JLabel lblNome = new JLabel("Nome:"), lblLocal = new JLabel("Local:"), lblFuncionario = new JLabel("Nome do Funcionário:");
	private JButton btnCadastrar, btnLimpar;
	private JComboBox<Object> cbFuncionario = new JComboBox<Object>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDepartamento frame = new TelaCadastroDepartamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroDepartamento() {
		super("Tela de Cadstro de departamento");
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);

		try {
			LoginDAO dao = new LoginDAO();
	        
	        for(Funcionario p: dao.buscar()){
	        	cbFuncionario.addItem(p);
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		lblNome.setBounds(55, 11, 113, 28);
		getContentPane().add(lblNome);
		txtNome = new JTextField(20);
		txtNome.setBounds(178, 11, 153, 28);
		getContentPane().add(txtNome);
		
		lblLocal.setBounds(55, 63, 120, 28);
		getContentPane().add(lblLocal);
		txtLocal= new JTextField(20);
		txtLocal.setBounds(178, 63, 153, 28);
		getContentPane().add(txtLocal);
		
		lblFuncionario.setBounds(55, 115, 120, 28);
		getContentPane().add(lblFuncionario);
		cbFuncionario.setBounds(178, 115, 153, 28);
		getContentPane().add(cbFuncionario);
		
//		this.setSize(421, 315);
		this.setResizable(false);
        getContentPane().setLayout(null);
        
        btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(57, 168, 89, 48);
		getContentPane().add(btnCadastrar);	
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(215, 168, 89, 48);
		getContentPane().add(btnLimpar);
		btnCadastrar.addActionListener(this);
		
		 txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyPressed(java.awt.event.KeyEvent evt) {
	                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
	                	btnCadastrar.doClick();
	                }
	            }
		 });
		 setVisible(true);
		 setBounds(100, 100, 380, 277);
		 getContentPane().setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCadastrar){	  
			if (!txtLocal.getText().equals("") && !txtNome.getText().equals("")) {
				String nNome = txtNome.getText();
			    txtNome.setText(nNome); 
			         
			    String lLocal = txtLocal.getText();
			    txtLocal.setText(lLocal);
			         
//				fazer a Comunicação com o DepartamentoDAO
				try {
					Funcionario funcionario = (Funcionario) this.cbFuncionario.getSelectedItem();
					Departamento departamento = new Departamento(nNome, lLocal, funcionario);
					this.dao = new DepartamentoDAO();
					dao.incluir(departamento);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Algum Campo está faltando!!!");
			}
		} else if (e.getSource()==btnLimpar){
	    	  txtNome.setText("");
	    	  txtLocal.setText("");
	    	  
		}
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}

}
