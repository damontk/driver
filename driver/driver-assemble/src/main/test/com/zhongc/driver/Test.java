package com.zhongc.driver;


import java.util.*;

/**
 * 项目名称：SPS
 * 类名称：Test
 * 类描述： 保险业务
 * 创建人：zhongchao
 * 创建时间：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class Test {
    public static void main(String[] args) {
        Base b = new Base();
        Base3 base3 = new Base3(new Base1(b));

//        Map<?,String> map = new HashMap<Object, String>();
//        map.put(null,"1");
//        System.out.println(map.get(null));
//        int a = 1 | 2 | 3;
//        int b = 1 | 2;

//        System.out.println(b == a);

        // contains  测试
//        String a = "/index";
//        String b = "index";
//        System.out.println(a.contains(b));

//        Lists bean = new Lists();
//        ArrayList<Bean> list = (ArrayList<Bean>) bean.getlist();
//        for (Bean bean1 : list){
//            System.out.println(bean1.getUser());
//        }
        List<String> list = Arrays.asList("hah", "heih", "1", "2");
//        Collections.sort(list);
//        Collections.sort(list, (String a, String b)-> b.compareTo(a));
//        for (String i : list) {
//            System.out.println(i);
//        }


//        System.out.println(20 % 100);

        //转换位置
//        int a = 2;
//        int b = 3;
//        System.out.println(a^b);
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a + " " + b);

        // 二分算法
//        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81,
//                95, 101};
//        int num = 95;
////        System.out.println(search(srcArray, num));
//        System.out.println(search_(srcArray,0,srcArray.length-1,num));
    }

    static int search_(int[] arrays, int start, int end, int key) {
        int miKey = (end - start) / 2 + start;
        if (arrays[miKey] == key) {
            return miKey;
        }
        if (start >= end) {
            return -1;
        } else if (key < arrays[miKey]) {
            search_(arrays, start, miKey + 1, key);

        } else if (key > arrays[miKey]) {
            search_(arrays, end, miKey - 1, key);
        }

        return -1;
    }


    /**
     * 二分算法
     *
     * @param arrays
     * @param key
     * @return
     */
    static int search(int[] arrays, int key) {
        int miKey = arrays.length / 2;
        if (arrays[miKey] == key) {
            return miKey;
        }
        int start = 0;
        int end = arrays.length - 1;
        while (start <= end) {
            miKey = (end - start) / 2 + start;
            if (key < arrays[miKey]) {
                end = miKey - 1;
            } else if (key > arrays[miKey]) {
                start = miKey + 1;
            } else {
                return miKey;
            }
        }
        return -1;
    }
}

class Bean {
    private String user;
    private String name;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Lists {
    public List<Bean> getlist() {
        List<Bean> list = new ArrayList<Bean>();
//        list.add(null);
//        list=null;
        return null;
    }

    public List<Bean> getlist_() {
        List<Bean> list = new ArrayList<Bean>();
//        list.add(null);
        return list;
    }
}
