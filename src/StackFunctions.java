import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackFunctions {
    void stackBAsicFunctions() {
        Stack<String> stack = new Stack<>();
        stack.push("abc");
        stack.push("def");

        //Get the last element without removing from the stack
        System.out.println(stack.peek());

        System.out.println(stack.size());

        /*
        Stack can be iterated by any of the following three ways:
        1. Iterator() method
        2. forEach() method
        3. using listIterator() method
        4. For loop using range
         */

        System.out.println("Iterating Stack using Iterator() method");
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        System.out.println("Iterating Stack using for loop");
        for(String str:stack) {
            System.out.println(str);
        }


        System.out.println("Iterating Stack using forEach() method");
        stack.forEach(value ->{
            System.out.println(value);
        });
    }
}
