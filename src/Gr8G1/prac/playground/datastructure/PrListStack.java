package Gr8G1.prac.playground.datastructure;

import java.util.ArrayList;

class PrListStack<T> {
  private final ArrayList<T> listStack = new ArrayList<>();

  public void show() {
    System.out.println(listStack);
  }

  public void size() {
    System.out.println(listStack.size());
  }

  public void clear() {
    listStack.clear();
  }

  public void push(T t) {
    listStack.add(t);
  }

  public T pop() {
    if (listStack.isEmpty()) {
      return null;
    } else {
      T last = listStack.get(listStack.size() - 1);
      listStack.remove(last);
      return last;
    }
  }

  public T peek() {
    if (listStack.isEmpty()) {
      return null;
    } else {
      return listStack.get(listStack.size() - 1);
    }
  }
}
