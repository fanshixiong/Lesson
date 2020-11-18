package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Paint extends Area {
	private Color color = Color.black;
	private String string = null;
	private int fontSize = 10;
	private Color fontColor = Color.black;

	/**
	 * ���ڻ�ͼ�Ļ���С��㹦�� ���÷����� new Paint(color).add(shape).add(...).add(...),,,;
	 * http://www.cjsdn.net/Doc/JDK60/java/awt/geom/Area.html
	 * 
	 * @author 6g3y
	 * @param color
	 *            Ψһ��ɫ
	 */
	public Paint(Color color) {
		this.color = color;
	}

	public Paint() {
		this.color = Color.pink;
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

	public Paint setFontSize(int fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	public Font getFont() {
		return new Font("����", Font.PLAIN, fontSize);
	}

	public Paint add(Shape s) {
		add(new Area(s));
		return this;
	}

	public Point getCenter() {
		Rectangle2D r = this.getBounds2D();
		return new Point((int) r.getCenterX(), (int) r.getCenterY());
	}

	public String getString() {
		return string;
	}

	public Paint setString(String string) {
		this.string = string;
		return this;
	}

	public Area getArea() {
		return this;
	}

	public Color getColor() {
		return color;
	}

	public Paint setColor(Color color) {
		this.color = color;
		return this;
	}

	private int height = 30;
	private int width = 30;

	/**
	 * @param x
	 *            x���
	 * @param y
	 *            y���
	 * @return node���(Ĭ��30*30)
	 */
	public Paint setSize(int w, int h) {
		width = w;
		height = h;
		return this;
	}

	public Paint getRectangle(Color color, Point p) {
		return new Paint(color).add(new Rectangle(p.x, p.y, width, height));
	}

}

/*
 * 
 * ��ժҪ AffineTransform AffineTransform ���ʾ 2D ����任����ִ�д� 2D ���굽���� 2D
 * ���������ӳ�䣬�������ߵġ�ֱ���ԡ��͡�ƽ���ԡ��� Arc2D Arc2D �����д洢 2D ���ȵĶ���ĳ����࣬���� 2D
 * �����ɴ�����Ρ���ʼ�Ƕȡ��ǿ�Խ�����ĳ��ȣ��ͱպ����ͣ�OPEN��CHORD �� PIE�����塣 Arc2D.Double ���ඨ���� double
 * ����ָ���Ļ��� Arc2D.Float ���ඨ���� float ����ָ���Ļ��� Area Area ����洢�Ͳ��� 2 ά�ռ��������������޹ص�������
 * CubicCurve2D CubicCurve2D �ඨ�� (x,y) ����ռ��ڵ����β������߶Ρ� CubicCurve2D.Double ʹ��
 * double ����ָ�������β������߶Ρ� CubicCurve2D.Float ʹ�� float ����ָ�������β������߶Ρ� Dimension2D
 * Dimension2D �����ڷ�װ��Ⱥ͸߶ȳߴ硣 Ellipse2D Ellipse2D ������������ζ������Բ�� Ellipse2D.Double
 * Double ���� double ���ȶ�����Բ�� Ellipse2D.Float Float ���� float ���ȶ�����Բ��
 * FlatteningPathIterator FlatteningPathIterator �෵����һ�� PathIterator ����ı�ƽ��ͼ��
 * GeneralPath GeneralPath ���ʾ����ֱ�ߡ��������ߺ����� (B��zier) ���߹���ļ���·���� Line2D Line2D ��ʾ
 * (x,y) ����ռ��е��߶Ρ� Line2D.Double ʹ�� double ����ָ�����߶Ρ� Line2D.Float ʹ�� float
 * ����ָ�����߶Ρ� Path2D Path2D ���ṩһ����ʾ���⼸����״·���ļ򵥶���������״�� Path2D.Double Double
 * �ඨ����һ������·������������˫���ȸ���ֵ��ʽ�洢�����ꡣ Path2D.Float Float
 * �ඨ����һ������·�����������Ե����ȸ���ֵ��ʽ�洢�����ꡣ Point2D Point2D �ඨ���ʾ (x,y) ����ռ���λ�õĵ㡣
 * Point2D.Double Double ���� double ���ȶ���ָ���ĵ㡣 Point2D.Float Float ���� float
 * ���ȶ���ָ���ĵ㡣 QuadCurve2D QuadCurve2D �ඨ�� (x,y) ����ռ��ڵĶ��β������߶Ρ� QuadCurve2D.Double
 * ʹ�� double ����ָ���Ķ��β������߶Ρ� QuadCurve2D.Float ʹ�� float ����ָ���Ķ��β������߶Ρ� Rectangle2D
 * Rectangle2D ������ͨ��λ�� (x,y) �ͳߴ� (w x h) ����ľ��Ρ� Rectangle2D.Double Double �ඨ��һ����
 * double ������ָ���ľ��Ρ� Rectangle2D.Float Float �ඨ��һ���� float ������ָ���ľ��Ρ�
 * RectangularShape RectangularShape ����� Shape ����Ļ��࣬��Щ����ļ�����״�ɾ��δ��嶨�塣
 * RoundRectangle2D RoundRectangle2D �ඨ��һ�����Σ��þ��ξ�����λ�� (x,y)��ά�� (w x h)
 * �Լ�Բ�ǻ��Ŀ�Ⱥ͸߶ȶ����Բ�ǡ� RoundRectangle2D.Double Double �ඨ��һ������Բ�Ƕ�ʹ�� double ����ָ���ľ��Ρ�
 * RoundRectangle2D.Float Float �ඨ��һ������Բ�Ƕ�ʹ�� float ����ָ���ľ��Ρ�
 */