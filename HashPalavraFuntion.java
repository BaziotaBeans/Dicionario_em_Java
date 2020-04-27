public class HashPalavraFuntion
{	
	public int hashCode(Palavra elemento)
	{
		String str = elemento.getDescricao();
		str.toLowerCase(); 
		String primeiro = ""+str.charAt(0);
		return (primeiro.hashCode() - 19); 
	}	
}
