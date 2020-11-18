package GraphTheory.DFS;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Main.Drawer;

public class DFSWin extends JFrame {
	// TextField inputS, inputE, inputW;
	private JTextArea jta;
	private Button b, c, d;
	private int step = 0;
	private int maxStep = 0;
	private String[] s = new String[0];

	private DFSDeal map = null;

	public DFSWin(final JFrame jf) {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				playAble = false;
				super.windowClosing(e);
				dispose();
				jf.setVisible(true);
			}
		});

		this.setTitle("DFS");

		Panel pNorth = new Panel(), pCenter = new Panel(), pSouth = new Panel();
		// inputS = new TextField(5);

		JTextPane jp = new JTextPane();
		jp.setText("���ı�������߿�(���к�ÿ�м���)�͵���ͼStart End .����·����������ǽ��(ע���ʽ��д������)����:\n"
				+ "7 9\nS.#......\n..#...#..\n..#...#..\n..##..#..\n..#...#..\n..#.###E.\n......#..");
		jp.setFont(new Font("����", Font.PLAIN, 15));
		add(jp, BorderLayout.NORTH);

		jta = new JTextArea();
		jta.setFont(new Font("����", Font.PLAIN, 15));
		JScrollPane jsp = new JScrollPane(jta);
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
				map = new DFSDeal(s);
				maxStep = map.getSumStep();
				// System.out.println(maxStep);
			}
		});

		c = new Button("��һ��");
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

		d = new Button("��һ��");
		pSouth.add(d);
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAble = false;
				if (step >= maxStep)
					return;
				step++;
				showDraw();
			}
		});

		d = new Button("�Զ�����");
		pSouth.add(d);
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAble = true;
				play();
			}
		});

		// setBounds(50, 50, 50, 50);
		setSize(500, 500);
		setVisible(true);
	}

	private void showDraw() {
		map.change(step);
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
					if (step >= maxStep || !playAble) {
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
