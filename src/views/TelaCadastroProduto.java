package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroProduto extends JInternalFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroProduto();
	}

	private static final long serialVersionUID = 1L;
	private ProdutoDAO dao;
	private JTextField txtNome, txtDescricao, txtPeso;
	private JLabel lblNome, lblDescricao, lblPeso;
	private JButton btnCadastrar, btnLimpar;
	   
	public TelaCadastroProduto(){
		super("Cadastro de Produto");
		
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblDescricao = new JLabel("Descrição:");
		txtDescricao = new JTextField(20);

		lblPeso = new JLabel("Peso:");
		txtPeso = new JTextField(10);

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
		      
		painel3.add(lblNome);
		painel4.add(txtNome);
		painel5.add(lblDescricao);
		painel6.add(txtDescricao);
		painel9.add(lblPeso);
		painel10.add(txtPeso);
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
		setVisible(true);
	}
	   
	public void actionPerformed(ActionEvent cadastrar){
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
	}
}