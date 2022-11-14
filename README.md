# BankApp-kotlin

## Outline

kotlin과 Android Studio를 활용한 폰뱅킹 Application

## Development Environment 

| 구 분 | 내 용 |
| --- | --- |
| OS | Windows 11 Home |
| Language | Kotlin 213-1.7.20 |
| Editor | Android Studio 11.0.13 |
| Github | https://github.com/seopit95/BankApp-kotlin.git |

![bankStart](https://user-images.githubusercontent.com/115531849/201670928-26a37a4b-d272-4922-9a27-dd92c4664281.gif)
- MainActivity가 생성되기전에 StartActivity로 App Loading 구사
- 총 3개의 Fragment 사용
- Action bar를 숨기고 Tool bar를 사용
- ViewPager 사용

![backRecyclerView](https://user-images.githubusercontent.com/115531849/201671012-eb49395e-b8d4-49ee-af57-846c89ce6047.gif)
- RecyclerView로 출금한 내역들을 표시
- ItemView는 CardView를 사용
- floating Button으로 출금내역 추가 Dialog를 사용(입금할 은행에 맞게 은행 이미지가 생성되게 함)
- setOnClickListener로 ItemView를 Click하면 은행과 해당은행의 국적을 Toast메세지로 발생
- setOnLongClickListener로 ItemView를 길게 누르면 해당 ItemView는 삭제됨

![banketc](https://user-images.githubusercontent.com/115531849/201670937-3709e489-4a28-494b-911c-2d9ef784b78d.gif)
- 스마트폰 Pay를 구현
- PasswordActivity를 만들어 비밀번호가 알맞게 입력되면 Parcalable Intent를 사용
- 비밀번호는 임의로 123456을 설정
- 아무런 입력이 없을 경우와 비밀번호가 다를 경우 각각 Toast 메세지를 다르게 발생
- 비밀번호가 알맞게 되어 PasswordActivity로 intent되면 10초부터 카운트를 설정
- 카운트가 0초가 될 경우 다시 이전 Layout인 FragmentThree로 돌아감

![bankPay](https://user-images.githubusercontent.com/115531849/201670965-0d79cd0e-a505-4941-87e3-935260280c72.gif)
- Toggle 버튼을 사용하여 간단하게 메뉴표시
- Nevigator 사용
- 메뉴 클릭시 Toast 메시지 표출
- '고객센터' 메뉴를 클릭할 경우 자동으로 전화App으로 연결 (임의로 번호를 설정)
- Search 기능 추가
- Tab메뉴 추가 (메뉴 클릭시 Toast 메세지 발생)
