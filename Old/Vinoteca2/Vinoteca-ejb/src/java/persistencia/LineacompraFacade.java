/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Lineacompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author coke
 */
@Stateless
public class LineacompraFacade extends AbstractFacade<Lineacompra> implements LineacompraFacadeLocal {
    @PersistenceContext(unitName = "Vinoteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineacompraFacade() {
        super(Lineacompra.class);
    }
    
}
