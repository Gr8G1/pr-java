package Gr8G1.prac.spring.mvc;

public class PrMVC {
  /*
   * # MVC
   *  - 사용자 인터페이스, 데이터 및 논리 제어를 구현하는데 널리 사용되는 소프트웨어 디자인 패턴
   *
   * # Model
   *  - 클라이언트에게 응답으로 돌려주는 작업의 처리 결과 데이터를 Model 이라고 한다.
   *
   * # View
   * - Model 데이터를 이용해서 클라이언트 애플리케이션의 화면에 보여지는 리소스(Resource)를 제공하는 역할을 한다.
   *
   * 처리
   *  - HTML 페이지의 출력
   *    > Spring MVC에서 지원하는 HTML 페이지 출력 기술에는 Thymeleaf, FreeMarker, JSP + JSTL, Tiles 등이 있다.
   *  - PDF, Excel 등의 문서 형태로 출력
   *  - XML, JSON 등 특정 형식의 포맷으로의 변환
   *
   * # Controller
   *  - 클라이언트 요청을 직접적으로 전달 받는 엔드포인트(Endpoint)로써 Model과 View의 중간에서 상호 작용을 해주는 역할을 한다.
   *
   * Spring MVC 개략적 흐름
   *  1. Client Request ->
   *  2. Controller 요청 데이터 수신 및 비즈니스 로직 처리(Model 데이터 생성) 및 전달
   *  3. View Model 데이터 수신 및 응답 데이터 생성 및 전달
   *  4. -> Client Response
   *
   * Spring MVC 동작 흐름
   *  Client
   *    1. Client Request
   *    14. Client Response
   *  dispatcherServlet
   *    2. Controller 검색
   *    4. Contorller 호출 위임
   *    9. view 검색 요청
   *    11. view 정보 수신
   *    12. view 응답 생성 요청
   *  handleMapping
   *    3. Controller 정보 반환
   *  handleAdapter
   *    5. Contorller 호출 위임 수신
   *    6. Controller 호출
   *    8. Model 데이터 수신
   *    9. Model 데이터와 View 이름 반환
   *  Controller
   *    7. Model 데이터 반환
   *  viewResolver
   *    10. view 정보 반환
   *  View
   *    13. view 응답 생성 및 반환
   *
   *
   * # DispatcherServlet의 역할
   *  - Spring MVC의 요청 처리 흐름을 가만히 살펴보면 DispatcherServlet이 굉장히 많은 일을 하는 것처럼 보인다.
   *    클라이언트로부터 요청을 전달 받으면 HandlerMapping, HandlerAdapter, ViewResolver, View 등 대부분의 Spring MVC 구성 요소들과 상호 작용을 하고 있는 것을 볼 수 있다.
   *    그런데 DispatcherServlet이 굉장히 바빠보이지만 실제로 요청에 대한 처리는 다른 구성 요소들에게 위임(Delegate)하고 있다.
   *    이처럼 DispatcherServlet이 애플리케이션의 가장 앞단에 배치되어 다른 구성요소들과 상호작용하면서 클라이언트의 요청을 처리하는 패턴을 *Front Controller Pattern*이라고 한다.
   *
   */

