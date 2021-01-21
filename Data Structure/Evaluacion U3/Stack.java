import java.util.NoSuchElementException;
import java.util.Iterator;
public class Stack <Item> implements Iterable<Item>
{
    private int Size; //tamaño de la pila
    private Nodo Primero;  // tope de la pila 

    /**Clase anidada para crear los nodo de la lista ligada*/
    private class Nodo{
        private Item item;
        private Nodo Siguiente;
    }

    /***
     * Pila vacia
     */
    public Stack(){
        Primero = null;
        Size = 0;
    }

    /**
     * Retorna true si la pila esta vacia, falso en caso contrario
     */
    public boolean isEmpty(){
        return Primero == null;
    }

    /**
     * @return El numero de Items dentro de la pila
     */
    public int Size()
    {
        return Size;
    }

    /***
     * @param Agrega el item a la pila
     */
    public void push(Item item){
        Nodo oldfirst = Primero;
        Primero = new Nodo();
        Primero.item = item;
        Primero.Siguiente = oldfirst;
        Size ++;
    }

    /** Muestra el contenido de la lista*/
    public void MostrarPila(){
        if(isEmpty()) {StdOut.print("Stack vacia"); return;}
        int i = 1;
        for (Nodo x = Primero; x != null; x = x.Siguiente){
            StdOut.println("<"+i+"> "+x.item); 
            i++;
        }
    }

    /**
     * elimina y retorna el item mas recientemente agregado al stack
     *
     * @return the item mas recientemente agregado
     * @throws NoSuchElementException si el stack esta vacio
     */
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Pila desbordada"); 
        Item item = Primero.item; //Recupera el item a retornar
        Primero = Primero.Siguiente; // Elimina el primer nodo
        Size --;
        return item;
    }

    /**
     * Retorna (sin eliminar) el item mas recientemente agregado al stack
     *
     * @return el item mas recientemente agregado al stack
     * @throws NoSuchElementException si el stack esta vacio
     */
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Pila desbordada"); 
        return Primero.item;
    }

    /**
     * Retorna una representacion string del stack
     *
     * @return la secuencia de items en el stack en orden LIFO, separado por espacios
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /** un iterator, no se implementa remove() puesto que es opcional */
    private class ListIterator implements Iterator<Item> {
        private Nodo current = Primero;
        public boolean hasNext()  { return current != null;                     }

        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.Siguiente; 
            return item;
        }
    }

    /**
     * @return un iterator para el stack que itera a traves de los items en orden LIFO
     */
    public Iterator<Item> iterator()  { return new ListIterator();  }
}

