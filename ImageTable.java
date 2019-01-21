package test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class ImageTable extends JFrame{
	ImageTableModel model;
	JTable table;
	JScrollPane scroll;
	
	public ImageTable() {
		table = new JTable(model=new ImageTableModel());
		scroll  =new JScrollPane(table);
		
		add(scroll);
		
		table.setRowHeight(50);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				System.out.println(row);
				int col=table.getSelectedColumn();
				Object obj=table.getValueAt(row, col);
				if(col ==0) {
					System.out.println((boolean)obj);
				}else {
					System.out.println(obj);
				}
			}
		});
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImageTable();

	}

}
