def max(array):
  for i in array:
    iIsGreatestNumber = True
  
    for j in array:
      if j > i:
        iIsGreatestNumber = False

    if iIsGreatestNumber:
      return i