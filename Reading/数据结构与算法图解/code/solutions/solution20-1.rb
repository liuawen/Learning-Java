#---
# Excerpted from "A Common-Sense Guide to Data Structures and Algorithms, Second Edition",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material,
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose.
# Visit http://www.pragmaticprogrammer.com/titles/jwdsal2 for more book information.
#---
def find_multisport_athletes(array_1, array_2)
  hash_table = {}
  multisport_athletes = []

  array_1.each do |athlete|
    hash_table[athlete[:first_name] + " " + athlete[:last_name]] = true
  end

  array_2.each do |athlete|
    if hash_table[athlete[:first_name] + " " + athlete[:last_name]]
      multisport_athletes << athlete[:first_name] +
        " " + athlete[:last_name]
    end
  end

  return multisport_athletes
end
