package views;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaGerenciamentoEstoque extends JFrame implements ActionListener{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
			    } 
			    catch (UnsupportedLookAndFeelException e) {
			       // handle exception
			    }
			    catch (ClassNotFoundException e) {
			       // handle exception
			    }
			    catch (InstantiationException e) {
			       // handle exception
			    }
			    catch (IllegalAccessException e) {
			       // handle exception
			    }
				
				try {
					
					TelaGerenciamentoEstoque frame = new TelaGerenciamentoEstoque();
					frame.IconImage();
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
	private JMenuItem consultaEntrada = new JMenuItem("Consulta");
	
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
	private TelaConsultaProduto telaConsultaProduto;
	
	private TelaCadastroEntradaProduto telaCadastroEntradaProduto;
	private TelaConsultaEntradaProduto telaConsultaEntradaProduto;
	
	private TelaCadastroSaidaProduto telaCadastroSaidaProduto;
	
	private TelaCadastroDepartamento telaCadastroDepartamento;
	private TelaConsultaDepartamento telaConsultaDepartamento;
	
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
		menuEntradaDeProduto.add(consultaEntrada);
		
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
		ProdutoConsulta.addActionListener(this);
		
		cadastrarEntrada.addActionListener(this);
		consultaEntrada.addActionListener(this);
		
		SaidaCad.addActionListener(this);//falta o saidConsulta
		
		dptoCadastro.addActionListener(this);
		DptoConsulta.addActionListener(this);
		
		this.setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktop);
		contentPane.setLayout(null);
	}
	
	public void actionPerformed(ActionEvent e){
		//fornecedor
		if(e.getSource()==fornecedorCad){   
			telaCadastroFornecedor = new TelaCadastroFornecedor();
			desktop.add(telaCadastroFornecedor);
			telaCadastroFornecedor.setVisible(true);
			telaCadastroFornecedor.setPosicao();
	    } else if(e.getSource()== FornecedorConsulta) {
	    	telaConsultaFornecedor = new TelaConsultaFornecedor();
			desktop.add(telaConsultaFornecedor);
			telaConsultaFornecedor.setVisible(true);
			telaConsultaFornecedor.setPosicao();
		//Funcionário
	    } else if(e.getSource() == funcionarioCad) {
	    	telaCadastroFuncionario = new TelaCadastroFuncionario();
	    	desktop.add(telaCadastroFuncionario);
	    	telaCadastroFuncionario.setPosicao();
	    	telaCadastroFuncionario.setVisible(true);
	    }else if(e.getSource() == funcionarioConsulta) {
	    	telaConsultaFuncionario = new TelaConsultaFuncionario2();
	    	desktop.add(telaConsultaFuncionario);
	    	telaConsultaFuncionario.setPosicao();
	    	telaConsultaFuncionario.setVisible(true);
	    	
	    //Produto
	    } else if(e.getSource() == ProdutoCad) {
	    	telaCadastroProduto = new TelaCadastroProduto();
	    	desktop.add(telaCadastroProduto);
	    	telaCadastroProduto.setPosicao();
	    	telaCadastroProduto.setVisible(true);
	    } else if (e.getSource() == ProdutoConsulta) {
	    	telaConsultaProduto = new TelaConsultaProduto();
	    	desktop.add(telaConsultaProduto);
	    	telaConsultaProduto.setLocation(500, 190);
	    	telaConsultaProduto.setVisible(true);
	    }
		//Entrada
	    else if(e.getSource() == cadastrarEntrada) {
	    	telaCadastroEntradaProduto = new TelaCadastroEntradaProduto();
	    	desktop.add(telaCadastroEntradaProduto);
	    	telaCadastroEntradaProduto.setPosicao();
	    	telaCadastroEntradaProduto.setVisible(true);
	    } else if(e.getSource() == consultaEntrada) {
	    	telaConsultaEntradaProduto = new TelaConsultaEntradaProduto();
	    	desktop.add(telaConsultaEntradaProduto);
	    	telaConsultaEntradaProduto.setPosicao();
	    	telaConsultaEntradaProduto.setVisible(true);
	    }
		
		//Saída
	    else if(e.getSource() == SaidaCad) {
	    	telaCadastroSaidaProduto = new TelaCadastroSaidaProduto();
	    	desktop.add(telaCadastroSaidaProduto);
	    	telaCadastroSaidaProduto.setPosicao();
	    	telaCadastroSaidaProduto.setVisible(true);
	    }
		
		//Departamento
	    else if(e.getSource() == dptoCadastro) {
	    	telaCadastroDepartamento = new TelaCadastroDepartamento();
	    	desktop.add(telaCadastroDepartamento);
	    	telaCadastroDepartamento.setPosicao();
	    	telaCadastroDepartamento.setVisible(true);
	    } else if(e.getSource() == DptoConsulta){
	    	telaConsultaDepartamento = new TelaConsultaDepartamento();
	    	desktop.add(telaConsultaDepartamento);
	    	telaConsultaDepartamento.setPosicao();
	    	telaConsultaDepartamento.setVisible(true);
	    }
	}
	void IconImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../logo.png") ));
	}
}
