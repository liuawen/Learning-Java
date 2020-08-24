def uniquePaths(rows, columns):
  if rows == 1 or columns == 1:
    return 1
  return uniquePaths(rows - 1, columns) + uniquePaths(rows, columns - 1)