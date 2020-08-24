def deleteMiddleNode(self, node):
  node.data = node.nextNode.data
  node.nextNode = node.nextNode.nextNode