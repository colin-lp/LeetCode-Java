import java.util.*;

public class Solution {

    //1. 2d二分 2. 遍历获取输出 3. 判断是否镜像二叉树

    public static void main(String[] args) {
        Map<String, Object> mapa = new HashMap<>();
        Map<String, Object> mapb = new HashMap<>();
        Map<String, Object> mapc = new HashMap<>();
        mapc.put("c",0);
        Object[] o=new Object[3];
        o[0]="v";
        o[1]=2;
        o[2]=mapc;
        mapb.put("b",o);
        mapa.put("a",mapb);
        mapa.put("d",new Object[]{1,null,3});
        Set<String> s=showMap(mapa);
        System.out.println(s);
    }

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
    public static Set<String> showMap(Map<String, Object> map) {
        //TODO your code goes here...
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        scanAndAddShowMap(map, set, list,true);
        return set;
    }
    public static void scanAndAddShowMap(Map<String, Object> map, Set<String> set, List<String> list,boolean first) {
        for (Map.Entry<String, Object> m : map.entrySet()) {
            if (m.getValue() == null) {
                set.add(String.join("", list) + m.getKey() + " = null");
            } else if (m.getValue() instanceof Number) {
                set.add(String.join("", list) + m.getKey() + " = " + m.getValue());
            } else if (m.getValue() instanceof String) {
                set.add(String.join("", list) + m.getKey() + " = " + m.getValue().toString());
            } else if (m.getValue() instanceof Object[]) {
                if(!first) {
                    list.add(".");
                }
                Object[] o=(Object[]) m.getValue();
                for (int i = 0; i < o.length; i++) {
                    if (o[i] == null) {
                        set.add(String.join("", list) + m.getKey() + "[" + i + "]" + " = null");
                    } else if (o[i] instanceof Number) {
                        set.add(String.join("", list) + m.getKey() + "[" + i + "]" + " = " + o[i].toString());
                    } else if (o[i] instanceof String) {
                        set.add(String.join("", list) + m.getKey() + "[" + i + "]" + " = " + o[i].toString());
                    } else {
                        list.add(m.getKey() + "[" + i + "]");
                        String temp=m.getKey();
                        scanAndAddShowMap((Map<String, Object>)o[i], set, list,false);
                        while(!list.isEmpty() && !list.get(list.size()-1).equals(temp)){
                            list.remove(list.size() - 1);
                        }
                        if(!list.isEmpty()) {
                            list.remove(list.size() - 1);
                        }
                    }
                }
            } else {
                if(first){
                    list.add(m.getKey());
                }else {
                    list.add("." + m.getKey());
                }
                String temp=m.getKey();
                scanAndAddShowMap((Map<String, Object>) m.getValue(), set, list,false);
                while(!list.isEmpty() && !list.get(list.size()-1).equals(temp)){
                    list.remove(list.size() - 1);
                }
                if(!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isTreeSymmetric(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return left.val==right.val && dfs(left.left,right.right) && dfs(left.right,right.left);
    }

}
