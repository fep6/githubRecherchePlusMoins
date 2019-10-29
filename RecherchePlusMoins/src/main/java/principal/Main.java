package principal;


/**
 * 
 * @author fep
 *
 */


public class Main {
	public static void main(String[] args) {
		Jeu j = new Jeu();
		System.out.println("args= "+args);
		j.getTl4j().debutJeu();
		j.setJeu();
		j.doJeu();
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		j.getTl4j().finJeu();
   }
}


