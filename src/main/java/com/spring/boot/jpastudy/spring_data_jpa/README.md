# Spring Data JPA 


---

- Spring Boot + Spring Data JPA -> (거의) 설정 없이 사용 가능
- 자동 설정
  - persistence.xml
  - EntityManagerFactory
- 스프링 연동
  - 스프링 트랜잭션 연동
  - EntityManager 연동


### 사용법

---
- spring-boot-starter-data-jpa 의존
  - 필요한 설정 자동 처리
- 스프링 부트 설정
- 엔티티 단위로 Repository 인터페이스를 상속받은 인터페이스 생성
- 지정한 규칙에 맞게 메서드 추가
- 필요한 곳에 해당 인터페이스 타입을 주입해서 사용


---
save() 동작 방식
- 새 엔티티면 EntityManager#persist() 실행
- 새 엔티티가 아니면 EntityManager#merge() 실행
- 새 엔티티인지 판단하는 기준
  - Persistable을 구현한 엔티티
    - isNew()로 판단
    - `@Version` 속성이 있는 경우
      - 버전 값이 null이면 새 엔티티로 판단
    - 식별자가 참조 타입이면
      - 식별자가 null이면 새 엔티티로 판단
    - 식별자가 숫자 타입이면
      - 0이면 새 엔티티로 판단

```java
  public <S extends T> S save(S entity) {
        if (this.entityInformation.isNew(entity)) {
            this.em.persist(entity);
            return entity;
        } else {
            return this.em.merge(entity);
        }
    }
```

### JPA 정렬, 페이징, @Query

---
1. find 메서드에 OrderBy 붙임
   2. OrderBy 뒤에 프로퍼티명 + Asc/Desc
   3. 여러 프로퍼티 지정 가능
```java
List<User> findByNameLikeOrderByNameDesc(String keyword);
List<User> findByNameLikeOrderByNameAsc(String keyword);
List<User> findByNameLikeOrderByNameAscEmailDesc(String keyword);
```

- 메서드 명으로 정렬 지정할 순 있지만 가능하면 Sort 사용
- Pageable/PageRequest로 페이징 처리 가능
  - findTop/findFirst, findTopN/findFirstN
- @Query를 사용해서 JPQL 지정

[공식 문서](https://www.baeldung.com/spring-data-jpa-pagination-sorting)


### Specification

---

- Specification 인터페이스를 이용한 검색 조건 생성
- 조합 가능
  - and() / or() 로 검색 조건 조합

- [공식문서](https://www.baeldung.com/rest-api-search-language-spring-data-specifications)
- [공식문서2](https://www.baeldung.com/spring-jpa-joining-tables)
