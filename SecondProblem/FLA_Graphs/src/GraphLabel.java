import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GraphLabel{

	int x, y;
	String label;

	public GraphLabel(String key, String value, int x, int y) {
		this.x = x;
		this.y = y;
		this.label = key+" : "+value;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.green);
		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		g2d.drawString(label, x, y);

	}

}