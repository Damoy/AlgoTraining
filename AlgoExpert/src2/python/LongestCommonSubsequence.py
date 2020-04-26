def longestCommonSubsequence(str1, str2):
    lengths = [[0 for _ in range(len(str1) + 1)] for _ in range(len(str2) + 1)]
    for row in range(1, len(str2) + 1):
        for col in range(1, len(str1) + 1):
            if str2[row - 1] == str1[col - 1]:
                lengths[row][col] = lengths[row - 1][col - 1] + 1
            else:
                lengths[row][col] = max(lengths[row - 1][col], lengths[row][col - 1])
    return retrieveSequence(lengths, str1)

def retrieveSequence(lengths, string):
    seq = []
    row = len(lengths) - 1
    col = len(lengths[0]) - 1
    while row != 0 and col != 0:
        if lengths[row][col] == lengths[row - 1][col]:
            row -= 1
        elif lengths[row][col] == lengths[row][col - 1]:
            col -= 1
        else:
            seq.append(string[col - 1])
            row -= 1
            col -= 1
    return list(reversed(seq))

print(longestCommonSubsequence("ZXVVYZW", "XKYKZPW"))