package com.springboot.provider;

import org.springframework.stereotype.Component;

import static org.apache.ibatis.jdbc.SelectBuilder.*;

@Component
public class UserSqlProvider {

    private static final String TABLE_NAME = "user";

    public String getSql() {
        BEGIN();
        SELECT("user_name, user_password");
        FROM(TABLE_NAME);
            WHERE("id = #{id}");
        return SQL();
    }
}
