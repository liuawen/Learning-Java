class Stack:
  def __init__(self):
    self.data = []

  def push(self, element):
    self.data.append(element)

  def pop(self):
    return self.data.pop()

  def read(self):
    if len(self.data) > 0:
      return self.data[-1]
    else:
      return None

def reverse(string):
  stack = Stack()

  for char in string:
    stack.push(char)

  newString = ""

  while stack.read():
    newString += stack.pop()

  return newString