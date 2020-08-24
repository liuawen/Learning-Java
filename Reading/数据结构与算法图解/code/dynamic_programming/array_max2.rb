#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def max(array)

  return array[0] if array.length == 1

  # Calculate the max of the remainder of the array
  # and store it inside a variable:

  max_of_remainder = max(array[1, array.length - 1])

  # Comparison of first number against this variable:

  if array[0] > max_of_remainder
    return array[0]
  else
    return max_of_remainder
  end
end