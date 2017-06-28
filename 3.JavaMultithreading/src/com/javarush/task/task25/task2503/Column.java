package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable{
    Customer("Customer") {
        @Override
        public String getColumnName() {
            return Customer.columnName;
        }

        @Override
        public boolean isShown() {

            int num = Column.Customer.ordinal();
           if(realOrder[num] != -1){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public void hide() {
            int num = Column.Customer.ordinal();
            realOrder[num] = -1;
        }
    },
    BankName("Bank Name") {
        @Override
        public String getColumnName() {
            return BankName.columnName;
        }

        @Override
        public boolean isShown() {

            int num = Column.BankName.ordinal();
            if(realOrder[num] != -1){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public void hide() {
            int num = Column.BankName.ordinal();
            realOrder[num] = -1;
        }
    },
    AccountNumber("Account Number") {
        @Override
        public String getColumnName() {
            return AccountNumber.columnName;
        }

        @Override
        public boolean isShown() {

            int num = Column.AccountNumber.ordinal();
            if(realOrder[num] != -1){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public void hide() {
            int num = Column.AccountNumber.ordinal();
            realOrder[num] = -1;
        }
    },
    Amount("Available Amount") {
        @Override
        public String getColumnName() {
            return Amount.columnName;
        }

        @Override
        public boolean isShown() {

            int num = Column.Amount.ordinal();
            if(realOrder[num] != -1){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public void hide() {
            int num = Column.Amount.ordinal();
            realOrder[num] = -1;
        }
    };

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
//        List<Column> result = new LinkedList<>(); //код рабочий но валидатор не принимает
//        Column[] columns = Column.values();
//        List<Column> main = new ArrayList<>();
//        for(int i = 0; i < columns.length; i++){
//            main.add(columns[i]);
//        }
//
//        for(int i = 0; i < realOrder.length;i++ ){
//
//            if(realOrder[i] != -1){
//                result.add(main.get(realOrder[i])); //last err sort
//            }
//            else{
//                main.remove(i);
//
//            }
//        }
//
//        return result;
//    }
        List<Column> result = new ArrayList<>();
        Map<Integer, Column> map = new TreeMap<>();
        for (int i = 0; i < realOrder.length; i++) {
            map.put(realOrder[i], Column.values()[i]);
        }

        for (Map.Entry<Integer, Column> entry : map.entrySet()) {
            if (entry.getKey() != -1)
                result.add(entry.getValue());
        }
        return result;
    }
}
