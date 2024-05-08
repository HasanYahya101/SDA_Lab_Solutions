abstract class SortAlgorithm {
    public abstract void compare(int[] arr, int i, int j);
    public abstract void swap(int[] arr, int i, int j);

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                compare(arr, j, j + 1);

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}

class BubbleSort extends SortAlgorithm {
    @Override
    public void compare(int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            System.out.println("Comparing " + arr[i] + " and " + arr[j] + " - Swapping " + arr[i] + " and " + arr[j]);
            swap(arr, i, j);
        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
    
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    
    }
}

class SelectionSort extends SortAlgorithm {
    @Override
    public void compare(int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            System.out.println("Comparing " + arr[i] + " and " + arr[j] + " - Swapping " + arr[i] + " and " + arr[j]);
            swap(arr, i, j);
        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class l227971_Lab11_q2 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};

        SortAlgorithm bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

        SortAlgorithm selectionSort = new SelectionSort();
        selectionSort.sort(arr);
    }
}