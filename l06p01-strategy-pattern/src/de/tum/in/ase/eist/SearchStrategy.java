package de.tum.in.ase.eist;

import java.util.List;

interface SearchStrategy {
    int performSearch(List<Chapter> book, String chapterToSearch);
}
