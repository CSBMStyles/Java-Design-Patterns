package patterns.comportamiento.iterator.excersice.social;

import patterns.comportamiento.iterator.excersice.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
