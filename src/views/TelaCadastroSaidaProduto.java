package views;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.EntradaProdutoDAO;
import dao.SaidaProdutoDAO;
import model.EntradaProduto;
import model.SaidaProduto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class TelaCadastroSaidaProduto extends JInternalFrame implements ActionListener {
	public static void main(String[] args){
		new TelaCadastroSaidaProduto();
    }

	private static final long serialVersionUID = 1L;
	private JTextField txtData, txtQuantidade;
    private JLabel lblData, lblQuantidade, lblIdProduto;
    private JButton btnCadastrar, btnLimpar;
    private JComboBox<Object> cbProdutos = new JComboBox<Object>();
    private SaidaProdutoDAO dao;
    
    public TelaCadastroSaidaProduto(){
        super("Cadastro de Sa�da de Produto");
        setClosable(true);
		setIconifiable(true);

        lblData = new JLabel("Data:");
        txtData = new JTextField(10);

        lblQuantidade = new JLabel("Quantidade:");
        txtQuantidade = new JTextField(10);

        lblIdProduto = new JLabel("ID da saida de Produto");
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
			EntradaProdutoDAO dao = new EntradaProdutoDAO();
	        
	        for(EntradaProduto p: dao.BuscarEntrada()){
	        	cbProdutos.addItem(p);
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		setVisible(true);
    }
    public void actionPerformed(ActionEvent cadastrar){
		if(cadastrar.getSource() == btnCadastrar){	  
			if (!txtData.getText().equals("") && !txtQuantidade.getText().equals("")) {
				try {	  			
					//come�o data
					Date pData;
				    String nData = txtData.getText();
				    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					pData = formato.parse(nData);
					txtData.setText(nData); 
				    //fim data 
				         
				    String dQuantidade = txtQuantidade.getText();
				    int sQuantidade = Integer.parseInt(dQuantidade);
				    txtQuantidade.setText(""+sQuantidade);

				    EntradaProduto ProdutoSelecionado = (EntradaProduto) this.cbProdutos.getSelectedItem();

		            SaidaProduto saidaProduto = new SaidaProduto(pData, sQuantidade, ProdutoSelecionado);
		            this.dao = new SaidaProdutoDAO();
		            this.dao.incluir(saidaProduto);
		            
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Algum Campo está faltando!!!");
			}
		} else if (cadastrar.getSource() == btnLimpar){
			System.exit(0);
		}
    }
    
    public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
}