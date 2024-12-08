package PetCoffee.PetCoffee.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "commodity", autoResultMap = true)
public class Commodity {

    @TableId(type = IdType.AUTO)
    @TableField(value = "cid")
    private int cid;

    @TableField(value = "cpic")
    private String cpic;

    @TableField(value = "cname")
    private String cname;

    @TableField(value = "csalenum")
    private int csalenum;

    @TableField(value = "cprice")
    private double cprice;

    @TableField(value = "cdetail")
    private String cdetail;

    @TableField(value = "ccategory")
    private String ccategory;

}
