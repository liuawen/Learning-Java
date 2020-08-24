def mark_inventory(clothing_items):
  clothing_options = []

  for item in clothing_items:
    # For sizes 1 through 5 (Python ranges go UP TO second
    # number, but do not include it):
    for size in range(1, 6):
      clothing_options.append(item + " Size: " + str(size))

  return clothing_options