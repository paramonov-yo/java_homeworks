package list;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>, MyQueue<T> {
    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private static int size = 0;

    @Override
    public void add( T item ) {
        // Создаем новый элемент
        ListItem<T> internalItem = new ListItem<>();
        internalItem.value = item;
        //Если голова ещё не задана - то её присваиваем новому элементу
        if ( head == null ) {
            head = internalItem;
        }
        // Хвост заменяется на новый
        ListItem<T> tempTail = tail;
        tail = internalItem;
        // Связываем старый хвост и новый хвост между собой
        if ( tempTail != null ) {
            tempTail.next = tail;
        }
        tail.prev = tempTail;
        // Двигаемся по счетчику
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get( int index ) {
        // TODO Ошибка если индекс больше размера (готово)
        if (index >= size) {
            throw new MyLinkedListException();
        }
        // TODO Если индекс > size/2 - то перебираем от tail (готово)
        int currPosition;
        T result = null;

        if (index > size/2) {
            currPosition = size - 1;
            ListItem<T> item = tail;
            // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
            while (result == null && currPosition < size) {
                if (index == currPosition) {
                    result = item.value;
                }
                item = item.prev;
                currPosition--;
            }
        } else {
            currPosition = 0;
            ListItem<T> item = head;
            // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
            while (result == null && currPosition < size) {
                if (index == currPosition) {
                    result = item.value;
                }
                item = item.next;
                currPosition++;
            }
        }
        return result;
    }

    @Override
    public boolean remove( T item ) {
        ListItem<T> listItem = head;
        ListItem<T> anotherList;
        boolean result = false;
        T removeValue = null;
        int index = 0;
        while(index < size) {
            if (listItem.value.equals(item)){
                removeValue =  listItem.value;
                System.out.println("Удаляем значение: " + listItem.value);
                //Удаление "хвостового" значения
                if (index == size - 1) {
                    listItem.value = null;
                    tail = listItem.prev;
                    //System.out.println("listItem.next.value: " + listItem.next.value);
                    //System.out.println("listItem.value: " + listItem.value);
                    result = true;
                    break;
                }
                //Смещаем позиции элементов в списке в сторону удаленного объекта
                while (index < size) {
                    anotherList = listItem;
                    listItem.value = anotherList.next.value;
                    //System.out.println("listItem.value " + listItem.value);
                    if (index != size - 2) {
                        index ++;
                        listItem = listItem.next;
                    }
                    else if (index == size - 2){
                        tail = listItem;
                        listItem = listItem.next;
                        listItem.value = null;
                        //System.out.println("listItem.value (last)" + listItem.value);
                        result = true;
                        break;
                    }
                }
                break;
            }
            index ++;
            listItem = listItem.next;
        } if (removeValue == null) {
            System.out.println("Значение введенного элемента не найдено среди существующих.");
            result = false;
        } if (result) {
            size--;
        }
        return result;
    }

    @Override
    //TODO: Реализовать метод poll (готово)
    public T poll() {
        ListItem<T> listItem = head;
        T result;
        if (size != 0) {
            if (listItem.value == null) {
                result = null;
            } else {
                result = listItem.value;
                listItem.value = null;
                head = listItem.next;
                size--;
            }
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public void sort() {
        boolean wasChange = true;
        while ( wasChange ){
            wasChange = false;
            ListItem<T> first = head;
            ListItem<T> second = head.next;
            while ( second != null ){
                wasChange = wasChange || compareAndReplaceItem(first, second);
                first = second;
                second = second.next;
            }
        }
    }

    @Override
    //TODO: Реализовать новый метод сортировки (НЕ(!!!) готово)
//Реализована пользовательская сортировка для частного случа (числовое значение).

    public void sortHomeWorkNum() {
        ListItem sortingValue1;
        int num1;
        int num2;
        int num3;
        int index;
        int iterator = 0;
        while(iterator < size) {
            index = 0;
            sortingValue1 = head;
            while (index < size - 1) {
                num1 = (int) sortingValue1.value;
                num2 = (int) sortingValue1.next.value;
                if (index == 0) {
                    if (num1 > num2) {
                        sortingValue1.value = num2;
                        sortingValue1.next.value = num1;
                    }
                } else if (index == size - 1) {
                    num2 = (int) sortingValue1.value;
                    num3 = (int) sortingValue1.prev.value;
                    if (num2 < num3) {
                        sortingValue1.value = num3;
                        sortingValue1.prev.value = num2;
                    }
                } else if (num1 > num2) {
                    sortingValue1.value = num2;
                    sortingValue1.next.value = num1;
                }
                sortingValue1 = sortingValue1.next;
                index++;
            }
            iterator ++;
        }
        //TODO: Сделать подход для проверки объекта (число/строка), затем сортировать в зависимости от этого
    }

    //Реализована пользовательская сортировка для значений типа T.
    @Override
    public void sortHomeWorkT() {
        ListItem<T> list = head;
        //if (list.value.compareTo(list.next.value)){
        //TODO: ???
        //}
    }

    private boolean compareAndReplaceItem( ListItem<T> first, ListItem<T> second ) {
        if (second.value.compareTo( first.value ) < 0){
            second.prev = first.prev;
            if (second.prev == null){
                head = second;
            }
            first.next = second.next;
            if (first.next == null){
                tail = first;
            }
            second.next = first;
            first.prev = second;
            return true;
        }
        return false;
    }

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }
}