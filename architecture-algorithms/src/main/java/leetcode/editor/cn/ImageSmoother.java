package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的 平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 * <p>
 * <p>
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出: [[137,141,137],[141,138,141],[137,141,137]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.66
 * 6667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 1
 * 38
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 * <p>
 * Related Topics 数组 矩阵 👍 155 👎 0
 */
public class ImageSmoother {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            if (img == null || img.length == 0) return new int[0][0];
            int height = img.length;
            int width = img[0].length;
            int[][] res = new int[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    res[y][x] = avg(img, height, width, x, y);
                }
            }
            return res;
        }

        int avg(int[][] img, int height, int width, int x, int y) {
            int[][] directions = new int[][]{
                    {0, 0}, {0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}, {1, -1}, {-1, 1}
            };
            int sum = 0;
            int cnt = 0;
            for (int[] direction : directions) {
                int x1 = x + direction[1];
                int y1 = y + direction[0];
                // 注意x/y和height、weight的对应关系
                if (x1 >= 0 && y1 >= 0 && y1 < height && x1 < width) {
                    sum += img[y1][x1];
                    cnt++;
                }
            }
            return sum / cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}
        };
        System.out.println(Arrays.deepToString(new Solution().imageSmoother(input)));
    }
}