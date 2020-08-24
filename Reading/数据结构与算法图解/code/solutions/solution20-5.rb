#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def sort_temperatures(array)
  hash_table = {}

  # Populate hash table with occurrences of temperatures:
  array.each do |temperature|
    if hash_table[temperature]
      hash_table[temperature] += 1
    else
      hash_table[temperature] = 1
    end
  end

  sorted_array = []

  # We multiply the temperature by 10 on the outset
  # so that we can increment the temperature by a whole number
  # during the loop, and avoid floating-point math errors: 
  temperature = 970

  # Run loop from 970 up to 990
  while temperature <= 990

    # If the hash table contains our the current temperature:
    if hash_table[temperature / 10.0]

      # Populate the sorted_array with as many occurences
      # of the current temperature that there are:
      hash_table[temperature / 10.0].times do
        sorted_array << temperature / 10.0
      end
    end

    temperature += 1
  end

  return sorted_array
end