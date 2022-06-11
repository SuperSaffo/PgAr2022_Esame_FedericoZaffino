package it.unibs.fp.esamearnaldo;


public class Battaglia {
	
	private Mostro nemico;
	private Personaggio protagonista;
	
	
	public Battaglia(Mostro nemico, Personaggio protagonista) {
		super();
		this.nemico = nemico;
		this.protagonista = protagonista;
	}
	

	public boolean generaBattaglia() {
		return true;
	}
	
	
	
}
