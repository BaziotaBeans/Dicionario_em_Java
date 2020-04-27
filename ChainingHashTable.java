import javax.swing.JOptionPane;

public class ChainingHashTable 
{
	static class Elemento extends LLinkedList
	{
		public Elemento(Palavra e)
		{
			insertOrder(e);
		}
		
	}
	
	Elemento[] arrayDeElementos;
	int tamanho;
	HashPalavraFuntion hash;
	
	public ChainingHashTable(int len, HashPalavraFuntion hash)
	{
		arrayDeElementos = new Elemento[len];
		tamanho = len;
		this.hash = hash; 
	}
	
	public final int index(Palavra elemento)
	{
		int codigo = hash.hashCode(elemento) % tamanho;
		return (codigo < 0) ? codigo + tamanho : codigo;
	}
	
	public final void inserir(Palavra novoElemento)
	{
		int posicaoDeIncerssao = index(novoElemento);
		if(arrayDeElementos[posicaoDeIncerssao] == null)
			arrayDeElementos[posicaoDeIncerssao] = new Elemento(novoElemento);
		else
			arrayDeElementos[posicaoDeIncerssao].insertOrder(novoElemento);
	}
	
	public final Palavra pesquisar(Palavra elementoProcurado){
		int posicaoDeBusca = index(elementoProcurado);
		if(arrayDeElementos[posicaoDeBusca] == null)
			return null;
		return arrayDeElementos[posicaoDeBusca].procurar(elementoProcurado);
	}
	
	public final boolean pesquisarSubString(Palavra elementoProcurado){
		int posicaoDeBusca = index(elementoProcurado);
		if(arrayDeElementos[posicaoDeBusca] == null)
			return false;
		return arrayDeElementos[posicaoDeBusca].procurarSubString(elementoProcurado);
	}
	
	public final Palavra apagar(Palavra elementoRemover){
		int posicaoDeRemocao = index(elementoRemover);
		if(arrayDeElementos[posicaoDeRemocao] == null)
			return null;
		Palavra elemento = arrayDeElementos[posicaoDeRemocao].procurar((Palavra)elementoRemover);
		if(arrayDeElementos[posicaoDeRemocao].extract(elementoRemover))
			return elemento;
		return null;
	}
	
	public final String clone(ChainingHashTable dispe){
    	String str = "";
    	for(int i = 0; i < 26; i++){
    		if(dispe.arrayDeElementos[i] == null)
    			continue;
    		else
    			str += (char)(i+65) + dispe.arrayDeElementos[i].imprimir();
    	}
    	return str;	
	}
}