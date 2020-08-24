#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def max(array)
  greatest_number_so_far = array[0]

  array.each do |number|
    if number > greatest_number_so_far
      greatest_number_so_far = number
    end
  end

  return greatest_number_so_far
end