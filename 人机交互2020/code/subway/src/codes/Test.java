package codes;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by Lairai on 2017/7/21.
 */
public class Test {
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater( () -> {
			JFrame subwayFrame = new MainFrame();
			subwayFrame.setTitle("地铁系统");
			subwayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			subwayFrame.setVisible(true);
		});
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(MainFrame.LOCAL_FILE_PATH_LINES)));

		while(true) {
			String amountString = bufferedReader.readLine();
			if (amountString == null) break;
			amountString = amountString.substring(2);
			System.out.println(amountString);
		}
	}
}
