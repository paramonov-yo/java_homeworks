package list;

public interface MyQueue<T extends Comparable<T>> extends MyList<T>{
    // TODO сделать реализацию дома. (Реализован в классе MyLinkedList)
    // Отдать первый в очереди элемент и его из очереди удалить
    // Если нет - отдаем Null
    T poll();

}
