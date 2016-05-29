package jeudescouleursjava;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

	
	
	
	  public Fenetre(){
		    this.setTitle("Le jeu des couleurs !");
		    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);}
	  
	  public void Joueur(int joueur){
		  this.setTitle("Joueur "+joueur+" A Ton Tour !!");
		  JOptionPane.showMessageDialog(null,
				    "Joueur " + joueur + " A Toi De Jouer !",
				    "A qui le tour ?",
				    JOptionPane.WARNING_MESSAGE);
	  }
	  
	  
	  
	  
	  public int asksize(){		  
		  
		    Object[] possibilities = {5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99};
		    Object s = JOptionPane.showInputDialog(
		                        null,
		                        "Choissisez la taille de la grille:\n"
		                                + "(Par défaut elle est de 13)"
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
		

		
		
		//Le conteneur principal
		JPanel main = new JPanel();
	    main.setBackground(Color.GRAY );
	    
	    JPanel content1 = new JPanel();
	    content1.setBackground(Color.GRAY );
	    main.add(content1);
	   		
	    JPanel content = new JPanel();
	    content.setBackground(Color.GRAY );
	   	main.add(content);
	   	
	   	JPanel content2 = new JPanel();
	    content2.setBackground(Color.GRAY );
	    main.add(content2);
	    
	    
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());
			
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
		
	    int lignes = tableau.length;
	    int colones = tableau[0].length;
	    
	  
	    
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
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
	        		content.add(cell, gbc);
	        	}
	        	if (tableau[i][j]/10==2){
	        		JPanel cell = new JPanel();
	        		cell.setBorder(BorderFactory.createLoweredBevelBorder());
	        		if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
	        			cell.setBorder(BorderFactory.createRaisedBevelBorder());
	        			
	        		}
	        		cell.setBackground(Color.orange);
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
	        		content.add(cell, gbc);
	        	}
	        	if (tableau[i][j]/10==3){
	        		JPanel cell = new JPanel();
	        		cell.setBorder(BorderFactory.createLoweredBevelBorder());
	        		if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
	        			cell.setBorder(BorderFactory.createRaisedBevelBorder());
	        			
	        		}
	        		cell.setBackground(Color.yellow);
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
	        		content.add(cell, gbc);
	        	}
	        	if (tableau[i][j]/10==4){
	        		JPanel cell = new JPanel();
	        		cell.setBorder(BorderFactory.createLoweredBevelBorder());
	        		if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
	        			cell.setBorder(BorderFactory.createRaisedBevelBorder());
	        			
	        		}
	        		cell.setBackground(Color.green);
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
	        		content.add(cell, gbc);
	        	}
	        	if (tableau[i][j]/10==5){
	        		JPanel cell = new JPanel();
	        		cell.setBorder(BorderFactory.createLoweredBevelBorder());
	        		if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
	        			cell.setBorder(BorderFactory.createRaisedBevelBorder());
	        			
	        		}
	        		cell.setBackground(Color.cyan);
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
	        		content.add(cell, gbc);
	        	}
	        	if (tableau[i][j]/10==6){
	        		JPanel cell = new JPanel();
	        		cell.setBorder(BorderFactory.createLoweredBevelBorder());
	        		if (tableau[i][j]%10==1 || tableau[i][j]%10==2) {
	        			cell.setBorder(BorderFactory.createRaisedBevelBorder());
	        			
	        		}
	        		cell.setBackground(Color.magenta);
	        		cell.setPreferredSize(new Dimension(1000/lignes,1000/colones));
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
	    
	    
	    content1.setLayout(new GridLayout(3, 1,40,40));
	    
	    if (Map.choixCouleur(Map.rouge, tableau, joueur)){
	    	content1.add(this.buttonrouge);
	    }
	    if (Map.choixCouleur(Map.orange, tableau, joueur)){
	    	content1.add(buttonorange);
	    }
	    if (Map.choixCouleur(Map.jaune, tableau, joueur)){
	    	content1.add(buttonyellow);
	    }
	    
	    content2.setLayout(new GridLayout(3, 1,40,40));
	    
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
			
		}

	
	}