/**
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Hide Tags Hash Table Math

 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 * 做法：
 * 建立一个迭代的for循环，使之每两个点能循环到
 * 如果以点i为外循环，点j为内循环即 Kij1的斜率和点j内比如KJn相等，
 * 则点i，j1和jn在一条直线上。有公共点i
 * 每次清空map，使之数据位一个公共点有关的相关数据
 * 注意：1. 两点x值相等，即与x轴垂直，k为无限大
 *       2. double值(2-3)/(3-3) = -0.0有负号，需要+0.0去掉负号
 *       3. 相同点，计算duplicate的次数，并且计算max points时分别加上此点
 *         （此点和点i为相同点，当计算i的时候，当然要加入此点）
 */
public class Solution {
    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0){
            return 0;
        }
        if (points.length <= 2){
            return points.length;
        }
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0; i < points.length; i++){
            int dup = 1;
            map.clear();
            for (int k = i + 1; k < points.length; k++){
                /**1.重复的点
                 * 两个点重复节点。即k = i。由于当前计算任何个k点
                 * 和i点组成直线上包含的最大点数，所以，在最后计算max的时候
                 * 要把dup算在内**/
                if (points[i].x == points[k].x && points[i].y == points[k].y){
                    dup++;
                    continue;
                }
                //如果两点和x轴垂直，则斜率k无限大。否则，求出斜率，精确到double
                // (2-3)/(3-3) = -0.0有负号。避免带负号。集体加上0.0
                double key = points[i].x - points[k].x == 0 ?
                    Integer.MAX_VALUE : 0.0 + (double)(points[i].y - points[k].y) / (double)(points[i].x - points[k].x);
                /**
                 * 2. map所放的点为不同的点
                 *    如果存在key，value + 1
                 *    不存在，创建新的，赋值1
                 **/
                map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);

            }
            /**III. 计算赋值
             * 3-1
             * 1)如果是相同点，无key
             * 当有n个点都是相同的点。我们只是continue，
             * 累加了duplicate的个数，但是
             * 没有没有两个不同的点放入map内。所以
             * 直接return dup
             * 2) (1,1) (1,0)
             * 当此例子的时候，i=1的时候，由于map已经清空，所以size=0，
             * 如果直接return dup,返回值为1
             * 但是，在i = 0的时候，我们得出了max = 2
             * 所以这里，我们要返回dup和max中的最大值
             */
            if (map.values().size() == 0){
                return Math.max(max, dup);
            }
            /**3-2 不同点，有key，加上duplicate
             * */
            for (int value : map.values()){
                max = Math.max(max, value + dup);
            }
        }
        return max;
    }
}
