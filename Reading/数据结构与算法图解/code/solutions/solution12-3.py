def uniquePaths(rows, columns, memo={}):

  if rows == 1 or columns == 1:
    return 1

  # In Python, we can use tuples as hash table keys:
  if not memo.get((rows, columns)):
    memo[(rows, columns)] = uniquePaths(rows - 1, columns, memo) + uniquePaths(rows, columns - 1, memo)

  return memo[(rows, columns)]