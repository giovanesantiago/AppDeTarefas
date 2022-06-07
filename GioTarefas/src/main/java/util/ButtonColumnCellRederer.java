
package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;


public class ButtonColumnCellRederer extends DeadlineColumnCellRederer {
    
    private String buttonType;

    public ButtonColumnCellRederer(String buttonType) {
        this.buttonType = buttonType;
    }
    
    

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, col);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(Color.WHITE);
        
        label.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/" + buttonType + ".png")));

        
        return label;
    }
    
}
