package Gr8G1.prac.cs;

public class PrRESTAPI {
  /*
   * # REST API
   *
   * REST(Representational State Transfer) API란?
   *  - REST API는 서로 다른 시스템에서 인터넷을 통해 정보(자원)를 안전하게 교환하기 위해 사용하는 인터페이스이다.
   *    > REST란?: API 작동 방식에 대한 조건을 부과하는 소프트웨어 아키텍처
   *    > 로이 필딩(Roy Thomas Fielding: HTTP 사양의 주요 작성자 중 한 명이며 REST(Representational State Transfer) 아키텍처 스타일 의 창시자)에 의해 제시되었다.
   *      논문에 서술된 균일한 인터페이스는 REST의 필수 요소로 모든 단계를 충족해야 REST API라고 부를 수 있다.
   *      REST Blog: https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm
   *      REST Design Guide: https://blog.restcase.com/5-basic-rest-api-design-guidelines/
   *
   * RMM(Richardson Maturity Model): REST 성숙도 모델
   *  - 레오나르드 리차드슨(Leonard Richardson)에 의해 정의되었고 총 4단계(0~3단계)로 구성되어있다.
   *  - 3단계까지 지키기 어렵기 때문에 2단계까지 지켜진다면 좋은 API라 볼 수 있고 이를 HTTP API라고 부른다.
   *      - HTTP API : 2단계까지 준수
   *      - REST API : 모든 단계 준수
   *
   * 0단계(The Swamp of POX(Plain of XML)): HTTP 사용
   *  - 단일 URI를 가지며 HTTP 프로토콜 사용한다.
   *    > 이는 REST API 작성의 기본단계로 해당 API는 REST API라 부를 수 없다.
   * 1단계(Resources): URI Resource
   *  - 요청을 특정 서비스 End-point로 보내는 것이 아닌, 개별 리소스로 통신 가능한 고유 End-point를 제공해야한다.
   *    > 예: 뉴스 리소스를 예를 들어 /news 로 모든 요청을 전달하는 것이 아닌, /news/(topic, 1~100) 과 같은 분류(계층) 또는 식별자를 포함하는 개별 리소스를 만들어 topic, 1~100번 리소스를 이해할 수 있도록 URI를 설계한다.
   *    > End-point 작성시 주의사항
   *      > 리소스에 집중한 명사 단어 선택 / 동사, HTTP 메서드, 특정 행위에 대한 단어 선택은 지양한다.
   * 2단계(HTTP Verbs): URI Resources + HTTP Method(CRUD에 적합하게 작성)
   *  - GET /news/topic/(topic, 1~100)/comments?from=20220101&to=20220201 처럼 리소스와 HTTP Method로 요청대상과 목적을 파악할 수 있다.
   *  - Status Code로 Client-Server 간 커뮤니케이션 진행
   *    > 아래 상태코드 참조
   * 3단계(Hypermedia Controls): URI Resource + HTTP Method + HATEOAS
   *  - 호출 가능한 API 정보를 자원의 상태에 반영하여 표현하는것
   *    > 예: GET 요청으로 반환된 리소스 표현에 그 리소스에 대한 액션의 링크도 함께 태워 보내는 것.
   *    > HATEOAS 제약 조건은 REST의 "균일한 인터페이스"기능의 필수 부분이다.
   *
   * ~ > HATEOAS(Hypermedia As The Engine Of Application State)
   *      - 하이퍼미디어를 애플리케이션의 상태를 관리하기 위한 하나의 메커니즘으로 사용
   *
   * REST 아키텍처 스타일과 원칙들
   *  - 균일한 인터페이스(4가지 아키텍처 제약 조건 = REST 성숙도 참조)
   *    1. 균일한 리소스 식별자를 사용
   *    2. 리소스 수정/삭제 정보 수신
   *      - 서버는 리소스를 자세히 설명하는 메타데이터를 전송하여 이 조건을 충족한다.
   *    3. 추가 처리하는 방법에 대한 정보를 수신
   *      - 서버는 클라이언트가 리소스를 적절히 사용하는 방법에 대한 메타데이터가 포함된 명확한 메시지를 전송한다.
   *    4. 작업 완료 정보 수신
   *      - 서버는 클라이언트가 더 많은 리소스를 동적으로 검색할 수 있도록 표현에 하이퍼링크를 넣어 전송한다.
   *  - 무상태
   *    - 서버가 이전의 모든 요청과 독립적으로 모든 클라이언트 요청을 완료하는 통신 방법을 나타낸다.
   *      클라이언트는 임의의 순서로 리소스를 요청할 수 있으며 모든 요청은 무상태이거나 다른 요청과 분리된다.
   *      이 REST API 설계 제약 조건은 서버가 매번 요청을 완전히 이해해서 이행할 수 있음을 의미한다.
   *  - 계층화 시스템
   *    - 클라이언트 <=> 서버 사이의 다른 승인된 중개자에게 연결할 수 있으며 여전히 서버로부터도 응답을 받고 서버는 요청을 다른 서버로 전달할 수도 있다.
   *      클라이언트 요청을 이행하기 위해 함께 작동하는 보안, 애플리케이션 및 비즈니스 로직과 같은 여러 계층으로 여러 서버에서 실행되도록 RESTful 웹 서비스를 설계할 수 있다.
   *      이러한 계층은 클라이언트에 보이지 않는 상태로 유지된다.
   *  - 캐시 가능성
   *    - RESTful 웹 서비스는 서버 응답 시간을 개선하기 위해 클라이언트 또는 중개자에 일부 응답을 저장하는 프로세스인 캐싱을 지원한다.
   *  - 온디맨드 코드
   *    - REST 아키텍처 스타일에서 서버는 소프트웨어 프로그래밍 코드를 클라이언트에 전송하여 클라이언트 기능을 일시적으로 확장하거나 사용자 지정할 수 있다.
   *
   * REST API 사용시 이점
   *  - 확장성
   *    1. 클라이언트-서버 상호 작용: 최적화 및 효율적으로 크기 조정
   *    2. 무상태: 서버가 과거 클라이언트 요청 정보를 유지할 필요가 없기 때문에 서버 로드를 제거
   *    3. 캐싱: 일부 클라이언트-서버 상호 작용을 부분적으로 또는 완전히 제거
   *  - 유연성
   *    - RESTful 웹 서비스는 완전한 클라이언트-서버 분리를 지원
   *  - 독립성
   *    - REST API는 사용되는 기술과 독립적이다.
   *      API 설계에 영향을 주지 않고 다양한 프로그래밍 언어로 클라이언트 및 서버 애플리케이션을 모두 작성할 수 있다.
   *      또한 통신에 영향을 주지 않고 양쪽의 기본 기술을 변경할 수 있다.
   *
   * REST 요청에 포함되는것
   *  - 고유 리소스 식별자
   *    - 일반적으로 URL(Uniform Resource Locator)을 사용하여 리소스 식별을 수행한다.
   *  - 메서드
   *    1. GET
   *      - 서버의 지정된 URL에 있는 리소스에 액세스
   *        요청을 캐싱하고 파라미터를 넣어 전송하여 전송 전에 데이터를 필터링하도록 서버에 지시 가능
   *    2. POST
   *      - 서버에 데이터를 전송
   *    3. PUT
   *      - 서버의 기존 리소스를 업데이트
   *        > POST와 달리, 동일한 PUT 요청을 여러 번 전송해도 결과는 동일
   *    4. DELETE
   *      - 리소스를 제거
   *  - HTTP 헤더
   *    - 요청 헤더는 클라이언트와 서버 간에 교환되는 메타데이터
   *  - 데이터
   *    - POST, PUT 및 기타 HTTP 메서드가 성공적으로 작동하기 위한 데이터가 포함될 수 있다.
   *  - 파라미터
   *    - 수행해야 할 작업에 대한 자세한 정보를 서버에 제공하는 파라미터가 포함될 수 있다.
   *      1. URL 세부정보를 지정하는 경로 파라미터 (/resource/1/10234)
   *      2. 리소스에 대한 추가 정보를 요청하는 쿼리 파라미터 (?name=john)
   *      3. 클라이언트를 빠르게 인증하는 쿠키 파라미터
   *
   * REST 응답에 포함되는것
   *  - 상태 코드
   *    - 200: 일반 성공 응답
   *    - 201: POST 메서드 성공 응답
   *    - 3xx: URL 리디렉션
   *    - 400: 서버가 처리할 수 없는 잘못된 요청
   *    - 404: 리소스를 찾을 수 없음
   *    - 5xx: 서버 오류
   *    > 응답 코드 참조: https://developer.mozilla.org/ko/docs/Web/HTTP/Status
   *
   * # RESTful이란?
   *  - REST(아키텍처) 원리를 따르는 시스템 또는 제공하는 웹 서비스를 ‘RESTful’하다 표현 또는 지칭(비공식)
   *
   * RESTful의 목적
   *  - 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것
   *    > RESTful한 API 구현 목적은 성능 향상이 아닌 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기
   *
   * # GET과 POST의 차이
   *
   * 1. 특징:
   *  - GET:
   *    - 캐시가 가능하다.
   *    - 웹 캐시가 요청을 가로채 서버로부터 리소스를 다시 다운로드하는 대신 리소스의 복사본을 반환한다.
   *        HTTP 헤더에서 cache-control 헤더를 통해 캐시 옵션을 지정할 수 있다.
   *    - 브라우저 히스토리에 남는다.
   *    - 북마크 될 수 있다.
   *    - 길이 제한이 있다. (브라우저별 상이)
   *    - 중요한 정보(보안 요소)를 다루면 안된다.
   *    - 데이터를 요청할때만 사용 된다.
   *  - POST:
   *    - 캐시되지 않는다.
   *    - 브라우저 히스토리에 남지 않는다.
   *    - 북마크 되지 않는다.
   *    - 데이터 길이에 제한이 없다.
   * 2. 사용목적:
   *  - GET: 데이터 요청
   *  - POST: 데이터 생성 | 업데이트
   * 3. 리소스 전달 방식:
   *  - GET: 쿼리스트링
   *  - POST: HTTP Body
   * 4. 멱등성 (idempotent):
   *  - GET: 멱등 O
   *  - POST: 멱등 X
   *  > 멱등 사전적 정의: 연산을 여러 번 적용하더라도 결과가 달라지지 않는 성질을 의미
   *
   */

