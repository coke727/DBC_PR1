/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.AbonadoFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class ControladorAbonado implements ControladorAbonadoRemote {
    @EJB
    private AbonadoFacadeLocal abonadoFacade;

    @Override
    public void sayHey() {
        System.out.println("SAY HEY");
    }

    @Override
    public String getNif(String login) {
        modelo.Abonado abonado = getAbonado(login);
        
        if(abonado != null) return abonado.getNif().getNif();
        return null;
    }

    @Override
    public boolean isPasswdOK(String login, String passwd) {
        modelo.Abonado abonado = getAbonado(login);
        return abonado != null && abonado.getPassword().equals(passwd);
    }

    @Override
    public List<modelo.Preferencia> getPreferencias(String login) {
        modelo.Abonado abonado = getAbonado(login);
        Collection<modelo.Preferencia> prefCollection = abonado.getPreferenciaCollection();
        List<modelo.Preferencia> prefList = new ArrayList<>();
        
        for(modelo.Preferencia pref : prefCollection) prefList.add(pref);
        
        return prefList;
    }
    
    @Override
    public List<modelo.Preferencia> getPreferencias(modelo.Persona persona) {
        modelo.Abonado abonado = getAbonado(persona);
        Collection<modelo.Preferencia> prefCollection = abonado.getPreferenciaCollection();
        List<modelo.Preferencia> prefList = new ArrayList<>();
        
        for(modelo.Preferencia pref : prefCollection) prefList.add(pref);
        
        return prefList;
    }

    @Override
    public boolean isAbonado(String login) {
        return getAbonado(login) != null;
    }

    public modelo.Abonado getAbonado(String login) {
        List<modelo.Abonado> abonados = abonadoFacade.findAll();
        for(modelo.Abonado item : abonados) {
            if(item.getLogin().equals(login)) return item;
        }
        return null;
    }
    
    public modelo.Abonado getAbonado(modelo.Persona persona) {
        List<modelo.Abonado> abonados = abonadoFacade.findAll();
        for(modelo.Abonado item : abonados) {
            if(item.getNif().equals(persona)) {
                return item;
            }
        }
        return null;
    }
    
    
}
