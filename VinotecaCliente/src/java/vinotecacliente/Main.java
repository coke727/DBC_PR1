/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinotecacliente;

import controlador.ControladorAbonadoRemote;
import controlador.ControladorVinoRemote;
import java.util.List;
import javax.ejb.EJB;
import modelo.Preferencia;
import modelo.Referencia;
import modelo.Vino;

/**
 *
 * @author coke
 */
public class Main {
    @EJB
    private static ControladorVinoRemote controladorVino;
    @EJB
    private static ControladorAbonadoRemote controladorAbonado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Obtener el nif de un abonado
        System.out.println("El NIF de jorcuad debe ser 71172553L: " + controladorAbonado.getNif("jorcuad"));
        
        //Comprobar password
        System.out.println("Comprobando isPasswdOK:");
        System.out.println("Debe ser true: " + controladorAbonado.isPasswdOK("jorcuad", "122224"));
        
        //Obtener preferencias
        System.out.println("PREFERENCIAS LUCHURT:");
        List<Preferencia> preferencias = controladorAbonado.getPreferencias("luchurt");
        for(Preferencia i : preferencias) System.out.println(i);
        System.out.println("PREFERENCIAS JORCUAD:");
        preferencias = controladorAbonado.getPreferencias("jorcuad");
        for(Preferencia i : preferencias) System.out.println(i);
        
        //Comprobar si es abonado
        System.out.println("Comprobando isAbonado:");
        System.out.println("Debe ser true: " + controladorAbonado.isAbonado("jorcuad"));
        System.out.println("Debe ser false: " + controladorAbonado.isAbonado("falso"));
        
        //Obtener lista de vinos
        System.out.println("Tenemos rioja y veneno:");
        List<Vino> vinos = controladorVino.getVinos("23", 'R');
        for(Vino i : vinos) System.out.println(i);
        
        //Obtenemos referencias de un vino
        System.out.println("Obtenemos referencias del vino 1:");
        Referencia referencia = controladorVino.getReferencia(1);
        System.out.println(referencia);
        
        //Añadimos una referencias
        System.out.println("Añadimos referencia:");
        Referencia nuevaRef = new Referencia('T', (short) 666, (float) 23, 'T', vinos.get(0));
        Referencia nuevaRefNew = new Referencia('T', (short) 666, (float) 23, 'T', new Vino(34,"duero", (short)1992, "es un rio", 23, 'R'));
        controladorVino.addReferencia(nuevaRef);
        controladorVino.addReferencia(nuevaRefNew);
    }
    
}
