package phaseI_project_package;

public class BinarySearchNames {
	static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            //int res = x.compareTo(arr[m]);
            int res = ((Comparable<String>)x).compareTo(arr[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0) {
                l = m + 1;
            }
 
           // If x is smaller, ignore right half
            else {
                r = m - 1;
            }
        }
 
        return -1;
    }
 
    /*
	// Driver method to test above
    public static void main(String []args)
    {
        String[] arr = { "aaa", "Array Vs Linked List.txt", "Bubble Sort.PNG", "Default keyword example in Interface.png", "dos.png", "dos1.png", "dos2.png", "dos3.png", "Interfaces -Example.png", "Interfaces.txt", "Java Concepts_Techniques_DS.txt", "Linked List Explanation.PNG", "Linked List Explanation_2.PNG", "Linked List Explanation_3.PNG", "Matrix Add Subtract.PNG", "Practice Question- Collections.txt", "Project.txt", "Project1", "ret", "rr", "Selection Sort.PNG", "Sets.png", "Sets1.PNG", "Sets2.png", "Simplilearn Links.txt", "Singly Linked List- Code.txt", "Static keyword example in Interface.PNG", "Unable to Run.PNG", "wq"};
        String x = "rr";
        int result = binarySearch(arr, x);
 
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                              + "index " + result);
        System.out.println(x.compareTo("Matrix Add Subtract.PNG"));
        
        int a= 0 + (28-0) / 2;
        System.out.println(a);
        a= 15 + (28-15) / 2;
        System.out.println(a);
        System.out.println("RR".compareTo("Sets.png"));
    }
    */
}


