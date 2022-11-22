package GUImodeling.careSTD.tool;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class STDTableCellChkBox extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

	JCheckBox jc;
	String name;
	String phone;
	public STDTableCellChkBox(JTable table) {
		jc = new JCheckBox();
		jc.addActionListener(e -> {
			name = table.getValueAt(table.getSelectedRow(), 1).toString();
		});
		jc.addActionListener(e -> {
			phone = table.getValueAt(table.getSelectedRow(), 4).toString();
		});		
	}
	
	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return jc;
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		return jc;
	}
}
