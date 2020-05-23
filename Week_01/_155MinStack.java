import java.util.Deque;
import java.util.LinkedList;


class MinStack {

  Deque<Integer> data;
  Deque<Integer> min;
  /**
   * initialize your data structure here.
   */
  public MinStack() {
    data = new LinkedList<>();
    min = new LinkedList<>();
  }

  public void push(int x) {
    data.push(x);
    if (min.isEmpty() || x <= min.peek()) {
      min.push(x);
    }
  }

  public void pop() {
    if (data.pop().equals(min.peek())) {
      min.pop();
    }
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return min.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */