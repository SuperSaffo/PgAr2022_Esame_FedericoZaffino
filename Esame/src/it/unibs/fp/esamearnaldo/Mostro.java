package it.unibs.fp.esamearnaldo;

import it.unibs.fp.mylib.NumeriCasuali;

public class Mostro extends Personaggio {
	
	public void setMostro() {
		setNome("dijkstra");
		setVita(NumeriCasuali.estraiIntero(15, 25));
		setAttacco(5);
		setDifesa(5);
	}

}
