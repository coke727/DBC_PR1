/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.ejb.Remote;
import modelo.Pedido;

/**
 *
 * @author coke
 */
@Remote
public interface controladorPedidoRemote {

    void sayHey();

    void newPedido(Pedido pedido);

    ArrayList<Pedido> getPedidosPendientes();

    ArrayList<Pedido> getPedidosAbonado(String nif);

    void editPedido(int numeroPedido, String estado);
    
}
