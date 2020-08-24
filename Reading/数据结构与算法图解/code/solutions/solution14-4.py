def reverse(self):
  previousNode = None
  currentNode = self.firstNode

  while currentNode:
    nextNode = currentNode.nextNode

    currentNode.nextNode = previousNode
    
    previousNode = currentNode
    currentNode = nextNode

  self.firstNode = previousNode 