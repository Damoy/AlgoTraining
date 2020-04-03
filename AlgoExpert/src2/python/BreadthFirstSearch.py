from queue import *

class Node:
    def __init__(self, name):
        self.children = []
        self.name = name

    def addChild(self, name):
        self.children.append(Node(name))
        return self

    def breadthFirstSearch(self, array):
        q = Queue()
        q.put(self)

        while(not q.empty()):
            node = q.get()
            array.append(node.name)
            for c in node.children:
                q.put(c)

        return array


tree = Node("A")
tree.addChild("B").addChild("C").addChild("D")
tree.children[0].addChild("E").addChild("F")
tree.children[2].addChild("G").addChild("H")
tree.children[0].children[1].addChild("I").addChild("J")
tree.children[2].children[0].addChild("K")
print(tree.breadthFirstSearch([]))