class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None

    def getNodesInArray(self):
        nodes = []
        current = self
        while current is not None:
            nodes.append(current.value)
            current = current.next
        return nodes

def removeKthNodeFromEnd(head, k):
    left = head
    right = head
    cpt = 0

    while cpt != k:
        right = right.next
        cpt += 1
    
    if right is None:
        head.value = head.next.value
        head.next = head.next.next
    else:
        while right is not None and right.next is not None:
            left = left.next
            right = right.next

        left.next = left.next.next


l = LinkedList(0)
l.next = LinkedList(1)
l.next.next = LinkedList(2)
l.next.next.next = LinkedList(3)
l.next.next.next.next = LinkedList(4)
l.next.next.next.next.next = LinkedList(5)
l.next.next.next.next.next.next = LinkedList(6)
l.next.next.next.next.next.next.next = LinkedList(7)
l.next.next.next.next.next.next.next.next = LinkedList(8)
l.next.next.next.next.next.next.next.next.next = LinkedList(9)

print(l.getNodesInArray())
removeKthNodeFromEnd(l, 5)
print(l.getNodesInArray())