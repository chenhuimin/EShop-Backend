package cn.sinjinsong.eshop.core.domain.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_category.id
     *
     * @mbggenerated
     */
    @NotNull
    private Long id;

    @NotNull
    private String name;
    private List<ProductDO> products;
    private String description;
    @JsonIgnore
    private Boolean isOnBoard;
    private String alias;
    
    public ProductCategoryDO(String name){
        this.name = name;
    }
}