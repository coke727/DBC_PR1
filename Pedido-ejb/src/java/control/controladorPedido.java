/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import controlador.controladorPedidoRemote;
import java.util.ArrayList;
import javax.ejb.Stateless;
import modelo.Pedido;

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

    @Override
    public void newPedido(Pedido pedido) {
    }

    @Override
    public ArrayList<Pedido> getPedidosPendientes() {
        return null;
    }

    @Override
    public ArrayList<Pedido> getPedidosAbonado(String nif) {
        return null;
    }

    @Override
    public void editPedido(int numeroPedido, String estado) {
    }

    
}
