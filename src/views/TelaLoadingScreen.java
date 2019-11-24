package views;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class TelaLoadingScreen extends JFrame{
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());   
		            break;
		        }   
		    }
	    } 
	    catch (Exception e) {
	       // handle exception
	    }
		
        new TelaLoadingScreen();
    }
	
	private static final long serialVersionUID = 1L;
    private JProgressBar progresso;
    private ImageIcon imagem = new ImageIcon(getClass().getResource("../logo.png"));
    private JLabel label =new JLabel(imagem);
    
    public TelaLoadingScreen() {
	    super("Tela de Carregamento");
	    TelaLoadingScreen.this.IconImage();
        UIManager.put("ProgressBar.foreground", Color.green);
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
	    progresso = new JProgressBar();
	    progresso.setStringPainted(true);
	    	
	    //usando lambda
	    new Thread(() -> {
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(18);
                    
                    progresso.setValue(i);

                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
            }
            new TelaLogin().setVisible(true);
            
            TelaLoadingScreen.this.dispose();
	    }).start();
	   
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
    
    private void IconImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../logoHome.png") ));
	}
}