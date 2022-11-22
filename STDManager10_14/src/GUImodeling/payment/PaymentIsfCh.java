package GUImodeling.payment;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PaymentIsfCh extends JFrame {

	private JPanel contentPane;

	public PaymentIsfCh() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("환불이 완료 되었습니다.");
		lblNewLabel.setBounds(128, 58, 205, 103);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}

}
