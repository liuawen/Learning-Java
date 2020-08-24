def selectEven(array):
  if len(array) == 0:
    return []

  if array[0] % 2 == 0:
    return [array[0]] + selectEven(array[1:])
  else:
    return selectEven(array[1:])