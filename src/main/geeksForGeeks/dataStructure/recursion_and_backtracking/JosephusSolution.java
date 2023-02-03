package main.geeksForGeeks.dataStructure.recursion_and_backtracking;

public class JosephusSolution {
    public int josephus(int n, int k)
    {
        //Your code here
        if(n==1) return 1;
        else{
            return (josephus(n-1,k)+k-1)%n+1;
        }
    }

    public static void main(String[] args) {
        JosephusSolution obj = new JosephusSolution();
        System.out.println(obj.josephus(5,3));
    }

}