  /*
   * # HTTP Method 특징
   *
   * # GET(Request has body: N)
   * - 특정 리소스의 표시를 요청합니다. GET을 사용하는 요청은 오직 데이터를 받기만 한다.
   *  > GET 요청에 본문이나 페이로드가 담겨있으면 명세에는 금지되어있지 않지만, 의미가 정의되지 않아 기존에 존재하는
   *    구현체에게 요청을 거부당할수 있다. 이러한 이유로 GET 요청에는 본문이나 페이로드를 담지 않는 것을 권장한다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/GET
   * # HEAD(Request has body: N)
   *  - GET 메서드의 요청과 동일한 응답을 요구하지만, 응답 본문을 포함하지 않는다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/HEAD
   * # POST(Request has body: Y)
   *  - POST 메서드는 특정 리소스에 엔티티를 제출할 때 쓰입니다. 이는 종종 서버의 상태의 변화나 부작용을 일으킨다.
   *  - 보통 HTML 양식을 통해 서버에 전송
   *    이떄 콘텐츠 유형(Content-Type)은 *<form> 요소의 enctype 특성이나 <input>, <button> *요소의 formenctype 특성 안에 적당한 문자열을 넣어 결정
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/POST
   * # PUT(Request has body: Y)
   *  - 요청 페이로드를 사용해 새로운 리소스를 생성하거나, 대상 리소스를 나타내는 데이터를 대체한다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/PUT
   * # DELETE(Request has body: May)
   *  - DELETE 메서드는 특정 리소스를 삭제한다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/DELETE
   * # CONNECT(Request has body: N)
   *  - CONNECT 메서드는 목적 리소스로 식별되는 서버로의 터널을 맺습니다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/CONNECT
   * # OPTIONS(Request has body: N)
   *  - 목적 리소스의 통신을 설정하는 데 쓰입니다.
   *  > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/OPTIONS
   * # TRACE (en-US) (Request has body: N)
   *  - 목적 리소스의 경로를 따라 메시지 loop-back 테스트를 합니다.
   *  > 정의: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/TRACE
   * # PATCH(Request has body: Y)
   *  - 리소스의 부분만을 수정하는 데 쓰인다.
   *    > 정의: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/PATCH
   *
   * # PUT vs POST
   *  - PUT과 POST의 차이는 멱등성으로, PUT은 멱등성을 가진다. 즉, 부수 효과(side effect)가 없다.
   *
   *
   */
}
