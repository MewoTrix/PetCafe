package PetCoffee.PetCoffee.Mybatis_interface;

import PetCoffee.PetCoffee.bean.Pet;
import PetCoffee.PetCoffee.bean.User;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface PetMapper extends BaseMapper<Pet> {

    /* 获取宠物总数 */
    @Select("select count(*) from pet")
    public int allPetNumber();

    /* 获取所有宠物id */
    @Select("select pid from pet")
    public int[] allPid();

    /* 按照pid找宠物 */
    @Select("select * from pet where pid = #{pid}")
    public Pet findPetByPid(Integer pid);

    /* 获取宠物已被评论的用户id */
    @Select("select phadscoreduserid from pet where pid = #{pid}")
    public int findHadScoredUserIdByPid(Integer pid);

    /* 获取所有宠物名字 */
    @Select("select pname from pet")
    public String[] findAllPetName();

    /* 根据宠物类获取该类所有宠物名字 */
    @Select("select pname from pet where pkind = #{pkind}")
    public String[] findAllPetNameByPkind(String pkind);

    /* 获取所有宠物总评分 */
    @Select("select pscoreall from pet")
    public float[] findAllPetScoreAll();

    /* 获取所有宠物外貌评分 */
    @Select("select pscoreappearence from pet")
    public float[] findAllPetScoreAppearence();

    /* 获取所有宠物性格评分 */
    @Select("select pscorepersonality from pet")
    public float[] findAllPetScorePersonality();

    /* 获取猫总数 */
    @Select("select count(*) as catcount from pet where pkind = '猫'")
    public int catCount();

    /* 获取狗总数 */
    @Select("select count(*) as dogcount from pet where pkind = '狗'")
    public int dogCount();

    /* 根据宠物类获取所有该类点赞数量 */
    @Select("select plike from pet where pkind = #{pkind}")
    public int[] findAllPlinkByPkind(String pkind);

    /* 根据总评分找宠物 */
    @Select("select * from pet where pscoreall = #{pscoreall}")
    public Pet findPetByPscoreall(float pscoreall);

    /* 添加已评论的用户id */
    @Update("UPDATE PET SET phadscoreduserid = #{phadscoreduserid} WHERE pid = #{pid}")
    public void updatePhadscoreduseridByPid(JSONArray phadscoreduserid, Integer pid);

    /* 根据pid删除宠物 */
    @Delete("DELETE FROM pet WHERE pid=${pid}")
    public void deletePetById(Integer pid);

}
