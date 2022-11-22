package GUImodeling.consult.tool;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ConsultTableCellChkBox extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

	JCheckBox jc;
	private String consultDay;
	private String consultTime;
	private String professorName;
	
	public ConsultTableCellChkBox(JTable table) {
		jc = new JCheckBox();
		jc.addActionListener(e -> {
			consultDay = table.getValueAt(table.getSelectedRow(), 1).toString();
		});
		jc.addActionListener(e -> {
			consultTime = table.getValueAt(table.getSelectedRow(), 2).toString();
		});		
		jc.addActionListener(e -> {
			professorName = table.getValueAt(table.getSelectedRow(), 3).toString();
		});		
	}
	
	public String getConsultDay() {
		return consultDay;
	}
	public String getConsultTime() {
		return consultTime;
	}
	public String getProfessorName() {
		return professorName;
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
