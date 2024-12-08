package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.Shopcart;
import PetCoffee.PetCoffee.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ShopcartMapper extends BaseMapper<Shopcart> {

    @Select("select * from shopcart where stheuserid = #{stheuserid}")
    public Shopcart findShopcartByUid(int stheuserid);

    /* 根据用户 id 查商品 id (Mybati-plus查询需要) */
    @Select("select sid from shopcart where stheuserid = #{stheuserid}")
    public int findSidByStheuserid(int stheuserid);

    /* 根据用户id删除该用户的购物车 */
    @Delete("DELETE FROM shopcart WHERE stheuserid=${stheuserid}")
    public void deleteShopcartByUid(Integer stheuserid);

}
