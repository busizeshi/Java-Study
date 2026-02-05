package cn.hollis.nft.turbo.api.collection.service;

import cn.hollis.nft.turbo.api.collection.request.*;
import cn.hollis.nft.turbo.api.collection.response.CollectionAirdropResponse;
import cn.hollis.nft.turbo.api.collection.response.CollectionChainResponse;
import cn.hollis.nft.turbo.api.collection.response.CollectionModifyResponse;
import cn.hollis.nft.turbo.api.collection.response.CollectionRemoveResponse;

/**
 * 藏品管理门面服务
 *
 * @author Hollis
 */
public interface CollectionManageFacadeService {

    /**
     * 创建藏品
     *
     * @param request
     * @return
     */
    public CollectionChainResponse create(CollectionCreateRequest request);


    /**
     * 藏品下架
     *
     * @param request
     * @return
     */
    public CollectionRemoveResponse remove(CollectionRemoveRequest request);

    /**
     * 空投
     *
     * @param request
     * @return
     */
    public CollectionAirdropResponse airDrop(CollectionAirDropRequest request);

    /**
     * 藏品库存修改
     *
     * @param request
     * @return
     */
    public CollectionModifyResponse modifyInventory(CollectionModifyInventoryRequest request);

    /**
     * 藏品价格修改
     *
     * @param request
     * @return
     */
    public CollectionModifyResponse modifyPrice(CollectionModifyPriceRequest request);
}
