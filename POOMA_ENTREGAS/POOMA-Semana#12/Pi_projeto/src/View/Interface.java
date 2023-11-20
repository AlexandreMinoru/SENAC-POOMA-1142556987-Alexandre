package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Interface extends JFrame{
	
	public Interface() throws MalformedURLException, IOException {
		setTitle("Primeira Java Swing");
		setSize(1000,1000);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().setBackground(Color.red);
		
		
		BufferedImage bufferedImage = ImageIO.read(new URL("https://images.uncyc.org/pt/thumb/8/84/Richard_milos.png/250px-Richard_milos.png.jpeg"));
		Image image = bufferedImage.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		JLabel img = new JLabel(new ImageIcon(image));

		
		img.setAlignmentX(SwingConstants.CENTER);
		img.setAlignmentY(SwingConstants.CENTER);

		add(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.revalidate();
		this.repaint();
		
		setVisible(true);
	}
	

}
