import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class TelaLoadingScreen extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        new TelaLoadingScreen();
    }

    private JProgressBar progresso;
    private ImageIcon imagem = new ImageIcon(getClass().getResource("logo.jpg"));
    private JLabel label =new JLabel(imagem);
   
    public TelaLoadingScreen() {
	    super("Tela de Carregamento");

	    progresso = new JProgressBar();
	    progresso.setStringPainted(true);
	    
	    new Thread() {
	        public void run() {
	            for (int i = 0; i < 101; i++) {
	                try {
	                    sleep(10);
	                    progresso.setValue(i);
	
	                } catch (InterruptedException e) {
	                    
	                    e.printStackTrace();
	                }
	            }
	            new TelaLogin().setVisible(true); //mudar para tela de 
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