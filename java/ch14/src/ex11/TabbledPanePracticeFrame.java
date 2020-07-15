package ex11;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbledPanePracticeFrame extends JFrame{
	JLabel resultLabel = new JLabel("계산 결과 출력");
	public TabbledPanePracticeFrame() {
		super("탭팬 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tPane = new JTabbedPane();
		tPane.addTab("계산입력", new QuestionPanel());
		tPane.addTab("결과보기", new AnswerPanel());
		add(tPane);
		tPane.addChangeListener(new MyChangeListener());
		setSize(350, 150);
		setVisible(true);
	}
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {          //이곳이 오타맛집 
			JTabbedPane t = (JTabbedPane)e.getSource();
			JPanel p = (JPanel)t.getSelectedComponent();
			if(p instanceof AnswerPanel) {
				AnswerPanel aPanel =(AnswerPanel)p;
				QuestionPanel qPanel = (QuestionPanel)t.getComponentAt(0);
				if(qPanel.isCalucationValid())
					aPanel.setResult(Integer.toString(qPanel.calculate()));
			else 
					aPanel.setResult("입력된 수에 문제가 있어 계산이 실패하였습니다.");
			}
		
		}

		
	}
	class QuestionPanel extends JPanel {
		boolean bCalcValid = true;
		int sum = 0;
		JTextField a = new JTextField("0", 10);
		JTextField b = new JTextField("0", 10);
		public  QuestionPanel() {
			setLayout(new FlowLayout());
			add(a);
			add(new JLabel(" + "));
			add(b);
		}
		int calculate() {
			try {
				int x = Integer.parseInt(a.getText());
				int y = Integer.parseInt(b.getText());
				sum = x+y;
				bCalcValid = true;
			}catch(NumberFormatException e2) {
				bCalcValid = false;
				sum = 0;
				return 0;
			}
			return sum;
		}
		public boolean isCalucationValid() { return(bCalcValid);}
	}
	class AnswerPanel extends JPanel {
		JLabel resultLabel = new JLabel();
		public AnswerPanel() {
			add(new JLabel("결과는 "));
			add(resultLabel);
		}
		public void setResult(String text) {
			resultLabel.setText(text);
		}
	}

	public static void main(String[] args) {
		new TabbledPanePracticeFrame();
	}

}
