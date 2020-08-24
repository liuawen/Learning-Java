def fib(n):
  # The base cases are the first two numbers in the series:
  if n == 0 or n == 1:
    return n

  # Return the sum of the previous two Fibonacci numbers:
  return fib(n - 2) + fib(n - 1)