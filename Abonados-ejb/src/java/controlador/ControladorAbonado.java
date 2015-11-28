package controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.AbonadoFacadeLocal;

/**
 * Session Bean sin estado que controla los aspectos relacionados con los abonados
 * de la plataforma.
 * @author Jorge Cuadrado.
 * @author Lucas Hurtado.
 */
@Stateless
public class ControladorAbonado implements ControladorAbonadoRemote {
    @EJB
    private AbonadoFacadeLocal abonadoFacade;
    
    /**
     * Método de prueba.
     */
    @Override
    public void sayHey() {
        System.out.println("SAY HEY");
    }

    /**
     * Devuelve el nif de un abonado.
     * @param login nombre de usuario del abonado.
     * @return nif del abonado o null en caso de no existir.
     */
    @Override
    public String getNif(String login) {
        modelo.Abonado abonado = getAbonado(login);
        
        if(abonado != null) return abonado.getNif().getNif();
        return null;
    }
    
    /**
     * Comprueba si el password del abonado es correcto.
     * @param login nombre de usuario del abonado.
     * @param passwd contraseña del abonado.
     * @return true si es correcta y false en caso contrario.
     */
    @Override
    public boolean isPasswdOK(String login, String passwd) {
        modelo.Abonado abonado = getAbonado(login);
        return abonado != null && abonado.getPassword().equals(passwd);
    }
    
    /**
     * Devuelve las preferencias de un abonado.
     * @param login nombre de usuario del abonado.
     * @return lista de preferencias.
     */
    @Override
    public List<modelo.Preferencia> getPreferencias(String login) {
        modelo.Abonado abonado = getAbonado(login);
        Collection<modelo.Preferencia> prefCollection = abonado.getPreferenciaCollection();
        List<modelo.Preferencia> prefList = new ArrayList<>();
        
        for(modelo.Preferencia pref : prefCollection) prefList.add(pref);
        
        return prefList;
    }
    
    /**
     * Devuelve las preferencias de un abonado.
     * @param persona objeto que modela los datos personales del abonado.
     * @return lista de preferencias.
     */
    @Override
    public List<modelo.Preferencia> getPreferencias(modelo.Persona persona) {
        modelo.Abonado abonado = getAbonado(persona);
        Collection<modelo.Preferencia> prefCollection = abonado.getPreferenciaCollection();
        List<modelo.Preferencia> prefList = new ArrayList<>();
        
        for(modelo.Preferencia pref : prefCollection) prefList.add(pref);
        
        return prefList;
    }

    /**
     * Informa si el login esta asociado a un abonado.
     * @param login nombre de usuario del abonado.
     * @return true si existe y false en caso contrario.
     */
    @Override
    public boolean isAbonado(String login) {
        return getAbonado(login) != null;
    }

    /**
     * Devuelve un abonado.
     * @param login nombre de usuario del abonado.
     * @return objeto que modela al abonado o null en caso de no existir.
     */
    public modelo.Abonado getAbonado(String login) {
        List<modelo.Abonado> abonados = abonadoFacade.findAll();
        for(modelo.Abonado item : abonados) {
            if(item.getLogin().equals(login)) return item;
        }
        return null;
    }
    
    /**
     * Devuelve un abonado.
     * @param persona objeto que modela los datos personales del abonado.
     * @return objeto que modela al abonado o null en caso de no existir.
     */
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
