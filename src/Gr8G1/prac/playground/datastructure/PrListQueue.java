package Gr8G1.prac.playground.datastructure;

import java.util.ArrayList;

class PrListQueue<T> {
  private ArrayList<T> listQueue = new ArrayList<>();

  public void size() {
    System.out.println(listQueue.size());
  }

  public void show() {
    System.out.println(listQueue);
  }

  public void clear() {
    listQueue.clear();
  }

  public void offer(T t) {
    listQueue.add(t);
  }

  public T poll() {
    if (listQueue.isEmpty()) {
      return null;
    } else {
      T first = listQueue.get(0);
      listQueue.remove(first);
      return first;
    }
  }

  public T peek() {
    if (listQueue.isEmpty()) {
      return null;
    } else {
      return listQueue.get(0);
    }
  }
}
