import javax.swing.JOptionPane;
import java.io.IOException;

public class LLinkedList {

	NodeLista head, tail;
	
    public LLinkedList() {
    	head = tail = null;
    }
    
    public boolean  vazia(){
    	return head == null;
    }
    
    public void prepend(Palavra palavra) {
        if(vazia())
        	head = tail = new NodeLista(palavra);
        else 
           head = new NodeLista(palavra, head); 
    }
        
    public void append(Palavra palavra)
    {
    	if(vazia())
    		head = tail = new NodeLista(palavra);
    	else
    		tail = tail.next = new NodeLista(palavra);
    }
    
    public void insertOrder(Palavra palavra){
     	NodeLista aux = head , tmp = aux;
     	while(aux != null && ((aux.palavra).getDescricao().compareTo((palavra.getDescricao())) < 0)){ 
     		aux = aux.next;
     	}
    	if(aux != null){
			if(aux == head)
				
				prepend(palavra);
			else
				tmp.next = new NodeLista(palavra, aux);
    	}
		else
			append(palavra);
    }
     	
    public boolean extract(Palavra palavra){
    	try{
    		if(vazia()){
	    		JOptionPane.showMessageDialog(null,"A lista encontra-se vazia","ERRO", JOptionPane.ERROR_MESSAGE);
	    		return false;
	    	}
	    	NodeLista aux = head, tmp = null;
	    	while(aux != null && (!(aux.palavra.getDescricao().equals( palavra.getDescricao())))){
	    		tmp = aux;
	    		aux = aux.next;
	    	}
	    	if(aux == null)
	    		return false;
	    	if(aux == head)
	    		head = head.next;	
	    	else if(aux == tail)
	    	{
	    		tmp.next = null;
	    		tail = tmp;
	    	} 
	    	else
	    		tmp.next = aux.next;
    	}catch (NullPointerException  e){
    	 	System.exit(1);
    	 }
    	return true;
    }
    public Palavra procurar(Palavra palavra){
    	for(NodeLista aux = head; aux != null; aux = aux.next){
    		if(aux.palavra.getDescricao().equals( palavra.getDescricao()))
    			return aux.palavra;
    	}
    	return null;
    }
    
    public boolean procurarSubString(Palavra palavra) throws NullPointerException{
    	String str = "";
    	int i = palavra.getDescricao().length();
    	for(NodeLista aux = head; aux != null; aux = aux.next){
    		int j = aux.palavra.getDescricao().length();
    		if(i > j)
    			continue;
    		else if(aux.palavra.getDescricao().substring(0,i).equals(palavra.getDescricao()))
    			str += aux.palavra + "\n";
    	}
    	if(str == "")
			return false;
		else
    		new Mostrar(str);
    	return true;
    }
    
    public String imprimir(){
    	if(vazia())
    		return null;
    	NodeLista aux = head;
    	String str = "";
    	while (aux != null){
    		str += aux.palavra + "\n";
    		aux = aux.next;
    	}
    	return str;
    }
}