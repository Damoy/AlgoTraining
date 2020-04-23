def rangeBitwiseAnd(m: int, n: int) -> int:
    while n > m:
        n = n & (n - 1)
    return m & n

def rangeBitwiseAnd2(m: int, n: int) -> int:
    i = 0
    while(m != n):
        m >>= 1
        n >>= 1
        i += 1
    return n << i