class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, x: int) -> None:
        newMin = x
        if len(self.minStack):
            newMin = min(self.minStack[-1], x)
        self.minStack.append(newMin)
        self.stack.append(x)

    def pop(self) -> None:
        self.minStack.pop()
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]