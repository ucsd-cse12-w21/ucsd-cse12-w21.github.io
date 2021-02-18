For `removeRecursively`, we search for our `keyToRemove`, then find the minimum of the right subtree in our algorithm, and swap in that minimum for the node we want to remove.

Our interface has fewer methods than used in PA7 and we have omitted implementations for methods in our `BSTMap.java` that you are supposed to implement for PA7. Because of this, you will need to add your own implementations for these before the code will compile.

In the code, we provide method implementations for both recursively removing and iteratively removing an element from a tree. Notice how much more code is required for the iterative one!

Lastly, we added in a `BFS` method that performs BFS on a binary tree. Note: a **binary tree** is not necessarily a BST (it is not necessarily ordered). We use binary search in our `removeRecursively` and `removeIteratively` methods because binary search makes more sense for a BST, but we are providing this method as something we hope will be useful to you with heaps.
