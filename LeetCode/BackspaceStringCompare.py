def backspaceCompare(S, T):
    s = backspaceUtil(S)
    t = backspaceUtil(T)
    n = len(s)
    if n != len(t):
        return False
    for i in range(n):
        if(s[i] != t[i]):
            return False
    return True

def backspaceUtil(string):
    arr = []
    for c in string:
        n = len(arr)
        if c == '#' and n > 0:
            arr.pop()
        elif c != '#':
            arr.append(c)
    return arr

print(backspaceCompare("ab#c", "ad#c"))
print(backspaceCompare("ab##", "c#d#"))
print(backspaceCompare("a##c", "#a#c"))
print(backspaceCompare("a#c", "b"))