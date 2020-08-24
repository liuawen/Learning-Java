#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def quicksort!(left_index, right_index)
  # Base case: the subarray has 0 or 1 elements:
  if right_index - left_index <= 0
    return
  end

  # Partition the range of elements and grab the index of the pivot:
  pivot_index = partition!(left_index, right_index)

  # Recursively call this quicksort! method on whatever 
  # is to the left of the pivot:
  quicksort!(left_index, pivot_index - 1)

  # Recursively call this quicksort! method on whatever 
  # is to the right of the pivot:
  quicksort!(pivot_index + 1, right_index)
end