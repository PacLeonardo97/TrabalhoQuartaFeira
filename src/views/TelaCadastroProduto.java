package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import model.Produto;

public class TelaCadastroProduto extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO dao;

	private JLabel lblNome, lblDescrio, lblPeso;
	private JTextField txtNome, txtDescricao, txtPeso;
	

	private JButton btnCadastrar = new JButton("Cadastrar"),  btnLimpar = new JButton("Limpar");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroProduto() {
		super("Cadastro de Produto");
		setClosable(true);
		setIconifiable(true);
		
		setBounds(100, 100, 345, 315);

		
		
		getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(131, 22, 153, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(131, 80, 153, 28);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(131, 137, 153, 28);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(45, 29, 48, 14);
		getContentPane().add(lblNome);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(45, 87, 48, 14);
		getContentPane().add(lblDescrio);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(45, 144, 48, 14);
		getContentPane().add(lblPeso);
		
		
		btnCadastrar.setBounds(38, 193, 89, 48);
		getContentPane().add(btnCadastrar);
		
		
		btnLimpar.setBounds(192, 193, 89, 48);
		getContentPane().add(btnLimpar);
		
		btnCadastrar.addActionListener(this);
		txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                 btnCadastrar.doClick();
                }
             }
        });
		
		btnLimpar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent cadastrar){
		if(Pattern.matches("[a-zA-Z]+", txtPeso.getText()) == false) {
			if(cadastrar.getSource()==btnCadastrar){	  
			    
				String nNome = txtNome.getText();
				txtNome.setText(nNome); 
				         
			    String dDescricao = txtDescricao.getText();
			    txtDescricao.setText(dDescricao);
			         
			    String pPeso  = txtPeso.getText();
			    int peso = Integer.parseInt(pPeso);
				txtPeso.setText("" + peso);
			         
				Produto produto = new Produto(nNome, dDescricao, peso);
				 try {
						this.dao = new ProdutoDAO();
						this.dao.incluir(produto);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			} else if (cadastrar.getSource()==btnLimpar){
		    	  txtNome.setText("");
		    	  txtDescricao.setText("");
		    	  txtPeso.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "O campo Peso s� pode conter n�mero");
		}
	}
		
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}



	
	