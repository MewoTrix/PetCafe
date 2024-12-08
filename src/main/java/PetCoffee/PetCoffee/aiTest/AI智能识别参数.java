/*
┌─────────────────────────────────────────────────────────────────────────────────────────┐
│    🐱动物识别 请求参数详情                                                                 │
│                                                                                         │
│        参数名称	    是否必选	    类型	        默认值	    说明                           │
│        image	        是	        mixed		            本地图片路径或者图片二进制数据     │
│        top_num	    否	        String	    6	        返回预测得分top结果数，默认为6    │
│        baike_num	    否	        String	    0	        返回百科信息的结果数，默认不返回   │
└─────────────────────────────────────────────────────────────────────────────────────────┘


┌─────────────────────────────────────────────────────────────────────────────────────────┐
│    🐱动物识别 返回数据参数详情                                                             │
│                                                                                         │
│        参数	        类型	            是否必须	    说明                                   │
│        log_id	        uint64	        是	        唯一的log id，用于问题定位               │
│        result	        arrry(object)	是	        识别结果数组                            │
│        +name	        string	        是	        动物名称，示例：蒙古马                    │
│        +score	        uint32	        是	        置信度，示例：0.5321                     │
│        +baike_info	object		    否	        对应识别结果的百科词条名称                 │
│        ++baike_url	string		    否	        对应识别结果百度百科页面链接               │
│        ++image_url	string		    否	        对应识别结果百科图片链接                  │
│        ++description	string		    否	        对应识别结果百科内容描述                  │
└─────────────────────────────────────────────────────────────────────────────────────────┘
*/

/*
    👉 请求示例

    👉 HTTP 方法：    POST

    👉 请求URL：      https://aip.baidubce.com/rest/2.0/image-classify/v1/animal

    👉 URL参数：
            参数值
                access_token	通过API Key和Secret Key获取的access_token,参考“Access Token获取”

    👉 Header如下：
            参数值
                Content-Type	application/x-www-form-urlencoded

    👉 Body中放置请求参数，参数详情如下：
            请求参数

            参数名称	    是否必选	        类型说明
            image	    和url二选一	    string	    图像数据，base64编码，要求base64编码后大小不超过4M，
                                                    最短边至少15px，最长边最大4096px,
                                                    支持jpg/png/bmp格式。
                                                    注意：图片需要base64编码、去掉编码头后再进行urlencode。

            url	        和image二选一	string	    图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，
                                                    最短边至少15px，最长边最大4096px,支持jpg/png/bmp格式，当image字段存在时url字段失效。

            top_num	    否	            integer	    返回预测得分top结果数，默认为6

            baike_num	否	            integer	    用于控制返回结果是否带有百科信息，若不输入此参数，则默认不返回百科结果；
                                                    若输入此参数，会根据输入的整数返回相应个数的百科信息
 */


/*  ✔是动物返回
        {
          "result": [
            {
              "score": "0.412126",
              "name": "波斯猫",
              "baike_info": {
                  "baike_url": "http://baike.baidu.com/item/%E6%B3%A2%E6%96%AF%E7%8C%AB/585",
                  "image_url": "https://bkimg.cdn.bcebos.com/pic/cc11728b4710b9123e0206d7cefdfc03934522dc",
                  "description": "波斯猫(Persian cat)是以阿富汗的土种长毛猫和土耳其的安哥拉长毛猫为基础，在英国经过100多年的选种繁殖，于1860年诞生的一个品种。波斯猫是最常见的长毛猫，波斯猫有一张讨人喜爱的面庞，长而华丽的背毛，优雅的举止，故有\u201c猫中王子\u201d、\u201c王妃\u201d之称，是世界上爱猫者最喜欢的纯种猫之一，占有极其重要的地位。"
              }
            },
            {
              "score": "0.412126",
              "name": "波斯猫",
              "baike_info": {
                  "baike_url": "http://baike.biaidu.com/item/%E6%B3%A2%E6%96%AF%E7%8C%AB/585",
                  "image_url": "https://bkimg.cdn.bcebos.com/pic/cc11728b4710b9123e0206d7cefdfc03934522dc",
                  "description": "波斯猫(Persian cat)是以阿富汗的土种长毛猫和土耳其的安哥拉长毛猫为基础，在英国经过100多年的选种繁殖，于1860年诞生的一个品种。波斯猫是最常见的长毛猫，波斯猫有一张讨人喜爱的面庞，长而华丽的背毛，优雅的举止，故有\u201c猫中王子\u201d、\u201c王妃\u201d之称，是世界上爱猫者最喜欢的纯种猫之一，占有极其重要的地位。"
              }
            },
          ],
          "log_id": 1589229549289174264
        }
*/

/*  ❌非动物返回
    {
      "result": [
        {
          "score": "0.999536",
          "name": "非动物",
          "baike_info": {}
        }
      ],
      "log_id": 1589229549289174264
    }
*/

