package views;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class TelaLoadingScreen extends JFrame{
	public static void main(String[] args) {
        new TelaLoadingScreen();
    }
	
	private static final long serialVersionUID = 1L;
    private JProgressBar progresso;
    private ImageIcon imagem = new ImageIcon(getClass().getResource("../logo.png"));
    private JLabel label =new JLabel(imagem);
    
    public TelaLoadingScreen() {
	    super("Tela de Carregamento");
	    
	    progresso = new JProgressBar();
	    progresso.setStringPainted(true);
	    
	    new Thread() {
	        public void run() {
	            for (int i = 0; i < 101; i++) {
	                try {
	                    sleep(30);
	                    progresso.setValue(i);
	
	                } catch (InterruptedException e) {
	                    
	                    e.printStackTrace();
	                }
	            }
//	            new TelaGerenciamentoEstoque().setExtendedState(MAXIMIZED_BOTH);
	            new TelaLogin().setVisible(true);
	            
	            TelaLoadingScreen.this.dispose();
	        }
	    }.start();
	
	    setSize(387,252);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		label.setBounds(42, 11, 279, 119);
		getContentPane().add(label);
		
		
		progresso.setBounds(64, 167, 245, 17);
		getContentPane().add(progresso);
    }
    
}