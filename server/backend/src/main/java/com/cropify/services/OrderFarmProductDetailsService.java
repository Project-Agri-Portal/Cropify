package com.cropify.services;

public interface OrderFarmProductDetailsService {
    String addFarmProductToCart(Long farmerId, Double totalPrice);
}
