package cn.hollis.nft.turbo.api.goods.service;

import cn.hollis.nft.turbo.api.goods.constant.GoodsEvent;
import cn.hollis.nft.turbo.api.goods.constant.GoodsType;
import cn.hollis.nft.turbo.api.goods.model.BaseGoodsVO;
import cn.hollis.nft.turbo.api.goods.model.GoodsStreamVO;
import cn.hollis.nft.turbo.api.goods.request.GoodsBookRequest;
import cn.hollis.nft.turbo.api.goods.request.GoodsSaleRequest;
import cn.hollis.nft.turbo.api.goods.response.GoodsBookResponse;
import cn.hollis.nft.turbo.api.goods.response.GoodsSaleResponse;

import java.util.List;

/**
 * 商品服务
 *
 * @author hollis
 */
public interface GoodsFacadeService {

    /**
     * 获取商品
     *
     * @param goodsId
     * @param goodsType
     * @return
     */
    public BaseGoodsVO getGoods(String goodsId, GoodsType goodsType);

    /**
     * 获取商品流水
     *
     * @param goodsId
     * @param goodsType
     * @param goodsEvent
     * @param identifier
     * @return
     */
    public GoodsStreamVO getGoodsInventoryStream(String goodsId, GoodsType goodsType, GoodsEvent goodsEvent, String identifier);

    /**
     * 藏品出售的try阶段，做库存占用
     *
     * @param request
     * @return
     */
    public GoodsSaleResponse sale(GoodsSaleRequest request);

    /**
     * 藏品出售的try阶段，做库存占用-无hint
     *
     * @param request
     * @return
     */
    public GoodsSaleResponse saleWithoutHint(GoodsSaleRequest request);

    /**
     * 藏品出售的confirm阶段，做真正售出
     *
     * @param request
     * @return
     * @deprecated 废弃，这个方法之前是依赖数据库做的藏品的序号的生成，但是这里存在并发问题。
     * 当然也可以基于乐观锁/悲观锁的方式解决，但是会影响吞吐量，所以改用其他方式实现
     */
    @Deprecated
    public GoodsSaleResponse confirmSale(GoodsSaleRequest request);

    /**
     * 支付成功
     *
     * @param request
     * @return
     */
    GoodsSaleResponse paySuccess(GoodsSaleRequest request);

    /**
     * 藏品出售的cancel阶段，做库存退还
     *
     * @param request
     * @return
     */
    public GoodsSaleResponse cancelSale(GoodsSaleRequest request);

    /**
     * 商品预约
     *
     * @param request
     * @return
     */
    public GoodsBookResponse book(GoodsBookRequest request);

    /**
     * 查询是否预约过
     *
     * @param goodsId
     * @param goodsType
     * @param buyerId
     * @return
     */
    public Boolean isGoodsBooked(String goodsId, GoodsType goodsType, String buyerId);

    /**
     * 添加热门商品
     *
     * @param goodsId
     * @param goodsType
     * @return
     */
    public Boolean addHotGoods(String goodsId, String goodsType);

    /**
     * 是否是热门商品
     *
     * @param goodsId
     * @param goodsType
     * @return
     */
    public Boolean isHotGoods(String goodsId, String goodsType);


    /**
     * 获取热门商品id列表
     *
     * @param goodsType
     * @return
     */
    public List<String> getHotGoods(String goodsType);
}
