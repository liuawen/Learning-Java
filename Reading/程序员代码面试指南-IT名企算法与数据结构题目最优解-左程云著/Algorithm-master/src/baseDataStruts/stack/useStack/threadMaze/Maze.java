package stack.useStack.threadMaze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 迷宫 迷宫的初始化，对迷宫的一些基本的操作（判断该点是否有效，） 对迷宫建模成数组，0是墙，1是路
 * 
 * @author Wangxy
 *
 */
public class Maze {
	private static final int TRIED = 2;
	private static final int PATH = 3;
	private int numRows, numCols;
	private int[][] arrayMaze;

	/**
	 * 读取一个配置文件
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public Maze(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		numRows = scan.nextInt();
		numCols = scan.nextInt();
		arrayMaze = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) // 行
			for (int j = 0; j < numCols; j++) // 列
				arrayMaze[i][j] = scan.nextInt();
	}

	public void tryPosition(int row, int col) {
		arrayMaze[row][col] = TRIED;
	}

	public void markPath(int row, int col) {
		arrayMaze[row][col] = PATH;
	}

	public boolean vaild(int row, int col) {// 考虑下标越界的情况
		if (row >= 0 && row < numRows && col >= 0 && row < numCols)
			return arrayMaze[row][col] == 1 ? true : false;
		return false;
	}

	// @Override
	// public String toString() {
	// return "Maze [numRows=" + numRows + ", numCols=" + numCols + ",\n
	// arrayMaze=" + Arrays.toString(arrayMaze)
	// + "]";
	// }

	public int getNumRows() {
		return numRows;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < numRows; i++) { // 行
			for (int j = 0; j < numCols; j++) // 列
				result += "   " + arrayMaze[i][j];
			result += "\n";
		}
		return result;
	}

	public int getNumCols() {
		return numCols;
	}

	public int[][] getArrayMaze() {
		return arrayMaze;
	}

}
