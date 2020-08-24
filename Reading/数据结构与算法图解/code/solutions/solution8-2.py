def findDuplicate(array):
  hashTable = {}

  for value in array:
    if hashTable.get(value):
      return value
    else:
      hashTable[value] = True

  return None
