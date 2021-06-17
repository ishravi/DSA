package com.tree;

import java.util.ArrayList;
import java.util.List;

public class NArray {

    public static class TreeNode{
        int val;
        boolean locked = false;
        TreeNode parent;
        List<TreeNode> child;
        int lockedDescendent = 0;
    }

    TreeNode newNode(int key){
        TreeNode temp = new TreeNode();
        temp.val = key;
        temp.child = new ArrayList<>();
        return temp;
    }

    public static boolean isLocked(TreeNode node){

        return node.locked;

    }
    public static boolean lock(TreeNode node){

        if(isLocked(node)){

            return false;
        }

        if(!canLockOrUnlock(node)){
            return false;
        }

        node.locked = true;

        TreeNode parentNode = node.parent;

        while(parentNode != null){

            parentNode.lockedDescendent +=  1;
            parentNode = parentNode.parent;
        }


        return true;

    }

    public static boolean unLock(TreeNode node){
        //in unlock we are only writing not reading

        if(!isLocked(node)){
            return false;
        }
        node.locked = false;
        TreeNode parentNode =node.parent;


        while(parentNode != null){
            parentNode.lockedDescendent -= 1;
            parentNode = parentNode.parent;
        }

        return true;
    }

    public static boolean canLockOrUnlock(TreeNode node){

        if(node.lockedDescendent >0){
            return false;
        }

        TreeNode parentNode = new TreeNode();

        while(parentNode != null){

            if(isLocked(parentNode)){

                return false;

            }
            parentNode = parentNode.parent;

        }

        return true;

    }

    public static void main(String[] args)
    {
        // Creating N-Array Tree
        TreeNode root = new TreeNode();
        root.val=1;
        root.child=new ArrayList<>();
        root.parent= null;

        TreeNode t1 = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t3 = new TreeNode();

        root.child.add(t1);
        t1.val=2;
        t1.child=new ArrayList<>();
        t1.parent= root;

        root.child.add(t2);
        t2.val=3;
        t2.child=new ArrayList<>();
        t2.parent= root;

        root.child.add(t3);
        t3.val=4;
        t3.child=new ArrayList<>();
        t3.parent= root;


        TreeNode t5 = new TreeNode();
        t5.val=6;
        t5.child=new ArrayList<>();
        t5.parent=t1;

        t1.child.add(t5);

        TreeNode  t4 = new TreeNode ();
        t4.val=5;
        t4.child=new ArrayList<>();
        t4.parent=t2;

        t2.child.add(t4);

        // Locking t4 node.
        lock(t4);
        //    Checking if the t4 node is locked.
        System.out.println("t4 node is locked: "+isLocked(t4)+"\n");

        // Locking t2 node.
        lock(t2);
        System.out.println("t2 node is locked: "+isLocked(t2)+"\n");

        // Unlocking t4 node.
        unLock(t4);
        //    Now we should be able to lock the tree.
        lock(t2);
        System.out.println("t2 node is locked: "+isLocked(t2)+"\n");

    }

}
