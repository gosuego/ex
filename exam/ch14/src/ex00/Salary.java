package ex00;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Salary extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfBasic;
	private JTextField tfBonus;
	private JTextField tfTax;
	private int basic, bonus, total, tax, money;
	private JLabel lblResult;
	private JComboBox cboJob;
	private JComboBox cboTaxRate;
	private JComboBox cboName;

	public static void main(String[] args) {
		Salary frame = new Salary();
		frame.setVisible(true);
	}
	public Salary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성명");
		lblNewLabel.setBounds(12, 28, 57, 15);
		contentPane.add(lblNewLabel);
		
		cboName = new JComboBox();
		cboName.setModel(new DefaultComboBoxModel(new String[] {"김철수", "이순신", "이철호", "홍선호", "박수철"}));
		cboName.setBounds(81, 25, 83, 21);
		contentPane.add(cboName);
		JLabel label = new JLabel("직급");
		label.setBounds(12, 56, 57, 15);
		contentPane.add(label);
		
		cboJob = new JComboBox();
		cboJob.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED) {
					calc();
				}
			}
		});
		cboJob.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "사원","주임", "대리", "과장", "부장"}));
		cboJob.setBounds(81, 53, 116, 21);
		contentPane.add(cboJob);
		
		JLabel label_1 = new JLabel("세율");
		label_1.setBounds(12, 131, 57, 15);
		contentPane.add(label_1);
		
		cboTaxRate = new JComboBox();
		cboTaxRate.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED) {
					calc();
				}
			}
		});
		cboTaxRate.setModel(new DefaultComboBoxModel(new String[] {"면세(0%)", "3%", "5%"}));
		cboTaxRate.setBounds(81, 128, 83, 21);
		contentPane.add(cboTaxRate);
		
		JLabel label_2 = new JLabel("기본급");
		label_2.setBounds(12, 82, 57, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("보너스");
		label_3.setBounds(12, 106, 57, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("세액");
		label_4.setBounds(12, 156, 57, 15);
		contentPane.add(label_4);
		
		tfBasic = new JTextField();
		tfBasic.setBounds(81, 79, 116, 21);
		contentPane.add(tfBasic);
		tfBasic.setColumns(10);
		
		tfBonus = new JTextField();
		tfBonus.setColumns(10);
		tfBonus.setBounds(81, 103, 116, 21);
		contentPane.add(tfBonus);
		
		tfTax = new JTextField();
		tfTax.setColumns(10);
		tfTax.setBounds(81, 154, 116, 21);
		contentPane.add(tfTax);
		
		JButton btnEval = new JButton("계산");
		btnEval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calc();
			}
		});
		btnEval.setBounds(22, 187, 97, 23);
		contentPane.add(btnEval);
		
		JButton btnReset = new JButton("취소");
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cboJob.setSelectedIndex(1);
				tfBasic.setText("1000000");
				tfBonus.setText("0");
				cboTaxRate.setSelectedIndex(0);
				tfTax.setText("0");
				lblResult.setText("");
			}	
		
		});
		
		btnReset.setBounds(133, 185, 97, 23);
		contentPane.add(btnReset);
		lblResult = new JLabel("");
		lblResult.setBounds(27, 236, 203, 23);
		contentPane.add(lblResult);
		}
		void calc() {
			System.out.println("계산 method 호출...");
			
			String item = cboJob.getSelectedItem().toString();
			if(item.equals("선택하세요")) {
				JOptionPane.showMessageDialog(Salary.this, "직급을 선택하세요.");
				cboJob.requestFocus();
				return;
			}
			if(item.equals("사원")) {
				basic = 1000000;
			}else if(item.equals("대리")) {
				basic= 2000000;
			}else if(item.equals("과장")) {
				basic = 2500000;
			}else if(item.equals("부장")) {
				basic = 3000000;
			}else {
				basic = 1000000;
			}
			tfBasic.setText(basic+"");
			
			String strBonus = tfBonus.getText();
			if(strBonus.equals("")) {
				JOptionPane.showMessageDialog(Salary.this, "보너스를 입력하세요.");
			tfBonus.requestFocus();
			return;
			}else {
				bonus = Integer.parseInt(strBonus);
			}
			total = basic + bonus;
			int rate_idx = cboTaxRate.getSelectedIndex();
			switch(rate_idx) {
			case 0:
				tax = 0; break;
			case 1:
				tax = (int)(total*0.03); break;
			case 2:
				tax = (int)(total*0.05); break;
			}
			tfTax.setText(tax+"");
			money = total - tax;
			lblResult.setText("실수령액:"+money);
	
	}

}
