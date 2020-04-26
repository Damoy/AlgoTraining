def longestCommonSubsequence(text1: str, text2: str) -> int:
    n = len(text1)
    m = len(text2)
    sub = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    for row in range(1, n + 1):
        for col in range(1, m + 1):
            sub[row][col] = sub[row - 1][col - 1] + 1 \
                if text1[row - 1] == text2[col - 1] else \
                    max(sub[row - 1][col], sub[row][col - 1])
    return sub[n][m]
    

print(longestCommonSubsequence("abcde", "ace") == 3)
print(longestCommonSubsequence("abc", "abc") == 3)
print(longestCommonSubsequence("abc", "abe") == 2)
print(longestCommonSubsequence("abc", "def") == 0)
print(longestCommonSubsequence("psnw", "vozsh") == 1)
print(longestCommonSubsequence("ezupkr", "ubmrapg") == 2)