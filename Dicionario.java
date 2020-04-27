public class Dicionario {

	ChainingHashTable dispersao;
	HashPalavraFuntion hf;
	ReceberArquivo receber;
	
    public Dicionario() {
    	
        hf = new HashPalavraFuntion();
    	dispersao = new ChainingHashTable(26, hf);
    	receber = new ReceberArquivo();
    	receber.receberTudo(dispersao);
    	new MenuPrincipal(dispersao);
    }
}