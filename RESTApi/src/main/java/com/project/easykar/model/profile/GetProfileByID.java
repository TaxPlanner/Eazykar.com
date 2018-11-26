
package com.project.easykar.model.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileByID implements Serializable
{

    @SerializedName("userID")
    @Expose
    private Long userID;
    private final static Long serialVersionUID = -6055161396787163617L;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

}
