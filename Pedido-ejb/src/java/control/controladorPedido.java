/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import controlador.controladorPedidoRemote;
import javax.ejb.Stateless;

/**
 *
 * @author coke
 */
@Stateless
public class controladorPedido implements controladorPedidoRemote {

    @Override
    public void sayHey() {
        System.out.println("HEEEEEEYYYY");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
