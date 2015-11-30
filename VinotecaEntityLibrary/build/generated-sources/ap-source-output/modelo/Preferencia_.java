package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Abonado;
import modelo.Persona;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T19:46:14")
@StaticMetamodel(Preferencia.class)
public class Preferencia_ { 

    public static volatile SingularAttribute<Preferencia, String> denominacion;
    public static volatile SingularAttribute<Preferencia, Character> categoria;
    public static volatile SingularAttribute<Preferencia, Persona> nif;
    public static volatile SingularAttribute<Preferencia, Abonado> numeroabonado;
    public static volatile SingularAttribute<Preferencia, Integer> id;

}