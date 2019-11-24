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

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroDepartamento extends JInternalFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroDepartamento();
	}

	private static final long serialVersionUID = 1L;
	private DepartamentoDAO dao;
	private JTextField txtNome, txtLocal;
	private JLabel lblNome, lblLocal, lblFuncionario;
	private JButton btnCadastrar, btnLimpar;
	private JComboBox<Object> cbFuncionario = new JComboBox<Object>();
	public TelaCadastroDepartamento(){
		super("Cadastro de Departamento");
		setClosable(true);
		setIconifiable(true);
		
		
		try {
			LoginDAO dao = new LoginDAO();
	        
	        for(Funcionario p: dao.buscar()){
	        	cbFuncionario.addItem(p);
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblLocal = new JLabel("Local:");
		txtLocal = new JTextField(20);
        
        lblFuncionario= new JLabel("Funcionario:");
        

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
		painel10.add(cbFuncionario);
		
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
		
		txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                	btnCadastrar.doClick();
                } 
             }
        });
		
		setSize(500,500);
		setVisible(true);
	}
	   
	public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource()==btnCadastrar){	  
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Algum Campo está faltando!!!");
			}
		} else if (cadastrar.getSource()==btnLimpar){
	    	  txtNome.setText("");
	    	  txtLocal.setText("");
	    	  
		}
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
	
}