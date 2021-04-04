package cn.tellsea.frame.dto.layuimini;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 复选框设计类
 *
 * @author Tellsea
 * @date 2021/04/01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CheckArr {
    /**
     * 复选框标记
     */
    private Integer type = 0;
    /**
     * 复选框是否选中
     */
    private Integer checked = 0;
}
