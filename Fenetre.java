package jeudescouleursjava;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
//import javax.swing.JTextField;
/**
*
* @author victor
*/
public class Fenetre extends JFrame implements ActionListener{
		
	
	private JButton buttonrouge = new JButton("Rouge");
	private JButton buttonorange = new JButton("Orange");
	private JButton buttonyellow = new JButton("Jaune");
	private JButton buttongreen = new JButton("Vert");
	private JButton buttoncyan = new JButton("Bleu");
	private JButton buttonmagenta = new JButton("Violet");
	private JButton buttonNewGame= new JButton("Nouvelle Partie");
	private JButton buttonLoadGame= new JButton("Charger une Partie");

	
	
	
	  public Fenetre(){
		    this.setTitle("Le jeu des couleurs !");
		    this.setSize(1080, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);}
	  
	  public void Newgame(int i){
		  JPanel main = new JPanel();
		  main.setBackground(new Color(160,160,160));
		
		  
		  main.setLayout(new GridLayout(4, 1,40,40));
		  JLabel Titre = new JLabel("Jeux des 6 couleurs",
	                null,
	                JLabel.CENTER);
		  Titre.setFont(new Font("Impact", Font.BOLD, 45));
		  JLabel Titre2 = new JLabel("Cree par Tardieu et Dubes",
	                null,
	                JLabel.CENTER);
		  Titre2.setFont(new Font("Impact", Font.BOLD, 20));
		  if (i==1){
			  Titre.setForeground(Color.RED);
			  Titre2.setForeground(Color.MAGENTA);
		  }
		  if (i==2){
			  Titre.setForeground(Color.YELLOW);
			  Titre2.setForeground(Color.RED);
		  }
		  if (i==3){
			  
			  Titre.setForeground(Color.ORANGE);
			  Titre2.setForeground(Color.YELLOW);
		  }
		  if (i==4){
			  Titre.setForeground(Color.GREEN);
			  Titre2.setForeground(Color.ORANGE);
		  }
		  if (i==5){
			  Titre.setForeground(Color.CYAN);
			  Titre2.setForeground(Color.GREEN);
		  }
		  if (i==6){
			  Titre.setForeground(Color.MAGENTA);
			  Titre2.setForeground(Color.CYAN);
			  
		  }
		  
		  main.add(Titre);
		  
		  
		  
		  this.buttonNewGame.addActionListener(this);
		  this.buttonNewGame.setFont(new Font("Arial", Font.PLAIN, 40));
		  this.buttonNewGame.setBackground(new Color(224,224, 224));
		  this.buttonNewGame.setForeground(Color.DARK_GRAY );
		  main.add(buttonNewGame);
		  String filename = "autosave.txt";
	        try{
	            InputStream ips=new FileInputStream(filename); // Ouverture du fichier
			  this.buttonLoadGame.addActionListener(this);
			  this.buttonLoadGame.setFont(new Font("Arial", Font.PLAIN, 40));
			  this.buttonLoadGame.setBackground(new Color(224,224, 224));
			  this.buttonLoadGame.setForeground(Color.DARK_GRAY );
			  main.add(buttonLoadGame);
		  }
	        catch (Exception e){
	        	JLabel BLANK = new JLabel(" ",
		                null,
		                JLabel.CENTER);
	        	main.add(BLANK);
	        }
	        main.add(Titre2);
		  this.setContentPane(main);
		    this.setVisible(true);
		    
	  }
	  
	  
	  
	  public int asksize(){		  
		  
		    Object[] possibilities = {5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99};
		    Object s = JOptionPane.showInputDialog(
		                        null,
		                        "Choissisez la taille de la grille:\n"
		                                + "(Par defaut elle est de 13)"
		                        ,
		                        "Settings",
		                        JOptionPane.QUESTION_MESSAGE,
		                        null,
		                        possibilities,
		                        13);
		    if (s==null){
		    	return 13;
		    }
		   return (int) s;
	  }
	
