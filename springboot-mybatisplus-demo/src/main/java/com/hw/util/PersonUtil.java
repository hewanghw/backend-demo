package com.hw.util;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 该类作用 中文工具类
 *
 * @author IT_CREATE
 * @date 2023401 18:28:21
 */
public class PersonUtil {
    /**
     * 百家姓
     */
    public static final String[] CHINESE_FAMILY_NAMES = ("赵,钱,孙,李,周,吴,郑,王," + "冯,陈,褚,卫,蒋,沈,韩,杨," + "朱,秦,尤,许,何,吕,施,张," +
            "孔,曹,严,华,金,魏,陶,姜," + "戚,谢,邹,喻,柏,水,章," + "云,苏,潘,葛,奚,范,彭," + "鲁,韦,昌,马,苗,凤,花,方," + "俞,任,袁,柳,酆,鲍,史,唐").split(",");

    /**
     * 常用名
     */
    public static final String[] COMMON_NAMES = ("微,庚,殷,德,鹰,宫,娠,倾,侮,颁,豆,逾,袋,收,仰,懂," +
            "江,舅,庭,囊,捏,缘,愧,拉,览,渔,襄,佰,嫁,情,导,字,堵,待,拖,秒,校," +
            "贷,逮,项,埋,案,万,袜,勇,蛋,洼,像,摘,压,秋,筹,乡,丫,匠,捷,袁,鞍,淋,掉,猩,港,月,捌,典,摊,啼,缚,晦,卸,行," +
            "诺,凝,珐,醉,歼,葬,择,迭,钳,抠,夫,郑,卵,痔,稍,朝,锥,无,翠,奥,倪,夸,唱,骑,蒂,忠,唐,遗,锭,讶,助,廓,哪,悍," +
            "塔,彤,爽,棕,售,撼,陇,辆,绪,抑,肠,找,零,播,标,柔,套,箩,雍,吓,沟,迪,类,玲,鸳,鸿,棒,郴,哺,出,锈,愈,赛,乱," +
            "筛,乎,撑,拙,尤,鄙,胸,害,并,总,带,椭,昨,裕,抽,巩,疆,婉,边,擞,男,励,栏,坑,梆,抚,耿,俩,暂,那,何,鲸,插,攻," +
            "痴,癌,鉴,汛,扛,帝,狗,烁,什,悠,樟,棉,蓉,鸯,撮,宏,郧,跺,奏,锤,尽,鼠,晓,永,跑,佑,血,再,杨,萄,厚,庐,溺,咐," +
            "薛,只,武,勒,犊,伟,针,宅,镣,厨,韶,砸,握,浪,虚,咸,柄,敖,初,紧,贮,侈,枯,倘,畔,坤,洲,故,淆,听,姿,饭,狮,苦," +
            "蹄,缺,灿,她,拾,仗,虏,暇,疙,加,捐,现,跋,徒,军,叮,抬,熬,裙,殊,陈,剂,烂,镀,连,拼,纸,碟,秉,贰,第,虹,仇,钮," +
            "浅,工,抱,检,屯,质,平,逸,翁,炔,瘁,蚁,谗,梯,蹿,咙,贸,酱,吐,澎,正,汰,代,幅,铸,淡,至,净,咽,吟,狱,栖,荤,的," +
            "底,头,逗,釜,最,想,驾,僵,喂,奇,鳃,札,赖,葱,碘,淳,渺,厘,眶,泉,望,型,铝,半,舆,绣,叭,科,暖,嗅,绷,腊,抒,矗," +
            "痘,利,埠,膳,熟,拈,吹,俏,笼,角,胆,契,蹋,希,掷,溢,迸,鸭,历,误,渐,务,溶,柞,信,疵,册,粉,笆,乙,瘤,忧,师,党," +
            "梦,蕉,汀,态,拔,睡,膜,艰,乔,沉,聂,心,伸,踢,火,傣,给,悉,墟,腔,饲,衫,氖,湘,惦,茧,罐,三,坏,瞻," +
            "扇,奸,醋,说,捞,扶,时,逛,汉,隐,艇,川,锯,祟,份,做,走,享,员,这,褐,驴,荣,亡,擎,涯,常,钥,查,挛,逞,饺,断,势," +
            "滚,骡,烫,亏,躬,蝶,群,篮,盏,喻,臆,验,缄,笋,位,盾,饯,渡,哥,餐,袖,绅,啊,哟,丈,拣,粕,茵,湍,邓,脚,郁,研,厕," +
            "舍,凹,版,戈,颐,棍,象,烈,眷,铅,惭,雪,盔,憾,刀,博,产,闻,严,昆,密,落,额,轨,屿,蔷,域,盂,砍,苟,欧,绎,河,和," +
            "聪,俞,榴,甲,噬,燃,史,记,卧,蜕,俱,遏,减,坦,持,仕,派,涵,煞,裹,悬,轰,冻,喘,确,溯,炼,段,灶,肃,劣,馒,斌,撤," +
            "烤,谢,耽,肝,咒,炙,迟,淹,踏,哲,铜,荡,桶,妒,太,村,印,银,馆,拆,鸵,睫,捕,圈,烩,薯,异,儡,撞,旷,鸟,衍,米,堕," +
            "铣,贼,付,坠,汞,税,瑞,夜,些,匪,转,枣,沏,疤,涂,设,彭,蓟,哮,踪,竖,敞,吠,敷,膨,钩,刊,跨,濒,嘛,逐,儿,腹,部," +
            "法,辛,惜,苯,童,得,蒋,队,省,灾,缅,控,譬,芍,建,枷,征,形,摆,仅,欲,钟,锨,黎,拜,韩,破,奶,楚,帘,拄,码,奄,衙," +
            "抓,蹭,度,弹,止,耗,照,所,吮,拱,狭,旺,啦,杯,虐,燥,菏,曙,酥,瓣,酋,辊,畦,果,夷,汕,雌,湖,架,裳,齿,园,桥,盼," +
            "稻,蝉,碰,义,拨,粹,侦,捻,蒲,速,拥,纷,烧,揽,野,陀,造,忱,色,雕,青,堑,讫,哆,临,叹,大,烛,机,淮,双,增,您,袍," +
            "伺,琵,秘,顶,洗,柿,弥,淄,孽,顷,碴,勿,胳,邦,池,恬,皂,庞,居,席,斤,阮,赣,鲤,抗,展,铀,袱,嗣,私,移,梨,萍,膛," +
            "近,组,靠,揩,狈,窥,掣,辩,灸,埂,骂,偶,帮,对,凭,流,景,娄,很,腮,瓢,滨,棚,滓,褥,槽,怎,狼,帐,陵,壮,模,娃,颓," +
            "仆,础,羚,酚,匡,壬,柒,根,存,蝎,搏,觉,戮,嵌,蛀,登,输,钞,谜,龚,栅,左,矣,旅,显,脓,怨,萤,堪,疼,莱,绩,识,贺," +
            "靛,慰,扦,淫,名,迂,肢,予,诚,汤,牙,埃,辉,曰,醚,茸,训,稚,饵,倦,扭,殉,锑,泣,劲,沃,鼎,磊,莹,菜,贾,抉,憎,浸," +
            "跃,泳,硅,内,伦,杉,梧,蘑,疑,乏,是,阶,奋,锦,攘,业,枝,哀,侥,坞,鞭,霓,人,甄,诡,钦,冗,址,归,刁,漂,苗,拴,攀," +
            "碑,某,盆,掌,甜,饶,合,吸,染,距,能,好,族,嘴,聘,煽,二,感,寅,侍,瑟,耶,舜,耻,笔,柬,卡,社,摧,礼,矿,爵,闷,慕," +
            "圆,贞,寄,沪,荚,炭,屁,誉,堰,粘,腰,牡,孜,蓬,恶,浆,接,试,橱,描,蟹,篱,铃,窄,过,栗,精,真,吾,郊,瓮,桩,酒,挂," +
            "央,椽,锁,蛇,折,盛,躲,颠,荆,疥,窖,魁,瘩,咕,翻,讣,筐,径,宋,闪,均,萨,颅,爆,楔,携,讹,进,丹,叉,毅,徐,沫,悼," +
            "暗,惠,削,告,潦,夺,仿,沈,趾,腻,娱,号,盗,哩,非,婿,邻,谷,穿,睛,殴,卓,判,瓜,脆,阵,杖,辨,回,拧,伴,慨,捉,编," +
            "致,办,赎,欠,仍,烘,靶,瞧,强,否,罚,怯,孔,神,碱,桑,司,亥,旦,诉,旧,卿,逝,颜,馁,割,羹,又,闹,邢,矾,洽,疯,蜡," +
            "肤,烙,游,螺,种,乳,辰,奢,亭,逃,尝,瑚,衬,币,兔,房,漓,啄,祷,锌,定,看,椎,岛,恩,彪,棠,缴,谰,前,辐,臂,泛,支," +
            "疡,避,莆,纬,侧,难,杀,搀,浓,泄,欺,降,地,剧,析,赞,届,陕,右,诊,辈,颗,奎,窗,矽,鸥,颂,顽,诸,枢,油,点,椰,华," +
            "谨,会,亩,刃,瞬,侯,谊,琅,骗,身,碍,凌,茬,茁,涅,逻,屎,极,究,汾,绥,滑,潜,盯,翌,西,篷,拒,林,星,农,鲁,芳,学," +
            "揪,锋,溉,苔,漾,姨,纠,阿,肉,鹿,苏,吨,赢,溅,联,苞,刹,耐,檄,菩,品,蛰,必,芹,霜,傲,挽,龄,它,般,梅,瘪,搬,余," +
            "船,擒,协,峭,徘,仓,录,领,读,扯,掖,摄,馏,吗,藕,送,删,森,腆,盒,蚜,穗,兼,穆,屡,若,狂,尼,国,寡,贩,拿,梳,垣," +
            "喧,哭,辕,厉,跳,辅,昔,辗,婚,选,疾,乍,赁,慎,乘,理,硒,阎,崇,滤,因,胖,紫,颊,蘸,歪,蛊,逊,垫,叛,瑶,渭,浇,喀," +
            "冷,臻,妮,湃,锡,慑,隋,恐,演,哑,焚,擦,重,市,醒,惕,抛,帅,爱,栽,菠,天,特,练,蛆,还,击,吏,侠,囤,隆,磷,栓,痞," +
            "寞,恫,扔,由,氨,岗,懈,惨,腑,有,批,善,脸,埔,丽,毯,斗,臣,蚌,须,几,为,劫,智,滔,葫,褂,全,岁,蚂,蹲,榷,氦,凋," +
            "升,妨,制,擂,谍,廖,沛,胡,茅,咱,矮,悄,趁,尉,卤,停,钎,诅,寓,鞋,斜,菇,呕,踩,旱,喳,烬,朋,姆,决,勾,辙,订,扮," +
            "耍,掏,渠,核,崔,嘲,掇,序,驶,力,践,山,兰,意,芒,填,技,中,帖,窑,仔,挣,资,截,乓,蕊,扩,粗,谣,巍,称,钻,捎,艳," +
            "礁,腾,琉,纳,莎,载,铁,活,板,湿,梢,陡,舌,摔,屏,筒,舒,恼,泌,黔,译,驳,事,隔,卷,渊,构,奉,悟,锻,叔,秸,将,陨," +
            "疗,糠,布,准,崭,束,赤,雄,料,祈,城,狄,豺,邮,虑,禁,秧,长,卜,东,场,卢,挠,从,韭,略,陷,赵,巢,纶,抖,涛,郝,辜," +
            "体,壳,壁,硫,柴,吉,坪,除,坍,嫉,糜,巡,缔,驱,马,低,卯,砰,惟,瞄,孝,祥,彩,肾,岸,褪,蜗,晚,蝇,偷,绘,嚣,馈,纲," +
            "尺,匈,话,蓄,碱,苇,陆,皮,蠕,亚,诧,宇,羊,清,胚,巨,叙,剿,题,上,通,患,砌,篓,吝,垄,吕,崩,孕,肪,票,援,扑,诌," +
            "辞,朱,鄂,扁,嫡,淀,墓,扣,海,硬,苫,乾,沤,思,墒,桓,廉,甸,网,原,咆,漏,嘉,奈,幂,晨,砷,亮,嚼,荫,爹,掳,牟,贫," +
            "费,泥,褒,妓,塞,甥,稼,雨,小,衷,乌,骸,戍,都,潮,弦,盎,誓,使,汐,符,术,驹,膏,瞅,坟,斧,值,芥,噶,了,怖,猫,殆," +
            "蒜,袒,养,鹏,贯,宝,罪,喝,越,逆,痉,泅,咎,八,敝,死,滦,划,僚,葵,狰,尔,侩,宿,吭,汹,署,抡,公,间,秃,橙,渤,丸," +
            "恿,岭,辫,轩,奔,申,吧,茎,撩,诬,烽,块,艾,觅,雏,赡,我,张,款,置,枫,庆,械,龟,议,舀,沧,仪,泽,佐,谆,样,凳,退," +
            "宰,遭,麦,沼,灯,汗,潍,笺,莉,挺,相,彻,堆,柜,呜,静,件,蚤,娟,宣,烯,恳,芋,鸽,错,宛,砾,缎,洪,匹,煤,竿,纽,耸," +
            "剪,瞩,佯,注,与,搁,缮,酮,迅,换,勉,泞,丰,细,叼,阔,介,姓,毋,里,么,跪,弘,贬,君,沦,泪,页,千,珍,似,铱,招,倒," +
            "铺,嫌,婆,忙,滥,早,危,轧,勘,护,娩,挞,幢,炯,沸,触,雀,厦,亦,孙,传,曹,梗,瓷,格,氢,掸,迹,撰,澄,孰,瓶,弛,官," +
            "寨,围,络,温,旁,秽,帚,萝,数,甭,沥,晒,化,芽,罕,绿,嘻,僳,抄,轿,镊,雹,钵,休,诀,欣,医,素,佣,例,允,固,孤,装," +
            "氮,屈,虫,榨,痹,邯,弗,驼,犀,绕,纹,材,缆,魏,杜,臀,樊,讼,俐,示,邵,寥,罗,雷,寐,暴,缉,惑,昭,呆,勤,郡,朴,榆," +
            "函,宴,眺,靡,嚎,够,粟,朔,疚,晌,霖,纤,痊,蛮,辟,瘸,闭,圭,循,愉,奖,焉,向,涌,涩,尘,于,凉,棺,阴,怪,曝,丢,车," +
            "仲,媳,呈,吻,尿,酿,轮,隅,未,本,孵,靴,爷,砧,帧,鱼,喇,苛,举,镶,防,蛹,僧,仙,劈,阁,古,伎,柠,库,混,南,轻,虎," +
            "书,愚,沿,狡,舷,珠,拽,胜,绍,獭,托,煎,醛,怕,浊,易,葛,负,碳,黑,墙,酬,裴,床,挚,含,新,铲,剖,软,尧,氛,嚷,戊," +
            "老,益,秩,眯,推,共,啡,麓,切,睁,努,虽,涨,哇,炊,翰,聋,谚,姚,燎,猛,堡,霄,泼,腋,铬,谐,乃,琶,卖,枕,毖,蝴,音," +
            "统,飞,肿,僻,尾,昏,浙,妙,锰,金,镐,薪,篇,脖,吞,顺,牲,缠,阳,胞,怀,檀,嘱,散,踊,曲,此,级,迁,爸,站,朽,蛙,挪," +
            "邹,韧,搽,犬,就,傍,愿,浩,骇,磅,榜,措,突,指,性,念,衣,毁,舟,辑,陌,营,泵,甩,球,颤,闸,巾,侨,个,佛,亲,湾,雅," +
            "弱,副,弃,斡,宗,番,泊,伶,咀,胺,脏,昼,履,讨,墩,胁,戚,运,轴,供,挥,峻,各,嗓,撬,胯,醇,辽,妊,颧,靳,蹬,纪,衔," +
            "系,债,在,涕,潘,少,铂,守,杰,娇,缓,亢,迢,索,槐,垮,屋,饿,祝,趣,劳,贝,雇,箔,酶,捆,委,搓,惮,俺,稀,频,磨,丝," +
            "日,帜,赏,别,媒,骄,斥,韵,遂,丁,抢,籽,草,刺,分,蓑,兵,变,宁,忌,复,巧,柱,唾,溃,革,配,衅,今,芭,伍,贴,绵,萎," +
            "链,绽,辣,眩,疮,快,买,骨,州,猴,敲,厌,掺,赦,姬,娥,召,次,蔡,属,隧,氓,影,狞,催,涝,足,妆,墅,毕,锅,悔,螟,纂," +
            "彝,惰,鬃,狠,企,辱,冰,怂,多,液,垒,瓦,遵,茂,敌,雁,画,惊,离,庇,砖,丘,钒,铡,优,巳,曾,啸,台,趟,稗,糟,价,咖," +
            "来,竹,汇,寇,写,璃,咯,樱,匙,贡,苑,佩,犁,耘,氏,诱,圾,惹,竟,莲,臼,玄,捶,匣,锚,丛,问,剁,斩,铭,垛,喜,改,翔," +
            "钙,屉,峙,凸,之,爬,乐,宜,砂,福,桂,险,节,用,缝,框,嘿,簇,母,丙,咨,六,磐,焊,崖,董,抨,薄,令,嗽,坡,嫩,睦,袭," +
            "呐,延,购,娘,服,墨,蒙,晾,癸,陛,忻,探,众,偏,桐,酷,峪,刨,账,洁,怒,龋,入,釉,饼,揭,计,痰,嚏,赋,炽,季,沽,钉," +
            "嫂,融,膘,熙,佃,吱,整,条,尖,弯,粤,魔,培,任,撇,黍,去,返,也,绰,涎,你,屠,枉,钨,县,芯,堤,喉,摈,兄,赴,途,拎," +
            "梦琪,琪忆,忆柳,柳之,之桃,桃慕,慕青,青问,问兰,兰尔,尔岚,岚元,元香,香初,初夏,夏沛,沛菡,菡傲,傲珊,珊曼,曼文,文乐," +
            "乐菱,菱痴,痴珊,珊晓,晓绿,绿以,以菱,菱冬,冬云,云含,含玉,玉访,访枫,枫访,访云,云翠,翠容,容寒,寒凡,凡笑,笑珊,珊恨," +
            "恨玉,玉惜,惜文,文香,香寒,寒新,新柔,柔语,语蓉,蓉海,海安,安夜,夜蓉,蓉涵,涵柏,柏水,水桃,桃醉,醉蓝,蓝春,春儿,儿语," +
            "语琴,琴从,从彤,彤傲,傲晴,晴语,语兰,兰又,又菱,菱碧,碧彤,彤元,元霜,霜怜,怜梦,梦紫,紫寒,寒妙,妙彤,彤寒,寒珊,曼易," +
            "易南,南莲,莲紫,紫翠,翠雨,雨寒,寒易,易烟,烟如,如萱,萱若,若南,南寻,寻真,真晓,晓亦,亦向,向珊,珊慕,慕灵,灵以,以蕊," +
            "蕊寻,寻雁,雁映,映易,易雪,雪柳,柳孤,孤岚,岚笑,笑霜,霜海,海云,云凝,凝天,天沛,沛珊,珊寒,寒云,云谷,谷南,南冰,冰旋," +
            "旋宛,宛儿,儿绿,绿真,真盼,盼儿,儿晓,晓霜,霜碧,碧凡,凡夏,夏菡,菡曼,曼香,香若,若烟,烟半,半梦,梦雅,雅绿,绿冰,冰蓝," +
            "蓝灵,灵槐,槐平,平安,安书,书翠,翠翠,翠风,风香,香巧,巧代,代云,云梦,梦曼,曼幼,幼翠,翠友,友巧,巧慕,慕儿,儿听,听寒," +
            "寒梦,梦柏,柏醉,醉易,易访,访旋,旋亦,亦玉,玉凌,凌萱,萱访,访卉,卉怀,怀亦,亦笑,笑蓝,春翠,翠靖,靖柏,柏夜,夜蕾,蕾冰," +
            "冰夏,夏梦,梦松,松书,书雪,雪乐,乐枫,枫念,念薇,薇靖,靖雁,雁寻,寻春,春恨,恨山,山从,从寒,寒夏,夏岚,岚忆,忆香,香觅," +
            "觅波,波静,静曼,曼凡,凡旋,旋以,以亦,亦念,念露,露芷,芷蕾,蕾千,千兰,兰新,新波,波代,代真,真新,新蕾,蕾雁,雁玉,玉冷," +
            "冷卉,卉紫,紫山,山千,千琴,琴恨,恨天,天傲,傲芙,芙盼,盼山,山怀,怀蝶,蝶冰,冰兰,兰山,山柏,柏友,友儿,儿翠,翠萱,萱恨," +
            "恨松,松问,问旋,旋从,从南,南白,白易,易问,问筠,筠如,如霜,霜半,半芹,芹丹,丹珍,珍冰,冰彤,彤亦,亦寒,寒寒,寒雁,雁怜," +
            "怜云,云寻,寻文,乐丹,丹翠,翠柔,柔谷,谷山,山之,之瑶,瑶冰,冰露,露尔,尔珍,珍谷,谷雪,雪小,小萱,萱乐,乐萱,萱涵,涵菡," +
            "菡海,海莲,莲傲,傲蕾,蕾青,青槐,槐冬,冬儿,儿易,易梦,梦惜,惜雪,雪宛,宛海,海之,之柔,柔夏,夏青,青亦,亦瑶,瑶妙,妙菡," )
            .split(",");


