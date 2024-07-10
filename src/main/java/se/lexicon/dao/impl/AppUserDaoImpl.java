package se.lexicon.dao.impl;

import se.lexicon.AppUsers;
import se.lexicon.dao.AppUserDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AppUserDaoImpl implements AppUserDao {
    private final Map<String, AppUsers> appUsers = new HashMap<>();

    @Override
    public AppUsers persist(AppUsers appUser) {
        appUsers.put(appUser.getUsername(), appUser);
        return appUser;
    }

    @Override
    public AppUsers findByUsername(String username) {
        return appUsers.get(username);
    }

    @Override
    public Collection<AppUsers> findAll() {
        return new ArrayList<>(appUsers.values());
    }

    @Override
    public void remove(String username) {
        appUsers.remove(username);
    }
}
