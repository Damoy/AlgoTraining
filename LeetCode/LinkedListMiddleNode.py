class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def middleNode(self, head):
    length = 0
    current = head
    while current is not None:
        length += 1
        current = current.next
    ptr = 0
    current = head
    while ptr < length // 2:
        current = current.next
        ptr += 1
    return current
    
# [1,2,3] 3 // 2
# [1,2,3,4] 4 // 2
