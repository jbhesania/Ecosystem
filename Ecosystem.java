

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Ecosystem implements ActionListener {

	public static Ecosystem ecosystem;
	public static final int WIDTH = 800, HEIGHT=800, GWIDTH = 15, GHEIGHT=15; 

	public RendererEco renderer;
	
	
	public boolean gameOver;
	protected static LinkedList<Animal> animals = new LinkedList<Animal>();

	public Ecosystem(int pred, int prey){ 
		renderer = new RendererEco();

		for(int i=0; i<pred; i++) {
			Ecosystem.animals.add(new Animal("predator"));
		}
		for(int i=0; i<prey; i++) {
			Ecosystem.animals.add(new Animal("prey"));
		}
		JFrame jframe = new JFrame("Snakey Snake");
		jframe.add(renderer);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);

		Timer timer = new Timer(30, this);
		timer.start();
		
	}
	public Ecosystem() {
		this(5, 55);
	}
	
	
	
	public void repaint(Graphics g) {				
		/* for every animal in animals print something
		 * (x, y) where x goes down and y goes to the right
		 */
		g.setColor(Color.gray);							//the background
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		for(int i=0; i< Ecosystem.animals.size(); i++){
			if(Ecosystem.animals.get(i).type.equals("predator")) {
				g.setColor(Color.red);							//the bird
				g.fillRect(Ecosystem.animals.get(i).x,Ecosystem.animals.get(i).y,GWIDTH, GHEIGHT);
			}
//CHECK IF DIFF FOR ELSE
			if(Ecosystem.animals.get(i).type.equals("prey")) {
				g.setColor(Color.green);							//the bird
				g.fillRect(Ecosystem.animals.get(i).x,Ecosystem.animals.get(i).y,GWIDTH, GHEIGHT);
			}
		}
		

	}
	public void actionPerformed(ActionEvent e) {
		int a = (int)(Math.random()*Ecosystem.animals.size());
		Ecosystem.animals.get(a).move();
		
		renderer.repaint();
	}

	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter number of predator then number of prey");
		ecosystem = new Ecosystem(inp.nextInt(), inp.nextInt());
			
	}
}