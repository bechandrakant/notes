## Recursion

Definition: 
- Solving problems using __sub-problems (smaller instances of same problem)__
```
    sum(N) = 1 + 2 + 3 + 4 + .... + (N - 1) + N
    sum(N - 1) = 1 + 2 + 3 + 4 + .... + (N - 2) + (N - 1)
    sum(N) = sum(N - 1) + N
    sum(N - 1) = sum(N - 2) + N
```

### Recursion steps
- **Assumption**: Decide what the function does
- **Main Logic**: Solve problems using sub-problems
- **Base Condition**: When to stop.

### Recursive relations
- Use to calculate time complexity of recursive function.

```
Q: Calculate Time Complexity of factorial(N) 
- 1 represent constant time
- T(N) represent time taken to complete given input size N

T(N) = 1 + T(N - 1), T(0) = 1

T(N - 1) = 1 + T(N - 2)
T(N - 2) = 1 + T(N - 3)

=> T(N) = 1 + T(N - 1) = 2 + T(N - 2) = 3 + T(N - 3)

// Generalize
T(N) = K + T(N - K)

Solve using, T(0) = 1, i.e K = N
T(N) = N + T(N - N) => N + 1
=> Time Complexity: O(N)
```

#### Find Time Complexity
```
Q1. T(N) = 2 * T (N / 2) + N, T(1) = 1
Ans: N log N

Q2. T(N) = 2 * T(N - 1) + 1, T(1) = 1
Ans: 2^N
```
### Simplified Master's Theorem




