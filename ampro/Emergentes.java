package ampro;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Emergentes extends JFrame 
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JPanel panel;

	public Emergentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((tamTotal.width/2)-250, (tamTotal.height/2)-175, 500, 350);
		panel = new JPanel();
		setContentPane(panel);
		
		//Inicializar ventana
		panel.setForeground(SystemColor.controlHighlight);
        try {
            URL imagen = Ampro.class.getResource("fondo_emergente.png");
            BufferedImage  img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder( img );
            panel.setBorder(borde);
        } catch (Exception e) {
        }
        panel.setLayout(null);
	}
}
