package org.affichage;

import org.entrees.CombinaisonSecrete;
import org.entrees.EntreesManuellesDuJeu;
import org.principal.ComparatifAffichageTest;
import org.principal.Jeu;
import org.recherche.RechercheMode1;
import org.recherche.RechercheMode2;
import org.recherche.RechercheMode3;

public class AffichageConsole {
	/**
	 * @see Jeu
	 */
	public void argumentLigneAdmin(int nbreArg) {
		System.out.println("L'argument 'admin' est l'argument "+(int)(nbreArg+1)+" de la commande en ligne!");
	}
	public void argumentTraceAdmin(int nbreArg) {
		System.out.println("L'argument 'trace' est l'argument "+(int)(nbreArg+1)+" de la commande en ligne!");
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
			System.out.println("Enfin, vous avez choisi le mode "+ modeJeu + ":");
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
 * @see GestionConformites 
 */
	 public void rappelEntreeConforme() {
			System.out.println("Svp de bien entrer 'oui' ou 'non'...");
	 }
	 public void rappelEntree(int test) {
			System.out.println("Vous avez entré :" + test);
	 }
	 public void entreeNonEntier() {
			System.out.println(" : Cette valeur n'est pas un entier!");
	 }
	

	 /**
	  * @see EntreesManuellesDuJeu
	  */
	 public void questionRecommenceJeu() {
			System.out.println("Voulez-vous recommencer le jeu (oui/non)?");
	 }
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
	  * @see ComparatifAffichageTest 
	  * @see RechercheMode1
	  * @see RechercheMode2
	  * @see RechercheMode3
	  */
	public String joueurPerd() {
		return "LE JOUEUR A PERDU!";
	}
	public String joueurGagne() {
		return "LE JOUEUR A GAGNE!";
	}
	public String ordiPerd() {
		return "L'ORDINATEUR A PERDU!";
	}
	public String ordiGagne() {
		return "L'ORDINATEUR A GAGNE!";
	}
	public String jeuEnCours() {
		return "LE JEU EST EN COURS";
	}
	
	
	 /** 
	  * @see ComparatifAffichageTest
	  */
	public void reponseMode1() {
		 System.out.print("Reponse à la proposition du joueur (mode1)");
	}
	public void reponseMode2() {
		 System.out.print("Reponse à la proposition de l'ordinateur (mode2)");
	}
	public void erreurModeEnCours() {
		System.out.print("Erreur dans la donnée de ComparatifAffichageTest.pModeEnCours!!! ");
	}

	public void coupsRestants(int tourRestant) {
		System.out.println(" ______________________________________");
		System.out.println(" -> Il reste: "+ (int)(tourRestant-1) + " coups!");
		System.out.println(" ______________________________________");
	}
	
	
	/**
	 * @see RechercheMode1
	 */
	public void finPartieMode1(ComparatifAffichageTest cat1) {
		System.out.println("...Fin de la partie : "+ cat1.getVerdict());
	}
	public void propositionJoueur() {
		System.out.println("----------------------------");
		System.out.println("PROPOSITION DU JOUEUR:");
	}
	
	
	/**
	 * @see RechercheMode2
	 */
	public void finPartieMode2(ComparatifAffichageTest cat2) {
		System.out.println("...Fin de la partie : "+ cat2.getVerdict());
	}
	public void propositionOrdi() {
		System.out.println("----------------------------");
		System.out.println("PROPOSITION DE L'ORDINATEUR:");
	}
	
	/**
	 * @see RechercheMode3
	 */
	public void verdictsMode3(ComparatifAffichageTest cat1, ComparatifAffichageTest cat2) {				
		System.out.println("Verdict du joueur = " + cat1.getVerdict());				
		System.out.println("Verdict de l'ordinateur = " + cat2.getVerdict());
	}
	public void affichageTour(int coup) {
		System.out.println("\n Nous sommes au tour N° :" + (int)(coup+1));
	}
	
	/**
	 * @see CombinaisonSecrete
	 */
	public void warningModeJeu(int modeJeu) {
		System.out.println("/// WARNING!!! ///");
		System.out.println("N° de mode de jeu (?) = " + modeJeu);
		System.out.println("/// WARNING!!! ///");
	}
	public void infoOrdi(){
		System.out.println("L'ordinateur entre sa combinaison secrète...");
	}
	public void modeAdmin() {
		System.out.println("\n \n-------------------------------------");
		System.out.println("MODE ADMINISTRATEUR : combinaisonSecreteOrdi= ");
	}
	public void propEntreeJoueur() {
		System.out.println("Veuillez entrer votre combinaison secrète: ");
	}
	public void recapPropEntreeJoueur() {
		System.out.print("La proposition est donc: ");
	}
	public void entreeJoueurCs() {
		System.out.println("Veuillez entrer votre combinaison secrète");
	}
	/** Divers
	 * 
	 */
	public void separateur() {
		System.out.println("\n ---------------------------");
	}
}

