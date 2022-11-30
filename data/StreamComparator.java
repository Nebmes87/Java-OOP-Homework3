package data;

import java.util.Comparator;

public class StreamComparator implements Comparator<StudentsGroup>{
    @Override
    public int compare(StudentsGroup aGroup, StudentsGroup bGroup) {
        return Integer.compare(aGroup.getSizeOfGroup(),bGroup.getSizeOfGroup());
    }
}