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
@TableName(value = "user", autoResultMap = true)
public class User {

    @TableId
    @TableField(value = "uid")
    private int uid;

    @TableField(value = "upwd")
    private String upwd;

    @TableField(value = "uname")
    private String uname;

}
