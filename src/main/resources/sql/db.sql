SET
FOREIGN_KEY_CHECKS=0;


/***************************************************************
	👮‍️【管理员】属性
***************************************************************/
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `aid`   int(11) NOT NULL,
    `apwd`  varchar(30) NOT NULL,
    `aname` varchar(10) NOT NULL,
    PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


/***************************************************************
	👮‍【管理员】创建成员
***************************************************************/
INSERT INTO `admin` VALUES (1, 'abc123', '管理员1');
INSERT INTO `admin` VALUES (2, 'abc123', '管理员2');
INSERT INTO `admin` VALUES (3, 'abc123', '管理员3');
INSERT INTO `admin` VALUES (4, 'abc123', '管理员4');
INSERT INTO `admin` VALUES (5, 'abc123', '管理员5');
INSERT INTO `admin` VALUES (6, 'abc123', '管理员6');
INSERT INTO `admin` VALUES (7, 'abc123', '管理员7');
INSERT INTO `admin` VALUES (8, 'abc123', '管理员8');
INSERT INTO `admin` VALUES (9, 'abc123', '管理员9');
INSERT INTO `admin` VALUES (10, 'abc123', '管理员10');
INSERT INTO `admin` VALUES (11, 'abc123', '管理员11');
INSERT INTO `admin` VALUES (12, 'abc123', '管理员12');
INSERT INTO `admin` VALUES (13, 'abc123', '管理员13');
INSERT INTO `admin` VALUES (14, 'abc123', '管理员14');
INSERT INTO `admin` VALUES (15, 'abc123', '管理员15');
INSERT INTO `admin` VALUES (16, 'abc123', '管理员16');
INSERT INTO `admin` VALUES (17, 'abc123', '管理员17');
INSERT INTO `admin` VALUES (18, 'abc123', '管理员18');
INSERT INTO `admin` VALUES (19, 'abc123', '管理员19');
INSERT INTO `admin` VALUES (20, 'abc123', '管理员20');


/***************************************************************
	👶【用户】属性
***************************************************************/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `uid`   int(11) NOT NULL UNIQUE,
    `upwd`  varchar(30) NOT NULL,
    `uname` varchar(10) NOT NULL,
    PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


/***************************************************************
	👶【用户】创建成员
***************************************************************/
INSERT INTO `user` VALUES (2, 'abc123', '陈一');
INSERT INTO `user` VALUES (3, 'abc123', '唐一');
INSERT INTO `user` VALUES (4, 'abc123', '王一');
INSERT INTO `user` VALUES (5, 'abc123', '罗一');
INSERT INTO `user` VALUES (6, 'abc123', '劳一');
INSERT INTO `user` VALUES (7, 'abc123', '李一');
INSERT INTO `user` VALUES (8, 'abc123', '郑一');
INSERT INTO `user` VALUES (9, 'abc123', '林一');


