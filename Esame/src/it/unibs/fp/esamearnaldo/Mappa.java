package it.unibs.fp.esamearnaldo;

import it.unibs.fp.mylib.NumeriCasuali;

public class Mappa {
	
	public static final int DIMENSIONE_MAPPA = 10;
	
	private Personaggio protagonista;
	private Mostro[] mostri;
	private char[][] mappa;
	
	public Mappa(Personaggio protagonista, Mostro[] mostri, String[][] mappa) {
		super();
		this.protagonista = protagonista;
		this.mostri = mostri;
		this.mappa = new char[DIMENSIONE_MAPPA][DIMENSIONE_MAPPA];
		
	}
	
	public Mappa(Personaggio protagonista, Mostro[] mostri) {
		super();
		this.protagonista = protagonista;
		this.mostri = mostri;
		
	}
	
	public void generaMappaVuota() {
		for(int i=0; i<DIMENSIONE_MAPPA; i++) {
			for(int j=0; j<DIMENSIONE_MAPPA; j++) {
				mappa[i][j] = '.';
			}
		}
	}
	
	public void aggiungiProtagonista() {
		int x = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
		int y = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
		
		mappa[x][y] = 'O';
		protagonista.setCoordinataX(x);
		protagonista.setCoordinataY(y);
	}
	
	public void aggiungiMuri() {
		boolean fine = false;
		
		for(int i=0; i<DIMENSIONE_MAPPA; i++) {
			do {
				int x = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
				int y = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
			
				if(mappa[x][y] != 'O' && mappa[x][y] != '#') {
					mappa[x][y] = '#';
					fine = true;
				}
			}while(!fine);
		}
	}
	
	public void aggiungiMostri() {
		boolean fine = false;
		int nMostro = 0;
		
		for(int i=0; i<DIMENSIONE_MAPPA; i++) {
			do {
				int x = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
				int y = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
			
				if(mappa[x][y] != 'O' && mappa[x][y] != '#' && mappa[x][y] != 'M') {
					mappa[x][y] = '#';
					fine = true;
					mostri[nMostro].setCoordinataX(x);
					mostri[nMostro].setCoordinataY(y);
					nMostro++;
				}
			}while(!fine);
		}
	}
	
	public void aggiungiCeste() {
		boolean fine = false;
		
		for(int i=0; i<DIMENSIONE_MAPPA; i++) {
			do {
				int x = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
				int y = NumeriCasuali.estraiIntero(0, DIMENSIONE_MAPPA);
			
				if(mappa[x][y] != 'O' && mappa[x][y] != '#' && mappa[x][y] != 'M' && mappa[x][y] != 'C') {
					mappa[x][y] = '#';
					fine = true;
				}
			}while(!fine);
		}
	}
	
	public void generaMappaCompleta() {
		generaMappaVuota();
		aggiungiProtagonista();
		aggiungiMuri();
		aggiungiMostri();
		aggiungiCeste();
		
		for(int i=0; i<DIMENSIONE_MAPPA; i++) {
			for(int j=0; j<DIMENSIONE_MAPPA; j++) {
				System.out.println(mappa[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
	}
	
	public void generaMovimentiProtagonista() {
		boolean esito = false;
		
		do {
			esito = protagonista.movimentoPersonaggio();
			if(controlloMovimentoProtagonista()) {
				esito = true;
			}
		}while(!esito);
		
		if(esito && mappa[protagonista.getCoordinataX()][protagonista.getCoordinataY()]=='M') {
			Mostro daCombattere = new Mostro();
			Battaglia combattimento = new Battaglia(daCombattere, protagonista);
			combattimento.generaBattaglia();
		} else if(esito && mappa[protagonista.getCoordinataX()][protagonista.getCoordinataY()]=='C') {
			
		}
		
	}
	
	public boolean controlloMovimentoProtagonista() {
		
		if (mappa[protagonista.getCoordinataX()][protagonista.getCoordinataY()]=='.' || mappa[protagonista.getCoordinataX()][protagonista.getCoordinataY()]=='C' || mappa[protagonista.getCoordinataX()][protagonista.getCoordinataY()]=='M')
			return true;
		
		return false;
	}	
	

}
