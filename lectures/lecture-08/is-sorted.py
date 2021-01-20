import sys
from time import time

def is_sorted1(lst):
  for i in range(0, len(lst) - 1):
    if lst[i] > lst[i + 1]: return False
  return True

def is_sorted2(lst):
  for i in range(0, len(lst)):
    for j in range(i + 1, len(lst)):
      if lst[i] > lst[j]: return False
  return True

def run_and_time(size):
  lst = range(0, size)
  start = time()
  result = is_sorted1(lst)
  duration = (time() - start) * 1000 # python gives time in seconds, want ms
  print("For size " + str(size) + ": \t" + str(duration))

for size in range(0, 1000000, 100000):
  run_and_time(size)
