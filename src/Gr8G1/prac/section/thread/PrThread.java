package Gr8G1.prac.section.thread;

import java.util.*;
import java.util.function.IntUnaryOperator;

public class PrThread {
  /*
   * # Thread
   *
   * Process & Thread
   *  - 프로그램 실행시 OS에서 실행에 필요한 자원(메모리)를 할당받아 Process가 된다.
   *    > Process는 실행중인 프로그램을 말한다.
   *  - Process의 자원을 이용해 실제 작업을 수행하는 것이 *Thread*다.
   *  - 모든 Process는 최소 하나 이상의 Thread가 존재하고, Thread는 작업 수행을 위해 개별적인 자원(메모리) 공간(Call Stack)이 필요하다.
   *  - CPU 코어(core)가 한 번에 오직 하나의 작업만 수행할 수 있으므로, 동시에 처리되는 작업의 수는 코어의 개수와 일치한다.
   *
   * Thread 실행
   *  - start()를 호출시 Thread가 실행되지만 바로 실행되는것이 아닌 실행대기 상태로 머물다가 자신의 차례가 돌아오면 실행된다.
   *    > 실행 순서(차례)는 OS의 스케쥴러에 의해 결정된다.
   *  - 한번 실행 종료된 Thread는 재실행 할 수 없다.
   *
   * Thread 동기화
   *  - 개별 Thread의 작업을 다른 Thread의 간섭으로부터 보호하는것
   *
   * 임계영역(critical section)과 잠금(lock)
   *  - 공유 데이터를 사용하는 영역을 임계영역으로 지정하고, 공유 데이터(객체)의 lock을 획득한 단 하나의 Thread의 작업 수행을 보장한다.
   *    lock을 획득한 Thread가 임계영역 내의 모든 작업을 수행하고 lock을 반납하면 다른 Thread의 접근(작업 수행)을 가능하게 한다.
   *
   * Synchronized
   *  - 임계 영역 설정 제어자
   *    > 메소드 전체 또는 특정 역역을 임계 영역으로 설정
   *      > synchronized 메소드() {}
   *      > synchronized(객체의 참조변수) {}
   *
   * Thread 실행제어
   *  - sleep: 일정 시간동안 Thread를 멈춘다.
   *    > 일시정지 상태가 된 Thread는 지정된 시간이 지나거나, interrupt가 호출되면, InterruptedException이 발생하며 일시정지 상태에서 실행대기 상태가 된다.
   *    > InterruptedException이 발생하기 때문에 try-catch문으로 예외를 처리해줘야 한다.
   *  - interrupt & interrupted : Thread의 작업을 취소한다.
   *    - interrupt: interrupted 상태값을 true로 변경
   *    - interrupted: 현재 Thread의 interrupted 상태값을 반환 후, 상태값을 false로 변경
   *      > isInterrupted: interrupted 상태값 반환
   *  - suspend, resume, stop: 교착상태(Dead-lock)를 일으키는 요소로 현재 deprecated 된 메소드들이다.
   *    - suspend: Thread를 멈추게 한다.
   *    - resume: Thread를 싱행대기 상태로 변경한다.
   *    - stop: 호출 즉시 Thread를 종료한다.
   *  - yield: 다른 Thread에게 자신의 자원(메모리) 실행(사용)시간을 양도한다.
   *  - join: Thread 자신의 작업을 잠시 멈추고 다른 Thread의 작업 수행을 지정 시간만큼 기다린다.
   *    > 시간을 지정하지 않는다면 다른 Thread의 작업 수행이 끝날때까지 기다린다.
   *    > InterruptedException이 발생하기 때문에 try-catch문으로 예외를 처리해줘야 한다.
   *  - wait, notify, notifyAll: 임계영역과 잠금 제어
   *    - wait: 객체의 lock을 풀고 해당 객체의 Waiting-pool로 들어간다.
   *    - notify: Waiting-pool 대기중인 Thread중 하나를 깨운다.
   *    - notifyAll: Waiting-pool 대기중인 Thread를 모두 깨운다.
   *      > Waiting-pool은 객체마다 존재하므로 notifyAll을 호출해도 모든 Thread에게 통보되는것은 아니다.
   *
   * TODO: Thread 동시성 문제 정리
   *
   */

