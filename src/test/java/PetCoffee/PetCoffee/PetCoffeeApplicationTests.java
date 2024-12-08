package PetCoffee.PetCoffee;

import PetCoffee.PetCoffee.Mybatis_interface.*;
import PetCoffee.PetCoffee.bean.Commodity;
import PetCoffee.PetCoffee.bean.MyOrder;
import PetCoffee.PetCoffee.bean.OrderInfo;
import PetCoffee.PetCoffee.bean.Pet;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PetCoffeeApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private MyOrderMapper myOrderMapper;

    // 插入方法
    // @Test
    public void testInsert() {
        Pet pet = new Pet();

        Map<String, Object> map = new HashMap<>();
        map.put("data1", "data1");
        map.put("data2", "data2");
        map.put("data3", "data3");
        map.put("Picpath1", "/petPic/详情.png");
        map.put("Picpath2", "Picpath2");
        map.put("Picpath3", "Picpath3");
        map.put("text1", "text1");
        map.put("text2", "text2");
        map.put("text3", "text3");
        pet.setPdetailinfo(map);

        petMapper.insert(pet);
    }

    // 查询方法
    // @Test
    public void testSelect() {
        Pet pet = petMapper.selectById(112);
        String str = JSONUtil.toJsonStr(pet);
        System.out.println(str);

        String str1 = JSONUtil.toJsonStr(pet.getPdetailinfo());
        System.out.println(str1);
    }

    //@Test
    public void test() {
        /* 到店娱乐 */
        Commodity commodity0 = new Commodity(1, "/pic/i-入场券.jpg", "单人工作日套餐", 1679, 60, "•工作日单人不限时无限畅饮\n•工作日单人不限时撸宠物", "1");
        Commodity commodity1 = new Commodity(2, "/pic/i-入场券.jpg", "单人周末套餐", 872, 70, "•周六日单人不限时无限畅饮\n•周六日单人不限时撸宠物", "1");
        Commodity commodity2 = new Commodity(3, "/pic/i-入场券.jpg", "单人节假日套餐", 311, 80, "•节假日单人不限时无限畅饮\n•节假日单人不限时撸宠物", "1");
        Commodity commodity3 = new Commodity(4, "/pic/i-入场券.jpg", "双人工作日套餐", 1079, 110, "•工作日双人不限时无限畅饮\n•工作日双人不限时撸宠物", "1");
        Commodity commodity4 = new Commodity(5, "/pic/i-入场券.jpg", "双人周末套餐", 802, 130, "•周六日双人不限时无限畅饮\n•周六日双人不限时撸宠物", "1");
        Commodity commodity5 = new Commodity(6, "/pic/i-入场券.jpg", "双人节假日套餐", 301, 150, "•节假日双人不限时无限畅饮\n•节假日双人不限时撸宠物", "1");
        Commodity commodity6 = new Commodity(7, "/pic/i-入场券.jpg", "三人工作日套餐", 167, 150, "•工作日3人不限时无限畅饮\n•工作日3人不限时撸宠物", "1");
        Commodity commodity7 = new Commodity(8, "/pic/i-入场券.jpg", "三人周末套餐", 87, 180, "•周六日3人不限时无限畅饮\n•周六日3人不限时撸宠物", "1");
        Commodity commodity8 = new Commodity(9, "/pic/i-入场券.jpg", "三人节假日套餐", 31, 210, "•节假日3人不限时无限畅饮\n•节假日3人不限时撸宠物", "1");

        /* 宠物护理 */
        Commodity commodity9 = new Commodity(10, "/pic/i-短毛猫洗澡.jpg", "短毛猫洗澡", 217, 39.9, "•适用宠物：猫咪\n•适用体重：1-10kg\n•适用毛长：短毛\n•包含项目：全身洗护", "2");
        Commodity commodity10 = new Commodity(11, "/pic/i-长毛猫洗澡.jpg", "长毛猫洗澡", 145, 52.9, "•适用宠物：猫咪\n•适用体重：1-10kg\n•适用毛长：长毛\n•包含项目：全身洗护", "2");
        Commodity commodity11 = new Commodity(12, "/pic/i-小型犬洗澡.jpg", "小型犬洗澡", 37, 29.9, "•适用宠物：狗狗\n•适用体重：1-10kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛", "2");
        Commodity commodity12 = new Commodity(13, "/pic/i-中型犬洗澡.jpg", "中型犬洗澡", 35, 52.9, "•适用宠物：狗狗\n•适用体重：10-20kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛", "2");
        Commodity commodity13 = new Commodity(14, "/pic/i-大型犬洗澡.jpg", "大型犬洗澡", 20, 89.9, "•适用宠物：狗狗\n•适用体重：20-30kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛", "2");
        Commodity commodity14 = new Commodity(15, "/pic/i-犬猫毛发修剪.jpg", "犬猫毛发修剪", 29, 148, "•适用宠物：猫咪、狗狗\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：毛发修剪、全身洗护", "2");

        /* 宠物寄养 */
        Commodity commodity15 = new Commodity(16, "/pic/i-寄养抽屉间.jpg", "犬猫寄养一天抽屉间", 56, 40, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");
        Commodity commodity16 = new Commodity(17, "/pic/i-寄养抽屉间.jpg", "犬猫寄养一周抽屉间", 15, 250, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");
        Commodity commodity17 = new Commodity(18, "/pic/i-寄养抽屉间.jpg", "犬猫寄养一月抽屉间", 8, 688, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");
        Commodity commodity18 = new Commodity(19, "/pic/i-寄养豪华单间.jpg", "犬猫寄养一天豪华单间", 54, 78, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");
        Commodity commodity19 = new Commodity(20, "/pic/i-寄养豪华单间.jpg", "犬猫寄养一周豪华单间", 11, 488, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");
        Commodity commodity20 = new Commodity(21, "/pic/i-寄养豪华单间.jpg", "犬猫寄养一月豪华单间", 3, 1388, "•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食", "3");

        /* 个人饮品 */
        Commodity commodity21 = new Commodity(22, "/pic/j-柠啡.jpg", "柠啡", 19, 11.9, "柠檬、咖啡因、700毫升", "4");
        Commodity commodity22 = new Commodity(23, "/pic/j-生椰拿铁.jpg", "生椰拿铁", 68, 12.9, "咖啡因、500毫升", "4");
        Commodity commodity23 = new Commodity(24, "/pic/j-美式咖啡.jpg", "美式咖啡", 9, 11.9, "咖啡因、500毫升", "4");
        Commodity commodity24 = new Commodity(25, "/pic/j-3Q百香果.jpg", "3Q百香果", 642, 12.9, "1000毫升", "4");
        Commodity commodity25 = new Commodity(26, "/pic/j-满杯水果茶.jpg", "满杯水果茶", 345, 12.9, "西瓜、1000毫升", "4");
        Commodity commodity26 = new Commodity(27, "/pic/j-霸气橙子.jpg", "霸气橙子", 244, 12.9, "橙子、1000毫升", "4");
        Commodity commodity27 = new Commodity(28, "/pic/j-火烧大柠茶.jpg", "火烧大柠茶", 172, 15.9, "柠檬、红茶、1000毫升", "4");
        Commodity commodity28 = new Commodity(29, "/pic/j-黑糖波霸鲜奶.jpg", "黑糖波霸鲜奶", 167, 10.9, "茶、牛奶、500毫升", "4");
        Commodity commodity29 = new Commodity(30, "/pic/j-芒芒甘露.jpg", "芒芒甘露", 125, 12.9, "耶乳、芒果、700毫升", "4");
        Commodity commodity30 = new Commodity(31, "/pic/j-珍珠奶茶.jpg", "珍珠奶茶", 1214, 10.9, "牛奶、茶、500毫升", "4");
        Commodity commodity31 = new Commodity(32, "/pic/j-杨枝甘露.jpg", "杨枝甘露", 101, 15.9, "芒果、700毫升", "4");
        Commodity commodity32 = new Commodity(33, "/pic/j-春见.jpg", "春见", 43, 14.9, "柠檬、1000毫升", "4");
        Commodity commodity33 = new Commodity(34, "/pic/j-凤梧桐.jpg", "凤梧桐", 41, 14.9, "柠檬、乌龙茶、1000毫升", "4");
        Commodity commodity34 = new Commodity(35, "/pic/j-西瓜啵啵.jpg", "西瓜啵啵", 73, 13.9, "西瓜、1000毫升", "4");
        Commodity commodity35 = new Commodity(36, "/pic/j-快乐柠檬水.jpg", "快乐柠檬水", 35, 9.9, "柠檬、1000毫升", "4");
        Commodity commodity36 = new Commodity(37, "/pic/j-青梅柠檬茶.jpg", "青梅柠檬茶", 17, 15.9, "柠檬、青梅、700毫升", "4");
        Commodity commodity37 = new Commodity(38, "/pic/j-多肉葡萄.jpg", "多肉葡萄", 93, 14.9, "葡萄、700毫升", "4");
        Commodity commodity38 = new Commodity(39, "/pic/j-大柠绿.jpg", "大柠绿", 7, 15.9, "绿茶、柠檬、500毫升", "4");
        Commodity commodity39 = new Commodity(40, "/pic/j-鸭屎香柠檬茶.jpg", "鸭屎香柠檬茶", 95, 12.9, "乌龙茶、柠檬、700毫升", "4");
        Commodity commodity40 = new Commodity(41, "/pic/j-金桔柠檬茶.jpg", "金桔柠檬茶", 20, 14.9, "柠檬、金桔、1000毫升", "4");
        Commodity commodity41 = new Commodity(42, "/pic/j-葡萄鲜奶茶.jpg", "葡萄鲜奶茶", 24, 12.9, "葡萄、500毫升", "4");
        Commodity commodity42 = new Commodity(43, "/pic/j-奶茶三兄弟.jpg", "奶茶三兄弟", 82, 10.9, "珍珠、烧仙草、500毫升", "4");
        Commodity commodity43 = new Commodity(44, "/pic/j-椰果奶茶.jpg", "椰果奶茶", 39, 10.9, "红茶、椰果、500毫升", "4");
        Commodity commodity44 = new Commodity(45, "/pic/j-烧仙草奶茶.jpg", "烧仙草奶茶", 64, 10.9, "仙草冻、500毫升", "4");
        Commodity commodity45 = new Commodity(46, "/pic/j-招牌奶茶.jpg", "招牌奶茶", 30, 10.9, "牛奶、绿茶、500毫升", "4");
        Commodity commodity46 = new Commodity(47, "/pic/j-黑钻奶茶.jpg", "黑钻奶茶", 38, 10.9, "红茶、牛奶、500毫升", "4");

        commodityMapper.insert(commodity0);
        commodityMapper.insert(commodity1);
        commodityMapper.insert(commodity2);
        commodityMapper.insert(commodity3);
        commodityMapper.insert(commodity4);
        commodityMapper.insert(commodity5);
        commodityMapper.insert(commodity6);
        commodityMapper.insert(commodity7);
        commodityMapper.insert(commodity8);

        commodityMapper.insert(commodity9);
        commodityMapper.insert(commodity10);
        commodityMapper.insert(commodity11);
        commodityMapper.insert(commodity12);
        commodityMapper.insert(commodity13);
        commodityMapper.insert(commodity14);

        commodityMapper.insert(commodity15);
        commodityMapper.insert(commodity16);
        commodityMapper.insert(commodity17);
        commodityMapper.insert(commodity18);
        commodityMapper.insert(commodity19);
        commodityMapper.insert(commodity20);

        commodityMapper.insert(commodity21);
        commodityMapper.insert(commodity22);
        commodityMapper.insert(commodity23);
        commodityMapper.insert(commodity24);
        commodityMapper.insert(commodity25);
        commodityMapper.insert(commodity26);
        commodityMapper.insert(commodity27);
        commodityMapper.insert(commodity28);
        commodityMapper.insert(commodity29);
        commodityMapper.insert(commodity30);
        commodityMapper.insert(commodity31);
        commodityMapper.insert(commodity32);
        commodityMapper.insert(commodity33);
        commodityMapper.insert(commodity34);
        commodityMapper.insert(commodity35);
        commodityMapper.insert(commodity36);
        commodityMapper.insert(commodity37);
        commodityMapper.insert(commodity38);
        commodityMapper.insert(commodity39);
        commodityMapper.insert(commodity40);
        commodityMapper.insert(commodity41);
        commodityMapper.insert(commodity42);
        commodityMapper.insert(commodity43);
        commodityMapper.insert(commodity44);
        commodityMapper.insert(commodity45);
        commodityMapper.insert(commodity46);


    }

    @Test
    public void test1() {

        int pid = 101;
        int uid = 3;
        Pet pet = petMapper.selectById(pid);
        String petScoredStr = pet.getPhadscoreduserid();
        String[] petScoredStrArr = petScoredStr.split(",");

        int[] petScoredArr = new int[petScoredStrArr.length];
        for (int i = 0; i < petScoredStrArr.length; i++) {
            petScoredArr[i] = Integer.parseInt(petScoredStrArr[i]);
        }
        for (int j = 0; j < petScoredArr.length; j++) {
            if (petScoredArr[j] == uid) {
                System.out.println("1");
            }
        }
    }
}
