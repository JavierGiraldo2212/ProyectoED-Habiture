package DataStructures;

public class LinkedList<T extends Comparable<T>>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }


    // Método para agregar un nuevo nodo al principio de la lista
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size ++;
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size ++;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (head.getData().compareTo(data) > 0) { // El nuevo dato es menor que el primer dato en la lista
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) { // Si el nuevo nodo es el último, actualizamos la cola
                tail = newNode;
            }
        }
        size++;
    }


    // Método para eliminar el primer nodo de la lista
    public void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
            }
        }
        size --;
    }

    // Método para eliminar el último nodo de la lista
    public void removeLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node<T> current = head;
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                current.setNext(null);
                tail = current;
            }
        }
        size --;
    }


    // Método para eliminar el primer nodo que contiene un valor específico
    public void remove(T data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData().equals(data)) {
            removeFirst();
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    tail = current; // Actualiza la cola si se eliminó el último nodo
                }
                return;
            }
            current = current.getNext();
        }
        size --;
    }

    
    // Método para obtener el dato almacenado en el primer nodo de la lista
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return head.getData();
    }

    // Método para obtener el dato almacenado en el último nodo de la lista
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return tail.getData();
    }

    // Método para obtener el dato almacenado en una posición específica de la lista
    public T getAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
    	return size;
    }

    // Método para eliminar todos los elementos de la lista
    public void clear() {
        head = null;
        tail = null;
    }
    
    public void printRecursive() {
        printRecursive(head);
    }

    private void printRecursive(Node<T> current) {
        if (current == null) {
            System.out.println();
            return;
        }
        System.out.println(current.getData() + " ");
        printRecursive(current.getNext());
    }

    
}
