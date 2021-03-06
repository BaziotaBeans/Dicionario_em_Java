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

public class InserirPalavras extends JFrame implements KeyListener {

	private JLabel palavraL, sinonimosL, traducaoL;
	private JTextField palavra, sinonimos, traducao;
	private JButton sair, adicionar;
	ChainingHashTable dispersao;
	Verificacao v = new Verificacao();
	Palavra p;
	
    public InserirPalavras(ChainingHashTable dispersao) {
    	
    	this.palavraL = new JLabel("Portugues");
    	this.sinonimosL = new JLabel("Sinonimos");
    	this.traducaoL = new JLabel("Kimbundo");
    	palavraL.setFont (new Font("Arial", Font.BOLD, 20));
    	sinonimosL.setFont (new Font("Arial", Font.BOLD, 20));
    	traducaoL.setFont (new Font("Arial", Font.BOLD, 20));
    	this.dispersao = dispersao;
    	
    	palavra = new JTextField();
    	sinonimos = new JTextField();
    	traducao = new JTextField();
    	
    	this.sair = new JButton("Voltar");
        this.adicionar = new JButton("Adicionar");
        sair.setFont(new Font("Arial", Font.BOLD, 30));
        adicionar.setFont(new Font("Arial", Font.BOLD, 30));
        
        sair.setBackground(Color.WHITE);
        adicionar.setBackground(Color.WHITE);
        palavraL.setForeground(Color.WHITE);
        sinonimosL.setForeground(Color.WHITE);
        traducaoL.setForeground(Color.WHITE);
        
        eventos();
    	inicio();
    }
    public void inicio(){
        
        setLayout(null);
        
        sair.setBounds( 400, 550, 190, 50);
        adicionar.setBounds( 650, 550, 190, 50);
        palavraL.setBounds(400, 200, 100, 100);
        sinonimosL.setBounds(400, 280, 100, 100);
        traducaoL.setBounds(400, 360, 100, 100);
        palavra.setBounds(540, 240, 210, 35);
        sinonimos.setBounds(540, 320, 210, 35);
        traducao.setBounds(540, 400, 210, 35);
        	
        add(adicionar);
        add(sair);
        add(palavraL);
        add(sinonimosL);
        add(traducaoL);
        add(palavra);
        add(sinonimos);
        add(traducao);
        
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
        	recolherDados();
        });
    }
    
	public void recolherDados(){
		if(v.verificar(palavra, sinonimos, traducao)){
			p = new Palavra(palavra.getText().toLowerCase(), sinonimos.getText(), traducao.getText());
			if(dispersao.pesquisar(p) != null)
				JOptionPane.showMessageDialog(null,"N�o foi possivel adicionar esta palavra."+"\n"+"A Palavra ja existe","ERRO", JOptionPane.ERROR_MESSAGE);
			else{
				dispersao.inserir(p);
				guardar();
		    	JOptionPane.showMessageDialog(null,"Palavra adicionado com sucesso","SALVAR", JOptionPane.PLAIN_MESSAGE);
		    	limpar();
			}
		}
    }
    
    public void guardar(){
		try{
			char c = p.getDescricao().toUpperCase().charAt(0);
			File f = new File(Paths.get("Arquivos\\"+c+".txt").toString());
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			    	
	    	String s = ColetarDados(p.getDescricao(), 50)+""+ColetarDados(p.getSinonimos(), 100)+""+ColetarDados(p.getSignificado(), 50)+"\n";
	    	bw.append(s);
	    	bw.close();
	    	fw.close();
		} 
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private String ColetarDados(String dados, int size ) {
		int tamanho = dados.length();
		if (tamanho > size)
			dados = dados.substring(0,size);
		else
	    	for( int i = tamanho ; i < size ; i++)
		        dados += ' ';
		return dados;
	}
	
    public void limpar()
    {
		palavra.setText("");
		sinonimos.setText(""); 
		traducao.setText("");
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