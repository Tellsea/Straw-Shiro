package cn.tellsea.frame.dto.layuimini;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Tellsea
 * @date 2021/03/29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class HomeInfo {

    private String title;

    private String href;
}
