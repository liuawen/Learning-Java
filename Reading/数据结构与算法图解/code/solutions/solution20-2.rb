#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def find_missing_number(array)
  # Calculate the full sum (which is the sum if only the 0 were missing):
  full_sum = 0
  (1..array.length).each do |n|
    full_sum += n
  end

  # Calculate the CURRENT sum:
  current_sum = 0

  array.each do |n|
    current_sum += n
  end
  # The difference between the two sums will be the missing number:
  return full_sum - current_sum
end
