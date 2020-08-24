def firstNonDuplicate(string):
  hashTable = {}

  for char in string:
    if hashTable.get(char):
      hashTable[char] += 1
    else:
      hashTable[char] = 1

  for char in string:
    if hashTable.get(char) == 1:
      return char

  return None