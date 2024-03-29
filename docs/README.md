## 구현 해야할 목록
1. domain
   1. Discount : 
      1. [x] christmasDDay : 12. 1 ~ 12. 25까지 1,000원으로 시작하여 할인액이 매일 100원씩 증가
      2. [x] weekday : 디저트 메뉴를 메뉴 1개당 2,023원 할인
      3. [x] weekend : 메인 메뉴를 메뉴 1개당 2,023원 할인
      4. [x] special : 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
      5. [x] BonusEvent : 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
   2. Bill
      1. [x] appetizer : 양송이수프(6,000), 타파스(5,000), 시저샐러드(8,000)
      2. [x] mainDish : 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
      3. [x] dessert : 초코케이크(15,000), 아이스크림(5,000)
      4. [x] drink : 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
   3. Badge : 총혜택 금액에 따라 다른 이벤트 배지를 부여
      1. [x] star : 5,000 원 이상
      2. [x] tree : 10,000 원 이상
      3. [x] santa : 20,000 원 이상
      4. [x] none : "없음"
   4. Calender
      1. [x] Weekend : 매주 금요일, 토요일 주말 설정
      2. [x] Speical : 매주 일요일과 크리스마스(25일) Special Day 설정
      3. [x] Weekday : Weekend, Special 제외한 날은 Weekday로 설정

2. View
   1. InputView
      1. [x] bookingDay : 식당 예상 방문 날짜 입력받기
         1. [x] 예외 처리 : 값이 숫자인지 확인하기
         2. [x] 예외 처리 : 값이 1 ~ 31인지 확인하기
      2. [x] bookingMenu : 주문할 메뉴와 개수 입력받기
         1. [x] 예외 처리 : 값이 정해진 양식이 맞는지 확인하기
         2. [x] 예외 처리 : 정확한 메뉴를 입력했는지 확인하기
         3. [x] 예외 처리 : 주문한 메뉴의 총합이 20개가 넘는지 확인하기
   2. OutputView
      1. [x] welcomeMessage : 웰컴메세지 출력 
      2. [x] showCanGetBenefits : 혜택 알림 출력
      4. [x] outputOrder : 주문 메뉴 출력
      5. [x] totalPriceBeforeDiscount : 할인 전 총주문 금액 출력
      6. [x] giftmenu : 증정 메뉴 출력(샴페인)
      7. [x] showAllDiscount : 받은 총혜택 내역 출력
      8. [x] totalDiscountPrice : 총혜택 금액 출력
      9. [x] expectedPrice : 할인 후 예상 결제 금액 출력
      10. [x] showBadge : 이벤트 배지 출력


### 이벤트 목표
1. 중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것
2. 올해 12월에 지난 5년 중 최고의 판매 금액을 달성
3. 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참여하는 것

### 12월 이벤트 계획
- 크리스마스 디데이 할인
  - 이벤트 기간 : 2023. 12. 1 ~ 2023. 12. 25
  - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  - 총주문 금액에서 해당 금액만큼 할인
  (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
- 평일 할인(일요일~목요일) : 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- 주말 할인(금요일, 토요일) : 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
- 특별 할인 : 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
- 증정 이벤트 : 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
- 이벤트 기간 : '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023. 12. 01 ~ 2023. 12. 31 동안 적용

### 혜택 금액에 따른 12월 이벤트 배지 부여
- 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다. 이 배지는 2024 새해 이벤트에서 활용할 예정입니다.
배지에 따라 새해 이벤트 참여 시, 각각 다른 새해 선물을 증정할 예정입니다.
  - 5천 원 이상 : 별
  - 1만 원 이상 : 트리
  - 2만 원 이상 : 산타

### 고객에게 안내할 이벤트 주의 사항
- 총주문 금액 10,000원 이상부터 이밴트가 적용됩니다.
- 음료만 주문 시, 주문할 수 없습니다.
- 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.</br>
  (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

### '12월 이벤트 플래너' 개발 요청 사항
- 고객들이 식당에 방문할 날짜와 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액,
증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주기를 기대합니다.
- 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
  - 방문할 날짜는 1 이상 31이하의 숫자로만 입력받아 주세요.
  - 1 이상 31 이하의 숫자가 아닌경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 모든 에러 메세지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문하실 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2, 레드와인-1, 초코케이크-1)
  - 고객이 메뉴판에 없는 메뉴를 입력하는 경우,
  "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 메시지를 보여주세요.
  - 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요.
  이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여주세요.
  - 메뉴 형식이 예시와 다른 경우,
  "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 라는 에러 메시지를 보여 주세요.
  - 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1, 시저샐러드-1),
  "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 라는 에러 메시지를 보여 주세요.
  - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
- 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여주세요.
- 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- 증정 메뉴
  - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- 혜택 내역
  - 고객에게 적용된 이벤트 내역만 보여주세요.
  - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여주세요.
  - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
- 이벤트 배지
  - 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.
- 적용된 이벤트가 하나도 없는 경우는 아래 예시를 참고해 주세요.

> 안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
>
><주문 메뉴></br>
타파스 1개</br>
제로콜라 1개
>
><할인 전 총주문 금액></br>
>8,500원
>
><증정 메뉴></br>
>없음
>
><혜택 내역></br>
>없음
>
><총혜택 금액></br>
>0원
>
><할인 후 예상 결제 금액>
>8,500원
>
><12월 이벤트 배지></br>
없음

### 기대하는 '12월 이벤트 플래너'의 예시 모습
>
> 안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.</br>
>12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)</br>
>3</br>
>주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)</br>
>티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1</br>
>12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!</br>
>
><주문 메뉴></br>
>티본스테이크 1개</br>
>바비큐립 1개</br>
>초코케이크 2개</br>
>제로콜라 1개</br>
>
><할인 전 총주문 금액></br>
>142,000원
>
><증정 메뉴></br>
>샴페인 1개
>
><혜택 내역></br>
>크리스마스 디데이 할인: -1,200원</br>
>평일 할인: -4,046원</br>
>특별 할인: -1,000원</br>
>증정 이벤트: -25,000원</br>
>
><총혜택 금액></br>
>-31,246원
>
><할인 후 예상 결제 금액></br>
>135,754원
>
><12월 이벤트 배지></br>
>산타
> 