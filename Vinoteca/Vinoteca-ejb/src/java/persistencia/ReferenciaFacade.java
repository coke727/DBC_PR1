/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Referencia;

/**
 *
 * @author coke
 */
@Stateless
public class ReferenciaFacade extends AbstractFacade<Referencia> implements ReferenciaFacadeLocal {
    @PersistenceContext(unitName = "Vinoteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferenciaFacade() {
        super(Referencia.class);
    }
    
}