	public void refresh(int[][] tableau, int joueur ){	
		int lignes = tableau.length;
	    int colones = tableau[0].length;
		
		//Le conteneur principal
		JPanel main = new JPanel();
                main.setBackground(Color.LIGHT_GRAY ); 
                int sizeON=45;
                int sizeOFF=25;  
                JLabel label1 = new JLabel("Joueur 1  -  Score : "+JeuDesCouleursJava.score(JeuDesCouleursJava.carteReele, 1)+"   ",
                    null,
                    JLabel.CENTER);

                Border paddingBorder1 = BorderFactory.createEmptyBorder(0,0,0,0);
	    
                JLabel label2 = new JLabel("Joueur 2  -  Score : "+JeuDesCouleursJava.score(JeuDesCouleursJava.carteReele, 2)+"   ",
                    null,
                    JLabel.CENTER);
                if(joueur==1){
                    label1.setFont(new Font("Impact", Font.BOLD, sizeON));
                    label2.setFont(new Font("Impact", Font.BOLD, sizeOFF));
                    label1.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder1));
                    label2.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder1));
                        main.add(label1);
                        main.add(label2);
                }
                if(joueur==2){
                    label1.setFont(new Font("Impact", Font.BOLD, sizeOFF));
                        label2.setFont(new Font("Impact", Font.BOLD, sizeON));
                        label1.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder1));
                    label2.setBorder(BorderFactory.createCompoundBorder(null,paddingBorder1));
                        main.add(label2);
                        main.add(label1);
                }

                if (tableau[0][0]/10==1){
                    label1.setForeground(Color.RED);
                }
                if (tableau[lignes-1][colones-1]/10==1){
                    label2.setForeground(Color.RED);
                }
                if (tableau[0][0]/10==2){
                    label1.setForeground(Color.ORANGE);
                }
                if (tableau[lignes-1][colones-1]/10==2){
                    label2.setForeground(Color.ORANGE);
                }
                if (tableau[0][0]/10==3){
                    label1.setForeground(Color.YELLOW);
                }
                if (tableau[lignes-1][colones-1]/10==3){
                    label2.setForeground(Color.YELLOW);
                }
                if (tableau[0][0]/10==4){
                    label1.setForeground(Color.GREEN);
                }
                if (tableau[lignes-1][colones-1]/10==4){
                    label2.setForeground(Color.GREEN);
                }
                if (tableau[0][0]/10==5){
                    label1.setForeground(Color.CYAN);
                }
                if (tableau[lignes-1][colones-1]/10==5){
                    label2.setForeground(Color.CYAN);
                }
                if (tableau[0][0]/10==6){
                    label1.setForeground(Color.MAGENTA);
                }
                if (tableau[lignes-1][colones-1]/10==6){
                    label2.setForeground(Color.MAGENTA);
                }
	    
                JPanel content = new JPanel();
                content.setBackground(Color.LIGHT_GRAY );
	   	main.add(content);
	   	
	   	JPanel content2 = new JPanel();
                content2.setBackground(Color.LIGHT_GRAY );
                main.add(content2);
	    
                //On d�finit le layout manager
                content.setLayout(new GridBagLayout());
			
                //L'objet servant � positionner les composants
                GridBagConstraints gbc = new GridBagConstraints();
            
                for (int i=0 ; i<lignes ; i++){
                    gbc.gridy = i;
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    for (int j=0;j<colones;j++){
                            if(j==colones-1){
                                gbc.gridwidth = GridBagConstraints.REMAINDER;
                            }
                            gbc.gridx = j;
                            if (tableau[i][j]/10==1){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                        cell.setBorder(BorderFactory.createRaisedBevelBorder());
                                    }
                                    cell.setBackground(Color.red);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                            if (tableau[i][j]/10==2){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                            cell.setBorder(BorderFactory.createRaisedBevelBorder());
                                    }
                                    cell.setBackground(Color.orange);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                            if (tableau[i][j]/10==3){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                            cell.setBorder(BorderFactory.createRaisedBevelBorder());

                                    }
                                    cell.setBackground(Color.yellow);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                            if (tableau[i][j]/10==4){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                            cell.setBorder(BorderFactory.createRaisedBevelBorder());

                                    }
                                    cell.setBackground(Color.green);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                            if (tableau[i][j]/10==5){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                            cell.setBorder(BorderFactory.createRaisedBevelBorder());

                                    }
                                    cell.setBackground(Color.cyan);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                            if (tableau[i][j]/10==6){
                                    JPanel cell = new JPanel();
                                    cell.setBorder(BorderFactory.createLoweredBevelBorder());
                                    if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
                                            cell.setBorder(BorderFactory.createRaisedBevelBorder());

                                    }
                                    cell.setBackground(Color.magenta);
                                    cell.setPreferredSize(new Dimension(675/lignes,675/colones));
                                    content.add(cell, gbc);
                            }
                    }
                }
	    
	    this.buttonrouge.addActionListener(this);
	    this.buttonrouge.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttonrouge.setBackground(Color.RED);
	    this.buttonrouge.setForeground(Color.DARK_GRAY);
	    
	    this.buttonorange.addActionListener(this);
	    this.buttonorange.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttonorange.setBackground(Color.ORANGE);
	    this.buttonorange.setForeground(Color.DARK_GRAY);
	    
	    this.buttonyellow.addActionListener(this);
	    this.buttonyellow.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttonyellow.setBackground(Color.YELLOW);
	    this.buttonyellow.setForeground(Color.DARK_GRAY);
	    
	    this.buttongreen.addActionListener(this);
	    this.buttongreen.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttongreen.setBackground(Color.GREEN);
	    this.buttongreen.setForeground(Color.DARK_GRAY);

	    this.buttoncyan.addActionListener(this);
	    this.buttoncyan.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttoncyan.setBackground(Color.CYAN);
	    this.buttoncyan.setForeground(Color.DARK_GRAY);

	    this.buttonmagenta.addActionListener(this);
	    this.buttonmagenta.setFont(new Font("Arial", Font.PLAIN, 40));
	    this.buttonmagenta.setBackground(Color.MAGENTA);
	    this.buttonmagenta.setForeground(Color.DARK_GRAY );
	   
	    content2.setLayout(new GridLayout(6, 1,40,40));
	    
	    if (Map.choixCouleur(Map.rouge, tableau, joueur)){
	    	content2.add(this.buttonrouge);
	    }
	    if (Map.choixCouleur(Map.orange, tableau, joueur)){
	    	content2.add(buttonorange);
	    }
	    if (Map.choixCouleur(Map.jaune, tableau, joueur)){
	    	content2.add(buttonyellow);
	    }
	    
	    if (Map.choixCouleur(Map.vert, tableau, joueur)){
	    	content2.add(buttongreen);
	    }
	    if (Map.choixCouleur(Map.bleu, tableau, joueur)){
	    	content2.add(buttoncyan);
	    }
	    if (Map.choixCouleur(Map.indigo, tableau, joueur)){
	    	content2.add(buttonmagenta);
	    }
	    
	    //On ajoute le conteneur
	    this.setContentPane(main);
	    this.setVisible(true);
	    
	}

	public void EndGame(){
		 JPanel main = new JPanel();
		  main.setBackground(new Color(160,160,160));
		  JLabel Titre = new JLabel("Merci d'avoir jouer !",
	                null,
	                JLabel.CENTER);
		  Titre.setFont(new Font("Impact", Font.BOLD, 45));
		  main.add(Titre);
		  this.setContentPane(main);
		    this.setVisible(true);
		    
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.buttonrouge){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.rouge;
		}
		if(e.getSource()== this.buttonorange){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.orange;
		}
		if(e.getSource()== this.buttonyellow){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.jaune;
		}
		if(e.getSource()== this.buttongreen){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.vert;
		}
		if(e.getSource()== this.buttoncyan){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.bleu;
		}
		if(e.getSource()== this.buttonmagenta){
			JeuDesCouleursJava.choix = true;
			JeuDesCouleursJava.couleurAJouer=Map.indigo;
		}
		if(e.getSource()== this.buttonNewGame){
			JeuDesCouleursJava.choixgame = true;
			}
		if(e.getSource()== this.buttonLoadGame){
			JeuDesCouleursJava.Carte=false;
			JeuDesCouleursJava.choix=true;
			}
		}
	}
	