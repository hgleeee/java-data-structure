# Array (배열)
## 1. 정의
- 동일한 타입의 원소들이 연속적인 메모리 공간에 할당되어 각 항목이 하나의 원소에 저장되어 있는 기본적인 자료구조

### 구성
- 배열의 인덱스 또는 키로 식별되는 요소/값의 컬렉션
  - 인덱스는 0부터 시작
  - 인덱스 때문에 랜덤 액세스 가능
 
### 특성
- 배열은 동일한 유형의 타입을 저장하기 위한 자료구조
- 배열은 인덱스를 키로 사용
- 배열은 원하는 만큼의 차원을 가질 수 있음, N차원 배열
- 동적배열 : 배열의 크기가 동적으로 변경되는 경우
- 응용 프로그램에는 table, hashtable, heap이 있음

## 2. 장점
- 인덱스, 즉 키 때문에 랜덤 엑세스가 가능하다.
- 구현 및 사용이 쉽다.
- 매우 빠른 자료구조로 항목을 반복해서 추가하거나 삭제하려고 할 때, 주어진 인덱스를 통해 빠르게 처리가 가능하다.

## 3. 단점
- 컴파일 시점에 배열의 크기를 알아야하기 때문에 동적 자료구조가 아니다.
- 배열이 다 찾을 경우, 더 큰 배열을 만들어야하고 다 찬 배열의 데이터를 다시 복사해 옮겨야만 한다.
- 다른 유형의 데이터를 저장할 수 없다.

## 4. 연산
### 1) 삽입 연산
- capacity만큼 가득 차지 않은 배열에 값을 계속 추가할 수 있다.
- 새로운 값을 리스트에 추가할 때, 다음 인덱스에 삽입하면 되기 때문에 매우 빠르다.
- 데이터의 양과 상관 없이 빠르게 처리할 수 있기 때문에 O(1)의 시간 복잡도를 가진다.
### 2) 특정 인덱스에 삽입 연산
- 주어진 인덱스에 값을 위와 같이 추가할 수 있다.
- 문제점은 새로운 값을 주어진 인덱스 위치에 삽입하기 위해서는 기존에 저장된 값들을 이동해야 된다.
- 저장된 데이터가 많으면 많을수록 처리시간이 증가하기 때문에 O(N)의 시간 복잡도를 가진다.
### 3) 삭제 연산
- 저장된 데이터의 양과 상관 없이 빠르게 처리할 수 있기 때문에 O(1)의 시간복잡도를 가진다.
### 4) 특정 인덱스의 삭제 연산
- 저장된 데이터가 많으면 많을수록 이동시켜야할 데이터가 증가하기 때문에 O(N)의 시간복잡도를 갖는다.

## 5. Array 사용
```java
public class ArrApp {
    public static void main(String[] args) {

        // 배열 선언
        int[] nums = new int[5];

        // 배열에 값 저장
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        // O(1) 시간복잡도, random index
        int num = nums[0];
        System.out.println(num);

        // O(N) Linear Search(선형 탐색) --> O(LogN) Binary Tree(이진트리) --> O(1) HashTable(해쉬)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                System.out.println("index found : " + i);
            }
        }
    }
}
```

## 6. ArrayList 구현
- src 참고.

## 7. 예제
### 1) 배열에 저장된 데이터 순서 바꾸기
- Ex) input is [1,2,3,4,5] then the output is [5,4,3,2,1]

```java
// 배열 순서 뒤집기
public class ReverseArray {
    public int[] reverseArray(int[] numbers) {
        int startIndex = 0; // 시작 위치
        int endIndex = numbers.length - 1;  // 마지막 위치

        // 반복 1회에서 2개의 요소의 위치를 교환, n/2 반복만 수행하게 된다.
        while (endIndex > startIndex) {
            // 시작 인덱스와 마지막 인덱스 요소들을 교환 수행
            swap(numbers, startIndex, endIndex);
            // 시작, 마지막 인덱스 1씩 증가, 감소
            startIndex++;
            endIndex--;
        }

        // 순서가 바뀐 배열 반환
        return numbers;
    }

    // 교환
    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
```

### 2) 두 개의 문자 배열의 알파벳들이 일치하는지 확인
```java
public class AnagramProblem {
    public boolean solve(char[] s1, char[] s2) {
        // 비교할 문자 배열의 길이가 같이 않으면 메서드 종료
        if (s1.length != s2.length) {
            return false;
        }

        // 문자 배열 정렬
        Arrays.sort(s1);
        Arrays.sort(s2);

        // 문자 배열 비교, 같지 않으면 메서드 종료
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

}
```


