package views;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.ProdutoDAO;
import model.Produto;
import model.SaidaProduto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroSaidaProduto extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroSaidaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField txtData, txtQuantidade;
    private JLabel lblData, lblQuantidade, lblIdProduto;
    private JButton btnCadastrar, btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox<Object>();
    
    public TelaCadastroSaidaProduto(){
        super("Cadastro de Saída de Produto");


        lblData = new JLabel("Data:");
        txtData = new JTextField(10);

        lblQuantidade = new JLabel("Quantidade:");
        txtQuantidade = new JTextField(10);

        lblIdProduto = new JLabel("ID do produto:");
//      txtIdProduto = new JTextField(10);

	    btnCadastrar = new JButton("Cadastrar");
	    btnLimpar = new JButton("Limpar");
        
	    Container tela = getContentPane();

        tela.setLayout(new GridLayout(4,2));

		JPanel painel1 = new JPanel(new FlowLayout());
		JPanel painel2 = new JPanel(new FlowLayout());
		JPanel painel3 = new JPanel(new FlowLayout());
		JPanel painel4 = new JPanel(new FlowLayout());
		JPanel painel5 = new JPanel(new FlowLayout());
		JPanel painel6 = new JPanel(new FlowLayout());
		JPanel painel7 = new JPanel(new FlowLayout());
		JPanel painel8 = new JPanel(new FlowLayout());

		painel1.add(lblData);
	    painel2.add(txtData);
	    painel3.add(lblQuantidade);
	    painel4.add(txtQuantidade);
	    painel5.add(lblIdProduto);
	    painel7.add(btnCadastrar);
	    painel8.add(btnLimpar);
	        
        tela.add(painel1);
		tela.add(painel2);
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
		tela.add(painel7);
		tela.add(painel8);

		try {
			ProdutoDAO dao = new ProdutoDAO();
	        for(Produto p: dao.buscar()){
	        	cbProdutos.addItem(p);
	        	  		        	
	        }  
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("index "+cbProdutos.getSelectedIndex());
        tela.add(painel1);
		tela.add(painel2);
		tela.add(painel3);
		tela.add(painel4);
		tela.add(painel5);
		tela.add(painel6);
		
		painel6.add(cbProdutos);
		tela.add(painel7);
		tela.add(painel8);

        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        
        setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource() == btnCadastrar){	  

			try {	  			
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

			    Produto ProdutoSelecionado = (Produto) this.cbProdutos.getSelectedItem();

	            SaidaProduto entradaProduto = new SaidaProduto(pData, sQuantidade, ProdutoSelecionado);
	            JOptionPane.showMessageDialog(this, entradaProduto);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} else if (cadastrar.getSource() == btnLimpar){
			System.exit(0);
		}
    }
}