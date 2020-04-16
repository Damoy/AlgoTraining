def checkValidString(s: str) -> bool:
    left = 0
    right = 0
    for c in s:
        left += 1 if c == '(' else -1
        right += 1 if c != ')' else -1
        if right < 0:
            break
        left = max(left, 0)
    return left == 0

print(checkValidString("") == True)
print(checkValidString("()") == True)
print(checkValidString("(*)") == True)
print(checkValidString("(*))") == True)
print(checkValidString("(((*)") == False)
print(checkValidString("(*()") == True)
print(checkValidString("((*)") == True)
print(checkValidString("(*)") == True)
print(checkValidString(")(") == False)
print(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*") == False)