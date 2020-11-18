package STL.Queue;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Main.Drawer;

/*
 Ia
 Ib
 Ic
 Id
 O
 O
 Ic
 Igg
 IAF
 O
 O
 O
 O
 O
 O
 */

public class QueueWin extends JFrame {
	// TextField inputS, inputE, inputW;
	private JTextArea jta;
	private Button b, c, d;
	private int step = 0;
	private String[] s = new String[0];

	public QueueWin(final JFrame jf) {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				playAble = false;
				super.windowClosing(e);
				dispose();
				jf.setVisible(true);
			}
		});

		this.setTitle("Stack");

		Panel pNorth = new Panel(), pCenter = new Panel(), pSouth = new Panel();
		// inputS = new TextField(5);

		JTextPane jp = new JTextPane();
		jp.setText("在文本中输入队列的输入和输出每个操作一行。\nI表示输入，O表示输出(注意格式，写错不负责)例如:\nIa\nO\n");
		add(jp, BorderLayout.NORTH);
		jp.setFont(new Font("楷体", Font.PLAIN, 15));

		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setFont(new Font("楷体", Font.PLAIN, 15));
		pCenter.add(jsp);
		add(jsp, BorderLayout.CENTER);

		b = new Button("Submit");
		pSouth.add(b);
		add(pSouth, BorderLayout.SOUTH);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = (jta.getText().split("[\n|\\s]{1,}"));
				int tick = 0;
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null && s[i].length() != 0)
						tick++;
				}
				String tmp[] = new String[tick];
				tick = 0;
				for (int i = 0; i < s.length; i++) {
					if (s[i].length() == 0)
						continue;
					tmp[tick++] = s[i];
				}
				s = tmp;
				step = 0;
			}
		});

		c = new Button("上一步");
		pSouth.add(c);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAble = false;
				if (step <= 0)
					return;
				step--;
				showDraw();
			}
		});

		d = new Button("下一步");
		pSouth.add(d);
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAble = false;
				if (step >= s.length)
					return;
				step++;
				showDraw();
			}
		});

		d = new Button("自动播放");
		pSouth.add(d);
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playAble)
					return;
				playAble = true;
				play();
			}
		});

		// setBounds(50, 50, 50, 50);
		setSize(500, 500);
		setVisible(true);
	}

	private void showDraw() {
		Vector<String> ans = new Vector<String>();
		for (int i = 0; i < step; i++) {
			ans.add(s[i]);
		}
		new QueueDeal(ans);
	}

	private boolean playAble = true;

	private void play() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (step >= s.length || !playAble) {
						playAble = false;
						return;
					}
					++step;
					while (!Drawer.getInstance().drawAble())
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					showDraw();
				}
			}
		}).start();
	}
}
