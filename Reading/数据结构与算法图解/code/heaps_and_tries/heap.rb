#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
class Heap
  def initialize
    @data = []
  end

  def root_node
    return @data.first
  end

  def last_node
    return @data.last
  end

  def left_child_index(index)
    return (index * 2) + 1
  end

  def right_child_index(index)
    return (index * 2) + 2
  end

  def parent_index(index)
    return (index - 1) / 2
  end

  def has_greater_child(index)
    # We check whether the node at index has left and right
    # children and if either of those children are greater
    # than the node at index:
    (@data[left_child_index(index)] &&
     @data[left_child_index(index)] > @data[index]) || 
    (@data[right_child_index(index)] && 
      @data[right_child_index(index)] > @data[index])
  end

  def calculate_larger_child_index(index)
    # If there is no right child:
    if !@data[right_child_index(index)]
      # Return left child index:
      return left_child_index(index)
    end

    # If right child value is greater than left child value:
    if @data[right_child_index(index)] > @data[left_child_index(index)]
      # Return right child index:
      return right_child_index(index)
    else # If the left child value is greater or equal to right child:
      # Return the left child index:
      return left_child_index(index)
    end

  end

  def insert(value)
    # Turn value into last node by inserting it at the end of the array:
    @data << value

    # Keep track of the index of the newly inserted node:
    new_node_index = @data.length - 1

    # The following loop executes the "trickle up" algorithm.
    
    # If the new node is not in the root position, 
    # and it's greater than its parent node:
    while new_node_index > 0 && @data[new_node_index] > @data[parent_index(new_node_index)]

      # Swap the new node with the parent node:
      @data[parent_index(new_node_index)], @data[new_node_index] = 
      @data[new_node_index], @data[parent_index(new_node_index)]

      # Update the index of the new node:
      new_node_index = parent_index(new_node_index)
    end
  end

  def delete
    # We only ever delete the root node from a heap, so we
    # pop the last node from the array and make it the root node:
    @data[0] = @data.pop
    # Track the current index of the "trickle node":
    trickle_node_index = 0

    # The following loop executes the "trickle down" algorithm:

    # We run the loop as long as the trickle node has a child
    # that is greater than it:
    while has_greater_child(trickle_node_index)
      # Save larger child index in variable:
      larger_child_index = calculate_larger_child_index(trickle_node_index)

      # Swap the trickle node with its larger child:
      @data[trickle_node_index], @data[larger_child_index] = 
      @data[larger_child_index], @data[trickle_node_index]

      # Update trickle node's new index:
      trickle_node_index = larger_child_index
    end
  end
end