package org.entrees;

import java.util.Scanner;
import org.sorties.AffichageConsole;

/**
 * Entrées (int) du joueur, soit de la combinaison secrète (Mode1) ou de l'attaque (Mode2)
 * @author fep
 */
public class EntreesManuellesDuJeu {
	private AffichageConsole acEmj;
	private GestionConformites gcEntreePions;
	private int[] entreeIntDuJoueur;
	private String[] entreeStringDuJoueur;
	private String jeuEnCours;
	/**
	 * Pour recommencer le jeu (a la fin)
	 */
	private GestionConformites gcRecommenceJeu;
	private boolean testSiPionEntier;
	private String entreeString;
	private Scanner sc;
	
	public EntreesManuellesDuJeu(){
		acEmj = new AffichageConsole();
		gcRecommenceJeu = new GestionConformites();
	}
	public EntreesManuellesDuJeu(int pions){
		acEmj = new AffichageConsole();
		entreeIntDuJoueur = new int[pions];
		entreeStringDuJoueur = new String[pions];
		entreeString="";
		sc = new Scanner(System.in);
		gcEntreePions = new GestionConformites();
	}
	public void demandeRecommenceJeu() {
		acEmj.questionRecommenceJeu();
		
		gcRecommenceJeu.gestionEntreeSiRecommence();
		jeuEnCours=gcRecommenceJeu.getReponseSiRecommence();
	}
	public void doEntreesManuellesDesPions(int pions) {
		acEmj.entreeProposition(pions);
		entreeString = sc.nextLine();
		testNombreDePions(entreeString,pions);
		testSiPionsEntiers(entreeString,entreeIntDuJoueur, pions);
	}
	private void testNombreDePions(String entreeString,int pions) {
		if (entreeString.length()!=pions) {
			acEmj.entreesEronneesNombrePions(pions);
			doEntreesManuellesDesPions(pions);
		}
	}
	private void testSiPionsEntiers(String entreeString,int[] entreeIntDuJoueur,int pions) {
		for (int pion=0;pion<pions;pion++) {
			
			entreeStringDuJoueur[pion]=Character.toString(entreeString.charAt(pion));
			testSiPionEntier=false;
			
			while (testSiPionEntier==false) {
				if (gcEntreePions.testEntreeSiEntierRegEx(pion, entreeStringDuJoueur)==false){
					acEmj.entreesEronneesValeurPions(pions);
					doEntreesManuellesDesPions(pions);
				} else {
					entreeIntDuJoueur[pion]=Character.getNumericValue(entreeString.charAt(pion));
					testSiPionEntier=true; 
				}
			}
		}
	}
	public int getEntree(int p){
		return entreeIntDuJoueur[p];
	}
	public String getJeuEnCours() {
		return jeuEnCours;
	}
}
