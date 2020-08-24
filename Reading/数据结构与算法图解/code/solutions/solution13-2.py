def find_missing_number(array):
  array.sort()

  for i in range(len(array)):
    if array[i] != i:
      return i

  return None