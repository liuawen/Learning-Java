def last(self):
  currentNode = self.firstNode

  while currentNode.nextNode:
    currentNode = currentNode.nextNode

  return currentNode.data