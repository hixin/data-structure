package heap;

/**
 * @Description TODO
 * @Author: sain
 * @Date 19-5-17 下午6:09 星期五
 * ================================================================================
 * 温馨提示
 * 代码千万行，注释第一行。
 * 命名不规范，同事泪两行。
 */
public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length -1); i >=0; i--) {
            siftUp(i);
        }

    }


    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {

    }
}
