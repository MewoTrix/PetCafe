package PetCoffee.PetCoffee.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "pet", autoResultMap = true)
public class Pet {

    @TableId(type = IdType.AUTO)
    @TableField(value = "pid")
    private int pid;

    @TableField(value = "pcartoonpic")
    private String pcartoonpic;

    @TableField(value = "ppic")
    private String ppic;

    @TableField(value = "pname")
    private String pname;

    @TableField(value = "pbirth")
    private String pbirth;

    @TableField(value = "psex")
    private String psex;

    @TableField(value = "pweight")
    private String pweight;

    @TableField(value = "pbreed")
    private String pbreed;

    @TableField(value = "pwashtime")
    private String pwashtime;

    @TableField(value = "pbirthskill")
    private String pbirthskill;

    @TableField(value = "pinjection")
    private String pinjection;

    @TableField(value = "pillhistory")
    private String pillhistory;

    @TableField(value = "plike")
    private int plike;

    @TableField(value = "pscoreall")
    private float pscoreall;

    @TableField(value = "pscoreappearence")
    private float pscoreappearence;

    @TableField(value = "pscorepersonality")
    private float pscorepersonality;

    @TableField(value = "pscorepersonnum")
    private int pscorepersonnum;

    @TableField(value = "phadscoreduserid")
    private String phadscoreduserid;

    @TableField(value = "pdetailinfo", typeHandler = FastjsonTypeHandler.class)
    private Map<String,Object> pdetailinfo;

    @TableField(value = "pkind")
    private String pkind;

}
