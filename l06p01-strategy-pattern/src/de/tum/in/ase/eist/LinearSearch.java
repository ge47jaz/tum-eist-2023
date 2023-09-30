package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    public int performSearch(List<Chapter> book, String chapterToSearch) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getName().equals(chapterToSearch)) {
                return book.get(i).getPageNumber();
            }
        }
        return -1;
    }
}
