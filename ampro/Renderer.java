package ampro;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class Renderer extends JLabel implements TableCellRenderer 
{
    boolean isBordered = true;

    public Renderer(boolean isBordered) 
	{
        this.isBordered = isBordered;
        setOpaque(false);
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) 
	{
        return new JButton();     
    }
}
