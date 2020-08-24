#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def quickselect!(kth_lowest_value, left_index, right_index)
  # If we reach a base case - that is, that the subarray has one cell,
  # we know we've found the value we're looking for:
  if right_index - left_index <= 0
    return @array[left_index]
  end

  # Partition the array and grab the index of the pivot:
  pivot_index = partition!(left_index, right_index)

  
  # If what we're looking for is to the left of the pivot:
  if kth_lowest_value < pivot_index
    # Recursively perform quickselect on the subarray to 
    # the left of the pivot:
    quickselect!(kth_lowest_value, left_index, pivot_index - 1)
  # If what we're looking for is to the right of the pivot:
  elsif kth_lowest_value > pivot_index
    # Recursively perform quickselect on the subarray to 
    # the right of the pivot:
    quickselect!(kth_lowest_value, pivot_index + 1, right_index)
  else # if kth_lowest_value == pivot_index
    # if after the partition, the pivot position is in the same spot
    # as the kth lowest value, we've found the value we're looking for
    return @array[pivot_index]
  end
end