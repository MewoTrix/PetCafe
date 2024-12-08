package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.MyOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyOrderMapper extends BaseMapper<MyOrder> {

    @Select("select myoid from myorder where ouid = #{ouid}")
    public int findOidByOuid(int ouid);

    /* 根据uid查所有订单id */
    @Select("select myoid from myorder where myouid = #{myouid}")
    public int[] findAllMyoidByUid(int myouid);

    /* 根据myoid删除订单 */
    @Delete("DELETE FROM myorder WHERE myoid=${myoid}")
    public void deleteOrderByMyoid(Integer myoid);

    /* 得到所有订单oid */
    @Select("select myoid from myorder")
    public int[] selectAllMyoid();
}
