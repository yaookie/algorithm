package algorithm.binarySearch.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找算法，数组必须排好序
 */
public class BinarySearchLastEdition {
    public static void main(String[] args) {
        //创建数组
        int arr[] = {0, 2, 5, 11, 11, 11, 222, 234, 1233};
        //调用二分查找方法
        List result = binarySearch(arr, 0, arr.length - 1, 11);
        //将list集合排序输出
        Collections.sort(result);
        System.out.println(result);
    }

    /**
     * 二分查找数据
     * @param arr 数组
     * @param leftIndex 左边下标
     * @param rightIndex 右边下标
     * @param finadVal 要找的数
     * @return list集合存放符合条件的下标
     */
    public static List binarySearch(int arr[], int leftIndex, int rightIndex, int finadVal) {
        int midIndex = (leftIndex + rightIndex) / 2; //获取数组中间下标
        int midVal = arr[midIndex]; //获取中间下标的数据
        //向右查
        if (finadVal > midVal) {
            return binarySearch(arr, midIndex + 1, rightIndex, finadVal);
        } else if (finadVal < midVal) { //向左查
            return binarySearch(arr, leftIndex, midIndex - 1, finadVal);
        } else { //findVal == midVal表示查到了
            List list = new ArrayList();

            //向左扫描
            int temp = midIndex - 1;
            while (true) {
                if (temp < 0 || arr[temp] != finadVal) { //当查找完了或与查找的数据不同就break
                    break;
                }
                list.add(temp); //把符合条件的加进List集合
                temp--;
            }

            list.add(midIndex); //把查找到的中间下标加进list集合

            //向右扫描
            temp = midIndex + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != finadVal) {
                    break;
                }
                list.add(temp); //将找到的下标加进list集合中
                temp++;
            }
            return list;
        }
    }
}
