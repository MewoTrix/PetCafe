package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //  用户登录验证
    @Select("SELECT * FROM USER WHERE UID = #{uid} AND UPWD = #{upwd}")
    public User findByIdWithPwd(Integer uid, String upwd);

    //  用户注册验证是否id重复
    @Select("SELECT * FROM USER WHERE UID = #{uid}")
    public User findById(Integer uid);

    //  根据用户名查用户
    @Select("SELECT * FROM USER WHERE UNAME = #{uname}")
    public User findByUname(String uname);

    /* 得到所有用户aid */
    @Select("select uid from user")
    public int[] selectAllUid();

    //  数据库添加用户
    @Insert("INSERT INTO USER(uid,upwd,uname) VALUES (#{uid},#{upwd},#{uname})")
    public void insertUser(Integer uid, String upwd, String uname);

    //  用户注销账号
    @Delete("DELETE FROM `user` WHERE uid=${uid}")
    public void deleteUserById(Integer uid);

    @Update("UPDATE USER SET UPWD = #{upwd},UNAME = #{uname} WHERE UID = #{uid}")
    public void updateUserByUpwdAndUname(String upwd, String uname, Integer uid);

    @Update("UPDATE USER SET JSON = #{json} WHERE UID = #{uid}")
    public void updateJson(String json, Integer uid);

    /* 根据uid修改名字和密码 */
    @Update("UPDATE user SET upwd = #{upwd},uname = #{uname} WHERE uid = #{uid}")
    public void updateUserUpwdUnameByUid(String upwd, String uname, Integer uid);

    /* 根据uid修改名字 */
    @Update("UPDATE user SET uname = #{uname} WHERE uid = #{uid}")
    public void updateUserUnamedByUid(String uname, Integer uid);

    /* 根据uid修改密码 */
    @Update("UPDATE user SET upwd = #{upwd} WHERE uid = #{uid}")
    public void updateUserUpwdByUid(String upwd, Integer uid);

}
