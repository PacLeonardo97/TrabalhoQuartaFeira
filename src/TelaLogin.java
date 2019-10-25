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

public class TelaLogin extends JFrame implements ActionListener {
	   private JTextField txtCPF;
	   private JLabel lblCPF;
	   private JTextField txtSenha;
	   private JLabel lblSenha;
	   private JButton btnLogar;
	   
	   public TelaLogin(){
		      //configura o titulo
		      super("Login");
		      //instanciar elementos de interface
		      lblCPF = new JLabel("CPF:");
		      txtCPF = new JTextField(11);
		      lblSenha = new JLabel("Senha:");
		      txtSenha = new JTextField(16);
		      btnLogar = new JButton("Login");
		      //configura o gerenciador de layout
		      Container tela = getContentPane();
		      tela.setLayout(new GridLayout(3,2));
		      JPanel painel1 = new JPanel(new FlowLayout());
		      JPanel painel2 = new JPanel(new FlowLayout());
		      JPanel painel3 = new JPanel(new FlowLayout());
		      JPanel painel4 = new JPanel(new FlowLayout());
		      JPanel painel5 = new JPanel(new FlowLayout());
		     		      
		      //adicionar aos paineis
		      painel1.add(lblCPF);
		      painel2.add(txtCPF);
		      painel3.add(lblSenha);
		      painel4.add(txtSenha);
		      painel5.add(btnLogar);
		      //adicionar a tela
		      tela.add(painel1);
		      tela.add(painel2);
		      tela.add(painel3);
		      tela.add(painel4);
		      tela.add(painel5);
		      //configurar eventos
		      btnLogar.addActionListener(this);
		      //retoques finais
		      setSize(500,500);
		      setLocationRelativeTo(null);
		      setVisible(true);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   }
	   
	   public void actionPerformed(ActionEvent logar){
		      if(logar.getSource()==btnLogar){
		    	  
		    	 String cCPF  = txtCPF.getText();
		    	 int cpf = Integer.parseInt(cCPF);
			     txtCPF.setText(""+cpf);
			     
		         String sSenha = txtSenha.getText();
		         int senha = Integer.parseInt(sSenha);
		         txtSenha.setText(""+senha); 
		         
		      		        			    		 
		      } else {
		    	  System.exit(0);
		      }
		   }

		   public static void main(String[] args){
		      new TelaLogin();
		   }

}