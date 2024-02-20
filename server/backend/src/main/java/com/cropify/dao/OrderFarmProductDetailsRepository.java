package com.cropify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cropify.dto.OrderDTO;
import com.cropify.entity.OrderFarmProductDetails;
import com.cropify.entity.OrderMachineDetails;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmOrderStatus;

public interface OrderFarmProductDetailsRepository extends JpaRepository<OrderFarmProductDetails, Long> {

	@Query(value = "select count(distinct order_id) from order_farm_product_details", nativeQuery = true)
    public int findDistinctOrderIdForIdGeneration();

    @Query("SELECT o.oid, o.orderId, o.customerId, o.farmerId, o.farmProdId, o.orderDate, o.deliveryDate, " +
       "o.quantity, o.totalPrice, o.farmOrderStatus, f.farmProductId, f.farmProductName, f.farmProductType " +
       "FROM OrderFarmProductDetails o " +
       "JOIN o.farmProdId f " +
       "WHERE o.customerId.id = :customerId " +
       "AND o.farmOrderStatus = 'PLACED'")
        List<Object[]> findByCustomerIdAndStatus(@Param("customerId") Long customerId);

    @Query(value = "select * from order_farm_product_details where farmer_id=:farmerId", nativeQuery = true)
    public List<OrderFarmProductDetails> getByUserId(
    		@Param ("farmerId") Long farmerId
    		);	
    
    @Query("SELECT ofpd FROM OrderFarmProductDetails ofpd WHERE ofpd.farmerId = :farmerId")
    List<OrderFarmProductDetails> findAllByFarmerId(@Param("farmerId") UserDetails farmerId);
}

