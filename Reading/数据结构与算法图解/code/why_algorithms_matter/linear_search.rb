#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def linear_search(array, search_value)

  # We iterate through every element in the array:
  array.each_with_index do |element, index|

    # If we find the value we're looking for, we return its index:
    if element == search_value
      return index

    # If we reach an element that is greater than the value
    # we're looking for, we can exit the loop early:
    elsif element > search_value
      break
    end
  end

  # We return nil if we do not find the value within the array:
  return nil

end