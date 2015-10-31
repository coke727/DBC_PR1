package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Referencia;
import persistencia.ReferenciaFacadeLocal;
import persistencia.VinoFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class ControladorVino implements ControladorVinoRemote {
    @EJB
    private ReferenciaFacadeLocal referenciaFacade;
    @EJB
    private VinoFacadeLocal vinoFacade;

    
    
    /**
     * Devuelve la lista de vinos que tengan la categoría y el origen dados
     * @param origen
     * @param categoria
     * @return lista de vinos
     */
    @Override
    public List<modelo.Vino> getVinos(String origen, String categoria) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        List<modelo.Vino> vinosBuscados = new ArrayList<>();
        for(modelo.Vino item: vinos){
            if(item.getIddenominacion() == Integer.parseInt(origen) && item.getCategoria().equals(categoria)){
                vinosBuscados.add(item);
            }
        }
        if(vinosBuscados.isEmpty()) vinosBuscados = null;
        return vinosBuscados;
    }

    /**
     * devuelve la referencia que tenga el id del vino dado
     * @param vinoID
     * @return una referencia
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
            if(item.getId() == (referencia.getVinoid().getId())) hayVino=true ;
        }
        if(hayVino == false) vinoFacade.create(referencia.getVinoid());
        referenciaFacade.create(referencia);
        //crear vino, puede hacerse en cascada
    }

    
}
