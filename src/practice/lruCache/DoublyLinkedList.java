package practice.lruCache;

public class DoublyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
        }
    }
        private Node<T> head, tail;
        private int size;

        public void addFirst(T data){
            Node<T> node = new Node<>(data);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public void addLast(T data) {
            Node<T> node = new Node<>(data);
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }

        public void remove(Node<T> node) {
            if (node == null) return;
            if (node.prev != null) node.prev.next = node.next;
            else head = node.next;
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
            size--;
        }

        public Node<T> removeLast() {
            if (tail == null) return null;
            Node<T> removed = tail;
            remove(tail);
            return removed;
        }

        public void moveTofront(Node<T> node) {
            remove(node);
            node.prev = null;
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
        }

        public int size() { return size; }

        public void printList() {
            Node<T> cur = head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        System.out.println();
        }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.printList();
        DoublyLinkedList.Node<Integer> node = dll.removeLast();
        System.out.println("removed: " + node.data);
        dll.printList();

    }
}
