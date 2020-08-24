#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def longest_sequence_length(array)
  hash_table = {}
  greatest_sequence_length = 0

  # Populate hash table with the numbers as keys:
  array.each do |number|
    hash_table[number] = true
  end

  # Iterate over each number in the array:
  array.each do |number|

    # If the current number is the first in the sequence,
    # (that is, there isn't a number one lower than it):
    if !hash_table[number - 1]

      # We start counting the length of the current sequence,
      # starting with the current number. Since this is the
      # first number of the sequence, the length of the sequence
      # is currently 1:
      current_sequence_length = 1

      # We establish a current_number for use in the
      # upcoming while loop:
      current_number = number

      # Run a while loop as long as there is
      # a next number in the sequence:
      while hash_table[current_number + 1]

        # Move on to the next number in the sequence:
        current_number += 1

        # Increase the length of the sequence by 1:
        current_sequence_length += 1

        # Greedily keep track of the greatest sequence length:
        if current_sequence_length > greatest_sequence_length
          greatest_sequence_length = current_sequence_length
        end
      end
    end
  end

  return greatest_sequence_length
end
