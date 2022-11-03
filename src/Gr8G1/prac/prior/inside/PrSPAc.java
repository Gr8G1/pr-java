package Gr8G1.prac.prior.inside;

import Gr8G1.prac.prior.PrAccessControl;

public class PrSPAc {
  public static void main(String[] args) {
    PrAccessControl pac = new PrAccessControl();

    System.out.println("PrSPAc");
    System.out.println(pac.publicS);
    System.out.println();

    System.out.println("PrDPAc extends");
    // System.out.println(pac.defaultS); : -> Cannot be accessed from outside packag
    // 패키지 상위에 존재하더라도 default값에 접근 불가하다. (동등한 레벨에 존재해야함).
  }
}
