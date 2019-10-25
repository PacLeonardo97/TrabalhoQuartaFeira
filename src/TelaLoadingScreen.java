import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;

public class TelaLoadingScreen extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        new TelaLoadingScreen();
    }

    private JProgressBar progresso;

    public TelaLoadingScreen() {
        super("Tela de Carregamento");
        progresso = new JProgressBar();
        progresso.setStringPainted(true);

        Container tela = getContentPane();
        tela.setLayout(new GridLayout(3, 2));
        JPanel painel1 = new JPanel(new FlowLayout());

        painel1.add(progresso);

        tela.add(painel1);

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

        setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}