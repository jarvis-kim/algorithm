# 최백준 알고리즘 강의 2017-03-15
 - Location : 강남역

---

# 그래프 알고리즘 
 * 문제의 상황을 그래프로 변경 후 문제에 적용 해야함 (이게 많이 어려움)

 DFS/BFS는 목적이 같음. 단 순서만 달라짐 

 
    
    
## BFS

대부분 최단 거리를 구하는 문제

 - BFS는 대부분 최단 거리를 구하는데 사용(모든 가중치가 1일때만 사용)
 
 **BFS를 적용가능한 상황**
 1. 그래프에서 상태를 찾아야함
 2. 상태는 가중치가 **1**이 나오야함
 3. 최소 비용을 구하는 문제여야함

 - BFS는 Queue를 사용함.
 
 - BFS가 어렵다는것은 상태를 찾기가 어려운것. (상태가 어려운경우는 2차원 배열일 경우)
 
 ### 숨바꼭질 - BFS
 - 방법 : BFS로 풀수 있음. 
 - BFS는(최단거리) 같은 정점을 두번 방문하면 안된다. BFS의 성질.
 
 ### 숨바꼭질 4 - BFS
 - 이동하는 방법을 출력하는 문제
 - 점정이 어디서 왔는지 저장
   - 재귀를 이용할수 추적할 수 있음
   - 스택을 사용해서 추적할 수 있음

### DSLR - BFS
 - 가중치합이 연산 횟수
 - 가중치는 연산 횟수
 - 상태는 지금 숫자
 
 ### 이모티콘 - BFS
 - 상태 : 변화 시킬수 있는 값
 - 화면에 이모티콘이 몇개 있냐가 중요함 -> S
 

## DFS (Depth First Search_깊이 우선 탐색)  

- 모든 경우의 수를 구할 때

 - 상태를 찾아야함 (다음 순서로)
   1. 불가능한 경우(더이상 함수 호출을 해봐야 답이 안나오는경우)
   2. 정답을 찾은 경우
   3. 두가지 경우가 아닌 경우 다음 경우를 호출

### 1,2,3 더하기 - DFS, DP

1. 불가능한경우 - sum이 goal보다 커진경우
2. 정답을 찾은 경우 - sum이 goal되어 버린경우
3. 다음 경우 호출 - 1
  - 1을 사용하는 경우 go(count +1, sum + 1, goal)
  - 2를 사용하는 경우 go(count + 1, sum + 2, goal)
  - 3을 사용하는 경우 go(count + 1, sum + 3, goal)


``
1초는 1억 연산을 할수 있음
1억이 넘는건 큰수
1억보다 작은건 작은 수
3만가지는 매우 작은 경우
``

### 암호 만들기 - DFS
- 모두 구하라는 모두 구해야함. 모두 해보지 않고 구할수 있는것은 없음
 
 
 ### 스도쿠
 - 중요하지않으니 패스 했음
 
 ### 부분집합의 합
 가능한경우의 수 :  2의n -> 작은수
 
 - 재귀호출안해도됨. 비트마스크를 사용해도됨
                                                                       
 ### 종이 조각
 
 
   