    public static String[] GENDER = {"男", "女"};
    public static Map<String, String> JIGUAN = new HashMap<String, String>()
    {{
        put("37", "山东");
        put("13", "河北");
        put("11", "北京");
        put("41", "河南");
        put("31", "上海");
        put("32", "江苏");
        put("22", "吉林");
    }};
    public static String[] XUEXING = {"A","B","AB","O"};
    public static String[] HUNYIN = {"未婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚","已婚"};
    public static String[] MIANMAO = {"中共党员","无党派人士","群众","九三学社社员","中共党员","中共党员","中共党员"};
    public static String[] XUEWEI = {"学士", "硕士","博士","硕士","硕士","硕士","硕士","博士","博士"};

    /**
     * 随机生成指定姓氏中文姓名
     * @param familyName 指定姓氏
     * @return 中文姓名
     */
    public static String randomChineseName(String familyName) {
        String commonName = randomCommonName();
        // 生成的名字最少两个字,最多四个字
        String chineseName = familyName + commonName;
        int length2 = 2;
        int length3 = 3;
        int length4 = 4;
        // 随机生成名字的限制长度
        int randomLimit = randomNumber(2, 4);
        // 排除复姓，复姓名字最少都有三个字
        if (familyName.length() != length2 && randomLimit == length2) {
            return chineseName.length() > length2 ? chineseName.substring(0, length2) : chineseName;
        } else if (randomLimit == length3) {
            // 三个字(可以是单姓和复姓)
            if (chineseName.length() < length3) {
                chineseName = chineseName + randomCommonName();
            }
            return chineseName.length() > length3 ? chineseName.substring(0, length3) : chineseName;
        } else if (familyName.length() == length2 && randomLimit == length4) {
            // 四个字(只取复姓，单姓氏很少四个字，这里忽略)，要想实现单姓氏组合四个字，请将传入的姓氏写成两个字即可
            if (chineseName.length() < length4) {
                chineseName = chineseName + randomCommonName() + randomCommonName();
            }
            return chineseName.length() > length4 ? chineseName.substring(0, length4) : chineseName;
        }
        return chineseName;
    }

