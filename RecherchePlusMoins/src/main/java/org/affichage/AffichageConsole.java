package org.affichage;

import org.entrees.EntreesManuellesDuJeu;

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
	 public void debutManche(int manche) {
			System.out.println("_________________________________________________________________________________");
			System.out.println("Début de la manche: "+ manche);
	 }	
	 public void finManche(int manche) {
			System.out.println("_________________________________________________________________________________");
			System.out.println("Fin de la manche: "+ manche);
	 }
	 public void finJeu() {
			System.out.println("Fin définitive du jeu!");
			System.out.println("_________________________");
	 }

/**
 * @see EntreesConfigJeu
 */
public void affichageRecapitulatifConfigJeu(int modeJeu, int nCoups, int nPions){
	System.out.println("\n _____________________________________________ \n ");	
	System.out.println("\n RECAPTULATIF: \n Vous avez choisi le jeu:");
	System.out.println("Avec " + nPions + " pions, à retrouver en " 
	+ nCoups +" coups maximum.");
	System.out.println("Enfin, vous avez choisi le mode:");
	if (modeJeu == 1) {
		System.out.println(" \' Challenger \' où vous devez trouver la combinaison secrète de l'ordinateur");
	}
	else if (modeJeu == 2) {
		System.out.println("  \' Défenseur \' où c'est à l'ordinateur de trouver votre combinaison secrète");
	}
	else if (modeJeu == 3) {
		System.out.println("  \' Duel \' où l'ordinateur et vous jouez tour à tour,\n" + 
				"le premier à trouver la combinaison secrète de l'autre a gagné");
	}
	System.out.println("\n _____________________________________________ \n ");	
}
public void menuMode() {
	System.out.println("veuillez entrer le mode à choisir:\n"
	+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
	+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
	+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
	+ "le premier à trouver la combinaison secréte de l'autre a gagné");
}

/**
 * @see EntreesManuellesDuJeu
 */
public void questionRecommenceJeu() {
	System.out.println("Voulez-vous recommencer le jeu (oui/non)?");
}

/**
 * ?
 */
public void entreeProposition(int pions) {
		System.out.println("Veuillez entrer votre proposition.  (Attention: " + pions + " pions à entrer)");
}



public void entreesEronneesNombrePions(int pions) {
		System.out.println("Votre entree est erronnée!");
		System.out.println("Merci de rentrer le bon nombre de pions. A savoir: " + pions + " chiffres (pions)");
}
public void entreesEronneesValeurPions(int pions) {
	System.out.println("Votre entree est erronnée!");
	System.out.println("Svp d'entrer "+ pions + " pions d'une valeur entre 0 et 9!");
 }

/**
 * @see RechercheMode1
 */

























}