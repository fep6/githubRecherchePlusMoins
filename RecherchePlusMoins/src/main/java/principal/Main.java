package principal;

/**
 * 
 * @author fep
 *
 */

public class Main {
	public static void main(String[] args) {
  
		Jeu j = new Jeu();
	 	j.gestionCommandeAdmin(args);
		j.tl4j.debutJeu();
		j.setJeu();
		j.doJeu();
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		j.tl4j.finJeu();
   }
}


