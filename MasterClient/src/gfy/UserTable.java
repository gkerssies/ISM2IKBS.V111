/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Gerjan
 */
public class UserTable {
  private JTable table;
  
  public UserTable() {
    addTable();
  }
  
  public void addTable() {
    String[] columnNames = {"Gebruiker", 
                                            "Type"};
    Object[][] data = {
      {"gcdkjgjc", "sgfdk"}
    };
    
    table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
  }
  
  public JTable getTable() {
    return table;
  }
}
