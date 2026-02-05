package cn.hollis.nft.turbo.api.inventory;

import cn.hollis.nft.turbo.api.inventory.request.InventoryRequest;

/**
 * 库存服务
 *
 * @author Hollis
 */
public interface InventoryTransactionFacadeService {

    /**
     * 库存扣减-try
     *
     * @param inventoryRequest
     * @return
     */
    public Boolean tryDecrease(InventoryRequest inventoryRequest);

    /**
     * 库存扣减-confirm
     *
     * @param inventoryRequest
     * @return
     */
    public Boolean confirmDecrease(InventoryRequest inventoryRequest);

    /**
     * 库存扣减-confirm
     *
     * @param inventoryRequest
     * @return
     */
    public Boolean cancelDecrease(InventoryRequest inventoryRequest);
}
