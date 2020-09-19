package stack.useStack.threadMaze;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 提供迷宫的解决方案
 * 
 * @author Wangxy
 *
 */
public class MazeSlover {
	private Maze maze;

	public MazeSlover(Maze maze) {
		this.maze = maze;
	}

	/**
	 * 利用栈，跟踪迷宫的遍历， 一个栈存放当前路径， 一个栈存放可用路径，
	 * 
	 * @param maze
	 */
	public boolean travel() {
		boolean done = false;
		int row, column;
		Position pos = new Position();
		// Deque是双端队列，此处作为栈使用
		Deque<Position> stack = new LinkedList<Position>();
		stack.push(pos);
		while (!done && !stack.isEmpty()) {
			pos = stack.pop();
			maze.tryPosition(pos.getX(), pos.getY());// 一次尝试
			if (pos.getY() == maze.getNumRows() - 1 && pos.getX() == maze.getNumCols() - 1) {// x对应列，y对应行
				done = true;
			} else {
				// 左
				// Position l=new Position(
				if (maze.vaild(pos.getX() - 1, pos.getY())) {
					Position l = new Position(pos.getX() - 1, pos.getY());
					stack.push(l);
				}

				// 右
				if (maze.vaild(pos.getX() + 1, pos.getY())) {
					Position l = new Position(pos.getX() + 1, pos.getY());
					stack.push(l);
				}
				// 上
				if (maze.vaild(pos.getX(), pos.getY() - 1)) {
					Position l = new Position(pos.getX(), pos.getY() - 1);
					stack.push(l);
				}
				// 下
				if (maze.vaild(pos.getX(), pos.getY() + 1)) {
					Position l = new Position(pos.getX(), pos.getY() + 1);
					stack.push(l);
				}
			}
		}
		return done;
	}
}
