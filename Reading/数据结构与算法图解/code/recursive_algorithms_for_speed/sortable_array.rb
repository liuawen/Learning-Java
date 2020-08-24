#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
class SortableArray

  attr_reader :array

  def initialize(array)
    @array = array
  end

  def partition!(left_pointer, right_pointer)

    # We always choose the right-most element as the pivot.
    # We keep the index of the pivot for later use:
    pivot_index = right_pointer

    # We grab the pivot value itself:
    pivot = @array[pivot_index]

    # We start the right pointer immediately to the left of the pivot
    right_pointer -= 1

    while true

      # Move the left pointer to the right as long as it
      # points to value that is less than the pivot:
      while @array[left_pointer] < pivot do
        left_pointer += 1
      end

      # Move the right pointer to the left as long as it
      # points to a value that is greater than the pivot:
      while @array[right_pointer] > pivot do
        right_pointer -= 1
      end

      # We've now reached the point where we've stopped
      # moving both the left and right pointers.

      # We check whether the left pointer has reached
      # or gone beyond the right pointer. If it has,
      # we break out of the loop so we can swap the pivot later
      # on in our code:
      if left_pointer >= right_pointer
        break

      # If the left pointer is still to the left of the right
      # pointer, we swap the values of the left and right pointers:
      else
        @array[left_pointer], @array[right_pointer] =
          @array[right_pointer], @array[left_pointer]

        # We move the left pointer over to the right, gearing up
        # for the next round of left and right pointer movements:
        left_pointer += 1
      end

    end

    # As the final step of the partition, we swap the value
    # of the left pointer with the pivot:
    @array[left_pointer], @array[pivot_index] =
      @array[pivot_index], @array[left_pointer]

    # We return the left_pointer for the sake of the quicksort method
    # which will appear later in this chapter:
    return left_pointer
  end

end
