package STL.LinkedList;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import Main.Drawer;
import Main.Node;
import Main.Paint;

public class LinkedListDeal {
	private Drawer dr = Drawer.getInstance();
	Vector<Node> que = new Vector<Node>();
	int dis = 30;
	int height = 60;
	int width = 60;

	public LinkedListDeal(Vector<String> args) {
		int index = 0;
		for (String str : args) {
			AddDraw(new Point(dis, dis + index++ * height), str);
		}
		draw();
		dr.clearCanvas();
		dr.repaint();
	}

	private void AddDraw(Point p, String name) {
		Node n = new Node();
		n.add(new Paint().setSize(width, height).getRectangle(Color.ORANGE, p)
				.setString(name).setFontSize(30));
		p.translate(width, 0);
		n.add(new Paint().setSize(width, height).getRectangle(Color.YELLOW, p)
				.setString("pointer").setFontSize(13));
		que.add(n);
	}

	private void draw() {
		dr.addNode(que);
	}
}
