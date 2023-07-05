/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.examples.main;

import com.examples.contracts.AlumnoService;
import com.examples.contracts.Configuracion;
import com.examples.domains.services.AlumnoServiceImp;
import com.examples.entities.Alumno;
import com.examples.exception.CursoException;
import java.util.ServiceLoader;
import java.util.Arrays;

/**
 *
 * @author Javier
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceLoader<Configuracion> services = ServiceLoader.load(Configuracion.class);
        services.forEach(srv -> srv.configurate("Soy el modulo principal"));
        try {
            var clase = Class.forName("com.examples.uow.DataBase");
            Arrays.stream(clase.getDeclaredMethods()).forEach(m -> System.out.println(m.getName()));

        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        AlumnoService srv = new AlumnoServiceImp();

        var lst = srv.get();
        try {
            srv.add(new Alumno(11, "Desde", "El modulo", null));
            lst.forEach(System.out::println);
        } catch (CursoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fin");
    }

}
