package ex16;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class ButtonImageLabel extends JFrame {
	private JLabel imageLabel;
	private ImageIcon [] images = new ImageIcon [4];
	int currentId;
	
	public ButtonImageLabel() {
		setTitle("Open Challenge 11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		for(int i = 0; i<images.length; i++)
			images[i] = new ImageIcon("images/image" + i + ".jpg");
		
		currentId = 0; //현재 선택된 이미지 번호
		imageLabel = new JLabel(images[currentId]);  //현재 선택된 이미지를 레이블에 출력
		c.add(imageLabel, BorderLayout.CENTER);  //이미지 레이블을 센터에 부착
		c.add(new MenuPanel(), BorderLayout.SOUTH);  //2개의 화살표 버튼을 가진 메뉴판넬에 부착
		setSize(300, 400);
		setVisible(true);
	}
	//두개의 화살표 버튼을 가진 메뉴 패널
	class MenuPanel extends JPanel {
		public MenuPanel() {
			ImageIcon leftIcon = new ImageIcon("images/left.png");  //왼쪽 화살표 이미지 로딩
			ImageIcon rightIcon = new ImageIcon("images/right.png");  //오른쪽 화살표 이미지 로딩
 			JButton leftBtn = new JButton(leftIcon);   //왼쪽 버튼 생성
			JButton rightBtn = new JButton(rightIcon);  //오른쪽 버튼 생성
			
			add(leftBtn);
			add(rightBtn);
			
			// 왼쪽 화살표 버튼에 액션 리스너 달기
			leftBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					currentId --;  // 이미지 번호 감소. 이전 이미지
					currentId += images.length; //currentId가 음수가 될 수 있기 때문에 4를 더함
					currentId %= images.length;
							imageLabel.setIcon(images[currentId]); //이미지 레이블에 이미지 변경
				}
			});
			rightBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentId ++;  //이미지 번호 증가. 다음 이미지
					currentId %= images.length; // 4가 넘는 것을 막기 위해 이미지 개수로 나머지 구함
					imageLabel.setIcon(images[currentId]); //이미지 레이블에 이미지 변경
				}
			});
		}
	}

	public static void main(String[] args) {
		new ButtonImageLabel();
	}

}
