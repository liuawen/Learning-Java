#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def get_intersection(array1, array2)
  intersection = []
  hash_table = {}

  array1.each do |value|
    hash_table[value] = true
  end

  array2.each do |value|
    if hash_table[value]
      intersection << value
    end
  end

  return intersection
end