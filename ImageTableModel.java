package test;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ImageTableModel extends AbstractTableModel{
	String[] columnName= {"선택","고유번호","이미지","상위분류","하위분류","상품명","가격"};
	Object[][] data;
	URL url;
	ImageIcon icon;
	
	public ImageTableModel() {
		url=this.getClass().getClassLoader().getResource("koala.jpg");
		icon=new ImageIcon(url);
		Image image=icon.getImage();
		Image thumb=image.getScaledInstance(50,35, Image.SCALE_SMOOTH);
		ImageIcon thumbIcon=new ImageIcon(thumb);
		
		data=new Object[][]{
			{false,"1", thumbIcon ,"상의","가디건","코알라 가디건","23000"}
		};
		
	}
	@Override
	public Class getColumnClass(int col) {
		if(col==0) {
			return Boolean.class;	
		}else {
			return getValueAt(0, col).getClass();
		}
		
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	public void setValueAt(Object obj, int row, int col) {
		if(col==0) {
			data[row][col]=(boolean)obj;
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public String getColumnName(int col) {
		return columnName[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
}
