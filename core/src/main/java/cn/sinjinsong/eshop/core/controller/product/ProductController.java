package cn.sinjinsong.eshop.core.controller.product;

import cn.sinjinsong.eshop.common.exception.RestValidationException;
import cn.sinjinsong.eshop.core.domain.entity.product.ProductCategoryDO;
import cn.sinjinsong.eshop.core.domain.entity.product.ProductDO;
import cn.sinjinsong.eshop.core.properties.PageProperties;
import cn.sinjinsong.eshop.core.service.product.ProductService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@RestController
@RequestMapping("/products")
@Slf4j
@Api(value = "products", description = "产品API")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "按id查询产品类别", response = ProductCategoryDO.class, authorizations = {@Authorization("登录")})
    public ProductCategoryDO findCategoryById(@PathVariable("id") @ApiParam(value = "产品类别id", required = true) Long categoryId) {
        return productService.findCategoryById(categoryId);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有产品类别", response = ProductCategoryDO.class)
    public List<ProductCategoryDO> findAllCategories() {
        return productService.findAllCategories();
    }

    @RequestMapping(value = "/by_category/{categoryId}", method = RequestMethod.GET)
    @ApiOperation(value = "按产品类别分页查询产品", response = ProductDO.class)
    public PageInfo<ProductDO> findProductByCategory(@PathVariable("categoryId") Long categoryId,
                                                     @RequestParam(value = "pageNum", required = false, defaultValue = PageProperties.DEFAULT_PAGE_NUM)
                                                     @ApiParam(value = "页码", required = false, defaultValue = PageProperties.DEFAULT_PAGE_NUM)
                                                             Integer pageNum,
                                                     @RequestParam(value = "pageSize", required = false, defaultValue = PageProperties.DEFAULT_PAGE_SIZE)
                                                     @ApiParam(value = "页的大小", required = false, defaultValue = PageProperties.DEFAULT_PAGE_SIZE)
                                                             Integer pageSize) {
        return productService.findProductByCategory(categoryId, pageNum, pageSize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "按id查询产品", response = ProductDO.class)
    public ProductDO findProductById(@PathVariable("id") @ApiParam(value = "产品id", required = true) Long id) {
        return productService.findProductById(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增产品")
    @PreAuthorize("hasRole('ADMIN')")
    public void saveProduct(@RequestBody @Valid @ApiParam(value = "产品对象", required = true) ProductDO product, BindingResult result) {
        if (result.hasErrors()) {
            throw new RestValidationException(result.getFieldErrors());
        }
        productService.saveProduct(product);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改产品")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateProduct(@RequestBody @Valid @ApiParam(value = "产品对象", required = true) ProductDO product, BindingResult result) {
        if (result.hasErrors()) {
            throw new RestValidationException(result.getFieldErrors());
        }
        productService.updateProduct(product);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @ApiOperation(value = "保存产品类别")
    @PreAuthorize("hasRole('ADMIN')")
    public void saveCategory(@RequestParam("name") @ApiParam(value = "产品类别名字", required = true) String name) {
        productService.saveCategory(name);
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    @ApiOperation(value = "修改产品类别")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@RequestBody @Valid @ApiParam(value = "产品类别", required = true) ProductCategoryDO category, BindingResult result) {
        if (result.hasErrors()) {
            throw new RestValidationException(result.getFieldErrors());
        }
        productService.updateCategory(category);
    }
}
