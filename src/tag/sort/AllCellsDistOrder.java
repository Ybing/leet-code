package tag.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 距离顺序排列矩阵单元格
 * @Author: 杨亚兵
 * @Date: 2020/7/4 2:12 下午
 */
public class AllCellsDistOrder {
    /**
     * 思路：
     * 桶排序
     *
     * @param R  单元格行数
     * @param C  单元格列数
     * @param r0 目标坐标横坐标
     * @param c0 目标坐标纵坐标
     * @return 单元格坐标，按距离（r0,c0）的距离从小到达顺序排列
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> map = new HashMap<>(16);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = dist(i, j, r0, c0);
                if (map.containsKey(dist)) {
                    List<int[]> items = map.get(dist);
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    items.add(item);
                } else {
                    List<int[]> items = new LinkedList<>();
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    items.add(item);
                    map.put(dist, items);
                }
            }
        }
        int[][] result = new int[R * C][2];
        int num = 0;
        for (Map.Entry<Integer, List<int[]>> mapItem : map.entrySet()) {
            List<int[]> listValue = mapItem.getValue();
            for (int[] item : listValue) {
                result[num][0] = item[0];
                result[num][1] = item[1];
                num++;
            }
        }
        return result;
    }

    private int dist(int r1, int c1, int r0, int c0) {
        return Math.abs(r1 - r0) + Math.abs(c1 - c0);
    }

    public static void main(String[] args) {
        AllCellsDistOrder allCellsDistOrder = new AllCellsDistOrder();
        int[][] result = allCellsDistOrder.allCellsDistOrder(1, 2, 0, 0);
        System.out.println(result);
    }
}
