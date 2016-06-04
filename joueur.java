/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudescouleursjava;
/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
*/
import java.io.*;

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

    //fonctiond de sauvegarde
    public static void ecrireGrille(String fichier,int[][] grille){
            int nbLignes=grille.length;
            int nbcolones=grille[0].length;
            try {
                FileWriter fw = new FileWriter (fichier+".txt");
                BufferedWriter bw = new BufferedWriter ( fw ) ;

                PrintWriter pw = new PrintWriter ( bw ) ;
                for(int i=0;i<nbLignes;i++){
                            for(int j=0;j<nbcolones;j++){
                                pw.print(grille[i][j]); // écrit dans le fichier grille.txt à la racine du projet
                                if(j<nbcolones-1){
                                    pw.print(",");
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
    
    public static int[][] loadAutoSave(){
        String filename = "autosave.txt";
        try{
            InputStream ips=new FileInputStream(filename); // Ouverture du fichier
            InputStreamReader ipsr=new InputStreamReader(ips); // Overture du mode lecture
            BufferedReader br=new BufferedReader(ipsr); // Onverture du buffered reader
            String ligne;
            // on le fait une premiere fois pour avoir la taille de la grille et pouvoir crée le tableau et le remplir
            ligne=br.readLine();
            String[] decompose = ligne.split(",");
            int taille = decompose.length;
            int[][] cases=new int[taille][taille];
            // on remplit la premiere ligne du tableau
            for(int j=0;j<taille;j++){
                    cases[0][j]=Integer.parseInt(decompose[j]);
                }
            //on remplit le reste
            for(int i=1;i<taille;i++){
                ligne=br.readLine();
                decompose = ligne.split(",");
                for(int j=0;j<taille;j++){
                    cases[i][j]=Integer.parseInt(decompose[j]);
                }
            }
            System.out.println("plop");
            Map.afficheTableauNormal(cases);
            return cases;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        int[][] valeur = {{0,0},{0,0}};
        return(valeur);
    }
}

//awt get screen size