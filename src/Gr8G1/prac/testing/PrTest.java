package Gr8G1.prac.testing;

public class PrTest {
  /*
   * # 슬라이스(Slice) 테스트
   *  - 애플리케이션을 특정 계층으로 나누어 진행하는 테스트를 의미한다.
   *
   * # 단위(Unit) 테스트
   *  - 특정 기능(작은)을 하나의 단위로 보고 진행하는 테스트를 의미한다.
   *
   * # 단위(Unit) 테스트 원칙 F.I.R.S.T
   *  - Fast(빠르게)
   *    - 테스트 실행시 가능한 빠른 시간안에 테스트가 완료되야한다.
   *  - Independent(독립적으로)
   *    - 테스트들을 독릭접(개별적)이여야 실행할 수 있어야한다.
   *  - Repeatable(반복 가능하도록)
   *    - 테스트들은 반복 수행이 가능해야한다.
   *  - Self-validating(셀프 검증이 되도록)
   *    - 자가 검증이 가능해야한다.
   *  - Timely(시기 적절하게)
   *    - 테스트는 테스트 하려는 기능 구현을 하기 직전에 작성해야 한다.
   *      > 구현체 없이 테스트 케이스를 완벽하게 작성하는것은 쉽지 않다.
   *      > 하여 일정 부분 구현이 완료된다면 주기적으로 테스트 케이스를 병행해서 작성해야한다.
   */

  /*
   * # JUnit
   *  - Java 테스트 프레임워크
   *
   * Annotations
   *  - @Test
   *    - 테스트 케이스 정의
   *  - @DisplayName
   *    - 테스트 케이스명 정의
   *  - @Disabled
   *    - 테스트 중지
   *  - @BeforeEach
   *    @BeforeAll
   *    @AfterEach,
   *    @AfterAll
   *      - 테스트 케이스 전/후처리
   *      - Each: 각가의 테스트 케이스 시작전 초기화 작업 진행
   *      - All: 클레스 레벨에서 테스트 진행시 1회 초기화 작업을 진행
   *  - @EnabledOnOs({..}),
   *    @DisabledOnOs({..})
   *    - OS 분기 테스트
   *  - @Nested
   *    - 중첩 구문 테스트
   *  - @RepeatedTest
   *    - 테스트 케이스 반복
   *  - ..
   *
   * Assertions(단정)
   *  - 단정한 검증 테스트 시작
   *    > Methods: https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
   *
   * Assumption(가정)
   *  - 가정의 성립을 기준으로 테스트 시작
   *    > Methods: https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
   *
   */
}
