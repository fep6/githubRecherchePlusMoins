package org.affichage;

public class AffichageConsole {
	/**
	 * @dee Jeu
	 * @param nbreArg
	 */
	public void rappelArgumentLigne(int nbreArg) {
		System.out.println("\n L'argument 'admin' est l'argument "+(int)(nbreArg+1)+" de la commande en ligne!");
	}
	public void rappelArgumentTrace(int nbreArg) {
		System.out.println("\n L'argument 'trace' est l'argument "+(int)(nbreArg+1)+" de la commande en ligne!");
	}
}
