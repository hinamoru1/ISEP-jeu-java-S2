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
    public static boolean choixgame;
    public static boolean Carte;
    public static color couleurAJouer;
    static int[][] carteReele;

    public static void main(String[] args) {
        Carte=true;
        //@victor
        Fenetre Fen = new Fenetre();
        Fen.setVisible(true);
        choix = false;
        choixgame = false;
        int i = 1;
        while (choix == false){
            Fen.Newgame(i);
            ++i;
            if (i==6){
                i=1;
            }
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(choixgame){
                    choixgame=false;
                    int n = JOptionPane.showConfirmDialog(
                                null,
                                "Si une partie existe deja, elle sera supprimee ! \n"+"Voulez-vous quand meme creer une nouvelle partie ?",
                                "Attention !",
                                JOptionPane.YES_NO_OPTION);
                    if(n==0){
                            Carte=true;
                            choix=true;
                    }
            }
    }

    choix = false;
    if(Carte){
    int size = Fen.asksize();
    Map yolo=  new Map();
    carteReele = yolo.creationTableau(size,size);} //on met la carte cree dans une variable
    else {
    carteReele = joueur.loadAutoSave();
    }

    int Joueur = 1;
    Fen.refresh(carteReele, Joueur);

    while(casePosedeMax(carteReele)==false){
        while(Joueur == 1){
            try {
                Thread.sleep(1);                 //tempo
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (Joueur == 1 && choix){
                carteReele = caseAEtudier(carteReele,couleurAJouer,Joueur);//ca modifie les valleurs
                Joueur = 2;
                Fen.refresh(carteReele, Joueur);
                choix = false;
            }
        }
        while(Joueur == 2){
            try {
                Thread.sleep(1);                 //tempo
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (Joueur ==2 && choix) {
                carteReele = caseAEtudier(carteReele,couleurAJouer,Joueur);
                Joueur = 1;
                Fen.refresh(carteReele, Joueur);
                choix = false;
            }
        }
        // on save la grille
        System.out.println("autoooosave en cour");
        joueur.ecrireGrille("autosave",carteReele);
    }
    Fen.EndGame();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////

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
                if(nbCaseJoueur1>=nbCaseFinale){

                    JOptionPane.showMessageDialog(null,
                                "Le gagnant est le joueur 1 ! ",
                                "Partie terminnee !",
                                JOptionPane.INFORMATION_MESSAGE,
                                null);
                    return true;
                }
            }
            else if((valeurTeste.equals(2))){
                nbCaseJoueur2++;
                if(nbCaseJoueur2>=nbCaseFinale){

                    JOptionPane.showMessageDialog(null,
                                "Le gagnant est le joueur 2 ! ",
                                "Partie terminee !",
                                JOptionPane.INFORMATION_MESSAGE,
                                null);
                    return true;
                }
            }
        }
    }
    return false;
}
    
    public static int score(int[][] tab,int joueur){
        int lignes = tab.length;
        int colones = tab[0].length;
        int nbCaseJoueur = 0;
        Integer valeurTeste = 0;
        for( int i = 0;i<lignes;i++){
            for(int j=0;j<colones;j++){
                valeurTeste = tab[i][j]%10;
                if((valeurTeste.equals(joueur))){
                    nbCaseJoueur++;
                }
            }
        }
    return nbCaseJoueur;
    }
    

    public static int[][] caseAEtudier(int[][] tab,color couleur,int joueur){
        int lignes = tab.length;
        int colones = tab[0].length;
        while (Map.choixCouleur1(couleur,tab, joueur)==true){
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
            for(int k=lignes-1;k>=0;k--){
                for(int l=colones-1;l>=0;l--){
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


