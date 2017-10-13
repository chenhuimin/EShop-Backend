package cn.sinjinsong.eshop.core.dao.product;

import cn.sinjinsong.eshop.core.domain.entity.product.ProductCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    int insert(ProductCategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    int insertSelective(ProductCategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    ProductCategoryDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductCategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductCategoryDO record);
    List<ProductCategoryDO> findAll();
    List<ProductCategoryDO> findAllWithOutProducts();
    
    List<ProductCategoryDO> findOnBoard();
}