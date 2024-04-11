package queueAndStack;

import java.util.Stack;

public class StackToQueue_lc232 {

    class MyQueue {

        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        //（1）out空了才能倒 （2）in必须一次性倒完，不能剩数据
        public void inToOut() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }
}
