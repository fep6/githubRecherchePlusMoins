package org.recherche;

import org.affichage.AffichageConsole;

/**
 * Le joueur et l’ordinateur jouent tour à tour. 
 * Le premier à trouver la combinaison secrète de l'autre a gagné ! 
 * @author fep
 */
public class RechercheMode3 extends RechercheMode {

	private RechercheMode1 rm1;
	private RechercheMode2 rm2;
	private AffichageConsole acRm3;

	public RechercheMode3(int coups, int pions){
		super(coups, pions);
		acRm3= new AffichageConsole();
		rm1 = new RechercheMode1(coups, pions);
		rm2 = new RechercheMode2(coups, pions);
	}
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {		
		cs.doCombinaisonSecrete(modeJeu, pions, admin);
		combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
		combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
		rm2.initVariablesDicho(dichoPlus, dichoMoins, dichoMax, pions);
		while (jeuEnCours) {
			jeuParTour(coups, pions); 
		}
		acRm3.verdictsMode3(cat1,cat2);
	}
	private void jeuParTour(int coups, int pions) {
		boleenSiGagne= true;
		acRm3.affichageTour(coup);
		rm1.entreesJoueur(coup, tableauJeuMode1, pions );
		rm2.entreesJeuOrdi(coup, tableauJeuMode2,tableauReponseJoueur,dichoPlus, dichoMoins, dichoMax, cat2, pions);
		cat1.setModeEnCours1();
		cat1.doComparatifAffichageTest(tableauJeuMode1,combinaisonOrdi,boleenSiGagne, coup, tourRestant, pions );
		cat2.setModeEnCours2();
		cat2.doComparatifAffichageTest(tableauJeuMode2,combinaisonJoueur,boleenSiGagne, coup,tourRestant, pions);
		if (!cat1.getVerdict().equals(acRm3.joueurGagne()) && !cat1.getVerdict().equals(acRm3.joueurPerd()) 
				&& !cat2.getVerdict().equals(acRm3.ordiGagne()) && !cat2.getVerdict().equals(acRm3.ordiPerd())) {
			jeuEnCours =true;
		} else {
			jeuEnCours =false;
		}
		cat1.affichageRecapitulatif(tourRestant, coup, coups);
		coup++;
	}
}

	
	
	
	
	
	

