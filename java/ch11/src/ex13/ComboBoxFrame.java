package ex13;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ComboBoxFrame extends JFrame implements ActionListener {
	JLabel label;
	public ComboBoxFrame() {
		setTitle("콤보 박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		String[] animals = {"dog1", "lion", "tiger"};
		JComboBox animalList = new JComboBox(animals);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(animals[animalList.getSelectedIndex()]);
		add(animalList, BorderLayout.NORTH);
		add(label, BorderLayout.SOUTH);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String name = (String) cb.getSelectedItem();
		changePicture(name);
	}
	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon("./images/"+name + ".gif");
		label.setIcon(icon);
	}
	public static void main(String[] args) {
		ComboBoxFrame frame = new ComboBoxFrame();
	}

}
