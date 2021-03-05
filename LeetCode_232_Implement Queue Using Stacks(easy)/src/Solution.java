import java.util.LinkedList;

class MyQueue {
    LinkedList<Integer> listIn, listOut;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        listIn = new LinkedList<>();
        listOut = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        listIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //如果为空，从in栈中转移所有元素，否则出栈头元素就行
        if (listOut.isEmpty()) {
            while (!listIn.isEmpty()) {
                listOut.push(listIn.pop());
            }
        }
        return listOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //如果为空，从in栈中转移所有元素，否则出栈头元素就行
        if (listOut.isEmpty()) {
            while (!listIn.isEmpty()) {
                listOut.push(listIn.pop());
            }
        }
        return listOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return listIn.isEmpty() && listOut.isEmpty();
    }
}
