def triangle(n):
  if n == 1:
    return 1
  return n + triangle(n - 1)