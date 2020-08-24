def golomb(n, memo={}):
  if n == 1:
    return 1

  if not memo.get(n):
    memo[n] = 1 + golomb(n - golomb(golomb(n - 1, memo), memo), memo)

  return memo[n]