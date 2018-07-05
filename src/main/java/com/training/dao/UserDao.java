package com.training.dao;

import com.training.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 2018/7/1.
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public User getUserByName(String name){

        String sql  = "select * from t_user where name = ?";

        User u = jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper());

        return  u;
    }

    /**
     * 通过姓名查询该用户有哪些权限
     * @param name
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthentyByName(String name){

        String sql  = "select r.name" +
                " from t_user u" +
                " left join authorities a on a.u_id  = u.id" +
                " left join t_role r on r.id = a.r_id" +
                " where u.name = ?";

        return jdbcTemplate.query(sql, new Object[]{name}, new RowMapper<SimpleGrantedAuthority>() {
            @Override
            public SimpleGrantedAuthority mapRow(ResultSet resultSet, int i) throws SQLException {
                String roleName = "ROLE_" + resultSet.getString("name");

                return new SimpleGrantedAuthority(roleName);
            }
        });
    }


    class UserMapper implements  RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setCreateTitme(resultSet.getTimestamp("createTime"));
            return user;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
