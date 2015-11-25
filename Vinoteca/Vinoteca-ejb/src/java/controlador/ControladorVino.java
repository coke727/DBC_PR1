package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Referencia;
import persistencia.ReferenciaFacadeLocal;
import persistencia.VinoFacadeLocal;

/**
 * Session Bean sin estado que controla los aspectos relacionados con los vinos
 * de la plataforma.
 * @author Jorge Cuadrado.
 * @author Lucas Hurtado.
 */
@Stateless
public class ControladorVino implements ControladorVinoRemote {
    
    @EJB
    private ReferenciaFacadeLocal referenciaFacade;
    @EJB
    private VinoFacadeLocal vinoFacade;
    
    /**
     * Devuelve la lista de vinos que tengan la categoría y el origen dados
     * @param origen del vino.
     * @param categoria del vino.
     * @return lista de vinos
     */
    @Override
    public List<modelo.Vino> getVinos(String origen, char categoria) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        List<modelo.Vino> vinosBuscados = new ArrayList<>();
        for(modelo.Vino item: vinos){
            if(item.getIddenominacion() == Integer.parseInt(origen) && item.getCategoria() == categoria){
                vinosBuscados.add(item);
            }
        }
        if(vinosBuscados.isEmpty()) vinosBuscados = null;
        return vinosBuscados;
    }

    /**
     * Devuelve la referencia que tenga el id del vino dado
     * @param vinoID identificador del vino
     * @return referencia asociada al identificador del vino.
     */
    @Override
    public Referencia getReferencia(int vinoID) {
        List<Referencia> referencias = referenciaFacade.findAll();
        for(Referencia item: referencias){
            if(item.getVinoid().getId() == vinoID) return item;
        }
        return null;
    }
    
    /**
     * Añade a la base de datos una nueva referencia
     * Si se necesita crea la entrada de la tabla de vinos necesarea
     * @param referencia 
     */
    @Override
    public void addReferencia(Referencia referencia) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        boolean hayVino = false;
        for(modelo.Vino item: vinos){
            if(Objects.equals(item.getId(), referencia.getVinoid().getId())) 
            hayVino=true ;
        }
        if(hayVino == false) vinoFacade.create(referencia.getVinoid());
        referenciaFacade.create(referencia);
        //crear vino, puede hacerse en cascada
    }

    
}
