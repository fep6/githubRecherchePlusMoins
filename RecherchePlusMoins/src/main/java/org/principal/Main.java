package org.principal;

/**
 * @author fep
 */

public class Main {
	public static void main(String[] args) {
		Jeu j = new Jeu();
		j.setArgsCommandeJeu(args);
		j.debutJeu(args);
		j.setJeu();
		j.doJeu();
		j.finJeu();
   }
}


