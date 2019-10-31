package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaGerenciamentoEstoque extends JFrame implements ActionListener{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciamentoEstoque frame = new TelaGerenciamentoEstoque();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	final JDesktopPane desktop = new JDesktopPane();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menuFornecedor = new JMenu("Fornecedor");
	private JMenuItem fornecedorCad = new JMenuItem("Cadastrar");;
	private JMenuItem FornecedorConsulta = new JMenuItem("Consultar");
	
	private JMenu menuProduto = new JMenu("Produto");
	private JMenuItem ProdutoCad = new JMenuItem("Cadastrar");
	private JMenuItem ProdutoConsulta = new JMenuItem("Consultar");
	
	private JMenu menuEntradaDeProduto = new JMenu("Entrada de Produto");
	private JMenuItem cadastrarEntrada = new JMenuItem("Cadastrar");
	
	JMenu menuSaidaDeProduto = new JMenu("Saída de Produto");
	private JMenuItem SaidaCad = new JMenuItem("Cadastrar");
	
	JMenu menuFuncionario = new JMenu("Funcionário");
	private JMenuItem funcionarioCad = new JMenuItem("Cadastrar");
	private JMenuItem funcionarioConsulta = new JMenuItem("Consultar");
	
	JMenu menuDepartamento = new JMenu("Departamento");
	private JMenuItem dptoCadastro = new JMenuItem("Cadastro");
	private JMenuItem DptoConsulta = new JMenuItem("Consultar");
	
	private TelaCadastroFornecedor telaCadastroFornecedor;
	private TelaConsultaFornecedor telaConsultaFornecedor;
	
	private TelaCadastroFuncionario telaCadastroFuncionario;
	private TelaConsultaFuncionario2 telaConsultaFuncionario;

	private TelaCadastroProduto telaCadastroProduto;
	
	public TelaGerenciamentoEstoque() {	
		setJMenuBar(menuBar);
		
		menuBar.add(menuFornecedor);	
		menuFornecedor.add(fornecedorCad);	
		menuFornecedor.add(FornecedorConsulta);
			
		menuBar.add(menuProduto);
		menuProduto.add(ProdutoCad);
		menuProduto.add(ProdutoConsulta);
		
		
		menuBar.add(menuEntradaDeProduto);
		menuEntradaDeProduto.add(cadastrarEntrada);
		
		
		menuBar.add(menuSaidaDeProduto);
		menuSaidaDeProduto.add(SaidaCad);
		
		
		menuBar.add(menuDepartamento);
		menuDepartamento.add(dptoCadastro);
		menuDepartamento.add(DptoConsulta);
		
		
		menuBar.add(menuFuncionario);
		menuFuncionario.add(funcionarioCad);	
		menuFuncionario.add(funcionarioConsulta);
		
		fornecedorCad.addActionListener(this);
		FornecedorConsulta.addActionListener(this);
		
		funcionarioCad.addActionListener(this);
		funcionarioConsulta.addActionListener(this);
		
		ProdutoCad.addActionListener(this);
		
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktop);
		contentPane.setLayout(null);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==fornecedorCad){   
			
			telaCadastroFornecedor = new TelaCadastroFornecedor();
			desktop.add(telaCadastroFornecedor);
			telaCadastroFornecedor.setLocation(50, 50);
			telaCadastroFornecedor.setVisible(true);
	    } else if(e.getSource()== FornecedorConsulta) {
	    	telaConsultaFornecedor = new TelaConsultaFornecedor();
			desktop.add(telaConsultaFornecedor);
			telaConsultaFornecedor.setLocation(50, 50);
			telaConsultaFornecedor.setVisible(true);
			
	    } else if(e.getSource() == funcionarioCad) {
	    	telaCadastroFuncionario = new TelaCadastroFuncionario();
	    	desktop.add(telaCadastroFuncionario);
	    	telaCadastroFuncionario.setLocation(50, 50);
	    	telaCadastroFuncionario.setVisible(true);
	    } else if(e.getSource() == funcionarioConsulta) {
	    	telaConsultaFuncionario = new TelaConsultaFuncionario2();
	    	desktop.add(telaConsultaFuncionario);
	    	telaConsultaFuncionario.setLocation(50, 50);
	    	telaConsultaFuncionario.setVisible(true);
	    } 
		
	    else if(e.getSource() == ProdutoCad) {
	    	telaCadastroProduto = new TelaCadastroProduto();
	    	desktop.add(telaCadastroProduto);
	    	telaCadastroProduto.setLocation(50, 50);
	    	telaCadastroProduto.setVisible(true);
	    }
		
	}
}
