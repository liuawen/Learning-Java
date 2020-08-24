def fib(n, memo):

  if n == 0 or n == 1:
    return n

  # Check the hash table (called memo) to see whether fib(n)
  # was already computed or not:
  if not memo.get(n):

    # If n is NOT in memo, compute fib(n) with recursion
    # and then store the result in the hash table:
    memo[n] = fib(n - 2, memo) + fib(n - 1, memo)
  
  # By now, fib(n)'s result is certainly in memo. (Perhaps
  # it was there before, or perhaps we just stored it there
  # in the previous line of code. But it's certainly there now.)
  # So let's return it:
  return memo[n]