import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import org.omg.CORBA.PRIVATE_MEMBER;

public class BubblePanel extends JPanel {

	Random rand = new Random();
	ArrayList<Bubble> bubbleList;
	int size = 25;
	
	public  BubblePanel() {
		bubbleList = new ArrayList<Bubble>();
		setBackground(Color.BLACK);
	}
	
	private class Bubble{
		private int x;
		private int y;
		private int size;
		private Color color;
		public Bubble(int newX, int newY, int newSize) {
			x = newX;
			y = newY;
			size = newSize;
			color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		}
		public void draw(Graphics canvas) {
			canvas.setColor(color);
			canvas.fillOval(x-size/2, y-size/2, size, size);
		}
	}
//	Ìí¼ÓÆÁÄ»»æÍ¼·½·¨
    public void paintComponent(Graphics canvas){
        super.paintComponent(canvas);
        for(Bubble b : bubbleList){
            b.draw(canvas);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
