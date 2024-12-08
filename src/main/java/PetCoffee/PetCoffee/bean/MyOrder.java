package PetCoffee.PetCoffee.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "myorder", autoResultMap = true)
public class MyOrder {

    @TableId(type = IdType.INPUT)
    @TableField(value = "myoid")
    private int myoid;

    /* 用户id */
    @TableField(value = "myouid")
    private int myouid;

    /* 订单商品信息 */
    /* Integer用来固定顺序，遍历添加时只需要加一减一 */
    @TableField(value = "myooderinfo", typeHandler = FastjsonTypeHandler.class)
    private OrderInfo myooderinfo;
}
