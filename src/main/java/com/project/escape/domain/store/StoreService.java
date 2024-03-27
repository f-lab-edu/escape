package com.project.escape.domain.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public List<StoreResponse> saveAllStoreData(List<StoreDto> request) {
        List<Store> storeList = request.stream().map(StoreDto::toEntity).toList();
        return storeRepository.saveAll(storeList)
                .stream()
                .map(StoreResponse::of)
                .toList();
    }
}
