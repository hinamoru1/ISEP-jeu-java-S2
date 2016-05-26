/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudescouleursjava;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author nicolas
 */
public class JeuDesCouleursJava {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map yolo=  new Map();
        int[][] carteReele = yolo.creationTableau(5,5); //on met la carte cree dans une variable
        
        yolo.afficheTableau(carteReele);
//        System.out.println("");
//        casePosedeMax(carteReele);
        color couleurAJouer1;
        color couleurAJouer2;
        while(casePosedeMax(carteReele)==false){
            System.out.println("PREMIER JOUEUR A TOI DE JOUER");
            couleurAJouer1 = Map.demandeCouleur(carteReele,1); //premiere joueur qui choisit sa couleur
            carteReele = caseAEtudier(carteReele,couleurAJouer1,1);//ca modifie les valleurs
            yolo.afficheTableau(carteReele);//on affiche
            
            System.out.println("DEUXIEME JOUEUR A TOI DE JOUER");
            couleurAJouer2 = Map.demandeCouleur(carteReele,2); //deuxieme joueur qui choisit sa couleur
            carteReele = caseAEtudier(carteReele,couleurAJouer2,2);
            yolo.afficheTableau(carteReele);
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
                        System.out.println("♥ le premier joueur a gagné ♥");
                        return true;
                    }
                }
                else if((valeurTeste.equals(2))){
                    nbCaseJoueur2++;
                    if(nbCaseJoueur2>nbCaseFinale){
                        System.out.println("♥ le deuxieme joueur a gagné ♥");
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
                Integer valleurCase = tab[k][l]%10;
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
    
    
    }
    

