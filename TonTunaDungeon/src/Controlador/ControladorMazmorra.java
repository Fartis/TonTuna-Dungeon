/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dado;
import Modelo.Habitacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar la mazmorra
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorMazmorra {

    private final ArrayList<Habitacion[][]> mazmorra = new ArrayList();;
    private int nivelPiso = 1;
    private static ControladorMazmorra singleton = null;

    /**
     * Metodo constructor de mazmorra
     */
    private ControladorMazmorra() {
    }
    

    /**
     * Metodo singleton de la mazmorra
     *
     * @return
     */
    public static ControladorMazmorra getSingleton() {
        if (singleton == null) {
            singleton = new ControladorMazmorra();
        }
        return singleton;
    }

    private Habitacion[][] rellenarPiso(int nivel) throws ParserConfigurationException, IOException, SAXException {
        File xmlPiso = new File("src/Recursos/xmlPisos/piso" + nivel + ".xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document docPiso = dBuilder.parse(xmlPiso);

        docPiso.getDocumentElement().normalize();

        NodeList nodoPiso = docPiso.getElementsByTagName("Piso");
        Node subNodoPiso = nodoPiso.item(Dado.lanza(5) - 1);
        int numero = 0;
        Habitacion[][] piso = new Habitacion[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Node habitacion = subNodoPiso.getChildNodes().item(numero);
                int tipo = Integer.parseInt(habitacion.getAttributes().getNamedItem("tipo").getNodeValue());
                piso[i][j] = new Habitacion(tipo, ControladorPrincipal.getSingleton().getNivelActual(), Dado.lanza(3));
                numero++;
            }
        }
        return piso;
    }

    /**
     * Metodo para generar piso de la mazmorra
     */
    public void generarPiso() {
        try {
            Habitacion[][] piso = rellenarPiso(nivelPiso);
            mazmorra.add(piso);
            nivelPiso++;
        } catch (ParserConfigurationException | IOException | SAXException ex) {
        }
    }
}
