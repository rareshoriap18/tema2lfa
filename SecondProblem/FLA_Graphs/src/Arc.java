import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Arc {

	int x1, y1, x2, y2;

	public Arc(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX() {
		return x1;
	}
	public int getY() {
		return y1;
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
		g2d.setColor(Color.darkGray);
		g2d.fill(line);
		g2d.drawLine(x1, y1, x2, y2);
	}

}