package PetCoffee.PetCoffee.aiTest;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static PetCoffee.PetCoffee.PetCoffeeApplication.disableWarning;

public class test {

    public static void main(String[] args) {

        String a = "1,2";
        a += ",3";
        System.out.println(a);
    }

}

