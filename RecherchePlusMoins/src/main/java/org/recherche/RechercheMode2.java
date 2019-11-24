package org.recherche;

import org.principal.ComparatifAffichageTest;
import org.sorties.AffichageConsole;

/**
 * Mode 2 "Défenseur": L'ordinateur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.
 * @author fep
 */
public class RechercheMode2 extends RechercheMode{

	private AffichageConsole acRm2;
	private String stringTableauJeuMode2="";
	
	public RechercheMode2(int coups, int pions){
		super(coups, pions);
		acRm2 = new AffichageConsole();
		initVariablesDicho(dichoPlus, dichoMoins, dichoMax, pions);
	}
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {
		cs.doCombinaisonSecrete(modeJeu , pions, admin);
		combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
		while (jeuEnCours) {
			jeuParTour(coups, pions);
		}
		acRm2.finMancheMode2(pManche, cat2);
	}
	private void jeuParTour(int coups, int pions) {
		boleenSiGagne= true;
		entreesJeuOrdi(coup,tableauJeuMode2,tableauReponseJoueur,dichoPlus,dichoMoins,dichoMax,cat2,pions);
		cat2.setModeEnCours2();
			cat2.doComparatifAffichageTest(tableauJeuMode2,combinaisonJoueur,boleenSiGagne,
					coup,tourRestant,pions );
			if (!cat2.getVerdict().equals("L'ORDINATEUR A GAGNE!") && !cat2.getVerdict().equals("L'ORDINATEUR A PERDU!")) {
				jeuEnCours =true;
			} else {
				jeuEnCours =false;
			}
			cat2.affichageRecapitulatif(tourRestant, coup, coups);
		coup++;
		tourRestant--;
	}
	 void entreesJeuOrdi(int coup, int[][] tableauJeuMode2,String[][] tableauReponseJoueur, int[] dichoPlus, 
		int[] dichoMoins, int Max ,ComparatifAffichageTest cat2, int pions){
		stringTableauJeuMode2="";
		acRm2.propositionOrdi();
		if (coup==0) {
			// Au début, l'ordinateur prend la valeur (couleur) maximum
			for (int pion=0;pion<pions;pion++) {	
				tableauJeuMode2[0][pion]=(int) (Max/2);
				stringTableauJeuMode2 = stringTableauJeuMode2 + Integer.toString(tableauJeuMode2[0][pion]);
			}
		} else {
			//Ensuite, l'ordinateur fait une org.recherche dichotomique selon la comparaison de la valeur d'avant
			for (int pion=0;pion<pions;pion++) {
				tableauReponseJoueur[coup-1][pion]= cat2.getTableauReponse(coup-1,pion);
				if (tableauReponseJoueur[coup-1][pion].equals("=")) {
					tableauJeuMode2[coup][pion]=tableauJeuMode2[coup-1][pion];
					}	
				else if (tableauReponseJoueur[coup-1][pion].equals("+")) {
					dichoMoins [pion] = tableauJeuMode2[coup-1][pion];			
					}
				else if (tableauReponseJoueur[coup-1][pion].equals("-")) {
					dichoPlus [pion]=  tableauJeuMode2[coup-1][pion];
				}
				tableauJeuMode2[coup][pion]=(dichoPlus[pion] + dichoMoins[pion])/2;
				stringTableauJeuMode2 = stringTableauJeuMode2 + Integer.toString(tableauJeuMode2[coup][pion]);
			}
		}
		System.out.println(stringTableauJeuMode2);
		acRm2.separateur();
	}
	void initVariablesDicho(int[]dichoPlus,int[]dichoMoins,int dichoMax, int pions) {
		for (int pion =0; pion<pions; pion++) {
			dichoPlus[pion]=dichoMax;
			dichoMoins[pion]=0;
		}
	}
}



