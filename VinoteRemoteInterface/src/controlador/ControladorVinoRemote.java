/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;
import modelo.Referencia;

/**
 *
 * @author coke
 */
@Remote
public interface ControladorVinoRemote {

    List<modelo.Vino> getVinos(String origen, String categoria);

    Referencia getReferencia(int vinoID);

    void addReferencia(Referencia referencia);
    
}
