/**
二叉查找树

如果该二叉树是二叉查找树，那么求解LCA十分简单。
基本思想为：从树根开始，该节点的值为t，如果t大于t1和t2，说明t1和t2都位于t的左侧，所以它们的共同祖先必定在t的左子树中，从t.left开始搜索；如果t小于t1和t2，说明t1和t2都位于t的右侧，那么从t.right开始搜索；如果t1<t< t2，说明t1和t2位于t的两侧，那么该节点t为公共祖先。
如果t1是t2的祖先，那么应该返回t1的父节点；同理，如果t2是t1的祖先，应该返回t2的父节点。
*/
public int query(Node t1, Node t2, Node t) {
  	int left = t1.value;
  	int right = t2.value;
  	Node parent = null;

  	if (left > right) {
  		int temp = left;
  		left = right;
  		right = temp;
  	}

  	while (true) {
  		if (t.value < left) {

  			parent = t;
  			t = t.right;

  		}else if (t.value > right) {

  			parent = t;
  			t = t.left;

  		} else if (t.value == left || t.value == right) {

  			return parent.value;

  		} else {

  			return t.value;

  		}
  	}
}
