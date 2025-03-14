# 키오스크 과제

## 🚀 Hugging Face에서 바로 실행하기
[![Run on Hugging Face Spaces](https://huggingface.co/spaces/YourUsername/Kiosk-Lv6/badge.svg)](https://huggingface.co/spaces/YourUsername/Kiosk-Lv6)

## 📌 실행 방법
1. 위 버튼을 클릭하면 Hugging Face Spaces에서 실행됨
2. 웹 UI에서 "Run" 버튼 클릭하면 `kiosk.exe` 실행됨
3. 결과가 웹 브라우저에 표시됨 🎉

## 목적
- 객체지향 개념을 이해하고 프로그램의 흐름을 파악하는 것이 목표입니다.
- 클린 코드 원칙을 적용하고, 추상화 수준을 균일하게 유지합니다.
- 변수 및 파일명을 명확하게 작성하며, 코드 흐름이 읽기 쉽게 구현합니다.

---
## 사용 기술
- Java 21
- Java Collections Framework
- Stream API
- Enum

## 개발 단계

### **LV.1** - 메뉴 출력 및 선택
- 키오스크에서 메뉴를 출력하고 사용자가 선택할 수 있도록 구현합니다.

### **LV.2** - `MenuItem` 클래스로 역할 분리
- 메뉴 정보를 별도의 `MenuItem` 클래스로 관리하여 `main` 클래스의 역할을 분리합니다.

### **LV.3** - `Kiosk` 클래스로 기능 관리
- 키오스크의 전체적인 기능을 제어하는 `Kiosk` 클래스를 추가합니다.

---

## **LV.6 도전과제**
    lv4~lv6까지 과제 진행 중 흐름을 타버려 lv4,lv5를 따로 못나눴다.

## 프로젝트 구조
    kioskLv6/ 
    ├── KioskLv6.java               # 메인 실행 클래스 
    ├── Kiosk.java                  # 키오스크 시스템 관리 
    ├── Menu.java                   # 메뉴 카테고리 관리 
    ├── MenuItem.java               # 개별 메뉴 아이템 정보 
    ├── MenuData.java               # 초기 메뉴 데이터 관리 
    ├── Cart.java                   # 장바구니 기능 구현 
    ├── Order.java                  # 주문 정보 관리 
    ├── OrderHistory.java           # 주문 내역 관리 
    ├── PaymentMethod.java          # 결제 방법 열거형 
    ├── Discount.java               # 할인 유형 열거형 
    ├── ReturnToHomeException.java  # 홈 이동을 강제하는 예외 클래스

### **구현 요소**
- `Menu`, `MenuItem`, `MenuData`, `Discount`, `Cart`,`Order`,`PaymentMethod`,`OrderHistory `  클래스를 설계하여 구조화합니다.
- 버거, 음료 등의 상위 카테고리를 적용하여 메뉴를 체계적으로 관리합니다.
- **캡슐화** 원칙을 적용하여 클래스의 데이터 접근과 관리를 효율적으로 처리합니다.
- **장바구니 기능** 추가: 메뉴 담기, 삭제, 총 금액 계산, 중복 개수 관리 등.
- `Enum`, 람다, 스트림을 활용하여 주문 및 장바구니 관리를 최적화합니다.
- 결제 시 **할인율** 적용 (`Discount` 활용) 및 결제 수단 선택 (`PaymentMethod`) 기능 구현
- 주문 완료 후 영수증 출력

---