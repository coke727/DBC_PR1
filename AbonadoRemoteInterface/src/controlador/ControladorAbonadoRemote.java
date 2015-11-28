/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author coke
 */
@Remote
public interface ControladorAbonadoRemote {

    void sayHey();

    String getNif(String login);

    boolean isPasswdOK(String login, String passwd);

    List<modelo.Preferencia> getPreferencias(String login);
    
    List<modelo.Preferencia> getPreferencias(modelo.Persona persona);

    boolean isAbonado(String login);
    
}
