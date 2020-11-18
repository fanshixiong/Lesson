package GraphTheory.Astar;

import java.awt.Color;
import java.awt.Point;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

import Main.Drawer;
import Main.Node;
import Main.Paint;

public class AstarDeal {

	private Drawer dr = Drawer.getInstance();
	Vector<Node> que = new Vector<Node>();
	Queue<Point> queue = null;
	String[] s;
	int dis = 30;
	int height = 60;
	int width = 60;
	Point startPoint = new Point(dis, dis);

	static Point start = new Point(0, 0), end = new Point(0, 0);

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

	public AstarDeal(String[] arg) {
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
		getSumAstar(start.x, start.y);
		draw();
	}

	private int step = 0;
	private int stepleap = 0;

	public void change(int n) {
		step = 0;
		stepleap = n;
		vis = new int[vis.length];
		changeAstar(start.x, start.y);
		draw();
		// create(que.get(tick), startPoint, 0);
	}

	private static int dist(Point a) {
		return (int) (100 * Math.sqrt((a.x - end.x) * (a.x - end.x)
				+ (a.y - end.y) * (a.y - end.y)));
	}

	private static int cmp(Point a, Point b) {
		return dist(a) - dist(b);
		// return (Math.abs(a.x - end.x) + Math.abs(a.y - end.y))- (Math.abs(b.x
		// - end.x) + Math.abs(b.y - end.y));
	}

	public boolean changeAstar(int x, int y) {
		queue = new PriorityQueue<Point>(new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return cmp(a, b);
			}
		});
		vis[getIndex(x, y)] = 1;
		queue.offer(new Point(x, y));
		while (!que.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = now.x + path[i][0];
				int b = now.y + path[i][1];
				int idx = getIndex(a, b);
				Point p = new Point(a, b);
				if (vis[getIndex(now.x, now.y)] == 1 && step < stepleap)
					que.get(getIndex(now.x, now.y)).paints.get(0).setColor(
							Color.ORANGE);
				// System.out.println(p);
				if (isLegal(a, b) && vis[idx] == 0 && map[idx] != 1) {
					sumstep++;
					if (end.equals(p)) {
						queue = null;
						return true;
					} else if (start.equals(p))
						;
					else if (++step > stepleap)
						que.get(idx).paints.get(0).setColor(Color.CYAN);
					else
						que.get(idx).paints.get(0).setColor(Color.blue);
					vis[getIndex(a, b)] = 1;
					queue.offer(new Point(a, b));
				}
			}
		}
		return false;
	}

	private int path[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private int sumstep;

	public int getSumStep() {
		return sumstep - 1;
	}

	private boolean getSumAstar(int x, int y) {
		queue = new PriorityQueue<Point>(new Comparator<Point>() {
			public int compare(Point a, Point b) {
				return cmp(a, b);
			}
		});
		vis[getIndex(x, y)] = 1;
		queue.offer(new Point(x, y));
		while (!que.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = now.x + path[i][0];
				int b = now.y + path[i][1];
				int idx = getIndex(a, b);
				Point p = new Point(a, b);
				if (isLegal(a, b) && vis[idx] == 0 && map[idx] != 1) {
					vis[getIndex(a, b)] = 1;
					sumstep++;
					if (end.equals(p)) {
						queue = null;
						return true;
					}
					queue.offer(new Point(a, b));
				}
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
