def addUntil100(array):
  if len(array) == 0:
    return 0

  sumOfRemainingNumbers = addUntil100(array[1:])

  if array[0] + sumOfRemainingNumbers > 100:
    return sumOfRemainingNumbers
  else:
    return array[0] + sumOfRemainingNumbers