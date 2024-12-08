package PetCoffee.PetCoffee.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderInfo {
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private ArrayList<Commodity> commodityMap;  /* 订单的商品 */
    private String date;                        /* 订单日期 */
    private double sum;                         /* 订单总额 */
    private User user;                          /* 订单用户 */
    private int cancelStatue;                   /* 订单取消状态 */
    private int finishStatue;                   /* 订单完成状态 */
    private int pastStatue;                     /* 订单过期状态 */
}