  /*
   * # MVC Annotations
   * @RequestMapping
   *  - 클래스 레벨 Annotation 으로 핸들러의 역할을 하며 URL을 맵핑한다. 특정 HTTP Request Method("GET", "POST" 등)에 대한 기본 매핑을 좁히는 추가 메서드 레벨 Annotation과 함께 사용된다.
   *  - URI 템플릿 패턴 적용 가능
   *    > 예: http://www.example.com/{valiable} : valiable == 변수
   *    > URI 템플릿 패턴에는 정규식도 포함될 수 있다.
   *      > 예: @RequestMapping("/spring-web/{symbolicName:[az-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[az]+}")
   *            public String accessURITepl(@PathVariable String version, @PathVariable String extension) { .. }
   *
   * @RequestHeader
   *  - Request Header에 포함된 정보 접근하여 인수로 인수(Parameter - 바인딩 된 정보)로 받을 수 있다.
   *    > public String accessURL(@RequestHeader Map<String, String> headers) { .. }
   *    > public String accessURL(@RequestHeader("user-agent") String userAgent) { .. }
   *
   *    > 응답값 Header 내용 변경
   *      HttpHeaders headers = new HttpHeaders();
   *      headers.set("Client-Geo-Location", "Korea, Seoul");
   *      return ResponseEntity<>(XXX, headers, HttpStatus.CREATED)
   *
   * @PathVariable
   *  - @RequestMapping URI 템플릿 패턴 형식으로 지정된 변수의 접근하여 인수(Parameter - 바인딩 된 정보)로 받을 수 있다.
   *    > @RequestMapping(value="/path/{var}", method = RequestMethod.GET)
   *      public String accessURL(@PathVariable String var) { .. }
   *
   * @RequestParam
   *  - 쿼리 파라미터(Query Parmeter 또는 Query string), 폼 데이터(form-data), x-www-form-urlencoded 형식의 데이터를 파라미터로 전달 받을 수 있다.
   *
   * @GetMapping, @PostMapping
   *  - URI 생략시 클래스 레벨의 URI 경로로 Request URI를 구성한다.
   *
   */

  /*
   * # HTTP Response Header
   *  > HTTP 헤더 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Headers
   *
   * 커스텀 헤더(Custom Header)
   *  - HTTP Request에 기본적으로 포함되어 있는 헤더 정보는 개발자가 컨트롤 해야 될 경우가 생각보다 많지 않다.
   *    하지만 특정 상황(클라이언트 요구조건)에 의해 조종 추가해야될 부가적인 정보를 전달하는 경우가 발생한다.
   *
   * 커스텀 헤더 네이밍(Naming)
   *  - 2012년 이 전에는 커스텀 헤더에 ‘X-’라는 Prefix를 추가하는 것이 관례였으나, 이 관례는 문제점이 발생할 가능성이 높아서 더 이상 사용하지 않다. (Deprecated)
   *    다만, 커스텀 헤더의 이름을 지을 때, 이 헤더를 사용하는 측에서 헤더의 목적을 쉽게 이용할 수 있도록 대시(-)를 기준으로 의미가 명확한 용어 사용을 권장한다.
   *    대시(-)를 기준으로 각 단어의 첫 글자를 대문자로 작성하는 것이 관례이나 Spring에서 Request 헤더 정보를 확인할 때, *대/소문자*를 구분하지는 않는다.
   *
   * Spring MVC HTTP Request 헤더(Header) 정보 조회 및 추가
   *  - @RequestHeader 개별 헤더 정보 또는 전체 헤더 정보 조회 및 추가 가능
   *  - HttpServletRequest | HttpEntity 객체로 헤더 정보 조회 및 추가가 가능하다.
   *
   */

  /*
   * # Rest Client란?
   *  - Rest API 서버에 HTTP 요청을 보낼 수 있는 클라이언트 툴 또는 라이브러리를 의미
   *  - Java에서 사용할 수 있는 HTTP Client 라이브러리로는 java.net.HttpURLConnection, Apache HttpComponents, OkHttp 3, Netty 등이 있다.
   *
   * RestTemplate
   *  - 원격지에 있는 다른 Backend 서버에 HTTP 요청을 전송할 수 있는 Rest Client API (Spring에서 제공되는 API)
   *  - 기본적으로 RestTemplate의 객체를 생성하기 위해서는 RestTemplate의 생성자 파라미터로 HTTP Client 라이브러리의 구현 객체를 전달해야한다.
   *    > HttpComponentsClientHttpRequestFactory 클래스를 통해 Apache HttpComponents를 전달하기 위해서 Apache HttpComponents를 사용
   *      : builde.gradle의 dependencies 항목 추가
   *      > ./builde.gradle
   *        dependencies {
   *          ..
   *          implementation 'org.apache.httpcomponents:httpclient'
   *        }
   *    > pr-spring 프로젝트 참고
   *
   *
   *
   */


}
