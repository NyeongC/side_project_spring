# 📝 Devlog - 기술 블로그 프로젝트

개발 공부 및 기술 공유를 위한 개인 블로그 프로젝트입니다.  
Spring Boot 기반으로 시작하여 MSA 구조와 메시징 시스템(RabbitMQ) 등을 도입하며 점진적으로 확장합니다.

## 🛠️ 프로젝트 목표

- CRUD 중심의 기술 블로그 구현
- MSA 환경으로의 점진적 전환
- RabbitMQ 기반 알림 시스템 도입
- 사용자 활동 통계 및 대시보드 구성

---

## 📌 개발 단계

### ✅ 1단계: 블로그 기본 기능
- 게시글 작성 / 수정 / 삭제 / 조회
- 카테고리 및 태그 기능
- 마크다운 에디터 적용 예정

### ⏭️ 2단계: 알림 서비스 분리 (MSA + RabbitMQ)
- 댓글/좋아요 발생 시 RabbitMQ 이벤트 발행
- 별도 알림 서비스에서 수신 및 DB 저장

### ⏭️ 3단계: 서비스 분리 및 통계 기능
- 유저, 댓글, 통계 서비스로 분리
- API 간 통신은 FeignClient 또는 RestTemplate 사용

### ⏭️ 4단계: 인증, 캐시, 대시보드
- JWT 기반 인증 시스템
- Redis로 캐싱 및 세션 관리
- 관리자 대시보드 (유저/게시글 통계 시각화)

---

## ⚙️ 기술 스택
- Spring Boot, JPA, MySQL
- RabbitMQ, Redis
- Spring Security, JWT
- (계획) Prometheus, Grafana, Docker

---
