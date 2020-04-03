class SuffixTrie:
    def __init__(self, string):
        self.root = {}
        self.endSymbol = "*"
        self.populateSuffixTrieFrom(string)

    # Time O(n^2) | Space O(n^2)
    def populateSuffixTrieFrom(self, string):
        n = len(string)
        for i in range(n):
            suffix = string[i:n]
            self.addSuffixToRoot(suffix)

    # Time O(n)
    def addSuffixToRoot(self, suffix):
        dico = self.root
        for s in suffix:
            if s in dico:
                dico = dico[s]
            else:
                newDico = {}
                dico[s] = newDico
                dico = newDico
        dico[self.endSymbol] = True

    # Time O(m (size of searched string)) | Space O(1)
    def contains(self, string):
        dico = self.root
        for s in string:
            if s not in dico:
                return False
            dico = dico[s]
        return self.endSymbol in dico

trie = SuffixTrie("babc")
print(trie.contains("ba"))
print(trie.contains("babc"))
print(trie.contains("c"))
print(trie.contains("bc"))
print(trie.contains("abc"))
print(trie.contains("ba"))
print(trie.contains("b"))
print(trie.contains("cde"))