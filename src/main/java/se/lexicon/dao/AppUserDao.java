package se.lexicon.dao;

import se.lexicon.AppUsers;

import java.util.Collection;

public interface AppUserDao {
    AppUsers persist(AppUsers appUser);
    AppUsers findByUsername(String username);
    Collection<AppUsers> findAll();
    void remove(String username);
}
