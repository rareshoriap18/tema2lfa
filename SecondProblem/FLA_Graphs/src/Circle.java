import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle {

	int x, y;
	private static int delay = 50;
	private static int radius = 100;
	public Circle(int x, int y) {
		this.x = x - delay;
		this.y = y - delay;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius, radius);
		g2d.setColor(Color.darkGray);
		g2d.fill(circle);

	}

}