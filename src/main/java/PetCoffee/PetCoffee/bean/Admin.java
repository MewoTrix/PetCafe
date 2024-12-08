package PetCoffee.PetCoffee.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("admin")
public class Admin {

    @TableId
    @TableField(value = "aid")
    private int aid;

    @TableField(value = "apwd")
    private String apwd;

    @TableField(value = "aname")
    private String aname;

}
