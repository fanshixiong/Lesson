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
		this.setTitle("算法选择");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbStack = new JButton("栈");
		jbStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StackWin(jf);
				setVisible(false);
			}
		});
		this.add(jbStack);

		JButton jbQueue = new JButton("队列");
		jbQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueueWin(jf);
				setVisible(false);
			}
		});
		this.add(jbQueue);

		JButton jbLinkedList = new JButton("链表");
		jbLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LinkedListWin(jf);
				setVisible(false);
			}
		});
		this.add(jbLinkedList);

		JButton jbMBT = new JButton("前序生成二叉树");
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
