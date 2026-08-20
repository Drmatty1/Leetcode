class Solution {
    class Treap {

        static class Node {
            int val;
            int priority;
            int size;
            Node left, right;

            Node(int val) {
                this.val = val;
                this.priority = new Random().nextInt();
                this.size = 1;
            }
        }

        Node root;

        // ---------------- SIZE ----------------

        int size(Node node) {
            return node == null ? 0 : node.size;
        }

        void updateSize(Node node) {
            if (node != null) {
                node.size = 1 + size(node.left) + size(node.right);
            }
        }

        // ---------------- ROTATIONS ----------------

        Node rotateRight(Node root) {
            Node newRoot = root.left;

            root.left = newRoot.right;
            newRoot.right = root;

            updateSize(root);
            updateSize(newRoot);

            return newRoot;
        }

        Node rotateLeft(Node root) {
            Node newRoot = root.right;

            root.right = newRoot.left;
            newRoot.left = root;

            updateSize(root);
            updateSize(newRoot);

            return newRoot;
        }

        // ---------------- INSERT ----------------

        Node insert(Node root, int val) {

            if (root == null) {
                return new Node(val);
            }

            if (val < root.val) {

                root.left = insert(root.left, val);

                // Heap property violated
                if (root.left.priority > root.priority) {
                    root = rotateRight(root);
                }

            } else {

                root.right = insert(root.right, val);

                // Heap property violated
                if (root.right.priority > root.priority) {
                    root = rotateLeft(root);
                }
            }

            updateSize(root);

            return root;
        }

        void insert(int val) {
            root = insert(root, val);
        }

        // ---------------- COUNT GREATER ----------------

        int countGreaterThan(Node root, int x) {

            if (root == null) {
                return 0;
            }

            if (root.val <= x) {
                // root and everything on left are <= x
                return countGreaterThan(root.right, x);
            }

            // root.val > x
            // root itself + entire right subtree
            return 1
                + size(root.right)
                + countGreaterThan(root.left, x);
        }

        int countGreaterThan(int x) {
            return countGreaterThan(root, x);
        }
    }
    public int[] resultArray(int[] nums) {

        Treap ost_l = new Treap();
        Treap ost_r = new Treap();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        arr1.add(nums[0]);
        ost_l.insert(nums[0]);

        arr2.add(nums[1]);
        ost_r.insert(nums[1]);

        int n = nums.length;

        for(int i=2; i<n; i++){
            int curr = nums[i];

            if(ost_l.countGreaterThan(curr) > ost_r.countGreaterThan(curr)){
                arr1.add(curr);
                ost_l.insert(curr);
            }
            else if(ost_l.countGreaterThan(curr) < ost_r.countGreaterThan(curr)){
                arr2.add(curr);
                ost_r.insert(curr);
            }
            else if(arr2.size() < arr1.size()){
                arr2.add(curr);
                ost_r.insert(curr);
            }
            else{
                arr1.add(curr);
                ost_l.insert(curr);
            }
        }

        int i=0;
        for(int e: arr1) nums[i++] = e;
        for(int e: arr2) nums[i++] = e;

        return nums;

    }
}












