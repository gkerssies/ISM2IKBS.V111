package BackupRestore;
import javax.swing.JTable;


/**
 * Custom table class which can't be eddited
 * @author Janssen-laptop
 */
public class CustomTable extends JTable{
  
  public CustomTable(Object[][] data,String[] columnNames )
  {
    super(data,columnNames);
  }
  
  @Override
  public boolean isCellEditable(int row, int col) {  
            //Note that the data/cell address is constant,  
            //no matter where the cell appears onscreen.  
    return false;  
  }
}
