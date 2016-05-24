/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudescouleursjava;
import java.lang.*;
import java.util.Random;
import java.util.HashMap;
/**
 *
 * @author nicolas
 */
public class Map {
    //on crée les couleurs
    color rouge = new color("R", "r", 1) ;
    color orange = new color("O", "o", 2) ;
    color jaune = new color("J", "j", 3) ;
    color vert = new color("V", "v", 4) ;
    color bleu = new color("B", "b", 5) ;
    color indigo = new color("I", "i", 6) ;
    //on cree une table de achage
    HashMap<Integer,color> ht = new HashMap<>();
    {
    ht.put(1, rouge);
    ht.put(2, orange);
    ht.put(3, jaune);
    ht.put(4, vert);
    ht.put(5, bleu);
    ht.put(6, indigo);
    }

        public int[][] creationTableau(int lignes, int colones){
            int[][] DeffaultGrille= new int[lignes][colones];
            for (int i=0 ; i<lignes ; i++){
                for (int j=0;j<colones;j++){

                Random aleatoire = new Random();
                int nombre = aleatoire.nextInt(6)+1;
                DeffaultGrille[i][j]=nombre*10;
                }
            }

            //initialisation des départ
            while(DeffaultGrille[0][0]==DeffaultGrille[lignes-1][colones-1]){
                Random aleatoire = new Random();
                int nombre = aleatoire.nextInt(6)+1;
                DeffaultGrille[lignes-1][colones-1]=nombre*10;
            }
            DeffaultGrille[0][0] += 1;
            DeffaultGrille[lignes-1][colones-1] += 2;
            //fin initialisation depart

            return DeffaultGrille;
        }

        public color trouverCouleur(int pouet){
            return ht.get(pouet);
           }

        public void afficheTableau(int[][] tableau){
            int lignes = tableau.length;
            int colones = tableau[0].length;
            for (int i=0 ; i<lignes ; i++){
                System.out.println("");
                for (int j=0;j<colones;j++){
                    if(tableau[i][j]%10 ==0){
                        int col = tableau[i][j]/10;
                        System.out.print(trouverCouleur(col).initial+" "); //car non possédé
                    }
                    else{
                        int col = tableau[i][j]/10;
                        System.out.print(trouverCouleur(col).Initial+" "); //car possédé
                    }
                    /*System.out.println()*/
                }
            }
        }

        public static Boolean choixCouleur(color couleur, int[][] tab, int joueur){
            /* la couleur est déja possédée?
                la couleur est à coté?
                on est dans le tableau?
            */
            int lignes = tab.length;
            int colones = tab[0].length;
            int couleurJoueur1 = tab[0][0]/10;
            int CouleurJoueur2 = tab[lignes-1][colones-1];
            //la couleur n'est pas celle d'un joueur
            if(couleurJoueur1==couleur.numero && CouleurJoueur2==couleur.numero){
                return false;
            }
            //la couleur est bien selectionnable (elle est présente dans l'environnement imedia de la zone controlée)
            for(int i =0;i<colones;i++){
                for(int j =0;j<colones;j++){
                    int caseEvalue = tab[i][j]%10;
                    if (joueur == caseEvalue){
                        if(couleurEstPresente(couleur,tab,i,j)){
                            return true;
                        }
                    }
                }
            }
            return false; //on a fait toute les cases ayant le numero du joueur et on a pas trouver la couleur
        }
        //on donne une couleur, une map ainsi qu'une position sur cette map et ca sort si la couleur est autour de la position 
        public static Boolean couleurEstPresente(color couleur, int[][] tab,int lignes,int colones){
            /*int lignesTab = tab.length;
            int colonesTab = tab[0].length;*/
            for(int i=lignes-1; i<=lignes+1;i++){
                for(int j=colones-1; j<=colones+1;j++){
                    if(i>0 && i<tab.length && j>0 && j<tab[0].length){  //avec ca onverifie ci la case qu'on étudie est bien sur le plateau et pas a l'exterieur
                        int test = tab[i][j]/10;
                        if (couleur.numero == test){
                            return true;
                        }
                    }

                }
            }
            return false;
        }


        }

