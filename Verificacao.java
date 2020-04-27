import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Verificacao {
	
    public boolean verificar(JTextField palavra, JTextField sinonimos, JTextField traducao){
    	int tamanho = palavra.getText().length();
    	for(int i = 0; i < tamanho; i++)
    		if( !Character.isLetter(palavra.getText().charAt(i))){
    			JOptionPane.showMessageDialog(null,"A palavra so pode conter letras","AVISO", JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	tamanho = sinonimos.getText().length();
    	for(int i = 0; i < tamanho; i++)
    		if((sinonimos.getText().charAt(i) == ' ')|| (sinonimos.getText().charAt(i) == ','))
    			continue;
    		else if( !Character.isLetter(sinonimos.getText().charAt(i))){
    			JOptionPane.showMessageDialog(null,"Os sinonimos so podem conter letras","AVISO", JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	tamanho = traducao.getText().length();
    	for(int i = 0; i < tamanho; i++)
    		if(traducao.getText().charAt(i) == ' ')
    			continue;
    		else if( !Character.isLetter(traducao.getText().charAt(i))){
    			JOptionPane.showMessageDialog(null,"A traducao so pode conter letras","AVISO", JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
		if (palavra.getText().equals("")){
    		JOptionPane.showMessageDialog(null,"Palavra nula","AVISO", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}	
 	    else if (traducao.getText().equals("")){
 	    	JOptionPane.showMessageDialog(null,"Tradução nula","AVISO", JOptionPane.ERROR_MESSAGE);
 	    	return false;
 	    }
 	    return true;
    }
    
    public boolean verificar(JTextField palavra){
    	int tamanho = palavra.getText().length();
    	for(int i = 0; i < tamanho; i++)
    		if(palavra.getText().charAt(i) == ' ')
    			continue;
    		else if( !Character.isLetter(palavra.getText().charAt(i))){
    			JOptionPane.showMessageDialog(null,"A palavra so pode conter letras","AVISO", JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	if (palavra.getText().equals("")){
    		JOptionPane.showMessageDialog(null,"Palavra nula","AVISO", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	return true;
    }
}