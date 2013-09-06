/**
 * ClassName: aa
 * CopyRight: TalkWeb
 * Date: 13-8-27
 * Version: 1.0
 */
package com.titian.cms;

import com.opensoft.common.exception.AppException;
import com.opensoft.common.utils.TreeCreator;
import com.titian.core.domain.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
public class ReadConsole1 {
    static int count = 0;
    static int count1 = 0;

    public static void main(String[] args) {

        Tree t1 = new Tree("01", "name1", "");
        Tree t2 = new Tree("02", "name2", "01");
        Tree t3 = new Tree("03", "name3", "01");
        Tree t4 = new Tree("04", "name4", "02");
        Tree t5 = new Tree("05", "name5", "02");
        Tree t6 = new Tree("06", "name6", "16");
        Tree t7 = new Tree("07", "name6", "08");
        Tree t8 = new Tree("08", "name6", "09");
        Tree t9 = new Tree("09", "name6", "10");
        Tree t10 = new Tree("10", "name6", "11");
        Tree t11 = new Tree("11", "name6", "12");
        Tree t12 = new Tree("12", "name6", "13");
        Tree t13 = new Tree("13", "name6", "14");
        Tree t14 = new Tree("14", "name6", "15");
        Tree t15 = new Tree("15", "name6", "16");
        Tree t16 = new Tree("16", "name6", "17");
        Tree t17 = new Tree("17", "name6", "18");
        Tree t18 = new Tree("18", "name6", "19");
        Tree t19 = new Tree("19", "name6", "20");
        Tree t20 = new Tree("20", "name6", "21");
        Tree t21 = new Tree("21", "name6", "22");
        Tree t22 = new Tree("22", "name6", "23");
        Tree t23 = new Tree("23", "name6", "05");

        List<Tree> list = new ArrayList<Tree>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);
        list.add(t10);
        list.add(t11);
        list.add(t12);
        list.add(t13);
        list.add(t14);
        list.add(t15);
        list.add(t16);
        list.add(t17);
        list.add(t18);
        list.add(t19);
        list.add(t20);
        list.add(t21);
        list.add(t22);
        list.add(t23);
        long start = System.currentTimeMillis();
        showTree1(list, t1, 0);
        System.out.println("循环次数===" + count + "， 时间：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        showTree(list, t1, 0);
        System.out.println("循环次数===" + count1 + "， 时间：" + (System.currentTimeMillis() - start));
       /* try {
            Tree tree = TreeCreator.createTree(list, t1, "id", "pid", "children");
            System.out.println(tree.toString());
        } catch (AppException e) {
            e.printStackTrace();
        }
*/
        Menu menu = new Menu();
        menu.setFunctionId(1);
        menu.setParentId(0);
        menu.setFunctionName("父节点");
        Menu menu1 = new Menu();
        menu1.setFunctionId(2);
        menu1.setParentId(1);
        menu1.setFunctionName("孩子节点");
        Menu root = new Menu();
        root.setFunctionId(0);
        try {
            root = TreeCreator.createTree(com.opensoft.common.utils.CollectionUtils.asList(menu, menu1), root, "functionId", "parentId", "children");
        } catch (AppException e) {
            e.printStackTrace();
        }
        System.out.println(root.toString());
    }

    //判断字母还是数字
    public static void showTree(List<Tree> list, Tree tree, int deep) {
        String str = "";
        for (int i = 0; i < deep; i++) {
            str += "--";
        }
        System.out.println(str + "" + tree.getName());
        for (int i = 0; i < list.size(); i++) {
            count1++;
            if (list.get(i).getPid().equals(tree.getId())) {
                deep++;
                showTree(list, list.get(i), deep);
                deep--;
            }

        }
    }

    public static void showTree1(List<Tree> list, Tree tree, int deep) {
        String str = "";
        for (int i = 0; i < deep; i++) {
            str += "--";
        }
        System.out.println(str + "" + tree.getName());

        List<Tree> rest = new ArrayList<Tree>();
        List<Tree> children = new ArrayList<Tree>();
        for (Tree tree1 : list) {
            count++;
            if (tree.getId().equals(tree1.getPid())) {
                children.add(tree1);
            } else {
                rest.add(tree1);
            }
        }

        for (Tree child : children) {
            deep++;
            showTree1(rest, child, deep);
            deep--;
        }
    }
}


