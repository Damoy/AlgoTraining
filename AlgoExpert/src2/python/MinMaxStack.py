class MinMaxStack:
    def __init__(self):
        self.minMaxStack = []
        self.stack = []
			
    def peek(self):
        return self.stack[len(self.stack) - 1]

    def pop(self):
        self.minMaxStack.pop()
        return self.stack.pop()

    def push(self, number):
        newMinMax = {"min": number ,"max": number}
        if len(self.minMaxStack):
            lastMinMax = self.minMaxStack[len(self.minMaxStack) - 1]
            newMinMax["min"] = min(lastMinMax["min"], number)
            newMinMax["max"] = max(lastMinMax["max"], number)
        self.minMaxStack.append(newMinMax)
        self.stack.append(number)
			
    def getMin(self):
        return self.minMaxStack[(len(self.minMaxStack) - 1)]["min"]

    def getMax(self):
        return self.minMaxStack[(len(self.minMaxStack) - 1)]["max"]

def printMinMaxPeek(s, min, max, peek):
    print(s.getMin() == min)
    print(s.getMax() == max)
    print(s.peek() == peek)

s = MinMaxStack()
s.push(2)
printMinMaxPeek(s, 2, 2, 2)

s.push(7)
printMinMaxPeek(s, 2, 7, 7)

s.push(1)
printMinMaxPeek(s, 1, 7, 1)

s.push(8)
printMinMaxPeek(s, 1, 8, 8)

s.push(3)
printMinMaxPeek(s, 1, 8, 3)

