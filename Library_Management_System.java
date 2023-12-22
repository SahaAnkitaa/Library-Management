package Java_Proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Library_Management_System implements ActionListener{

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	
	JButton addbttn;
	JButton viewbttn;
	JButton editbttn;
	JButton deletebttn;
	JButton clearbttn;
	JButton exitbttn;
	
	private ArrayList<String[]> books = new ArrayList<String[]>();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library_Management_System window = new Library_Management_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Library_Management_System() {
		initialize();
	}

	
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("Book ID");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label1.setBounds(10, 27, 115, 14);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Book Title");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(10, 52, 77, 20);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Author");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(10, 80, 65, 20);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Publisher");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(10, 111, 85, 20);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Publication Year");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(10, 142, 115, 20);
		frame.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("No. of copies");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label6.setBounds(10, 173, 115, 20);
		frame.getContentPane().add(label6);
		
		addbttn = new JButton("Add");
		addbttn.setBounds(6, 226, 264, 33);
		frame.getContentPane().add(addbttn);
		
		viewbttn = new JButton("View");
		viewbttn.setBounds(269, 226, 264, 33);
		frame.getContentPane().add(viewbttn);
		
		editbttn = new JButton("Edit");
		editbttn.setBounds(6, 258, 264, 33);
		frame.getContentPane().add(editbttn);
		
		deletebttn = new JButton("Delete");
		deletebttn.setBounds(269, 260, 264, 31);
		frame.getContentPane().add(deletebttn);
		
		clearbttn = new JButton("Clear");
		clearbttn.setBounds(6, 292, 264, 29);
		frame.getContentPane().add(clearbttn);
		
		textField1 = new JTextField();
		textField1.setBounds(207, 26, 315, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(207, 54, 315, 20);
		frame.getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(207, 82, 315, 20);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(207, 113, 315, 20);
		frame.getContentPane().add(textField4);
		
		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(207, 144, 315, 20);
		frame.getContentPane().add(textField5);
		
		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(207, 175, 315, 20);
		frame.getContentPane().add(textField6);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 533, 332);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		exitbttn = new JButton("Exit");
		exitbttn.setBounds(269, 292, 264, 29);
		panel.add(exitbttn);
		
		addbttn.addActionListener(this);
        viewbttn.addActionListener(this);
        editbttn.addActionListener(this);
        deletebttn.addActionListener(this);
        clearbttn.addActionListener(this);
        exitbttn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== addbttn) {
			String[] book= new String[6];
			book[0]= textField1.getText();
			book[1]= textField2.getText();
			book[2]= textField3.getText();
			book[3]= textField4.getText();
			book[4]= textField5.getText();
			book[5]= textField6.getText();
			
			books.add(book);
            JOptionPane.showMessageDialog(frame, "Book added successfully");
            clearFields();
		}
		
		else if(e.getSource()== viewbttn) {
			String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "Number of Copies"};
            Object[][] data = new Object[books.size()][6];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i)[0];
                data[i][1] = books.get(i)[1];
                data[i][2] = books.get(i)[2];
                data[i][3] = books.get(i)[3];
                data[i][4] = books.get(i)[4];
				data[i][5] = books.get(i)[5];
				
				JTable table = new JTable(data, columns);
				JScrollPane scrollPane = new JScrollPane(table);
				JFrame frame = new JFrame("View Books");
				frame.add(scrollPane);
				frame.setSize(800, 400);
				frame.setVisible(true);
			}
		}
		
		else if(e.getSource()== editbttn) {
			String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i)[0].equals(bookID)) {
					String[] book = new String[6];
					book[0] = bookID;
					book[1] = textField2.getText();
					book[2] = textField3.getText();
					book[3] = textField4.getText();
					book[4] = textField5.getText();
					book[5] = textField6.getText();
					books.set(i, book);
					JOptionPane.showMessageDialog(frame, "Book edited successfully");
					clearFields();
					return;
				}
			}
			JOptionPane.showMessageDialog(frame, "Book not found");
		}
				
		else if(e.getSource()== deletebttn) {
			String bookID = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i)[0].equals(bookID)) {
					books.remove(i);
					JOptionPane.showMessageDialog(frame, "Book deleted successfully");
					clearFields();
					return;
				}
			}
			JOptionPane.showMessageDialog(frame, "Book not found");
		}
				
		else if(e.getSource()== clearbttn) {
			clearFields();
		}
				
		else if(e.getSource()== viewbttn) {
			
		}
				
		else if(e.getSource()== exitbttn) {
			System.exit(0);
		}
	}
	
	private void clearFields() {
	    textField1.setText("");
	    textField2.setText("");
	    textField3.setText("");
	    textField4.setText("");
	    textField5.setText("");
	    textField6.setText("");
	}
	
}
