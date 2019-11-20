package org.entrees;



import java.util.Scanner;

import org.affichage.AffichageConsole;
import org.divers.GestionConformites;
import org.recherche.RechercheMode1;

/**
 * Entrées (int) du joueur, soit de la combinaison secrète (Mode1) ou de l'attaque (Mode2)
 * @author fep
 */
public class EntreesManuellesDuJeu {
	
	private AffichageConsole acEmdj= new AffichageConsole();
	private GestionConformites gcEntreePions;
	private int[] entreeIntDuJoueur;
	private String[] entreeStringDuJoueur;
	private String jeuEnCours;
	private GestionConformites gcRecommenceJeu;
	private boolean testSiPionEntier;
	private String entreeString;
	private Scanner sc = new Scanner(System.in);
	
	public EntreesManuellesDuJeu(){
		// acEmdj = new AffichageConsole();
		gcRecommenceJeu = new GestionConformites();
	}
	/**
	 * Constructeur selon entrées des pions du joueur	
	 * @param pions
	 * @see CombinaisonSecrete
	 * @see RechercheMode1
	 */ 
	public EntreesManuellesDuJeu(int pions){
		entreeIntDuJoueur = new int[pions];
		entreeStringDuJoueur = new String[pions];
		entreeString="";
		gcEntreePions = new GestionConformites();
	}
	public void demandeRecommenceJeu() {
		acEmdj.questionRecommenceJeu();
		gcRecommenceJeu.gestionEntreeSiRecommence();
		jeuEnCours=gcRecommenceJeu.getReponseSiRecommence();
	}
	public void doEntreesManuellesDesPions(int pions) {
		acEmdj.entreeProposition(pions);
		entreeString = sc.nextLine();
		testNombreDePions(entreeString,pions);
		testSiPionsEntiers(entreeString,entreeIntDuJoueur, pions);
	}
	private void testNombreDePions(String entreeString,int pions) {
		if (entreeString.length()!=pions) {
			acEmdj.entreesEronneesNombrePions(pions);
			doEntreesManuellesDesPions(pions);
		}
	}
	
	private void testSiPionsEntiers(String entreeString,int[] entreeIntDuJoueur,int pions) {
		for (int pion=0;pion<pions;pion++) {
			
			entreeStringDuJoueur[pion]=Character.toString(entreeString.charAt(pion));
			testSiPionEntier=false;
			
			while (testSiPionEntier==false) {
				if (gcEntreePions.testEntreeSiEntierRegEx(pion, entreeStringDuJoueur)==false){
					acEmdj.entreesEronneesValeurPions(pions);
					doEntreesManuellesDesPions(pions);
				} else {
					entreeIntDuJoueur[pion]=Character.getNumericValue(entreeString.charAt(pion));
					testSiPionEntier=true;
				}
			}
		}
	}
	
/**
 * @see CombinaisonSecrete.setCombinaisonSecreteJoueur(int pions)
 * @see RechercheMode1.entreesJoueur(int coup, int[][] tableauJeu, int pions)
 */
	public int getEntree(int p){
		return entreeIntDuJoueur[p];
	}
	public String getJeuEnCours() {
		return jeuEnCours;
	}
}
