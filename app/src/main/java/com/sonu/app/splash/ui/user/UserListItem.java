package com.sonu.app.splash.ui.user;

import com.sonu.app.splash.ui.list.ListItem;
import com.sonu.app.splash.ui.list.ListItemTypeFactory;
import com.sonu.app.splash.ui.userdescription.UserDescription;

/**
 * Created by amanshuraikwar on 20/12/17.
 */

public class UserListItem extends ListItem<UserOnClickListener> {

    private UserDescription userDescription;

    public UserListItem(UserDescription userDescription) {
        this.userDescription = userDescription;
    }

    public UserDescription getUserDescription() {
        return userDescription;
    }

    @Override
    public int type(ListItemTypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
