package evaluacion1;

import evaluacion1.DTO.ClubesDeportivos;
import evaluacion1.DTO.Suscripciones;
import evaluacion1.DTO.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

    public static void main(String[] args) {

        Date isbirthday = new Date();

        int correlativoS = 1000;
        //int correlativoC = 10;
        int correlativoU = 1000;
        try {
            String fechanacimiento = "1997/12/21";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            isbirthday = sdf.parse(fechanacimiento);
        } catch (Exception e) {
            isbirthday = new Date();
        };

        System.out.println("Creando Usuario");

        Usuario usuario1 = new Usuario();
        usuario1.setID(++correlativoU);
        usuario1.setNombreCompleto("Rodrigo Lopez");
        usuario1.setRun(19857932, '7');
        //usuario1.setDV("7");
        usuario1.setFechaNacimiento(isbirthday);
        usuario1.setTelefono("5698983968");
        usuario1.setEmail("ro.lopezb@duocuc.cl");
        usuario1.setNombreUsuario("Rolopezb1");
        usuario1.setContraseña("L19857932-7");  
        System.out.println(usuario1.validarUsuario(usuario1.getNombreUsuario(), usuario1.getContraseña()));

        System.out.println("Usuario creado: " + usuario1.getNombreUsuario());

        System.out.println("Creando Usuario");

        Usuario usuario2 = new Usuario();
        usuario2.setID(++correlativoU);
        usuario2.setNombreCompleto("Rodrigo Bravo");
        usuario2.setRun(19857932, '7');
        //usuario2.setDV("7");
        usuario2.setFechaNacimiento(isbirthday);
        usuario2.setTelefono("5698983968");
        usuario2.setEmail("ro.bravol@duocuc.cl");
        usuario2.setNombreUsuario("Robravol1");
        usuario2.setContraseña("L19857932-7");
        System.out.println(usuario2.validarUsuario(usuario2.getNombreUsuario(), usuario2.getContraseña()));

        System.out.println("Usuario creado: " + usuario2.getNombreUsuario());

        System.out.println("Creando Usuario");

        Usuario usuario3 = new Usuario();
        usuario3.setID(++correlativoU);
        usuario3.setNombreCompleto("Andres Lopez");
        usuario3.setRun(19857932, '7');
        // usuario3.setDV("7");
        usuario3.setFechaNacimiento(isbirthday);
        usuario3.setTelefono("5698983968");
        usuario3.setEmail("an.lopezb@duocuc.cl");
        usuario3.setNombreUsuario("Anlopezb1");
        usuario3.setContraseña("L19857932-7");
        System.out.println(usuario3.validarUsuario(usuario3.getNombreUsuario(), usuario3.getContraseña()));
        System.out.println(usuario3.resetContraseña(usuario3.getNombreUsuario()));

        System.out.println("Usuario creado: " + usuario3.getNombreUsuario());

        System.out.println("Ingresando Club");

        ClubesDeportivos Club1 = new ClubesDeportivos();
        Club1.setCodigo("ARH11");
        Club1.setNombreClub("Arsenal de Coquimbo");
        Club1.setNombreFundador("Pepe Ormeno");
        //Club1.setAnoFundacion();
        Club1.setPaisOrigen("Chile");
        Club1.setLema("Cañones a los puertos");
        Club1.setValorSuscripcion(10050);
        Club1.setColores(new String[]{"Amarillo", "Rojo"});

        System.out.println("Club Creado: " + Club1.getNombreClub());

        System.out.println("Ingresando Club");

        ClubesDeportivos Club2 = new ClubesDeportivos();
        Club2.setCodigo("MCH12");
        Club2.setNombreClub("Manquehue City");
        Club2.setNombreFundador("Felipe Ormeno");
        //Club2.setAnoFundacion();
        Club2.setPaisOrigen("Chile");
        Club2.setLema("Vivir y Fuerza");
        Club2.setValorSuscripcion(15100);
        Club2.setColores(new String[]{"Celeste", "Blanco"});

        System.out.println("Club Creado: " + Club2.getNombreClub());

        System.out.println("Ingresando Club");

        ClubesDeportivos Club3 = new ClubesDeportivos();
        Club3.setCodigo("LCH13");
        Club3.setNombreClub("Los Condores Unidos");
        Club3.setNombreFundador("Juanito Ormeno");
        //Club3.setAnoFundacion();
        Club3.setPaisOrigen("Chile");
        Club3.setLema("Desde lo alto al sol");
        Club3.setValorSuscripcion(13200);
        Club3.setColores(new String[]{"Amarillo", "Naranjo"});
        Club3.concatColor();

        System.out.println("Club Creado: " + Club3.getNombreClub());

        System.out.println("\n");

        System.out.println("Creando Solicitud");
        Suscripciones Suscripcion1 = new Suscripciones();
        Suscripcion1.setNumero(correlativoS = correlativoS + 10);
        Suscripcion1.setFechaInicio(new Date());
        Suscripcion1.setUsuario(usuario1);
        Suscripcion1.AgregarClubes(Club1);
        Suscripcion1.AgregarClubes(Club2);
        System.out.println(Suscripcion1.toString());
        System.out.println("Suscripciones Creadas");

        System.out.println("\n");

        System.out.println("Creando Solicitud");
        Suscripciones Suscripcion2 = new Suscripciones();
        Suscripcion2.setNumero(correlativoS = correlativoS + 10);
        Suscripcion2.setFechaInicio(new Date());
        Suscripcion2.setUsuario(usuario2);
        Suscripcion2.AgregarClubes(Club3);
        System.out.println(Suscripcion2.toString());
        System.out.println("Suscripciones Creadas");

        System.out.println("\n");

        System.out.println("Creando Solicitud");
        Suscripciones Suscripcion3 = new Suscripciones();
        Suscripcion3.setNumero(correlativoS = correlativoS + 10);
        Suscripcion3.setFechaInicio(new Date());
        Suscripcion3.setUsuario(usuario3);
        Suscripcion3.AgregarClubes(Club3);
        Suscripcion3.AgregarClubes(Club2);
        System.out.println(Suscripcion3.toString());
        System.out.println("Suscripciones Creadas");

    }

}
