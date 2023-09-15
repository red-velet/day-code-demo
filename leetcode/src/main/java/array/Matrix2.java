package array;

/**
 * author: chiou
 * createTime: 2023/9/15
 * description: 螺旋矩阵2
 */
public class Matrix2 {
    /**
     * 给你一个正整数 n ，
     * 生成一个包含 1 到 n2 所有元素，
     * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * @param n 正整数 n
     * @return 元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //顺时针转圈的次数
        int loop = 0;
        //循环的开始
        int start = 0;
        int i, j;
        //填充的数字
        int num = 1;
        while (loop++ < n / 2) {
            //从左上到右上
            for (j = start; j < n - loop; j++) {
                matrix[start][j] = num++;
            }
            //从右上到右下
            for (i = start; i < n - loop; i++) {
                matrix[i][j] = num++;
            }
            //从右下到左下
            for (; j >= loop; j--) {
                matrix[i][j] = num++;
            }
            //从左下到左上
            for (; i >= loop; i--) {
                matrix[i][j] = num++;
            }
            start++;
        }
        //填充中心
        if (n % 2 == 1) {
            matrix[start][start] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Matrix2().generateMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
