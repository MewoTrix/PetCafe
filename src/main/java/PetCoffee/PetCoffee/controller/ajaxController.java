package PetCoffee.PetCoffee.controller;

import PetCoffee.PetCoffee.Mybatis_interface.*;
import PetCoffee.PetCoffee.bean.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class ajaxController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper usermapper;
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private MyOrderMapper myOrderMapper;

    User user;
    Admin admin;

    /* Ajax 删除用户 */
    @PostMapping("delete-By-Id")
    public String deleteById(@RequestBody String jsonStr) {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入  @PostMapping(\"delete-By-Id\")");
        System.out.println("▇▇    得到 delete-By-Id 的 JSonstr = " + jsonStr);
        System.out.println("▇▇    作用 根据前端传来的uid，注销当前账号");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        /*  ①
            接收前端传来的JSon数据
         */
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        /*  ②
            从前端获取【用户账号】，获得当前页面用户
        */
        int userId = Integer.parseInt(jsonObject.getString("userId"));

        /*  ③
            根据账号删除用户
         */
        usermapper.deleteUserById(userId);

        return "1";
    }

    /* Ajax 根据id找用户 */
    @PostMapping("find-By-Id-Ajax-Post")
    public String findByIdAjaxPost(@RequestBody String jsonStr, Model model) {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @PostMapping(\"find-By-Id-Ajax-Post\")");
        System.out.println("▇▇    得到 find-By-Id-Ajax-Post 的 JSonstr = " + jsonStr);
        System.out.println("▇▇    作用 接收前端的uid，再给前端返回这个对象");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        /*  ①
            接收前端传来的JSon数据
         */
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        /*  ②
            从前端获取【用户账号】，获得当前页面用户
        */
        int userId = Integer.parseInt(jsonObject.getString("userId"));

        /*  ③
            根据id找用户
         */
        User user1 = usermapper.findById(userId);

        /*  ④
            后端向前端，实体类转JSON传回前端
         */
        String str = JSONUtil.toJsonStr(user1);
        JSONObject jobj1 = JSONObject.parseObject(str);
        model.addAttribute("jObj1", jobj1);

        return str;
    }

    /* Ajax 给主页初始化的时候提供当前用户信息 */
    @PostMapping("give-Html-The-User")
    public String giveHtmlTheUser(@RequestBody(required = false) String jsonStr, Model model) {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @PostMapping(\"give-Html-The-User\")");
        System.out.println("▇▇    得到 give-Html-The-User JSonstr = " + jsonStr);
        System.out.println("▇▇    作用 传输当前对象给前端，在前端中作为一个全局变量的对象");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        /*  ①
            接收前端传来的JSon数据
         */
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        /*  ②
            从前端获取【用户账号】，获得当前页面用户
        */
        int userId = Integer.parseInt(jsonObject.getString("currentUserId"));

        /*  ③
            根据id找到更新资料之后的用户
        */
        User user1 = usermapper.findById(userId);

        /*  ④
            后端向前端，实体类转JSON传回前端
         */
        String str = JSONUtil.toJsonStr(user1);
        JSONObject currentUserJsonObj = JSONObject.parseObject(str);
        model.addAttribute("curJsonObj", currentUserJsonObj);

        return str;
    }

    /* Ajax 得到宠物总数 */
    @PostMapping("pet-Count")
    public int petCount() {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @PostMapping(\"pet-Count\")");
        System.out.println("▇▇    作用 得到宠物总数");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        return petMapper.allPetNumber();
    }

    /* Ajax 得到包含所有宠物的ArrayList,再转成JSON返回给前端 */
    @PostMapping("get-all-animals")
    public String getAllAnimals() {

        System.out.println();
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println("▇▇    进入 @PostMapping(\"get-all-animals\")");
        System.out.println("▇▇    作用 得到包含所有宠物的ArrayList,再转成JSON返回给前端");
        System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
        System.out.println();

        /* 所有宠物id */
        int[] pidArr = petMapper.allPid();

        /* 存下所有Pet对象 */
        ArrayList<Pet> petArrayList = new ArrayList<Pet>();
        for (int i = 0; i < pidArr.length; i++) {
            petArrayList.add(petMapper.findPetByPid(pidArr[i]));
        }

        /* 存user对象的数组转JSON到前端 */
        String str = JSON.toJSONString(petArrayList);

        return str;
    }

    /* 根据pid找宠物详情 */
    @PostMapping("find-Petdetail-By-Pid")
    public String findPetdetailByPid(@RequestBody String jsonStr) {
        return JSONUtil.toJsonStr(petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid"))).getPdetailinfo());
    }

    /* 获取所有宠物名字加 + 总评分 */
    @PostMapping("get-all-pet-name-and-scoreAll")
    public String getAllPetNameAndScoreall() {
        String[] allName = petMapper.findAllPetName();
        float[] allScore = petMapper.findAllPetScoreAll();
        JSONObject json = new JSONObject();
        for (int i = 0; i < allName.length; i++) {
            json.put(allName[i], allScore[i]);
        }
        return json.toString();
    }

    /* 获取所有宠物名字加 + 性格评分 */
    @PostMapping("get-all-pet-name-and-scorePersonality")
    public String getAllPetNameAndScorePersonality() {
        String[] allName = petMapper.findAllPetName();
        float[] personalityScore = petMapper.findAllPetScorePersonality();
        JSONObject json = new JSONObject();
        for (int i = 0; i < allName.length; i++) {
            json.put(allName[i], personalityScore[i]);
        }
        return json.toString();
    }

    /* 获取所有宠物名字加 + 形象评分 */
    @PostMapping("get-all-pet-name-and-scoreAppearence")
    public String getAllPetNameAndScoreAppearence() {
        String[] allName = petMapper.findAllPetName();
        float[] appearenceScore = petMapper.findAllPetScoreAppearence();
        JSONObject json = new JSONObject();
        for (int i = 0; i < allName.length; i++) {
            json.put(allName[i], appearenceScore[i]);
        }
        return json.toString();
    }

    /* 获取猫总数、狗总数 */
    @PostMapping("get-count-cat-and-dog")
    public String getCountCatAndDog() {
        JSONObject json = new JSONObject();
        json.put("catCount", petMapper.catCount());
        json.put("dogCount", petMapper.dogCount());

        /* 分两类获取名字 */
        String[] allCatName = petMapper.findAllPetNameByPkind("猫");
        String[] allDogName = petMapper.findAllPetNameByPkind("狗");

        /* 分两类获取点赞数 */
        int[] catLiked = petMapper.findAllPlinkByPkind("猫");
        int[] dogLiked = petMapper.findAllPlinkByPkind("狗");

        /* 猫类json对象 */
        Map<String, Integer> catMap = new HashMap<>();
        for (int i = 0; i < allCatName.length; i++) {
            catMap.put(allCatName[i], catLiked[i]);
        }

        /* 狗类json对象 */
        Map<String, Integer> dogMap = new HashMap<>();
        for (int i = 0; i < allDogName.length; i++) {
            dogMap.put(allDogName[i], dogLiked[i]);
        }

        json.put("catMap", catMap);
        json.put("dogMap", dogMap);

        return json.toString();
    }

    /* 获取本店总评分前三的宠物 */
    @PostMapping("three-star-pet")
    public String getThreeStarPet() {
        float[] allPetScore = petMapper.findAllPetScoreAll();
        Arrays.sort(allPetScore);

        JSONObject json = new JSONObject();
        json.put("petstar1", petMapper.findPetByPscoreall(allPetScore[allPetScore.length - 1]));
        json.put("petstar2", petMapper.findPetByPscoreall(allPetScore[allPetScore.length - 2]));
        json.put("petstar3", petMapper.findPetByPscoreall(allPetScore[allPetScore.length - 3]));

        return json.toString();
    }

    /* 获取所有商品 */
    @PostMapping("get-all-commodity")
    public String getAllCommodity() {
        /* 所有商品cid */
        int[] commodityArr = commodityMapper.allCid();

        /* 存下所有Commodity对象 */
        ArrayList<Commodity> commodityArrayList = new ArrayList<>();
        for (int i = 0; i < commodityArr.length; i++) {
            commodityArrayList.add(commodityMapper.findCommodityByPid(commodityArr[i]));
        }
        return JSON.toJSONString(commodityArrayList);
    }

    /* 添加购物车进数据库 */
    @PostMapping("my-shopcart-create")
    public void myShopCartCreate(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        int userId = Integer.parseInt(jsonObject.getString("uid"));
        Commodity commodity = commodityMapper.findCommodityByPid(Integer.parseInt(jsonObject.getString("cid")));

        /* 捕捉购物车数据库无对象的异常 */
        int sid;
        try {
            sid = shopcartMapper.findSidByStheuserid(userId);
        } catch (Exception e) {
            sid = 0;
        }
        Shopcart shopcart = shopcartMapper.selectById(sid);

        /* 有该用户的购物车就添加，没有就新增 */
        if (shopcart != null) {

            Map<String, Commodity> map = shopcart.getSmycommodity();

            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                /* java11有bug，类型判断为jSON，但是编译的时候又说是JAVA实体类，只能通过两种类型共有的方法转成JSON字符串，再转回来JAVA实体类 */
                String str = JSONUtil.toJsonStr(entry.getValue());
                Commodity commodity1 = JSONObject.parseObject(str, Commodity.class);

                if (commodity1.getCid() == Integer.parseInt(jsonObject.getString("cid"))) {
                    return;
                }
            }

            int size = map.size() + 1;
            map.put(String.valueOf(size), commodity);
            shopcart.setSmycommodity(map);
            shopcartMapper.updateById(shopcart);
        } else {
            Shopcart shopcart1 = new Shopcart();
            Map<String, Commodity> map = new ConcurrentHashMap<>();
            map.put("1", commodity);
            shopcart1.setStheuserid(userId);
            shopcart1.setSmycommodity(map);
            shopcartMapper.insert(shopcart1);
        }
    }

    /* 删除购物车里点击的商品(Map遍历无异常方法) */
    @PostMapping("my-shopcart-delete")
    public void myShopcartDelete(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        int userId = Integer.parseInt(jsonObject.getString("uid"));
        int cid = Integer.parseInt(jsonObject.getString("cid"));
        int sid = shopcartMapper.findSidByStheuserid(userId);

        Shopcart shopcart = shopcartMapper.selectById(sid);

        Map<String, Commodity> map = shopcart.getSmycommodity();

        /* 用Iterator遍历Map不会报异常 */
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {

            Map.Entry entry = (Map.Entry) iter.next();
            /* java11有bug，类型判断为jSON，但是编译的时候又说是JAVA实体类，只能通过两种类型共有的方法转成JSON字符串，再转回来JAVA实体类 */
            String str = JSONUtil.toJsonStr(entry.getValue());
            Commodity commodity = JSONObject.parseObject(str, Commodity.class);

            if (commodity.getCid() == cid) {
                iter.remove();
            }
        }
        shopcart.setSmycommodity(map);
        shopcartMapper.updateById(shopcart);
    }

    /* 获得购物车总商品数量 */
    @PostMapping("cart-num")
    public String cartNum(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        int userId = Integer.parseInt(jsonObject.getString("uid"));

        int sid;
        try {
            sid = shopcartMapper.findSidByStheuserid(userId);
            Shopcart shopcart = shopcartMapper.selectById(sid);

            Map<String, Commodity> map = shopcart.getSmycommodity();

            int cartNum = 0;
            for (Map.Entry<String, Commodity> entry : map.entrySet()) {
                cartNum += 1;
            }

            return String.valueOf(cartNum);
        } catch (Exception e) {
            return "0";
        }
    }

    /* 通过用户id得到他的购物车商品 */
    @PostMapping("get-cart-all-commodity-by-uid")
    public String getCartAllCommodityByUid(@RequestBody String jsonStr) {
        int userId = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"));
        try {
            Shopcart shopcart = shopcartMapper.selectById(shopcartMapper.findSidByStheuserid(userId));
            Map<String, Commodity> map = shopcart.getSmycommodity();
            return JSONUtil.toJsonStr(map);
        } catch (Exception e) {
            return "";
        }
    }

    /* 根据用户id增加订单,uid有则插入信息,无则新增 */
    @PostMapping("generate-myorder-by-uid-and-hiscid")
    public String generateMyOrderByUidAndHiscid(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        int userId = Integer.parseInt(jsonObject.getString("uid"));

        /*  前台传进来的订单cid,根据此数组,逐个添加进OrderInfo  */
        String[] s = (jsonObject.getString("allCid").substring(1, jsonObject.getString("allCid").length() - 1)).split(",");
        int[] cidArr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            cidArr[i] = Integer.parseInt(s[i]);
        }



        /* 初始支付成功的订单信息 */
        /* 属性 : 订单商品 */
        ArrayList<Commodity> commodityMap = new ArrayList<>();
        for (int i = 0; i < cidArr.length; i++) {
            commodityMap.add(commodityMapper.findCommodityByPid(cidArr[i]));
        }
        /* 属性 : 订单日期 */
        Calendar now = Calendar.getInstance();
        String date = String.valueOf(now.get(Calendar.YEAR)) + "-" + String.valueOf((now.get(Calendar.MONTH) + 1)) + "-" + String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        /* 属性 : 订单总额 */
        double sum = 0;
        for (int i = 0; i < cidArr.length; i++) {
            sum += commodityMapper.findCommodityByPid(cidArr[i]).getCprice();
        }
        /* 属性 : 订单用户 */
        User user1 = usermapper.findById(userId);
        /* 属性 : 订单取消状态 */
        int cancelStatue = 0;
        /* 属性 : 订单完成状态 */
        int finishStatue = 0;
        /* 属性 : 订单过期状态 */
        int pastStatue = 0;
        /* 订单信息实体类 */
        OrderInfo orderInfo = new OrderInfo(commodityMap, date, sum, user1, cancelStatue, finishStatue, pastStatue);




        /* 新增订单 */
        MyOrder myOrder1 = new MyOrder();
        myOrder1.setMyouid(userId);
        myOrder1.setMyooderinfo(orderInfo);
        myOrderMapper.insert(myOrder1);

        shopcartMapper.deleteShopcartByUid(userId);
        return "1";
    }

    /* 根据uid获取该用户的所有订单 */
    @PostMapping("get-all-myorder-by-uid")
    public String getAllMyorderByUid(@RequestBody String jsonStr) {

        /* 用户id */
        int userId = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"));

        /* 得到该用户的所有oid主键 */
        int[] allOid = myOrderMapper.findAllMyoidByUid(userId);

        /* 存放所有Map类,存着本次订单所有信息(OrderInfo类),存下所有这个Map类就可以直接传到前端 */
        List<MyOrder> listMap = new ArrayList<>();

        for (int i = 0; i < allOid.length; i++) {
            listMap.add(myOrderMapper.selectById(allOid[i]));
        }
        return JSONUtil.toJsonStr(listMap);
    }

    /* 根据myoid更新数据库订单 -> 取消状态 */
    @PostMapping("cancel-order-by-myoid")
    public String cancelOrderByMyoid(@RequestBody String jsonStr) {

        MyOrder myOrder = myOrderMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("myoid")));
        OrderInfo orderInfo = myOrder.getMyooderinfo();
        orderInfo.setCancelStatue(1);
        myOrder.setMyooderinfo(orderInfo);
        myOrderMapper.updateById(myOrder);

        return "1";
    }

    /* 根据aid获取当前管理员对象返回前端 */
    @PostMapping("get-admin")
    public String getAdmin(@RequestBody String jsonStr) {
        return JSONUtil.toJsonStr(adminMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))));
    }

    /* 根据aid修改名字 */
    @PostMapping("update-aname-by-aid")
    public String updateAnameByAid(Model model, @RequestBody String jsonStr) {
        if (adminMapper.findByAname(JSONObject.parseObject(jsonStr).getString("aname")) != null) {
            return "0";
        }
        adminMapper.updateAdminAnamedByAid((JSONObject.parseObject(jsonStr).getString("aname")), (Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))));
        model.addAttribute("admin", adminMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))));
        return "1";
    }

    /* 根据aid修改密码 */
    @PostMapping("update-apwd-by-aid")
    public void updateApwdByAid(@RequestBody String jsonStr) {
        adminMapper.updateAdminApwdByAid((JSONObject.parseObject(jsonStr).getString("apwd")), (Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))));
    }

    /* 根据aid注销账号 */
    @PostMapping("delete-admin-by-aid")
    public String deleteAdminByAid(@RequestBody String jsonStr) {
        String name = adminMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))).getAname();
        adminMapper.deleteAdminById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid")));
        return name;
    }

    /* 给前台返回所有管理员对象 */
    @PostMapping("get-all-admin-objs")
    public String getAllAdminObjs() {
        List<Admin> adminList = new ArrayList<>();
        int[] allAid = adminMapper.selectAllAid();
        for (int i = 0; i < allAid.length; i++) {
            adminList.add(adminMapper.selectById(allAid[i]));
        }
        return JSONUtil.toJsonStr(adminList);
    }

    /* 管理员修改管理员名字、密码 */
    @PostMapping("update-apwd-aname-by-aid")
    public String updateApwdAnameByAid(@RequestBody String jsonStr) {
        adminMapper.updateAdminApwdAnameByAid(JSONObject.parseObject(jsonStr).getString("apwd"), JSONObject.parseObject(jsonStr).getString("aname"), Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid")));
        return "1";
    }

    /* 管理员添加管理员 */
    @PostMapping("insert-admin")
    public String insertAdmin(@RequestBody String jsonStr) {
        try {
            if (adminMapper.findById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid"))) != null) {
                return "1";
            }
            if (adminMapper.findByAname(JSONObject.parseObject(jsonStr).getString("aname")) != null) {
                return "2";
            }
            adminMapper.insertAdmin(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("aid")), JSONObject.parseObject(jsonStr).getString("apwd"), JSONObject.parseObject(jsonStr).getString("aname"));
            return "0";
        } catch (NumberFormatException ne) {
            System.out.println(ne);
            return "3";
        }
    }

    /* 获取所有宠物对象，返回到前台 */
    @PostMapping("get-all-pet-objs")
    public String getAllPetObjs() {
        int[] allPetId = petMapper.allPid();
        List<Pet> petList = new ArrayList<>();
        for (int i = 0; i < allPetId.length; i++) {
            petList.add(petMapper.findPetByPid(allPetId[i]));
        }
        return JSONUtil.toJsonStr(petList);
    }

    /* 获取所有宠物详情，返回到前台 */
    @PostMapping("get-all-pet-detail-by-pid")
    public String getAllPetDetailByPid() {
        int[] allPetId = petMapper.allPid();
        List<Map<String, Object>> detailList = new ArrayList<>();
        for (int i = 0; i < allPetId.length; i++) {
            detailList.add(petMapper.selectById(allPetId[i]).getPdetailinfo());
        }
        return JSONUtil.toJsonStr(detailList);
    }

    /* 根据pid更新除了图片之外的全部信息 */
    @PostMapping("update-pet-by-pid")
    public String updatePetByPid(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        Pet pet = petMapper.selectById(jsonObject.getString("pid"));
        pet.setPname(jsonObject.getString("pname"));
        pet.setPbirth(jsonObject.getString("pbirth"));
        pet.setPsex(jsonObject.getString("psex"));
        pet.setPweight(jsonObject.getString("pweight"));
        pet.setPbreed(jsonObject.getString("pbreed"));
        pet.setPwashtime(jsonObject.getString("pwashtime"));
        pet.setPbirthskill(jsonObject.getString("pbirthskill"));
        pet.setPinjection(jsonObject.getString("pinjection"));
        pet.setPillhistory(jsonObject.getString("pillhistory"));
        pet.setPkind(jsonObject.getString("pillhistory"));
        pet.setPkind(jsonObject.getString("pkind"));
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("date1", jsonObject.getString("pDetailDate1"));
        infoMap.put("date2", jsonObject.getString("pDetailDate2"));
        infoMap.put("date3", jsonObject.getString("pDetailDate3"));
        infoMap.put("text1", jsonObject.getString("pDetailText1"));
        infoMap.put("text2", jsonObject.getString("pDetailText2"));
        infoMap.put("text3", jsonObject.getString("pDetailText3"));
        pet.setPdetailinfo(infoMap);

        petMapper.updateById(pet);
        return "1";
    }

    /* 根据pid删除宠物 */
    @PostMapping("delete-pet-by-pid")
    public String deletePetByPid(@RequestBody String jsonStr) {
        petMapper.deletePetById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        return "1";
    }

    /* 新增宠物 */
    @PostMapping("insert-pet")
    public String insertPet(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Pet pet = new Pet();
        pet.setPname(jsonObject.getString("pname"));
        pet.setPbirth(jsonObject.getString("pbirth"));
        pet.setPsex(jsonObject.getString("psex"));
        pet.setPweight(jsonObject.getString("pweight"));
        pet.setPbreed(jsonObject.getString("pbreed"));
        pet.setPwashtime(jsonObject.getString("pwashtime"));
        pet.setPbirthskill(jsonObject.getString("pbirthskill"));
        pet.setPinjection(jsonObject.getString("pinjection"));
        pet.setPillhistory(jsonObject.getString("pillhistory"));
        pet.setPkind(jsonObject.getString("pkind"));
        pet.setPcartoonpic(jsonObject.getString("pCartoonPicPath"));
        pet.setPpic(jsonObject.getString("pHeadPicPath"));
        Map<String, Object> detailMap = new HashMap<>();
        detailMap.put("date1", jsonObject.getString("pDetailDate1"));
        detailMap.put("date2", jsonObject.getString("pDetailDate2"));
        detailMap.put("date3", jsonObject.getString("pDetailDate3"));
        detailMap.put("text1", jsonObject.getString("pDetailText1"));
        detailMap.put("text2", jsonObject.getString("pDetailText2"));
        detailMap.put("text3", jsonObject.getString("pDetailText3"));
        detailMap.put("Picpath1", jsonObject.getString("pDetail1PicPath"));
        detailMap.put("Picpath2", jsonObject.getString("pDetail2PicPath"));
        detailMap.put("Picpath3", jsonObject.getString("pDetail3PicPath"));
        pet.setPdetailinfo(detailMap);
        petMapper.insert(pet);
        return "1";
    }

    /* 根据pid修改卡通图 */
    @PostMapping("update-pcartoon-by-pid")
    public String updatePcartoonByPid(@RequestBody String jsonStr) {
        Pet pet = petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        pet.setPcartoonpic(JSONObject.parseObject(jsonStr).getString("pcartoonPic"));
        petMapper.updateById(pet);
        return JSONObject.parseObject(jsonStr).getString("pcartoonPic");
    }

    /* 根据pid修改头像图 */
    @PostMapping("update-realpic-by-pid")
    public String updateRealpicByPid(@RequestBody String jsonStr) {
        Pet pet = petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        pet.setPpic(JSONObject.parseObject(jsonStr).getString("changedHeadPic"));
        petMapper.updateById(pet);
        return JSONObject.parseObject(jsonStr).getString("ppic");
    }

    /* 根据pid修改宠物详情图1 */
    @PostMapping("update-pdetail1pic-by-pid")
    public void updatePdetail1picByPid(@RequestBody String jsonStr) {
        Pet pet = petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        Map<String, Object> detailMap = new ConcurrentHashMap<>();
        detailMap = pet.getPdetailinfo();
        /* 删除重新添加 */
        Iterator iter = detailMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (entry.getKey() == "Picpath1") {
                iter.remove();
            }
        }
        detailMap.put("Picpath1", JSONObject.parseObject(jsonStr).getString("changedDetail1Pic"));
        pet.setPdetailinfo(detailMap);
        petMapper.updateById(pet);
    }

    /* 根据pid修改宠物详情图2 */
    @PostMapping("update-pdetail2pic-by-pid")
    public void updatePdetail2picByPid(@RequestBody String jsonStr) {
        Pet pet = petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        Map<String, Object> detailMap = new ConcurrentHashMap<>();
        detailMap = pet.getPdetailinfo();
        /* 删除重新添加 */
        Iterator iter = detailMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (entry.getKey() == "Picpath2") {
                iter.remove();
            }
        }
        detailMap.put("Picpath2", JSONObject.parseObject(jsonStr).getString("changedDetail2Pic"));
        pet.setPdetailinfo(detailMap);
        petMapper.updateById(pet);
    }

    /* 根据pid修改宠物详情图3 */
    @PostMapping("update-pdetail3pic-by-pid")
    public void updatePdetail3picByPid(@RequestBody String jsonStr) {
        Pet pet = petMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid")));
        Map<String, Object> detailMap = new ConcurrentHashMap<>();
        detailMap = pet.getPdetailinfo();
        /* 删除重新添加 */
        Iterator iter = detailMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (entry.getKey() == "Picpath3") {
                iter.remove();
            }
        }
        detailMap.put("Picpath3", JSONObject.parseObject(jsonStr).getString("changedDetail3Pic"));
        pet.setPdetailinfo(detailMap);
        petMapper.updateById(pet);
    }

    /* 得到所有用户对象，并返回 */
    @PostMapping("get-all-user-objs")
    public String getAllUserObjs() {
        List<User> userList = new ArrayList<>();
        int[] allUid = usermapper.selectAllUid();
        for (int i = 0; i < allUid.length; i++) {
            userList.add(usermapper.selectById(allUid[i]));
        }
        return JSONUtil.toJsonStr(userList);
    }

    /* 管理员添加用户 */
    @PostMapping("insert-user")
    public String insertUser(@RequestBody String jsonStr) {
        try {
            if (usermapper.findById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"))) != null) {
                return "1";
            }
            if (usermapper.findByUname(JSONObject.parseObject(jsonStr).getString("uname")) != null) {
                return "2";
            }
            usermapper.insertUser(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid")), JSONObject.parseObject(jsonStr).getString("upwd"), JSONObject.parseObject(jsonStr).getString("uname"));
            return "0";
        } catch (NumberFormatException ne) {
            return "3";
        }
    }

    /* 根据uid删除用户账号 */
    @PostMapping("delete-user-by-uid")
    public String deleteUserByAid(@RequestBody String jsonStr) {
        String name = usermapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"))).getUname();
        usermapper.deleteUserById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid")));
        return name;
    }

    /* 管理员修改用户名字、密码 */
    @PostMapping("update-upwd-uname-by-uid")
    public String updateUpwdUnameByUid(@RequestBody String jsonStr) {
        usermapper.updateUserUpwdUnameByUid(JSONObject.parseObject(jsonStr).getString("upwd"), JSONObject.parseObject(jsonStr).getString("uname"), Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid")));
        return "1";
    }

    /* 根据uid修改名字 */
    @PostMapping("update-uname-by-uid")
    public String updateUnameByUid(Model model, @RequestBody String jsonStr) {
        if (usermapper.findByUname(JSONObject.parseObject(jsonStr).getString("uname")) != null) {
            return "0";
        }
        usermapper.updateUserUnamedByUid((JSONObject.parseObject(jsonStr).getString("uname")), (Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"))));
        model.addAttribute("user", usermapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"))));
        return "1";
    }

    /* 根据uid修改密码 */
    @PostMapping("update-upwd-by-uid")
    public void updateUpwdByUid(@RequestBody String jsonStr) {
        usermapper.updateUserUpwdByUid((JSONObject.parseObject(jsonStr).getString("upwd")), (Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"))));
    }

    /* 得到所有商品对象，并返回 */
    @PostMapping("get-all-commodity-objs")
    public String getAllCommodityObjs() {
        List<Commodity> commodityList = new ArrayList<>();
        int[] allUid = commodityMapper.allCid();
        for (int i = 0; i < allUid.length; i++) {
            commodityList.add(commodityMapper.selectById(allUid[i]));
        }
        return JSONUtil.toJsonStr(commodityList);
    }

    /* 根据cid更新商品信息 */
    @PostMapping("update-cname-cprice-ccategory-cdetail-by-cid")
    public String updateCnameCpriceCcategoryCdetailByCid(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Commodity commodity = commodityMapper.selectById(Integer.parseInt(jsonObject.getString("cid")));
        commodity.setCname(jsonObject.getString("cname"));
        commodity.setCprice(Double.parseDouble(jsonObject.getString("cprice")));
        commodity.setCcategory(jsonObject.getString("ccategory"));
        commodity.setCdetail(jsonObject.getString("cdetail"));
        commodityMapper.updateById(commodity);
        return "2";
    }

    /* 根据cid删除商品 */
    @PostMapping("delete-commodity-by-cid")
    public String deleteCommodityByCid(@RequestBody String jsonStr) {
        String name = commodityMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("cid"))).getCname();
        commodityMapper.deleteCommodityByCid(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("cid")));
        return name;
    }

    /* 管理员添加商品 */
    @PostMapping("insert-commodity")
    public String insertCommodity(@RequestBody String jsonStr) {
        if (commodityMapper.findCommodityByCname(JSONObject.parseObject(jsonStr).getString("cname")) != null) {
            return "1";
        }
        Commodity commodity = new Commodity();
        commodity.setCname(JSONObject.parseObject(jsonStr).getString("cname"));
        commodity.setCprice(Double.parseDouble(JSONObject.parseObject(jsonStr).getString("cprice")));
        commodity.setCcategory(JSONObject.parseObject(jsonStr).getString("ccategory"));
        commodity.setCdetail(JSONObject.parseObject(jsonStr).getString("cdetail"));
        commodity.setCpic(JSONObject.parseObject(jsonStr).getString("cpic"));
        commodityMapper.insert(commodity);
        return "0";
    }

    /* 根据cid改pic路径 */
    @PostMapping("update-commodity-pic-by-cid")
    public String updateCommodityPicByCid(@RequestBody String jsonStr) {
        Commodity commodity = commodityMapper.selectById(Integer.parseInt(JSONObject.parseObject(jsonStr).getString("cid")));
        commodity.setCpic(JSONObject.parseObject(jsonStr).getString("cpic"));
        commodityMapper.updateById(commodity);
        return "";
    }

    /* 返回所有订单对象 */
    @PostMapping("get-all-order-objs")
    public String getAllOrderObjs() {
        List<MyOrder> myOrderList = new ArrayList<>();
        int[] allOid = myOrderMapper.selectAllMyoid();
        for (int i = 0; i < allOid.length; i++) {
            myOrderList.add(myOrderMapper.selectById(allOid[i]));
        }
        return JSONUtil.toJsonStr(myOrderList);
    }

    /* 根据myoid设置为“已完成”状态 */
    @PostMapping("finish-myorder-by-myoid")
    public String finishMyorderByMyoid(@RequestBody String jsonStr) {
        MyOrder myOrder = myOrderMapper.selectById(JSONObject.parseObject(jsonStr).getString("myoid"));
        OrderInfo orderInfo = myOrder.getMyooderinfo();
        orderInfo.setFinishStatue(1);
        myOrder.setMyooderinfo(orderInfo);
        myOrderMapper.updateById(myOrder);
        return "1";
    }

    /* 根据uid、pid查是否已经评论 */
    @PostMapping("check-uid-scored-or-not")
    public String checkUidScoredOrNot(@RequestBody String jsonStr) {
        int pid = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid"));
        int uid = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("uid"));
        Pet pet = petMapper.selectById(pid);
        String petScoredStr = pet.getPhadscoreduserid();
        String[] petScoredStrArr = petScoredStr.split(",");

        int[] petScoredArr = new int[petScoredStrArr.length];
        for (int i = 0; i < petScoredStrArr.length; i++) {
            petScoredArr[i] = Integer.parseInt(petScoredStrArr[i]);
        }
        for (int j = 0; j < petScoredArr.length; j++) {
            if (petScoredArr[j] == uid) {
                return "1";
            }
        }
        return "0";
    }

    /* 更新宠物评分 */
    @PostMapping("update-score")
    public String updateScore(@RequestBody String jsonStr) {
        String uid = "," + JSONObject.parseObject(jsonStr).getString("uid");
        int pid = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("pid"));
        double pscoreappearence = Double.parseDouble(JSONObject.parseObject(jsonStr).getString("pscoreappearence"));
        double pscorepersonality = Double.parseDouble(JSONObject.parseObject(jsonStr).getString("pscorepersonality"));
        int like = Integer.parseInt(JSONObject.parseObject(jsonStr).getString("plike"));

        Pet pet = petMapper.selectById(pid);

        int num = pet.getPscorepersonnum() + 1;
        float apperance = (float) (pet.getPscoreappearence() * pet.getPscorepersonnum() + pscoreappearence) / num;
        float personality = (float) (pet.getPscorepersonality() * pet.getPscorepersonnum() + pscorepersonality) / num;
        float sumscore = (float) ((pet.getPscoreall() * pet.getPscorepersonnum() + (pscoreappearence + pscorepersonality) / 2) / num);
        String scoreStr = pet.getPhadscoreduserid() + uid;
        int plike = pet.getPlike();
        if (like == 1) {
            plike += 1;
        }

        pet.setPscorepersonnum(num);
        pet.setPscoreappearence(apperance);
        pet.setPscorepersonality(personality);
        pet.setPscoreall(sumscore);
        pet.setPhadscoreduserid(scoreStr);
        pet.setPlike(plike);

        petMapper.updateById(pet);

        return "1";
    }
}



















