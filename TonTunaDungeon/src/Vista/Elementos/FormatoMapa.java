import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * 
 * @author Manuel David Villalba Escamilla
 */
public class FormatoMapa extends DefaultTableCellRenderer{

    private int columna_patron ;

    public FormatoMapa(int Colpatron)
    {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
        if( table.getValueAt(row,columna_patron).equals(false) )
        {
            setBackground(Color.red);
        }

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }

}