/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudescouleursjava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author nicolas
 */
public class joueur {
    public static boolean entreeConsoleValide(int nombre){
        if(nombre>0){
            return true;
        }
        else{
            System.out.println("un nombre négatif ... hmm wee mais non.");
            return false;
        }
    }
    public static boolean entreeConsoleValide(double nombre){

        System.out.println("un nombre à virgule ... hmm wee mais non.");
        return false;

    }
    
    public static boolean entreeConsoleValide(String nombre){
        System.out.println("on ne te demande pas de raconter ta vie...");
        return false;
    }
    
    //cette fonction a pour but que si le joueur a tester toutes les couleurs et qu'auncune ne peut etre joueur et bien ca declare vainceur l'autre joueur
    //si on lui donne 1 ca veut dire que rouge à été selectionner et a fail
    //donc on ne lui donne que de 1-6
    public static int nePeuxPlusJouer(int nombre,int fail){
        if(nombre==1 || nombre==2 || nombre==3 || nombre==4 || nombre==5 || nombre==6){
            switch (fail){
                case 1:
                    return nombre+1;
                case 2:
                    return nombre+10;
                case 3:
                    return nombre+100;
                case 4:
                    return nombre+1000;
                case 5:
                    return nombre+10000;
                case 6:
                    return nombre+100000;
            }
        }
        else{
            //si c'est pas un fail valide on reset
            return 000000;
        }
        return 000000;
    }
    
    //fonctiond de sauvegarde
    public static void ecrireGrille(String fichier,int[][] grille){
            int nbLignes=grille.length;
            int nbcolones=grille[0].length;
            try {
                FileWriter fw = new FileWriter ( "grille.txt" ) ;
                BufferedWriter bw = new BufferedWriter ( fw ) ;

                PrintWriter pw = new PrintWriter ( bw ) ;
                for(int i=0;i<nbLignes;i++){
                            for(int j=0;j<nbcolones;j++){
                                
                                pw.print(grille[i][j]); // écrit dans le fichier grille.txt à la racine du projet
                                
                                if(j<nbcolones-1){
                                    pw.print(" ");
                                }else{
                                    bw.newLine(); // retour chariot
                                }
                            }
                        }
                pw. close ( ) ;
            }
            catch ( IOException e ) {
                System.out.println ( " Problème à l’écriture du fichier " ) ; 
                System.exit(0);
            }
        }
}
