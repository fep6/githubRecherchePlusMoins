package org.recherche;

import org.entrees.EntreesManuellesDuJeu;

/**
 * Mode 1 "Challenger" : Le joueur attaque
 * l’ordinateur joue le rôle de défenseur.
 * @author fep
 */
public class RechercheMode1 extends RechercheMode{
/**
 * Variables de l'entrée du joueur humain lors de sa proposition d'attaque dans le jeu
 * @see EntreesManuellesDuJeu
 * @param coups
 * @param pions	
 */
	private EntreesManuellesDuJeu emjMode1;
	
	public RechercheMode1(int coups, int pions){
		super(coups, pions);
		emjMode1 = new EntreesManuellesDuJeu (pions);
	}
/**
 * Le défenseur créé sa combinaison secrète et on lance le jeu par tours tant que le jeu est en cours
 * @param modeJeu
 * Mode de jeu en cours
 * @param coups
 * Nombre de coups maximum
 * @param pions
 * Nombre de pions maximum
 * @param admin
 * Acces administrateur	 (triche)
 */
	public void doRechercheMode(int modeJeu, int coups, int pions, boolean admin) {

		cs.doCombinaisonSecrete(modeJeu, pions, admin);
		combinaisonOrdi= cs.getCombinaisonSecreteOrdi();
		while (jeuEnCours) {
			jeuParTour(coups, pions);
		}
		System.out.println("...Fin de la partie : "+ cat1.getVerdict());
	}
/**
 * A chaque tour, on compare l'entrée de l'attaquant avec l'entrée de la défense
 * et on affiche le résultat
 * @see ComparatifAffichageTest
 * Nombre de coups maximum
 * @param coups
 * Nombre de pions maximum
 * @param pions
 */
	private void jeuParTour(int coups, int pions) {
		boleenSiGagne= true;
		this.entreesJoueur(coup, tableauJeuMode1, pions);
		cat1.setModeEnCours1() ;
		cat1.doComparatifAffichageTest(tableauJeuMode1,combinaisonOrdi,boleenSiGagne, coup, tourRestant, pions);
			if (!cat1.getVerdict().equals("LE JOUEUR A GAGNE!") && !cat1.getVerdict().equals("LE JOUEUR A PERDU!")) {
				jeuEnCours =true;
			} else {
				jeuEnCours =false;
			}
			cat1.affichageRecapitulatif(tourRestant, coup, coups);
			coup++;
	}
/**
 * Entrées du joueur
 * @see jeuParTour(int coups, int pions)
 * N° de coup
 * @param coup
 * Tableau de l'attaquant (joueur ou ordi) selon le mode de jeu
 * @param tableauJeuMode1
 * N° de coup en cours
 * @param coup
 * Nombre de pions maximum 
 * @param pions
 */
	void entreesJoueur(int coup, int[][] tableauJeuMode1, int pions) {
		System.out.println("----------------------------");
		System.out.println("PROPOSITION DU JOUEUR:");
		emjMode1.doEntreesManuellesDesPions(pions);
		for ( int pion=0;pion<pions;pion++) {				
			tableauJeuMode1[coup][pion]=emjMode1.getEntree(pion);	
		}
	}
}

	

