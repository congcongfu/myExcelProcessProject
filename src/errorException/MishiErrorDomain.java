package errorException;

/**
 * 错误码业务领域和范围枚举，列出目前主要的一级及部分二级业务领域，及其对应的错误码范围。二级业务域典型标准是模块代码有独立的一个库或者规模较大，未来可能独立库的package，一级是相对较大的业务域，未来可能会由多个独立项目组成。<br/>
 * 建议的错误码规划如下：<br/>
 * 1. 一级业务域：10000~19999<br/>
 * 2. 二级业务域：100~199<br/>
 * 
 */
public class MishiErrorDomain extends AbsErrorDomain {

    /**
     * 基础通用错误码，目前范围：0~9
     */
    public static final ErrorDomain COMMON      = new MishiErrorDomain("mishi", 0, 99);

    /**
     * API网关错误码,目前范围：100001~100023
     */
    public static final ErrorDomain API_GATEWAY = new MishiErrorDomain("mishi.api", 100001, 100099);

    /**
     * 公共业务组件错误码,目前范围：201001~220204
     */
    public static final ErrorDomain COMMON_BIZ  = new MishiErrorDomain("mishi.common.component", 200001, 229999);

    /**
     * 附件上次错误码，目前范围：601001~601003，需要整改
     */
    public static final ErrorDomain ATTACH      = new MishiErrorDomain("mishi.attach", 260001, 269999);

    /**
     * 会员业务线错误码,目前范围：301001~310102，需要整改
     */
    public static final ErrorDomain USER        = new MishiErrorDomain("mishi.user", 300001, 309999);

    /**
     * 搜索业务线错误码，目前范围：1001001~1001004，需要整改
     */
    public static final ErrorDomain SEARCH      = new MishiErrorDomain("mishi.search", 310001, 319999);

    /**
     * 店铺业务线错误码,目前范围：401001~440005 需要整改
     */
    public static final ErrorDomain SHOP        = new MishiErrorDomain("mishi.shop", 400001, 409999);

    /**
     * 美食商品业务线错误码,目前范围：500000~505023
     */
    public static final ErrorDomain GOODS       = new MishiErrorDomain("mishi.goods", 500000, 509999);

    /**
     * 优惠相关错误码，目前范围：1~1018，需要整改
     */
    public static final ErrorDomain BONUS       = new MishiErrorDomain("mishi.bonus", 600000, 609999);

    /**
     * 订单业务线错误码,目前范围：700001~704007
     */
    public static final ErrorDomain OREDR       = new MishiErrorDomain("mishi.order", 700001, 709999);

    /**
     * 资金业务线错误码，目前范围：800001~800506
     */
    public static final ErrorDomain FUND        = new MishiErrorDomain("mishi.fund", 800001, 809999);

    /**
     * 活动业务线错误码，目前范围：900001~900035
     */
    public static final ErrorDomain ACIVITY     = new MishiErrorDomain("mishi.activity", 900001, 909999);

    /**
     * 处罚纠纷错误码，目前范围：910001~910009
     */
    public static final ErrorDomain PUNISH      = new MishiErrorDomain("mishi.punish", 910001, 910099);

    /**
     * 物流业务错误码，目前范围：92001~92008，需要整改
     */
    public static final ErrorDomain LOGIS       = new MishiErrorDomain("mishi.logistics", 920001, 929999);

    /**
     * 风控错误码，目前范围：1100001,1100004，需要整改
     */
    public static final ErrorDomain RISK        = new MishiErrorDomain("mishi.risk", 930001, 930099);

    /**
     * 物料错误码，目前范围：420001,420019，需要整改
     */
    public static final ErrorDomain MATERIAL    = new MishiErrorDomain("mishi.material", 930101, 930199);

    /**
     * 一人宴错误码，目前范围：1210001~1210007
     */
    public static final ErrorDomain YRY         = new MishiErrorDomain("mishi.yry", 1000001, 1009999);

    public MishiErrorDomain(String domain, int codeRangeStart, int codeRangeEnd) {
        super(domain, codeRangeStart, codeRangeEnd);
    }

    @Override
    public ErrorDomain getParentDomain() {
        return null;
    }

}
