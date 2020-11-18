package GraphTheory.DFS;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import Main.Drawer;
import Main.Node;
import Main.Paint;

public class DFSDeal {

	private Drawer dr = Drawer.getInstance();
	Vector<Node> que = new Vector<Node>();
	String[] s;
	int dis = 30;
	int height = 60;
	int width = 60;
	Point startPoint = new Point(dis, dis);

	Point start = new Point(0, 0), end = new Point(0, 0);

	int[] vis = null;
	int[] map = null;
	int H, W;

	private boolean isLegal(int x, int y) {
		if (x < 0 || y < 0 || x >= H || y >= W)
			return false;
		return true;
	}

	private int getIndex(int x, int y) {
		return x * W + y;
	}

	public DFSDeal(String[] arg) {
		H = Integer.parseInt(arg[0]);
		W = Integer.parseInt(arg[1]);
		map = new int[H * W];
		vis = new int[H * W];
		s = arg;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				char ch = arg[i + 2].charAt(j);
				AddDraw(new Point(dis + height * j, dis + height * i), "" + ch);
				int idx = getIndex(i, j);
				map[idx] = (ch == '.') ? 0 : (ch == 'S') ? 2 : (ch == 'E') ? 3
						: 1;
				if (map[idx] == 2)
					start = new Point(i, j);
				else if (map[idx] == 3)
					end = new Point(i, j);
			}
		}
		// System.out.println(getSumDfs(start.x, start.y));
		getSumDfs(start.x, start.y);
		draw();
	}

	private int step = 0;
	private int stepleap = 0;

	public void change(int n) {
		step = 0;
		stepleap = n;
		vis = new int[vis.length];
		changeDfs(start.x, start.y);
		draw();
		// create(que.get(tick), startPoint, 0);
	}

	public boolean changeDfs(int x, int y) {
		vis[getIndex(x, y)] = 1;
		if (end.equals(new Point(x, y)))
			return true;
		if (start.equals(new Point(x, y)))
			;
		else if (++step > stepleap)
			que.get(getIndex(x, y)).paints.get(0).setColor(Color.CYAN);
		else
			que.get(getIndex(x, y)).paints.get(0).setColor(Color.blue);
		for (int i = 0; i < 4; i++) {
			int a = x + path[i][0];
			int b = y + path[i][1];
			int idx = getIndex(a, b);
			if (isLegal(a, b) && vis[idx] == 0 && map[idx] != 1) {
				if (changeDfs(a, b))
					return true;
			}
		}
		return false;
	}

	private int path[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private int sumstep;

	public int getSumStep() {
		return sumstep - 1;
	}

	private boolean getSumDfs(int x, int y) {
		vis[getIndex(x, y)] = 1;
		sumstep++;
		if (end.equals(new Point(x, y)))
			return true;
		for (int i = 0; i < 4; i++) {
			int a = x + path[i][0];
			int b = y + path[i][1];
			int idx = getIndex(a, b);
			if (isLegal(a, b) && vis[idx] == 0 && map[idx] != 1) {
				if (getSumDfs(a, b))
					return true;
			}
		}
		return false;
	}

	private void AddDraw(Point p, String name) {
		Node n = new Node();
		if (name.equals(".")) {
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.CYAN, p).setString(name)
					.setFontSize(30));
		} else if (name.equals("S") || name.equals("E")) {
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.YELLOW, p).setString(name)
					.setFontSize(30));
		} else {
			n.add(new Paint().setSize(width, height)
					.getRectangle(Color.LIGHT_GRAY, p).setString(name)
					.setFontSize(30));
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
