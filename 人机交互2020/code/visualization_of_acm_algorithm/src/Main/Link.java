package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Link {
	private Node a, b;
	private Point ap, bp;
	private String val = null;
	private String string = null;
	private int fontSize = 10;
	private Color fontColor = Color.black;

	public String getString() {
		return string;
	}

	public Font getFont() {
		return new Font("¿¬Ìå", Font.PLAIN, fontSize);
	}

	public Link setString(String string) {
		this.string = string;
		return this;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public int getFontSize() {
		return fontSize;
	}

	public Link setFontSize(int fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	int type = 0;

	public Link linkAbs(Node a, Point ap, Node b, Point bp) {
		this.a = a;
		this.ap = getTranslate(ap, a.getPaint().getCenter());
		this.b = b;
		this.bp = getTranslate(bp, b.getPaint().getCenter());
		return this;
	}

	public Link linkRel(Node a, Point ap, Node b, Point bp) {
		this.a = a;
		this.ap = bp;
		this.b = b;
		this.bp = bp;
		return this;
	}

	public Line2D getLine() {
		return new Line2D.Float(getTranslateAdd(a.getPaint().getCenter(), ap),
				getTranslateAdd(b.getPaint().getCenter(), bp));
	}

	private Point getTranslate(Point a, Point b) {
		return new Point(a.x - b.x, a.y - b.y);
	}

	private Point getTranslateAdd(Point a, Point b) {
		return new Point(a.x + b.x, a.y + b.y);
	}

	public boolean isLinked(Node a, Node b) {
		if ((this.a == a && this.b == b) || (this.a == b && this.b == a))
			return true;
		return false;
	}

	public Point getCenter() {
		Point aa = getTranslateAdd(a.getPaint().getCenter(), ap);
		Point bb = getTranslateAdd(b.getPaint().getCenter(), bp);
		return new Point((aa.x + bb.x) / 2, (aa.y + bb.y) / 2);
	}
}
