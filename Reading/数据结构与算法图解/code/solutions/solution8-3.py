def findMissingLetter(string):
  # Store all encountered letters in hash table:
  hashTable = {}
  for char in string:
    hashTable[char] = True

  alphabet = "abcdefghijklmnopqrstuvwxyz"
  for char in alphabet:
    if not hashTable.get(char):
      return char

  return None