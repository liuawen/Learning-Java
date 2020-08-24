class TreeNode:
    def __init__(self,val,left=None,right=None):
        self.value = val
        self.leftChild = left
        self.rightChild = right

def search(searchValue, node):
    # Base case: If the node is nonexistent 
    # or we've found the value we're looking for:
    if node is None or node.value == searchValue:
        return node

    # If the value is less than the current node, perform
    # search on the left child:
    elif searchValue < node.value:
        return search(searchValue, node.leftChild)

    # If the value is less than the current node, perform
    # search on the right child:
    else:  # searchValue > node.value
        return search(searchValue, node.rightChild)

def insert(value, node):
    if value < node.value:

        # If the left child does not exist, we want to insert
        # the value as the left child:
        if node.leftChild is None:
            node.leftChild = TreeNode(value)
        else:
            insert(value, node.leftChild)

    elif value > node.value:

        # If the right child does not exist, we want to insert
        # the value as the right child:
        if node.rightChild is None:
            node.rightChild = TreeNode(value)
        else:
            insert(value, node.rightChild)


def traverse_and_print(node):
    if node is None:
        return
    traverse_and_print(node.leftChild)
    print(node.value)
    traverse_and_print(node.rightChild)

def delete(valueToDelete, node):

    # The base case is when we've hit the bottom of the tree,
    # and the parent node has no children:
    if node is None:
        return None

    # If the value we're deleting is less or greater than the current node,
    # we set the left or right child respectively to be 
    # the return value of a recursive call of this very method on the current 
    # node's left or right subtree.
    elif valueToDelete < node.value:
        node.leftChild = delete(valueToDelete, node.leftChild)
        # We return the current node (and its subtree if existent) to 
        # be used as the new value of its parent's left or right child:
        return node
    elif valueToDelete > node.value:
        node.rightChild = delete(valueToDelete, node.rightChild)
        return node

    # If the current node is the one we want to delete:
    elif valueToDelete == node.value:

        # If the current node has no left child, we delete it by 
        # returning its right child (and its subtree if existent) 
        # to be its parent's new subtree:
        if node.leftChild is None:
            return node.rightChild

            # (If the current node has no left OR right child, this
            # ends up being None as per the first line of code in this
            # function.)

        elif node.rightChild is None:
            return node.leftChild
    
        # If the current node has two children, we delete the current node
        # by calling the lift function (below), which changes the current node's
        # value to the value of its successor node:
        else:
            node.rightChild = lift(node.rightChild, node)
            return node

    
def lift(node, nodeToDelete):

    # If the current node of this function has a left child, 
    # we recursively call this function to continue down 
    # the left subtree to find the successor node. 
    if node.leftChild:
        node.leftChild = lift(node.leftChild, nodeToDelete)
        return node
    # If the current node has no left child, that means the current node
    # of this function is the successor node, and we take its value
    # and make it the new value of the node that we're deleting:
    else:
        nodeToDelete.value = node.value
        # We return the successor node's right child to be now used
        # as its parent's left child:
        return node.rightChild

        

root = TreeNode(50)
insert(25, root)
insert(75, root)
insert(11, root)
insert(33, root)
insert(30, root)
insert(40, root)
insert(56, root)
insert(52, root)
insert(61, root)
insert(89, root)
insert(82, root)
insert(95, root)
insert(55, root)
delete(50, root)
traverse_and_print(root)