public class HeapSort {
  public static void heapSort(int arr[]) {
      int n = arr.length;

      // Построение max-кучи (первый шаг сортировки)
      for (int i = n / 2 - 1; i >= 0; i--) {
          heapify(arr, n, i);
      }

      // Извлечение элементов из кучи по одному (сортировка)
      for (int i = n - 1; i >= 0; i--) {
          // Обмен корня (максимального элемента) с последним элементом
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;

          // Вызов heapify на уменьшенной куче
          heapify(arr, i, 0);
      }
  }

  // Преобразование поддерева с корнем i в max-кучу
  static void heapify(int arr[], int n, int i) {
      int largest = i; // Инициализация наибольшего элемента как корня
      int left = 2 * i + 1; // Левый потомок
      int right = 2 * i + 2; // Правый потомок

      // Если левый потомок больше корня
      if (left < n && arr[left] > arr[largest]) {
          largest = left;
      }

      // Если правый потомок больше корня
      if (right < n && arr[right] > arr[largest]) {
          largest = right;
      }

      // Если наибольший элемент не корень
      if (largest != i) {
          int swap = arr[i];
          arr[i] = arr[largest];
          arr[largest] = swap;

          // Рекурсивно преобразуем поддерево
          heapify(arr, n, largest);
      }
  }

  public static void main(String args[]) {
      int arr[] = {12, 11, 13, 5, 6, 7};
      int n = arr.length;

      heapSort(arr);

      System.out.println("Отсортированный массив:");
      for (int i = 0; i < n; i++) {
          System.out.print(arr[i] + " ");
      }
  }
}
