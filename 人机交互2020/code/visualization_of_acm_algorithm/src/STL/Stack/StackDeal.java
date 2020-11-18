package STL.Stack;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import Main.Drawer;
import Main.Node;
import Main.Paint;

public class StackDeal {
	private Drawer dr = Drawer.getInstance();
	Node sta = new Node();
	Node ans = new Node();
	int dis = 30;
	int height = 60;
	int width = 60;

	public StackDeal(Vector<String> args) {
		Vector<String> stack = new Vector<String>();
		Vector<String> pop = new Vector<String>();
		for (String str : args) {
			// System.out.println(str);
			String io = str.substring(0, 1);
			String val = str.substring(1, str.length());
			if (io.equals("I")) {
				stack.add(val);
			} else if (io.equals("O")) {
				if (stack.isEmpty()) {
					pop.add("null");
				} else {
					pop.add(stack.lastElement());
					stack.removeElementAt(stack.size() - 1);
				}
			}
		}
		int index = 0;
		for (int i = 0; i < stack.size() - 1; i++) {
			staAddDraw(Color.CYAN, new Point(dis + index++ * width, dis),
					stack.get(i));
		}
		if (stack.size() != 0)
			staAddDraw(Color.YELLOW, new Point(dis + index++ * width, dis),
					stack.get(stack.size() - 1));
		index = 0;
		for (int i = 0; i < pop.size(); i++) {
			ansAddDraw(Color.PINK, new Point(dis + index++ * width, 2 * dis
					+ height), pop.get(i));
		}
		draw();
		dr.clearCanvas();
		dr.repaint();
	}

	private void ansAddDraw(Color color, Point p, String name) {
		ans.add(new Paint().setSize(width, height).getRectangle(color, p)
				.setString(name).setFontSize(30));
	}

	private void staAddDraw(Color color, Point p, String name) {
		sta.add(new Paint().setSize(width, height).getRectangle(color, p)
				.setString(name).setFontSize(30));
	}

	private void draw() {
		dr.addNode(sta);
		dr.addNode(ans);
	}
}
