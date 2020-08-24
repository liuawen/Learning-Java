# We've provided the basic Node and LinkedList classes in addition to the actual solution,
# which is the printList function

class Node:

  def __init__(self, data, nextNode=None):
    self.data = data
    self.nextNode = nextNode

class LinkedList:

  def __init__(self, firstNode):
    self.firstNode = firstNode

  def printList(self):
    currentNode = self.firstNode

    while currentNode:
      print(currentNode.data)
      currentNode = currentNode.nextNode