import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestPane extends JPanel {

	static JPanel control = new JPanel();
	private Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW};
	private ArrayList<DefaultBox> boxes = new ArrayList<DefaultBox>(25);
	private boolean reverse;
    public TestPane() {
		
    	reverse = false;
    	JButton more = new JButton();
        more.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e) {
        		Color color = colors[(int) (Math.random() * colors.length)];
                int width = 10 + (int) (Math.random() * 9);
                int height = 10 + (int) (Math.random() * 9);
                boxes.add(new DefaultBox(color, new Dimension(width, height)));
        	}
        });
        control.add(more);
        
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Box box : boxes) {
                    box.update(getSize());
                }
                repaint();
            }
        });
        timer.start();
      	
        JButton stop = new JButton();
    	stop.addActionListener(new ActionListener() {
    		public void actionPerformed (ActionEvent e) {
    			timer.stop();
    		}
    	});
    	add(stop);
    	
    	JButton go = new JButton();
    	stop.addActionListener(new ActionListener() {
    		public void actionPerformed (ActionEvent e) {
    				timer.start();
    		}
    	});
    	add(go); 
 
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Box box : boxes) {
            Graphics2D g2d = (Graphics2D) g.create();
            box.paint(g2d);
            
            g2d.dispose();
        }
    }
    public static void main(String[] args) {
	       JFrame frame = new JFrame("My First GUI");
	       JFrame frame2 = new JFrame("meh");
	       frame2.getContentPane().add(control);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.getContentPane().add(new TestPane());
	       frame.pack();
	       frame2.pack();
	       frame.setVisible(true);
	       frame2.setVisible(true);
	       frame2.setPreferredSize(new Dimension(400,400));
    }
}