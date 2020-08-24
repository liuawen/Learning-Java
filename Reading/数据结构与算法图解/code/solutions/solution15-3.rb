#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
# The solution is the max method at the bottom, but we've
# added the basic TreeNode class and the insert method
# for your convenience as well.

class TreeNode
  attr_accessor :value, :left_child, :right_child

  def initialize(val, left=nil, right=nil)
    @value = val
    @left_child = left
    @right_child = right
  end
end

def insert(value, node)
  if value < node.value
    # If the left child does not exist, we want to insert
    # the value as the left child:
    if !node.left_child
        node.left_child = TreeNode.new(value)
    else
        insert(value, node.left_child)
    end
  elsif value > node.value

    # If the right child does not exist, we want to insert
    # the value as the right child:
    if !node.right_child
        node.right_child = TreeNode.new(value)
    else
        insert(value, node.right_child)
    end
  end
end

def max(node)   
  if node.right_child
      return max(node.right_child)
  else
      return node.value
  end
end  