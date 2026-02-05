package cn.hollis.nft.turbo.api.inventory.service;

import cn.hollis.nft.turbo.api.inventory.request.InventoryRequest;
import cn.hollis.nft.turbo.base.response.MultiResponse;
import cn.hollis.nft.turbo.base.response.SingleResponse;

/**
 * 库存服务
 *
 * @author Hollis
 */
public interface InventoryFacadeService {

    /**
     * 库存初始化
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Boolean> init(InventoryRequest inventoryRequest);

    /**
     * 库存扣减
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Boolean> decrease(InventoryRequest inventoryRequest);

    /**
     * 库存增加
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Boolean> increase(InventoryRequest inventoryRequest);

    /**
     * 库存失效
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Void> invalid(InventoryRequest inventoryRequest);


    /**
     * 查询库存扣减流水
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<String> getInventoryDecreaseLog(InventoryRequest inventoryRequest);

    /**
     * 查询库存增加流水
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<String> getInventoryIncreaseLog(InventoryRequest inventoryRequest);

    /**
     * 批量查询库存流水
     * @param inventoryRequest
     * @return
     */
    public MultiResponse<String> getInventoryDecreaseLogs(InventoryRequest inventoryRequest);

    /**
     * 查询库存
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Integer> queryInventory(InventoryRequest inventoryRequest);

    /**
     * 移除流水
     *
     * @param inventoryRequest
     * @return
     */
    public SingleResponse<Long> removeInventoryDecreaseLog(InventoryRequest inventoryRequest);


}
