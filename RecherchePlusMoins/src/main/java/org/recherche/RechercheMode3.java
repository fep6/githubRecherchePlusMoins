package org.recherche;

import org.entrees.CombinaisonSecrete;
import org.principal.Jeu;

/**
 * Le joueur et l’ordinateur jouent tour à tour. 
 * Le premier à trouver la combinaison secrète de l'autre a gagné ! 
 * @author fep
 */
public class RechercheMode3 extends RechercheMode {

	private RechercheMode1 rm1;
	private RechercheMode2 rm2;

	public RechercheMode3(int coups, int pions){
		super(coups, pions);
		rm1 = new RechercheMode1(coups, pions);
		rm2 = new RechercheMode2(coups, pions);
	}
/**
 * Le défenseur et l'ordinateur créent leur combinaison secrète et on lance le jeu par tour
 * @see Jeu
 * Classe amont
 * @see CombinaisonSecrete
 * Classe avale
 * @param modeJeu
 * Mode de jeu
 * @param coup
 * N° de coup en cours
 * @param pions
 * Nombre de pions maximum
 * @param admin	
 * Mode administrateur	
 */
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {		
		cs.doCombinaisonSecrete(modeJeu, pions, admin);
		combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
		combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
		rm2.initVariablesDicho(dichoPlus, dichoMoins, dichoMax, pions);
		while (jeuEnCours) {
			jeuParTour(coups, pions); 
		}				
		System.out.println("Verdict du joueur = " + cat1.getVerdict());				
		System.out.println("Verdict de l'ordinateur = " + cat2.getVerdict());
	}
/**
 * A chaque tour, on compare l'entrée de l'attaquant avec l'entrée de la défense
 * et on affiche le résultat
 * @see Jeu
 * Classe amont
 * @see CombinaisonSecrete
 * Classe avale
 * @param coup
 * N° de coup en cours
 * @param pions
 * Nombre de pions maximum
 */
	private void jeuParTour(int coups, int pions) {
		boleenSiGagne= true;
		System.out.println("\n Nous sommes au tour N° :" + (int)(coup+1));
		rm1.entreesJoueur(coup, tableauJeuMode1, pions );
		rm2.entreesJeuOrdi(coup, tableauJeuMode2,tableauReponseJoueur,dichoPlus, dichoMoins, dichoMax, cat2, pions);
		cat1.setModeEnCours1();
		cat1.doComparatifAffichageTest(tableauJeuMode1,combinaisonOrdi,boleenSiGagne, coup, tourRestant, pions );
		cat2.setModeEnCours2();
		cat2.doComparatifAffichageTest(tableauJeuMode2,combinaisonJoueur,boleenSiGagne, coup,tourRestant, pions);
		if (!cat1.getVerdict().equals("LE JOUEUR A GAGNE!") && !cat1.getVerdict().equals("LE JOUEUR A PERDU!") 
				&& !cat2.getVerdict().equals("L'ORDINATEUR A GAGNE!") && !cat2.getVerdict().equals("L'ORDINATEUR A PERDU!")) {
			jeuEnCours =true;
		} else {
			jeuEnCours =false;
		}
		cat1.affichageRecapitulatif(tourRestant, coup, coups);
		coup++;
	}
}

	
	
	
	
	
	

