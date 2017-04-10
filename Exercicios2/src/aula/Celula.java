package aula;

public interface Celula {
	String nome = "";
	Celula anterior = null, proxima = null;

	public void setAnterior(Celula anterior);

	public void setProxima(Celula proxima);

	public Celula getAnterior();

	public Celula getProxima();

	public String getNome();

	public void setNome();
	
}