import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

/** 
 * La rockola solo debe contener una pila de ritmos y una cola de melodias
 * 
 * @author (your name)  
 * @version (a version number or a date)
 */
public class Jukebox
{ 
    private Stack <String> Ritmo;

    private Stack <String> RitmoAux ;
    private Queue <Melodia> CancionesAux ;

    public Jukebox (String cade){
        Ritmo = ritmos( cade);
    } 

    public Stack<String> getPilaAux(){return RitmoAux;}

    public Queue<Melodia> getColaAux(){return CancionesAux;}

    public void restablece(){
        RitmoAux = Ritmo;
    }

    /**Nos devuelve una copia de la cola de canciones*/
    public Queue <Melodia> backCancion(){ 
        Queue <Melodia> copia = new Queue (); 

        for(Melodia e: CancionesAux){
            copia.enqueue(e);
        }
        return copia;
    }

    /**
     * @return Una cola de melodias desde un fichero
     */
    public Queue <Melodia> RecuperaMelodia(String ruta){
        try{ 
            Queue <Melodia> can = new <String> Queue();

            File f = new File(ruta); 
            if(f.exists()){
                FileReader  lectorArchivo=new FileReader(f);
                BufferedReader buf = new BufferedReader(lectorArchivo);
                String str; 

                while((str= buf.readLine()) != null){
                    String [] melodia = str.split("&");
                    Melodia song = new Melodia(melodia[0],melodia[1],
                            melodia[2],melodia[3]);
                    can.enqueue(song);
                }
                buf.close();

            } else System.err.print("File doesn't exist");
            return can;

        }catch(IOException e){
            System.err.print(e.getMessage());
        }
        return null;
    }

    /**
     * @return Una pila de ritmos, recuperandolos desde un archivo txt java class<archivo.txt
     */
    public Stack <String> ritmos(String cadena){
        Stack <String> Ritmo = new <String> Stack();
        String str ;
        while((str = StdIn.readLine()) != null){
            Ritmo.push(str);
        }
        return Ritmo;
    }

    public void muestraRi(){Ritmo.MostrarPila();}

    /**Pequeño menu para cargar las melodias a la cola*/
    public void menu(int d){

        try{
            switch (d){
                case 1: CancionesAux = RecuperaMelodia("txt/reggae.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 2: CancionesAux = RecuperaMelodia("txt/bachata.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 3: CancionesAux = RecuperaMelodia("txt/rap.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 4: CancionesAux = RecuperaMelodia("txt/rock.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 5: CancionesAux = RecuperaMelodia("txt/intrumental.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 6: CancionesAux = RecuperaMelodia("txt/pop.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 7: CancionesAux = RecuperaMelodia("txt/metal.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 8: CancionesAux = RecuperaMelodia("txt/corridos.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 9: CancionesAux = RecuperaMelodia("txt/blues.txt");
                System.out.print( CancionesAux.toString());
                break;
                case 10: CancionesAux = RecuperaMelodia("txt/vagas.txt");
                System.out.print( CancionesAux.toString());
                break;
                default: System.out.print( "Ritmo invalido");
                break;
            } 
        }catch(InputMismatchException | NumberFormatException e){
            System.out.println("Debes insertar uno valido");

        }
    }
}
