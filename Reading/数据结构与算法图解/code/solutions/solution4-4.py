def greatestNumber(array):
  greatestNumberSoFar = array[0]

  for i in array:
    if i > greatestNumberSoFar:
      greatestNumberSoFar = i

  return greatestNumberSoFar