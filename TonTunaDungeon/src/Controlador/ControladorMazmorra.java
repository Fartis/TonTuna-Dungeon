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
import java.io.File;

/**
 * Clase para gestionar la mazmorra
 *
 * @author Manuel David Villalba Escamilla
 */
public class ControladorMazmorra {

    private static ArrayList<Habitacion[][]> mazmorra;
    private static ControladorMazmorra singleton = null;
    private int xActual = 4, yActual = 4;

    /**
     * Metodo constructor de mazmorra
     */
    private ControladorMazmorra() {
        this.mazmorra = new ArrayList<>();
    }

    /**
     * método para reiniciar la mazmorra
     */
    public void reiniciarMazmorra() {
        this.mazmorra = new ArrayList<>();
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

    /**
     * método para generar un piso de la mazmorra desde un archivo xml
     *
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    private Habitacion[][] rellenarPiso() throws ParserConfigurationException, IOException, SAXException {
        File xmlPiso = new File("src/Recursos/xmlPisos/piso" + (ControladorPrincipal.getSingleton().getNivelActual() + 1) + ".xml");
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
                boolean[] caminos = new boolean[4];
                if(Integer.parseInt(habitacion.getAttributes().getNamedItem("arriba").getNodeValue())==1){
                    caminos[0]=true;
                }else{
                    caminos[0]=false;
                }
                if(Integer.parseInt(habitacion.getAttributes().getNamedItem("abajo").getNodeValue())==1){
                    caminos[1]=true;
                }else{
                    caminos[1]=false;
                }
                if(Integer.parseInt(habitacion.getAttributes().getNamedItem("derecha").getNodeValue())==1){
                    caminos[2]=true;
                }else{
                    caminos[2]=false;
                }
                if(Integer.parseInt(habitacion.getAttributes().getNamedItem("izquierda").getNodeValue())==1){
                    caminos[3]=true;
                }else{
                    caminos[3]=false;
                }
                piso[i][j] = new Habitacion(tipo, ControladorPrincipal.getSingleton().getNivelActual(), Dado.lanza(3), caminos);
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
            Habitacion[][] piso = rellenarPiso();
            mazmorra.add(piso);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
        }
    }
    

    /**
     * método para obtener la información del mapa
     *
     * @return
     */
    public int[] infoMapa() {
        int[] info = new int[100];
        Habitacion[][] temporal = mazmorra.get(ControladorPrincipal.getSingleton().getNivelActual());

        int numero = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                info[numero] = temporal[i][j].getTipo();
                numero++;
            }
        }
        return info;
    }

    /**
     * método para cambiar la posición del personaje dentro de la mazmorra 1
     * arriba, 2 abajo, 3 derecha, 4 izquierda
     *
     * @param direccion
     * @return
     */
    public int moverPersonaje(int direccion) {
        Habitacion[][] temporal = mazmorra.get(ControladorPrincipal.getSingleton().getNivelActual());
        if (temporal[xActual][yActual].direccionPermitida(direccion)){
            switch (direccion) {
                case 0:
                    this.yActual--;
                    break;
                case 1:
                    this.yActual++;
                    break;
                case 2:
                    this.xActual++;
                    break;
                case 3:
                    this.xActual--;
                    break;
            }
        }
        return (xActual * 10) + yActual;
    }

    /**
     * método para obtener la posición actual del personaje dentro de la
     * mazmorra
     *
     * @return
     */
    public int posicionActual() {
        return (xActual * 10) + yActual;
    }

    public int infoHabitacion() {
        Habitacion[][] temporal = mazmorra.get(ControladorPrincipal.getSingleton().getNivelActual());
        return temporal[xActual][yActual].getTipo();
    }
}
