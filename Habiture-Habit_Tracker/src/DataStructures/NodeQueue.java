package DataStructures;

public class NodeQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    int size;

    public NodeQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Método para agregar un elemento al final de la cola
    public void enqueue(T data) {
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

    // Método para remover y devolver el elemento al frente de la cola
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size --;
        return data;
    }

    // Método para obtener el elemento al frente de la cola sin removerlo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return head.getData();
    }

 // Método para verificar si la lista contiene un elemento específico
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Método para eliminar todos los elementos de la lista
    public void clear() {
        head = null;
        tail = null;
    }
    
    public void printQueue() {
        printQueueRecursive(head);
    }

    private void printQueueRecursive(Node<T> current) {
        if (current == null) {
            System.out.println();
            return;
        }
        System.out.println(current.getData() + " ");
        printQueueRecursive(current.getNext());
    }
    
}
