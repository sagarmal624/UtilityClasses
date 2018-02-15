package com.sagarandcompany;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("sagar");
        list.add("rahul");
        list.add("sagar");
        list.add("sagar");
        CollectionUtils.removeDuplicate(list);
        list.forEach(System.out::println);
    }
}
