package other.unionFind;

/**并查集
 * Created by Dell on 2017-08-07.
 */
public class UnionFind {
    private int[] s = null;

    public UnionFind(int num) {
        s = new int[num];
        for (int i = 0; i < num; i++)
            s[i] = -1;
    }
    public void union(int root1, int root2) {
        if (s[root2] < s[root1])// root2 is deeper
            s[root1] = root2;
        else {
            if (s[root2] == s[root1])//Update height if same
                s[root1]--;
            s[root2] = root1;//Make root1 new root
        }
    }
    public int find(int x){//
        if(s[x]<0)
            return x;
        else
            return s[x]=find(s[x]);
    }
}
