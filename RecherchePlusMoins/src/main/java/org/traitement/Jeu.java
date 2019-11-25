package org.traitement;

public class Jeu {
	
	void doJeu(String[] args){
		Manche m = new Manche();
		m.setArgsCommandeJeu(args);
		m.debutJeu(args);
		m.setJeu();
		m.doJeu();
		m.finJeu();
	}
}
