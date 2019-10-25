import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.parg.viacep.ViaCEPException;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadastroEntradaProduto extends JFrame implements ActionListener {
    

    private JTextField txtID;
    private JLabel lblID;
    
    private JTextField txtData;
    private JLabel lblData;
    
    private JTextField txtQuantidade;
    private JLabel lblQuantidade;


    private JTextField txtIdProduto;
    private JLabel lblIdProduto;

    private JTextField txtNomeProduto;
    private JLabel lblNomeProduto;

    private JTextField txtDescricaoProduto;
    private JLabel lblDescricaoProduto;

    private JTextField txtPesoProduto;
    private JLabel lblPesoProduto;

    private JButton btnCadastrar, btnLimpar;
    
    public TelaCadastroEntradaProduto(){
        super("Cadastro de Entrada de Produto");

        lblID = new JLabel("ID Entrada Produto:");
        txtID = new JTextField(10);

        lblData = new JLabel("Data:");
        txtData = new JTextField(10);

        lblQuantidade = new JLabel("Data:");
        txtQuantidade = new JTextField(10);

        lblIdProduto = new JLabel("ID do produto:");
        txtIdProduto = new JTextField(10);

        lblNomeProduto = new JLabel("Nome do produto:");
        txtNomeProduto = new JTextField(10);

        lblDescricaoProduto = new JLabel("Descrição do produto:");
        txtDescricaoProduto = new JTextField(20);

        lblPesoProduto = new JLabel("Peso do produto:");
        txtPesoProduto  = new JTextField(10);

        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        
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
        
        painel1.add(lblID);
        painel2.add(txtID);

        painel3.add(lblData);
        painel4.add(txtData);

        painel5.add(lblQuantidade);
        painel6.add(txtQuantidade);

        painel7.add(lblIdProduto);
        painel8.add(txtIdProduto);

        painel9.add(lblNomeProduto);
        painel10.add(txtNomeProduto);

        painel11.add(lblDescricaoProduto);
        painel12.add(txtDescricaoProduto);

        painel13.add(lblPesoProduto);
        painel14.add(txtPesoProduto);

        painel15.add(btnCadastrar);
        painel16.add(btnLimpar);
        
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

        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);

        setSize(700,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent cadastrar){
    	
    	
    	if(cadastrar.getSource() == btnCadastrar){	  

			try {
				String iId  = txtID.getText();
			    int id = Integer.parseInt(iId);
				txtID.setText(""+id);
				  			
				//começo data
				Date pData;
			    String nData = txtData.getText();
			    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				pData = formato.parse(nData);
				txtData.setText(nData); 
			    //fim data 
			         
			    String dQuantidade = txtQuantidade.getText();
			    int sQuantidade = Integer.parseInt(dQuantidade);
			    txtQuantidade.setText(""+sQuantidade);
	            
	            String pId  = txtIdProduto.getText();
			    int prodId = Integer.parseInt(pId);
				txtIdProduto.setText("" + prodId);

	            String nNomeProduto = txtNomeProduto.getText();
			    txtNomeProduto.setText(nNomeProduto); 

	            String nDescProduto = txtDescricaoProduto.getText();
			    txtDescricaoProduto.setText(nDescProduto); 
	            
	            String pPesoProd  = txtPesoProduto.getText();
			    int stringPesoProd = Integer.parseInt(pPesoProd);
				txtPesoProduto.setText("" + stringPesoProd);
	            
	            Produto produto = new Produto(prodId, nNomeProduto, nDescProduto, stringPesoProd);

	            EntradaProduto entradaProduto = new EntradaProduto(id, pData, sQuantidade, produto);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} else if (cadastrar.getSource() == btnLimpar){
			System.exit(0);
		}
    }
    
    public static void main(String[] args){
		new TelaCadastroEntradaProduto();
    }
    
}