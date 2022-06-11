package it.unibs.fp.esamearnaldo;

public class Main {

	public static void main(String[] args) {
		char[][] mappa = LetturaXML.creaMappa();
		
		for(int i=0; i<mappa.length; i++) {
			for(int j=0; j<mappa.length; j++) {
				System.out.print(mappa[i][j]);
			}
			System.out.println();
		}
	}

}
