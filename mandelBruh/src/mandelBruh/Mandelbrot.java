package mandelBruh;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Mandelbrot extends JPanel {
	
	private static final int BITMAP_WIDTH = 512;
	private static final int BITMAP_HEIGHT = 512;
	private BufferedImage image;
	
	private static final double X_MIN = 0;
	private static final double X_MAX = 511;
	private static final double Y_MIN = 0;
	private static final double Y_MAX = 511;
	
	private static final double U_MIN = 0.5;
	private static final double U_MAX = 1.3;
	private static final double V_MIN = -0.6;
	private static final double V_MAX = 1.2;
	
	public Mandelbrot() {
		int w = BITMAP_WIDTH;
		int h = BITMAP_HEIGHT;
		int imageType = BufferedImage.TYPE_INT_RGB;
		this.image = new BufferedImage(w, h, imageType);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		AffineTransform scale = new AffineTransform();
		scale.setToScale((double) w / BITMAP_WIDTH, (double) h / BITMAP_HEIGHT);
		
		WritableRaster raster = this.image.getRaster();
		
		this.mandelbrot(raster);
		
		g2d.drawImage(image, scale, this);
	}
	
	public void mandelbrot(WritableRaster raster) {
		Complex z = new Complex();
		Complex cartesian = new Complex();
		Complex uvCoord = new Complex();
		
		for (int j = 0; j < this.getHeight(); j++) {
			for (int i = 0; i < this.getWidth(); i++) {
				
				cartesian.setU(i);
				cartesian.setV(j);
				uvCoord = map(cartesian);
			}
		}
		
	}
	
	public static Complex map(Complex input) {
		Complex result = new Complex();
		result.setU(U_MIN + (U_MAX - U_MIN) * ((input.getU() - X_MIN)/(X_MAX - X_MIN)));
		result.setV(V_MIN + (V_MAX - V_MIN) * ((input.getV() - Y_MIN)/(Y_MAX - Y_MIN)));
		return result;
	}
	

}
