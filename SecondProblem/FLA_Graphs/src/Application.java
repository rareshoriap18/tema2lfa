import javax.swing.JFrame;

public class Application {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Graph Drawer");		
		Swing app = new Swing();
		frame.add(app);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}