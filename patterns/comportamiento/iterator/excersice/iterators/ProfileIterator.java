package patterns.comportamiento.iterator.excersice.iterators;

import patterns.comportamiento.iterator.excersice.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
