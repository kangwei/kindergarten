/**
 * ClassName: aa
 * CopyRight: TalkWeb
 * Date: 13-8-27
 * Version: 1.0
 */
package com.titian.cms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
public class ReadConsole1 {
    public static void main(String[] args) {
        Tree t1 = new Tree("01", "name1", "");
        Tree t2 = new Tree("02", "name2", "01");
        Tree t3 = new Tree("03", "name3", "01");
        Tree t4 = new Tree("04", "name4", "02");
        Tree t5 = new Tree("05", "name5", "02");

        List<Tree> list = new ArrayList<Tree>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        showTree(list, t1, 0);

        for (Tree tree : list) {
            if (tree.getId().equals("04")) {
                list.remove(tree);
            }
        }

        System.out.println(list.size());

        for(Iterator<Tree> iterator = list.iterator(); iterator.hasNext();) {
            Tree next = iterator.next();
            if (next.getId().equals("04")) {
                iterator.remove();
            }
        }



        System.out.println(Arrays.toString(list.toArray()));
    }

    //判断字母还是数字
    public static void showTree(List<Tree> list, Tree tree, int deep) {
        String str = "";
        for (int i = 0; i < deep; i++) {
            str += "--";
        }
        System.out.println(str + "" + tree.getName());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPid().equals(tree.getId())) {
                deep++;
                showTree(list, list.get(i), deep);
                deep--;
            }

        }
    }
}

class Tree {
    private String id;
    private String name;
    private String pid;

    public Tree(String id, String name, String pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPid() {
        return pid;
    }

}
