public class NodeLista {

	Palavra palavra;
	NodeLista next;
    
    public NodeLista(Palavra palavra) {
    	this(palavra, null);
    }
    
    public NodeLista(Palavra palavra, NodeLista next) {
    	this.palavra = palavra;
    	this.next = next;
    }

	public String toString() {

		String sep = System.getProperty("line.separator");

		StringBuffer buffer = new StringBuffer();
		buffer.append(sep);
		buffer.append("palavra = ");
		buffer.append(palavra);
		buffer.append(sep);
		buffer.append("next = ");
		buffer.append(next);
		buffer.append(sep);
		
		return buffer.toString();
	} 
}