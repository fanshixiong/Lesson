package Main;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public class Node {
	public Vector<Paint> paints = new Vector<Paint>();
	public Vector<Link> links = new Vector<Link>();

	public Node add(Paint p) {
		paints.add(p);
		return this;
	}

	public boolean isLinked(Node a, Node b) {
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).isLinked(a, b)) {
				return true;
			}
		}
		return false;

	}

	public boolean removeBy_A_B(Node a, Node b) {
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).isLinked(a, b)) {
				links.removeElementAt(i);
				return true;
			}
		}
		return false;
	}

	public void linkAbs(Node a, Point ap, Node b, Point bp) {
		if (!removeBy_A_B(a, b))
			links.add(new Link().linkAbs(a, ap, b, bp));
	}

	public void linkRel(Node a, Point ap, Node b, Point bp) {
		if (!removeBy_A_B(a, b))
			links.add(new Link().linkRel(a, ap, b, bp));
	}

	public Node Translate(Point point) {
		for (Paint p : paints) {
			p.transform(AffineTransform.getTranslateInstance(point.x, point.y));
		}
		return this;
	}

	private Point getCenter(Rectangle2D r) {
		return new Point((int) r.getCenterX(), (int) r.getCenterY());
	}

	private Point getTranslate(Point a, Point b) {
		return new Point(a.x - b.x, a.y - b.y);
	}

	private Point getTranslateAdd(Point a, Point b) {
		return new Point(a.x + b.x, a.y + b.y);
	}

	public Node MoveTo(Point point) {
		Point center = getCenter(this.getPaint().getBounds2D());
		for (Paint p : paints) {
			Point d = getTranslate(point, center);
			p.transform(AffineTransform.getTranslateInstance(d.x, d.y));
		}
		return this;
	}

	public Node painting(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		for (Paint p : paints) {
			// System.out.println(1);
			// p.transform(AffineTransform.getTranslateInstance(26.0d, 0.0d));
			// System.out.println(this.toString());
			g.setPaint(Color.black);
			g.draw(p);
			g.setPaint(p.getColor());
			g.fill(p);
			if (p.getString() != null) {
				g.setPaint(p.getFontColor());
				g.setFont(p.getFont());
				int strWidth = g.getFontMetrics().stringWidth(p.getString());
				g.drawString(p.getString(), p.getCenter().x - strWidth / 2,
						p.getCenter().y + p.getFontSize() / 3);
			}
		}
		for (Link l : links) {

			g.setStroke(new BasicStroke(2));
			g.setPaint(l.getFontColor());
			// System.out.println(l.getCenter());
			g.draw(l.getLine());
			if (l.getString() != null) {
				g.setPaint(l.getFontColor());
				g.setFont(l.getFont());
				int strWidth = g.getFontMetrics().stringWidth(l.getString());
				g.drawString(l.getString(), l.getCenter().x - strWidth / 2,
						l.getCenter().y + l.getFontSize() / 3);
			}
		}
		return this;
	}

	/**
	 * 仅用于获取onClick，尽量用painting
	 * 
	 * @deprecated
	 */
	public Paint getPaint() {
		Paint a = new Paint();
		for (Paint p : paints) {
			a.add(p);
		}
		return a;
	}
}
