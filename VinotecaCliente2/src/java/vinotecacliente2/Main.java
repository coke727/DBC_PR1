/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinotecacliente2;

import controlador.ControladorAbonadoRemote;
import dominio.Bodega;
import dominio.Vino;
import javax.ejb.EJB;

/**
 *
 * @author coke
 */
public class Main {
    
    @EJB
    private static ControladorAbonadoRemote controladorAbonado;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("DNI: "+controladorAbonado.getNif("jorcuad"));
        System.out.println("EXISTE: "+controladorAbonado.isAbonado("luchurt"));
        System.out.println("PASSOK: "+controladorAbonado.isPasswdOK("luchurt", "1234"));
        
        
        
    }
    
}
