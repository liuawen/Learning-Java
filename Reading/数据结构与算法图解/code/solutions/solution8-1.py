def getIntersection(array1, array2):
  intersection = []
  hashTable = {}

  for value in array1:
    hashTable[value] = True

  for value in array2:
    if hashTable.get(value):
      intersection.append(value)

  return intersection