package org.recherche;

import org.affichage.AffichageConsole;
import org.entrees.EntreesManuellesDuJeu;

/**
 * Mode 1 "Challenger" : Le joueur attaque
 * l’ordinateur joue le rôle de défenseur.
 * @author fep
 */
public class RechercheMode1 extends RechercheMode{
	

	private AffichageConsole acRm1;
	
	public RechercheMode1(int coups, int pions){
		super(coups, pions);
		acRm1 = new AffichageConsole();
		emjMode1 = new EntreesManuellesDuJeu (pions);
	}
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {
		cs.doCombinaisonSecrete(modeJeu, pions, admin);
		combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
		while (jeuEnCours) {
			jeuParTour(coups, pions);
		}
		acRm1.finPartieMode1(cat1);
	}
	private void jeuParTour(int coups, int pions) {
		boleenSiGagne= true;
		this.entreesJoueur(coup, tableauJeuMode1, pions);
		cat1.setModeEnCours1() ;
		cat1.doComparatifAffichageTest(tableauJeuMode1,combinaisonOrdi,boleenSiGagne, coup, tourRestant, pions);
			if (!cat1.getVerdict().equals(acRm1.joueurGagne()) && !cat1.getVerdict().equals(acRm1.joueurPerd())) {
				jeuEnCours =true;
			} else {
				jeuEnCours =false;
			}
			cat1.affichageRecapitulatif(tourRestant, coup, coups);
			coup++;
	}
	void entreesJoueur(int coup, int[][] tableauJeuMode1, int pions) {
		acRm1.propositionJoueur();
		emjMode1.doEntreesManuellesDesPions(pions);
		for (int pion=0;pion<pions;pion++) {				
			tableauJeuMode1[coup][pion]=emjMode1.getEntree(pion);	
		}
	}
}

	

