def count_ones(outer_array):
  count = 0

  for inner_array in outer_array:
    for number in inner_array:
      if number == 1:
        count += 1

  return count
