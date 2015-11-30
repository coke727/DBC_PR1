package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Pedido;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T19:46:14")
@StaticMetamodel(Estadopedido.class)
public class Estadopedido_ { 

    public static volatile SingularAttribute<Estadopedido, String> clave;
    public static volatile CollectionAttribute<Estadopedido, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Estadopedido, String> nombre;

}