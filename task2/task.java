package task2;

import java.util.LinkedList;

public class task {

    public static void main(String[] args) {
        LinkedList <Integer> example = fullfil_list();
        System.out.printf("Input array: ");
        System.out.println(example.toString());

        System.out.printf("\nenqueue 433: ");
        example = enqueue(example, 433);
        System.out.println(example.toString());

        System.out.printf("\nfirst: ");
        System.out.println(first(example));
        System.out.printf("List after first: ");
        System.out.println(example.toString());

        System.out.printf("\ndequeue: ");
        System.out.println(dequeue(example));
        System.out.printf("List after dequeue: ");
        System.out.println(example.toString());
    }
    /*
    Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди
    dequeue() - возвращает первый элемент из очереди и удаляет его
    first() - возвращает первый элемент из очереди, не удаляя.
    */
    public static LinkedList <Integer> fullfil_list() {
        LinkedList <Integer> lst = new LinkedList<>();
        for (int i = 1; i < 10; ++i)
            lst.add(i);

        return lst;
    }

    public static LinkedList <Integer> enqueue(LinkedList <Integer> lst, int elem) {
        lst.add(elem);

        return lst;
    }

    public static int first(LinkedList <Integer> lst) {
        return lst.get(0);
    }
    
    public static int dequeue(LinkedList <Integer> lst) {
        

        return lst.remove(0);
    }
    
}