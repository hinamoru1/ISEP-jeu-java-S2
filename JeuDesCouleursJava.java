/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudescouleursjava;
//import java.awt.event.ActionEvent;
//import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class JeuDesCouleursJava {

    public static boolean choix;
	public static color couleurAJouer;
	public static void main(String[] args) {
    	
    	//@victor
    	Fenetre Fen = new Fenetre();
    	Fen.setVisible(true);
    	int size = Fen.asksize();
    	
    	
    	//
    	
        //Scanner scan = new Scanner(System.in);
        Map yolo=  new Map();
        
       //int dimentionTableau = Map.definitionTailleTableau();
       // int nbLignesCarte = trouverNbLignes(dimentionTableau);
        //int nbColonnesCarte = trouverNbColonnes(dimentionTableau);
        
        int[][] carteReele = yolo.creationTableau(size,size); //on met la carte cree dans une variable
        
        //int[][] carteReele = yolo.creationTableau(9,9); //on met la carte cree dans une variable
  
        //yolo.afficheTableau(carteReele);
//        System.out.println("");
//        casePosedeMax(carteReele);
        
        //color couleurAJouer1;
                
        //color couleurAJouer2;
        
        choix = false;
        int Joueur = 1;
        Fen.refresh(carteReele, Joueur);
        Fen.Joueur(Joueur);
        while(casePosedeMax(carteReele)==false){
        	
           // System.out.println("PREMIER JOUEUR A TOI DE JOUER");
            //couleurAJouer1 = Map.demandeCouleur(carteReele,1); //premiere joueur qui choisit sa couleur
        	if (Joueur == 1 && choix){
        		
            carteReele = caseAEtudier(carteReele,couleurAJouer,Joueur);//ca modifie les valleurs
            //yolo.afficheTableau(carteReele);//on affiche
            
            Joueur = 2;
            Fen.refresh(carteReele, Joueur);
            choix = false;
            Fen.Joueur(Joueur);
        	}
        	
        	if (Joueur ==2 && choix) {
            
            //System.out.println("DEUXIEME JOUEUR A TOI DE JOUER");
            
            //couleurAJouer2 = Map.demandeCouleur(carteReele,2); //deuxieme joueur qui choisit sa couleur
            carteReele = caseAEtudier(carteReele,couleurAJouer,Joueur);
            //yolo.afficheTableau(carteReele);
           
            Joueur = 1;
            Fen.refresh(carteReele, Joueur);
            choix = false;
            Fen.Joueur(Joueur);
        	}
        }
    }
    
    //fonction qui compte le nombre de case possédée au max renvoie true si un joueur a plus de la moitié
    
    public static boolean casePosedeMax(int[][] tab){
        int lignes = tab.length;
        int colones = tab[0].length;
        int nbCaseFinale = 1+(lignes*colones/2);
        int nbCaseJoueur1 = 0;
        int nbCaseJoueur2 = 0;
        Integer valeurTeste = 0;
        for( int i = 0;i<lignes;i++){
            for(int j=0;j<colones;j++){
                valeurTeste = tab[i][j]%10;
                if((valeurTeste.equals(1))){
                    nbCaseJoueur1++;
                    if(nbCaseJoueur1>nbCaseFinale){
                    	JOptionPane.showMessageDialog(null,
                    		    "Le gagnant est le joueur 1 !",
                    		    "Partie termin�e !",
                    		    JOptionPane.INFORMATION_MESSAGE,
                    		    null);
                        return true;
                    }
                }
                else if((valeurTeste.equals(2))){
                    nbCaseJoueur2++;
                    if(nbCaseJoueur2>nbCaseFinale){
                    	JOptionPane.showMessageDialog(null,
                    		    "Le gagnant est le joueur 2 !",
                    		    "Partie termin�e !",
                    		    JOptionPane.INFORMATION_MESSAGE,
                    		    null);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void mettreAJourLaCarte(int[][] tab,color couleur,int joueur){
        
    }
    public static int[][] caseAEtudier(int[][] tab,color couleur,int joueur){
        int lignes = tab.length;
        int colones = tab[0].length;
        //on se ballade sur le plateau pour trouve une case possedee par le joueur
        for(int k=0;k<lignes;k++){
            for(int l=0;l<colones;l++){
                Integer valleurCase = tab[k][l]%10;     //elle est possédée?
                if(valleurCase.equals(joueur)){
                    tab[k][l] = couleur.numero*10+joueur;
                    //on en a trouvée une maintenant on se ballade AUTOUR de CETTE case
                    for(int i=k-1; i<=k+1;i++){
                        for(int j=l-1; j<=l+1;j++){
                            if(i>=0 && i<tab.length && j>=0 && j<tab[0].length){  //avec ca on verifie si la case qu'on étudie est bien sur le plateau et pas a l'exterieur
                                int test = tab[i][j]/10;    //on prend la couleur,le premier numero du chiffre, de la case qu'on etudie
                                if (couleur.numero == test){
                                    tab[i][j] = couleur.numero*10+joueur; //on vient de marquer la case comme appartenant à un joueur
                                }
                            }
                        }
                    }
                }
            }
        }
        return tab;
    }
    //permet de sortir le nombre de lignes transmises par la fonction definitionTailleTableau()
    public static int trouverNbLignes(int dimention){
        int nblignes = dimention/100;
        return nblignes;
    }
    public static int trouverNbColonnes(int dimention){
        int nbcolonnes = dimention%100;
        return nbcolonnes;
    }
    
    //fin
    }
    

