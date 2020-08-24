def sum(low, high):
  # Base case:
  if high == low:
    return low

  return high + sum(low, high - 1)