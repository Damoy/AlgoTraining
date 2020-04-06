def groupAnagrams(words):
    res = {}

    for word in words:
        sortedWord = str(sorted(word))
        if sortedWord in res:
            res[sortedWord].append(word)
        else:
            res[sortedWord] = [word]

    return list(res.values())

from collections import defaultdict

def groupAnagrams_v2(words):
    res = defaultdict(list)
    for word in words:
        res['.'.join(sorted(word))].append(word)
    return [v for v in res.values()]

print(groupAnagrams(["yo", "act", "flop", "tac", "cat", "oy", "olfp"]))
print(groupAnagrams_v2(["yo", "act", "flop", "tac", "cat", "oy", "olfp"]))