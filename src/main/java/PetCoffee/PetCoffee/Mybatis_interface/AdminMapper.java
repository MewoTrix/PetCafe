package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.Admin;
import PetCoffee.PetCoffee.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    //  管理员登录验证
    @Select("SELECT * FROM ADMIN WHERE AID = #{aid} AND APWD = #{apwd}")
    public Admin findByIdWithPwd(Integer aid, String apwd);

    /* 根据aid查询管理员 */
    @Select("select * from admin where aid = #{aid}")
    public Admin findById(Integer aid);

    /* 根据aname查询管理员 */
    @Select("select * from admin where aname = #{aname}")
    public Admin findByAname(String aname);

    /* 得到所有管理员aid */
    @Select("select aid from admin")
    public int[] selectAllAid();

    //  数据库添加管理员
    @Insert("insert into admin(aid,apwd,aname) values (#{aid},#{apwd},#{aname})")
    public void insertAdmin(Integer aid, String apwd, String aname);

    //  删除管理员
    @Delete("delete from admin where aid=${aid}")
    public void deleteAdminById(Integer aid);

    /* 根据aid修改名字 */
    @Update("UPDATE admin SET aname = #{aname} WHERE aid = #{aid}")
    public void updateAdminAnamedByAid(String aname, Integer aid);

    /* 根据aid修改密码 */
    @Update("UPDATE admin SET apwd = #{apwd} WHERE aid = #{aid}")
    public void updateAdminApwdByAid(String apwd, Integer aid);

    /* 根据aid修改名字和密码 */
    @Update("UPDATE admin SET apwd = #{apwd},aname = #{aname} WHERE aid = #{aid}")
    public void updateAdminApwdAnameByAid(String apwd, String aname, Integer aid);
}
