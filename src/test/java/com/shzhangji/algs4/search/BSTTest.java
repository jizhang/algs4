package com.shzhangji.algs4.search;

import org.junit.Assert;
import org.junit.Test;

import com.shzhangji.algs4.util.StringUtils;

public class BSTTest {

    @Test
    public void testClear() {
        BST<String, Integer> bst = new BST<>();
        bst.put("test", 1);
        bst.clear();
        Assert.assertTrue(bst.isEmpty());
    }

    @Test
    public void testTraversal() {

        BST<String, Integer> bst = new BST<>();
        bst.put("c", 1);
        bst.put("a", 2);
        bst.put("d", 3);
        bst.put("b", 4);

        Assert.assertEquals("c a b d", StringUtils.join(bst.preOrder(), " "));
        Assert.assertEquals("a b c d", StringUtils.join(bst.inOrder(), " "));
        Assert.assertEquals("b a d c", StringUtils.join(bst.postOrder(), " "));
        Assert.assertEquals("c a d b", StringUtils.join(bst.levelOrder(), " "));
    }

}
