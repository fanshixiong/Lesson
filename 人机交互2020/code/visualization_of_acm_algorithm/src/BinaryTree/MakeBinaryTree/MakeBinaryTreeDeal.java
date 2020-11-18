package BinaryTree.MakeBinaryTree;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import Main.Drawer;
import Main.Node;
import Main.Paint;

public class MakeBinaryTreeDeal {

	private Drawer dr = Drawer.getInstance();
	Vector<Node> que = new Vector<Node>();
	String s = null;
	int dis = 30;
	int height = 60;
	int width = 60;
	Point startPoint = new Point(1000, dis + 60);

	public MakeBinaryTreeDeal(String arg) {
		s = arg;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			AddDraw(new Point(dis, dis + index++ * height), "" + s.charAt(i));
		}
		draw();
	}

	private int tick = 0;
	private int step = 0;

	public void change(int n) {
		step = n;
		tick = 0;
		for (int i = 0; i < s.length(); i++) {
			que.get(i).links.clear();
		}
		draw();
		create(que.get(tick), startPoint, 0);
	}

	private int tp = 0;

	private void create(Node a, Point p, int deep) {
		if (tick >= step)
			return;
		que.get(tick).MoveTo(p);
		Node b = que.get(tick);
		if (!a.isLinked(a, b) && tick != step && a != b)
			a.linkAbs(a, a.paints.get(tp).getCenter(), b, b.getPaint()
					.getCenter());
		// System.out.println(que.get(tick).getPaint().getCenter());
		if (s.charAt(tick++) == '#')
			return;
		Point l = (Point) p.clone();
		int det = (3 - deep) <= 0 ? 1 : (3 - deep);
		tp = 0;
		l.translate(-2 * width * det, 2 * height);
		create(b, l, deep + 1);
		Point r = (Point) p.clone();
		tp = 2;
		r.translate(2 * width * det, 2 * height);
		create(b, r, deep + 1);
	}

	private void AddDraw(Point p, String name) {
		Node n = new Node();
		if (name.equals("#")) {
			name = "NULL";
			p.translate(width, 0);
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.CYAN, p).setString(name)
					.setFontSize(30));
		} else {
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.YELLOW, p).setString("Lson")
					.setFontSize(13));
			p.translate(width, 0);
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.CYAN, p).setString(name)
					.setFontSize(30));
			p.translate(width, 0);
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.YELLOW, p).setString("Rson")
					.setFontSize(13));
		}
		que.add(n);
	}

	private void draw() {
		// System.out.println(step);
		// for (Node n : que)
		// System.out.println(n.getPaint().getCenter());
		for (Node n : que)
			dr.addNode(n);
		dr.clearCanvas();
		dr.repaint();
	}
}
