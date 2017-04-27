package Vista.Elementos;

import Controlador.ControladorMazmorra;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Manuel David Villalba Escamilla
 */
public class FormatoMapa extends JPanel {

    private JPanel[] arrayPanel = new JPanel[100];
    private JPanel punto = new JPanel();

    public FormatoMapa() {
        for (int i = 0; i < 100; i++) {
            arrayPanel[i] = new JPanel();
            this.add(arrayPanel[i]);
        }
        this.setLayout(null);
        this.setSize(340, 340);
        this.setBackground(new Color(0, 0, 0, 124));
        estilizarElementos();
    }

    public void pintarPosicion(int posicion) {
        arrayPanel[ControladorMazmorra.getSingleton().posicionActual()].remove(punto);
        arrayPanel[posicion].add(punto);
    }

    private void estilizarElementos() {
        arrayPanel[1 - 1].setBounds(0, 0, 34, 34);
        arrayPanel[2 - 1].setBounds(0, 34, 34, 34);
        arrayPanel[3 - 1].setBounds(0, 68, 34, 34);
        arrayPanel[4 - 1].setBounds(0, 102, 34, 34);
        arrayPanel[5 - 1].setBounds(0, 136, 34, 34);
        arrayPanel[6 - 1].setBounds(0, 170, 34, 34);
        arrayPanel[7 - 1].setBounds(0, 204, 34, 34);
        arrayPanel[8 - 1].setBounds(0, 238, 34, 34);
        arrayPanel[9 - 1].setBounds(0, 272, 34, 34);
        arrayPanel[10 - 1].setBounds(0, 306, 34, 34);
        arrayPanel[11 - 1].setBounds(34, 0, 34, 34);
        arrayPanel[12 - 1].setBounds(34, 34, 34, 34);
        arrayPanel[13 - 1].setBounds(34, 68, 34, 34);
        arrayPanel[14 - 1].setBounds(34, 102, 34, 34);
        arrayPanel[15 - 1].setBounds(34, 136, 34, 34);
        arrayPanel[16 - 1].setBounds(34, 170, 34, 34);
        arrayPanel[17 - 1].setBounds(34, 204, 34, 34);
        arrayPanel[18 - 1].setBounds(34, 238, 34, 34);
        arrayPanel[19 - 1].setBounds(34, 272, 34, 34);
        arrayPanel[20 - 1].setBounds(34, 306, 34, 34);
        arrayPanel[21 - 1].setBounds(68, 0, 34, 34);
        arrayPanel[22 - 1].setBounds(68, 34, 34, 34);
        arrayPanel[23 - 1].setBounds(68, 68, 34, 34);
        arrayPanel[24 - 1].setBounds(68, 102, 34, 34);
        arrayPanel[25 - 1].setBounds(68, 136, 34, 34);
        arrayPanel[26 - 1].setBounds(68, 170, 34, 34);
        arrayPanel[27 - 1].setBounds(68, 204, 34, 34);
        arrayPanel[28 - 1].setBounds(68, 238, 34, 34);
        arrayPanel[29 - 1].setBounds(68, 272, 34, 34);
        arrayPanel[30 - 1].setBounds(68, 306, 34, 34);
        arrayPanel[31 - 1].setBounds(102, 0, 34, 34);
        arrayPanel[32 - 1].setBounds(102, 34, 34, 34);
        arrayPanel[33 - 1].setBounds(102, 68, 34, 34);
        arrayPanel[34 - 1].setBounds(102, 102, 34, 34);
        arrayPanel[35 - 1].setBounds(102, 136, 34, 34);
        arrayPanel[36 - 1].setBounds(102, 170, 34, 34);
        arrayPanel[37 - 1].setBounds(102, 204, 34, 34);
        arrayPanel[38 - 1].setBounds(102, 238, 34, 34);
        arrayPanel[39 - 1].setBounds(102, 272, 34, 34);
        arrayPanel[40 - 1].setBounds(102, 306, 34, 34);
        arrayPanel[41 - 1].setBounds(136, 0, 34, 34);
        arrayPanel[42 - 1].setBounds(136, 34, 34, 34);
        arrayPanel[43 - 1].setBounds(136, 68, 34, 34);
        arrayPanel[44 - 1].setBounds(136, 102, 34, 34);
        arrayPanel[45 - 1].setBounds(136, 136, 34, 34);
        arrayPanel[46 - 1].setBounds(136, 170, 34, 34);
        arrayPanel[47 - 1].setBounds(136, 204, 34, 34);
        arrayPanel[48 - 1].setBounds(136, 238, 34, 34);
        arrayPanel[49 - 1].setBounds(136, 272, 34, 34);
        arrayPanel[50 - 1].setBounds(136, 306, 34, 34);
        arrayPanel[51 - 1].setBounds(170, 0, 34, 34);
        arrayPanel[52 - 1].setBounds(170, 34, 34, 34);
        arrayPanel[53 - 1].setBounds(170, 68, 34, 34);
        arrayPanel[54 - 1].setBounds(170, 102, 34, 34);
        arrayPanel[55 - 1].setBounds(170, 136, 34, 34);
        arrayPanel[56 - 1].setBounds(170, 170, 34, 34);
        arrayPanel[57 - 1].setBounds(170, 204, 34, 34);
        arrayPanel[58 - 1].setBounds(170, 238, 34, 34);
        arrayPanel[59 - 1].setBounds(170, 272, 34, 34);
        arrayPanel[60 - 1].setBounds(170, 306, 34, 34);
        arrayPanel[61 - 1].setBounds(204, 0, 34, 34);
        arrayPanel[62 - 1].setBounds(204, 34, 34, 34);
        arrayPanel[63 - 1].setBounds(204, 68, 34, 34);
        arrayPanel[64 - 1].setBounds(204, 102, 34, 34);
        arrayPanel[65 - 1].setBounds(204, 136, 34, 34);
        arrayPanel[66 - 1].setBounds(204, 170, 34, 34);
        arrayPanel[67 - 1].setBounds(204, 204, 34, 34);
        arrayPanel[68 - 1].setBounds(204, 238, 34, 34);
        arrayPanel[69 - 1].setBounds(204, 272, 34, 34);
        arrayPanel[70 - 1].setBounds(204, 306, 34, 34);
        arrayPanel[71 - 1].setBounds(238, 0, 34, 34);
        arrayPanel[72 - 1].setBounds(238, 34, 34, 34);
        arrayPanel[73 - 1].setBounds(238, 68, 34, 34);
        arrayPanel[74 - 1].setBounds(238, 102, 34, 34);
        arrayPanel[75 - 1].setBounds(238, 136, 34, 34);
        arrayPanel[76 - 1].setBounds(238, 170, 34, 34);
        arrayPanel[77 - 1].setBounds(238, 204, 34, 34);
        arrayPanel[78 - 1].setBounds(238, 238, 34, 34);
        arrayPanel[79 - 1].setBounds(238, 272, 34, 34);
        arrayPanel[80 - 1].setBounds(238, 306, 34, 34);
        arrayPanel[81 - 1].setBounds(272, 0, 34, 34);
        arrayPanel[82 - 1].setBounds(272, 34, 34, 34);
        arrayPanel[83 - 1].setBounds(272, 68, 34, 34);
        arrayPanel[84 - 1].setBounds(272, 102, 34, 34);
        arrayPanel[85 - 1].setBounds(272, 136, 34, 34);
        arrayPanel[86 - 1].setBounds(272, 170, 34, 34);
        arrayPanel[87 - 1].setBounds(272, 204, 34, 34);
        arrayPanel[88 - 1].setBounds(272, 238, 34, 34);
        arrayPanel[89 - 1].setBounds(272, 272, 34, 34);
        arrayPanel[90 - 1].setBounds(272, 306, 34, 34);
        arrayPanel[91 - 1].setBounds(306, 0, 34, 34);
        arrayPanel[92 - 1].setBounds(306, 34, 34, 34);
        arrayPanel[93 - 1].setBounds(306, 68, 34, 34);
        arrayPanel[94 - 1].setBounds(306, 102, 34, 34);
        arrayPanel[95 - 1].setBounds(306, 136, 34, 34);
        arrayPanel[96 - 1].setBounds(306, 170, 34, 34);
        arrayPanel[97 - 1].setBounds(306, 204, 34, 34);
        arrayPanel[98 - 1].setBounds(306, 238, 34, 34);
        arrayPanel[99 - 1].setBounds(306, 272, 34, 34);
        arrayPanel[100 - 1].setBounds(306, 306, 34, 34);
        punto.setBounds(7,7,10,10);
        punto.setBackground(Color.GREEN);
    }

    public void pintarMapa() {
        int[] tipo = ControladorMazmorra.getSingleton().infoMapa();
        for (int i = 0; i < 100; i++) {
            switch (tipo[i]) {
                //El tipo de contenido se utiliza con un entero:
                //0 = Vacia.
                //1 = Normal
                //2 = Tesoro
                //3 = Guardado
                //4 = Siguiente nivel
                case 0:
                    arrayPanel[i].setBackground(new Color(0,0,0,124));
                    break;
                case 1:
                    arrayPanel[i].setBackground(Color.WHITE);
                    break;
                case 2:
                    arrayPanel[i].setBackground(Color.YELLOW);
                    break;
                case 3:
                    arrayPanel[i].setBackground(Color.BLUE);
                    break;
                case 4:
                    arrayPanel[i].setBackground(Color.RED);
                    break;
            }
        }
        arrayPanel[ControladorMazmorra.getSingleton().posicionActual()].add(punto);
    }
}
