package com.example.javaspringmarket.domain.dto.category;

public class CategoryUpdateDto extends CategoryCreateDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
