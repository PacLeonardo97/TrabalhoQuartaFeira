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

public class TelaCadastroProduto extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroProduto();
	}

	private JTextField txtID;
	private JLabel lblID;

	private JTextField txtNome;
	private JLabel lblNome;

	private JTextField txtDescricao;
	private JLabel lblDescricao;

	private JTextField txtSetor;
	private JLabel lblSetor;
	
	private JTextField txtPeso;
	private JLabel lblPeso;

	private JTextField txtQtdaMax;
	private JLabel lblQuantidade_Maxima;

	private JTextField txtQtdaMin;
	private JLabel lblQuantidade_Minima;

	private JButton btnCadastrar, btnLimpar;
	   
	public TelaCadastroProduto(){
		//configura o titulo
		super("Cadastro de Produto");
		//instanciar elementos de interface
		lblID = new JLabel("ID:");
		txtID = new JTextField(10);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblDescricao = new JLabel("Descrição:");
		txtDescricao = new JTextField(20);

		lblSetor = new JLabel("Setor:");
		txtSetor = new JTextField(10);

		lblPeso = new JLabel("Peso:");
		txtPeso = new JTextField(10);

		lblQuantidade_Maxima = new JLabel("QtdaMax:");
		txtQtdaMax = new JTextField(10);

		lblQuantidade_Minima = new JLabel("QtdaMinima:");
		txtQtdaMin = new JTextField(10);

		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");

		//configura o gerenciador de layout
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(8,2));
		JPanel painel1 = new JPanel(new FlowLayout());
		JPanel painel2 = new JPanel(new FlowLayout());
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
		JPanel painel6 = new JPanel(new FlowLayout());
		JPanel painel7 = new JPanel(new FlowLayout());
		JPanel painel8 = new JPanel(new FlowLayout());
		JPanel painel9 = new JPanel(new FlowLayout());
		JPanel painel10 = new JPanel(new FlowLayout());
		JPanel painel11 = new JPanel(new FlowLayout());
		JPanel painel12 = new JPanel(new FlowLayout());
		JPanel painel13 = new JPanel(new FlowLayout());
		JPanel painel14 = new JPanel(new FlowLayout());
		JPanel painel15 = new JPanel(new FlowLayout());
		JPanel painel16 = new JPanel(new FlowLayout());
		      
		//adicionar aos paineis
		painel1.add(lblID);
		painel2.add(txtID);
		painel3.add(lblNome);
		painel4.add(txtNome);
		painel5.add(lblDescricao);
		painel6.add(txtDescricao);
		painel7.add(lblSetor);
		painel8.add(txtSetor);
		painel9.add(lblPeso);
		painel10.add(txtPeso);
		painel11.add(lblQuantidade_Maxima);
		painel12.add(txtQtdaMax);
		painel13.add(lblQuantidade_Minima);
		painel14.add(txtQtdaMin);
		painel15.add(btnCadastrar);
		painel16.add(btnLimpar);
		//adicionar a tela
		tela.add(painel1);
		tela.add(painel2);
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
		tela.add(painel7);
		tela.add(painel8);
		tela.add(painel9);
		tela.add(painel10);
		tela.add(painel11);
		tela.add(painel12);
		tela.add(painel13);
		tela.add(painel14);
		tela.add(painel15);
		tela.add(painel16);
		//configurar eventos
		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);
		//retoques finais
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	   
	public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource()==btnCadastrar){	  
		    String iId  = txtNome.getText();
		    int id = Integer.parseInt(iId);
			txtID.setText(""+id);
			     
		    String nNome = txtNome.getText();
		    txtNome.setText(nNome); 
		         
		    String dDescricao = txtDescricao.getText();
		    txtDescricao.setText(dDescricao);
		         
		    String pPeso  = txtPeso.getText();
		    int peso = Integer.parseInt(pPeso);
			txtPeso.setText("" + peso);
		         
			Produto produto = new Produto(id, nNome, dDescricao, peso);

		} else if (cadastrar.getSource()==btnLimpar){
			System.exit(0);
		}
	}
}