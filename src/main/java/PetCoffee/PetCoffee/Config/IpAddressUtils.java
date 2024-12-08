package PetCoffee.PetCoffee.Config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class IpAddressUtils {
    /**
     * 根据ip获取地址
     * @param ip
     * @return
     */
    public static String getAddress(String ip) {
        String url = "http://ip.ws.126.net/ipquery?ip=" + ip;
        String str = HttpUtil.get(url);
        if(!StrUtil.hasBlank(str)){
            String substring = str.substring(str.indexOf("{"), str.indexOf("}")+1);
            System.out.println(substring);
            JSONObject jsonObject = JSONUtil.parseObj(substring);
            String province = jsonObject.getStr("province");
            String city = jsonObject.getStr("city");
            return province + " " + city;
        }
        return null;
    }
}
