public class Palavra
{
	private String descricao;
	private String significado;
	private String sinonimos;
	
	public Palavra( String descricao )
	{
		this.descricao = descricao;
	}
	
	public Palavra( String descricao, String significado )
	{
		this.descricao = descricao;
		this.significado = significado;
	}
	
	public Palavra( String descricao, String sinonimo, String significado )
	{
		this.descricao = descricao;
		this.significado = significado;
		this.sinonimos = sinonimo;
	}
	
	public void setDescricao(String descricao) 
	{ this.descricao = descricao; }
	
	public void setSignificado(String significado) 
	{ this.significado = significado; }
	
	public void setSinonimos(String sinonimo) 
	{ this.sinonimos = sinonimos; }
	
	public String getDescricao()
	{ return descricao; }
	
	public String getSignificado()
	{ return significado; }
	
	public String getSinonimos()
	{ return sinonimos; }

	public String toString() {

		String sep = System.getProperty("line.separator");

		StringBuffer buffer = new StringBuffer();
		buffer.append(sep);
		buffer.append("Portugues = ");
		buffer.append(descricao);
		buffer.append(sep);
		buffer.append("Traducao = ");
		buffer.append(significado);
		buffer.append(sep);
		if(sinonimos.trim() != ""){
			buffer.append("Sinonimos = ");
			buffer.append(sinonimos);
			buffer.append(sep);
		}
		return buffer.toString();
	}
}