package DataStructures;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
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
    }

    // Método para agregar un nuevo nodo en una posición específica de la lista
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
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
    }

    // Método para eliminar el nodo en una posición específica de la lista
    public void removeAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size() - 1) {
            removeLast();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
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
        if (index < 0 || index >= size()) {
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

    // Método para obtener el número de elementos en la lista
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Método para eliminar todos los elementos de la lista
    public void clear() {
        head = null;
        tail = null;
    }
    
}
