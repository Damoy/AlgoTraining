class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.nbEdges = 0
        def height(node):
            if node is None:
                return 0
            left = height(node.left)
            right = height(node.right)
            self.nbEdges = max(self.nbEdges, left + right)
            return max(left, right) + 1
        height(root)
        return self.nbEdges

s = Solution()
t = TreeNode(1)
t.left = TreeNode(2)
t.left.left = TreeNode(4)
t.left.right = TreeNode(5)
t.right = TreeNode(3)

print(s.diameterOfBinaryTree(t))

t2 = TreeNode(1)
print(s.diameterOfBinaryTree(t2))