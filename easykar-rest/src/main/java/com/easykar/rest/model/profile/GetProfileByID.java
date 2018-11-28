
package com.easykar.rest.model.profile;

import java.io.Serializable;

public class GetProfileByID implements Serializable
{

    private Long userID;
    private final static Long serialVersionUID = -6055161396787163617L;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

}
