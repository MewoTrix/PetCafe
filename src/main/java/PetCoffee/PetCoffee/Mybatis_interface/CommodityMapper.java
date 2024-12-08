package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.Commodity;
import PetCoffee.PetCoffee.bean.Pet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {

    /* 获取所有商品id */
    @Select("select cid from commodity")
    public int[] allCid();

    /* 按照cid找商品 */
    @Select("select * from commodity where cid = #{cid}")
    public Commodity findCommodityByPid(Integer cid);

    /* 根据cname找商品 */
    @Select("select * from commodity where cname = #{cname}")
    public Commodity findCommodityByCname(String cname);

    /* 根据cid删除商品 */
    @Delete("DELETE FROM commodity WHERE cid=${cid}")
    public void deleteCommodityByCid(Integer cid);
}
