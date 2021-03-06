package entrees;



import java.io.FileInputStream;
import java.util.Properties;

import test.GestionConformites;



public class EntreesConfigJeu {

	private int modeJeu=0;
	private int nCoups=0;
	private int nPions=0;
	private boolean admin=false;
	private GestionConformites gcEcj = new GestionConformites();
	private  FileInputStream fis = null;
	// Classe Properties permet de gérer les propriétés du fichier
	private Properties p = new Properties();

	public EntreesConfigJeu () {
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
	
	// Pour lecture fichier externe
	public void entreesFichierConfigJeu(boolean commAdmin) {		
		gcEcj.gestionExeptionFichierConfig (fis , p);
		nCoups=gcEcj.getNCoups();
		nPions=gcEcj.getNPions();
		//Gestion du mode administrateur: par gcEcj.getConfAdmin() 
		// (fichier de config ou par admin existant (ecj instantié ordonne ou non admin en ligne de commande)
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
	public void setAdmin(boolean b) {
		admin = b; 
	}
	
	//Getters
	/**
	 * @see
	 * Jeu
	 */
	public int getModeJeu() {
		return modeJeu;
	}
	/**
	 * @see
	 * Jeu
	 */
	public int getNCoups() {
		return nCoups;
	}
	/**
	 * @see
	 * Jeu
	 */
	public int getNPions() {
		return nPions;
	}
	/**
	 * @see
	 * Jeu
	 */
	public boolean getAdmin () {
		return admin;
	}
}
