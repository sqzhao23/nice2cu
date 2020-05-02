package com.sqzhao.nice2cu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: nice2cu
 * @description: 单元测试类
 * @author: sqzhao
 * @create: 2020-04-25 14:13
 **/
public class TestMain {
    public static void main(String args[]){
        //准备用户测试数据：

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/nice2cu?useUnicode=true&characterEncoding=utf8",
                        "root", "admin");
                Statement s = c.createStatement();
        )
        {
//            for (int i = 1; i <=10 ; i++) {
//                String sqlFormat = "insert into user values (null, 'sqzhaocn@foxmail.com', '赵诗秋', '12345678', '男'," +
//                        " '我就是本条街最靓的仔！', '我的头像', '陕西安康')";
//                String sql = String.format(sqlFormat, i);
//                s.execute(sql);
//            }

            String sql = "insert into chat values (null, 1 , '狗屎', 1, 10, '2020-05-06 20:10')";
            s.execute(sql);
            System.out.println("已经成功插入数据");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
