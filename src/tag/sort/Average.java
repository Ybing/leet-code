package tag.sort;

/**
 * @Description: 去掉最高工资和最低工资后的平均值
 * @Author: 杨亚兵
 * @Date: 2020/7/2 13:57
 */
public class Average {

    /**
     * 思路：
     * 用两个变量动态记录最大最小值，全部值相加后减掉即可
     *
     * @param salary 员工工资数组（每个数均不相等）
     * @return 去掉最该和最低后的平均值
     */
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, total = 0;
        int count = salary.length;
        for (int item:salary){
            if (item > max){
                max = item;
            }
            if (item < min){
                min = item;
            }
            total += item;
        }
        //注意：此处必须要类型转换，否则int型除以int型将会得到int型，即整数，小数部分将被抛弃
        return (double)(total - max - min)/(count - 2);
    }

    public static void main(String[] args) {
        Average average = new Average();
        int[] salary = {48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        System.out.println(average.average(salary));
    }
}
