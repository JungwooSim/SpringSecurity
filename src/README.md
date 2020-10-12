## 인프런 강의 : 스프링 시큐리티 - Spring Boot 기반으로 개발하는 Spring Security

### 스프링 시큐리티 기본 API 및 Filter 이해
1. 프로젝트 구성 및 의존성 추가
2. 사용자 정의 보안 기능 구현
3. Form Login 인증
4. Form Login 인증 필터 : UsernamePasswordAuthenticationFilter
5. Logout 처리, LogoutFilter
6. Remember Me 인증
- 세션 만료되고 웹브라우저가 종료된 후에도 어플리케이션이 사용자를 기억하는 기능
- 쿠키에 대한 Http 요청을 확인한 후 토큰 기반 인증을 사용해 유효성을 검사하고 토큰이 검증되면 사용자는 로그인 된다.
- 사용자 라이프 사이클
  - 인증 성공(Remember-Me 쿠키 설정)
  - 인증 실패(쿠키가 존재하면 쿠키 무효화)
  - 로그아웃(쿠키가 존재하면 쿠키 무효화)
7. Remember Me 인증 필터 : RememberMeAuthenticationFilter
8. 익명사용자 인증 필터 : AnonymousAuthenticationFilter
- 익명 사용자 인증 처리 필터
- 익명 사용자와 인증 사용 사용자를 구분해서 처리하기 위한 용도로 사용
- 화면에서 인증 여부를 구현할 때 isAnonymous() 와 isAuthenticated() 로 구분해서 사용
- 인증객체를 세션에 저장하지 않는다.
9. 동시 세션 제어, 세션 고정 보호, 세션 정책
- 동시 세션 제어 2가지 전략
  1. 이전 사용자 세션 만료
  2. 현재 사용자 인증 실패
  
```java
http.sessionManagement() : 세션 관리 기능 작동

http.sessionManagement()
.maximumSession(1) // 최대 허용 가능 세션 수, -1 : 무제한 로그인 세션 허용
.maxSessionPreventsLogin(true) // 동시 로그인 차단, false : 기존 세션 만료(default)
.invalidSessionUrl("/invalid") // 세션이 유효하지 않을 때 이동 할 페이지
.expiredUrl("/expired") // 세션 만료 후 이동할 페이지


http.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.If_Required);
	
SessionCreationPolicy.Always // 스프링 시큐리티가 항상 세션 생성
SessionCreationPolicy.If_Required // 스프링 시큐리티가 필요 시 생성(기본값)
SessionCreationPolicy.Never // 스프링 시큐리티가 생성하지 않지만 이미 존재하면 사용
SessionCreationPolicy.Stateless // 스프링 시큐리티가 생성하지 않고 존재해도 사용하지 않음
```
10. 세션 제어 필터 : SessionManagementFilter, ConcurrentSessionFilter
11. 권한설정과 표현방식
