def traverse(self, node=None):
  currentNode = node or self.root

  for key, childNode in currentNode.children.items():
    print(key)
    if key != "*":
      self.traverse(childNode)