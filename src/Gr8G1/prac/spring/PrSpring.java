package Gr8G1.prac.spring;

public class PrSpring {
  /*
   *
   * # 스프링 도큐먼트
   *  ~ https://docs.spring.io/spring-framework/docs/current/javadoc-api/index.html
   *
   * # 스프링 계층 구조
   *
   * # Presentation(상위) 계층
   *  > 웹 클라이언트의 요청 및 응답을 처리
   *  - HTTP 요청 처리 및 HTML 렌더링에 대해 알고 있는 웹 계층
   *  - MVC (Model / View / Controller) 도 이 계층에 속한다.
   *
   * # Domain(Business or Service) 계층
   *  > 비지니스 로직 처리와 비지니스와 관련된 도메인 모델의 적합성 검증
   *  - IO 데이터를 기반으로 Presentation 계층에서 인계받은 데이터의 유효성 검사 및 일련의 연산을 포함하는 Business 논리 계층
   *  - 애플리케이션이 수행해야하는 도메인과 관련된 작업들을 담당한다.
   *
   * # Data Access(Persistence) 계층
   *  > 데이터베이스 또는 원격 서비스에서 영구 데이터를 관리하는 방법을 분류하는 데이터 접근 계층
   *  - Database / Message Queue / 외부 API와의 통신 등 처리한다.
   *
   * 기능 기반 패키지 구조(package-by-feature) *권장*
   *  - 패키지 하위에 하나의 기능을 완성하기 위한 계층별(API 계층, 서비스 계층, 데이터 액세스 계층)클래스들을 모아둔 구조
   *
   * 계층 기반 패키지 구조(package-by-layer)
   *  - 패키지를 하나의 계층(Layer)으로 보고 클래스들을 계층별로 묶어서 관리하는 구조
   *
   */

