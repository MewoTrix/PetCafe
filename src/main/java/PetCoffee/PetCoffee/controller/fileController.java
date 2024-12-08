package PetCoffee.PetCoffee.controller;

import PetCoffee.PetCoffee.Mybatis_interface.PetMapper;
import PetCoffee.PetCoffee.bean.Pet;
import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@CrossOrigin
@RestController
public class fileController {

    @Autowired
    PetMapper petMapper;
    //设置APPID/AK/SK
    public static final String APP_ID = "28278989";
    public static final String API_KEY = "ABHhLMCZGCTisLRZMXChVz7u";
    public static final String SECRET_KEY = "IfBo2O3FqhAstajDMamfPuNu04lC78OK";
    String newFileName;
    String pathForUpImg = "F:\\大三上学期\\毕设\\PetCoffee\\src\\main\\resources\\static\\uploadPic";
    String packPathForUpImg = "F:\\大三上学期\\毕设\\PetCoffee\\src\\main\\resources\\static\\uploadPic\\";
    String deskPetPic = "F:\\大三上学期\\毕设\\PetCoffee\\src\\main\\resources\\static\\pic";

    /*  保存图片到磁盘，返回图片识别结果以JSon形式到前端  */
    @PostMapping("addPic")
    public String addPic(MultipartFile file) throws Exception {
        // 获取文件后缀
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        // 重命名图片
        newFileName = "识别图" + preName;

        File putInDeskImgFile = new File(pathForUpImg, newFileName);

        if (putInDeskImgFile.exists()) {
            putInDeskImgFile.delete();
        }

        putInDeskImgFile.createNewFile();

        // 图片保存
        file.transferTo(putInDeskImgFile);

        // 文件对象
        File checkFile = new File((packPathForUpImg + newFileName));

        /*
            动物识别
        */
        // 初始化智能识别类
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // （可选）设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 设置可选参数
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "4");
        options.put("baike_num", "4");

        // 开始识别
        String path = pathForUpImg + "\\" + newFileName;
        JSONObject aiAnimalJsonObj = client.animalDetect(path, options);

        String str = aiAnimalJsonObj.toString(4);

        checkFile.delete();

        return str;

    }

    /* 保存改变的宠物卡通图，并返回路径 */
    @PostMapping("change-cartoon-by-pid")
    public String changeCartoonByPid(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 保存改变的宠物头像图，并返回路径 */
    @PostMapping("change-realpic-by-pid")
    public String changeRealpicByPid(MultipartFile file) throws IOException{
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 保存改变的宠物详情1图，并返回路径 */
    @PostMapping("change-pdetail1pic-by-pid")
    public String changePdetail1picByPid(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 保存改变的宠物详情2图，并返回路径 */
    @PostMapping("change-pdetail2pic-by-pid")
    public String changePdetail2picByPid(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 保存改变的宠物详情3图，并返回路径 */
    @PostMapping("change-pdetail3pic-by-pid")
    public String changePdetail3picByPid(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增宠物卡通图，并返回路径 */
    @PostMapping("create-cartoon")
    public String createCartoon(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增宠物头像图，并返回路径 */
    @PostMapping("create-realpic")
    public String createRealpic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增宠物详情1图，并返回路径 */
    @PostMapping("create-pdetail1pic")
    public String createPdetail1pic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增宠物详情2图，并返回路径 */
    @PostMapping("create-pdetail2pic")
    public String createPdetail2pic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增宠物详情3图，并返回路径 */
    @PostMapping("create-pdetail3pic")
    public String createPdetail3pic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增商品图，并返回路径 */
    @PostMapping("create-commodity-pic")
    public String createCommodityPic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }

    /* 新增商品图，并返回路径 */
    @PostMapping("change-commodity-pic")
    public String changeCommodityPic(MultipartFile file) throws IOException {
        /* 随机名 */
        String fileLatterName = UUID.randomUUID().toString().replace("-", "");
        /* 获取文件后缀 */
        String preName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        /* 文件全名 */
        String filename = fileLatterName + preName;
        /* 保存 */
        File file1 = new File(deskPetPic, filename);
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        /* 图片保存 */
        file.transferTo(file1);
        return "/pic/" + (fileLatterName + preName);
    }



}
