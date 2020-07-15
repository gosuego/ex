package ex11;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class ListChangeEx extends JFrame {
	private JTextField tf = new JTextField(10);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<String>(v);
	
	public ListChangeEx() {
		setTitle("리스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 <Enter> 키"));
		c.add(tf);
		
		v.add("황기태");
		v.add("이제문");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));
		
		setSize(300,300);
		setVisible(true);
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());
				t.setText("");
				nameList.setListData(v);
			}
		});
	}

	public static void main(String[] args) {
		new ListChangeEx();
	}

}
