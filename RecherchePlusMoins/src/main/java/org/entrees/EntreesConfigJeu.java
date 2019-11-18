package org.entrees;



import java.io.FileInputStream;
import java.util.Properties;

import org.divers.GestionConformites;



public class EntreesConfigJeu {

	private GestionConformites gcEcj ;
	private  FileInputStream fis = null;
	// Classe Properties permet de gérer les propriétés du fichier config.properties
	private Properties p = new Properties();
	private int modeJeu=0;
	private int nCoups=0;
	private int nPions=0;
	private boolean admin=false; 

	public EntreesConfigJeu () {
		gcEcj = new GestionConformites();
	}
	public void affichageRecapitulatifConfigJeu() {
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
	
	public void entreesFichierConfigJeu(boolean commAdmin) {		
		gcEcj.gestionExeptionFichierConfig (fis , p);
		nCoups=gcEcj.getNCoups();
		nPions=gcEcj.getNPions();
		admin=gcEcj.getConfAdmin()||admin;
	}

	public void setModeJeu(){	
		do {
			System.out.println("veuillez entrer le mode à choisir:\n"
			+ "1-> Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur \n"
			+ "2-> Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète \n" 
			+ "3-> Mode duel où l'ordinateur et vous jouez tour à tour, \n"
			+ "le premier à trouver la combinaison secréte de l'autre a gagné");
						
			gcEcj.testEntreeSiEntier(modeJeu);
			modeJeu = gcEcj.getResultatTestEntreeSiEntier();			
		} while ( modeJeu < 1 || modeJeu > 3 );
	}
	
	//Getters
	/**
	 * @see Jeu
	 */
	public int getModeJeu() {
		return modeJeu;
	}
	/**
	 * @see Jeu
	 */
	public int getNCoups() {
		return nCoups;
	}
	/**
	 * @see Jeu
	 */
	public int getNPions() {
		return nPions;
	}
	/**
	 * Renvoi booleen du niveau admin dans le fichier config.properties
	 * @see Jeu
	 */
	public boolean getAdmin () {
		return admin;
	}
}
