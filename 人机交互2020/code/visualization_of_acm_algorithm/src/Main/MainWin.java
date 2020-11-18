package Main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * https://www.cnblogs.com/xingyunblog/p/3841031.html
 */
public class MainWin extends JFrame {
	Drawer dr;

	public MainWin() {
		try {
			dr = new Drawer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.add(dr, BorderLayout.CENTER);
		dr.repaint();
		this.setTitle("ACM 可视化 数据结构 解析");
		this.setSize(600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
