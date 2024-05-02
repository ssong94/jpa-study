# 02 코드 구조, 영속 컨텍스트

- 기본 구조
  - EntityManagerFactory 초기화
  - DB 작업이 필요할 때마다
    - EntityManager 생성
    - EntityManager로 DB 조작
    - EntityTransaction으로 트랜잭션 관리
  - 하지만 스프링과 연동할 때는 
    - 대부분 스프링이 대신 처리하므로 매핑 설정 중심으로 작업. 
  - 영속 컨텍스트 (Persistence Context)
    - EntityManager 단위로 영속 컨텍스트 관리
    - 커밋 시점에 영속 컨텍스트의 변경 내역을 DB에 반영(변경 쿼리 실행)
    - 엔티티를 메모리에 보관
    - 변경을 추적해서 트랜잭션 커밋 시점에 DB 반영




🔖 **참고**

---

[공식 홈페이지](https://www.baeldung.com/jpa-hibernate-persistence-context)
