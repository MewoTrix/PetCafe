package PetCoffee.PetCoffee.controller;

import PetCoffee.PetCoffee.Mybatis_interface.AdminMapper;
import PetCoffee.PetCoffee.Mybatis_interface.MyOrderMapper;
import PetCoffee.PetCoffee.Mybatis_interface.UserMapper;
import PetCoffee.PetCoffee.bean.Admin;
import PetCoffee.PetCoffee.bean.MyOrder;
import PetCoffee.PetCoffee.bean.OrderInfo;
import PetCoffee.PetCoffee.bean.User;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

@CrossOrigin
@Controller
public class LoginRegisterController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper buserMapper;
    @Autowired
    private MyOrderMapper myOrderMapper;

    User user;
    Admin admin;

    @GetMapping("/")
    public String index() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"/\")");
        System.out.println("▇▇    作用 进入页面   a-Login");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        return "a-Login";
        // return "ztest";
    }

    @GetMapping("/ztest")
    public String test() {
        return "ztest";
    }

    @GetMapping("/a-Login")
    public String aLogin() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"a-Login\")");
        System.out.println("▇▇    作用 进入页面   a-Login");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "a-Login";
    }

    /* 用户登陆验证 */
    @GetMapping("/a-Login-Check")
    public String aLoginCheck(@RequestParam Map<String, Object> params, Model model) {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"a-Login-Check\")");
        System.out.println("▇▇    作用 进行用户登陆验证");
        System.out.println("▇▇         成功 -> d-Home-User");
        System.out.println("▇▇         失败 -> a-Login-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        try {

            // 得到登录的账号、密码
            int uLoginId = Integer.parseInt((params.get("uid")).toString());
            String uloginPwd = params.get("upwd").toString();

            // 根据登录账号密码查数据库
            user = buserMapper.findByIdWithPwd(uLoginId, uloginPwd);

            // 数据库有这个用户，把这个对象作为model对象的参数
            if (user != null) {
                model.addAttribute("user", user);

                /* 检查订单是否过期 */
                /* 订单本月内生效 */
                Calendar now = Calendar.getInstance();
                int month = Integer.parseInt(String.valueOf((now.get(Calendar.MONTH) + 1)));

                int[] allMyoid = myOrderMapper.selectAllMyoid();
                for (int i = 0; i < allMyoid.length; i++) {
                    MyOrder myOrder = myOrderMapper.selectById(allMyoid[i]);
                    OrderInfo orderInfo = myOrder.getMyooderinfo();
                    String[] dataStr = orderInfo.getDate().split("-");
                    int monthOld = Integer.parseInt(dataStr[1]);

                    if (month != monthOld){
                        orderInfo.setPastStatue(1);
                        myOrder.setMyooderinfo(orderInfo);
                        myOrderMapper.updateById(myOrder);
                    }
                }

                return "d-Home-User";
            } else {
                return "a-Login-error";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "a-Login-error";
        }
    }

    @GetMapping("/a-Login-error")
    public String aLoginError() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"a-Login-error\")");
        System.out.println("▇▇    作用 进入页面   a-Login-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "a-Login-error";
    }

    @GetMapping("/b-Register")
    public String bRegister() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"b-Register\")");
        System.out.println("▇▇    作用 进入页面   b-Register");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "b-Register";
    }

    @GetMapping("/b-Register-success")
    public String bRegisterSuccess() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"b-Register-success\")");
        System.out.println("▇▇    作用 进入页面   b-Register-success");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "b-Register-success";
    }

    @GetMapping("/b-Register-error")
    public String bRegisterError() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"b-Register-error\")");
        System.out.println("▇▇    作用 进入页面   b-Register-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "b-Register-error";
    }

    /* 注册验证 */
    @GetMapping("/b-Register-Check")
    public String bRegisterCheck(@RequestParam Map<String, Object> params) throws SQLException {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"b-Register-Check\")");
        System.out.println("▇▇    作用 进行注册验证");
        System.out.println("▇▇         成功 -> b-Register-success");
        System.out.println("▇▇         失败 -> b-Register-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        try {
            int uRegisterId = Integer.parseInt((params.get("register-uid")).toString());
            String uRegisterPwd = params.get("register-upwd").toString();
            String uRegisterName = params.get("register-uname").toString();

            User userLoginResult2 = buserMapper.findById(uRegisterId);
            System.out.println(userLoginResult2);

            if ((uRegisterPwd != "") && (uRegisterName != "") && (userLoginResult2 == null)) {
                buserMapper.insertUser(uRegisterId, uRegisterPwd, uRegisterName);
                return "b-Register-success";
            } else {
                return "b-Register-error";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "b-Register-error";
        }
    }

    @GetMapping("/c-Admin-Login")
    public String cAdminLogin() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"c-Admin-Login\")");
        System.out.println("▇▇    作用 进入页面   c-Admin-Login");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "c-Admin-Login";
    }

    /* 管理员登陆验证 */
    @GetMapping("/c-Admin-Login-Check")
    public String cAdminLoginCheck(Model model, @RequestParam Map<String, Object> params) {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"c-Admin-Login-Check\")");
        System.out.println("▇▇    作用 管理员登陆验证");
        System.out.println("▇▇         成功 -> d-Home-Admin");
        System.out.println("▇▇         失败 -> c-Admin-Login-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        try {
            int aLoginId = Integer.parseInt((params.get("aid")).toString());
            String aloginPwd = params.get("apwd").toString();

            admin = adminMapper.findByIdWithPwd(aLoginId, aloginPwd);

            if (admin != null) {
                model.addAttribute("admin", admin);

                /* 检查订单是否过期 */
                /* 订单本月内生效 */
                Calendar now = Calendar.getInstance();
                int month = Integer.parseInt(String.valueOf((now.get(Calendar.MONTH) + 1)));

                int[] allMyoid = myOrderMapper.selectAllMyoid();
                for (int i = 0; i < allMyoid.length; i++) {
                    MyOrder myOrder = myOrderMapper.selectById(allMyoid[i]);
                    OrderInfo orderInfo = myOrder.getMyooderinfo();
                    String[] dataStr = orderInfo.getDate().split("-");
                    int monthOld = Integer.parseInt(dataStr[1]);

                    if (month != monthOld){
                        orderInfo.setPastStatue(1);
                        myOrder.setMyooderinfo(orderInfo);
                        myOrderMapper.updateById(myOrder);
                    }
                }

                return "d-Home-Admin";
            } else {
                return "c-Admin-Login-error";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "c-Admin-Login-error";
        }
    }

    @GetMapping("/c-Admin-Login-error")
    public String cAdminLoginError() {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"c-Admin-Login-error\")");
        System.out.println("▇▇    作用 进入页面   c-Admin-Login-error");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();
        return "c-Admin-Login-error";
    }

    @GetMapping("/d-Home-User")
    public String dHomeUser(Model model, @RequestParam Map<String, Object> params) {
        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @GetMapping(\"d-Home-User\")");
        System.out.println("▇▇    作用 进入页面   d-Home-User，并传一个User对象进Model");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        model.addAttribute("user", user);

        return "d-Home-User";
    }

    /*
        Ajax 修改用户密码、用户名
    */
    @PostMapping("/alter-Upwd-Uname")
    @ResponseBody
    public String alterUpwdUname(@RequestBody String jsonStr, Model model) {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @PostMapping(\"alter-Upwd-Uname\")");
        System.out.println("▇▇    得到 give-Html-The-User JSonstr = " + jsonStr);
        System.out.println("▇▇    作用 ①、更改用户密码、用户名   ");
        System.out.println("▇▇        ②、重新获取该用户信息，以JSon形式发到前端   ");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        /*  ①
            接收前端传来的JSon数据
         */
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        /*  ②
            从前端传来的JSon获取【修改的用户密码、用户名、账号】数据
        */
        String userPwd = jsonObject.getString("userPwd");
        String userName = jsonObject.getString("userName");

        /*  ③
            从前端获取【用户账号】，获得当前页面用户
        */
        int userId = Integer.parseInt(jsonObject.getString("userId"));

        /*  ④
            更新用户密码、用户名
        */
        buserMapper.updateUserByUpwdAndUname(userPwd, userName, userId);

        /*  ⑤
            根据id找到更新资料之后的用户
        */
        User userLoginResult1 = buserMapper.findById(userId);

        /*  ⑥
            后端向前端，实体类转JSON传回前端
         */
        String str = JSONUtil.toJsonStr(userLoginResult1);
        JSONObject jobj = JSONObject.parseObject(str);
        model.addAttribute("jObj", jobj);

        // jb = {"uid":2,"uname":"r","upwd":"r"}
        System.out.println("jobj = " + jobj);

        return str;
    }

}
