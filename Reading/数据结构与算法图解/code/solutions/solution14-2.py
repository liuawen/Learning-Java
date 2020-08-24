def printInReverse:
  currentNode = lastNode

  while current_node:
    print(currentNode.data)
    currentNode = currentNode.previousNode
