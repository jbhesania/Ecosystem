import java.awt.Graphics;

import javax.swing.JPanel;


public class RendererEco extends JPanel{

	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Ecosystem.ecosystem.repaint(g);
	}
	

}
