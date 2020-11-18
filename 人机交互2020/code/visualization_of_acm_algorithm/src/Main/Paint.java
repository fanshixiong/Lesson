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
	 * 用于画图的基本小块点功能 调用方法： new Paint(color).add(shape).add(...).add(...),,,;
	 * http://www.cjsdn.net/Doc/JDK60/java/awt/geom/Area.html
	 * 
	 * @author 6g3y
	 * @param color
	 *            唯一颜色
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
		return new Font("楷体", Font.PLAIN, fontSize);
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
	 *            x起点
	 * @param y
	 *            y起点
	 * @return node结点(默认30*30)
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
 * 类摘要 AffineTransform AffineTransform 类表示 2D 仿射变换，它执行从 2D 坐标到其他 2D
 * 坐标的线性映射，保留了线的“直线性”和“平行性”。 Arc2D Arc2D 是所有存储 2D 弧度的对象的抽象超类，其中 2D
 * 弧度由窗体矩形、起始角度、角跨越（弧的长度）和闭合类型（OPEN、CHORD 或 PIE）定义。 Arc2D.Double 此类定义以 double
 * 精度指定的弧。 Arc2D.Float 此类定义以 float 精度指定的弧。 Area Area 对象存储和操作 2 维空间封闭区域的与解析无关的描述。
 * CubicCurve2D CubicCurve2D 类定义 (x,y) 坐标空间内的三次参数曲线段。 CubicCurve2D.Double 使用
 * double 坐标指定的三次参数曲线段。 CubicCurve2D.Float 使用 float 坐标指定的三次参数曲线段。 Dimension2D
 * Dimension2D 类用于封装宽度和高度尺寸。 Ellipse2D Ellipse2D 类描述窗体矩形定义的椭圆。 Ellipse2D.Double
 * Double 类以 double 精度定义椭圆。 Ellipse2D.Float Float 类以 float 精度定义椭圆。
 * FlatteningPathIterator FlatteningPathIterator 类返回另一个 PathIterator 对象的变平视图。
 * GeneralPath GeneralPath 类表示根据直线、二次曲线和三次 (Bézier) 曲线构造的几何路径。 Line2D Line2D 表示
 * (x,y) 坐标空间中的线段。 Line2D.Double 使用 double 坐标指定的线段。 Line2D.Float 使用 float
 * 坐标指定的线段。 Path2D Path2D 类提供一个表示任意几何形状路径的简单而又灵活的形状。 Path2D.Double Double
 * 类定义了一条几何路径，它具有以双精度浮点值形式存储的坐标。 Path2D.Float Float
 * 类定义了一条几何路径，它具有以单精度浮点值形式存储的坐标。 Point2D Point2D 类定义表示 (x,y) 坐标空间中位置的点。
 * Point2D.Double Double 类以 double 精度定义指定的点。 Point2D.Float Float 类以 float
 * 精度定义指定的点。 QuadCurve2D QuadCurve2D 类定义 (x,y) 坐标空间内的二次参数曲线段。 QuadCurve2D.Double
 * 使用 double 坐标指定的二次参数曲线段。 QuadCurve2D.Float 使用 float 坐标指定的二次参数曲线段。 Rectangle2D
 * Rectangle2D 类描述通过位置 (x,y) 和尺寸 (w x h) 定义的矩形。 Rectangle2D.Double Double 类定义一个在
 * double 坐标中指定的矩形。 Rectangle2D.Float Float 类定义一个在 float 坐标中指定的矩形。
 * RectangularShape RectangularShape 是许多 Shape 对象的基类，这些对象的几何形状由矩形窗体定义。
 * RoundRectangle2D RoundRectangle2D 类定义一个矩形，该矩形具有由位置 (x,y)、维度 (w x h)
 * 以及圆角弧的宽度和高度定义的圆角。 RoundRectangle2D.Double Double 类定义一个所有圆角都使用 double 坐标指定的矩形。
 * RoundRectangle2D.Float Float 类定义一个所有圆角都使用 float 坐标指定的矩形。
 */