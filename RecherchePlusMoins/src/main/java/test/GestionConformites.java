package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import principal.Jeu;

public class GestionConformites {
	
	private Scanner sc;
	private String entreeJeu;
	private String jeuEnCours;
	private int resultat;
	private int nCoups;
	private int nPions;
	//Lecture sur le fichier de config di l'on est en admin (triche)
	private boolean confAdmin;
	
	public GestionConformites(){
		sc = new Scanner(System.in);
		entreeJeu="";
		resultat=0;
	}
	public boolean testEntreeSiEntierRegEx(int pion, String[] entreeStringDuJoueur) {
		String regExp="^[0-9]$";
		return entreeStringDuJoueur[pion].matches(regExp);
	}
	public void gestionEntreeSiRecommence() {
		do {
			jeuEnCours = sc.nextLine();
			if (!jeuEnCours.equals("oui")&&!jeuEnCours.equals("non")) {
				System.out.println("Svp de bien entrer 'oui' ou 'non'...");
			}
		} while(!jeuEnCours.equals("oui")&&!jeuEnCours.equals("non"));
	}
	/** Recherche des erreurs entrées clavier sur l'entrée de la configuration du jeu
	 * @param fis
	 * entrée du fichier de configuration
	 * @param p
	 * chargement de fis en plusieurs lignes (p)
	 */
	public void gestionExeptionFichierConfig(FileInputStream fis,Properties p) {
		try {
			 // Chargement du fichier config.properties à travers instanciation de File, puis de FileInputStream
			fis = new FileInputStream(new File("./IO/config.properties"));
			// On charge fis par la méthode load à travers la classe Properties (p)
			p.load(fis);
			// On charge les valeurs dans les variables
			nCoups=Integer.parseInt(p.getProperty("nCoups"));
			nPions=Integer.parseInt(p.getProperty("nPions"));
			confAdmin =Boolean.parseBoolean(p.getProperty("admin"));
		} catch (NumberFormatException e){
			Jeu.getTl4j().setMessageWarning(" La valeur entrée dans le fichier config.properties n'est pas valide.");
		} catch (FileNotFoundException e) {
			Jeu.getTl4j().setMessageWarning(" Le fichier config.properties n'a pas été trouvé.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
           try {
               if (fis != null) 
                   fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @param test
	 * @see EntreeConfigJeu
	 */
	public void testEntreeSiEntier (int test) {
		do {
			entreeJeu = sc.nextLine();
			try {
				test = Integer.parseInt(entreeJeu);
				System.out.println("Vous avez entré :" + test);
				resultat = test;
			} catch (NumberFormatException e){
				System.out.println(" : Cette valeur n'est pas un entier!");
			}
		} while(entreeJeu.equals(""));
	}
	
	//getters
	public int getNCoups() {
		return nCoups;
	}
	public int getNPions() {
		return nPions;
	}
	public boolean getConfAdmin() {
		return confAdmin;
	}
	public int getResultatTestEntreeSiEntier() {
		return resultat;
	}
	public String getReponseSiRecommence() {
		return jeuEnCours;
	}
}
