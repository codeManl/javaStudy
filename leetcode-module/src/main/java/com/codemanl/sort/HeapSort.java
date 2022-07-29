package com.codemanl.sort;

import java.util.Arrays;

/**
 * @author 刘乐乐
 * @description 堆排序算法
 * @date 2021/10/14 20:08
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        sort(arr);
    }

    /**
     * 进行堆排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        int temp = 0;
        // 将无序序列构建成堆，根据升序降序来决定大顶堆和小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            getMaxNode(arr, i, arr.length);
        }
        // 将堆顶元素与末尾元素交换，将大顶堆的顶点沉到数组末端，然后剩余元素重新调整成一个新的大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            getMaxNode(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将以i在数组中对应的非叶子节点为根节点的树调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      最后一个非叶子节点在数组的坐标
     * @param length 表示要对length个元素进行调整，这里length ≠ arr.length
     */
    public static void getMaxNode(int[] arr, int i, int length) {
        int temp = arr[i];

        // k指的是i结点的左子节点 每次循环后k变为k节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 左子节点小于右子节点时，将k从左子节点指向右子节点  k+1 < length是因为循环条件是k要小于length
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 当(左/右)子节点大于i节点时,将较大子节点的值赋值给父节点，同时将k指向i
            if (arr[k] > temp) {
                arr[i] = arr[k];
                // 修改k的值向下调整
                i = k;
            } else { // 根节点大于两个子节点
                break;
            }
        }
        // 将i节点的值与  i为堆顶节点的大顶堆的最小值交换位置
        arr[i] = temp;
    }

}
