package Gr8G1.prac.spring.core;

public class PrIocDI {
  /*
   * # IoC, DI, 그리고 스프링 컨테이너
   *
   * # 제어의 역전 IoC(Inversion of Control)
   *  - 프로그램의 제어 흐름을 직접(개발자 스스로) 제어하는 것이 아니라 외부에서 관리하는 것
   *
   * # 의존관계 주입 DI(Dependency Injection)
   *  - 외부에서 생성된 객체를 주입 하는 방식을 일컫는다.
   *    > DI(의존관계 주입)를 통해 모듈 간의 결합도는 낮추고 유연성은 높이는 이점이 있다.
   *
   * # 컨테이너(Container)
   *  - 의존성이 없는 POJOs(Plain Old Java Objects)를 받아 설정 정보에 따라 객체 초기화, 설정 변경, 기존 bean과 재조립하는 역할 담당한다.
   *    > XML, Annotation 의해 표현될 수 있다.
   *  - IoC 컨테이너 또는 DI 컨테이너라 칭하고 최근 의존관계 주입에 초점을 맞추어 주로 DI 컨테이너라 한다.
   *    > 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.
   *
   * # Annotaions
   *  - @Configuration
   *    - DI 컨테이너를 직접 생성한다. (@ComponentScan의 대상이 된다.)
   *  - @Bean
   *    - DI 컨테이너의 bean을 연결한다.
   *      > 외부 라이브러리 사용시 또는 직접 bean 등록, 관리 할때 적용한다.
   *      > Singleton 패턴으로 관리된다.
   *  - @Autowired
   *    - type에 따른 연결
   *      > @Qualifier와 조합하여 bean name으로 연결할 수도 있다.
   *  - @Resource
   *    - bean name에 따른 연결
   *  - @Component
   *    - 정형화된 다른 컴포넌트의 상위 개체이다.
 *        ~ @Controller, @Service, @Repository
   *
   *
   */
}
