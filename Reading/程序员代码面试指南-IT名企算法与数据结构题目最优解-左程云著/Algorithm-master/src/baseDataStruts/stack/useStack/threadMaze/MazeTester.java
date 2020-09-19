package stack.useStack.threadMaze;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeTester {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入迷宫的模型文件");
		String fileName = scan.nextLine();
		Maze maze = new Maze(fileName);
		System.out.println(maze);
		MazeSlover solver = new MazeSlover(maze);
		if (solver.travel()) {
			System.out.println("解决");
		} else {
			System.out.println("未解决");
		}
		System.out.println(maze);

	}
}
