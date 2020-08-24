def indexOfX(string):
  if string[0] == "x":
    return 0
  return indexOfX(string[1:]) + 1
