# 📝 Todo 프로젝트 로드맵 (Thymeleaf → Vue 확장형)

처음에는 **Spring Boot + Thymeleaf**로 빠르게 완성하고,  
이후 **Vue 기반 프론트 분리 구조로 확장**하는 것을 목표로 합니다.

---

# 🔥 전체 로드맵

👉 핵심 흐름

백엔드 안정화 → 인증 → 기능 구현 → 화면 → 배포 → 프론트 확장 → 고도화(JWT)

---

# ✅ 1단계: 백엔드 뼈대 잡기 (필수)

- [ ] 프로젝트 생성 (Spring Boot 3.x)
- [ ] 패키지 구조 (domain 기반)
- [ ] User / Todo 엔티티 생성
- [ ] JPA 연결 (H2 or MySQL)

---

# ✅ 2단계: 회원가입 기능

- [ ] 회원가입 기능 구현
- [ ] username 중복 체크
- [ ] 비밀번호 암호화 (BCrypt)

---

# ✅ 3단계: 로그인 (세션 기반)

👉 Spring Security 적용

- [ ] Security 설정
- [ ] 로그인 처리 (/login)
- [ ] 세션 생성 확인
- [ ] 로그인 성공 / 실패 처리

❗ 이 단계에서 JWT 하지 않음

---

# ✅ 4단계: 인증 기반 구조

- [ ] 로그인 사용자 가져오기
- [ ] Controller / Service에서 사용자 활용

예시:

Authentication auth = SecurityContextHolder.getContext().getAuthentication();

---

# ✅ 5단계: Todo 기능 구현

- [ ] Todo 생성
- [ ] Todo 목록 조회
- [ ] Todo 수정
- [ ] Todo 삭제

❗ 반드시 로그인 사용자 기준 처리

---

# ✅ 6단계: Thymeleaf 화면 구성

👉 여기까지가 1차 완성

- [ ] 로그인 페이지
- [ ] 회원가입 페이지
- [ ] Todo 리스트 화면
- [ ] Todo 등록/삭제 UI

👉 서버 렌더링 기반으로 전체 흐름 완성

---

# ✅ 7단계: 기능 검증

- [ ] 전체 기능 수동 테스트
- [ ] 로그인 유지 확인
- [ ] 사용자별 데이터 분리 확인

---

# ✅ 8단계: 배포

👉 우선 단일 서버 구조

- [ ] GitHub Actions 설정
- [ ] Spring Boot 빌드 및 배포
- [ ] 서버 실행 (jar)

👉 이 단계에서는 Thymeleaf 포함 상태로 배포

---

# ⏭️ 9단계: Vue 도입 (확장)

👉 기존 구조 유지하면서 점진적 변경

- [ ] Vue 프로젝트 생성
- [ ] axios 설정
- [ ] API 호출 구조 설계

---

# ⏭️ 10단계: API 전환

- [ ] Controller → @RestController 전환
- [ ] JSON 응답 구조 변경
- [ ] /api/** 경로로 통일

---

# ⏭️ 11단계: Vue ↔ Spring 연결

- [ ] CORS 설정
- [ ] withCredentials 설정
- [ ] 로그인 상태 유지 확인

---

# ⏭️ 12단계: 프론트 분리 배포

- [ ] Vue build
- [ ] nginx 배포
- [ ] API 서버 분리

예시:

www.xxx.com → Vue  
api.xxx.com → Spring

---

# ⏭️ 13단계: 리팩토링

- [ ] DTO 분리
- [ ] 예외 처리 (ControllerAdvice)
- [ ] 응답 포맷 통일

---

# ⏭️ 14단계: JWT 적용 (고도화)

- [ ] JWT 로그인 구현
- [ ] 토큰 발급
- [ ] 인증 필터 적용

❗ 반드시 세션 구조 이해 후 진행

---

# 🔥 최종 핵심 순서

1. 엔티티 + JPA
2. 회원가입
3. Spring Security (세션 로그인)
4. Todo 기능
5. Thymeleaf 화면 완성
6. 배포
7. Vue 도입
8. API 전환
9. 프론트/백 연결
10. 리팩토링
11. JWT

---

# 🔥 한줄 핵심

👉 처음엔 **Thymeleaf로 흐름 완성 → 이후 Vue로 확장**

---

# 💡 핵심 전략

- 처음부터 SPA 하지 않는다
- 인증/비즈니스 흐름을 먼저 완성한다
- 이후 API 기반으로 자연스럽게 전환한다
- 점진적으로 실무 구조로 확장한다
