class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def bstFromPreorder(preorder):
    if not preorder or not len(preorder):
        return None
    return util(0, len(preorder) - 1, preorder)

def util(start, end, preorder):
    if start > end:
        return None
    node = TreeNode(preorder[start])
    i = start
    while i <= end:
        if preorder[i] > node.val:
            break
        i += 1
    node.left = util(start + 1, i - 1, preorder)
    node.right = util(i, end, preorder)
    return node