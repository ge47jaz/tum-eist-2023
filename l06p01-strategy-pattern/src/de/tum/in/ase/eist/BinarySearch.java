package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {
    public int performSearch(List<Chapter> book, String chapterToSearch) {
        int low = 0;
        int high = book.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (book.get(mid).getName().compareTo(chapterToSearch) < 0) {
                low = mid + 1;
            } else if (book.get(mid).getName().compareTo(chapterToSearch) > 0) {
                high = mid - 1;
            } else {
                return book.get(mid).getPageNumber();
            }
        }
        return -1;
    }
}
