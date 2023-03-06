import java.util.*;

public class ShortestDistance {
    public static void main(String[] args) {
        int[][] grid = new int[11][11];
        int[] start = new int[2];
        String directions = "";
        
        Scanner scanner = new Scanner(System.in);
        
        // Take start point as input
        System.out.print("Enter start point as x and y coordinate (separated by a space): ");
        start[0] = scanner.nextInt();
        start[1] = scanner.nextInt();
        
        // Take directions as input
        System.out.print("Enter directions: ");
        directions = scanner.next();
        
        scanner.close();
        
        // Calculate end point
        int[] end = new int[2];
        for (char c : directions.toCharArray()) {
            switch (c) {
                case 'N':
                    end[1]++;
                    break;
                case 'S':
                    end[1]--;
                    break;
                case 'E':
                    end[0]++;
                    break;
                case 'W':
                    end[0]--;
                    break;
            }
        }
        end[0] += start[0];
        end[1] += start[1];
        
        
        
        double dist=Math.pow((end[0] - start[0]),2)+Math.pow((end[1] - start[1]),2);
        dist=Math.sqrt(dist);
        System.out.println("Shortest distance between start and end point: " + dist);
    }
}
