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
        int[][] carteReele = yolo.creationTableau(13,13); //on met la carte cree dans une variable
        
        yolo.afficheTableau(carteReele);
        System.out.println("");
        casePosedeMax(carteReele);
        color couleurAJouer;
        while(casePosedeMax(carteReele)==false){
            System.out.println("PREMIER JOUEUR A TOI DE JOUER");
            couleurAJouer = Map.demandeCouleur(carteReele,1); //premiere joueur qui choisit sa couleur
            
            System.out.println("DEUXIEME JOUEUR A TOI DE JOUER");
            couleurAJouer = Map.demandeCouleur(carteReele,2); //deuxieme joueur qui choisit sa couleur
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
                        return true;
                    }
                }
                else if((valeurTeste.equals(2))){
                    nbCaseJoueur2++;
                    if(nbCaseJoueur2>nbCaseFinale){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    }
    

