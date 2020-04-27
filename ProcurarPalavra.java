import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Paths;

public class ProcurarPalavra extends JFrame implements KeyListener {

	private JLabel palavraL;
	private JTextField palavra;
	private JButton sair, adicionar;
	ChainingHashTable dispersao;
	Verificacao v;
	Palavra p;
	
    public ProcurarPalavra(ChainingHashTable dispersao) {
    	
    	this.palavraL = new JLabel("Portugues");
    	this.dispersao = dispersao;
   		v = new Verificacao();
    	palavra = new JTextField();
    	
    	palavraL.setFont (new Font("Arial", Font.BOLD, 20));
    	
    	this.sair = new JButton("Voltar");
        this.adicionar = new JButton("Procurar");
        sair.setFont(new Font("Arial", Font.BOLD, 30));
        adicionar.setFont(new Font("Arial", Font.BOLD, 30));
        
        sair.setBackground(Color.WHITE);
        adicionar.setBackground(Color.WHITE);
        palavraL.setForeground(Color.WHITE);
        
        eventos();
    	inicio();
    }
    public void inicio(){
        
        setLayout(null);
        
        sair.setBounds( 400, 550, 190, 50);
        adicionar.setBounds( 650, 550, 190, 50);
        palavraL.setBounds(400, 200, 100, 100);
        palavra.setBounds(540, 240, 210, 35);
        	
        add(adicionar);
        add(sair);
        add(palavraL);
        add(palavra);
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setUndecorated(true);
        Dimension Size;
        Size = Toolkit.getDefaultToolkit().getScreenSize();
    	setMinimumSize(Size);
        setVisible(true);
        setResizable( false);
    }
    public void eventos(){
        addKeyListener(this);
        
        sair.addMouseListener( new MouseEventos());
        adicionar.addMouseListener( new MouseEventos());
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
        sair.addActionListener ((ActionEvent e) -> {
            dispose();
            new MenuPrincipal(dispersao);
        });
        adicionar.addActionListener ((ActionEvent e) -> {
        	procura();
        });
    }
    public void procura()
    {
    	if(v.verificar(palavra))
    	{
    		p = new Palavra(palavra.getText().toLowerCase());
    		if(dispersao.pesquisarSubString(p) == false)
    			JOptionPane.showMessageDialog(null,"Palavra nao encontrada","ERRO", JOptionPane.ERROR_MESSAGE);
    		else
    			palavra.setText("");
    	}
    }
    
    private class MouseEventos implements MouseListener{
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e){  
            if( e.getSource() == sair){
                sair.setForeground ( Color.WHITE );
                sair.setBackground ( Color.BLACK );
            }
            if( e.getSource() == adicionar){
                adicionar.setForeground ( Color.WHITE );
                adicionar.setBackground ( Color.BLACK );
            }
        }
        public void mouseExited (MouseEvent e ){
            if( e.getSource() == sair){
                sair.setForeground ( Color.BLACK );
                sair.setBackground ( Color.WHITE );
            }
            if( e.getSource() == adicionar){
                adicionar.setForeground ( Color.BLACK );
                adicionar.setBackground ( Color.WHITE );
            } 
        }
    }     
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}