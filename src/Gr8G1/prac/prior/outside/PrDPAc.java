package Gr8G1.prac.prior.outside;

import Gr8G1.prac.prior.PrAccessControl;

public class PrDPAc extends PrAccessControl {
  public static void main(String[] args) {
    PrAccessControl pac = new PrAccessControl();
    PrDPAc dpac = new PrDPAc();

    System.out.println("PrDPAc");
    System.out.println(pac.publicS);

    System.out.println("PrDPAc extends");
    System.out.println(dpac.protectedS); // 상속 결과에 따라 protected 접근
  }
}
