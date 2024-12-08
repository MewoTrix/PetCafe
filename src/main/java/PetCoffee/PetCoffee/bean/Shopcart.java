package PetCoffee.PetCoffee.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "shopcart", autoResultMap = true)
public class Shopcart {

    @TableId(type = IdType.AUTO)
    @TableField(value = "sid")
    private int sid;

    @TableField(value = "stheuserid")
    private int stheuserid;

    /* Integer用来固定顺序，遍历添加时只需要加一减一 */
    @TableField(value = "smycommodity", typeHandler = FastjsonTypeHandler.class)
    private Map<String,Commodity> smycommodity;

}
