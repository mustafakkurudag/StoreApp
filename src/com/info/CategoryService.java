package com.info;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class CategoryService {
    public List<Category> getCategories() {
        Category category1 = new Category(1, "Notebook");
        Category category2 = new Category(2, "Cep Telefonu");

        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);

        return categories;
    }

    public Category getCategoryById(int id) {
        List<Category> categories = getCategories();
        Iterator<Category> it = categories.iterator();

        while (it.hasNext()) {
            Category c = it.next();
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
