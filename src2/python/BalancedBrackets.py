def balancedBrackets(string):
    stack = []
    openingBrackets = ['(', '[', '{']
    closingBrackets = [')', ']', '}']
    bracketsMapping = {k:v for k,v in zip(openingBrackets, closingBrackets)}

    for char in list(string):
        if char in openingBrackets:
            stack.append(char)
        elif char in closingBrackets:
            if len(stack) == 0:
                return False
            c = stack.pop()
            if bracketsMapping[c] != char:
                return False

    return len(stack) == 0

print(balancedBrackets("([])(){}(())()()"))
print(balancedBrackets("([])(){}(())()("))
print(balancedBrackets("([])(){(())()()"))
print(balancedBrackets("([])(g){}((gggggggg))()()"))