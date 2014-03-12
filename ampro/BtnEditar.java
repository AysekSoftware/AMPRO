package ampro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

@SuppressWarnings("serial")
public class BtnEditar extends AbstractCellEditor implements TableCellEditor, ActionListener 
{
    Boolean currentValue;
    JButton button;
    @SuppressWarnings("unused")
	private JTable jTable1;

    public BtnEditar(JTable jTable1) 
	{
        button = new JButton();
        button.addActionListener(ElegirEditar.accEditar);
        this.jTable1 = jTable1;
    }

    public void actionPerformed(ActionEvent e) 
	{
    }

    public Object getCellEditorValue() 
	{
        return currentValue;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	{
        return button;
    }
}
