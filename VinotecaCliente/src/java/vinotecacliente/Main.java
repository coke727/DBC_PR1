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
        controladorAbonado.sayHey();
        System.out.println(controladorAbonado.getNif("jorcuad"));
        List<Preferencia> cosos = controladorAbonado.getPreferencias("luchurt");
        for(Preferencia i : cosos) System.out.println(i);
        List<Vino> vinos = controladorVino.getVinos("a",'a');
        for(Vino i : vinos) System.out.println(i);
    }
    
}
