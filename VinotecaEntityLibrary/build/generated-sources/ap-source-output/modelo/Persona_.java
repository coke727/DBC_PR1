package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Abonado;
import modelo.Preferencia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T19:46:14")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidos;
    public static volatile CollectionAttribute<Persona, Abonado> abonadoCollection;
    public static volatile CollectionAttribute<Persona, Preferencia> preferenciaCollection;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> cuentabancaria;
    public static volatile SingularAttribute<Persona, String> nif;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> email;

}