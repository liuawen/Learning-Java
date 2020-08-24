def print_all_items(array):
  for value in array:
    # if the current item is a "list", i.e. array:
    if isinstance(value, list):
      print_all_items(value)
    else:
      print(value)