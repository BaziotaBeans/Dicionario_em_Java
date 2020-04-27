import javax.swing.JTextField;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Paths;

public class ReceberArquivo {
    
    public void receber(ChainingHashTable dispersao, JTextField palavra){
    	String  pa, sin, sig, pal = "";
		Palavra p;
		try{
			char c = palavra.getText().charAt(0);
			File f = new File(Paths.get("Arquivos\\"+c+".txt").toString());
			if(f.exists()){
				FileReader fw = new FileReader(f);
				BufferedReader bw = new BufferedReader(fw);
				pa = sin = sig = "";
		    	while(pal != null){
		    		pal = bw.readLine();
		    		int tamanho = pal.length();
		    		for(int i = 0; i < tamanho; i++){
		    			if(i < 50)
		    				pa += pal.charAt(i);
		    			else if(i < 150){
		    				if(pal.charAt(i) == ' '){
		    					if(pal.charAt(i + 1) == ' ' || i + 1 == 150 );
		    					else 
		    						sin += pal.charAt(i);
		    				}
		    				else 
		    					sin += pal.charAt(i);
		    			}
		    			else if(i < 200){
		    				if(pal.charAt(i) == ' '){
		    					if(i != 199){
		    						if(pal.charAt(i + 1) == ' ' || i + 1 == 199);
			    					else
			    						sig += pal.charAt(i);
		    					}
		    				}
		    				else
		    					sig += pal.charAt(i);
		    			}
		    		}
		    		pa = pa.trim();
		    		p = new Palavra(pa, sin, sig);
		    		if(dispersao.pesquisar(p) == null)
						dispersao.inserir(p);
					pa = sin = sig = "";
		    	}
		    	bw.close();
		    	fw.close();
			}
		}
		catch(IOException io){}
		catch(Exception e){}
	}
	
	public void receberTudo(ChainingHashTable dispersao){
    	String  pa, sin, sig, pal = "";
    	String letras = "abcdefghijklmnopkrstuvwxyz";
    	JTextField palavra;
		Palavra p;
		for(int j = 0; j < 26; j++){
			palavra = new JTextField(letras.substring(j,26));
			receber(dispersao, palavra);
		}
	}
}