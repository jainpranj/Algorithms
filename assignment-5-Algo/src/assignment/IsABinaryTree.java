package assignment;

import java.util.Scanner;

public class IsABinaryTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			IsATree isATree = new IsATree();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < k; j++) {
				int root = sc.nextInt();
				sb.append(root);
				isATree.put(root);
			}
			isATree.printPreorder(isATree.root);
			System.out.println(isATree.sb);
			System.out.println(sb);
			if(isATree.sb.toString().equals(sb.toString())){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
			
		}

	}


}
