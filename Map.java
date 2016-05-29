/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeudescouleursjava;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author nicolas
 */
public class Map {
    //on crée les couleurs
    static color rouge = new color("R", "r", 1) ;
    static color orange = new color("O", "o", 2) ;
    static color jaune = new color("J", "j", 3) ;
    static color vert = new color("V", "v", 4) ;
    static color bleu = new color("B", "b", 5) ;
    static color indigo = new color("I", "i", 6) ;
    //on cree une table de achage
    static HashMap<Integer,color> ht = new HashMap<>();
    {
    ht.put(1, rouge);
    ht.put(2, orange);
    ht.put(3, jaune);
    ht.put(4, vert);
    ht.put(5, bleu);
    ht.put(6, indigo);
    }
        // demande les dimension de la carte
        public static int definitionTailleTableau(){
            Scanner scan = new Scanner(System.in);
            System.out.println("choisit la taille de la carte, elle doit être au moins de 5x5 et max 99x99 ");
            System.out.println("ps: par deffaut elle fait 13x13");
            System.out.println("nombre de lignes : ");
            int lignes = scan.nextInt();
            while(conformeTailleTableau(lignes)==false){
                System.out.println("ton nombre de lignes n'est pas valide choisie en un entre 5 et 100 : ");
                lignes = scan.nextInt();
            }
            /*
            System.out.println("nombre de colones : ");
            int colones = scan.nextInt();
            while(conformeTailleTableau(colones)==false){
                System.out.println("ton nombre de colonnes n'est pas valide choisie en un entre 5 et 100 : ");
                colones = scan.nextInt();
            }
            */
            System.out.println("tu viens de créé une carte de "+lignes+" par "+lignes);
            int dimention = lignes*100+lignes ; //les deux premiers chiffres sont pour le nombre de lignes, les deux derniers pour le nb de colones
            return dimention;
        }
        // on verifie si le nombre est correct
        public static boolean conformeTailleTableau(int valleur){
            if(valleur>=5 && valleur<100){
//                System.out.println("true");
                return true;
            }
            else{
//                System.out.println("false");
                return false;
            }
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
            
            //on enleve les couleurs relout dans coin superieur gauche
            for (int i=0 ; i<=1 ; i++){
                for (int j=0;j<=1;j++){
                    //System.out.println("hey on va retap");
                    //System.out.println("coin top gauche : "+DeffaultGrille[i][j]);
                    DeffaultGrille[i][j] = adapterCouleurCase(i,j,DeffaultGrille);
                    //System.out.println("//////////////////////////////////////////");
                    
                }
            }
            //on fait pareil pour le bas gauche
            for (int i=lignes-2 ; i<=lignes-1 ; i++){
                for (int j=colones-2;j<=colones-1;j++){
                    //System.out.println("coin bot droit : "+DeffaultGrille[i][j]);
                    DeffaultGrille[i][j] = adapterCouleurCase(i,j,DeffaultGrille);
                    /*
                    System.out.println("i : "+i);
                    System.out.println("j : "+j);
                    System.out.println("//////////////////////////////////////////");
                    */
                    
                }
//                System.out.println("fin creation grille");
            }
//            System.out.println("1fin creation grille1");
            return DeffaultGrille;
        }
        
        //fait en sorte de  changer la couleur d'une case (pour eviter les cas tu commence et tu peux pas jouer)
        public static int adapterCouleurCase(int horizontal, int vertical, int[][] tab){
            Integer lignes = tab.length;
            Integer colones = tab[0].length;
            
            // j'ai separer les deux cas car sinon ca marche pas :x
            if ((lignes.equals(colones))){
                //on est le coin superieur gauche
                if(vertical==0 && horizontal==0 ){
                    return tab[horizontal][vertical];
                }
                //on est le coin inferieur droit
                if(vertical==lignes-1 && horizontal==colones-1 ){
                    return tab[horizontal][vertical];
                }
                //sinon autour
                while(tab[horizontal][vertical]/10==tab[lignes-1][colones-1]/10 || tab[horizontal][vertical]/10==tab[0][0]/10){
                    Random aleatoire = new Random();
                    int nombre = aleatoire.nextInt(6)+1;
                    tab[horizontal][vertical]=nombre*10;

                }
                return tab[horizontal][vertical];
            }
            else{
                //on est le coin superieur gauche
                if(vertical==0 && horizontal==0 ){
                    System.out.println("");
                    return tab[horizontal][vertical];
                }
                //on est le coin inferieur droit
                if(vertical==lignes-1 && horizontal==colones-1 ){
                    return tab[horizontal][vertical];
                }
                //sinon autour
                while(tab[horizontal][vertical]/10==tab[lignes-1][colones-1]/10 || tab[horizontal][vertical]/10==tab[0][0]/10){
                    Random aleatoire = new Random();
                    int nombre = aleatoire.nextInt(6)+1;

                    System.out.println("horizontal : "+horizontal);
                    System.out.println("vertical : "+vertical);
                    System.out.println("lignes-1 : "+lignes);
                    System.out.println("colones-1 : "+colones);
                    System.out.println("tab[horizontal][vertical] : "+tab[horizontal][vertical]/10);
                    System.out.println("tab[0][0] : "+tab[0][0]/10);
                    System.out.println("tab[lignes-1][colones-1] : "+tab[lignes-1][colones-1]/10);
                    System.out.println("modif de la tab : "+tab[horizontal][vertical]);
                    System.out.println("________________________________________________");

                    tab[horizontal][vertical]=nombre*10;

                }
                return tab[horizontal][vertical];
            }
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
                        //int testtest = tableau[i][j]%10;
                        int col = tableau[i][j]/10;
                        System.out.print(trouverCouleur(col).Initial+" "); //car possédé
                    }
                    /*System.out.println()*/
                }
            }
            System.out.println("");
        }
        public static color demandeCouleur(int[][] tab,int joueur){
            Scanner scan = new Scanner(System.in);
            System.out.println("choisit une couleur 1 pour r 2|o 3|j 4|v 5|b 6|i");
            System.out.println("ton choix? : ");
            int a = scan.nextInt();

            if (choixCouleur(ht.get(a),tab,joueur)==false){
                System.out.println("tu ne peux pas prendre cette couleur");
                System.out.println("________________________________________________");
                System.out.println("essaye encore >:)");
                
                System.out.println("AVANT recursif"+a+" "+ht.get(a));
                a = 0;
                color apresRecursif = demandeCouleur(tab,joueur);
                int azerty = apresRecursif.numero;
                System.out.println("APRES recursif"+azerty+" "+ht.get(azerty));
                return ht.get(azerty);
            }
            /*
            System.out.println("tu as choisis : "+a);
            System.out.println("________________________________________________");
            */
            return ht.get(a);
        }

        public static Boolean choixCouleur(color couleur, int[][] tab, int joueur){
            /* retourn false si on a choisit une couleur invalide
                si on a prit sa propre couleur ou celle de son adversaire
                si on a pris un couleur qui n'est pas autour de notre position
            */
            int lignes = tab.length;
            int colones = tab[0].length;
            Integer couleurJoueur1 = tab[0][0]/10;
            Integer CouleurJoueur2 = tab[lignes-1][colones-1]/10;
            Integer numCouleur = couleur.numero;
            //la couleur n'est pas celle d'un joueur
            if((couleurJoueur1.equals(numCouleur)) || (CouleurJoueur2.equals(numCouleur))){
//                System.out.println("boucle de dieu");
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
                    if(i>=0 && i<tab.length && j>=0 && j<tab[0].length){  //avec ca on verifie si la case qu'on étudie est bien sur le plateau et pas a l'exterieur
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

