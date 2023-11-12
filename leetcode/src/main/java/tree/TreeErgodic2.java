package tree;

import java.util.*;

/**
 * author: chiou
 * createTime: 2023/11/11
 * description: 二叉树的广度优先搜索
 */
public class TreeErgodic2 {
    //二叉树层序遍历Ⅰ
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> two = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> one = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                one.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            two.add(one);
        }
        return two;
    }

    //二叉树层序遍历Ⅱ
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> two = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> one = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                one.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            two.add(one);
        }
        Collections.reverse(two);
        return two;
    }

    //二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        List<Integer> one = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                //当前层的最后一个节点就记录
                if (size == 0) {
                    one.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return one;
    }

    //二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int len = size;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / len);
        }
        return result;
    }

    //N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> two = new ArrayList<>();
        if (root == null) {
            return two;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> one = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                one.add(node.val);
                queue.addAll(node.children);
            }
            two.add(one);
        }
        return two;
    }

    //二叉树的每个树行找最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            int max = tmp.get(0);
            for (Integer i : tmp) {
                if (max < i) {
                    max = i;
                }
            }
            result.add(max);
        }
        return result;
    }

    //填充每个节点的下一个右指针
    public Node2 connect(Node2 root) {
        if (root == null) {
            return root;
        }
        Node2 dummy = root;
        dummy.next = null;
        //入队
        Queue<Node2> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //设置虚拟头节点
            Node2 head = new Node2();
            int size = queue.size();
            while (size-- > 0) {
                Node2 node = queue.poll();
                head.next = node;
                head = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return dummy;
    }

    //树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return len;
    }

    //树的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeErgodic2 ergodic2 = new TreeErgodic2();
        TreeNode root = new TreeNode();
        root.val = 1;
        root.right = new TreeNode(2);
        List<Integer> integers = ergodic2.rightSideView(root);
        System.out.println("integers = " + integers);

        TreeNode root1 = new TreeNode();
        root1.val = 0;
        root1.left = new TreeNode(-2147483648);
        root1.right = new TreeNode(2147483647);
        List<Integer> integers1 = ergodic2.largestValues(root1);
        System.out.println("integers1 = " + integers1);
    }

}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