  public static void main(String[] args) {
    CoinExchange coinExchange = new CoinExchange(new ArrayList<>(Arrays.asList(1, 2, 3)));

    Thread cc = new CoinConsumer(coinExchange); // Thread 클래스 상속
    Thread cs = new Thread(new CoinSupplier(coinExchange)); // Runnable 인터페이스 구현

    cc.setName("ConinConsumer");
    cc.setPriority(1);
    cs.setName("CoinSupplier");
    cs.setPriority(9);

    cc.start();
    cs.start();
  }
}

class CoinExchange {
  private final ArrayList<Integer> coins;
  final int MAX_COIN_COUNT = 5;
  int supplyCount;

  public CoinExchange(ArrayList<Integer> coins) {
    this.coins = coins;
  }

  public ArrayList<Integer> getCoins() {
    return coins;
  }

  public static IntUnaryOperator genRandomCoin() {
    return (v) -> (int) (Math.random() * v) + 1;
  }

  public void addCoin(int coin) {
    synchronized (this) {
      if (coins.size() >= this.MAX_COIN_COUNT) {
        System.out.println("😪 " + Thread.currentThread().getName()+" is waiting.");

        try {
          wait(); // CoinSupplier Waiting-pool 이동
          Thread.sleep(1000);
        } catch (InterruptedException e) {}
      }

      if (this.supplyCount != this.MAX_COIN_COUNT) {
        System.out.printf("🪙 No.%d coin has been added %n", coin);

        coins.add(coin);
        this.supplyCount++;
        notify(); // CoinCunsumer 대기상태 전환
      } else {
        if (!coins.isEmpty()) {
          System.out.println("😪 " + Thread.currentThread().getName()+" is waiting for all the coins to be sold.");

          try {
            wait(); // CoinSupplier Waiting-pool 이동
            Thread.sleep(1000);
          } catch (InterruptedException e) {}
        } else {
          System.out.println("👋 All coins have been sold. Good-Bye~");
          System.exit(0);
        }
      }
    }
  }

  public boolean removeCoin(int coin) {
    synchronized (this) {
      while(coins.size() == 0) {
        System.out.println("😪 " + Thread.currentThread().getName()+" is waiting.");
        try {
          wait(); // CoinCunsumer Waiting-pool 이동
          Thread.sleep(500);
        } catch(InterruptedException e) {}
      }

      for (int i = 0; i < coins.size(); i++) {
        if (coins.get(i) == coin) {
          coins.remove(i);
          notify(); // CoinSupplier 대기상태 전환
          return true;
        }
      }

      return false;
    }
  }
}

// Thread 클래스 상속
class CoinConsumer extends Thread {
  private final CoinExchange coinExchange;

  public CoinConsumer(CoinExchange coinExchange) {
    this.coinExchange = coinExchange;
  }

  @Override
  public void run() {
    while(true) {
      try { Thread.sleep(500); } catch (InterruptedException e) {}
      int randomCoin = CoinExchange.genRandomCoin().applyAsInt(5);

      System.out.println("🪙 Coins: " + this.coinExchange.getCoins());
      if (this.buyCoin(randomCoin)) {
        System.out.printf("😍 Get No.%d Coin!!! %n", randomCoin);
      } else {
        System.out.printf("🤬 Failed to get No.%d Coin!!! %n", randomCoin);
      }
    }
  }

  public boolean buyCoin(int randomCoin) {
    return this.coinExchange.removeCoin(randomCoin);
  }
}

// Runnable 인터페이스 구현
class CoinSupplier implements Runnable {
  private CoinExchange coinExchange;

  public CoinSupplier(CoinExchange coinExchange) {
    this.coinExchange = coinExchange;
  }

  @Override
  public void run() {
    while(true) {
      try { Thread.sleep(1000); } catch (InterruptedException e) {}
      this.supplyCoin();
    }
  }

  public void supplyCoin() {
    this.coinExchange.addCoin(CoinExchange.genRandomCoin().applyAsInt(5));
  }
}
