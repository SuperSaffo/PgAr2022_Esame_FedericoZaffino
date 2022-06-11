package it.unibs.fp.esamearnaldo;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Personaggio {
	
	public static final int DIMENSIONE_MAPPA = 10;
	
	private String nome;
	private int vita;
	private int attacco;
	private int difesa;
	private int coordinataX;
	private int coordinataY;
	ArrayList<Oggetto> inventario;
	
	public Personaggio(String nome, int vita, int attacco, int difesa, int coordinataX, int coordinataY,
			ArrayList<Oggetto> inventario) {
		super();
		this.nome = nome;
		this.vita = vita;
		this.attacco = attacco;
		this.difesa = difesa;
		this.coordinataX = coordinataX;
		this.coordinataY = coordinataY;
		this.inventario = inventario;
	}
	
	public Personaggio() {
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getCoordinataX() {
		return coordinataX;
	}

	public void setCoordinataX(int coordinataX) {
		this.coordinataX = coordinataX;
	}

	public int getCoordinataY() {
		return coordinataY;
	}

	public void setCoordinataY(int coordinataY) {
		this.coordinataY = coordinataY;
	}

	
	
	public boolean movimentoPersonaggio() {
		
		boolean fine = false;
		char mossa;
			
		do {
			mossa = InputDati.leggiChar("Inserire la mossa da eseguire -> ");
			if (mossa == 'w' || mossa == 'a' || mossa == 's' || mossa == 'd' || mossa == 'W' || mossa == 'A' || mossa == 'S' || mossa == 'D')
				fine = true;
		}while(!fine);
		
		if (mossa == 'w' || mossa == 'W') {
			setCoordinataY(getCoordinataY() - 1);
			if(this.coordinataY<0) {
				System.out.println("Non ci si può più muovere verso l'alto");
				setCoordinataY(getCoordinataY() + 1);
			} else
				return true;
		} else if (mossa == 'a' || mossa == 'A') {
			setCoordinataX(getCoordinataX() - 1);
			if(this.coordinataX<0) {
				System.out.println("Non ci si può più muovere verso sinistra");
				setCoordinataX(getCoordinataX() + 1);
			}else
				return true;
		} else if (mossa == 'd' || mossa == 'D') {
			setCoordinataX(getCoordinataX() + 1);
			if(this.coordinataX >= DIMENSIONE_MAPPA) {
				System.out.println("Non ci si può più muovere verso destra");
				setCoordinataX(getCoordinataX() - 1);
			}else
				return true;
		} else if (mossa == 's' || mossa == 'S') {
			setCoordinataY(getCoordinataY() + 1);
			if(this.coordinataY >= DIMENSIONE_MAPPA) {
				System.out.println("Non ci si può più muovere verso il basso");
				setCoordinataY(getCoordinataY() - 1);
			}else
				return true;
		}
		
		return false;
		
	}
	
	
	
	
	

}
