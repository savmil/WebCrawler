package crawler.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crawler.manager.CrawlerManager;

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

public class InterfacciaUtente extends JFrame implements UIUser {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacciaUtente frame = new InterfacciaUtente();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 115, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTest(textField_1.getText(), Integer.parseInt(textField.getText()));
			}
		});
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -1, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 131, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 272, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JFormattedTextField frmtdtxtfldInterfaccia = new JFormattedTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldInterfaccia, -1, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldInterfaccia, -50, SpringLayout.EAST, contentPane);
		frmtdtxtfldInterfaccia.setText("interfaccia");
		contentPane.add(frmtdtxtfldInterfaccia);
		
		JFormattedTextField frmtdtxtfldSito = new JFormattedTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldSito, 0, SpringLayout.NORTH, frmtdtxtfldInterfaccia);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldSito, 46, SpringLayout.WEST, contentPane);
		frmtdtxtfldSito.setText("sito");
		contentPane.add(frmtdtxtfldSito);
	}
	public void startTest(String rootURL, int nStep) {
		
		CrawlerManager crawler=CrawlerManager.getInstance();			
				System.out.println("qui");
				crawler.startTest(rootURL, nStep);
			

	}
}
