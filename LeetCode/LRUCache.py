from collections import OrderedDict

class LRUCache:
    def __init__(self, capacity: int):
        self.size = capacity
        self.data = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.data:
            return -1
        self.data.move_to_end(key)
        return self.data[key]
    
    def put(self, key: int, value: int) -> None:
        if key not in self.data:
            if len(self.data) >= self.size:
                self.data.popitem(last=False) # last=False for FIFO
        else:
            self.data.move_to_end(key)
        self.data[key] = value

cache = LRUCache(2)
cache.put(1, 1)
cache.put(2, 2)
print(cache.get(1))
cache.put(3, 3)
print(cache.get(2))
cache.put(4, 4)
print(cache.get(1))
print(cache.get(3))
print(cache.get(4))