import javax.swing.JOptionPane;

public class Test{
    public static void main(String[] args) {
        StdOut.printf("\n%65s","========================================\n");
        StdOut.printf("%48s", "My Rockola");
        StdOut.printf("\n%65s","========================================\n");
        String cadena = StdIn.readLine();
        Jukebox rockola = new Jukebox(cadena);
        rockola.muestraRi();
        Cliente p1 = new Cliente("Musulini");

        rockola.restablece();

        p1.SeleccionaRitmo(rockola); 
        String str =  JOptionPane.showInputDialog("Elija la cancion 1").toUpperCase();
        String str2 = JOptionPane.showInputDialog("Elija la cancion 2").toUpperCase();
        String str3 = JOptionPane.showInputDialog("Elija la cancion 3").toUpperCase();

        p1.reproducir(rockola, str,str2,str3);    
    }
}