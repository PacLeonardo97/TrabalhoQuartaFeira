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

public class TelaLogin extends JFrame implements ActionListener{
    public static void main(String[] args){
		new TelaLogin();
    }

    private JTextField txtCPF, txtSenha;
    private JLabel lblCPF, lblSenha;
    private JButton btnLogar, btnLimpar;

    public TelaLogin(){
        super("Tela de Login");

        lblCPF = new JLabel("CPF:");
        txtCPF = new JTextField(20);

        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField(20);

        btnLogar = new JButton("Entrar");
		btnLimpar = new JButton("Limpar");

        Container tela = getContentPane();
        tela.setLayout(new GridLayout(3,2));
        JPanel painel1 = new JPanel(new FlowLayout());
		JPanel painel2 = new JPanel(new FlowLayout());
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
        JPanel painel6 = new JPanel(new FlowLayout());

        painel1.add(lblCPF);
        painel2.add(txtCPF);

        painel3.add(lblSenha);
        painel4.add(txtSenha);

        painel5.add(btnLogar);
        painel6.add(btnLimpar);

        tela.add(painel1);
        tela.add(painel2);
        tela.add(painel3);
        tela.add(painel4);
        tela.add(painel5);
        tela.add(painel6);

        btnLogar.addActionListener(this);
        btnLimpar.addActionListener(this);

        setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent logar){
        if(logar.getSource()==btnLogar){
            
           //metodo de pegar string do textField
           String cCpf = txtCPF.getText();
           txtCPF.setText(cCpf); 
           
           String sSenha = txtSenha.getText();
           txtSenha.setText(sSenha);
                                                 
        } else {
            System.exit(0);
        }
     }
}
