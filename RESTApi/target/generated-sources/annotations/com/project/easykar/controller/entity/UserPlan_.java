package com.project.easykar.controller.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-26T08:09:18")
@StaticMetamodel(UserPlan.class)
public class UserPlan_ { 

    public static volatile SingularAttribute<UserPlan, Long> duration;
    public static volatile SingularAttribute<UserPlan, Timestamp> endDate;
    public static volatile SingularAttribute<UserPlan, Long> id;
    public static volatile SingularAttribute<UserPlan, Long> userID;
    public static volatile SingularAttribute<UserPlan, Long> pakageID;
    public static volatile SingularAttribute<UserPlan, Timestamp> startDate;
    public static volatile SingularAttribute<UserPlan, String> status;

}