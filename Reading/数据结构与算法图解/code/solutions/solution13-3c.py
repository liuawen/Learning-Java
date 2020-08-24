def max(array):
  greatestNumberSoFar = array[0]

  for number in array:
    if number > greatestNumberSoFar:
      greatestNumberSoFar = number

  return greatestNumberSoFar