def max(node):
    if node.rightChild:
        return max(node.rightChild)
    else:
        return node.value 