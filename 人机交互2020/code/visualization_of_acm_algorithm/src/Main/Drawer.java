package Main;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JComponent;

public class Drawer extends JComponent {
	/**
	 * 可添加Shape的画板 多重叠缓存的画板
	 * 
	 * @author 6g3y Alpha http://tieba.baidu.com/p/1787344682
	 *         http://www.cnitblog.com/zcy860511/archive/2009/01/25/54017.html
	 *         https://docs.oracle.com/javase/7/docs/api/java/awt/geom/
	 *         AffineTransform.html
	 */
	static Drawer myDramwe;
	Vector<Node> nodes = new Vector<Node>();
	Vector<Node> nodesBack = null;
	Point startDrag, endDrag, detDrag;
	BufferedImage bufBack = new BufferedImage(1920, 1080,
			BufferedImage.TYPE_INT_ARGB);
	BufferedImage bufMain = new BufferedImage(1920, 1080,
			BufferedImage.TYPE_INT_ARGB);
	BufferedImage bufOper = new BufferedImage(1920, 1080,
			BufferedImage.TYPE_INT_ARGB);
	boolean touchFlag = false;
	int touchType = 0;

	public Drawer() throws Exception {
		addListener();
		if (myDramwe != null)
			throw new Exception("不允许多开画板");
		myDramwe = this;
	}

	public static Drawer getInstance() {
		return myDramwe;
	}

	public void addNode(Node p) {
		nodes.add(p);
	}

	public void addNode(Vector<Node> ns) {
		for (Node p : ns)
			nodes.add(p);
	}

	private boolean linkAble = false;

