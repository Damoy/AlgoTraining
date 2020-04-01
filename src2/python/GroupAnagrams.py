def groupAnagrams(words):
    res = {}

    for word in words:
        sortedWord = str(sorted(word))
        if sortedWord in res:
            res[sortedWord].append(word)
        else:
            res[sortedWord] = [word]

    return list(res.values())


print(groupAnagrams(["yo", "act", "flop", "tac", "cat", "oy", "olfp"]))