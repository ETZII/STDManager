package GUImodeling.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import calendar.DateTime;
import db.DBDAOSQL;

public class TodayQuit {
	JFrame jf;
	private JPanel contentPane;
	
	public TodayQuit() {
		jf = new Frame(300, 190).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		title();  yesBtn(); noBtn();
		jf.setVisible(true);
	}
	void title() {
		JLabel title = new Label("정말로 종료하시겠습니까?",15).getTitle();
		title.setBounds(50, 21, 192, 40);
		contentPane.add(title);
	}
	
	void yesBtn() {
		JButton yesBtn = new Button("네",10).getBtn();
		yesBtn.setBounds(50, 80, 70, 30);
		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTime dt = new DateTime();
				try {
					System.out.println(dt.getTodaydate());
					if(dt.getTodaydate()==dt.getNowDateOfMonth()) 
						new DBDAOSQL().deleteAtt();
					System.exit(0);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		contentPane.add(yesBtn);
	}
	
	void noBtn() {
		JButton noBtn = new Button("아니오",10).getBtn();
		noBtn.setBounds(170, 80, 70, 30);
		noBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					jf.dispose();
			}
		});
		contentPane.add(noBtn);
	}
}
