package DataStructures;

public class Array<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Array() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacidad inválida");
        }
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Método para obtener el tamaño actual del arreglo
    public int size() {
        return size;
    }

    // Método para verificar si el arreglo está vacío
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener el elemento en una posición específica del arreglo
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return (T) array[index];
    }

    // Método para establecer un elemento en una posición específica del arreglo
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        array[index] = element;
    }

    // Método para agregar un elemento al final del arreglo
    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    // Método para redimensionar el arreglo si se queda sin capacidad
    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

}
