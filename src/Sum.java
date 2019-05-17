/**
 * @Description TODO
 * @Author: sain
 * @Date 19-5-15 上午11:03 星期三
 * ================================================================================
 * 温馨提示
 * 代码千万行，注释第一行。
 * 命名不规范，同事泪两行。
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) { // 关注函数的宏观语义  , 数组要自己构造递归, 链表则是天然的递归结构
        if (l == arr.length) { // 求解最基本的问题,表示问题达到何等规模,可直接求解
            return 0;
        }

        return arr[l] + sum(arr, l + 1); //把原问题转化成更小的问题
    }



    public static void main(String[] args) {
        int[] data = {1,2,3,4};
        System.out.println(sum(data));
    }
}
