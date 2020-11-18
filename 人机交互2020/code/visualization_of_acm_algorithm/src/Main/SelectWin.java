package Main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import BinaryTree.MakeBinaryTree.MakeBinaryTreeWin;
import GraphTheory.Astar.AstarWin;
import GraphTheory.BFS.BFSWin;
import GraphTheory.DFS.DFSWin;
import STL.LinkedList.LinkedListWin;
import STL.Queue.QueueWin;
import STL.Stack.StackWin;

public class SelectWin extends JFrame {
	public SelectWin() {
		final JFrame jf = this;
		this.setTitle("�㷨ѡ��");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbStack = new JButton("ջ");
		jbStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StackWin(jf);
				setVisible(false);
			}
		});
		this.add(jbStack);

		JButton jbQueue = new JButton("����");
		jbQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueueWin(jf);
				setVisible(false);
			}
		});
		this.add(jbQueue);

		JButton jbLinkedList = new JButton("����");
		jbLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LinkedListWin(jf);
				setVisible(false);
			}
		});
		this.add(jbLinkedList);

		JButton jbMBT = new JButton("ǰ�����ɶ�����");
		jbMBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MakeBinaryTreeWin(jf);
				setVisible(false);
			}
		});
		this.add(jbMBT);

		JButton jbDFS = new JButton("DFS");
		jbDFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DFSWin(jf);
				setVisible(false);
			}
		});
		this.add(jbDFS);

		JButton jbBFS = new JButton("BFS");
		jbBFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BFSWin(jf);
				setVisible(false);
			}
		});
		this.add(jbBFS);

		JButton jbAstar = new JButton("Astar");
		jbAstar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AstarWin(jf);
				setVisible(false);
			}
		});
		this.add(jbAstar);

		this.setSize(300, 300);
		this.setVisible(true);
	}
}
