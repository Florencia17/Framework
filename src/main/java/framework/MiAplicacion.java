package framework;


import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MiAplicacion {

    List<Accion> listaClases= new ArrayList();

    public void init(){
        Set<Class<? extends Accion>> clases = new Reflections("").getSubTypesOf(Accion.class);

        clases.forEach(clase-> {
            try {
                listaClases.add(clase.getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        //hacer menu
       // String opcionElegida ; //
        System.out.println("Seleccione una opcion");
        for(int x= 0; x < listaClases.size(); x++){
            System.out.println(x + " " + listaClases.get(x).nombreItemMenu());
        }
        listaClases.get(scanner.nextInt()).ejecutar();
    }
}
