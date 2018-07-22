package crawler.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crawler.crawlerLogic.manager.CrawlerManager;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class InterfacciaUtente extends JFrame implements UIUser {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static InterfacciaUtente frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						frame = new InterfacciaUtente();
						frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfacciaUtente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 140, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -15, SpringLayout.EAST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("START");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 155, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -132, SpringLayout.EAST, contentPane);
		btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTest(textField_1.getText(), Integer.parseInt(textField.getText()));
				frame.dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 38, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -15, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea frmtdtxtfldInterfaccia = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldInterfaccia, 25, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 1, SpringLayout.NORTH, frmtdtxtfldInterfaccia);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, frmtdtxtfldInterfaccia);
		frmtdtxtfldInterfaccia.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		frmtdtxtfldInterfaccia.setBackground(UIManager.getColor("Button.background"));
		frmtdtxtfldInterfaccia.setText("Numero di passi:");
		frmtdtxtfldInterfaccia.setEditable(false);
		contentPane.add(frmtdtxtfldInterfaccia);
		
		JTextArea frmtdtxtfldSito = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldInterfaccia, 23, SpringLayout.SOUTH, frmtdtxtfldSito);
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldSito, -2, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldSito, -6, SpringLayout.WEST, textField_1);
		frmtdtxtfldSito.setBackground(UIManager.getColor("Button.background"));
		frmtdtxtfldSito.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		frmtdtxtfldSito.setText("URL:");
		frmtdtxtfldSito.setEditable(false);
		contentPane.add(frmtdtxtfldSito);
	}
	public void startTest(String rootURL, int nStep) {
		
		CrawlerManager crawler=CrawlerManager.getInstance();			
		crawler.startTest(rootURL, nStep);
			

	}
}
