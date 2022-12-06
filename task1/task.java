package task1;

import java.util.LinkedList;

public class task {

    public static void main(String[] args) {
        LinkedList <Integer> lst = new LinkedList<>();
        for (int i = 0; i < 10; ++i)
            lst.add(i);
        
        System.out.printf("Input array: ");
        System.out.println(lst.toString());


        System.out.printf("\n\nOutput array: ");
        System.out.println(reverse(lst).toString());
    }
    
    public static LinkedList<Integer> reverse(LinkedList <Integer> list){
        for (int i = 1; i < list.size(); ++i)
            list.addFirst(list.remove(i));
        return list;
    }
    
}