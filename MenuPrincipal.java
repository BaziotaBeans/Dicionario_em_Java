import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame implements KeyListener{

    private final JButton inserirB, buscaB, apagarB, cloneB, sairB;
    private final JLabel mensagem;
    ChainingHashTable dispersao;
    ReceberArquivo rec;
    
    public MenuPrincipal(ChainingHashTable dispersao){
        
        this.inserirB = new JButton("Inserir");
        this.buscaB = new JButton("Procurar");
        this.apagarB = new JButton("Apagar");
        this.cloneB = new JButton("Clonar");
        this.sairB = new JButton("Sair");
        this.mensagem = new JLabel("Bem-Vindo ao Dicionario Portugues - Kimbundu");
        this.dispersao = dispersao;
        
        inserirB.setFont (new Font("Arial", Font.BOLD, 30));
        buscaB.setFont (new Font("Arial", Font.BOLD, 30));
        apagarB.setFont (new Font("Arial", Font.BOLD, 30));
        sairB.setFont (new Font("Arial", Font.BOLD, 30));
        cloneB.setFont (new Font("Arial", Font.BOLD, 30));
        mensagem.setFont(new Font("Arial", Font.BOLD, 50));
        
        inserirB.setBackground(Color.WHITE);
        buscaB.setBackground(Color.WHITE);
        apagarB.setBackground(Color.WHITE);
        cloneB.setBackground(Color.WHITE);
        sairB.setBackground(Color.WHITE);
        mensagem.setForeground(Color.WHITE);

        inicio();
        eventos();
    }
  public void inicio(){
        
        setLayout(null);
        inserirB.setBounds( 550, 200, 190, 50);
        buscaB.setBounds(550, 300, 190, 50);
        apagarB.setBounds(550, 400, 190, 50); 
        cloneB.setBounds(550, 500, 190, 50);  
        sairB.setBounds( 550, 600, 190, 50);
        
        mensagem.setBounds(100, 10, 1200, 60);
        
        add(inserirB);
        add(buscaB);
        add(apagarB);
        add(cloneB);
        add(sairB);
        add(mensagem);
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        Dimension Size;
        Size = Toolkit.getDefaultToolkit().getScreenSize();
    	setMinimumSize(Size);
        setVisible(true);
        setResizable( false);
    }
    public void eventos(){
        addKeyListener( this);
        
        inserirB.addMouseListener( new MouseEventos());
        apagarB.addMouseListener( new MouseEventos());
        buscaB.addMouseListener( new MouseEventos());
        cloneB.addMouseListener( new MouseEventos());
        sairB.addMouseListener( new MouseEventos () );
        
        this.addWindowListener(
            new WindowListener(){
                public void windowOpened(WindowEvent e) {}
                public void windowClosing ( WindowEvent e ){}
                public void windowClosed(WindowEvent e) {}
                public void windowIconified(WindowEvent e) {}
                public void windowDeiconified(WindowEvent e) {}
                public void windowActivated(WindowEvent e) {}
                public void windowDeactivated(WindowEvent e) {}
            }
        );
        inserirB.addActionListener ((ActionEvent e) -> {
        	dispose();
            new InserirPalavras(dispersao);
        });
        buscaB.addActionListener ((ActionEvent e) -> {
        	dispose();
        	new ProcurarPalavra(dispersao);
        });
        apagarB.addActionListener ((ActionEvent e) -> {
        	dispose();
        	new ApagarPalavra(dispersao);
        });
        cloneB.addActionListener ((ActionEvent e) -> {
        	ChainingHashTable dispe;
        	HashPalavraFuntion hf = new HashPalavraFuntion();
        	dispe = new ChainingHashTable(26, hf);
        	rec = new ReceberArquivo();
        	rec.receberTudo(dispe);
        	new Mostrar(dispersao.clone(dispe));
        });
        sairB.addActionListener ((ActionEvent e) -> {
            System.exit(0);
        });
    }
    private class MouseEventos implements MouseListener{
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        
        public void mouseEntered(MouseEvent e){  
            if( e.getSource() == inserirB){
                inserirB.setForeground ( Color.WHITE );
                inserirB.setBackground ( Color.BLACK );
            }
            if( e.getSource() == buscaB){
                buscaB.setForeground ( Color.WHITE );
                buscaB.setBackground ( Color.BLACK );
            } 
            if( e.getSource() == apagarB){
                apagarB.setForeground ( Color.WHITE );
                apagarB.setBackground ( Color.BLACK );
            }
            if( e.getSource() == cloneB){
                cloneB.setForeground ( Color.WHITE );
                cloneB.setBackground ( Color.BLACK );
            }
            if( e.getSource() == sairB){
                sairB.setForeground ( Color.WHITE );
                sairB.setBackground ( Color.BLACK );
            }
        }
        
        public void mouseExited (MouseEvent e ){
            if( e.getSource() == inserirB){
                inserirB.setForeground ( Color.BLACK );
                inserirB.setBackground ( Color.WHITE );
            }
            if( e.getSource() == buscaB){
                buscaB.setForeground ( Color.BLACK );
                buscaB.setBackground ( Color.WHITE );
            } 
            if( e.getSource() == apagarB){
                apagarB.setForeground ( Color.BLACK );
                apagarB.setBackground ( Color.WHITE );
            }
            if( e.getSource() == cloneB){
                cloneB.setForeground ( Color.BLACK );
                cloneB.setBackground ( Color.WHITE );
            }
            if( e.getSource() == sairB){
                sairB.setForeground ( Color.BLACK );
                sairB.setBackground ( Color.WHITE );
            }
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
