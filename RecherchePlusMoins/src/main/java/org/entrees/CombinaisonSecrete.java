package org.entrees;

import org.affichage.AffichageConsole;
import org.principal.Jeu;
import org.recherche.RechercheMode1;
import org.recherche.RechercheMode2;
import org.recherche.RechercheMode3;

/**

 * Création de combinaison secrète de la défense (joueur ou ordi (mode 1 2 et 3))
 * @author fep
 *
 */
public class CombinaisonSecrete {
	/**
	 * Entree manuelle pour combinaison secrete du joueur (Mode2)
	 * @see RechercheMode2
	 * @see RechercheMode3
	 */
	private EntreesManuellesDuJeu emjMode2;
	/**
	 * On génère la combinaison secrète de l'ordinateur (Mode 1)
	 * @see RechercheMode1
	 * @see RechercheMode3
	 */
	private int[] combinaisonSecreteOrdi;
	/**
	 * Entrée de la combinaison secrète du joueur (Mode 2)
	 * @see RechercheMode2
	 * @see RechercheMode3
	 */	
	private int[] combinaisonSecreteJoueur;
	
	private AffichageConsole acCs = new AffichageConsole();
	
	public CombinaisonSecrete(int pions){
		emjMode2 = new EntreesManuellesDuJeu (pions);
		combinaisonSecreteOrdi  = new int[pions];
		combinaisonSecreteJoueur  = new int[pions];
	}
	/**
	 * Création de la combinaison secrète (joueur ou ordinateur)
	 * @param modeJeu
	 * Mode du jeu (1 2 ou 3)
	 * @param pions
	 * Nombre de pions maximum
	 * @param admin
	 * Mode administrateur (code triche)
	 */
	public void doCombinaisonSecrete(int modeJeu,int pions,boolean admin){ 
		if ( modeJeu == 1 ) { 
			setCombinaisonSecreteOrdi(admin);
		}
		else if ( modeJeu == 2) {
			setCombinaisonSecreteJoueur(pions);
		}
		else if ( modeJeu == 3) {
			setCombinaisonSecreteOrdi(admin);
			setCombinaisonSecreteJoueur(pions);
		}
		else {
			acCs.warningModeJeu(modeJeu);
			Jeu.getTl4j().setMessageWarning("/// WARNING!!! ///"+"N° de mode de jeu (?) = "+ modeJeu + "/// WARNING!!! ///");
		}
	}
		/**
		 * on créé la combinaison secrète de l'ordinateur (Mode 1)
		 * @param admin
		 * Selon si mode admin ou non (code triche)
		 */
		void setCombinaisonSecreteOrdi(boolean admin) {
			acCs.infoOrdi();
			for (int i=0 ; i<combinaisonSecreteOrdi.length; i++) {
				combinaisonSecreteOrdi[i]=(int) (Math.random()*10);
			}
			if (admin == true) {
				acCs.modeAdmin();
				for (int i=0 ; i<combinaisonSecreteOrdi.length; i++) {
					System.out.print((int)combinaisonSecreteOrdi[i]);
				}
				acCs.separateur();
				System.out.println("");
			}		
		}
	 	/**
	  	 * Entrées de la combinaison secrète du joueur
		 * @param pions
		 * Nombre de pions maximum
		 */
		void setCombinaisonSecreteJoueur(int pions){
		acCs.entreeJoueurCs();
		emjMode2.doEntreesManuellesDesPions(pions);
		for (int pion = 0 ; pion < pions; pion++) {
			combinaisonSecreteJoueur [pion]= emjMode2.getEntree(pion);
		}
		acCs.recapPropEntreeJoueur();
		for (int i = 0 ; i < pions; i++) {
			System.out.print(combinaisonSecreteJoueur [i]);
		}
		acCs.separateur();
	}
	/**
	 * @return la combinaison secrete de l'ordi
	 * @see RechercheMode1.doRechercheMode(int modeJeu, int coups, int pions, boolean admin)
	 */
	public int[] getCombinaisonSecreteOrdi() {
		return combinaisonSecreteOrdi;
	}
	/**
	 * @return la combinaison secrete du joueur
	 * @see RechercheMode1.doRechercheMode(int modeJeu, int coups, int pions, boolean admin)
	 */

	public int[] getCombinaisonSecreteJoueur() {
		return combinaisonSecreteJoueur;
	}
}
