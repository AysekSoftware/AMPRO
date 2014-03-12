package ampro;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelBase extends JPanel 
{
	Dimension tamTotal = Toolkit.getDefaultToolkit().getScreenSize();

    public Font letraTitulo1 = new Font("Georgia", Font.BOLD, 38);
    public Font letraTexto1 = new Font("Georgia", Font.PLAIN, 28);
    public Font letraTexto2 = new Font("Georgia", Font.PLAIN, 22);
	
    protected PanelBase() 
    {
        setSize(tamTotal.width-40, tamTotal.height-258);
        
    	try {
    		setForeground(SystemColor.controlHighlight);
            try {
                URL imagen = Ampro.class.getResource("fondoPanel.jpg");
                BufferedImage  img = ImageIO.read(imagen);
                BgBorder borde = new BgBorder( img );
                setBorder(borde);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(null);   
	}
}
