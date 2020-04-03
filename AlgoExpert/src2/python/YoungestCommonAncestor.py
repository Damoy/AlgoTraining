class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None

    def addAsAncestors(self, descendants):
        for descendant in descendants:
            descendant.ancestor = self

# O(h) time | O(h) space
def getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo):
    if descendantOne == topAncestor or descendantTwo == topAncestor:
        return topAncestor

    ancestors = [descendantOne, descendantTwo]
    currentOne = descendantOne
    currentTwo = descendantTwo
    one = True 

    while (currentOne != None and currentOne != topAncestor) \
        or (currentTwo != None and currentTwo != topAncestor):

        ancestor = currentOne.ancestor if one else currentTwo.ancestor

        if ancestor in ancestors:
            return ancestor

        if(ancestor != None):
            ancestors.append(ancestor)            

        if one:
            if currentOne != topAncestor:
                currentOne = currentOne.ancestor
            one = False
        else:
            if currentTwo != topAncestor:
                currentTwo = currentTwo.ancestor
            one = True

    return topAncestor

# O(h) time | O(1) space
def getYoungestCommonAncestor_sol(topAncestor, descendantOne, descendantTwo):
    depthOne = getDescendantDepth(descendantOne, topAncestor)
    depthTwo = getDescendantDepth(descendantTwo, topAncestor)

    if depthOne > depthTwo:
        return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo)
    else:
        return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne)

def getDescendantDepth(descendant, topAncestor):
    depth = 0
    while descendant != topAncestor:
        depth += 1
        descendant = descendant.ancestor
    return depth

def backtrackAncestralTree(lowerDescendant, higherDescendant, diff):
    while diff > 0:
        lowerDescendant = lowerDescendant.ancestor
        diff -= 1

    while lowerDescendant != higherDescendant:
        lowerDescendant = lowerDescendant.ancestor
        higherDescendant = higherDescendant.ancestor
        
    return lowerDescendant

a = AncestralTree("A")
b = AncestralTree("B")
c = AncestralTree("C")
d = AncestralTree("D")

b.ancestor = a
c.ancestor = a
d.ancestor = b

h = AncestralTree("H")
i = AncestralTree("I")
e = AncestralTree("E")
f = AncestralTree("F")
g = AncestralTree("G")

h.ancestor = d
i.ancestor = d
e.ancestor = b
f.ancestor = c
g.ancestor = c

print(getYoungestCommonAncestor(a, b, c).name)
print(getYoungestCommonAncestor(a, d, c).name)
print(getYoungestCommonAncestor(a, d, g).name)
print(getYoungestCommonAncestor(a, i, g).name)
print(getYoungestCommonAncestor(a, d, e).name)
print(getYoungestCommonAncestor(a, h, g).name)
print(getYoungestCommonAncestor(a, a, b).name)
print(getYoungestCommonAncestor(a, f, g).name)
print(getYoungestCommonAncestor(a, h, i).name)

b.ancestor = a
c.ancestor = a
d.ancestor = a
e.ancestor = a

g.ancestor = b
h.ancestor = b
i.ancestor = b

j = AncestralTree("J")
k = AncestralTree("K")
l = AncestralTree("L")
m = AncestralTree("M")
n = AncestralTree("N")
o = AncestralTree("O")

j.ancestor = c
k.ancestor = d
l.ancestor = d
m.ancestor = e
n.ancestor = e
o.ancestor = m

print(getYoungestCommonAncestor(a, h, n).name)
print(getYoungestCommonAncestor(a, n, o).name)

ancestralTrees = {}
alphabet = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
for letter in alphabet:
    ancestralTrees[letter] = AncestralTree(letter)

ancestralTrees["A"].addAsAncestors(
    [ancestralTrees["B"], ancestralTrees["C"], ancestralTrees["D"], ancestralTrees["E"], ancestralTrees["F"]]
)

ancestralTrees["B"].addAsAncestors([ancestralTrees["G"], ancestralTrees["H"], ancestralTrees["I"]])
ancestralTrees["C"].addAsAncestors([ancestralTrees["J"]])
ancestralTrees["D"].addAsAncestors([ancestralTrees["K"], ancestralTrees["L"]])
ancestralTrees["F"].addAsAncestors([ancestralTrees["M"], ancestralTrees["N"]])
ancestralTrees["H"].addAsAncestors([ancestralTrees["O"], ancestralTrees["P"], ancestralTrees["Q"], ancestralTrees["R"]])
ancestralTrees["K"].addAsAncestors([ancestralTrees["S"]])
ancestralTrees["P"].addAsAncestors([ancestralTrees["T"], ancestralTrees["U"]])
ancestralTrees["R"].addAsAncestors([ancestralTrees["V"]])
ancestralTrees["V"].addAsAncestors([ancestralTrees["W"], ancestralTrees["X"], ancestralTrees["Y"]])
ancestralTrees["X"].addAsAncestors([ancestralTrees["Z"]])


print("Tests Algo 1:", getYoungestCommonAncestor(ancestralTrees["A"], ancestralTrees["Z"], ancestralTrees["M"]).name)
print("Tests Algo 2:", getYoungestCommonAncestor(ancestralTrees["A"], ancestralTrees["T"], ancestralTrees["H"]).name)