  /*
   * # POJO(Plan Old Java Object)
   *  - 오래된 방식의 간단한 자바 오브젝트라는 말로서 Java EE 등의 중량 프레임워크들을 사용하게 되면서
   *    해당 프레임워크에 종속된 "무거운" 객체를 만들게 된 것에 반발해서 사용되게 된 용어이다.
   *  - POJO라는 용어는 이후에 주로 특정 자바 모델이나 기능, 프레임워크 등을 따르지 않은 자바 오브젝트를 지칭하는 말로 사용되었다.
   *    스프링(Spring) 프레임워크는 POJO 방식의 프레임워크이다.
   *
   * 규칙
   *  1. POJO 는 자바 언어 사양 외에 어떠한 제한에도 묶이지 않아야한다. (순수 자바 오브젝트)
   *  2. POJO 는 특정 환경에 종속되지 않아야한다. (의존성 배제)
   *  > 진정한 POJO란 객체지향적인 원리에 충실하면서, 환경과 기술에 종속되지 않고
   *    필요에 따라 재활용될 수 있는 방식으로 설계된 오브젝트를 말한다.
   *
   * 특징
   *  1. 특정 규약에 종속되지 않아 로우레벨 코드와 비즈니스 코드가 분리되어 우아한 코드 작성이 가능하고 그만큼 디버깅이 용이해진다.
   *  2. 특정 제약에 얽매이지 않아 *객체지향 설계*를 할 수 있다.
   *  3. 특정 환경에 종속되지 않아 테스트가 수월하다.
   *
   * # IoC(Inversion Of Control, 제어의 역전)
   *  - 프로그래머가 작성한 프로그램이 재사용 라이브러리의 흐름 제어를 받게 되는 소프트웨어 디자인 패턴
   *    > 외부(환경) 자원 import -> 내부 export & Call 에서 반전되어
   *      내부 Program export -> 외부(환경) 자원 import & Call 되는 형태
   *
   * # DI(Dependency Injection, 의존성 주입)
   *  - 외부에서 두 객체 간의 관계를 결정해주는 디자인 패턴
   *  - 핵심
   *     - 의존관계인 클래스들을 Interface 구현을 통해 클래스 레벨에서 의존관계가 고정되지 않도록 하고 런타임 시에 관계를 동적으로 주입하여 유연성을 확보하고 결합도를 낮추는것
   *  - 요약
   *    1. 객체 간 관계라는 관심사의 분리
   *    2. 객체 간의 결합도 하향
   *    3. 객체의 유연성 상향
   *    4. 테스트 케이스 작성에 용이
   *
   *  > 의존관계 증명: 대상 B가 변하여, 그것이 A에 영향을 미칠때 의존관계라 한다.
   *
   * # AOP(Aspect Oriented Programming, 관점 지향 프로그래밍)
   *  - 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하는 프로그래밍 기법
   *    객체지향프로그래밍 서로 나란히 하는, 상호 보완관계에 있는 기술이다.
   *    > 비지니스 로직(핵심적인 관점)
   *        - 핵심 관심 사항(Core concern)을 토대로 모듈로 작성하는것
   *    > 공통 로직(부가적인 관점)
   *        - 횡단 관심 사항(Cross-cutting concern)을 묶어 관심사에 맞는 하나의 모듈로 작성하는것
   *          > 횡단 관심 사항: 분산(코드 중복)되거나 얽히는(시스템 간의 상당한 의존성 존재) 코드의 제거 등을 일컫는다.
   *          > AOP가 필요한 횡단 관심 사항으로는 대표적으로 로깅, 보안, 트랜젝션 처리와 같은 기능들이 있다.
   *
   * # PSA(Portable Service Abstraction)
   *  - 하나의 추상화로 여러 서비스를 묶어둔 것을 Spring에서 PSA 칭한다.
   *  > 서비스 추상화(Service Abstraction)
   *    - 추상화 계층을 사용하여 어떤 기술을 내부에 숨기고 개발자에게 편의성을 제공해주는 것
   *
   * # 자바 서블릿(Servlet)
   *  - 자바 서블릿은 자바를 사용하여 웹페이지를 *동적*으로 생성하는 서버측 프로그램 혹은 그 사양을 말한다.
   *    자바 서블릿은 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종으로 서블릿은 JSP(Java Server Page)와 비슷한 점이 있지만,
   *    JSP가 HTML 문서 안에 Java 코드를 포함하고 있는 반면, 서블릿은 자바 코드 안에 HTML을 포함하고 있다는 차이점이 있다.
   *    > 서블릿은 클라이언트의 요청을 처리하도록 특정 규약에 맞추어서 Java 코드로 작성하는 클래스
   *
   * # 자바 서버 페이지(JSP, JavaServer Pages)
   *    HTML 문서 안에 자바 코드를 삽입하여 웹 서버에서 *동적*으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 서버 사이드 스크립트 언어이다.
   *
   * # 웹 컨테이너(web container, 또는 서블릿 컨테이너)
   *  - 웹 서버의 컴포넌트 중 하나로 자바 서블릿과 상호작용한다.
   *    웹 컨테이너는 서블릿의 생명주기를 관리하고, URL과 특정 서블릿을 맵핑하며 URL 요청이 올바른 접근 권한을 갖도록 보장한다.
   *
   * # 아파치 톰캣(Apache Tomcat)
   *  - 아파치 소프트웨어 재단에서 개발한 *서블릿 컨테이너*(또는 웹 컨테이너)만 있는 웹 애플리케이션 서버이다.
   *    톰캣은 웹 서버와 연동하여 실행할 수 있는 자바 환경을 제공하여 JSP와 자바 서블릿이 실행할 수 있는 환경을 제공하고 있다.
   *
   * # Persistence(영속, 지속) Framework
   *  1. SQL Mapper
   *    - 객체와 SQL을 매핑한다. (단순 필드 매핑이 목적)
   *    - 개발자가 SQL 을 작성해서 직접 DB를 조작
   *      > Ex: iBatis, MyBatis
   *  2. ORM (Object-Relational Mappering)
   *    - 아래 내용 참조
   *
   * # ORM(Object Relational Mapping, 객체-관계 매핑)
   *  - 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것을 말한다.
   *    ORM을 통해 객체 간의 관계를 바탕으로 SQL을 자동으로 생성하여 불일치를 해결하기 위한 목적으로 사용한다.
   *
   * # OXM (Object/XML Mapping)
   *  - Object와 XML간의 변환을 위해서XML Marshalling 기술을 추상화한 기능으로
   *    Spring Web Service 프로젝트에 포함되어 있던 모듈이 분리되어 Spring 3에서 Core 영역에 포함되었다.
   *
   * # JMS(Java Message Service)
   *  - Java 애플리케이션간의 통신을 메시지 기반으로 수행하기 위한 Java 표준 API로 비동기 메시징 처리 또한 지원한다.
   *
   */

  /*
   *
   * # @SpringBootApplication 내부 동작
   * 1. @EnableAutoConfiguration
   *    - Spring Boot의 자동 구성 메카니즘을 활성화
   * 2. @ComponentScan
   *    - 애플리케이션 내의 패키지에서 @Component 애너테이션이 붙은 클래스들에 대한 스캐닝 활성화
   * 3. @SpringBootConfiguration
   *  - Spring Context에 Bean을 추가적으로 등록하거나 Configuration 클래스를 추가적으로 임포트 하는 기능을 활성화
   *  - Spring Boot의 @*Test 애너테이션을 사용해서 테스트를 진행할 경우, 자동으로 @SpringBootConfiguration을 검색
   *
   */
}
