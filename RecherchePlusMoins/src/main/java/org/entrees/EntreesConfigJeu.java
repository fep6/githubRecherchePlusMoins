package org.entrees;



import java.io.FileInputStream;
import java.util.Properties;

import org.affichage.AffichageConsole;
import org.divers.GestionConformites;



public class EntreesConfigJeu {

	private AffichageConsole acEcj;
	private GestionConformites gcEcj ;
	private FileInputStream fis = null;
	// Classe Properties permet de gérer les propriétés du fichier config.properties
	private Properties p = new Properties();
	private int modeJeu=0;
	private int nCoups=0;
	private int nPions=0;
	private boolean admin=false; 

	public EntreesConfigJeu () {
		gcEcj = new GestionConformites();
		acEcj = new AffichageConsole();
	}

	public void entreesFichierConfigJeu(boolean commAdmin) {		
		gcEcj.gestionExceptionFichierConfig (fis , p);	
		nCoups=gcEcj.getNCoups();
		nPions=gcEcj.getNPions();
		admin=gcEcj.getConfAdmin()||admin;
	}

	public void setModeJeu(){	
		do {
			acEcj.menuMode();	
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
	public int getNCoups() {
		return nCoups;
	}
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
