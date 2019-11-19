package org.principal;

/**
 * 
 * @author fep
 *
 */

public class Main {
	public static void main(String[] args) {
		int modeJeu;
		int nCoups;
		int nPions;
		
		Jeu j = new Jeu();
		
		j.debutJeu(args);
		j.setJeu();

		modeJeu=j.getEcj().getModeJeu();
		nCoups=j.getEcj().getNCoups();
		nPions=j.getEcj().getNPions();
		
		j.doJeu(modeJeu,nCoups, nPions );
		j.finJeu();
   }
}