	public void addListener() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				touchFlag = true;
				touchType = e.getModifiers();
				startDrag = new Point(e.getX(), e.getY());
				detDrag = new Point(0, 0);
				endDrag = startDrag;
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				touchType = e.getModifiers();
				touchFlag = false;
				if (endDrag != null)
					detDrag = new Point(e.getX() - endDrag.x, e.getY()
							- endDrag.y);
				else
					detDrag = new Point(0, 0);
				while (!drawable)
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				if ((touchType & 4) != 0)
					LinkOperator();
				repaint();
				startDrag = null;
				endDrag = null;
				touchType = 0;
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				touchType = e.getModifiers();
				if (endDrag != null)
					detDrag = new Point(e.getX() - endDrag.x, e.getY()
							- endDrag.y);
				else
					detDrag = new Point(0, 0);
				endDrag = new Point(e.getX(), e.getY());
				touchFlag = true;
				repaint();
			}
		});
	}

	private BufferedImage resize(BufferedImage buf) {
		if (buf.getWidth() < this.getWidth()
				|| buf.getHeight() < this.getHeight()) {
			BufferedImage tmp = new BufferedImage(this.getWidth(),
					this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			tmp.getGraphics().drawImage(buf, 0, 0, buf.getWidth(),
					buf.getHeight(), null);
			return tmp;
		}
		return buf;
	}

	private void paintBackground(Graphics2D g2) {
		if (bufBack.getWidth() == this.getWidth()
				&& bufBack.getHeight() == this.getHeight()) {
			g2.drawImage(bufBack, 0, 0, this.getWidth(), this.getHeight(), null);
			return;
		}
		bufBack = resize(bufBack);
		Graphics2D g = (Graphics2D) bufBack.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setPaint(Color.LIGHT_GRAY);
		for (int i = 0; i < getSize().width; i += 10) {
			Shape line = new Line2D.Float(i, 0, i, getSize().height);
			g.draw(line);
		}
		for (int i = 0; i < getSize().height; i += 10) {
			Shape line = new Line2D.Float(0, i, getSize().width, i);
			g.draw(line);
		}
		// bufBack =ChangeImage.rotateImage(bufBack,60);
		g.dispose();
		g2.drawImage(bufBack, 0, 0, bufBack.getWidth(), bufBack.getHeight(),
				null);
	}

	/**
	 * 清理画板
	 */
	public void clearCanvas() {
		bufMain = new BufferedImage(bufMain.getWidth(), bufMain.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
	}

	private void paintMain(Graphics2D g2) {
		bufMain = resize(bufMain);
		Graphics2D g = (Graphics2D) bufMain.getGraphics();
		g.setStroke(new BasicStroke(2));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.50f));
		// System.out.println("s");
		for (Node n : nodes) {
			n.painting(g);
		}
		if (nodes.size() != 0)
			nodesBack = nodes;
		nodes = new Vector<Node>();
		g.dispose();
		g2.drawImage(bufMain, 0, 0, bufBack.getWidth(), bufBack.getHeight(),
				null);
	}

	public void Paint(Graphics gs) {
		Graphics2D g = (Graphics2D) (gs);
		paintBackground(g);
	}

	private boolean drawable = true;

	public boolean drawAble() {
		return drawable;
	}

	public void paint(Graphics gs) {
		if (!drawable)
			return;
		drawable = false;
		Graphics2D g = (Graphics2D) gs;
		// g.setPaint(new Color(0xff,0xff,0xff,0xff));
		// g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground(g);
		if ((touchType & 8) != 0)// middle
			paintMove(g);
		paintMain(g);
		if ((touchType & 16) != 0)// right
			paintOperator(g);
		if ((touchType & 4) != 0)// middle
			paintLink(g);
		drawable = true;
	}

	private void paintLink(Graphics2D g2) {
		if (startDrag != null && endDrag != null) {
			bufOper = resize(bufOper);
			Graphics2D g = (Graphics2D) bufOper.getGraphics();
			g.setBackground(new Color(0, 0, 0, 0));
			g.clearRect(0, 0, bufOper.getWidth(), bufOper.getHeight());

			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					1.0f));

			g.setStroke(new BasicStroke(2));
			g.setPaint(Color.BLACK);
			Shape r = new Line2D.Double(startDrag.x, startDrag.y, endDrag.x,
					endDrag.y);
			g.draw(r);
			g.dispose();
			g2.drawImage(bufOper, 0, 0, bufBack.getWidth(),
					bufBack.getHeight(), null);
		}
	}

	private void LinkOperator() {
		if (nodesBack != null && startDrag != null && endDrag != null) {
			linkAble = false;
			Node a = null, b = null;
			int i = -1;
			for (i = nodesBack.size() - 1; i >= 0; i--) {
				if (nodesBack.get(i).getPaint().contains(startDrag)) {
					a = nodesBack.get(i);
					break;
				}
			}
			if (i < 0)
				return;
			for (i = nodesBack.size() - 1; i >= 0; i--) {
				if (nodesBack.get(i).getPaint().contains(endDrag)) {
					b = nodesBack.get(i);
					break;
				}
			}
			if (i < 0)
				return;
			if (a == b)
				return;
			a.linkAbs(a, startDrag, b, endDrag);
			nodes = nodesBack;
			nodesBack = null;
			clearCanvas();
			drawable = true;
		}
	}

	private void paintMove(Graphics2D g) {
		Point temp = endDrag;
		if (!touchFlag || nodesBack == null)
			return;
		for (int i = nodesBack.size() - 1; i >= 0; i--) {
			if (nodesBack.get(i).getPaint().contains(temp)) {
				Node t = nodesBack.get(i);
				t.Translate(detDrag);
				nodesBack.removeElementAt(i);
				nodesBack.add(t);
				break;
			}
		}
		clearCanvas();
		nodes = nodesBack;
		nodesBack = null;
	}

	private void paintOperator(Graphics2D g2) {
		if (startDrag != null && endDrag != null) {
			bufOper = resize(bufOper);
			Graphics2D g = (Graphics2D) bufOper.getGraphics();
			g.setBackground(new Color(0, 0, 0, 0));
			g.clearRect(0, 0, bufOper.getWidth(), bufOper.getHeight());

			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					1.0f));

			g.setStroke(new BasicStroke(2));
			g.setPaint(Color.BLACK);
			Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x,
					endDrag.y);
			g.draw(r);
			g.dispose();
			g2.drawImage(bufOper, 0, 0, bufBack.getWidth(),
					bufBack.getHeight(), null);
		}
	}

	private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
				Math.abs(x1 - x2), Math.abs(y1 - y2));
	}
}

// int imageWidth = 200;
// int imageHeight = 200;
// BufferedImage image = new BufferedImage(imageWidth, imageHeight,
// BufferedImage.TYPE_INT_RGB);
// Graphics graphics = image.getGraphics();
// int fontSize = 100;
// Font font = new Font("楷体", Font.PLAIN, fontSize);
// graphics.setFont(font);
// graphics.setColor(new Color(246, 96, 0));
// graphics.fillRect(0, 0, imageWidth, imageHeight);
// graphics.setColor(new Color(255, 255, 255));
// int strWidth = graphics.getFontMetrics().stringWidth("好");
// graphics.drawString("好", fontSize - (strWidth / 2), fontSize + 30);
// try {
// ImageIO.write(image, "PNG", new File("D:\\abc.png"));
// } catch (IOException e) {
// e.printStackTrace();
// }
// graphics.dispose();
