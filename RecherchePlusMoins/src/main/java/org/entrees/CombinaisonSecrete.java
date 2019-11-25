package org.entrees;

import org.sorties.AffichageConsole;
import org.traitement.Manche;

/**
 * Création de combinaison secrète de la défense (joueur ou ordi (mode 1 2 et 3))
 * @author fep
 */
public class CombinaisonSecrete {
	private EntreesManuellesDuJeu emjMode2;
	private int[] combinaisonSecreteOrdi;
	private int[] combinaisonSecreteJoueur;
	private AffichageConsole acCs = new AffichageConsole();
	
	public CombinaisonSecrete(int pions){
		emjMode2 = new EntreesManuellesDuJeu (pions);
		combinaisonSecreteOrdi  = new int[pions];
		combinaisonSecreteJoueur  = new int[pions];
	}
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
			Manche.getTl4j().setMessageWarning("/// WARNING!!! ///"+"N° de mode de jeu (?) = "+ modeJeu + "/// WARNING!!! ///");
		}
	}
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
	public int[] getCombinaisonSecreteOrdi() {
		return combinaisonSecreteOrdi;
	}
	public int[] getCombinaisonSecreteJoueur() {
		return combinaisonSecreteJoueur;
	}
}
