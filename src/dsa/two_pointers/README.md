## Two Pointers

Move pointer only when current pointer can yield no more results.

Each Pointer should be unidirectional.

Possible Combinations:
- leftPointer = 0; rightPointer = size - 1 (Move towards center)
- leftPointer = 0; rightPointer = 1 (Move right)
- leftPointer = size - 2; rightPointer = size - 1 (Move towards left)

General Time Complexity: O(N)