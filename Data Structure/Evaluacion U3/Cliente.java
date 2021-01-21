import javax.swing.JOptionPane;

/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    private String nombre;

    public Cliente(String n ) {
        nombre = n;
    }

    /**Dependiendo el ritmo seleccionado se cargara las melodias correspondientes*/
    public void SeleccionaRitmo(Jukebox s){
        int i = Integer.parseInt(JOptionPane.showInputDialog("Elija el ritmo"));
        if(i > 10){System.out.println("Ritmo no existe");
            return;
        }
        for(int x = 1; x<i; x++){
            s.getPilaAux().pop();
        }
        System.out.printf("%55s \n",s.getPilaAux().peek());
        System.out.print("\n");
        s.menu(i);
    }

    public Melodia SeleccionaMusica(Jukebox x,String melodia){
        Queue <Melodia> Canciones = x.backCancion();

        for(int i = 1; i<=20; i++){
            Melodia aux = Canciones.dequeue();
            if(aux.getNombre().equals(melodia)){
                return aux;
            }
        }
        System.out.print("\n No hay concidencias");
        return null;
    }

    public void reproducir(Jukebox x,String ... melodia){
        Queue <Melodia> canciones = new <Melodia> Queue();
        for(int i = 0; i< 3; i++){
            canciones.enqueue(SeleccionaMusica(x, melodia[i]));
        }

        if(! canciones.isEmpty()){
            System.out.print("\nReproduciendo \n");
            System.out.println(canciones.toString());
        }else System.out.print("\n No hay concidencias");
    }
}
