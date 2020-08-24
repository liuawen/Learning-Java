def fib(n):

  if n == 0:
    return 0

  # a and b start with the first two numbers in the 
  # series, respectively:
  a = 0
  b = 1

  # Loop from 1 until n:
  for i in range(1, n):

    # a and b each move up to the next numbers in the series.
    # Namely, b becomes the sum of b + a, and a becomes what b used to be. 
    # We utilize a temporary variable to make these changes:
    temp = a
    a = b
    b = temp + a

  return b