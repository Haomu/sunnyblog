package pers.sunny.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 相册数据表
 * </p>
 *
 * @author Sunny
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Picture implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 图片地址
     */
    private String pictureaddress;

    /**
     * 图片描述
     */
    private String picturedescription;

    /**
     * 图片名
     */
    private String picturename;

    /**
     * 图片时间
     */
    private String picturetime;

    /**
     * 逻辑删除
     */
    private Integer deleted;
}
