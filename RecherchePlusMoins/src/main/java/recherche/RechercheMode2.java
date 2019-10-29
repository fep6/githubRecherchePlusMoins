package recherche;

import test.ComparatifAffichageTest;

/**
 * Mode 2 "Défenseur": L'ordinateur a le rôle d’attaquant et doit faire une proposition d’une combinaison de X chiffres.
 * @author fep
 */
public class RechercheMode2 extends RechercheMode{

	String stringTableauJeuMode2="";
	
	public RechercheMode2(int coups, int pions){
		super(coups, pions);		
		initVariablesDicho(dichoPlus, dichoMoins, dichoMax, pions);
	}
/**
 * Le défenseur créé sa combinaison secrète et on lance le jeu par tour
 * @see Jeu
 * Classe amont
 * @see CombinaisonSecrete
 * Classe avale
 * @param modeJeu
 * Mode de jeu (2 ou 3)
 * @param coup
 * Nos de coup en cours
 * @param pions
 * Nombre de pions maximum
 * @param admin	
 * Mode administrateur
 */
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {
		cs.doCombinaisonSecrete(modeJeu , pions, admin);
		combinaisonJoueur= cs.getCombinaisonSecreteJoueur();
		while (jeuEnCours) {
			jeuParTour(coups, pions);
		} 
		System.out.println("...Fin de la partie : "+ cat2.getVerdict());
	}
/**
 * A chaque tour, on compare l'entrée de l'attaquant avec l'entrée de la défense
 * et on affiche le résultat
 * @see doRechercheMode(int modeJeu, int coups, int pions, boolean admin)
 * @see ComparatifAffichageTest
 * @param coups
 * @param pions	
 */
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
	}
/**
 * Attaque de l'ordinateur et réponse de en fonction de la combinaison du joueur
 * @see jeuParTour(int coups, int pions)
 * N° de coup en cours
 * @param coup
 * N° de coup en cours
 * @param tableauJeu
 * Tableau attaquant
 * @param tableauReponseJoueur
 * Tableau défenseur
 * @param dichoPlus
 * Recherche dichotomique vers le haut
 * @param dichoMoins
 * Recherche dichotomique vers le bas
 * @param Max
 * Chiffrage maximum de pions
 * @param cat2
 * Instance Comparatif et affichage
 * @param pions
 * Nombre de pions maximum
 */
	 void entreesJeuOrdi(int coup, int[][] tableauJeuMode2,String[][] tableauReponseJoueur, int[] dichoPlus, 
		int[] dichoMoins, int Max ,ComparatifAffichageTest cat2, int pions){
		stringTableauJeuMode2="";
		System.out.println("----------------------------");
		System.out.println("PROPOSITION DE L'ORDINATEUR:");
		if (coup==0) {
			// Au début, l'ordinateur prend la valeur (couleur) maximum
			for (int pion=0;pion<pions;pion++) {	
				tableauJeuMode2[0][pion]=(int) (Max/2);
			stringTableauJeuMode2 = stringTableauJeuMode2 + Integer.toString(tableauJeuMode2[0][pion]);
			}
		} else {
			//Ensuite, l'ordinateur fait une recherche dichotomique selon la comparaison de la valeur d'avant
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
		System.out.println("----------------------------");
	}
/**
 * initialisation des parametres pour la recherche dichotomique
 * @see RechercheMode2(int coups, int pions)
 * @param dichoPlus
 * Recherche dichotomique vers le haut
 * @param dichoMoins
 * Recherche dichotomique vers le bas
 * @param Max
 * Chiffrage maximum de pions
 * @param pions
 * Nombre de pions maximum
 */
	void initVariablesDicho(int[]dichoPlus,int[]dichoMoins,int dichoMax, int pions) {
		for (int pion =0; pion<pions; pion++) {
			dichoPlus[pion]=dichoMax;
			dichoMoins[pion]=0;
		}
	}
}



