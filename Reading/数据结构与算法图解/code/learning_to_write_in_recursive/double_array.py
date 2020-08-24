def double_array(array, index=0):
  # Base case: when the index goes past the end of the array
  if (index >= len(array)):
    return

  array[index] *= 2
  double_array(array, index + 1)