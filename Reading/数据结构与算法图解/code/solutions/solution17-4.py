def autocorrect(self, word):
  currentNode = self.root
  # Keep track of how much of the user's word we've found 
  # in the trie so far. We'll need to concatenate this with
  # the best suffix we can find in the trie.
  wordFoundSoFar = ""

  for char in word:
    # If the current node has child key with current character:
    if currentNode.children.get(char): 
      wordFoundSoFar += char 
      # Follow the child node:    
      currentNode = currentNode.children.get(char)
    else:
      # If the current character isn't found among
      # the current node's children, collect all the suffixes that 
      # descend from the current node and get the first one.
      # We concatenate the suffix with the prefix we've found so
      # far to suggest the word the user meant to type in:
      return wordFoundSoFar + self.collectAllWords(currentNode)[0]

  # If the user's word is found in the trie:
  return word