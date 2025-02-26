package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品浏览接口")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId) {
        // 查询Redis中是否有菜品数据
        List<DishVO> dishVOList = (List<DishVO>) redisTemplate.opsForValue().get("dish_" + categoryId);
        // 如果有，直接返回
        if (dishVOList != null && dishVOList.size() > 0) {
            return Result.success(dishVOList);
        }
        log.info("菜品数据不存在，查询数据库");
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);//查询起售中的菜品
        // 如果没有，查询数据库，将查询到的菜品数据缓存到Redis中，然后返回。
        dishVOList = dishService.listWithFlavor(dish);
        redisTemplate.opsForValue().set("dish_" + categoryId, dishVOList);
        return Result.success(dishVOList);
    }

}
