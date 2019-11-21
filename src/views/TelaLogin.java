package views;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.parg.politicaDeFoco.Criptografia;
import dao.LoginDAO;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtCPF;
	private JButton btnCadastrar = new JButton("Entrar"), btnLimpar = new JButton("Limpar");;
	private ImageIcon imagem = new ImageIcon(getClass().getResource("../logo.png"));
    private JLabel label =new JLabel(imagem);
    private JPasswordField txtSenha = new JPasswordField();;
    
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		        	 
		            UIManager.setLookAndFeel(info.getClassName());
		            
		            break;
		        }
		        
		    }
	             
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaLogin() {
		setBounds(100, 100, 351, 344);
		getContentPane().setLayout(null);
		TelaLogin.this.IconImage();
		setLocationRelativeTo(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(55, 132, 48, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(55, 187, 48, 14);
		getContentPane().add(lblSenha);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(128, 125, 142, 28);
		getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		txtSenha.setBounds(128, 180, 142, 28);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		btnCadastrar.setBounds(45, 246, 89, 48);
		getContentPane().add(btnCadastrar);
		
		btnLimpar.setBounds(199, 246, 89, 48);
		getContentPane().add(btnLimpar);
		
		label.setBounds(45, 11, 243, 103);
		getContentPane().add(label);
		
		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource()== btnCadastrar) {
			 try {
				String cCpf = txtCPF.getText();
		        txtCPF.setText(cCpf); 
		        //criptografia para entrar no sistema
		        Criptografia cripto = new Criptografia();
		        String strPass = new String(txtSenha.getPassword()).trim();
				String senha = cripto.Criptografar(strPass);
				//
				
				LoginDAO dao = new LoginDAO();
				if (dao.checkLogin(txtCPF.getText(), senha)) {
					
					TelaGerenciamentoEstoque TelaEstoque = new TelaGerenciamentoEstoque();
					TelaEstoque.setExtendedState(JFrame.MAXIMIZED_BOTH);
					TelaEstoque.setVisible(true);
					TelaEstoque.IconImage();
					
					this.dispose();

				}else {
					JOptionPane.showMessageDialog(this, "Credenciais Erradas!!");
				}
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		} else {

		}
	}
	 private void IconImage() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../logoHome.png") ));
	}
}
