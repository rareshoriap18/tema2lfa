import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Swing extends JPanel {
	private List<Object> shapes = new ArrayList<>();
	int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

	public Swing() {
		setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(screenSize.width, screenSize.height));
		
		JTextField key = new JTextField(20);
		JTextField value = new JTextField(20);		
		ButtonGroup group = new ButtonGroup();
		JToggleButton tb1 = new JToggleButton("Draw circle");
		JToggleButton tb2 = new JToggleButton("Draw arc");
		JToggleButton tb3 = new JToggleButton("Add Label");
		JToggleButton tb4 = new JToggleButton("Remove");

		group.add(tb1);
		group.add(tb2);
		group.add(tb3);
		group.add(tb4);
		this.add(tb1);
		this.add(tb2);
		this.add(tb3);
		this.add(tb4);
		this.add(new JLabel("key: "));
		this.add(key);
		this.add(new JLabel("value: "));
		this.add(value);
		

		this.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (tb1.isSelected()) {
					addCircle(e.getX(), e.getY());
				} else if (tb2.isSelected()) {
					x2 = x1;
					y2 = y1;
					x1 = e.getX();
					y1 = e.getY();

					if (x2 != -1)
						addArc(x1, y1, x2, y2);
				} else if (tb3.isSelected()) {
					addLabel(key.getText(),value.getText(),e.getX(), e.getY());
					value.setText("");
				} else if (tb4.isSelected()) {
					pointInCircle(e.getX(),e.getY());
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON3_MASK) 
			    {
					pointInCircle(e.getX(),e.getY());
			    }
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Object s : shapes) {
			if (s instanceof Arc) {
				((Arc) s).draw(g);
			} else if (s instanceof Circle) {
				((Circle) s).draw(g);
			}else if (s instanceof GraphLabel) {
				((GraphLabel) s).draw(g);
			}
		}
	}

	public void addCircle(int x, int y) {
		shapes.add(new Circle(x, y));
		resetCoordinates();
		repaint();
	}
	
	public void resetCoordinates() {
		x1 = -1;
		x2 = -1;
		y1 = -1;
		y2 = -1;
	}
	public void addArc(int a, int b, int c, int d) {
		shapes.add(new Arc(a, b, c, d));
		resetCoordinates();
		repaint();
	}

	public void addLabel(String key, String value, int a, int b) {		
		if (key.contentEquals("")|| value.contentEquals("")) {
			JOptionPane.showMessageDialog(null, "Empty value");
		}else {
			shapes.add(new GraphLabel(key,value,a,b));
			resetCoordinates();
			revalidate();
			repaint();
		}
	}
	
	public void pointInCircle(int x,int y) {
		for (Object shape : shapes) {
			if (shape instanceof Circle) {
			int  distanceSquared = (x - ((Circle) shape).getX()) * (x - ((Circle) shape).getX()) + (y - ((Circle) shape).getY()) * (y - ((Circle) shape).getY());
			if(distanceSquared <= 100 * 100) {
				shapes.remove(shape);
				repaint();
				break;
			}
			}else if(shape instanceof Arc) {
				int  distanceSquared = (x - ((Arc) shape).getX()) * (x - ((Arc) shape).getX()) + (y - ((Arc) shape).getY()) * (y - ((Arc) shape).getY());
				if(distanceSquared <= 100 * 100) {
					shapes.remove(shape);
					repaint();
					break;
				}
			}else if(shape instanceof GraphLabel) {
				int  distanceSquared = (x - ((GraphLabel) shape).getX()) * (x - ((GraphLabel) shape).getX()) + (y - ((GraphLabel) shape).getY()) * (y - ((GraphLabel) shape).getY());
				if(distanceSquared <= 100 * 100) {
					shapes.remove(shape);
					repaint();
					break;
				}
			}
	    }
		
	}

}