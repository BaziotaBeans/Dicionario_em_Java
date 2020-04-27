import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import  javax.swing.GroupLayout;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class Mostrar extends JDialog{
    
    private final JButton sair;
    private final JScrollPane scrollPane;
    private final JTextArea area1; 
    private GroupLayout layout;
    private String str;
    
    public Mostrar(String str){
        
        sair = new JButton("Voltar");
        sair.setFont ( new Font ( "Arial", Font.BOLD, 15 ) );
        sair.setBackground ( Color.RED );
        scrollPane = new JScrollPane();
        area1 = new JTextArea();
        this.str = str;
        
        initComponents();  
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo ( null ); 
        setVisible ( true );
    }
    
    private void initComponents() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        
        sair.addActionListener ((ActionEvent e) -> {
            dispose();
        });

        area1.setEditable(false);
        area1.setColumns(20);
        area1.setRows(5);
        area1.setText(str);
        area1.setBorder(createTitledBorder(null, "Conteudo da lista", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 20), Color.BLACK));
        scrollPane.setViewportView(area1);

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane, layout.DEFAULT_SIZE,250, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sair, layout.PREFERRED_SIZE, 100, layout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(scrollPane, layout.PREFERRED_SIZE, 400, layout.PREFERRED_SIZE)
                .addComponent(sair, layout.PREFERRED_SIZE, 42, layout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }
}

/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.SecurityException;
import java.io.*;

public class Mostrar extends JFrame implements KeyListener {

	private JLabel palavraL, sinonimoL, significadoL;
	private JButton ok;
	ChainingHashTable<Palavra> dispersao;
	Verificacao v = new Verificacao();
	
    public Mostrar(ChainingHashTable<Palavra> dispersao, Palavra palavra) {
    	
    	this.palavraL = new JLabel(palavra.getDescricao());
    	this.sinonimoL = new JLabel(palavra.getSinonimos());
    	this.significadoL = new JLabel(palavra.getSignificado());
    	this.dispersao = dispersao;
    	
    	this.ok = new JButton("OK");
        ok.setFont(new Font("Arial", Font.BOLD, 20));
        palavraL.setFont (new Font("Arial", Font.BOLD, 15));
        sinonimoL.setFont (new Font("Arial", Font.BOLD, 15));
        significadoL.setFont (new Font("Arial", Font.BOLD, 15));
        ok.setBackground(Color.BLACK);
        
        eventos();
    	inicio();
    }
    public void inicio(){
        
        setLayout(null);
        
        ok.setBounds( 430, 470, 70, 30);
        palavraL.setBounds( 100, 50, 250, 50);
        sinonimoL.setBounds( 100, 100, 250, 50);
        significadoL.setBounds( 100, 150, 259, 50);
        
        add(ok);
        add(palavraL);
        add(sinonimoL);
        add(significadoL);
        
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setSize(500,500);
        setVisible(true);
        setResizable( false);
    }
    public void eventos(){
        addKeyListener(this);
        
        ok.addMouseListener( new MouseEventos());
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
        ok.addActionListener ((ActionEvent e) -> {
            dispose();
        });
    }
    
    private class MouseEventos implements MouseListener{
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e){  
            if( e.getSource() == ok){
                ok.setForeground ( Color.WHITE );
                ok.setBackground ( Color.BLACK );
            }
        }
        public void mouseExited (MouseEvent e ){
            if( e.getSource() == ok){
                ok.setForeground ( Color.DARK_GRAY );
                ok.setBackground ( Color.BLACK );
            } 
        }
    }     
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}*/