    /**
     * 随机生成中文姓名
     *
     * @return 中文姓名
     */
    public static String randomChineseName() {
        String familyName = randomCreateFamilyName();
        return randomChineseName(familyName);
    }

    /**
     * 随机生成姓氏
     *
     * @return 姓氏
     */
    public static String randomCreateFamilyName() {
        int length = CHINESE_FAMILY_NAMES.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? CHINESE_FAMILY_NAMES[0] : CHINESE_FAMILY_NAMES[index];
    }

    /**
     * 随机生成名字
     *
     * @return 名字
     */
    public static String randomCommonName() {
        int length = COMMON_NAMES.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? COMMON_NAMES[0] : COMMON_NAMES[index];
    }

    /**
     * 随机创建一个汉字
     *
     * @return 汉字
     */
    public static String randomCreateChinese() {
        /*中文范围取值*/
        int chinese = randomNumber(0x4E00, 0x9FA5);
        return String.valueOf((char) (chinese + '0'));
    }

    /**
     * 随机生成性别
     * @return 性别
     */
    public static String randomGender(){
        int length = GENDER.length;
        int index = randomNumber(0, length - 1 );
        return index < 0 || index >= length ? GENDER[0] : GENDER[index];
    }

    public static String randomMobile(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append(random.nextInt(7) + 3); // 3-9
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // 随机生成地区编码
    public static String randomRegionCode(String jiguan) {
        Random random = new Random();
        int regionCode = random.nextInt(10000);
        return jiguan + String.format("%04d", regionCode);
    }

    // 随机生成出生年月日
    public static String randomBirthDate() {
        Random random = new Random();
        int year = random.nextInt(100) + 1900;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        return String.format("%04d%02d%02d", year, month, day);
    }

    // 随机生成顺序码
    public static String randomSequenceCode() {
        Random random = new Random();
        int sequenceCode = random.nextInt(100);
        return String.format("%02d", sequenceCode);
    }

    // 计算校验码
    public static char calculateCheckCode(String id) {
        String[] checkCodes = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] factors = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            sum += Integer.parseInt(String.valueOf(id.charAt(i))) * factors[i];
        }
        int index = sum % 11;
        return checkCodes[index].charAt(0);
    }

    public static String randomJiguan(){
        Set<String> keySet = JIGUAN.keySet();
        String[] strings = keySet.toArray(new String[0]);
        int length = strings.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? strings[0] : strings[index];
    }

    /**
     * 随机生成身份证号
     * @param jiguan
     * @return
     */
    public static String randomID(String jiguan) {
        String regionCode = randomRegionCode(jiguan);
        String birthDate = randomBirthDate();
        String sequenceCode = randomSequenceCode();
        String id = regionCode + birthDate + sequenceCode;
        char checkCode = calculateCheckCode(id);
        return id + checkCode;
    }

    /**
     * 随机生成婚姻状况
     * @return
     */
    public static String randomHunyin(){
        int length = HUNYIN.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? HUNYIN[0] : HUNYIN[index];
    }

    /**
     * 随机生成血型
     * @return
     */
    public static String randomXueXing(){
        int length = XUEXING.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? XUEXING[0] : XUEXING[index];
    }

    /**
     * 随机生成政治面貌
     * @return
     */
    public static String randowMianmao(){
        int length = MIANMAO.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? MIANMAO[0] : MIANMAO[index];
    }

    /**
     * 随机生成指定范围数字
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机值
     */
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String randomXueWei(){
        int length = XUEWEI.length;
        int index = randomNumber(0, length - 1);
        return index < 0 || index >= length ? XUEWEI[0] : XUEWEI[index];
    }



}