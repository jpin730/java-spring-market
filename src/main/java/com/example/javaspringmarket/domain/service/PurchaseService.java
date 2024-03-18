package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseListDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseUpdateDto;
import com.example.javaspringmarket.domain.repository.PurchaseRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepositoryInterface purchaseRepository;

    public List<PurchaseListDto> getAll() {
        return purchaseRepository.getAll();
    }

    public List<PurchaseListDto> getByCustomer(Integer customerId) {
        return purchaseRepository.getByCustomer(customerId);
    }

    public Optional<PurchaseDto> getById(Integer id) {
        return purchaseRepository.getById(id);
    }

    public PurchaseDto create(PurchaseCreateDto purchase) {
        return purchaseRepository.save(purchase);
    }

    public Boolean update(PurchaseUpdateDto purchase) {
        return getById(purchase.getId()).map(found -> {
            found.setPaid(purchase.getPaid());
            purchaseRepository.update(found);
            return true;
        }).orElse(false);
    }

    public Boolean delete(Integer id) {
        return getById(id).map(purchase -> {
            purchaseRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
