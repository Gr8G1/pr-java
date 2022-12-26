package Gr8G1.prac.spring.da;

public class PrJDBC {
  /*
   * # JDBC(Java Database Connectivity)
   *
   * # JDBC란?
   *  - Java 애플리케이션에서 데이터베이스에 액세스하기 위해 Java 초창기(JDK 1.1) 버전부터 제공되는 표준 사양(또는 명세, Specification)으로
   *    Java 개발자는 JDBC API를 사용해서 다양한 벤더(Oracle, MS SQL, MySQL 등)의 데이터베이스와 연동할 수 있다.
   *    > JDBC는 데이터 액세스 기술의 기본이 되는 저수준(low level) API이다.
   *
   * # JDBC 배워야 하는 이유
   *  - Spring Data JDBC나 Spring Data JPA 같은 기술 역시 데이터베이스와 연동하기 위해 내부적으로는 *JDBC*를 이용하기 때문이다.
   *
   * # JDBC 드라이버(JDBC Driver)
   *  - 데이터베이스와의 통신을 담당하는 인터페이스
   *    > Oracle이나 MS SQL, MySQL 같은 다양한 벤더에서는 해당 벤더에 맞는 JDBC 드라이버를 제공하고, 이를 이용해서 특정 벤더의 데이터베이스에 액세스 할 수 있다.
   *
   * # JDBC API 흐름
   *  1. JDBC 드라이버 로딩
   *  2. Connection 객체 생성
   *  3. Statement 객체 생성
   *  4. Query 실행
   *  5. ResultSet 객체로부터 데이터 조회
   *  6. ResultSet 객체 close
   *  7. Statement 객체 close
   *  8. Connection 객체 close
   *
   * # CP(Connection Pool)란?
   *  - 데이터베이스와의 연결을 위한 Connection 객체를 생성하는 작업은 비용이 많이 드는 작업 중 하나이다.
   *    애플리케이션 로딩 시점에 Connection 객체를 미리 생성해두고 애플리케이션에서 데이터베이스에 연결이 필요할 경우,
   *    Connection 객체를 새로 생성하는 것이 아니라 미리 만들어 둔 Connection 객체를 사용함으로써 애플리케이션의 성능을 향상을 도모하는데
   *    Connection을 미리 만들어서 보관하고 애플리케이션이 필요할 때 이 Connection을 제공해주는 역할을 하는 Connection 관리자를 Connection Pool이라고 한다.
   *  > Spring Boot 2.0 이전 버전에는 Apache 재단의 오픈 소스인 Apache Commons DBCP(Database Connection Pool, DBCP)를 주로 사용했지만
   *    Spring Boot 2.0 부터는 성능면에서 더 나은 이점을 가지고 있는 HikariCP를 기본 DBCP로 채택했다.
   *
   * # Spring Data JDBC
   *
   * # interface CrudRepository<T, ID>
   *  - Spring Data에서 제공하는 CRUD 편의 제공 인터페이스
   *    - public interface Repository extends CrudRepository<T, ID> {..}
   *      > save()
   *        - @Id 대응값이 0 또는 null이면 신규 데이터라고 판단 insert 쿼리를 전송
   *        - @Id 대응값이 0 또는 null아니면 기존 데이터라고 판단 update 쿼리를 전송
   *
   * # interface PagingAndSortingRepository<T, ID>
   *  - Spring Data에서 제공하는 Paging & Sorting CrudRepository 확장 인터페이스
   *    - public interface Repository extends PagingAndSortingRepository<T, ID> {..}
   *      > findAll(page, size, sort)
   *        - 특정 필드명 기준 정렬시: Sort.by("filedsName").ascending() / descending
   *
   *
   * # 쿼리 메서드(Query Method)
   *    - find + By + SQL 쿼리문에서 WHERE 절의 컬럼명 + (WHERE 절 컬럼의 조건이 되는 데이터)
   *    - WHERE 절 여러 컬럼 지정시 지정시 And를 붙인다.
   *      > 예) find[:All]By[:OrderBy](Target)[:ASC, Desc](Pageable pagaeble)
   *
   * # Annotations
   *  - @Table
   *    - @Table 애너테이션이 선언되지 않는다면 기본적으로 클래스(Enttity)명을 테이블 이름과 매핑한다.
   *  - @Id
   *    - 기본키(Primary key) 정의
   *  - @Cloumn
   *    - 컬럼명 정의
   *  - @MappedCollection(idColumn = "", keyColumn = "")
   *    - 애그리거트 객체 매핑 규칙2에 따라 아래와 같이 정의
   *      - idColumn: 자식 테이블에 추가되는 외래키에 해당되는 컬럼명을 지정
   *      - keyColumn: 외래키를 포함하고 있는 테이블의 기본키 컬럼명을 지정
   *    > 동일한 애그리거트 내에서 엔티티간 참조는 객체 참조로 정의한다.
   *
   *    - 애그리거트 객체 매핑 규칙3에 따라 아래와 같이 정의
   *      - private AggregateReference<Entity, Long> PK
   *    > 애그리거트 루트 via 애그리거트 루트 참조시
   *  - @Query("SELECT * FROM COFFEE WHERE ID = :Id")
   *    - CRUD 인터페이스 구현시 쿼리문 직접 정의에 사용
   *
   */
}