/***************************************************************
	🐾【宠物】属性
***************************************************************/
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet`
(
    `pid`               int (10) AUTO_INCREMENT PRIMARY KEY, /* pid用来打开宠物详情页 */
    `pcartoonpic`       varchar(400) not null, /* pcartoonpic 卡通图片，存放存在磁盘的图片的地址 */
    `ppic`              varchar(400) not null, /* ppic头像生活照，存放存在磁盘的照片的地址 */
    `pname`             varchar(30)  not null, /* 名字 */
    `pbirth`            varchar(30)  not null, /* 生日 */
    `psex`              varchar(10)  not null, /* 性别 */
    `pweight`           varchar(20)  not null, /* 体重 */
    `pbreed`            varchar(30)  not null, /* 品种 */
    `pwashtime`         varchar(30)  not null, /* 洗护时间 */
    `pbirthskill`       varchar(10)  not null, /* 生育能力 */
    `pinjection`        varchar(10)  not null, /* 疫苗情况 */
    `pillhistory`       varchar(10)  not null, /* 生病历史 */
    `plike`             int(10), /* 点赞数量 */
    `pscoreall`         decimal(4,1), /* 总体评分 */
    `pscoreappearence`  decimal(4,1), /* 外貌评分 */
    `pscorepersonality` decimal(4,1), /* 性格评分 */
    `pscorepersonnum`   int(10), /* 评分人数，用来对评分取平均数（先取出与现在平均数相乘，总分加上后来的评分再除以【这个数+1】） */
    `phadscoreduserid`  varchar(20),/* 已评分的用户的id */
    `pdetailinfo`       json, /* 宠物详情页 */
    `pkind` varchar(50) not null /* 是猫是狗 */
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


/***************************************************************
	🐾【宠物】创建宠物
***************************************************************/
/*
    🐱 1咪咪、2桃心、3大灰、4小妖精、5哒哒、6猫王、7四饼、8小瞎子
    🐕 9饭饭、10大福、11珍珠、12甜甜、13波霸、14泽金、15哈气
    狗名不超7字
    详情展示测试300字
 */
INSERT INTO `pet` VALUES (101, '/petPic/咪咪卡通.png', '/petPic/咪咪头像.jpg', '咪咪', '2019.01', '男', '3.4kg', '英国短毛猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 6, 74.1, 58.6, 89.5, 2, '2,4', '{\"date1\": \"2019-01-01 00:00\", \"date2\": \"2022-06-17 15:19\", \"date3\": \"2022-08-08 13:30\", \"text1\": \"2019年，咪咪被工作人员救助。它的眼睛得了眼疾，未得到有效治疗，被主人抛弃。因为已错过医治的最佳时间，咪咪最后只能摘除眼球，如今用仅剩的一只眼，好奇地观察着世界。\", \"text2\": \"咪咪最近老喜欢躲猫猫，好不容易逮到一只在躲猫猫的咪咪！~\", \"text3\": \"“我就只想安安静静地做一只干饭喵，你为啥老喊我照相？=。=”\", \"Picpath1\": \"/petPic/咪咪详情1.jpg\", \"Picpath2\": \"/petPic/咪咪详情2.jpg\", \"Picpath3\": \"/petPic/咪咪详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (102, '/petPic/桃心卡通.png', '/petPic/桃心头像.jpg', '桃心', '2019.03', '女', '3.5kg', '中华田园猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 10, 74.2, 95.6, 52.8, 2, '2,4', '{\"date1\": \"2022-03-14 16:38\", \"date2\": \"2022-06-11 18:10\", \"date3\": \"2022-08-10 00:00\", \"text1\": \"小可爱又晒太阳啦，一晒就是一下午~偶尔跑下去喝口水又跑上来继续晒~~\", \"text2\": \"桃心领养后的幸福生活，每天吃吃喝喝睡睡，有善良美丽的小姐姐宠着，别提有多开心幸福啦！\", \"text3\": \"分享一张新主人给它拍的“证件照”，喵喵喵？好严肃啊喂！\", \"Picpath1\": \"/petPic/桃心详情1.jpg\", \"Picpath2\": \"/petPic/桃心详情2.jpg\", \"Picpath3\": \"/petPic/桃心详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (103, '/petPic/大灰卡通.png', '/petPic/大灰头像.jpg', '大灰', '2019.05', '男', '3.6kg', '中华田园猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 9, 77.9, 94.4, 61.5, 2, '2,4', '{\"date1\": \"2019-05-05 00:00\", \"date2\": \"2021-11-29 16:22\", \"date3\": \"2022-06-17 17:20\", \"text1\": \"曾经逍遥自在的大灰参加了几届领养日线下活动，但是一直未能找到合适的领养家庭。目前在我们店里，等待被有缘人带走。\", \"text2\": \"大灰最近懒了很多，不过也因为他比较亲人的原因啦，和大家都玩的很好，是个暖心的主子了啦，就是有时候趴在那看人的眼神能不能不要这么高冷啊喂(#`0`)！\", \"text3\": \"大灰是真的很难抓拍到~好不容易把他堵在角落里拍个照片~啧啧\", \"Picpath1\": \"/petPic/大灰详情1.jpg\", \"Picpath2\": \"/petPic/大灰详情2.jpg\", \"Picpath3\": \"/petPic/大灰详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (104, '/petPic/小妖精卡通.png', '/petPic/小妖精头像.jpg', '小妖精', '2017.04', '女', '3.7kg', '中华田园猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 8, 90.6, 86.4, 94.8, 2, '2,4', '{\"date1\": \"2017-10-13 00:00\", \"date2\": \"2021-11-29 17:23\", \"date3\": \"2022-06-20 21:44\", \"text1\": \"2017年10月，小妖精找到了领养，但是领养人因其他原因又退养了。目前她在我们店铺里，继续等待有缘人。\", \"text2\": \"小妖精越发长得好看，可能是变胖了的原因，加上小妖精很爱干净，每次去草坪玩完都要把自己舔干净，整一支喵又肉肉的又萌，让人忍不住心生怜爱！啥时候等来下一个带它回家的铲屎官捏！\", \"text3\": \"“铲屎的你在干吗，不要打扰我休息”\", \"Picpath1\": \"/petPic/小妖精详情1.jpg\", \"Picpath2\": \"/petPic/小妖精详情2.jpg\", \"Picpath3\": \"/petPic/小妖精详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (105, '/petPic/哒哒卡通.png', '/petPic/哒哒头像.jpg', '哒哒', '2020.05', '男', '3.8kg', '中华田园猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 9, 95.4, 91.8, 98.9, 2, '2,4', '{\"date1\": \"2020-05-01 00:00\", \"date2\": \"2021-11-30 15:20\", \"date3\": \"2021-12-20 13:19\", \"text1\": \"工作人员连续一个月每天给它擦拭药膏，哒哒的皮肤病这才彻底好了。如今，哒哒又恢复了英俊的容颜。\", \"text2\": \"江门的冬天来了，哒哒开始了无休止地睡懒觉之旅，吵醒它可是要被翻白眼的呢！\", \"text3\": \"最近哒哒很喜欢趴在各种高处俯视大家，不知道是不是之前长了一些秋膘的原因，蹦跶上去会比以往吃力一些的感觉呢！\", \"Picpath1\": \"/petPic/哒哒详情1.jpg\", \"Picpath2\": \"/petPic/哒哒详情2.jpg\", \"Picpath3\": \"/petPic/哒哒详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (106, '/petPic/猫王卡通.png', '/petPic/猫王头像.jpg', '猫王', '2021.08', '男', '3.9kg', '中华田园猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 9, 68.8, 73.9, 63.8, 2, '2,4', '{\"date1\": \"2022-05-25 13:18\", \"date2\": \"2022-08-08 16:04\", \"date3\": \"2022-09-02 18:19\", \"text1\": \"分享一只正在思考猫生的小伙子，猫王你在想什么呀？是在回首过往的某一任”媳妇“吗？(一脸坏笑？(????ω????)?)\", \"text2\": \"逮到一只站岗的猫王，这小家伙就爱笔直笔直地在店里站岗！\", \"text3\": \"来分享一波猫王帅气侧漏的”证件照“，多少是有点帅的，不然曾经也不会有那么多”小媳妇“~~而且猫王真的很爱干净啊，脸上总是舔得干干净净的！\", \"Picpath1\": \"/petPic/猫王详情1.jpg\", \"Picpath2\": \"/petPic/猫王详情2.jpg\", \"Picpath3\": \"/petPic/猫王详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (107, '/petPic/四饼卡通.png', '/petPic/四饼头像.jpg', '四饼', '2020.07', '男', '4.0kg', '英国短毛猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 9, 82.9, 85.2, 80.7, 2, '2,4', '{\"date1\": \"2022-06-21 19:17\", \"date2\": \"2022-09-09 21:29\", \"date3\": \"2022-10-14 21:20\", \"text1\": \"四饼：卖猫啦！卖猫啦！铲屎的，你是要把我卖掉吗？（→_→）工作人员：我要去搬东西了，您能别妨碍我工作吗？（=。=|||）\", \"text2\": \"”你为什么宁愿看电视剧都不陪我玩，是我没有电视剧有趣吗，喵呜~emo了“\", \"text3\": \"”我想睡觉了，帮我关下灯，谢谢~“\", \"Picpath1\": \"/petPic/四饼详情1.jpg\", \"Picpath2\": \"/petPic/四饼详情2.jpg\", \"Picpath3\": \"/petPic/四饼详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (108, '/petPic/小瞎子卡通.png', '/petPic/小瞎子头像.jpg', '小瞎子', '2021.05', '女', '4.1kg', '狸花猫', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 8, 79.8, 76.1, 83.6, 2, '2,4', '{\"date1\": \"2022-07-22 11:28\", \"date2\": \"2022-08-29 12:42\", \"date3\": \"2022-10-25 14:30\", \"text1\": \"欢迎四饼的好朋友”小瞎子“也一起入驻店铺！鼓掌!（对，它们俩天天在一起玩耍，听说四饼来了，它也要争着”出镜“~~~~）\", \"text2\": \"今天的安排是和四饼儿一起晒太阳~（小瞎子：这四饼多少有点”心机“的喂，还扭头卖萌~~这会不会显得我很正经无趣？）\", \"text3\": \"今天和四饼一起仰望天空，思考喵生~（小瞎子：过分~这货每次都抢镜头~我在后面我在后面！）\", \"Picpath1\": \"/petPic/小瞎子详情1.jpg\", \"Picpath2\": \"/petPic/小瞎子详情2.jpg\", \"Picpath3\": \"/petPic/小瞎子详情3.jpg\"}','猫');
INSERT INTO `pet` VALUES (109, '/petPic/饭饭卡通.png', '/petPic/饭饭头像.jpg', '饭饭', '2021.06', '男', '4.3kg', '湖畔梗犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 7, 84.5, 96.8, 72.2, 2, '2,4', '{\"date1\": \"2021-06-15 00:00\", \"date2\": \"2021-12-20 14:11\", \"date3\": \"2022-02-13 13:28\", \"text1\": \"2021年6月15日，工作人员钱阿姨过院外垃圾桶时，听到里面传来微弱的呻吟声。赶过去一看，发现桶里蜷缩着一只脏兮兮的小狗。钱阿姨起初以为它和过往那些小狗一样，是被不负责任的主人弃养的。但抱出来一看，发现千疮百孔，令人心痛。“世界以痛击我，我回报以歌”，饭饭经过救治后痊愈，噩梦般的以前没有给它留下太多阴影，它还是那么快乐、那么温柔。\", \"text2\": \"这几天洗白白后的饭饭真的是太好rua了，毛毛好舒服~rua多几下它还会来蹭你，真的好暖心好治愈阿喂！\", \"text3\": \"江门的冬天真的太冷啦~~最近温度一骤降，饭饭就特别粘人，喝完水之后还蹭过来，呀~~你嘴巴湿湿的，快甩干净再靠过来啊喂~~\", \"Picpath1\": \"/petPic/饭饭详情1.jpg\", \"Picpath2\": \"/petPic/饭饭详情2.jpg\", \"Picpath3\": \"/petPic/饭饭详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (110, '/petPic/大福卡通.png', '/petPic/大福头像.jpg', '大福', '2019.02', '男', '4.4kg', '湖畔梗犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 5, 69.8, 79.7, 59.8, 2, '2,4', '{\"date1\": \"2022-08-11 12:06\", \"date2\": \"2022-08-27 11:11\", \"date3\": \"2022-09-15 15:05\", \"text1\": \"之前忙得晕头转向的工作人员把后面那位小伙伴的照片当成大福的来上传了，多少有些尴尬哈哈！来啦，大家再仔细看看，大福并没有被养掉色了啦~不过还是那么的潦草倒是真的哈哈哈~\", \"text2\": \"“好热呀，好晒呀，你看我这照片里舌头都要被晒黑了”“明明就是阴影背光的问题好嘛==”\", \"text3\": \"今早打扫卫生的时候，大福突然跑过来站在工作人员面前，不吼不叫，这是要干嘛呀？\", \"Picpath1\": \"/petPic/大福详情1.jpg\", \"Picpath2\": \"/petPic/大福详情2.jpg\", \"Picpath3\": \"/petPic/大福详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (111, '/petPic/珍珠卡通.png', '/petPic/珍珠头像.jpg', '珍珠', '2019.07', '男', '4.5kg', '雪橇犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 3, 91.1, 83.3, 98.8, 2, '2,4', '{\"date1\": \"2021-10-15 00:00\", \"date2\": \"2022-05-28 15:14\", \"date3\": \"2022-06-18 16:19\", \"text1\": \"珍珠曾经生活在犬留所，性格温顺的它经常被同类欺负。因为抢不到吃的，曾经的珍珠瘦得像一张纸片，全身溃烂，一点儿也看不出阿拉斯加的样子。现在已经是个毛茸茸的漂亮毛孩儿了。\", \"text2\": \"分享一只肥墩墩的可爱珍珠~~可太喜欢它了~摸上去手感很好~~\", \"text3\": \"大家好，今天给大家介绍下珍珠的好姐妹好闺蜜贝壳~~噔噔噔~~他们经常形影不离，贝壳是珍珠的跟屁虫~~两只毛茸茸的小可爱（哦不，是大可爱！）走来走去巡逻似的，可把大家都逗笑坏了~~（悄咪咪地提醒下，珍珠是男孩子，贝壳是女孩子哦~他们年纪相仿，珍珠比贝壳稍微大只一些~）\", \"Picpath1\": \"/petPic/珍珠详情1.jpg\", \"Picpath2\": \"/petPic/珍珠详情2.jpg\", \"Picpath3\": \"/petPic/珍珠详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (112, '/petPic/甜甜卡通.png', '/petPic/甜甜头像.jpg', '甜甜', '2019.09', '男', '4.6kg', '古代牧羊犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 2, 74.6, 89, 60.1, 2, '2,4', '{\"date1\": \"2021-11-25 09:00\", \"date2\": \"2022-06-16 11:28\", \"date3\": \"2022-08-14 14:20\", \"text1\": \"光头也很帅的甜甜，终于长出毛来啦！长毛的甜甜更帅了！比以前自信了，不再是趴在窗边偷偷看外面的小伙子，学会了凹造型和到处蹦跶~但是，甜甜，你什么时候才能爱上洗澡呢喂~\", \"text2\": \"大家好，今日分享一只趴在围栏上卖萌的甜甜~^0^\", \"text3\": \"甜甜每天都在休闲区域边默默地站着，大家都在奔跑玩耍，只有甜甜经常站在那眺望着远方~是在思考汪生吗~O.O\", \"Picpath1\": \"/petPic/甜甜详情1.jpg\", \"Picpath2\": \"/petPic/甜甜详情2.jpg\", \"Picpath3\": \"/petPic/甜甜详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (113, '/petPic/波霸卡通.png', '/petPic/波霸头像.jpg', '波霸', '2020.09', '男', '4.7kg', '边境牧羊犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 9, 64.8, 51.2, 78.5, 2, '2,4', '{\"date1\": \"2021-11-25 09:00\", \"date2\": \"2022-06-22 16:09\", \"date3\": \"2022-07-25 13:29\", \"text1\": \"冬天是蓄毛的季节，波霸身上的毛也浓密了些许，经过梳洗一番之后的波霸干净了很多哦，看起来有精神多了！会开始主动靠近你，不再是以前默默地从你身边路过的波霸了，虽然没那么高冷，但是很暖很惹人爱呢！\", \"text2\": \"给大家分享下今日帅气三连拍的波霸，看它眼神，多少是有些对镜头的蔑视在里头的！！~\", \"text3\": \"今天分享的是，走路被抓拍的波霸，憨憨中带着二哈的气息是怎么回事？怎么有点像网上的某张表情包？\", \"Picpath1\": \"/petPic/波霸详情1.jpg\", \"Picpath2\": \"/petPic/波霸详情2.jpg\", \"Picpath3\": \"/petPic/波霸详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (114, '/petPic/泽金卡通.png', '/petPic/泽金头像.jpg', '泽金', '2021.12', '女', '4.8kg', '中华田园犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 1, 83.5, 71.5, 95.5, 2, '2,4', '{\"date1\": \"2021-12-15 00:00\", \"date2\": \"2022-06-20 17:19\", \"date3\": \"2022-08-07 20:30\", \"text1\": \"泽金是在社区流浪被居民发现救助送来店里的，送来的时候身体无大碍，现在在店里过的快活的日子。\", \"text2\": \"夏天到了，分享一只伸懒腰的泽金~\", \"text3\": \"“铲屎的，让我发会儿呆行吗~别老拍我~说你呢~还拍~”\", \"Picpath1\": \"/petPic/泽金详情1.jpg\", \"Picpath2\": \"/petPic/泽金详情2.jpg\", \"Picpath3\": \"/petPic/泽金详情3.jpg\"}','狗');
INSERT INTO `pet` VALUES (115, '/petPic/哈气卡通.png', '/petPic/哈气头像.jpg', '哈气', '2021.08', '女', '5.0kg', '哈士奇犬', '一月一次', '未绝育', '已打全部疫苗', '无以往病史', 3, 54.8, 55.6, 54, 2, '2,4', '{\"date1\": \"2021-08-05 00:00\", \"date2\": \"2021-11-28 11:04\", \"date3\": \"2022-01-15 13:03\", \"text1\": \"2021年8月，哈气被志原者从狗车上面救了下来，差一点被送上了餐桌！\", \"text2\": \"分享一张哈气雪地里的英姿照片，毛茸茸的哈气与雪天更配哦！\", \"text3\": \"前两月哈气被领养，据说在新家的日子过得可太舒爽了，不是吃就是睡，长得更帅气了呢！\", \"Picpath1\": \"/petPic/哈气详情1.jpg\", \"Picpath2\": \"/petPic/哈气详情2.jpg\", \"Picpath3\": \"/petPic/哈气详情3.jpg\"}','狗');


/***************************************************************
	📦【商品】属性
***************************************************************/
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`
(
    `cid`       int (10) AUTO_INCREMENT PRIMARY KEY,
    `cpic`      varchar(400)  not null,
    `cname`     varchar(400)  not null,
    `csalenum`  varchar(30)   not null,
    `cprice`    decimal(5, 1) not null,
    `cdetail`   varchar(1000) not null,
    `ccategory` varchar(20)   not null
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/***************************************************************
	📦【商品】创建商品
***************************************************************/
INSERT INTO `commodity` VALUES (1, '/pic/i-入场券.jpg', '单人工作日套餐', '1679', 60.0, '•工作日单人不限时无限畅饮\n•工作日单人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (2, '/pic/i-入场券.jpg', '单人周末套餐', '872', 70.0, '•周六日单人不限时无限畅饮\n•周六日单人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (3, '/pic/i-入场券.jpg', '单人节假日套餐', '311', 80.0, '•节假日单人不限时无限畅饮\n•节假日单人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (4, '/pic/i-入场券.jpg', '双人工作日套餐', '1079', 110.0, '•工作日双人不限时无限畅饮\n•工作日双人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (5, '/pic/i-入场券.jpg', '双人周末套餐', '802', 130.0, '•周六日双人不限时无限畅饮\n•周六日双人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (6, '/pic/i-入场券.jpg', '双人节假日套餐', '301', 150.0, '•节假日双人不限时无限畅饮\n•节假日双人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (7, '/pic/i-入场券.jpg', '三人工作日套餐', '167', 150.0, '•工作日3人不限时无限畅饮\n•工作日3人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (8, '/pic/i-入场券.jpg', '三人周末套餐', '87', 180.0, '•周六日3人不限时无限畅饮\n•周六日3人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (9, '/pic/i-入场券.jpg', '三人节假日套餐', '31', 210.0, '•节假日3人不限时无限畅饮\n•节假日3人不限时撸宠物', '1');
INSERT INTO `commodity` VALUES (22, '/pic/j-柠啡.jpg', '柠啡', '19', 11.9, '柠檬、咖啡因、700毫升', '2');
INSERT INTO `commodity` VALUES (23, '/pic/j-生椰拿铁.jpg', '生椰拿铁', '68', 12.9, '咖啡因、500毫升', '2');
INSERT INTO `commodity` VALUES (24, '/pic/j-美式咖啡.jpg', '美式咖啡', '9', 11.9, '咖啡因、500毫升', '2');
INSERT INTO `commodity` VALUES (25, '/pic/j-3Q百香果.jpg', '3Q百香果', '642', 12.9, '1000毫升', '2');
INSERT INTO `commodity` VALUES (26, '/pic/j-满杯水果茶.jpg', '满杯水果茶', '345', 12.9, '西瓜、1000毫升', '2');
INSERT INTO `commodity` VALUES (27, '/pic/j-霸气橙子.jpg', '霸气橙子', '244', 12.9, '橙子、1000毫升', '2');
INSERT INTO `commodity` VALUES (28, '/pic/j-火烧大柠茶.jpg', '火烧大柠茶', '172', 15.9, '柠檬、红茶、1000毫升', '2');
INSERT INTO `commodity` VALUES (29, '/pic/j-黑糖波霸鲜奶.jpg', '黑糖波霸鲜奶', '167', 10.9, '茶、牛奶、500毫升', '2');
INSERT INTO `commodity` VALUES (30, '/pic/j-芒芒甘露.jpg', '芒芒甘露', '125', 12.9, '耶乳、芒果、700毫升', '2');
INSERT INTO `commodity` VALUES (31, '/pic/j-珍珠奶茶.jpg', '珍珠奶茶', '1214', 10.9, '牛奶、茶、500毫升', '2');
INSERT INTO `commodity` VALUES (32, '/pic/j-杨枝甘露.jpg', '杨枝甘露', '101', 15.9, '芒果、700毫升', '2');
INSERT INTO `commodity` VALUES (33, '/pic/j-春见.jpg', '春见', '43', 14.9, '柠檬、1000毫升', '2');
INSERT INTO `commodity` VALUES (34, '/pic/j-凤梧桐.jpg', '凤梧桐', '41', 14.9, '柠檬、乌龙茶、1000毫升', '2');
INSERT INTO `commodity` VALUES (35, '/pic/j-西瓜啵啵.jpg', '西瓜啵啵', '73', 13.9, '西瓜、1000毫升', '2');
INSERT INTO `commodity` VALUES (36, '/pic/j-快乐柠檬水.jpg', '快乐柠檬水', '35', 9.9, '柠檬、1000毫升', '2');
INSERT INTO `commodity` VALUES (37, '/pic/j-青梅柠檬茶.jpg', '青梅柠檬茶', '17', 15.9, '柠檬、青梅、700毫升', '2');
INSERT INTO `commodity` VALUES (38, '/pic/j-多肉葡萄.jpg', '多肉葡萄', '93', 14.9, '葡萄、700毫升', '2');
INSERT INTO `commodity` VALUES (39, '/pic/j-大柠绿.jpg', '大柠绿', '7', 15.9, '绿茶、柠檬、500毫升', '2');
INSERT INTO `commodity` VALUES (40, '/pic/j-鸭屎香柠檬茶.jpg', '鸭屎香柠檬茶', '95', 12.9, '乌龙茶、柠檬、700毫升', '2');
INSERT INTO `commodity` VALUES (41, '/pic/j-金桔柠檬茶.jpg', '金桔柠檬茶', '20', 14.9, '柠檬、金桔、1000毫升', '2');
INSERT INTO `commodity` VALUES (42, '/pic/j-葡萄鲜奶茶.jpg', '葡萄鲜奶茶', '24', 12.9, '葡萄、500毫升', '2');
INSERT INTO `commodity` VALUES (43, '/pic/j-奶茶三兄弟.jpg', '奶茶三兄弟', '82', 10.9, '珍珠、烧仙草、500毫升', '2');
INSERT INTO `commodity` VALUES (44, '/pic/j-椰果奶茶.jpg', '椰果奶茶', '39', 10.9, '红茶、椰果、500毫升', '2');
INSERT INTO `commodity` VALUES (45, '/pic/j-烧仙草奶茶.jpg', '烧仙草奶茶', '64', 10.9, '仙草冻、500毫升', '2');
INSERT INTO `commodity` VALUES (46, '/pic/j-招牌奶茶.jpg', '招牌奶茶', '30', 10.9, '牛奶、绿茶、500毫升', '2');
INSERT INTO `commodity` VALUES (47, '/pic/j-黑钻奶茶.jpg', '黑钻奶茶', '38', 10.9, '红茶、牛奶、500毫升', '2');
INSERT INTO `commodity` VALUES (10, '/pic/i-短毛猫洗澡.jpg', '短毛猫洗澡', '217', 39.9, '•适用宠物：猫咪\n•适用体重：1-10kg\n•适用毛长：短毛\n•包含项目：全身洗护', '3');
INSERT INTO `commodity` VALUES (11, '/pic/i-长毛猫洗澡.jpg', '长毛猫洗澡', '145', 52.9, '•适用宠物：猫咪\n•适用体重：1-10kg\n•适用毛长：长毛\n•包含项目：全身洗护', '3');
INSERT INTO `commodity` VALUES (12, '/pic/i-小型犬洗澡.jpg', '小型犬洗澡', '37', 29.9, '•适用宠物：狗狗\n•适用体重：1-10kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛', '3');
INSERT INTO `commodity` VALUES (13, '/pic/i-中型犬洗澡.jpg', '中型犬洗澡', '35', 52.9, '•适用宠物：狗狗\n•适用体重：10-20kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛', '3');
INSERT INTO `commodity` VALUES (14, '/pic/i-大型犬洗澡.jpg', '大型犬洗澡', '20', 89.9, '•适用宠物：狗狗\n•适用体重：20-30kg\n•适用毛长：无限制\n•包含项目：洗浴清洁、吹风拉毛', '3');
INSERT INTO `commodity` VALUES (15, '/pic/i-犬猫毛发修剪.jpg', '犬猫毛发修剪', '29', 148.0, '•适用宠物：猫咪、狗狗\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：毛发修剪、全身洗护', '3');
INSERT INTO `commodity` VALUES (16, '/pic/i-寄养抽屉间.jpg', '犬猫寄养一天抽屉间', '56', 40.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');
INSERT INTO `commodity` VALUES (17, '/pic/i-寄养抽屉间.jpg', '犬猫寄养一周抽屉间', '15', 250.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');
INSERT INTO `commodity` VALUES (18, '/pic/i-寄养抽屉间.jpg', '犬猫寄养一月抽屉间', '8', 688.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');
INSERT INTO `commodity` VALUES (19, '/pic/i-寄养豪华单间.jpg', '犬猫寄养一天豪华单间', '54', 78.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');
INSERT INTO `commodity` VALUES (20, '/pic/i-寄养豪华单间.jpg', '犬猫寄养一周豪华单间', '11', 488.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');
INSERT INTO `commodity` VALUES (21, '/pic/i-寄养豪华单间.jpg', '犬猫寄养一月豪华单间', '3', 1388.0, '•适用宠物：≥6个月犬猫\n•适用体重：无限制\n•适用毛长：无限制\n•包含项目：宠物寄养、日常饮食', '4');


/***************************************************************
	🛒【购物车】属性
***************************************************************/
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart`
(
    `sid`             int(10) AUTO_INCREMENT PRIMARY KEY,
    `stheuserid`      int(50)  not null,
    `smycommodity`    json                    /* 放Map转的json */
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/***************************************************************
	📜【订单】属性
***************************************************************/
DROP TABLE IF EXISTS `myorder`;
CREATE TABLE `myorder`
(
    `myoid`       int(10) AUTO_INCREMENT PRIMARY KEY,
    `myouid`      int(50) not null,
    `myooderinfo` json
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/***************************************************************
	📜【订单】创建订单
***************************************************************/
INSERT INTO `myorder` VALUES (1, 2, '{\"sum\": 141.60000000000002, \"date\": \"2022-10-30\", \"user\": {\"uid\": 2, \"upwd\": \"abc123\", \"uname\": \"陈一\"}, \"pastStatue\": 1, \"cancelStatue\": 0, \"commodityMap\": [{\"cid\": 1, \"cpic\": \"/pic/i-入场券.jpg\", \"cname\": \"单人工作日套餐\", \"cprice\": 60.0, \"cdetail\": \"•工作日单人不限时无限畅饮\\n•工作日单人不限时撸宠物\", \"csalenum\": 1679, \"ccategory\": \"1\"}, {\"cid\": 26, \"cpic\": \"/pic/j-满杯水果茶.jpg\", \"cname\": \"满杯水果茶\", \"cprice\": 12.9, \"cdetail\": \"西瓜、1000毫升\", \"csalenum\": 345, \"ccategory\": \"2\"}, {\"cid\": 28, \"cpic\": \"/pic/j-火烧大柠茶.jpg\", \"cname\": \"火烧大柠茶\", \"cprice\": 15.9, \"cdetail\": \"柠檬、红茶、1000毫升\", \"csalenum\": 172, \"ccategory\": \"2\"}, {\"cid\": 27, \"cpic\": \"/pic/j-霸气橙子.jpg\", \"cname\": \"霸气橙子\", \"cprice\": 12.9, \"cdetail\": \"橙子、1000毫升\", \"csalenum\": 244, \"ccategory\": \"2\"}, {\"cid\": 10, \"cpic\": \"/pic/i-短毛猫洗澡.jpg\", \"cname\": \"短毛猫洗澡\", \"cprice\": 39.9, \"cdetail\": \"•适用宠物：猫咪\\n•适用体重：1-10kg\\n•适用毛长：短毛\\n•包含项目：全身洗护\", \"csalenum\": 217, \"ccategory\": \"3\"}], \"finishStatue\": 0}');
INSERT INTO `myorder` VALUES (2, 2, '{\"sum\": 413.5, \"date\": \"2022-11-30\", \"user\": {\"uid\": 2, \"upwd\": \"abc123\", \"uname\": \"陈一\"}, \"pastStatue\": 0, \"cancelStatue\": 1, \"commodityMap\": [{\"cid\": 25, \"cpic\": \"/pic/j-3Q百香果.jpg\", \"cname\": \"3Q百香果\", \"cprice\": 12.9, \"cdetail\": \"1000毫升\", \"csalenum\": 642, \"ccategory\": \"2\"}, {\"cid\": 23, \"cpic\": \"/pic/j-生椰拿铁.jpg\", \"cname\": \"生椰拿铁\", \"cprice\": 12.9, \"cdetail\": \"咖啡因、500毫升\", \"csalenum\": 68, \"ccategory\": \"2\"}, {\"cid\": 24, \"cpic\": \"/pic/j-美式咖啡.jpg\", \"cname\": \"美式咖啡\", \"cprice\": 11.9, \"cdetail\": \"咖啡因、500毫升\", \"csalenum\": 9, \"ccategory\": \"2\"}, {\"cid\": 13, \"cpic\": \"/pic/i-中型犬洗澡.jpg\", \"cname\": \"中型犬洗澡\", \"cprice\": 52.9, \"cdetail\": \"•适用宠物：狗狗\\n•适用体重：10-20kg\\n•适用毛长：无限制\\n•包含项目：洗浴清洁、吹风拉毛\", \"csalenum\": 35, \"ccategory\": \"3\"}, {\"cid\": 17, \"cpic\": \"/pic/i-寄养抽屉间.jpg\", \"cname\": \"犬猫寄养一周抽屉间\", \"cprice\": 250.0, \"cdetail\": \"•适用宠物：≥6个月犬猫\\n•适用体重：无限制\\n•适用毛长：无限制\\n•包含项目：宠物寄养、日常饮食\", \"csalenum\": 15, \"ccategory\": \"4\"}, {\"cid\": 1, \"cpic\": \"/pic/i-入场券.jpg\", \"cname\": \"单人工作日套餐\", \"cprice\": 60.0, \"cdetail\": \"•工作日单人不限时无限畅饮\\n•工作日单人不限时撸宠物\", \"csalenum\": 1679, \"ccategory\": \"1\"}, {\"cid\": 26, \"cpic\": \"/pic/j-满杯水果茶.jpg\", \"cname\": \"满杯水果茶\", \"cprice\": 12.9, \"cdetail\": \"西瓜、1000毫升\", \"csalenum\": 345, \"ccategory\": \"2\"}], \"finishStatue\": 0}');
INSERT INTO `myorder` VALUES (3, 2, '{\"sum\": 93.6, \"date\": \"2022-11-30\", \"user\": {\"uid\": 2, \"upwd\": \"abc123\", \"uname\": \"陈一\"}, \"pastStatue\": 0, \"cancelStatue\": 0, \"commodityMap\": [{\"cid\": 11, \"cpic\": \"/pic/i-长毛猫洗澡.jpg\", \"cname\": \"长毛猫洗澡\", \"cprice\": 52.9, \"cdetail\": \"•适用宠物：猫咪\\n•适用体重：1-10kg\\n•适用毛长：长毛\\n•包含项目：全身洗护\", \"csalenum\": 145, \"ccategory\": \"3\"}, {\"cid\": 22, \"cpic\": \"/pic/j-柠啡.jpg\", \"cname\": \"柠啡\", \"cprice\": 11.9, \"cdetail\": \"柠檬、咖啡因、700毫升\", \"csalenum\": 19, \"ccategory\": \"2\"}, {\"cid\": 40, \"cpic\": \"/pic/j-鸭屎香柠檬茶.jpg\", \"cname\": \"鸭屎香柠檬茶\", \"cprice\": 12.9, \"cdetail\": \"乌龙茶、柠檬、700毫升\", \"csalenum\": 95, \"ccategory\": \"2\"}, {\"cid\": 37, \"cpic\": \"/pic/j-青梅柠檬茶.jpg\", \"cname\": \"青梅柠檬茶\", \"cprice\": 15.9, \"cdetail\": \"柠檬、青梅、700毫升\", \"csalenum\": 17, \"ccategory\": \"2\"}], \"finishStatue\": 1}');
INSERT INTO `myorder` VALUES (4, 2, '{\"sum\": 1622.5000000000005, \"date\": \"2022-11-30\", \"user\": {\"uid\": 2, \"upwd\": \"abc123\", \"uname\": \"陈一\"}, \"pastStatue\": 0, \"cancelStatue\": 0, \"commodityMap\": [{\"cid\": 21, \"cpic\": \"/pic/i-寄养豪华单间.jpg\", \"cname\": \"犬猫寄养一月豪华单间\", \"cprice\": 1388.0, \"cdetail\": \"•适用宠物：≥6个月犬猫\\n•适用体重：无限制\\n•适用毛长：无限制\\n•包含项目：宠物寄养、日常饮食\", \"csalenum\": 3, \"ccategory\": \"4\"}, {\"cid\": 12, \"cpic\": \"/pic/i-小型犬洗澡.jpg\", \"cname\": \"小型犬洗澡\", \"cprice\": 29.9, \"cdetail\": \"•适用宠物：狗狗\\n•适用体重：1-10kg\\n•适用毛长：无限制\\n•包含项目：洗浴清洁、吹风拉毛\", \"csalenum\": 37, \"ccategory\": \"3\"}, {\"cid\": 15, \"cpic\": \"/pic/i-犬猫毛发修剪.jpg\", \"cname\": \"犬猫毛发修剪\", \"cprice\": 148.0, \"cdetail\": \"•适用宠物：猫咪、狗狗\\n•适用体重：无限制\\n•适用毛长：无限制\\n•包含项目：毛发修剪、全身洗护\", \"csalenum\": 29, \"ccategory\": \"3\"}, {\"cid\": 37, \"cpic\": \"/pic/j-青梅柠檬茶.jpg\", \"cname\": \"青梅柠檬茶\", \"cprice\": 15.9, \"cdetail\": \"柠檬、青梅、700毫升\", \"csalenum\": 17, \"ccategory\": \"2\"}, {\"cid\": 38, \"cpic\": \"/pic/j-多肉葡萄.jpg\", \"cname\": \"多肉葡萄\", \"cprice\": 14.9, \"cdetail\": \"葡萄、700毫升\", \"csalenum\": 93, \"ccategory\": \"2\"}, {\"cid\": 39, \"cpic\": \"/pic/j-大柠绿.jpg\", \"cname\": \"大柠绿\", \"cprice\": 15.9, \"cdetail\": \"绿茶、柠檬、500毫升\", \"csalenum\": 7, \"ccategory\": \"2\"}, {\"cid\": 36, \"cpic\": \"/pic/j-快乐柠檬水.jpg\", \"cname\": \"快乐柠檬水\", \"cprice\": 9.9, \"cdetail\": \"柠檬、1000毫升\", \"csalenum\": 35, \"ccategory\": \"2\"}], \"finishStatue\": 0}');

SET FOREIGN_KEY_CHECKS = 1;












