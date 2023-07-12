# Stack (스택)
## 1. 정의 및 기능
- Stack은 한쪽 끝에서만 항목을 삭제하거나 새로운 항목을 저장하는 자료구조이다. 스택에서 새로운 항목을 저장하는 연산을 push라고 하고, 항목을 삭제하는 연산을 pop이라고 한다.
- push(), pop(), peek() 연산 존재

## 2. In Memory Management
### 1) Call Stack
- 프로그램의 코드 정보(서브루틴 / 메서드 / 함수)를 저장하는 Stack 자료구조이다.
  - 세부 정보는 일반적으로 고급 프로그래밍 언어에서는 숨겨져 있고, 자동화되어 있다.
  - Stack은 현재 실행 중인 서브루틴을 실행한 다음 어디로 반환해야할지를 추적한다.
- 각 함수에 의해 생성된 임시 변수를 저장하는데도 쓰인다.
  - 함수가 새로운 변수를 선언할 때 마다 Stack에 push가 된다.
  - 함수를 종료할 때마다 모든 변수는 Stack에서 pop되고 영구적으로 사라지게 된다.
  - local 변수는 Stack에 있다가 함수가 종료되면 사라지게 된다.
- Stack의 메모리는 제한적이다.
### 2) Heap Memory
- Heap은 자동으로 관리되지 않는 메모리 영역이다.
  - Stack 메모리와 달리 대용량 메모리 영역이다.
- Java의 경우 레퍼런스 타입이나 객체(인스턴스)가 생성되는 공간이다.
- 메모리가 자동으로 관리되지 않기 때문에 할당을 해제해야만 한다.
  - 그렇지 않으면 메모리 누수가 발생하여 느려질 수 있다.

### Stack Memory  vs  Heap Memory
| Stack Memory | Heap Memory |
|---|---|
|사이즈 제한 o | 사이즈 제한 x|
|접근이 빠르다.| 접근이 느리다.|
|지역변수 | 객체, 인스턴스|
|CPU에 의해 공간이 효율적으로 관리됨 | 메모리가 조각날 수 있음|
|변수 리사이즈 x | 변수 리사이즈 o|

## 3. Stakc 구현
- src 참조.

## 4. 예시
### 1) Stack의 최대값 찾기
- O(1)의 시간복잡도로 찾되, O(N)의 공간 사용 가능하다.

```java
public class MaxItemStack {
    private Stack<Integer> mainStack;   // 원본 Stack
    private Stack<Integer> maxStack;    // 최대값을 구하기 위한 Stack

    public MaxItemStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    // 삽입 연산
    public void push(int item) {

        mainStack.push(item); // 원본 Stack에 삽입

        // 첫 번째 삽입
        if (mainStack.size() == 1) {
            maxStack.push(item);
            return;
        }

        // maxStack의 가장 나중(max)값보다 크다면 삽입, 크지 않다면 기존의 max값 삽입
        if (item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    // 삭제 연산 : maxStack, mainStack 둘 다 제거
    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    // 최대값 반환
    public int getMaxItem() {
        return maxStack.peek();
    }

}
```

### 2) Stack으로 Queue 구현

- 2개의 stack 이용

```java
public class Queue {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public Queue() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }
    
    // 삽입 연산
    public void enqueue(int item) {
        this.enqueueStack.push(item);
    }

    public int dequeue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stacks are empty");
        }
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

}
```
- 간단하게 삽입 시 enqueueStack에 삽입했다가, 삭제 시 dequeueStack이 비어 있다면 enqueue 순서대로 pop한 후 push하면 된다. 
- 만일 dequeStack이 비어있지 않다면 그대로 pop 연산을 해준다.

### 3) Stack으로 Queue 구현 2

```java
public class Queue {

    private Stack<Integer> stack;

    public Queue() {
        this.stack = new Stack<>();
    }

    public void enqueue(int item) {
        this.stack.push(item);
    }

    // 삭제 연산 : Stack 하나만을 사용하여 구현, call stack을 통한 재귀 호출
    public int dequeue() {
        // Stack 사이즈가 1이면 삭제 연산 수행 : 마지막 항목이면 삭제처리
        if (stack.size() == 1) {
            return stack.pop();
        }
        // 마지막 항목을 찾을 때까지 pop 연산을 수행
        int item = stack.pop();
        // 재귀 호출 수행
        int lastDequeueItem = dequeue();
        // 꺼낸 항목을 다시 삽입
        enqueue(item);
        // 마지막 항목 반환
        return lastDequeueItem;
    }
}
```

