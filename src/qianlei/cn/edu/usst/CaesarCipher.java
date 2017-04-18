package qianlei.cn.edu.usst;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CaesarCipher {

	private JFrame frmCaesarCipherBy;
	public static String plainText;
	public static char[] plainCh;
	public static String enText;
	public static char[] enCh;
	public static String deText;
	public static char[] deCh;
	public static int key;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaesarCipher window = new CaesarCipher();
					window.frmCaesarCipherBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaesarCipher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCaesarCipherBy = new JFrame();
		frmCaesarCipherBy.setTitle("Caesar Cipher by Ray Chien");
		frmCaesarCipherBy.setBounds(100, 100, 450, 300);
		frmCaesarCipherBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("输入明文");
		
        JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JLabel label = new JLabel("输入移位数");
		
		JTextPane textPane = new JTextPane();
		
		JLabel label_1 = new JLabel("密文");
		
		
		JLabel label_2 = new JLabel("解密");
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plainText =textArea.getText();
				plainCh=plainText.toCharArray();
				if(textPane.getText().trim().equals("")||textPane.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null,"Please input an key!","Info:",JOptionPane.QUESTION_MESSAGE);
				}
				String str = textPane.getText();
				Pattern pattern = Pattern.compile("[0-9]*");
				if(!pattern.matcher(str).matches()||str==""||str==null)
				{
					JOptionPane.showMessageDialog(null,"Please input an legle key!","Info:",JOptionPane.QUESTION_MESSAGE);
				}
				key=Integer.parseInt(str);
				for (int i = 0; i < plainCh.length; i++) {
					if(plainCh[i]>='a'&&plainCh[i]<='z')
					{
						plainCh[i]=(char) ((plainCh[i]+key-97)%26+97);
					}
					else if(plainCh[i]>='A'&&plainCh[i]<='Z')
					{
						plainCh[i]=(char) ((plainCh[i]+key-65)%26+65);
					}
				}
			    enText = String.valueOf(plainCh);
			    textArea_2.setText(enText);
			    enCh=enText.toCharArray();
			    for (int i = 0; i < enCh.length; i++) {
					if(enCh[i]>='a'&&enCh[i]<='z')
					{
						enCh[i]=(char) ((enCh[i]+(26-key%26)-97)%26+97);
					}
					else if(enCh[i]>='A'&&enCh[i]<='Z')
					{
						enCh[i]=(char) ((enCh[i]+(26-key%26)-65)%26+65);
					}
				}
			    deText = String.valueOf(enCh);
			    textArea_3.setText(deText);
			}
		});
				
		GroupLayout groupLayout = new GroupLayout(frmCaesarCipherBy.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(30)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(45)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(btnNewButton)
							.addGap(185))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(scrollPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
							.addGap(40)))
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(15)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
					.addContainerGap())
		);
		frmCaesarCipherBy.getContentPane().setLayout(groupLayout);
	}
}
