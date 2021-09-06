import javax.swing.*;

public class BST<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T element) {
        return this.contains(element, this.root);
    }

    private boolean contains(T element, TreeNode<T> node) {
        if (node == null) {
            return false;
        } else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0)
                return contains(element, node.left);
            else if (compareResult > 0)
                return contains(element, node.right);
            else
                return true;
        }
    }

    public TreeNode<T> findMin() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.findMin(this.root);
        }
    }

    public TreeNode<T> findMax() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.findMax(this.root);
        }
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        if (node == null)
            return null;
        else if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }

    private TreeNode<T> findMax(TreeNode<T> node) {
        if (node != null)
            while (node.right != null) {
                node = node.right;
            }
        return node;
    }

    public void insert(T element) {
        this.root = this.insert(element, this.root);
    }

    private TreeNode<T> insert(T element, TreeNode<T> current) {
        if (current == null)
            return new TreeNode<>(element, null, null);

        int compareResult = element.compareTo(current.element);
        if (compareResult < 0)
            current.left = this.insert(element, current.left);
        else if (compareResult > 0)
            current.right = this.insert(element, current.right);
        return current;
    }

    public void remove(T element) {
        this.root = this.remove(element, this.root);
    }

    private TreeNode<T> remove(T element, TreeNode<T> node) {
        if (node == null)
            return null;

        int compareResult = element.compareTo(node.element);
        if (compareResult < 0)
            node.left = remove(element, node.left);
        else if (compareResult > 0)
            node.right = remove(element, node.right);
        else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }


    /**
     * Print first three levels in System.out
     * [Test]
     */
    public void print(){
        boolean right=true,left=true;
        if (this.isEmpty()){System.out.print("-");}
        else{ System.out.print("     "+this.root.element+"\n");}

        if (this.root.left==null){System.out.print("  -      ");left=false;}
        else{System.out.print("  "+this.root.left.element+"      ");}

        if (this.root.right==null){System.out.print("-\n");right=false;}
        else{System.out.print(this.root.right.element+"\n");}

        if (!left||this.root.left.left==null){System.out.print("-  ");}
        else{System.out.print(this.root.left.left.element+"  ");}

        if (!left||this.root.left.right==null){System.out.print("-  ");}
        else{System.out.print(this.root.left.right.element+"  ");}

        if (!right||this.root.right.left==null){System.out.print("-   ");}
        else{System.out.print(this.root.right.left.element+"   ");}

        if (!right||this.root.right.right==null){System.out.print("-\n");}
        else{System.out.print(this.root.right.right.element+"\n");}
        System.out.print("\n");
    }

    /**
     * [Test]
     */
    public static void main(String[] args) {
        BST<Integer> Tree = new BST<>();
        Tree.insert(10);
        Tree.print();
        Tree.insert(8);
        Tree.print();
        Tree.insert(12);
        Tree.print();
        Tree.insert(7);
        Tree.print();
        Tree.insert(9);
        Tree.print();
        Tree.insert(11);
        Tree.print();
        Tree.insert(13);
        Tree.print();
        /* Delete a element*/
        Tree.remove(10);
        Tree.print();
        Tree.remove(12);
        Tree.print();
        /* Delete twice a element*/
        Tree.remove(12);
        Tree.print();
        Tree.remove(12);
        Tree.print();
        Tree.insert(12);
        Tree.print();
        Tree.insert(99);
        Tree.print();
        Tree.remove(13);
        Tree.print();
        Tree.remove(98);
        Tree.print();
        Tree.remove(99);
        Tree.print();


        System.out.print("Tree contain 10:"+Tree.contains(10)+"\n");
        System.out.print("Tree contain 12:"+Tree.contains(12)+"\n");
        System.out.print("Tree contain 11:"+Tree.contains(11)+"\n");
        System.out.print("Tree contain 7:"+Tree.contains(7)+"\n");

    }
}
