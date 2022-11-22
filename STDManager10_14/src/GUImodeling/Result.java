package GUImodeling;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUImodeling.tool.Panel;

@SuppressWarnings("serial")
public class Result extends JFrame{
	private JPanel contentPane;
	private JLabel lblNewLabel;
	String str,s;
	int result;
	
	public Result(int result,String s) {
		str="에 성공했습니다.";
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 150);
		contentPane = new Panel().get();
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel(s+str);
		if(result==0) {
			str="에 실패했습니다.";
			lblNewLabel.setText(s+str);
		}
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 23, 413, 68);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
}
